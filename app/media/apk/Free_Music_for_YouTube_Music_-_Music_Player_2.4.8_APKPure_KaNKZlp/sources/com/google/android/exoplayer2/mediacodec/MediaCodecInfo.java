package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
@TargetApi(16)
/* loaded from: classes.dex */
public final class MediaCodecInfo {
    public final boolean adaptive;
    private final MediaCodecInfo.CodecCapabilities capabilities;
    private final String mimeType;
    public final String name;

    public static MediaCodecInfo newPassthroughInstance(String str) {
        return new MediaCodecInfo(str, null, null);
    }

    public static MediaCodecInfo newInstance(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return new MediaCodecInfo(str, str2, codecCapabilities);
    }

    private MediaCodecInfo(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        this.name = (String) Assertions.checkNotNull(str);
        this.mimeType = str2;
        this.capabilities = codecCapabilities;
        this.adaptive = codecCapabilities != null && isAdaptive(codecCapabilities);
    }

    public MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        return (this.capabilities == null || this.capabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.capabilities.profileLevels;
    }

    public boolean isCodecSupported(String str) {
        MediaCodecInfo.CodecProfileLevel[] profileLevels;
        if (str == null || this.mimeType == null) {
            return true;
        }
        String mediaMimeType = MimeTypes.getMediaMimeType(str);
        if (mediaMimeType == null) {
            return true;
        }
        if (this.mimeType.equals(mediaMimeType)) {
            Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(str);
            if (codecProfileAndLevel == null) {
                return true;
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
                if (codecProfileLevel.profile == ((Integer) codecProfileAndLevel.first).intValue() && codecProfileLevel.level >= ((Integer) codecProfileAndLevel.second).intValue()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @TargetApi(21)
    public boolean isVideoSizeSupportedV21(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        return (this.capabilities == null || (videoCapabilities = this.capabilities.getVideoCapabilities()) == null || !videoCapabilities.isSizeSupported(i, i2)) ? false : true;
    }

    @TargetApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int i, int i2, double d) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        return (this.capabilities == null || (videoCapabilities = this.capabilities.getVideoCapabilities()) == null || !videoCapabilities.areSizeAndRateSupported(i, i2, d)) ? false : true;
    }

    @TargetApi(21)
    public boolean isAudioSampleRateSupportedV21(int i) {
        MediaCodecInfo.AudioCapabilities audioCapabilities;
        return (this.capabilities == null || (audioCapabilities = this.capabilities.getAudioCapabilities()) == null || !audioCapabilities.isSampleRateSupported(i)) ? false : true;
    }

    @TargetApi(21)
    public boolean isAudioChannelCountSupportedV21(int i) {
        MediaCodecInfo.AudioCapabilities audioCapabilities;
        return (this.capabilities == null || (audioCapabilities = this.capabilities.getAudioCapabilities()) == null || audioCapabilities.getMaxInputChannelCount() < i) ? false : true;
    }

    private static boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.SDK_INT >= 19 && isAdaptiveV19(codecCapabilities);
    }

    @TargetApi(19)
    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }
}
