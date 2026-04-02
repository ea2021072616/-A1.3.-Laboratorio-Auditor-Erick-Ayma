package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
/* loaded from: classes.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() { // from class: com.google.android.exoplayer2.Format.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Format[] newArray(int i) {
            return new Format[i];
        }
    };
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    private MediaFormat frameworkMediaFormat;
    private int hashCode;
    public final int height;
    public final String id;
    public final List<byte[]> initializationData;
    public final String language;
    public final int maxInputSize;
    public final int pcmEncoding;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    public static Format createVideoContainerFormat(String str, String str2, String str3, String str4, int i, int i2, int i3, float f, List<byte[]> list) {
        return new Format(str, str2, str3, str4, i, -1, i2, i3, f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, 0, null, Long.MAX_VALUE, list, null);
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, DrmInitData drmInitData) {
        return createVideoSampleFormat(str, str2, str3, i, i2, i3, i4, f, list, -1, -1.0f, drmInitData);
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, DrmInitData drmInitData) {
        return createVideoSampleFormat(str, str2, str3, i, i2, i3, i4, f, list, i5, f2, null, -1, drmInitData);
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, i2, i3, i4, f, i5, f2, bArr, i6, -1, -1, -1, -1, -1, 0, null, Long.MAX_VALUE, list, drmInitData);
    }

    public static Format createAudioContainerFormat(String str, String str2, String str3, String str4, int i, int i2, int i3, List<byte[]> list, int i4, String str5) {
        return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, i2, i3, -1, -1, -1, i4, str5, Long.MAX_VALUE, list, null);
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData, int i5, String str4) {
        return createAudioSampleFormat(str, str2, str3, i, i2, i3, i4, -1, list, drmInitData, i5, str4);
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str4) {
        return createAudioSampleFormat(str, str2, str3, i, i2, i3, i4, i5, -1, -1, list, drmInitData, i6, str4);
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData, int i8, String str4) {
        return new Format(str, null, str2, str3, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, i3, i4, i5, i6, i7, i8, str4, Long.MAX_VALUE, list, drmInitData);
    }

    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, i2, str5, Long.MAX_VALUE, null, null);
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i, int i2, String str4, DrmInitData drmInitData) {
        return createTextSampleFormat(str, str2, str3, i, i2, str4, drmInitData, Long.MAX_VALUE);
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i, int i2, String str4, DrmInitData drmInitData, long j) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, i2, str4, j, null, drmInitData);
    }

    public static Format createImageSampleFormat(String str, String str2, String str3, int i, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, 0, str4, Long.MAX_VALUE, list, drmInitData);
    }

    public static Format createContainerFormat(String str, String str2, String str3, String str4, int i) {
        return new Format(str, str2, str4, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, 0, null, Long.MAX_VALUE, null, null);
    }

    public static Format createSampleFormat(String str, String str2, String str3, int i, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, 0, null, Long.MAX_VALUE, null, drmInitData);
    }

    Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, int i7, int i8, int i9, int i10, int i11, int i12, String str5, long j, List<byte[]> list, DrmInitData drmInitData) {
        this.id = str;
        this.containerMimeType = str2;
        this.sampleMimeType = str3;
        this.codecs = str4;
        this.bitrate = i;
        this.maxInputSize = i2;
        this.width = i3;
        this.height = i4;
        this.frameRate = f;
        this.rotationDegrees = i5;
        this.pixelWidthHeightRatio = f2;
        this.projectionData = bArr;
        this.stereoMode = i6;
        this.channelCount = i7;
        this.sampleRate = i8;
        this.pcmEncoding = i9;
        this.encoderDelay = i10;
        this.encoderPadding = i11;
        this.selectionFlags = i12;
        this.language = str5;
        this.subsampleOffsetUs = j;
        this.initializationData = list == null ? Collections.emptyList() : list;
        this.drmInitData = drmInitData;
    }

    Format(Parcel parcel) {
        this.id = parcel.readString();
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.codecs = parcel.readString();
        this.bitrate = parcel.readInt();
        this.maxInputSize = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        this.projectionData = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.selectionFlags = parcel.readInt();
        this.language = parcel.readString();
        this.subsampleOffsetUs = parcel.readLong();
        int readInt = parcel.readInt();
        this.initializationData = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.initializationData.add(parcel.createByteArray());
        }
        this.drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
    }

    public Format copyWithMaxInputSize(int i) {
        return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, i, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.subsampleOffsetUs, this.initializationData, this.drmInitData);
    }

    public Format copyWithSubsampleOffsetUs(long j) {
        return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, j, this.initializationData, this.drmInitData);
    }

    public Format copyWithContainerInfo(String str, String str2, int i, int i2, int i3, int i4, String str3) {
        return new Format(str, this.containerMimeType, this.sampleMimeType, str2, i, this.maxInputSize, i2, i3, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i4, str3, this.subsampleOffsetUs, this.initializationData, this.drmInitData);
    }

    public Format copyWithManifestFormatInfo(Format format, boolean z) {
        return new Format(format.id, this.containerMimeType, this.sampleMimeType, this.codecs == null ? format.codecs : this.codecs, this.bitrate == -1 ? format.bitrate : this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate == -1.0f ? format.frameRate : this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags | format.selectionFlags, this.language == null ? format.language : this.language, this.subsampleOffsetUs, this.initializationData, ((!z || format.drmInitData == null) && this.drmInitData != null) ? this.drmInitData : format.drmInitData);
    }

    public Format copyWithGaplessInfo(int i, int i2) {
        return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.channelCount, this.sampleRate, this.pcmEncoding, i, i2, this.selectionFlags, this.language, this.subsampleOffsetUs, this.initializationData, this.drmInitData);
    }

    public Format copyWithDrmInitData(DrmInitData drmInitData) {
        return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.subsampleOffsetUs, this.initializationData, drmInitData);
    }

    public int getPixelCount() {
        if (this.width == -1 || this.height == -1) {
            return -1;
        }
        return this.width * this.height;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat getFrameworkMediaFormatV16() {
        if (this.frameworkMediaFormat == null) {
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, this.sampleMimeType);
            maybeSetStringV16(mediaFormat, IjkMediaMeta.IJKM_KEY_LANGUAGE, this.language);
            maybeSetIntegerV16(mediaFormat, "max-input-size", this.maxInputSize);
            maybeSetIntegerV16(mediaFormat, "width", this.width);
            maybeSetIntegerV16(mediaFormat, "height", this.height);
            maybeSetFloatV16(mediaFormat, "frame-rate", this.frameRate);
            maybeSetIntegerV16(mediaFormat, "rotation-degrees", this.rotationDegrees);
            maybeSetIntegerV16(mediaFormat, "channel-count", this.channelCount);
            maybeSetIntegerV16(mediaFormat, "sample-rate", this.sampleRate);
            maybeSetIntegerV16(mediaFormat, "encoder-delay", this.encoderDelay);
            maybeSetIntegerV16(mediaFormat, "encoder-padding", this.encoderPadding);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.initializationData.size()) {
                    break;
                }
                mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap(this.initializationData.get(i2)));
                i = i2 + 1;
            }
            this.frameworkMediaFormat = mediaFormat;
        }
        return this.frameworkMediaFormat;
    }

    public String toString() {
        return "Format(" + this.id + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.bitrate + ", , " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (((this.language == null ? 0 : this.language.hashCode()) + (((((((((((((this.codecs == null ? 0 : this.codecs.hashCode()) + (((this.sampleMimeType == null ? 0 : this.sampleMimeType.hashCode()) + (((this.containerMimeType == null ? 0 : this.containerMimeType.hashCode()) + (((this.id == null ? 0 : this.id.hashCode()) + 527) * 31)) * 31)) * 31)) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.channelCount) * 31) + this.sampleRate) * 31)) * 31) + (this.drmInitData != null ? this.drmInitData.hashCode() : 0);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        if (this.bitrate == format.bitrate && this.maxInputSize == format.maxInputSize && this.width == format.width && this.height == format.height && this.frameRate == format.frameRate && this.rotationDegrees == format.rotationDegrees && this.pixelWidthHeightRatio == format.pixelWidthHeightRatio && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.subsampleOffsetUs == format.subsampleOffsetUs && this.selectionFlags == format.selectionFlags && Util.areEqual(this.id, format.id) && Util.areEqual(this.language, format.language) && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.drmInitData, format.drmInitData) && Arrays.equals(this.projectionData, format.projectionData) && this.initializationData.size() == format.initializationData.size()) {
            for (int i = 0; i < this.initializationData.size(); i++) {
                if (!Arrays.equals(this.initializationData.get(i), format.initializationData.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @TargetApi(16)
    private static void maybeSetStringV16(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    @TargetApi(16)
    private static void maybeSetIntegerV16(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @TargetApi(16)
    private static void maybeSetFloatV16(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeString(this.codecs);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.maxInputSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        parcel.writeInt(this.projectionData != null ? 1 : 0);
        if (this.projectionData != null) {
            parcel.writeByteArray(this.projectionData);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.selectionFlags);
        parcel.writeString(this.language);
        parcel.writeLong(this.subsampleOffsetUs);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.initializationData.get(i2));
        }
        parcel.writeParcelable(this.drmInitData, 0);
    }
}
