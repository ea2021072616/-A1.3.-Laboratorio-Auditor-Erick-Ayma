package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzat extends zzegi<zzat> {
    public String zzch = null;
    public Long zzci = null;
    private String stackTrace = null;
    private String zzcj = null;
    private String zzck = null;
    private Long zzcl = null;
    private Long zzcm = null;
    private String zzcn = null;
    private Long zzco = null;
    private String zzcp = null;

    public zzat() {
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
                    this.zzch = zzegfVar.readString();
                    break;
                case 16:
                    this.zzci = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 26:
                    this.stackTrace = zzegfVar.readString();
                    break;
                case 34:
                    this.zzcj = zzegfVar.readString();
                    break;
                case 42:
                    this.zzck = zzegfVar.readString();
                    break;
                case 48:
                    this.zzcl = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 56:
                    this.zzcm = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 66:
                    this.zzcn = zzegfVar.readString();
                    break;
                case 72:
                    this.zzco = Long.valueOf(zzegfVar.zzcdu());
                    break;
                case 82:
                    this.zzcp = zzegfVar.readString();
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
        if (this.zzch != null) {
            zzeggVar.zzl(1, this.zzch);
        }
        if (this.zzci != null) {
            zzeggVar.zzb(2, this.zzci.longValue());
        }
        if (this.stackTrace != null) {
            zzeggVar.zzl(3, this.stackTrace);
        }
        if (this.zzcj != null) {
            zzeggVar.zzl(4, this.zzcj);
        }
        if (this.zzck != null) {
            zzeggVar.zzl(5, this.zzck);
        }
        if (this.zzcl != null) {
            zzeggVar.zzb(6, this.zzcl.longValue());
        }
        if (this.zzcm != null) {
            zzeggVar.zzb(7, this.zzcm.longValue());
        }
        if (this.zzcn != null) {
            zzeggVar.zzl(8, this.zzcn);
        }
        if (this.zzco != null) {
            zzeggVar.zzb(9, this.zzco.longValue());
        }
        if (this.zzcp != null) {
            zzeggVar.zzl(10, this.zzcp);
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzch != null) {
            zzn += zzegg.zzm(1, this.zzch);
        }
        if (this.zzci != null) {
            zzn += zzegg.zze(2, this.zzci.longValue());
        }
        if (this.stackTrace != null) {
            zzn += zzegg.zzm(3, this.stackTrace);
        }
        if (this.zzcj != null) {
            zzn += zzegg.zzm(4, this.zzcj);
        }
        if (this.zzck != null) {
            zzn += zzegg.zzm(5, this.zzck);
        }
        if (this.zzcl != null) {
            zzn += zzegg.zze(6, this.zzcl.longValue());
        }
        if (this.zzcm != null) {
            zzn += zzegg.zze(7, this.zzcm.longValue());
        }
        if (this.zzcn != null) {
            zzn += zzegg.zzm(8, this.zzcn);
        }
        if (this.zzco != null) {
            zzn += zzegg.zze(9, this.zzco.longValue());
        }
        return this.zzcp != null ? zzn + zzegg.zzm(10, this.zzcp) : zzn;
    }
}
