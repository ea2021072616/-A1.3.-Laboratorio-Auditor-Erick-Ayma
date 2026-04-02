package com.google.android.gms.internal;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzaw extends zzegi<zzaw> {
    public String zzct = null;
    private String zzcu = null;
    private String zzcv = null;
    private String zzcw = null;
    private String zzcx = null;

    public zzaw() {
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
                    this.zzct = zzegfVar.readString();
                    break;
                case 18:
                    this.zzcu = zzegfVar.readString();
                    break;
                case 26:
                    this.zzcv = zzegfVar.readString();
                    break;
                case 34:
                    this.zzcw = zzegfVar.readString();
                    break;
                case 42:
                    this.zzcx = zzegfVar.readString();
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
        if (this.zzct != null) {
            zzeggVar.zzl(1, this.zzct);
        }
        if (this.zzcu != null) {
            zzeggVar.zzl(2, this.zzcu);
        }
        if (this.zzcv != null) {
            zzeggVar.zzl(3, this.zzcv);
        }
        if (this.zzcw != null) {
            zzeggVar.zzl(4, this.zzcw);
        }
        if (this.zzcx != null) {
            zzeggVar.zzl(5, this.zzcx);
        }
        super.zza(zzeggVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzegi, com.google.android.gms.internal.zzego
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzct != null) {
            zzn += zzegg.zzm(1, this.zzct);
        }
        if (this.zzcu != null) {
            zzn += zzegg.zzm(2, this.zzcu);
        }
        if (this.zzcv != null) {
            zzn += zzegg.zzm(3, this.zzcv);
        }
        if (this.zzcw != null) {
            zzn += zzegg.zzm(4, this.zzcw);
        }
        return this.zzcx != null ? zzn + zzegg.zzm(5, this.zzcx) : zzn;
    }
}
