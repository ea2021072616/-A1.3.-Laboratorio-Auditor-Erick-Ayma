package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzegy extends zzegi<zzegy> {
    private Integer zznep = null;
    private byte[] zzneq = null;
    private byte[] zznem = null;

    public zzegy() {
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
                    this.zznep = Integer.valueOf(zzegfVar.zzcbs());
                    break;
                case 18:
                    this.zzneq = zzegfVar.readBytes();
                    break;
                case 26:
                    this.zznem = zzegfVar.readBytes();
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
        if (this.zznep != null) {
            zzeggVar.zzu(1, this.zznep.intValue());
        }
        if (this.zzneq != null) {
            zzeggVar.zzc(2, this.zzneq);
        }
        if (this.zznem != null) {
            zzeggVar.zzc(3, this.zznem);
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zznep != null) {
            zzn += zzegg.zzv(1, this.zznep.intValue());
        }
        if (this.zzneq != null) {
            zzn += zzegg.zzd(2, this.zzneq);
        }
        return this.zznem != null ? zzn + zzegg.zzd(3, this.zznem) : zzn;
    }
}
