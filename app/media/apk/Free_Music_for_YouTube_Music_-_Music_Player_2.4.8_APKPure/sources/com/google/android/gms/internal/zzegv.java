package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzegv extends zzegi<zzegv> {
    private zzegw zzneg = null;
    public zzegu[] zzneh = zzegu.zzceg();
    private byte[] body = null;
    private byte[] zznei = null;
    private Integer zznej = null;

    public zzegv() {
        this.zzncu = null;
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
                    if (this.zzneg == null) {
                        this.zzneg = new zzegw();
                    }
                    zzegfVar.zza(this.zzneg);
                    break;
                case 18:
                    int zzb = zzegr.zzb(zzegfVar, 18);
                    int length = this.zzneh == null ? 0 : this.zzneh.length;
                    zzegu[] zzeguVarArr = new zzegu[zzb + length];
                    if (length != 0) {
                        System.arraycopy(this.zzneh, 0, zzeguVarArr, 0, length);
                    }
                    while (length < zzeguVarArr.length - 1) {
                        zzeguVarArr[length] = new zzegu();
                        zzegfVar.zza(zzeguVarArr[length]);
                        zzegfVar.zzcbr();
                        length++;
                    }
                    zzeguVarArr[length] = new zzegu();
                    zzegfVar.zza(zzeguVarArr[length]);
                    this.zzneh = zzeguVarArr;
                    break;
                case 26:
                    this.body = zzegfVar.readBytes();
                    break;
                case 34:
                    this.zznei = zzegfVar.readBytes();
                    break;
                case 40:
                    this.zznej = Integer.valueOf(zzegfVar.zzcbs());
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
        if (this.zzneg != null) {
            zzeggVar.zza(1, this.zzneg);
        }
        if (this.zzneh != null && this.zzneh.length > 0) {
            for (int i = 0; i < this.zzneh.length; i++) {
                zzegu zzeguVar = this.zzneh[i];
                if (zzeguVar != null) {
                    zzeggVar.zza(2, zzeguVar);
                }
            }
        }
        if (this.body != null) {
            zzeggVar.zzc(3, this.body);
        }
        if (this.zznei != null) {
            zzeggVar.zzc(4, this.zznei);
        }
        if (this.zznej != null) {
            zzeggVar.zzu(5, this.zznej.intValue());
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzneg != null) {
            zzn += zzegg.zzb(1, this.zzneg);
        }
        if (this.zzneh != null && this.zzneh.length > 0) {
            int i = zzn;
            for (int i2 = 0; i2 < this.zzneh.length; i2++) {
                zzegu zzeguVar = this.zzneh[i2];
                if (zzeguVar != null) {
                    i += zzegg.zzb(2, zzeguVar);
                }
            }
            zzn = i;
        }
        if (this.body != null) {
            zzn += zzegg.zzd(3, this.body);
        }
        if (this.zznei != null) {
            zzn += zzegg.zzd(4, this.zznei);
        }
        return this.zznej != null ? zzn + zzegg.zzv(5, this.zznej.intValue()) : zzn;
    }
}
