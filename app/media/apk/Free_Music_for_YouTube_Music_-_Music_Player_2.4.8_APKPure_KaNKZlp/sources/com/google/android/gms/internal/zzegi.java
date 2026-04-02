package com.google.android.gms.internal;

import com.google.android.gms.internal.zzegi;
import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class zzegi<M extends zzegi<M>> extends zzego {
    protected zzegk zzncu;

    public final <T> T zza(zzegj<M, T> zzegjVar) {
        zzegl zzhf;
        if (this.zzncu == null || (zzhf = this.zzncu.zzhf(zzegjVar.tag >>> 3)) == null) {
            return null;
        }
        return (T) zzhf.zzb(zzegjVar);
    }

    @Override // com.google.android.gms.internal.zzego
    public void zza(zzegg zzeggVar) throws IOException {
        if (this.zzncu == null) {
            return;
        }
        for (int i = 0; i < this.zzncu.size(); i++) {
            this.zzncu.zzhg(i).zza(zzeggVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zza(zzegf zzegfVar, int i) throws IOException {
        int position = zzegfVar.getPosition();
        if (zzegfVar.zzgl(i)) {
            int i2 = i >>> 3;
            zzegq zzegqVar = new zzegq(i, zzegfVar.zzz(position, zzegfVar.getPosition() - position));
            zzegl zzeglVar = null;
            if (this.zzncu == null) {
                this.zzncu = new zzegk();
            } else {
                zzeglVar = this.zzncu.zzhf(i2);
            }
            if (zzeglVar == null) {
                zzeglVar = new zzegl();
                this.zzncu.zza(i2, zzeglVar);
            }
            zzeglVar.zza(zzegqVar);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzego
    /* renamed from: zzcdy */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        zzegm.zza(this, m);
        return m;
    }

    @Override // com.google.android.gms.internal.zzego
    public /* synthetic */ zzego zzcdz() throws CloneNotSupportedException {
        return (zzegi) clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzego
    public int zzn() {
        if (this.zzncu != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.zzncu.size(); i2++) {
                i += this.zzncu.zzhg(i2).zzn();
            }
            return i;
        }
        return 0;
    }
}
