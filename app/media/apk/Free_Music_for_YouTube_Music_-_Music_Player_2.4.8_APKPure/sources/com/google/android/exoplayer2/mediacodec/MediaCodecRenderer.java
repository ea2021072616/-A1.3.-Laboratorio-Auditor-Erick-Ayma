package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
@TargetApi(16)
/* loaded from: classes.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = Util.getBytesFromHexString("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private static final int ADAPTATION_WORKAROUND_SLICE_WIDTH_HEIGHT = 32;
    private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000;
    private static final int RECONFIGURATION_STATE_NONE = 0;
    private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "MediaCodecRenderer";
    private final DecoderInputBuffer buffer;
    private MediaCodec codec;
    private long codecHotswapDeadlineMs;
    private boolean codecIsAdaptive;
    private boolean codecNeedsAdaptationWorkaround;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosPropagationWorkaround;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private int codecReinitializationState;
    private final List<Long> decodeOnlyPresentationTimestamps;
    protected DecoderCounters decoderCounters;
    private DrmSession<FrameworkMediaCrypto> drmSession;
    private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private Format format;
    private final FormatHolder formatHolder;
    private ByteBuffer[] inputBuffers;
    private int inputIndex;
    private boolean inputStreamEnded;
    private final MediaCodecSelector mediaCodecSelector;
    private final MediaCodec.BufferInfo outputBufferInfo;
    private ByteBuffer[] outputBuffers;
    private int outputIndex;
    private boolean outputStreamEnded;
    private DrmSession<FrameworkMediaCrypto> pendingDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private boolean shouldSkipOutputBuffer;
    private boolean waitingForKeys;

    protected abstract void configureCodec(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    protected abstract boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException;

    protected abstract int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException;

    /* loaded from: classes.dex */
    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final String decoderName;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z;
            this.decoderName = null;
            this.diagnosticInfo = buildCustomDiagnosticInfo(i);
        }

        public DecoderInitializationException(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z;
            this.decoderName = str;
            this.diagnosticInfo = Util.SDK_INT >= 21 ? getDiagnosticInfoV21(th) : null;
        }

        @TargetApi(21)
        private static String getDiagnosticInfoV21(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String buildCustomDiagnosticInfo(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }
    }

    public MediaCodecRenderer(int i, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z) {
        super(i);
        Assertions.checkState(Util.SDK_INT >= 16);
        this.mediaCodecSelector = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector);
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z;
        this.buffer = new DecoderInputBuffer(0);
        this.formatHolder = new FormatHolder();
        this.decodeOnlyPresentationTimestamps = new ArrayList();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
        this.codecReconfigurationState = 0;
        this.codecReinitializationState = 0;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 4;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) throws ExoPlaybackException {
        try {
            return supportsFormat(this.mediaCodecSelector, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MediaCodecInfo getDecoderInfo(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return mediaCodecSelector.getDecoderInfo(format.sampleMimeType, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void maybeInitCodec() throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.maybeInitCodec():void");
    }

    private void throwDecoderInitError(DecoderInitializationException decoderInitializationException) throws ExoPlaybackException {
        throw ExoPlaybackException.createForRenderer(decoderInitializationException, getIndex());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldInitCodec() {
        return this.codec == null && this.format != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.codec != null) {
            flushCodec();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.format = null;
        try {
            releaseCodec();
            try {
                if (this.drmSession != null) {
                    this.drmSessionManager.releaseSession(this.drmSession);
                }
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.drmSession != null) {
                    this.drmSessionManager.releaseSession(this.drmSession);
                }
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseCodec() {
        if (this.codec != null) {
            this.codecHotswapDeadlineMs = C.TIME_UNSET;
            this.inputIndex = -1;
            this.outputIndex = -1;
            this.waitingForKeys = false;
            this.shouldSkipOutputBuffer = false;
            this.decodeOnlyPresentationTimestamps.clear();
            this.inputBuffers = null;
            this.outputBuffers = null;
            this.codecReconfigured = false;
            this.codecReceivedBuffers = false;
            this.codecIsAdaptive = false;
            this.codecNeedsDiscardToSpsWorkaround = false;
            this.codecNeedsFlushWorkaround = false;
            this.codecNeedsAdaptationWorkaround = false;
            this.codecNeedsEosPropagationWorkaround = false;
            this.codecNeedsEosFlushWorkaround = false;
            this.codecNeedsMonoChannelCountWorkaround = false;
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
            this.codecReceivedEos = false;
            this.codecReconfigurationState = 0;
            this.codecReinitializationState = 0;
            this.decoderCounters.decoderReleaseCount++;
            try {
                this.codec.stop();
                try {
                    this.codec.release();
                    this.codec = null;
                    if (this.drmSession == null || this.pendingDrmSession == this.drmSession) {
                        return;
                    }
                    try {
                        this.drmSessionManager.releaseSession(this.drmSession);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.codec = null;
                    if (this.drmSession != null && this.pendingDrmSession != this.drmSession) {
                        try {
                            this.drmSessionManager.releaseSession(this.drmSession);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.codec.release();
                    this.codec = null;
                    if (this.drmSession != null && this.pendingDrmSession != this.drmSession) {
                        try {
                            this.drmSessionManager.releaseSession(this.drmSession);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.codec = null;
                    if (this.drmSession != null && this.pendingDrmSession != this.drmSession) {
                        try {
                            this.drmSessionManager.releaseSession(this.drmSession);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.format == null) {
            readFormat();
        }
        maybeInitCodec();
        if (this.codec != null) {
            TraceUtil.beginSection("drainAndFeed");
            do {
            } while (drainOutputBuffer(j, j2));
            do {
            } while (feedInputBuffer());
            TraceUtil.endSection();
        } else if (this.format != null) {
            skipToKeyframeBefore(j);
        }
        this.decoderCounters.ensureUpdated();
    }

    private void readFormat() throws ExoPlaybackException {
        if (readSource(this.formatHolder, null) == -5) {
            onInputFormatChanged(this.formatHolder.format);
        }
    }

    protected void flushCodec() throws ExoPlaybackException {
        this.codecHotswapDeadlineMs = C.TIME_UNSET;
        this.inputIndex = -1;
        this.outputIndex = -1;
        this.waitingForKeys = false;
        this.shouldSkipOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        if (this.codecNeedsFlushWorkaround || (this.codecNeedsEosFlushWorkaround && this.codecReceivedEos)) {
            releaseCodec();
            maybeInitCodec();
        } else if (this.codecReinitializationState != 0) {
            releaseCodec();
            maybeInitCodec();
        } else {
            this.codec.flush();
            this.codecReceivedBuffers = false;
        }
        if (this.codecReconfigured && this.format != null) {
            this.codecReconfigurationState = 1;
        }
    }

    private boolean feedInputBuffer() throws ExoPlaybackException {
        int position;
        int readSource;
        if (this.inputStreamEnded || this.codecReinitializationState == 2) {
            return false;
        }
        if (this.inputIndex < 0) {
            this.inputIndex = this.codec.dequeueInputBuffer(0L);
            if (this.inputIndex < 0) {
                return false;
            }
            this.buffer.data = this.inputBuffers[this.inputIndex];
            this.buffer.clear();
        }
        if (this.codecReinitializationState == 1) {
            if (!this.codecNeedsEosPropagationWorkaround) {
                this.codecReceivedEos = true;
                this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                this.inputIndex = -1;
            }
            this.codecReinitializationState = 2;
            return false;
        } else if (this.codecNeedsAdaptationWorkaroundBuffer) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            this.buffer.data.put(ADAPTATION_WORKAROUND_BUFFER);
            this.codec.queueInputBuffer(this.inputIndex, 0, ADAPTATION_WORKAROUND_BUFFER.length, 0L, 0);
            this.inputIndex = -1;
            this.codecReceivedBuffers = true;
            return true;
        } else {
            if (this.waitingForKeys) {
                readSource = -4;
                position = 0;
            } else {
                if (this.codecReconfigurationState == 1) {
                    for (int i = 0; i < this.format.initializationData.size(); i++) {
                        this.buffer.data.put(this.format.initializationData.get(i));
                    }
                    this.codecReconfigurationState = 2;
                }
                position = this.buffer.data.position();
                readSource = readSource(this.formatHolder, this.buffer);
            }
            if (readSource != -3) {
                if (readSource == -5) {
                    if (this.codecReconfigurationState == 2) {
                        this.buffer.clear();
                        this.codecReconfigurationState = 1;
                    }
                    onInputFormatChanged(this.formatHolder.format);
                    return true;
                } else if (this.buffer.isEndOfStream()) {
                    if (this.codecReconfigurationState == 2) {
                        this.buffer.clear();
                        this.codecReconfigurationState = 1;
                    }
                    this.inputStreamEnded = true;
                    if (!this.codecReceivedBuffers) {
                        processEndOfStream();
                        return false;
                    }
                    try {
                        if (this.codecNeedsEosPropagationWorkaround) {
                            return false;
                        }
                        this.codecReceivedEos = true;
                        this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                        this.inputIndex = -1;
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw ExoPlaybackException.createForRenderer(e, getIndex());
                    }
                } else {
                    boolean isEncrypted = this.buffer.isEncrypted();
                    this.waitingForKeys = shouldWaitForKeys(isEncrypted);
                    if (this.waitingForKeys) {
                        return false;
                    }
                    if (this.codecNeedsDiscardToSpsWorkaround && !isEncrypted) {
                        NalUnitUtil.discardToSps(this.buffer.data);
                        if (this.buffer.data.position() == 0) {
                            return true;
                        }
                        this.codecNeedsDiscardToSpsWorkaround = false;
                    }
                    try {
                        long j = this.buffer.timeUs;
                        if (this.buffer.isDecodeOnly()) {
                            this.decodeOnlyPresentationTimestamps.add(Long.valueOf(j));
                        }
                        this.buffer.flip();
                        onQueueInputBuffer(this.buffer);
                        if (isEncrypted) {
                            this.codec.queueSecureInputBuffer(this.inputIndex, 0, getFrameworkCryptoInfo(this.buffer, position), j, 0);
                        } else {
                            this.codec.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j, 0);
                        }
                        this.inputIndex = -1;
                        this.codecReceivedBuffers = true;
                        this.codecReconfigurationState = 0;
                        this.decoderCounters.inputBufferCount++;
                        return true;
                    } catch (MediaCodec.CryptoException e2) {
                        throw ExoPlaybackException.createForRenderer(e2, getIndex());
                    }
                }
            }
            return false;
        }
    }

    private static MediaCodec.CryptoInfo getFrameworkCryptoInfo(DecoderInputBuffer decoderInputBuffer, int i) {
        MediaCodec.CryptoInfo frameworkCryptoInfoV16 = decoderInputBuffer.cryptoInfo.getFrameworkCryptoInfoV16();
        if (i != 0) {
            if (frameworkCryptoInfoV16.numBytesOfClearData == null) {
                frameworkCryptoInfoV16.numBytesOfClearData = new int[1];
            }
            int[] iArr = frameworkCryptoInfoV16.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return frameworkCryptoInfoV16;
    }

    private boolean shouldWaitForKeys(boolean z) throws ExoPlaybackException {
        if (this.drmSession == null) {
            return false;
        }
        int state = this.drmSession.getState();
        if (state == 0) {
            throw ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
        }
        if (state != 4) {
            return z || !this.playClearSamplesWithoutKeys;
        }
        return false;
    }

    protected void onCodecInitialized(String str, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        Format format2 = this.format;
        this.format = format;
        if (!Util.areEqual(this.format.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.format.drmInitData != null) {
                if (this.drmSessionManager == null) {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
                this.pendingDrmSession = this.drmSessionManager.acquireSession(Looper.myLooper(), this.format.drmInitData);
                if (this.pendingDrmSession == this.drmSession) {
                    this.drmSessionManager.releaseSession(this.pendingDrmSession);
                }
            } else {
                this.pendingDrmSession = null;
            }
        }
        if (this.pendingDrmSession == this.drmSession && this.codec != null && canReconfigureCodec(this.codec, this.codecIsAdaptive, format2, this.format)) {
            this.codecReconfigured = true;
            this.codecReconfigurationState = 1;
            this.codecNeedsAdaptationWorkaroundBuffer = this.codecNeedsAdaptationWorkaround && this.format.width == format2.width && this.format.height == format2.height;
        } else if (this.codecReceivedBuffers) {
            this.codecReinitializationState = 1;
        } else {
            releaseCodec();
            maybeInitCodec();
        }
    }

    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected void onOutputStreamEnded() {
    }

    protected void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    protected void onProcessedOutputBuffer(long j) {
    }

    protected boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return (this.format == null || this.waitingForKeys || (!isSourceReady() && this.outputIndex < 0 && (this.codecHotswapDeadlineMs == C.TIME_UNSET || SystemClock.elapsedRealtime() >= this.codecHotswapDeadlineMs))) ? false : true;
    }

    protected long getDequeueOutputBufferTimeoutUs() {
        return 0L;
    }

    private boolean drainOutputBuffer(long j, long j2) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            return false;
        }
        if (this.outputIndex < 0) {
            this.outputIndex = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
            if (this.outputIndex >= 0) {
                if (this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                    this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                    this.codec.releaseOutputBuffer(this.outputIndex, false);
                    this.outputIndex = -1;
                    return true;
                } else if ((this.outputBufferInfo.flags & 4) != 0) {
                    processEndOfStream();
                    this.outputIndex = -1;
                    return true;
                } else {
                    ByteBuffer byteBuffer = this.outputBuffers[this.outputIndex];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.outputBufferInfo.offset);
                        byteBuffer.limit(this.outputBufferInfo.offset + this.outputBufferInfo.size);
                    }
                    this.shouldSkipOutputBuffer = shouldSkipOutputBuffer(this.outputBufferInfo.presentationTimeUs);
                }
            } else if (this.outputIndex == -2) {
                processOutputFormat();
                return true;
            } else if (this.outputIndex == -3) {
                processOutputBuffersChanged();
                return true;
            } else if (this.codecNeedsEosPropagationWorkaround && (this.inputStreamEnded || this.codecReinitializationState == 2)) {
                processEndOfStream();
                return true;
            } else {
                return false;
            }
        }
        if (processOutputBuffer(j, j2, this.codec, this.outputBuffers[this.outputIndex], this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.shouldSkipOutputBuffer)) {
            onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
            this.outputIndex = -1;
            return true;
        }
        return false;
    }

    private void processOutputFormat() {
        MediaFormat outputFormat = this.codec.getOutputFormat();
        if (this.codecNeedsAdaptationWorkaround && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if (this.codecNeedsMonoChannelCountWorkaround) {
            outputFormat.setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.codec, outputFormat);
    }

    private void processOutputBuffersChanged() {
        this.outputBuffers = this.codec.getOutputBuffers();
    }

    private void processEndOfStream() throws ExoPlaybackException {
        if (this.codecReinitializationState == 2) {
            releaseCodec();
            maybeInitCodec();
            return;
        }
        this.outputStreamEnded = true;
        onOutputStreamEnded();
    }

    private boolean shouldSkipOutputBuffer(long j) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i = 0; i < size; i++) {
            if (this.decodeOnlyPresentationTimestamps.get(i).longValue() == j) {
                this.decodeOnlyPresentationTimestamps.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        return Util.SDK_INT < 18 || (Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (Util.SDK_INT == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean codecNeedsAdaptationWorkaround(String str) {
        return Util.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(Util.DEVICE) || "flounder_lte".equals(Util.DEVICE) || "grouper".equals(Util.DEVICE) || "tilapia".equals(Util.DEVICE));
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(String str, Format format) {
        return Util.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean codecNeedsEosPropagationWorkaround(String str) {
        return Util.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private static boolean codecNeedsEosFlushWorkaround(String str) {
        return Util.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str);
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String str, Format format) {
        return Util.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
