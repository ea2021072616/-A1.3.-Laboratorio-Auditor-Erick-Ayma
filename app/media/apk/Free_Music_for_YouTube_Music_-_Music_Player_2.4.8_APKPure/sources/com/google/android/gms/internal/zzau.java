package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzau extends zzegi<zzau> {
    public zzav zzcq = null;
    public zzaw zzcr = null;

    public zzau() {
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
                    if (this.zzcq == null) {
                        this.zzcq = new zzav();
                    }
                    zzegfVar.zza(this.zzcq);
                    break;
                case 18:
                    if (this.zzcr == null) {
                        this.zzcr = new zzaw();
                    }
                    zzegfVar.zza(this.zzcr);
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
        if (this.zzcq != null) {
            zzeggVar.zza(1, this.zzcq);
        }
        if (this.zzcr != null) {
            zzeggVar.zza(2, this.zzcr);
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzcq != null) {
            zzn += zzegg.zzb(1, this.zzcq);
        }
        return this.zzcr != null ? zzn + zzegg.zzb(2, this.zzcr) : zzn;
    }
}
