package com.google.android.gms.internal;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
/* loaded from: classes2.dex */
final class zzefx extends zzefu {
    private static int zza(byte[] bArr, int i, long j, int i2) {
        int zzh;
        int zzx;
        int zzgy;
        switch (i2) {
            case 0:
                zzgy = zzeft.zzgy(i);
                return zzgy;
            case 1:
                zzx = zzeft.zzx(i, zzefr.zzb(bArr, j));
                return zzx;
            case 2:
                zzh = zzeft.zzh(i, zzefr.zzb(bArr, j), zzefr.zzb(bArr, 1 + j));
                return zzh;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004e, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bb, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int zza(byte[] r9, long r10, int r12) {
        /*
            Method dump skipped, instructions count: 190
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzefx.zza(byte[], long, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.zzefu
    public final int zzb(int i, byte[] bArr, int i2, int i3) {
        if ((i2 | i3 | (bArr.length - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long j = i2;
        return zza(bArr, j, (int) (i3 - j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.zzefu
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        long j2 = i;
        long j3 = j2 + i2;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(length - 1)).append(" at index ").append(i + i2).toString());
        }
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= 128) {
                break;
            }
            zzefr.zza(bArr, j2, (byte) charAt);
            i3++;
            j2 = 1 + j2;
        }
        if (i3 == length) {
            return (int) j2;
        }
        long j4 = j2;
        while (i3 < length) {
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < 128 && j4 < j3) {
                j = 1 + j4;
                zzefr.zza(bArr, j4, (byte) charAt2);
            } else if (charAt2 < 2048 && j4 <= j3 - 2) {
                long j5 = j4 + 1;
                zzefr.zza(bArr, j4, (byte) ((charAt2 >>> 6) | 960));
                j = 1 + j5;
                zzefr.zza(bArr, j5, (byte) ((charAt2 & '?') | 128));
            } else if ((charAt2 >= 55296 && 57343 >= charAt2) || j4 > j3 - 3) {
                if (j4 > j3 - 4) {
                    if (55296 > charAt2 || charAt2 > 57343 || (i3 + 1 != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i3 + 1)))) {
                        throw new ArrayIndexOutOfBoundsException(new StringBuilder(46).append("Failed writing ").append(charAt2).append(" at index ").append(j4).toString());
                    }
                    throw new zzefw(i3, length);
                }
                if (i3 + 1 != length) {
                    i3++;
                    char charAt3 = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        long j6 = 1 + j4;
                        zzefr.zza(bArr, j4, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                        long j7 = 1 + j6;
                        zzefr.zza(bArr, j6, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j8 = j7 + 1;
                        zzefr.zza(bArr, j7, (byte) (((codePoint >>> 6) & 63) | 128));
                        j = 1 + j8;
                        zzefr.zza(bArr, j8, (byte) ((codePoint & 63) | 128));
                    }
                }
                throw new zzefw(i3 - 1, length);
            } else {
                long j9 = 1 + j4;
                zzefr.zza(bArr, j4, (byte) ((charAt2 >>> '\f') | 480));
                long j10 = 1 + j9;
                zzefr.zza(bArr, j9, (byte) (((charAt2 >>> 6) & 63) | 128));
                j = 1 + j10;
                zzefr.zza(bArr, j10, (byte) ((charAt2 & '?') | 128));
            }
            i3++;
            j4 = j;
        }
        return (int) j4;
    }
}
