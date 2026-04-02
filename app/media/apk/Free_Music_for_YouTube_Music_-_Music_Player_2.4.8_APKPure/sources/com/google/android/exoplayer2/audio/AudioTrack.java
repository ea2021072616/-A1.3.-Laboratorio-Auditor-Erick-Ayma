package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.flurry.android.Constants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class AudioTrack {
    private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_BUFFER_DURATION_US = 750000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final long MIN_BUFFER_DURATION_US = 250000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int MIN_TIMESTAMP_SAMPLE_INTERVAL_US = 500000;
    private static final long PASSTHROUGH_BUFFER_DURATION_US = 250000;
    public static final int RESULT_BUFFER_CONSUMED = 2;
    public static final int RESULT_POSITION_DISCONTINUITY = 1;
    public static final int SESSION_ID_NOT_SET = 0;
    private static final int START_IN_SYNC = 1;
    private static final int START_NEED_SYNC = 2;
    private static final int START_NOT_SET = 0;
    private static final String TAG = "AudioTrack";
    public static boolean enablePreV21AudioSessionWorkaround = false;
    public static boolean failOnSpuriousAudioTimestamp = false;
    private final AudioCapabilities audioCapabilities;
    private boolean audioTimestampSet;
    private android.media.AudioTrack audioTrack;
    private final AudioTrackUtil audioTrackUtil;
    private int bufferSize;
    private long bufferSizeUs;
    private int channelConfig;
    private ByteBuffer currentSourceBuffer;
    private int framesPerEncodedSample;
    private Method getLatencyMethod;
    private android.media.AudioTrack keepSessionIdAudioTrack;
    private long lastPlayheadSampleTimeUs;
    private long lastTimestampSampleTimeUs;
    private long latencyUs;
    private int nextPlayheadOffsetIndex;
    private boolean passthrough;
    private int pcmFrameSize;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private final ConditionVariable releasingConditionVariable = new ConditionVariable(true);
    private ByteBuffer resampledBuffer;
    private long resumeSystemTimeUs;
    private int sampleRate;
    private long smoothedPlayheadOffsetUs;
    private int sourceEncoding;
    private int startMediaTimeState;
    private long startMediaTimeUs;
    private final int streamType;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private int targetEncoding;
    private byte[] temporaryBuffer;
    private int temporaryBufferOffset;
    private boolean useResampledBuffer;
    private float volume;

    /* loaded from: classes.dex */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.audioTrackState = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i) {
            super("AudioTrack write failed: " + i);
            this.errorCode = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public AudioTrack(AudioCapabilities audioCapabilities, int i) {
        this.audioCapabilities = audioCapabilities;
        this.streamType = i;
        if (Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = android.media.AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (Util.SDK_INT >= 23) {
            this.audioTrackUtil = new AudioTrackUtilV23();
        } else if (Util.SDK_INT >= 19) {
            this.audioTrackUtil = new AudioTrackUtilV19();
        } else {
            this.audioTrackUtil = new AudioTrackUtil();
        }
        this.playheadOffsets = new long[10];
        this.volume = 1.0f;
        this.startMediaTimeState = 0;
    }

    public boolean isPassthroughSupported(String str) {
        return this.audioCapabilities != null && this.audioCapabilities.supportsEncoding(getEncodingForMimeType(str));
    }

    public boolean isInitialized() {
        return this.audioTrack != null;
    }

    public long getCurrentPositionUs(boolean z) {
        long j;
        if (!hasCurrentPositionUs()) {
            return Long.MIN_VALUE;
        }
        if (this.audioTrack.getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.audioTimestampSet) {
            return framesToDurationUs(durationUsToFrames(((float) (nanoTime - (this.audioTrackUtil.getTimestampNanoTime() / 1000))) * this.audioTrackUtil.getPlaybackSpeed()) + this.audioTrackUtil.getTimestampFramePosition()) + this.startMediaTimeUs;
        }
        if (this.playheadOffsetCount == 0) {
            j = this.audioTrackUtil.getPlaybackHeadPositionUs() + this.startMediaTimeUs;
        } else {
            j = nanoTime + this.smoothedPlayheadOffsetUs + this.startMediaTimeUs;
        }
        if (!z) {
            return j - this.latencyUs;
        }
        return j;
    }

    public void configure(String str, int i, int i2, int i3, int i4) {
        int i5;
        switch (i) {
            case 1:
                i5 = 4;
                break;
            case 2:
                i5 = 12;
                break;
            case 3:
                i5 = 28;
                break;
            case 4:
                i5 = 204;
                break;
            case 5:
                i5 = 220;
                break;
            case 6:
                i5 = 252;
                break;
            case 7:
                i5 = 1276;
                break;
            case 8:
                i5 = C.CHANNEL_OUT_7POINT1_SURROUND;
                break;
            default:
                throw new IllegalArgumentException("Unsupported channel count: " + i);
        }
        boolean z = !MimeTypes.AUDIO_RAW.equals(str);
        if (z) {
            i3 = getEncodingForMimeType(str);
        } else if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new IllegalArgumentException("Unsupported PCM encoding: " + i3);
        }
        if (!isInitialized() || this.sourceEncoding != i3 || this.sampleRate != i2 || this.channelConfig != i5) {
            reset();
            this.sourceEncoding = i3;
            this.passthrough = z;
            this.sampleRate = i2;
            this.channelConfig = i5;
            if (!z) {
                i3 = 2;
            }
            this.targetEncoding = i3;
            this.pcmFrameSize = i * 2;
            if (i4 != 0) {
                this.bufferSize = i4;
            } else if (z) {
                if (this.targetEncoding == 5 || this.targetEncoding == 6) {
                    this.bufferSize = 20480;
                } else {
                    this.bufferSize = 49152;
                }
            } else {
                int minBufferSize = android.media.AudioTrack.getMinBufferSize(i2, i5, this.targetEncoding);
                Assertions.checkState(minBufferSize != -2);
                int i6 = minBufferSize * 4;
                int durationUsToFrames = ((int) durationUsToFrames(250000L)) * this.pcmFrameSize;
                int max = (int) Math.max(minBufferSize, durationUsToFrames(MAX_BUFFER_DURATION_US) * this.pcmFrameSize);
                if (i6 >= durationUsToFrames) {
                    durationUsToFrames = i6 > max ? max : i6;
                }
                this.bufferSize = durationUsToFrames;
            }
            this.bufferSizeUs = z ? C.TIME_UNSET : framesToDurationUs(pcmBytesToFrames(this.bufferSize));
        }
    }

    public int initialize(int i) throws InitializationException {
        this.releasingConditionVariable.block();
        if (i == 0) {
            this.audioTrack = new android.media.AudioTrack(this.streamType, this.sampleRate, this.channelConfig, this.targetEncoding, this.bufferSize, 1);
        } else {
            this.audioTrack = new android.media.AudioTrack(this.streamType, this.sampleRate, this.channelConfig, this.targetEncoding, this.bufferSize, 1, i);
        }
        checkAudioTrackInitialized();
        int audioSessionId = this.audioTrack.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && Util.SDK_INT < 21) {
            if (this.keepSessionIdAudioTrack != null && audioSessionId != this.keepSessionIdAudioTrack.getAudioSessionId()) {
                releaseKeepSessionIdAudioTrack();
            }
            if (this.keepSessionIdAudioTrack == null) {
                this.keepSessionIdAudioTrack = new android.media.AudioTrack(this.streamType, 4000, 4, 2, 2, 0, audioSessionId);
            }
        }
        this.audioTrackUtil.reconfigure(this.audioTrack, needsPassthroughWorkarounds());
        setAudioTrackVolume();
        return audioSessionId;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public long getBufferSizeUs() {
        return this.bufferSizeUs;
    }

    public void play() {
        if (isInitialized()) {
            this.resumeSystemTimeUs = System.nanoTime() / 1000;
            this.audioTrack.play();
        }
    }

    public void handleDiscontinuity() {
        if (this.startMediaTimeState == 1) {
            this.startMediaTimeState = 2;
        }
    }

    public int handleBuffer(ByteBuffer byteBuffer, long j) throws WriteException {
        int i = 1;
        int i2 = 0;
        boolean z = this.currentSourceBuffer == null;
        Assertions.checkState(z || this.currentSourceBuffer == byteBuffer);
        this.currentSourceBuffer = byteBuffer;
        if (needsPassthroughWorkarounds()) {
            if (this.audioTrack.getPlayState() == 2) {
                return 0;
            }
            if (this.audioTrack.getPlayState() == 1 && this.audioTrackUtil.getPlaybackHeadPosition() != 0) {
                return 0;
            }
        }
        if (!z) {
            i = 0;
        } else if (!this.currentSourceBuffer.hasRemaining()) {
            this.currentSourceBuffer = null;
            return 2;
        } else {
            this.useResampledBuffer = this.targetEncoding != this.sourceEncoding;
            if (this.useResampledBuffer) {
                Assertions.checkState(this.targetEncoding == 2);
                this.resampledBuffer = resampleTo16BitPcm(this.currentSourceBuffer, this.sourceEncoding, this.resampledBuffer);
                byteBuffer = this.resampledBuffer;
            }
            if (this.passthrough && this.framesPerEncodedSample == 0) {
                this.framesPerEncodedSample = getFramesPerEncodedSample(this.targetEncoding, byteBuffer);
            }
            if (this.startMediaTimeState == 0) {
                this.startMediaTimeUs = Math.max(0L, j);
                this.startMediaTimeState = 1;
                i = 0;
            } else {
                long framesToDurationUs = this.startMediaTimeUs + framesToDurationUs(getSubmittedFrames());
                if (this.startMediaTimeState == 1 && Math.abs(framesToDurationUs - j) > 200000) {
                    Log.e(TAG, "Discontinuity detected [expected " + framesToDurationUs + ", got " + j + "]");
                    this.startMediaTimeState = 2;
                }
                if (this.startMediaTimeState == 2) {
                    this.startMediaTimeUs = (j - framesToDurationUs) + this.startMediaTimeUs;
                    this.startMediaTimeState = 1;
                } else {
                    i = 0;
                }
            }
            if (Util.SDK_INT < 21) {
                int remaining = byteBuffer.remaining();
                if (this.temporaryBuffer == null || this.temporaryBuffer.length < remaining) {
                    this.temporaryBuffer = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.temporaryBuffer, 0, remaining);
                byteBuffer.position(position);
                this.temporaryBufferOffset = 0;
            }
        }
        if (this.useResampledBuffer) {
            byteBuffer = this.resampledBuffer;
        }
        int remaining2 = byteBuffer.remaining();
        if (Util.SDK_INT < 21) {
            int playbackHeadPosition = this.bufferSize - ((int) (this.submittedPcmBytes - (this.audioTrackUtil.getPlaybackHeadPosition() * this.pcmFrameSize)));
            if (playbackHeadPosition > 0) {
                i2 = this.audioTrack.write(this.temporaryBuffer, this.temporaryBufferOffset, Math.min(remaining2, playbackHeadPosition));
                if (i2 >= 0) {
                    this.temporaryBufferOffset += i2;
                }
                byteBuffer.position(byteBuffer.position() + i2);
            }
        } else {
            i2 = writeNonBlockingV21(this.audioTrack, byteBuffer, remaining2);
        }
        if (i2 < 0) {
            throw new WriteException(i2);
        }
        if (!this.passthrough) {
            this.submittedPcmBytes += i2;
        }
        if (i2 == remaining2) {
            if (this.passthrough) {
                this.submittedEncodedFrames += this.framesPerEncodedSample;
            }
            this.currentSourceBuffer = null;
            i |= 2;
        }
        return i;
    }

    public void handleEndOfStream() {
        if (isInitialized()) {
            this.audioTrackUtil.handleEndOfStream(getSubmittedFrames());
        }
    }

    public boolean hasPendingData() {
        return isInitialized() && (getSubmittedFrames() > this.audioTrackUtil.getPlaybackHeadPosition() || overrideHasPendingData());
    }

    public void setPlaybackParams(PlaybackParams playbackParams) {
        this.audioTrackUtil.setPlaybackParams(playbackParams);
    }

    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            setAudioTrackVolume();
        }
    }

    private void setAudioTrackVolume() {
        if (isInitialized()) {
            if (Util.SDK_INT >= 21) {
                setAudioTrackVolumeV21(this.audioTrack, this.volume);
            } else {
                setAudioTrackVolumeV3(this.audioTrack, this.volume);
            }
        }
    }

    public void pause() {
        if (isInitialized()) {
            resetSyncParams();
            this.audioTrackUtil.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.exoplayer2.audio.AudioTrack$1] */
    public void reset() {
        if (isInitialized()) {
            this.submittedPcmBytes = 0L;
            this.submittedEncodedFrames = 0L;
            this.framesPerEncodedSample = 0;
            this.currentSourceBuffer = null;
            this.startMediaTimeState = 0;
            this.latencyUs = 0L;
            resetSyncParams();
            if (this.audioTrack.getPlayState() == 3) {
                this.audioTrack.pause();
            }
            final android.media.AudioTrack audioTrack = this.audioTrack;
            this.audioTrack = null;
            this.audioTrackUtil.reconfigure(null, false);
            this.releasingConditionVariable.close();
            new Thread() { // from class: com.google.android.exoplayer2.audio.AudioTrack.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        AudioTrack.this.releasingConditionVariable.open();
                    }
                }
            }.start();
        }
    }

    public void release() {
        reset();
        releaseKeepSessionIdAudioTrack();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.exoplayer2.audio.AudioTrack$2] */
    private void releaseKeepSessionIdAudioTrack() {
        if (this.keepSessionIdAudioTrack != null) {
            final android.media.AudioTrack audioTrack = this.keepSessionIdAudioTrack;
            this.keepSessionIdAudioTrack = null;
            new Thread() { // from class: com.google.android.exoplayer2.audio.AudioTrack.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean hasCurrentPositionUs() {
        return isInitialized() && this.startMediaTimeState != 0;
    }

    private void maybeSampleSyncParams() {
        long playbackHeadPositionUs = this.audioTrackUtil.getPlaybackHeadPositionUs();
        if (playbackHeadPositionUs != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.lastPlayheadSampleTimeUs >= 30000) {
                this.playheadOffsets[this.nextPlayheadOffsetIndex] = playbackHeadPositionUs - nanoTime;
                this.nextPlayheadOffsetIndex = (this.nextPlayheadOffsetIndex + 1) % 10;
                if (this.playheadOffsetCount < 10) {
                    this.playheadOffsetCount++;
                }
                this.lastPlayheadSampleTimeUs = nanoTime;
                this.smoothedPlayheadOffsetUs = 0L;
                for (int i = 0; i < this.playheadOffsetCount; i++) {
                    this.smoothedPlayheadOffsetUs += this.playheadOffsets[i] / this.playheadOffsetCount;
                }
            }
            if (!needsPassthroughWorkarounds() && nanoTime - this.lastTimestampSampleTimeUs >= 500000) {
                this.audioTimestampSet = this.audioTrackUtil.updateTimestamp();
                if (this.audioTimestampSet) {
                    long timestampNanoTime = this.audioTrackUtil.getTimestampNanoTime() / 1000;
                    long timestampFramePosition = this.audioTrackUtil.getTimestampFramePosition();
                    if (timestampNanoTime < this.resumeSystemTimeUs) {
                        this.audioTimestampSet = false;
                    } else if (Math.abs(timestampNanoTime - nanoTime) > 5000000) {
                        String str = "Spurious audio timestamp (system clock mismatch): " + timestampFramePosition + ", " + timestampNanoTime + ", " + nanoTime + ", " + playbackHeadPositionUs;
                        if (failOnSpuriousAudioTimestamp) {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                        Log.w(TAG, str);
                        this.audioTimestampSet = false;
                    } else if (Math.abs(framesToDurationUs(timestampFramePosition) - playbackHeadPositionUs) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + timestampFramePosition + ", " + timestampNanoTime + ", " + nanoTime + ", " + playbackHeadPositionUs;
                        if (failOnSpuriousAudioTimestamp) {
                            throw new InvalidAudioTrackTimestampException(str2);
                        }
                        Log.w(TAG, str2);
                        this.audioTimestampSet = false;
                    }
                }
                if (this.getLatencyMethod != null && !this.passthrough) {
                    try {
                        this.latencyUs = (((Integer) this.getLatencyMethod.invoke(this.audioTrack, null)).intValue() * 1000) - this.bufferSizeUs;
                        this.latencyUs = Math.max(this.latencyUs, 0L);
                        if (this.latencyUs > 5000000) {
                            Log.w(TAG, "Ignoring impossibly large audio latency: " + this.latencyUs);
                            this.latencyUs = 0L;
                        }
                    } catch (Exception e) {
                        this.getLatencyMethod = null;
                    }
                }
                this.lastTimestampSampleTimeUs = nanoTime;
            }
        }
    }

    private void checkAudioTrackInitialized() throws InitializationException {
        int state = this.audioTrack.getState();
        if (state == 1) {
            return;
        }
        try {
            this.audioTrack.release();
        } catch (Exception e) {
        } finally {
            this.audioTrack = null;
        }
        throw new InitializationException(state, this.sampleRate, this.channelConfig, this.bufferSize);
    }

    private long pcmBytesToFrames(long j) {
        return j / this.pcmFrameSize;
    }

    private long framesToDurationUs(long j) {
        return (C.MICROS_PER_SECOND * j) / this.sampleRate;
    }

    private long durationUsToFrames(long j) {
        return (this.sampleRate * j) / C.MICROS_PER_SECOND;
    }

    private long getSubmittedFrames() {
        return this.passthrough ? this.submittedEncodedFrames : pcmBytesToFrames(this.submittedPcmBytes);
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0L;
        this.audioTimestampSet = false;
        this.lastTimestampSampleTimeUs = 0L;
    }

    private boolean needsPassthroughWorkarounds() {
        return Util.SDK_INT < 23 && (this.targetEncoding == 5 || this.targetEncoding == 6);
    }

    private boolean overrideHasPendingData() {
        return needsPassthroughWorkarounds() && this.audioTrack.getPlayState() == 2 && this.audioTrack.getPlaybackHeadPosition() == 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static ByteBuffer resampleTo16BitPcm(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2) {
        int i2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i3 = limit - position;
        switch (i) {
            case Integer.MIN_VALUE:
                i2 = (i3 / 3) * 2;
                break;
            case 3:
                i2 = i3 * 2;
                break;
            case 1073741824:
                i2 = i3 / 2;
                break;
            default:
                throw new IllegalStateException();
        }
        if (byteBuffer2 == null || byteBuffer2.capacity() < i2) {
            byteBuffer2 = ByteBuffer.allocateDirect(i2);
        }
        byteBuffer2.position(0);
        byteBuffer2.limit(i2);
        switch (i) {
            case Integer.MIN_VALUE:
                while (position < limit) {
                    byteBuffer2.put(byteBuffer.get(position + 1));
                    byteBuffer2.put(byteBuffer.get(position + 2));
                    position += 3;
                }
                break;
            case 3:
                while (position < limit) {
                    byteBuffer2.put((byte) 0);
                    byteBuffer2.put((byte) ((byteBuffer.get(position) & Constants.UNKNOWN) - 128));
                    position++;
                }
                break;
            case 1073741824:
                while (position < limit) {
                    byteBuffer2.put(byteBuffer.get(position + 2));
                    byteBuffer2.put(byteBuffer.get(position + 3));
                    position += 4;
                }
                break;
            default:
                throw new IllegalStateException();
        }
        byteBuffer2.position(0);
        return byteBuffer2;
    }

    private static int getEncodingForMimeType(String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals(MimeTypes.AUDIO_DTS)) {
                    c2 = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c2 = 0;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    c2 = 1;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals(MimeTypes.AUDIO_DTS_HD)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            default:
                return 0;
        }
    }

    private static int getFramesPerEncodedSample(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return DtsUtil.parseDtsAudioSampleCount(byteBuffer);
        }
        if (i == 5) {
            return Ac3Util.getAc3SyncframeAudioSampleCount();
        }
        if (i == 6) {
            return Ac3Util.parseEAc3SyncframeAudioSampleCount(byteBuffer);
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i);
    }

    @TargetApi(21)
    private static int writeNonBlockingV21(android.media.AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @TargetApi(21)
    private static void setAudioTrackVolumeV21(android.media.AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    private static void setAudioTrackVolumeV3(android.media.AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AudioTrackUtil {
        protected android.media.AudioTrack audioTrack;
        private long endPlaybackHeadPosition;
        private long lastRawPlaybackHeadPosition;
        private boolean needsPassthroughWorkaround;
        private long passthroughWorkaroundPauseOffset;
        private long rawPlaybackHeadWrapCount;
        private int sampleRate;
        private long stopPlaybackHeadPosition;
        private long stopTimestampUs;

        private AudioTrackUtil() {
        }

        public void reconfigure(android.media.AudioTrack audioTrack, boolean z) {
            this.audioTrack = audioTrack;
            this.needsPassthroughWorkaround = z;
            this.stopTimestampUs = C.TIME_UNSET;
            this.lastRawPlaybackHeadPosition = 0L;
            this.rawPlaybackHeadWrapCount = 0L;
            this.passthroughWorkaroundPauseOffset = 0L;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
        }

        public void handleEndOfStream(long j) {
            this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
            this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
            this.endPlaybackHeadPosition = j;
            this.audioTrack.stop();
        }

        public void pause() {
            if (this.stopTimestampUs == C.TIME_UNSET) {
                this.audioTrack.pause();
            }
        }

        public long getPlaybackHeadPosition() {
            if (this.stopTimestampUs != C.TIME_UNSET) {
                return Math.min(this.endPlaybackHeadPosition, ((((SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * this.sampleRate) / C.MICROS_PER_SECOND) + this.stopPlaybackHeadPosition);
            }
            int playState = this.audioTrack.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.audioTrack.getPlaybackHeadPosition();
            if (this.needsPassthroughWorkaround) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
                }
                playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
            }
            if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
                this.rawPlaybackHeadWrapCount++;
            }
            this.lastRawPlaybackHeadPosition = playbackHeadPosition;
            return playbackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
        }

        public long getPlaybackHeadPositionUs() {
            return (getPlaybackHeadPosition() * C.MICROS_PER_SECOND) / this.sampleRate;
        }

        public boolean updateTimestamp() {
            return false;
        }

        public long getTimestampNanoTime() {
            throw new UnsupportedOperationException();
        }

        public long getTimestampFramePosition() {
            throw new UnsupportedOperationException();
        }

        public void setPlaybackParams(PlaybackParams playbackParams) {
            throw new UnsupportedOperationException();
        }

        public float getPlaybackSpeed() {
            return 1.0f;
        }
    }

    @TargetApi(19)
    /* loaded from: classes.dex */
    private static class AudioTrackUtilV19 extends AudioTrackUtil {
        private final AudioTimestamp audioTimestamp;
        private long lastRawTimestampFramePosition;
        private long lastTimestampFramePosition;
        private long rawTimestampFramePositionWrapCount;

        public AudioTrackUtilV19() {
            super();
            this.audioTimestamp = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrack.AudioTrackUtil
        public void reconfigure(android.media.AudioTrack audioTrack, boolean z) {
            super.reconfigure(audioTrack, z);
            this.rawTimestampFramePositionWrapCount = 0L;
            this.lastRawTimestampFramePosition = 0L;
            this.lastTimestampFramePosition = 0L;
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrack.AudioTrackUtil
        public boolean updateTimestamp() {
            boolean timestamp = this.audioTrack.getTimestamp(this.audioTimestamp);
            if (timestamp) {
                long j = this.audioTimestamp.framePosition;
                if (this.lastRawTimestampFramePosition > j) {
                    this.rawTimestampFramePositionWrapCount++;
                }
                this.lastRawTimestampFramePosition = j;
                this.lastTimestampFramePosition = j + (this.rawTimestampFramePositionWrapCount << 32);
            }
            return timestamp;
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrack.AudioTrackUtil
        public long getTimestampNanoTime() {
            return this.audioTimestamp.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrack.AudioTrackUtil
        public long getTimestampFramePosition() {
            return this.lastTimestampFramePosition;
        }
    }

    @TargetApi(23)
    /* loaded from: classes.dex */
    private static class AudioTrackUtilV23 extends AudioTrackUtilV19 {
        private PlaybackParams playbackParams;
        private float playbackSpeed = 1.0f;

        @Override // com.google.android.exoplayer2.audio.AudioTrack.AudioTrackUtilV19, com.google.android.exoplayer2.audio.AudioTrack.AudioTrackUtil
        public void reconfigure(android.media.AudioTrack audioTrack, boolean z) {
            super.reconfigure(audioTrack, z);
            maybeApplyPlaybackParams();
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrack.AudioTrackUtil
        public void setPlaybackParams(PlaybackParams playbackParams) {
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            PlaybackParams allowDefaults = playbackParams.allowDefaults();
            this.playbackParams = allowDefaults;
            this.playbackSpeed = allowDefaults.getSpeed();
            maybeApplyPlaybackParams();
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrack.AudioTrackUtil
        public float getPlaybackSpeed() {
            return this.playbackSpeed;
        }

        private void maybeApplyPlaybackParams() {
            if (this.audioTrack != null && this.playbackParams != null) {
                this.audioTrack.setPlaybackParams(this.playbackParams);
            }
        }
    }
}
