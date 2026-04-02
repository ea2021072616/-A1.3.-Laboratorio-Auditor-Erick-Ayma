package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzehb extends zzegi<zzehb> {
    public String zznfa = null;
    public Long zznfb = null;
    public Boolean zznfc = null;

    public zzehb() {
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
                    this.zznfa = zzegfVar.readString();
                    break;
                case 16:
                    this.zznfb = Long.valueOf(zzegfVar.zzcdr());
                    break;
                case 24:
                    this.zznfc = Boolean.valueOf(zzegfVar.zzcds());
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
        if (this.zznfa != null) {
            zzeggVar.zzl(1, this.zznfa);
        }
        if (this.zznfb != null) {
            zzeggVar.zzb(2, this.zznfb.longValue());
        }
        if (this.zznfc != null) {
            zzeggVar.zzl(3, this.zznfc.booleanValue());
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zznfa != null) {
            zzn += zzegg.zzm(1, this.zznfa);
        }
        if (this.zznfb != null) {
            zzn += zzegg.zze(2, this.zznfb.longValue());
        }
        if (this.zznfc != null) {
            this.zznfc.booleanValue();
            return zzn + zzegg.zzgr(3) + 1;
        }
        return zzn;
    }
}
