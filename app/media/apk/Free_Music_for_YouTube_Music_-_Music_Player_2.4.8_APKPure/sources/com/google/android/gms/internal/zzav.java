package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzav extends zzegi<zzav> {
    public Integer zzcs;

    public zzav() {
        this.zzndd = -1;
    }

    @Override // com.google.android.gms.internal.zzego
    public final /* synthetic */ zzego zza(zzegf zzegfVar) throws IOException {
        while (true) {
            int zzcbr = zzegfVar.zzcbr();
            switch (zzcbr) {
                case 0:
                    break;
                case 216:
                    int position = zzegfVar.getPosition();
                    int zzcbz = zzegfVar.zzcbz();
                    switch (zzcbz) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.zzcs = Integer.valueOf(zzcbz);
                            continue;
                        default:
                            zzegfVar.zzha(position);
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
        if (this.zzcs != null) {
            zzeggVar.zzu(27, this.zzcs.intValue());
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        return this.zzcs != null ? zzn + zzegg.zzv(27, this.zzcs.intValue()) : zzn;
    }
}
