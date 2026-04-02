package com.google.android.gms.internal;

import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
final class zzeft {
    private static final zzefu zznbj;

    static {
        zznbj = zzefr.zzcdi() && zzefr.zzcdj() ? new zzefx() : new zzefv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zznbj.zzb(charSequence, bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(CharSequence charSequence) {
        int i;
        int i2 = 0;
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                i = i4;
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                throw new zzefw(i3, length2);
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i = i4 + i2;
            }
        }
        if (i < length) {
            throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(i + IjkMediaMeta.AV_CH_WIDE_RIGHT).toString());
        }
        return i;
    }

    public static boolean zze(byte[] bArr, int i, int i2) {
        return zznbj.zzb(0, bArr, i, i2) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzf(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return zzgy(b2);
            case 1:
                return zzx(b2, bArr[i]);
            case 2:
                return zzh(b2, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzgy(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzh(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return ((i2 << 8) ^ i) ^ (i3 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzx(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return (i2 << 8) ^ i;
    }
}
