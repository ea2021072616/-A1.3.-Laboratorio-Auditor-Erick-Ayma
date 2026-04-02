package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzegu extends zzegi<zzegu> {
    private static volatile zzegu[] zznee;
    public byte[] zznef = null;
    public byte[] zzmpq = null;

    public zzegu() {
        this.zzncu = null;
        this.zzndd = -1;
    }

    public static zzegu[] zzceg() {
        if (zznee == null) {
            synchronized (zzegm.zzndc) {
                if (zznee == null) {
                    zznee = new zzegu[0];
                }
            }
        }
        return zznee;
    }

    @Override // com.google.android.gms.internal.zzego
    public final /* synthetic */ zzego zza(zzegf zzegfVar) throws IOException {
        while (true) {
            int zzcbr = zzegfVar.zzcbr();
            switch (zzcbr) {
                case 0:
                    break;
                case 10:
                    this.zznef = zzegfVar.readBytes();
                    break;
                case 18:
                    this.zzmpq = zzegfVar.readBytes();
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
        zzeggVar.zzc(1, this.zznef);
        if (this.zzmpq != null) {
            zzeggVar.zzc(2, this.zzmpq);
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn() + zzegg.zzd(1, this.zznef);
        return this.zzmpq != null ? zzn + zzegg.zzd(2, this.zzmpq) : zzn;
    }
}
