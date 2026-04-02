package com.google.android.gms.internal;

import android.support.v7.widget.ActivityChooserView;
import com.flurry.android.Constants;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzegf {
    private final byte[] buffer;
    private int zzmxy;
    private int zzmyc;
    private int zzmye;
    private int zzncq;
    private int zzncr;
    private int zzncs;
    private int zzmyf = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzmxz = 64;
    private int zzmya = 67108864;

    private zzegf(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzncq = i;
        this.zzncr = i + i2;
        this.zzncs = i;
    }

    public static zzegf zzau(byte[] bArr) {
        return zzh(bArr, 0, bArr.length);
    }

    private final void zzcca() {
        this.zzncr += this.zzmyc;
        int i = this.zzncr;
        if (i <= this.zzmyf) {
            this.zzmyc = 0;
            return;
        }
        this.zzmyc = i - this.zzmyf;
        this.zzncr -= this.zzmyc;
    }

    private final byte zzccb() throws IOException {
        if (this.zzncs == this.zzncr) {
            throw zzegn.zzceb();
        }
        byte[] bArr = this.buffer;
        int i = this.zzncs;
        this.zzncs = i + 1;
        return bArr[i];
    }

    private final void zzgo(int i) throws IOException {
        if (i < 0) {
            throw zzegn.zzcec();
        }
        if (this.zzncs + i > this.zzmyf) {
            zzgo(this.zzmyf - this.zzncs);
            throw zzegn.zzceb();
        } else if (i > this.zzncr - this.zzncs) {
            throw zzegn.zzceb();
        } else {
            this.zzncs += i;
        }
    }

    public static zzegf zzh(byte[] bArr, int i, int i2) {
        return new zzegf(bArr, 0, i2);
    }

    public final int getPosition() {
        return this.zzncs - this.zzncq;
    }

    public final byte[] readBytes() throws IOException {
        int zzcbz = zzcbz();
        if (zzcbz < 0) {
            throw zzegn.zzcec();
        }
        if (zzcbz == 0) {
            return zzegr.zzndo;
        }
        if (zzcbz > this.zzncr - this.zzncs) {
            throw zzegn.zzceb();
        }
        byte[] bArr = new byte[zzcbz];
        System.arraycopy(this.buffer, this.zzncs, bArr, 0, zzcbz);
        this.zzncs = zzcbz + this.zzncs;
        return bArr;
    }

    public final String readString() throws IOException {
        int zzcbz = zzcbz();
        if (zzcbz < 0) {
            throw zzegn.zzcec();
        }
        if (zzcbz > this.zzncr - this.zzncs) {
            throw zzegn.zzceb();
        }
        String str = new String(this.buffer, this.zzncs, zzcbz, zzegm.UTF_8);
        this.zzncs = zzcbz + this.zzncs;
        return str;
    }

    public final void zza(zzego zzegoVar) throws IOException {
        int zzcbz = zzcbz();
        if (this.zzmxy >= this.zzmxz) {
            throw zzegn.zzcee();
        }
        int zzgm = zzgm(zzcbz);
        this.zzmxy++;
        zzegoVar.zza(this);
        zzgk(0);
        this.zzmxy--;
        zzgn(zzgm);
    }

    public final void zza(zzego zzegoVar, int i) throws IOException {
        if (this.zzmxy >= this.zzmxz) {
            throw zzegn.zzcee();
        }
        this.zzmxy++;
        zzegoVar.zza(this);
        zzgk((i << 3) | 4);
        this.zzmxy--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaa(int i, int i2) {
        if (i > this.zzncs - this.zzncq) {
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i).append(" is beyond current ").append(this.zzncs - this.zzncq).toString());
        } else if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i).toString());
        } else {
            this.zzncs = this.zzncq + i;
            this.zzmye = i2;
        }
    }

    public final int zzcbr() throws IOException {
        if (this.zzncs == this.zzncr) {
            this.zzmye = 0;
            return 0;
        }
        this.zzmye = zzcbz();
        if (this.zzmye == 0) {
            throw new zzegn("Protocol message contained an invalid tag (zero).");
        }
        return this.zzmye;
    }

    public final int zzcbs() throws IOException {
        return zzcbz();
    }

    public final int zzcbz() throws IOException {
        byte zzccb = zzccb();
        if (zzccb >= 0) {
            return zzccb;
        }
        int i = zzccb & Byte.MAX_VALUE;
        byte zzccb2 = zzccb();
        if (zzccb2 >= 0) {
            return i | (zzccb2 << 7);
        }
        int i2 = i | ((zzccb2 & Byte.MAX_VALUE) << 7);
        byte zzccb3 = zzccb();
        if (zzccb3 >= 0) {
            return i2 | (zzccb3 << 14);
        }
        int i3 = i2 | ((zzccb3 & Byte.MAX_VALUE) << 14);
        byte zzccb4 = zzccb();
        if (zzccb4 >= 0) {
            return i3 | (zzccb4 << 21);
        }
        int i4 = i3 | ((zzccb4 & Byte.MAX_VALUE) << 21);
        byte zzccb5 = zzccb();
        int i5 = i4 | (zzccb5 << 28);
        if (zzccb5 < 0) {
            for (int i6 = 0; i6 < 5; i6++) {
                if (zzccb() >= 0) {
                    return i5;
                }
            }
            throw zzegn.zzced();
        }
        return i5;
    }

    public final long zzcdr() throws IOException {
        return zzcdu();
    }

    public final boolean zzcds() throws IOException {
        return zzcbz() != 0;
    }

    public final long zzcdt() throws IOException {
        long zzcdu = zzcdu();
        return (-(zzcdu & 1)) ^ (zzcdu >>> 1);
    }

    public final long zzcdu() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzccb = zzccb();
            j |= (zzccb & Byte.MAX_VALUE) << i;
            if ((zzccb & 128) == 0) {
                return j;
            }
        }
        throw zzegn.zzced();
    }

    public final int zzcdv() throws IOException {
        return (zzccb() & Constants.UNKNOWN) | ((zzccb() & Constants.UNKNOWN) << 8) | ((zzccb() & Constants.UNKNOWN) << 16) | ((zzccb() & Constants.UNKNOWN) << 24);
    }

    public final long zzcdw() throws IOException {
        byte zzccb = zzccb();
        byte zzccb2 = zzccb();
        return ((zzccb2 & 255) << 8) | (zzccb & 255) | ((zzccb() & 255) << 16) | ((zzccb() & 255) << 24) | ((zzccb() & 255) << 32) | ((zzccb() & 255) << 40) | ((zzccb() & 255) << 48) | ((zzccb() & 255) << 56);
    }

    public final int zzcdx() {
        if (this.zzmyf == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzmyf - this.zzncs;
    }

    public final void zzgk(int i) throws zzegn {
        if (this.zzmye != i) {
            throw new zzegn("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzgl(int i) throws IOException {
        int zzcbr;
        switch (i & 7) {
            case 0:
                zzcbz();
                return true;
            case 1:
                zzcdw();
                return true;
            case 2:
                zzgo(zzcbz());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzcdv();
                return true;
            default:
                throw new zzegn("Protocol message tag had invalid wire type.");
        }
        do {
            zzcbr = zzcbr();
            if (zzcbr != 0) {
            }
            zzgk(((i >>> 3) << 3) | 4);
            return true;
        } while (zzgl(zzcbr));
        zzgk(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzgm(int i) throws zzegn {
        if (i < 0) {
            throw zzegn.zzcec();
        }
        int i2 = this.zzncs + i;
        int i3 = this.zzmyf;
        if (i2 > i3) {
            throw zzegn.zzceb();
        }
        this.zzmyf = i2;
        zzcca();
        return i3;
    }

    public final void zzgn(int i) {
        this.zzmyf = i;
        zzcca();
    }

    public final void zzha(int i) {
        zzaa(i, this.zzmye);
    }

    public final byte[] zzz(int i, int i2) {
        if (i2 == 0) {
            return zzegr.zzndo;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzncq + i, bArr, 0, i2);
        return bArr;
    }
}
