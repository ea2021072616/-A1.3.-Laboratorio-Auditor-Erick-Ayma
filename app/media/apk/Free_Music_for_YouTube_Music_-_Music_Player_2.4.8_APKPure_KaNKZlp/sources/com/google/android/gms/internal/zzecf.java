package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public final class zzecf {
    private final byte[] zzmuo = new byte[256];
    private int zzmup;
    private int zzmuq;

    public zzecf(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzmuo[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + this.zzmuo[i3] + bArr[i3 % bArr.length]) & 255;
            byte b2 = this.zzmuo[i3];
            this.zzmuo[i3] = this.zzmuo[i2];
            this.zzmuo[i2] = b2;
        }
        this.zzmup = 0;
        this.zzmuq = 0;
    }

    public final void zzap(byte[] bArr) {
        int i = this.zzmup;
        int i2 = this.zzmuq;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.zzmuo[i]) & 255;
            byte b2 = this.zzmuo[i];
            this.zzmuo[i] = this.zzmuo[i2];
            this.zzmuo[i2] = b2;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzmuo[(this.zzmuo[i] + this.zzmuo[i2]) & 255]);
        }
        this.zzmup = i;
        this.zzmuq = i2;
    }
}
