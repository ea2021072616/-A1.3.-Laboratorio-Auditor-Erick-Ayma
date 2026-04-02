package com.google.android.gms.internal;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public final class zzegg {
    private final ByteBuffer zznct;

    private zzegg(ByteBuffer byteBuffer) {
        this.zznct = byteBuffer;
        this.zznct.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzegg(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int length = charSequence.length();
        int i4 = 0;
        int i5 = i + i2;
        while (i4 < length && i4 + i < i5) {
            char charAt = charSequence.charAt(i4);
            if (charAt >= 128) {
                break;
            }
            bArr[i + i4] = (byte) charAt;
            i4++;
        }
        if (i4 == length) {
            return i + length;
        }
        int i6 = i + i4;
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 < 128 && i6 < i5) {
                i3 = i6 + 1;
                bArr[i6] = (byte) charAt2;
            } else if (charAt2 < 2048 && i6 <= i5 - 2) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 6) | 960);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 >= 55296 && 57343 >= charAt2) || i6 > i5 - 3) {
                if (i6 <= i5 - 4) {
                    if (i4 + 1 != charSequence.length()) {
                        i4++;
                        char charAt3 = charSequence.charAt(i4);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i8 = i6 + 1;
                            bArr[i6] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i3 = i10 + 1;
                            bArr[i10] = (byte) ((codePoint & 63) | 128);
                        }
                    }
                    throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i4 - 1).toString());
                }
                throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charAt2).append(" at index ").append(i6).toString());
            } else {
                int i11 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> '\f') | 480);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i3 = i12 + 1;
                bArr[i12] = (byte) ((charAt2 & '?') | 128);
            }
            i4++;
            i6 = i3;
        }
        return i6;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            zzb(charSequence, byteBuffer);
            return;
        }
        try {
            byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    public static zzegg zzav(byte[] bArr) {
        return zzi(bArr, 0, bArr.length);
    }

    public static int zzaw(byte[] bArr) {
        return zzhd(bArr.length) + bArr.length;
    }

    public static int zzb(int i, zzego zzegoVar) {
        int zzgr = zzgr(i);
        int zzbjo = zzegoVar.zzbjo();
        return zzgr + zzbjo + zzhd(zzbjo);
    }

    private static int zzb(CharSequence charSequence) {
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
                                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3).toString());
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

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 128) {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 2048) {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else if (charAt >= 55296 && 57343 >= charAt) {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                        byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i - 1).toString());
            } else {
                byteBuffer.put((byte) ((charAt >>> '\f') | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            }
            i++;
        }
    }

    private final void zzco(long j) throws IOException {
        while (((-128) & j) != 0) {
            zzhb((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzhb((int) j);
    }

    public static int zzcp(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    private final void zzcq(long j) throws IOException {
        if (this.zznct.remaining() < 8) {
            throw new zzegh(this.zznct.position(), this.zznct.limit());
        }
        this.zznct.putLong(j);
    }

    private static long zzcr(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzd(int i, byte[] bArr) {
        return zzgr(i) + zzaw(bArr);
    }

    public static int zze(int i, long j) {
        return zzgr(i) + zzcp(j);
    }

    public static int zzf(int i, long j) {
        return zzgr(i) + zzcp(zzcr(j));
    }

    public static int zzgr(int i) {
        return zzhd(i << 3);
    }

    public static int zzgs(int i) {
        if (i >= 0) {
            return zzhd(i);
        }
        return 10;
    }

    private final void zzhb(int i) throws IOException {
        byte b2 = (byte) i;
        if (!this.zznct.hasRemaining()) {
            throw new zzegh(this.zznct.position(), this.zznct.limit());
        }
        this.zznct.put(b2);
    }

    public static int zzhd(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    public static int zzhe(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static zzegg zzi(byte[] bArr, int i, int i2) {
        return new zzegg(bArr, 0, i2);
    }

    public static int zzm(int i, String str) {
        return zzgr(i) + zzrc(str);
    }

    public static int zzrc(String str) {
        int zzb = zzb(str);
        return zzb + zzhd(zzb);
    }

    public static int zzv(int i, int i2) {
        return zzgr(i) + zzgs(i2);
    }

    public final void zza(int i, double d) throws IOException {
        zzt(i, 1);
        zzcq(Double.doubleToLongBits(d));
    }

    public final void zza(int i, long j) throws IOException {
        zzt(i, 0);
        zzco(j);
    }

    public final void zza(int i, zzego zzegoVar) throws IOException {
        zzt(i, 2);
        zzb(zzegoVar);
    }

    public final void zzax(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zznct.remaining() < length) {
            throw new zzegh(this.zznct.position(), this.zznct.limit());
        }
        this.zznct.put(bArr, 0, length);
    }

    public final void zzb(int i, long j) throws IOException {
        zzt(i, 0);
        zzco(j);
    }

    public final void zzb(zzego zzegoVar) throws IOException {
        zzhc(zzegoVar.zzcef());
        zzegoVar.zza(this);
    }

    public final void zzc(int i, float f) throws IOException {
        zzt(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.zznct.remaining() < 4) {
            throw new zzegh(this.zznct.position(), this.zznct.limit());
        }
        this.zznct.putInt(floatToIntBits);
    }

    public final void zzc(int i, long j) throws IOException {
        zzt(i, 1);
        zzcq(j);
    }

    public final void zzc(int i, byte[] bArr) throws IOException {
        zzt(i, 2);
        zzhc(bArr.length);
        zzax(bArr);
    }

    public final void zzccd() {
        if (this.zznct.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.zznct.remaining())));
        }
    }

    public final void zzd(int i, long j) throws IOException {
        zzt(i, 0);
        zzco(zzcr(j));
    }

    public final void zzhc(int i) throws IOException {
        while ((i & (-128)) != 0) {
            zzhb((i & 127) | 128);
            i >>>= 7;
        }
        zzhb(i);
    }

    public final void zzl(int i, String str) throws IOException {
        zzt(i, 2);
        try {
            int zzhd = zzhd(str.length());
            if (zzhd != zzhd(str.length() * 3)) {
                zzhc(zzb(str));
                zza(str, this.zznct);
                return;
            }
            int position = this.zznct.position();
            if (this.zznct.remaining() < zzhd) {
                throw new zzegh(zzhd + position, this.zznct.limit());
            }
            this.zznct.position(position + zzhd);
            zza(str, this.zznct);
            int position2 = this.zznct.position();
            this.zznct.position(position);
            zzhc((position2 - position) - zzhd);
            this.zznct.position(position2);
        } catch (BufferOverflowException e) {
            zzegh zzeghVar = new zzegh(this.zznct.position(), this.zznct.limit());
            zzeghVar.initCause(e);
            throw zzeghVar;
        }
    }

    public final void zzl(int i, boolean z) throws IOException {
        zzt(i, 0);
        byte b2 = (byte) (z ? 1 : 0);
        if (!this.zznct.hasRemaining()) {
            throw new zzegh(this.zznct.position(), this.zznct.limit());
        }
        this.zznct.put(b2);
    }

    public final void zzt(int i, int i2) throws IOException {
        zzhc((i << 3) | i2);
    }

    public final void zzu(int i, int i2) throws IOException {
        zzt(i, 0);
        if (i2 >= 0) {
            zzhc(i2);
        } else {
            zzco(i2);
        }
    }
}
