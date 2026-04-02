package com.google.android.gms.internal;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzedv extends zzedt {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzmyb;
    private int zzmyc;
    private int zzmyd;
    private int zzmye;
    private int zzmyf;

    private zzedv(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzmyf = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.buffer = bArr;
        this.limit = i + i2;
        this.pos = i;
        this.zzmyd = this.pos;
        this.zzmyb = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
        if (r3[r2] < 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzcbz() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L6c
            byte[] r3 = r5.buffer
            int r2 = r0 + 1
            r0 = r3[r0]
            if (r0 < 0) goto L11
            r5.pos = r2
        L10:
            return r0
        L11:
            int r1 = r5.limit
            int r1 = r1 - r2
            r4 = 9
            if (r1 < r4) goto L6c
            int r1 = r2 + 1
            r2 = r3[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            if (r0 >= 0) goto L26
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
        L23:
            r5.pos = r1
            goto L10
        L26:
            int r2 = r1 + 1
            r1 = r3[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L33
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            r1 = r2
            goto L23
        L33:
            int r1 = r2 + 1
            r2 = r3[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            if (r0 >= 0) goto L41
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L23
        L41:
            int r2 = r1 + 1
            r1 = r3[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L72
            int r1 = r2 + 1
            r2 = r3[r2]
            if (r2 >= 0) goto L23
            int r2 = r1 + 1
            r1 = r3[r1]
            if (r1 >= 0) goto L72
            int r1 = r2 + 1
            r2 = r3[r2]
            if (r2 >= 0) goto L23
            int r2 = r1 + 1
            r1 = r3[r1]
            if (r1 >= 0) goto L72
            int r1 = r2 + 1
            r2 = r3[r2]
            if (r2 >= 0) goto L23
        L6c:
            long r0 = r5.zzcbw()
            int r0 = (int) r0
            goto L10
        L72:
            r1 = r2
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzedv.zzcbz():int");
    }

    private final void zzcca() {
        this.limit += this.zzmyc;
        int i = this.limit - this.zzmyd;
        if (i <= this.zzmyf) {
            this.zzmyc = 0;
            return;
        }
        this.zzmyc = i - this.zzmyf;
        this.limit -= this.zzmyc;
    }

    private final byte zzccb() throws IOException {
        if (this.pos == this.limit) {
            throw zzeer.zzcct();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.zzedt
    public final <T extends zzeed<T, ?>> T zza(T t, zzedz zzedzVar) throws IOException {
        int zzcbz = zzcbz();
        if (this.zzmxy >= this.zzmxz) {
            throw zzeer.zzccw();
        }
        int zzgm = zzgm(zzcbz);
        this.zzmxy++;
        T t2 = (T) zzeed.zza(t, this, zzedzVar);
        zzgk(0);
        this.zzmxy--;
        zzgn(zzgm);
        return t2;
    }

    @Override // com.google.android.gms.internal.zzedt
    public final int zzcbr() throws IOException {
        if (zzcbx()) {
            this.zzmye = 0;
            return 0;
        }
        this.zzmye = zzcbz();
        if ((this.zzmye >>> 3) == 0) {
            throw new zzeer("Protocol message contained an invalid tag (zero).");
        }
        return this.zzmye;
    }

    @Override // com.google.android.gms.internal.zzedt
    public final int zzcbs() throws IOException {
        return zzcbz();
    }

    @Override // com.google.android.gms.internal.zzedt
    public final String zzcbt() throws IOException {
        int zzcbz = zzcbz();
        if (zzcbz <= 0 || zzcbz > this.limit - this.pos) {
            if (zzcbz == 0) {
                return "";
            }
            if (zzcbz <= 0) {
                throw zzeer.zzccu();
            }
            throw zzeer.zzcct();
        } else if (zzeft.zze(this.buffer, this.pos, this.pos + zzcbz)) {
            int i = this.pos;
            this.pos += zzcbz;
            return new String(this.buffer, i, zzcbz, zzeen.UTF_8);
        } else {
            throw new zzeer("Protocol message had invalid UTF-8.");
        }
    }

    @Override // com.google.android.gms.internal.zzedt
    public final zzedk zzcbu() throws IOException {
        byte[] bArr;
        int zzcbz = zzcbz();
        if (zzcbz > 0 && zzcbz <= this.limit - this.pos) {
            zzedk zzc = zzedk.zzc(this.buffer, this.pos, zzcbz);
            this.pos = zzcbz + this.pos;
            return zzc;
        } else if (zzcbz == 0) {
            return zzedk.zzmxr;
        } else {
            if (zzcbz > 0 && zzcbz <= this.limit - this.pos) {
                int i = this.pos;
                this.pos = zzcbz + this.pos;
                bArr = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzcbz > 0) {
                throw zzeer.zzcct();
            } else {
                if (zzcbz != 0) {
                    throw zzeer.zzccu();
                }
                bArr = zzeen.EMPTY_BYTE_ARRAY;
            }
            return zzedk.zzar(bArr);
        }
    }

    @Override // com.google.android.gms.internal.zzedt
    public final int zzcbv() throws IOException {
        return zzcbz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.zzedt
    public final long zzcbw() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzccb = zzccb();
            j |= (zzccb & Byte.MAX_VALUE) << i;
            if ((zzccb & 128) == 0) {
                return j;
            }
        }
        throw zzeer.zzccv();
    }

    @Override // com.google.android.gms.internal.zzedt
    public final boolean zzcbx() throws IOException {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.zzedt
    public final int zzcby() {
        return this.pos - this.zzmyd;
    }

    @Override // com.google.android.gms.internal.zzedt
    public final void zzgk(int i) throws zzeer {
        if (this.zzmye != i) {
            throw new zzeer("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.zzedt
    public final boolean zzgl(int i) throws IOException {
        int zzcbr;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos < 10) {
                    while (i2 < 10) {
                        if (zzccb() >= 0) {
                            return true;
                        }
                        i2++;
                    }
                    throw zzeer.zzccv();
                }
                while (i2 < 10) {
                    byte[] bArr = this.buffer;
                    int i3 = this.pos;
                    this.pos = i3 + 1;
                    if (bArr[i3] >= 0) {
                        return true;
                    }
                    i2++;
                }
                throw zzeer.zzccv();
            case 1:
                zzgo(8);
                return true;
            case 2:
                zzgo(zzcbz());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzgo(4);
                return true;
            default:
                throw new zzees("Protocol message tag had invalid wire type.");
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

    @Override // com.google.android.gms.internal.zzedt
    public final int zzgm(int i) throws zzeer {
        if (i < 0) {
            throw zzeer.zzccu();
        }
        int zzcby = zzcby() + i;
        int i2 = this.zzmyf;
        if (zzcby > i2) {
            throw zzeer.zzcct();
        }
        this.zzmyf = zzcby;
        zzcca();
        return i2;
    }

    @Override // com.google.android.gms.internal.zzedt
    public final void zzgn(int i) {
        this.zzmyf = i;
        zzcca();
    }

    @Override // com.google.android.gms.internal.zzedt
    public final void zzgo(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i >= 0) {
            throw zzeer.zzcct();
        } else {
            throw zzeer.zzccu();
        }
    }
}
