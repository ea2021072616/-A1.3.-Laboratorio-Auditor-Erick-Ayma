package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzbb extends zzegi<zzbb> {
    public byte[] zzgc = null;
    public byte[] zzgd = null;

    public zzbb() {
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
                    this.zzgc = zzegfVar.readBytes();
                    break;
                case 18:
                    this.zzgd = zzegfVar.readBytes();
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
        if (this.zzgc != null) {
            zzeggVar.zzc(1, this.zzgc);
        }
        if (this.zzgd != null) {
            zzeggVar.zzc(2, this.zzgd);
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzgc != null) {
            zzn += zzegg.zzd(1, this.zzgc);
        }
        return this.zzgd != null ? zzn + zzegg.zzd(2, this.zzgd) : zzn;
    }
}
