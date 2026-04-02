package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzba extends zzegi<zzba> {
    private Long zzfx = null;
    private Integer zzfy = null;
    private Boolean zzfz = null;
    private int[] zzga = zzegr.zzndi;
    private Long zzgb = null;

    public zzba() {
        this.zzndd = -1;
    }

    @Override // com.google.android.gms.internal.zzego
    public final /* synthetic */ zzego zza(zzegf zzegfVar) throws IOException {
        while (true) {
            int zzcbr = zzegfVar.zzcbr();
            switch (zzcbr) {
                case 0:
                    break;
                case 8:
                    this.zzfx = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 16:
                    this.zzfy = Integer.valueOf(zzegfVar.zzcbz());
                    break;
                case 24:
                    this.zzfz = Boolean.valueOf(zzegfVar.zzcds());
                    break;
                case 32:
                    int zzb = zzegr.zzb(zzegfVar, 32);
                    int length = this.zzga == null ? 0 : this.zzga.length;
                    int[] iArr = new int[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzga, 0, iArr, 0, length);
                    }
                    while (length < iArr.length - 1) {
                        iArr[length] = zzegfVar.zzcbz();
                        zzegfVar.zzcbr();
                        length++;
                    }
                    iArr[length] = zzegfVar.zzcbz();
                    this.zzga = iArr;
                    break;
                case 34:
                    int zzgm = zzegfVar.zzgm(zzegfVar.zzcbz());
                    int position = zzegfVar.getPosition();
                    int i = 0;
                    while (zzegfVar.zzcdx() > 0) {
                        zzegfVar.zzcbz();
                        i++;
                    }
                    zzegfVar.zzha(position);
                    int length2 = this.zzga == null ? 0 : this.zzga.length;
                    int[] iArr2 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzga, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length) {
                        iArr2[length2] = zzegfVar.zzcbz();
                        length2++;
                    }
                    this.zzga = iArr2;
                    zzegfVar.zzgn(zzgm);
                    break;
                case 40:
                    this.zzgb = Long.valueOf(zzegfVar.zzcdu());
                    break;
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
        if (this.zzfx != null) {
            zzeggVar.zzb(1, this.zzfx.longValue());
        }
        if (this.zzfy != null) {
            zzeggVar.zzu(2, this.zzfy.intValue());
        }
        if (this.zzfz != null) {
            zzeggVar.zzl(3, this.zzfz.booleanValue());
        }
        if (this.zzga != null && this.zzga.length > 0) {
            for (int i = 0; i < this.zzga.length; i++) {
                zzeggVar.zzu(4, this.zzga[i]);
            }
        }
        if (this.zzgb != null) {
            zzeggVar.zza(5, this.zzgb.longValue());
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzfx != null) {
            zzn += zzegg.zze(1, this.zzfx.longValue());
        }
        if (this.zzfy != null) {
            zzn += zzegg.zzv(2, this.zzfy.intValue());
        }
        if (this.zzfz != null) {
            this.zzfz.booleanValue();
            zzn += zzegg.zzgr(3) + 1;
        }
        if (this.zzga != null && this.zzga.length > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.zzga.length; i2++) {
                i += zzegg.zzgs(this.zzga[i2]);
            }
            zzn = zzn + i + (this.zzga.length * 1);
        }
        if (this.zzgb != null) {
            return zzn + zzegg.zzgr(5) + zzegg.zzcp(this.zzgb.longValue());
        }
        return zzn;
    }
}
