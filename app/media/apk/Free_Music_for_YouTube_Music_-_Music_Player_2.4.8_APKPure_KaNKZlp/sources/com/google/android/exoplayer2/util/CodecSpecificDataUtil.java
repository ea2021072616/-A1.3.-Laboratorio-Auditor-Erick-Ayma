package com.google.android.exoplayer2.util;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class CodecSpecificDataUtil {
    private static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    private static final int AUDIO_OBJECT_TYPE_ER_BSAC = 22;
    private static final int AUDIO_OBJECT_TYPE_PS = 29;
    private static final int AUDIO_OBJECT_TYPE_SBR = 5;
    private static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_CONFIGURATION_INVALID = -1;
    private static final int AUDIO_SPECIFIC_CONFIG_FREQUENCY_INDEX_ARBITRARY = 15;
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private CodecSpecificDataUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> parseAacAudioSpecificConfig(byte[] r11) {
        /*
            r9 = 13
            r8 = 5
            r1 = 1
            r2 = 0
            r7 = 4
            com.google.android.exoplayer2.util.ParsableBitArray r4 = new com.google.android.exoplayer2.util.ParsableBitArray
            r4.<init>(r11)
            int r5 = r4.readBits(r8)
            int r3 = r4.readBits(r7)
            r0 = 15
            if (r3 != r0) goto L5b
            r0 = 24
            int r0 = r4.readBits(r0)
        L1d:
            int r3 = r4.readBits(r7)
            if (r5 == r8) goto L27
            r6 = 29
            if (r5 != r6) goto L77
        L27:
            int r5 = r4.readBits(r7)
            r0 = 15
            if (r5 != r0) goto L68
            r0 = 24
            int r0 = r4.readBits(r0)
        L35:
            int r5 = r4.readBits(r8)
            r6 = 22
            if (r5 != r6) goto L77
            int r3 = r4.readBits(r7)
            r10 = r3
            r3 = r0
            r0 = r10
        L44:
            int[] r4 = com.google.android.exoplayer2.util.CodecSpecificDataUtil.AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE
            r0 = r4[r0]
            r4 = -1
            if (r0 == r4) goto L75
        L4b:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            android.util.Pair r0 = android.util.Pair.create(r1, r0)
            return r0
        L5b:
            if (r3 >= r9) goto L66
            r0 = r1
        L5e:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r0)
            int[] r0 = com.google.android.exoplayer2.util.CodecSpecificDataUtil.AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE
            r0 = r0[r3]
            goto L1d
        L66:
            r0 = r2
            goto L5e
        L68:
            if (r5 >= r9) goto L73
            r0 = r1
        L6b:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r0)
            int[] r0 = com.google.android.exoplayer2.util.CodecSpecificDataUtil.AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE
            r0 = r0[r5]
            goto L35
        L73:
            r0 = r2
            goto L6b
        L75:
            r1 = r2
            goto L4b
        L77:
            r10 = r3
            r3 = r0
            r0 = r10
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.CodecSpecificDataUtil.parseAacAudioSpecificConfig(byte[]):android.util.Pair");
    }

    public static byte[] buildAacLcAudioSpecificConfig(int i, int i2) {
        int i3 = -1;
        for (int i4 = 0; i4 < AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE.length; i4++) {
            if (i == AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[i4]) {
                i3 = i4;
            }
        }
        int i5 = -1;
        for (int i6 = 0; i6 < AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE.length; i6++) {
            if (i2 == AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[i6]) {
                i5 = i6;
            }
        }
        if (i == -1 || i5 == -1) {
            throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i + ", " + i2);
        }
        return buildAacAudioSpecificConfig(2, i3, i5);
    }

    public static byte[] buildAacAudioSpecificConfig(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] buildNalUnit(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[NAL_START_CODE.length + i2];
        System.arraycopy(NAL_START_CODE, 0, bArr2, 0, NAL_START_CODE.length);
        System.arraycopy(bArr, i, bArr2, NAL_START_CODE.length, i2);
        return bArr2;
    }

    public static byte[][] splitNalUnits(byte[] bArr) {
        if (!isNalStartCode(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        do {
            arrayList.add(Integer.valueOf(i));
            i = findNalStartCode(bArr, i + NAL_START_CODE.length);
        } while (i != -1);
        byte[][] bArr2 = new byte[arrayList.size()];
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            byte[] bArr3 = new byte[(i2 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i2 + 1)).intValue() : bArr.length) - intValue];
            System.arraycopy(bArr, intValue, bArr3, 0, bArr3.length);
            bArr2[i2] = bArr3;
            i2++;
        }
        return bArr2;
    }

    private static int findNalStartCode(byte[] bArr, int i) {
        int length = bArr.length - NAL_START_CODE.length;
        for (int i2 = i; i2 <= length; i2++) {
            if (isNalStartCode(bArr, i2)) {
                return i2;
            }
        }
        return -1;
    }

    private static boolean isNalStartCode(byte[] bArr, int i) {
        if (bArr.length - i <= NAL_START_CODE.length) {
            return false;
        }
        for (int i2 = 0; i2 < NAL_START_CODE.length; i2++) {
            if (bArr[i + i2] != NAL_START_CODE[i2]) {
                return false;
            }
        }
        return true;
    }
}
