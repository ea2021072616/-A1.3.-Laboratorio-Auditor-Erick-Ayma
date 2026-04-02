package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzegz extends zzegi<zzegz> {
    public Integer zzndp = null;
    public String mimeType = null;
    public byte[] zzner = null;

    public zzegz() {
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
                case 8:
                    int position = zzegfVar.getPosition();
                    int zzcbs = zzegfVar.zzcbs();
                    switch (zzcbs) {
                        case 0:
                        case 1:
                            this.zzndp = Integer.valueOf(zzcbs);
                            continue;
                        default:
                            zzegfVar.zzha(position);
                            zza(zzegfVar, zzcbr);
                            continue;
                    }
                case 18:
                    this.mimeType = zzegfVar.readString();
                    break;
                case 26:
                    this.zzner = zzegfVar.readBytes();
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
        if (this.zzndp != null) {
            zzeggVar.zzu(1, this.zzndp.intValue());
        }
        if (this.mimeType != null) {
            zzeggVar.zzl(2, this.mimeType);
        }
        if (this.zzner != null) {
            zzeggVar.zzc(3, this.zzner);
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzndp != null) {
            zzn += zzegg.zzv(1, this.zzndp.intValue());
        }
        if (this.mimeType != null) {
            zzn += zzegg.zzm(2, this.mimeType);
        }
        return this.zzner != null ? zzn + zzegg.zzd(3, this.zzner) : zzn;
    }
}
