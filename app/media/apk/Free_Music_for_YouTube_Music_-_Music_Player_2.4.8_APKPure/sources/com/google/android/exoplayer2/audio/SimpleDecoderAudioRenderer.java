package com.google.android.exoplayer2.audio;

import android.media.PlaybackParams;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioTrack;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
/* loaded from: classes.dex */
public abstract class SimpleDecoderAudioRenderer extends BaseRenderer implements MediaClock {
    private boolean allowPositionDiscontinuity;
    private int audioSessionId;
    private final AudioTrack audioTrack;
    private boolean audioTrackHasData;
    private long currentPositionUs;
    private SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> decoder;
    private DecoderCounters decoderCounters;
    private final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private final FormatHolder formatHolder;
    private DecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long lastFeedElapsedRealtimeMs;
    private SimpleOutputBuffer outputBuffer;
    private boolean outputStreamEnded;

    protected abstract SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> createDecoder(Format format) throws AudioDecoderException;

    public SimpleDecoderAudioRenderer() {
        this(null, null);
    }

    public SimpleDecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener) {
        this(handler, audioRendererEventListener, null, 3);
    }

    public SimpleDecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, int i) {
        super(1);
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.audioSessionId = 0;
        this.audioTrack = new AudioTrack(audioCapabilities, i);
        this.formatHolder = new FormatHolder();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        if (!this.outputStreamEnded) {
            if (this.inputFormat != null || readFormat()) {
                if (this.decoder == null) {
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        TraceUtil.beginSection("createAudioDecoder");
                        this.decoder = createDecoder(this.inputFormat);
                        TraceUtil.endSection();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        this.eventDispatcher.decoderInitialized(this.decoder.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.decoderCounters.decoderInitCount++;
                    } catch (AudioDecoderException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                }
                try {
                    TraceUtil.beginSection("drainAndFeed");
                    do {
                    } while (drainOutputBuffer());
                    do {
                    } while (feedInputBuffer());
                    TraceUtil.endSection();
                    this.decoderCounters.ensureUpdated();
                } catch (AudioDecoderException | AudioTrack.InitializationException | AudioTrack.WriteException e2) {
                    throw ExoPlaybackException.createForRenderer(e2, getIndex());
                }
            }
        }
    }

    protected Format getOutputFormat() {
        return Format.createAudioSampleFormat(null, MimeTypes.AUDIO_RAW, null, -1, -1, this.inputFormat.channelCount, this.inputFormat.sampleRate, 2, null, null, 0, null);
    }

    private boolean drainOutputBuffer() throws AudioDecoderException, AudioTrack.InitializationException, AudioTrack.WriteException {
        if (this.outputStreamEnded) {
            return false;
        }
        if (this.outputBuffer == null) {
            this.outputBuffer = this.decoder.dequeueOutputBuffer();
            if (this.outputBuffer == null) {
                return false;
            }
            this.decoderCounters.skippedOutputBufferCount += this.outputBuffer.skippedOutputBufferCount;
        }
        if (this.outputBuffer.isEndOfStream()) {
            this.outputStreamEnded = true;
            this.audioTrack.handleEndOfStream();
            this.outputBuffer.release();
            this.outputBuffer = null;
            return false;
        }
        if (!this.audioTrack.isInitialized()) {
            Format outputFormat = getOutputFormat();
            this.audioTrack.configure(outputFormat.sampleMimeType, outputFormat.channelCount, outputFormat.sampleRate, outputFormat.pcmEncoding, 0);
            if (this.audioSessionId == 0) {
                this.audioSessionId = this.audioTrack.initialize(0);
                this.eventDispatcher.audioSessionId(this.audioSessionId);
                onAudioSessionId(this.audioSessionId);
            } else {
                this.audioTrack.initialize(this.audioSessionId);
            }
            this.audioTrackHasData = false;
            if (getState() == 2) {
                this.audioTrack.play();
            }
        } else {
            boolean z = this.audioTrackHasData;
            this.audioTrackHasData = this.audioTrack.hasPendingData();
            if (z && !this.audioTrackHasData && getState() == 2) {
                this.eventDispatcher.audioTrackUnderrun(this.audioTrack.getBufferSize(), C.usToMs(this.audioTrack.getBufferSizeUs()), SystemClock.elapsedRealtime() - this.lastFeedElapsedRealtimeMs);
            }
        }
        int handleBuffer = this.audioTrack.handleBuffer(this.outputBuffer.data, this.outputBuffer.timeUs);
        this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
        if ((handleBuffer & 1) != 0) {
            this.allowPositionDiscontinuity = true;
        }
        if ((handleBuffer & 2) != 0) {
            this.decoderCounters.renderedOutputBufferCount++;
            this.outputBuffer.release();
            this.outputBuffer = null;
            return true;
        }
        return false;
    }

    private boolean feedInputBuffer() throws AudioDecoderException {
        if (this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            this.inputBuffer = this.decoder.dequeueInputBuffer();
            if (this.inputBuffer == null) {
                return false;
            }
        }
        int readSource = readSource(this.formatHolder, this.inputBuffer);
        if (readSource != -3) {
            if (readSource == -5) {
                onInputFormatChanged(this.formatHolder.format);
                return true;
            } else if (this.inputBuffer.isEndOfStream()) {
                this.inputStreamEnded = true;
                this.decoder.queueInputBuffer((SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException>) this.inputBuffer);
                this.inputBuffer = null;
                return false;
            } else {
                this.inputBuffer.flip();
                this.decoder.queueInputBuffer((SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException>) this.inputBuffer);
                this.decoderCounters.inputBufferCount++;
                this.inputBuffer = null;
                return true;
            }
        }
        return false;
    }

    private void flushDecoder() {
        this.inputBuffer = null;
        if (this.outputBuffer != null) {
            this.outputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded && !this.audioTrack.hasPendingData();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.audioTrack.hasPendingData() || (this.inputFormat != null && (isSourceReady() || this.outputBuffer != null));
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        long currentPositionUs = this.audioTrack.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs = Math.max(this.currentPositionUs, currentPositionUs);
            }
            this.currentPositionUs = currentPositionUs;
            this.allowPositionDiscontinuity = false;
        }
        return this.currentPositionUs;
    }

    protected void onAudioSessionId(int i) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
        this.eventDispatcher.enabled(this.decoderCounters);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j, boolean z) {
        this.audioTrack.reset();
        this.currentPositionUs = j;
        this.allowPositionDiscontinuity = true;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.decoder != null) {
            flushDecoder();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        this.audioTrack.play();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.audioTrack.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.inputFormat = null;
        this.audioSessionId = 0;
        try {
            if (this.decoder != null) {
                this.decoder.release();
                this.decoder = null;
                this.decoderCounters.decoderReleaseCount++;
            }
            this.audioTrack.release();
        } finally {
            this.decoderCounters.ensureUpdated();
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    private boolean readFormat() {
        if (readSource(this.formatHolder, null) == -5) {
            onInputFormatChanged(this.formatHolder.format);
            return true;
        }
        return false;
    }

    private void onInputFormatChanged(Format format) {
        this.inputFormat = format;
        this.eventDispatcher.inputFormatChanged(format);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        switch (i) {
            case 2:
                this.audioTrack.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.audioTrack.setPlaybackParams((PlaybackParams) obj);
                return;
            default:
                super.handleMessage(i, obj);
                return;
        }
    }
}
