package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final String TAG = "MediaCodecVideoRenderer";
    private final long allowedJoiningTimeMs;
    private CodecMaxValues codecMaxValues;
    private int consecutiveDroppedFrameCount;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsAutoFrcWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long joiningDeadlineMs;
    private int lastReportedHeight;
    private float lastReportedPixelWidthHeightRatio;
    private int lastReportedUnappliedRotationDegrees;
    private int lastReportedWidth;
    private final int maxDroppedFramesToNotify;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private Format[] streamFormats;
    private Surface surface;
    private final int videoScalingMode;

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, int i) {
        this(context, mediaCodecSelector, i, 0L);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, int i, long j) {
        this(context, mediaCodecSelector, i, j, null, null, -1);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, int i, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2) {
        this(context, mediaCodecSelector, i, j, null, false, handler, videoRendererEventListener, i2);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, int i, long j, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2) {
        super(2, mediaCodecSelector, drmSessionManager, z);
        this.videoScalingMode = i;
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i2;
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(context);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsAutoFrcWorkaround = deviceNeedsAutoFrcWorkaround();
        this.joiningDeadlineMs = C.TIME_UNSET;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.lastReportedWidth = -1;
        this.lastReportedHeight = -1;
        this.lastReportedPixelWidthHeightRatio = -1.0f;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        boolean z2 = false;
        String str = format.sampleMimeType;
        if (MimeTypes.isVideo(str)) {
            DrmInitData drmInitData = format.drmInitData;
            if (drmInitData != null) {
                z = false;
                for (int i = 0; i < drmInitData.schemeDataCount; i++) {
                    z |= drmInitData.get(i).requiresSecureDecryption;
                }
            } else {
                z = false;
            }
            MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, z);
            if (decoderInfo == null) {
                return 1;
            }
            boolean isCodecSupported = decoderInfo.isCodecSupported(format.codecs);
            if (!isCodecSupported || format.width <= 0 || format.height <= 0) {
                z2 = isCodecSupported;
            } else if (Util.SDK_INT >= 21) {
                if (format.frameRate > 0.0f) {
                    z2 = decoderInfo.isVideoSizeAndRateSupportedV21(format.width, format.height, format.frameRate);
                } else {
                    z2 = decoderInfo.isVideoSizeSupportedV21(format.width, format.height);
                }
            } else if (format.width * format.height <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                z2 = true;
            }
            return (decoderInfo.adaptive ? 8 : 4) | (z2 ? 3 : 2);
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z) throws ExoPlaybackException {
        super.onEnabled(z);
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr) throws ExoPlaybackException {
        this.streamFormats = formatArr;
        super.onStreamChanged(formatArr);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        this.renderedFirstFrame = false;
        this.consecutiveDroppedFrameCount = 0;
        this.joiningDeadlineMs = (!z || this.allowedJoiningTimeMs <= 0) ? C.TIME_UNSET : SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if ((this.renderedFirstFrame || super.shouldInitCodec()) && super.isReady()) {
            this.joiningDeadlineMs = C.TIME_UNSET;
            return true;
        } else if (this.joiningDeadlineMs == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() >= this.joiningDeadlineMs) {
                this.joiningDeadlineMs = C.TIME_UNSET;
                return false;
            }
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.joiningDeadlineMs = C.TIME_UNSET;
        maybeNotifyDroppedFrames();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.lastReportedWidth = -1;
        this.lastReportedHeight = -1;
        this.lastReportedPixelWidthHeightRatio = -1.0f;
        this.frameReleaseTimeHelper.disable();
        try {
            super.onDisabled();
        } finally {
            this.decoderCounters.ensureUpdated();
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else {
            super.handleMessage(i, obj);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (this.surface != surface) {
            this.renderedFirstFrame = false;
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                releaseCodec();
                maybeInitCodec();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean shouldInitCodec() {
        return super.shouldInitCodec() && this.surface != null && this.surface.isValid();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.codecMaxValues = getCodecMaxValues(format, this.streamFormats);
        mediaCodec.configure(getMediaFormat(format, this.codecMaxValues, this.deviceNeedsAutoFrcWorkaround), this.surface, mediaCrypto, 0);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onInputFormatChanged(Format format) throws ExoPlaybackException {
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = getPixelWidthHeightRatio(format);
        this.pendingRotationDegrees = getRotationDegrees(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
        if (z) {
            integer = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.currentWidth = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.currentHeight = integer2;
        this.currentPixelWidthHeightRatio = this.pendingPixelWidthHeightRatio;
        if (Util.SDK_INT >= 21) {
            if (this.pendingRotationDegrees == 90 || this.pendingRotationDegrees == 270) {
                int i = this.currentWidth;
                this.currentWidth = this.currentHeight;
                this.currentHeight = i;
                this.currentPixelWidthHeightRatio = 1.0f / this.currentPixelWidthHeightRatio;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        mediaCodec.setVideoScalingMode(this.videoScalingMode);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return areAdaptationCompatible(format, format2) && format2.width <= this.codecMaxValues.width && format2.height <= this.codecMaxValues.height && format2.maxInputSize <= this.codecMaxValues.inputSize && (z || (format.width == format2.width && format.height == format2.height));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (z) {
            skipOutputBuffer(mediaCodec, i);
            return true;
        } else if (!this.renderedFirstFrame) {
            if (Util.SDK_INT >= 21) {
                renderOutputBufferV21(mediaCodec, i, System.nanoTime());
            } else {
                renderOutputBuffer(mediaCodec, i);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = (j3 - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long adjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(j3, (elapsedRealtime * 1000) + nanoTime);
            long j4 = (adjustReleaseTime - nanoTime) / 1000;
            if (j4 < -30000) {
                dropOutputBuffer(mediaCodec, i);
                return true;
            }
            if (Util.SDK_INT >= 21) {
                if (j4 < 50000) {
                    renderOutputBufferV21(mediaCodec, i, adjustReleaseTime);
                    return true;
                }
            } else if (j4 < 30000) {
                if (j4 > 11000) {
                    try {
                        Thread.sleep((j4 - 10000) / 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                renderOutputBuffer(mediaCodec, i);
                return true;
            }
            return false;
        }
    }

    private void skipOutputBuffer(MediaCodec mediaCodec, int i) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    private void dropOutputBuffer(MediaCodec mediaCodec, int i) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.droppedOutputBufferCount++;
        this.droppedFrames++;
        this.consecutiveDroppedFrameCount++;
        this.decoderCounters.maxConsecutiveDroppedOutputBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedOutputBufferCount);
        if (this.droppedFrames == this.maxDroppedFramesToNotify) {
            maybeNotifyDroppedFrames();
        }
    }

    private void renderOutputBuffer(MediaCodec mediaCodec, int i) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (!this.renderedFirstFrame) {
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    @TargetApi(21)
    private void renderOutputBufferV21(MediaCodec mediaCodec, int i, long j) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (!this.renderedFirstFrame) {
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static MediaFormat getMediaFormat(Format format, CodecMaxValues codecMaxValues, boolean z) {
        MediaFormat frameworkMediaFormatV16 = format.getFrameworkMediaFormatV16();
        frameworkMediaFormatV16.setInteger("max-width", codecMaxValues.width);
        frameworkMediaFormatV16.setInteger("max-height", codecMaxValues.height);
        if (codecMaxValues.inputSize != -1) {
            frameworkMediaFormatV16.setInteger("max-input-size", codecMaxValues.inputSize);
        }
        if (z) {
            frameworkMediaFormatV16.setInteger("auto-frc", 0);
        }
        return frameworkMediaFormatV16;
    }

    private static CodecMaxValues getCodecMaxValues(Format format, Format[] formatArr) {
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(format);
        int i3 = i2;
        int i4 = i;
        for (Format format2 : formatArr) {
            if (areAdaptationCompatible(format, format2)) {
                i4 = Math.max(i4, format2.width);
                i3 = Math.max(i3, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(format2));
            }
        }
        return new CodecMaxValues(i4, i3, maxInputSize);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int getMaxInputSize(Format format) {
        char c2;
        int i;
        int i2 = 2;
        if (format.maxInputSize != -1) {
            return format.maxInputSize;
        }
        if (format.width == -1 || format.height == -1) {
            return -1;
        }
        String str = format.sampleMimeType;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(MimeTypes.VIDEO_H263)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals(MimeTypes.VIDEO_MP4V)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals(MimeTypes.VIDEO_VP8)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                i = format.width * format.height;
                break;
            case 2:
                if (!"BRAVIA 4K 2015".equals(Util.MODEL)) {
                    i = ((format.width + 15) / 16) * ((format.height + 15) / 16) * 16 * 16;
                    break;
                } else {
                    return -1;
                }
            case 3:
                i = format.width * format.height;
                break;
            case 4:
            case 5:
                i = format.width * format.height;
                i2 = 4;
                break;
            default:
                return -1;
        }
        return (i * 3) / (i2 * 2);
    }

    private void maybeNotifyVideoSizeChanged() {
        if (this.lastReportedWidth != this.currentWidth || this.lastReportedHeight != this.currentHeight || this.lastReportedUnappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.lastReportedPixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
            this.eventDispatcher.videoSizeChanged(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
            this.lastReportedWidth = this.currentWidth;
            this.lastReportedHeight = this.currentHeight;
            this.lastReportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
            this.lastReportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private static boolean deviceNeedsAutoFrcWorkaround() {
        return Util.SDK_INT <= 22 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER);
    }

    private static boolean areAdaptationCompatible(Format format, Format format2) {
        return format.sampleMimeType.equals(format2.sampleMimeType) && getRotationDegrees(format) == getRotationDegrees(format2);
    }

    private static float getPixelWidthHeightRatio(Format format) {
        if (format.pixelWidthHeightRatio == -1.0f) {
            return 1.0f;
        }
        return format.pixelWidthHeightRatio;
    }

    private static int getRotationDegrees(Format format) {
        if (format.rotationDegrees == -1) {
            return 0;
        }
        return format.rotationDegrees;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }
}
