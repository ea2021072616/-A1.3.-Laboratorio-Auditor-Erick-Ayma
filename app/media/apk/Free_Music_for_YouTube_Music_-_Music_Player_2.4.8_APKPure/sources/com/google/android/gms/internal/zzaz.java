package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzaz extends zzegi<zzaz> {
    private Long zzem = null;
    private Long zzen = null;
    public Long zzfu = null;
    public Long zzfv = null;
    public Long zzfw = null;

    public zzaz() {
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
                    this.zzem = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 16:
                    this.zzen = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 24:
                    this.zzfu = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 32:
                    this.zzfv = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 40:
                    this.zzfw = Long.valueOf(zzegfVar.zzcdu());
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
        if (this.zzem != null) {
            zzeggVar.zzb(1, this.zzem.longValue());
        }
        if (this.zzen != null) {
            zzeggVar.zzb(2, this.zzen.longValue());
        }
        if (this.zzfu != null) {
            zzeggVar.zzb(3, this.zzfu.longValue());
        }
        if (this.zzfv != null) {
            zzeggVar.zzb(4, this.zzfv.longValue());
        }
        if (this.zzfw != null) {
            zzeggVar.zzb(5, this.zzfw.longValue());
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzem != null) {
            zzn += zzegg.zze(1, this.zzem.longValue());
        }
        if (this.zzen != null) {
            zzn += zzegg.zze(2, this.zzen.longValue());
        }
        if (this.zzfu != null) {
            zzn += zzegg.zze(3, this.zzfu.longValue());
        }
        if (this.zzfv != null) {
            zzn += zzegg.zze(4, this.zzfv.longValue());
        }
        return this.zzfw != null ? zzn + zzegg.zze(5, this.zzfw.longValue()) : zzn;
    }
}
