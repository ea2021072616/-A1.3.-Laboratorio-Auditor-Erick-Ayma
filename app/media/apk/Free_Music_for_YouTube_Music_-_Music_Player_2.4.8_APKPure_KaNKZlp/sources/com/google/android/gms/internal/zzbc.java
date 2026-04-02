package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzbc extends zzegi<zzbc> {
    public byte[] data = null;
    public byte[] zzge = null;
    public byte[] zzgf = null;
    public byte[] zzgg = null;

    public zzbc() {
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
                    this.data = zzegfVar.readBytes();
                    break;
                case 18:
                    this.zzge = zzegfVar.readBytes();
                    break;
                case 26:
                    this.zzgf = zzegfVar.readBytes();
                    break;
                case 34:
                    this.zzgg = zzegfVar.readBytes();
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
        if (this.data != null) {
            zzeggVar.zzc(1, this.data);
        }
        if (this.zzge != null) {
            zzeggVar.zzc(2, this.zzge);
        }
        if (this.zzgf != null) {
            zzeggVar.zzc(3, this.zzgf);
        }
        if (this.zzgg != null) {
            zzeggVar.zzc(4, this.zzgg);
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.data != null) {
            zzn += zzegg.zzd(1, this.data);
        }
        if (this.zzge != null) {
            zzn += zzegg.zzd(2, this.zzge);
        }
        if (this.zzgf != null) {
            zzn += zzegg.zzd(3, this.zzgf);
        }
        return this.zzgg != null ? zzn + zzegg.zzd(4, this.zzgg) : zzn;
    }
}
