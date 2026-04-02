package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzbd extends zzegi<zzbd> {
    public Long zzfx = null;
    private String zzgh = null;
    private byte[] zzgi = null;

    public zzbd() {
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
                case 26:
                    this.zzgh = zzegfVar.readString();
                    break;
                case 34:
                    this.zzgi = zzegfVar.readBytes();
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
        if (this.zzgh != null) {
            zzeggVar.zzl(3, this.zzgh);
        }
        if (this.zzgi != null) {
            zzeggVar.zzc(4, this.zzgi);
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
        if (this.zzgh != null) {
            zzn += zzegg.zzm(3, this.zzgh);
        }
        return this.zzgi != null ? zzn + zzegg.zzd(4, this.zzgi) : zzn;
    }
}
