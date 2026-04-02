package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioTrack;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
@TargetApi(16)
/* loaded from: classes.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private boolean allowPositionDiscontinuity;
    private int audioSessionId;
    private final AudioTrack audioTrack;
    private boolean audioTrackHasData;
    private long currentPositionUs;
    private final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private long lastFeedElapsedRealtimeMs;
    private boolean passthroughEnabled;
    private MediaFormat passthroughMediaFormat;
    private int pcmEncoding;

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector) {
        this(mediaCodecSelector, (DrmSessionManager) null, true);
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, DrmSessionManager drmSessionManager, boolean z) {
        this(mediaCodecSelector, drmSessionManager, z, null, null);
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener) {
        this(mediaCodecSelector, null, true, handler, audioRendererEventListener);
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener) {
        this(mediaCodecSelector, drmSessionManager, z, handler, audioRendererEventListener, null, 3);
    }

    public MediaCodecAudioRenderer(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, int i) {
        super(1, mediaCodecSelector, drmSessionManager, z);
        this.audioSessionId = 0;
        this.audioTrack = new AudioTrack(audioCapabilities, i);
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z = false;
        String str = format.sampleMimeType;
        if (MimeTypes.isAudio(str)) {
            if (allowPassthrough(str) && mediaCodecSelector.getPassthroughDecoderInfo() != null) {
                return 7;
            }
            MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, false);
            if (decoderInfo == null) {
                return 1;
            }
            if (Util.SDK_INT < 21 || ((format.sampleRate == -1 || decoderInfo.isAudioSampleRateSupportedV21(format.sampleRate)) && (format.channelCount == -1 || decoderInfo.isAudioChannelCountSupportedV21(format.channelCount)))) {
                z = true;
            }
            return (z ? 3 : 2) | 4;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MediaCodecInfo getDecoderInfo(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        MediaCodecInfo passthroughDecoderInfo;
        if (allowPassthrough(format.sampleMimeType) && (passthroughDecoderInfo = mediaCodecSelector.getPassthroughDecoderInfo()) != null) {
            this.passthroughEnabled = true;
            return passthroughDecoderInfo;
        }
        this.passthroughEnabled = false;
        return super.getDecoderInfo(mediaCodecSelector, format, z);
    }

    protected boolean allowPassthrough(String str) {
        return this.audioTrack.isPassthroughSupported(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        if (this.passthroughEnabled) {
            this.passthroughMediaFormat = format.getFrameworkMediaFormatV16();
            this.passthroughMediaFormat.setString(IMediaFormat.KEY_MIME, MimeTypes.AUDIO_RAW);
            mediaCodec.configure(this.passthroughMediaFormat, (Surface) null, mediaCrypto, 0);
            this.passthroughMediaFormat.setString(IMediaFormat.KEY_MIME, format.sampleMimeType);
            return;
        }
        mediaCodec.configure(format.getFrameworkMediaFormatV16(), (Surface) null, mediaCrypto, 0);
        this.passthroughMediaFormat = null;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onInputFormatChanged(Format format) throws ExoPlaybackException {
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        this.pcmEncoding = MimeTypes.AUDIO_RAW.equals(format.sampleMimeType) ? format.pcmEncoding : 2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = this.passthroughMediaFormat != null;
        String string = z ? this.passthroughMediaFormat.getString(IMediaFormat.KEY_MIME) : MimeTypes.AUDIO_RAW;
        if (z) {
            mediaFormat = this.passthroughMediaFormat;
        }
        this.audioTrack.configure(string, mediaFormat.getInteger("channel-count"), mediaFormat.getInteger("sample-rate"), this.pcmEncoding, 0);
    }

    protected void onAudioSessionId(int i) {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z) throws ExoPlaybackException {
        super.onEnabled(z);
        this.eventDispatcher.enabled(this.decoderCounters);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        this.audioTrack.reset();
        this.currentPositionUs = j;
        this.allowPositionDiscontinuity = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.audioTrack.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.audioTrack.pause();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.audioSessionId = 0;
        try {
            this.audioTrack.release();
            try {
                super.onDisabled();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.onDisabled();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return super.isEnded() && !this.audioTrack.hasPendingData();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.audioTrack.hasPendingData() || super.isReady();
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

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        if (this.passthroughEnabled && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.decoderCounters.skippedOutputBufferCount++;
            this.audioTrack.handleDiscontinuity();
            return true;
        } else {
            if (!this.audioTrack.isInitialized()) {
                try {
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
                } catch (AudioTrack.InitializationException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            } else {
                boolean z2 = this.audioTrackHasData;
                this.audioTrackHasData = this.audioTrack.hasPendingData();
                if (z2 && !this.audioTrackHasData && getState() == 2) {
                    this.eventDispatcher.audioTrackUnderrun(this.audioTrack.getBufferSize(), C.usToMs(this.audioTrack.getBufferSizeUs()), SystemClock.elapsedRealtime() - this.lastFeedElapsedRealtimeMs);
                }
            }
            try {
                int handleBuffer = this.audioTrack.handleBuffer(byteBuffer, j3);
                this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
                if ((handleBuffer & 1) != 0) {
                    handleAudioTrackDiscontinuity();
                    this.allowPositionDiscontinuity = true;
                }
                if ((handleBuffer & 2) != 0) {
                    mediaCodec.releaseOutputBuffer(i, false);
                    this.decoderCounters.renderedOutputBufferCount++;
                    return true;
                }
                return false;
            } catch (AudioTrack.WriteException e2) {
                throw ExoPlaybackException.createForRenderer(e2, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputStreamEnded() {
        this.audioTrack.handleEndOfStream();
    }

    protected void handleAudioTrackDiscontinuity() {
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
