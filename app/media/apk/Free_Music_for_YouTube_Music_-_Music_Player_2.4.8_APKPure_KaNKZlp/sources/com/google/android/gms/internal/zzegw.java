package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzegw extends zzegi<zzegw> {
    private byte[] zznek = null;
    private byte[] zznel = null;
    private byte[] zznem = null;

    public zzegw() {
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
                    this.zznek = zzegfVar.readBytes();
                    break;
                case 18:
                    this.zznel = zzegfVar.readBytes();
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
        if (this.zznek != null) {
            zzeggVar.zzc(1, this.zznek);
        }
        if (this.zznel != null) {
            zzeggVar.zzc(2, this.zznel);
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
        if (this.zznek != null) {
            zzn += zzegg.zzd(1, this.zznek);
        }
        if (this.zznel != null) {
            zzn += zzegg.zzd(2, this.zznel);
        }
        return this.zznem != null ? zzn + zzegg.zzd(3, this.zznem) : zzn;
    }
}
