package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzbe extends zzegi<zzbe> {
    private Integer zzgk;
    public Integer zzgl;
    public byte[][] zzgj = zzegr.zzndn;
    public byte[] zzge = null;

    public zzbe() {
        this.zzndd = -1;
    }

    @Override // com.google.android.gms.internal.zzego
    public final /* synthetic */ zzego zza(zzegf zzegfVar) throws IOException {
        while (true) {
            int zzcbr = zzegfVar.zzcbr();
            switch (zzcbr) {
                case 0:
                    break;
                case 10:
                    int zzb = zzegr.zzb(zzegfVar, 10);
                    int length = this.zzgj == null ? 0 : this.zzgj.length;
                    byte[][] bArr = new byte[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzgj, 0, bArr, 0, length);
                    }
                    while (length < bArr.length - 1) {
                        bArr[length] = zzegfVar.readBytes();
                        zzegfVar.zzcbr();
                        length++;
                    }
                    bArr[length] = zzegfVar.readBytes();
                    this.zzgj = bArr;
                    break;
                case 18:
                    this.zzge = zzegfVar.readBytes();
                    break;
                case 24:
                    int position = zzegfVar.getPosition();
                    int zzcbz = zzegfVar.zzcbz();
                    switch (zzcbz) {
                        case 0:
                        case 1:
                            this.zzgk = Integer.valueOf(zzcbz);
                            continue;
                        default:
                            zzegfVar.zzha(position);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case 32:
                    int position2 = zzegfVar.getPosition();
                    int zzcbz2 = zzegfVar.zzcbz();
                    switch (zzcbz2) {
                        case 0:
                        case 1:
                        case 2:
                            this.zzgl = Integer.valueOf(zzcbz2);
                            continue;
                        default:
                            zzegfVar.zzha(position2);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                default:
                    if (!super.zza(zzegfVar, zzcbr)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final void zza(zzegg zzeggVar) throws IOException {
        if (this.zzgj != null && this.zzgj.length > 0) {
            for (int i = 0; i < this.zzgj.length; i++) {
                byte[] bArr = this.zzgj[i];
                if (bArr != null) {
                    zzeggVar.zzc(1, bArr);
                }
            }
        }
        if (this.zzge != null) {
            zzeggVar.zzc(2, this.zzge);
        }
        if (this.zzgk != null) {
            zzeggVar.zzu(3, this.zzgk.intValue());
        }
        if (this.zzgl != null) {
            zzeggVar.zzu(4, this.zzgl.intValue());
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int i;
        int zzn = super.zzn();
        if (this.zzgj == null || this.zzgj.length <= 0) {
            i = zzn;
        } else {
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < this.zzgj.length; i4++) {
                byte[] bArr = this.zzgj[i4];
                if (bArr != null) {
                    i3++;
                    i2 += zzegg.zzaw(bArr);
                }
            }
            i = zzn + i2 + (i3 * 1);
        }
        if (this.zzge != null) {
            i += zzegg.zzd(2, this.zzge);
        }
        if (this.zzgk != null) {
            i += zzegg.zzv(3, this.zzgk.intValue());
        }
        return this.zzgl != null ? i + zzegg.zzv(4, this.zzgl.intValue()) : i;
    }
}
