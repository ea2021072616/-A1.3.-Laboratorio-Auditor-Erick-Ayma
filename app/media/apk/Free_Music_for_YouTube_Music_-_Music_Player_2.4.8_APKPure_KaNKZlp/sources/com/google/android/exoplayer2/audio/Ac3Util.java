package com.google.android.exoplayer2.audio;

import com.flurry.android.Constants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class Ac3Util {
    private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
    private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] SAMPLE_RATE_BY_FSCOD = {48000, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {24000, 22050, 16000};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        int i = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & PsExtractor.AUDIO_STREAM) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return Format.createAudioSampleFormat(str, MimeTypes.AUDIO_AC3, null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        parsableByteArray.skipBytes(2);
        int i = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & PsExtractor.AUDIO_STREAM) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return Format.createAudioSampleFormat(str, MimeTypes.AUDIO_E_AC3, null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static Format parseAc3SyncframeFormat(ParsableBitArray parsableBitArray, String str, String str2, DrmInitData drmInitData) {
        parsableBitArray.skipBits(32);
        int readBits = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(14);
        int readBits2 = parsableBitArray.readBits(3);
        if ((readBits2 & 1) != 0 && readBits2 != 1) {
            parsableBitArray.skipBits(2);
        }
        if ((readBits2 & 4) != 0) {
            parsableBitArray.skipBits(2);
        }
        if (readBits2 == 2) {
            parsableBitArray.skipBits(2);
        }
        return Format.createAudioSampleFormat(str, MimeTypes.AUDIO_AC3, null, -1, -1, CHANNEL_COUNT_BY_ACMOD[readBits2] + (parsableBitArray.readBit() ? 1 : 0), SAMPLE_RATE_BY_FSCOD[readBits], null, drmInitData, 0, str2);
    }

    public static Format parseEac3SyncframeFormat(ParsableBitArray parsableBitArray, String str, String str2, DrmInitData drmInitData) {
        int i;
        parsableBitArray.skipBits(32);
        int readBits = parsableBitArray.readBits(2);
        if (readBits == 3) {
            i = SAMPLE_RATE_BY_FSCOD2[parsableBitArray.readBits(2)];
        } else {
            parsableBitArray.skipBits(2);
            i = SAMPLE_RATE_BY_FSCOD[readBits];
        }
        return Format.createAudioSampleFormat(str, MimeTypes.AUDIO_E_AC3, null, -1, -1, CHANNEL_COUNT_BY_ACMOD[parsableBitArray.readBits(3)] + (parsableBitArray.readBit() ? 1 : 0), i, null, drmInitData, 0, str2);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return getAc3SyncframeSize((bArr[4] & 192) >> 6, bArr[4] & 63);
    }

    public static int parseEAc3SyncframeSize(byte[] bArr) {
        return (((bArr[2] & 7) << 8) + (bArr[3] & Constants.UNKNOWN) + 1) * 2;
    }

    public static int getAc3SyncframeAudioSampleCount() {
        return AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
    }

    public static int parseEAc3SyncframeAudioSampleCount(byte[] bArr) {
        return (((bArr[4] & 192) >> 6) == 3 ? 6 : BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[(bArr[4] & 48) >> 4]) * 256;
    }

    public static int parseEAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) == 3 ? 6 : BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4]) * 256;
    }

    private static int getAc3SyncframeSize(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= SAMPLE_RATE_BY_FSCOD.length || i2 < 0 || i3 >= SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1.length) {
            return -1;
        }
        int i4 = SAMPLE_RATE_BY_FSCOD[i];
        if (i4 == 44100) {
            return (SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1[i3] + (i2 % 2)) * 2;
        }
        int i5 = BITRATE_BY_HALF_FRMSIZECOD[i3];
        if (i4 == 32000) {
            return i5 * 6;
        }
        return i5 * 4;
    }

    private Ac3Util() {
    }
}
