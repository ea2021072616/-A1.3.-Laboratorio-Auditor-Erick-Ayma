package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzabg implements Runnable {
    private /* synthetic */ zzafj zzamz;
    private /* synthetic */ zzabf zzcrc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabg(zzabf zzabfVar, zzafj zzafjVar) {
        this.zzcrc = zzabfVar;
        this.zzamz = zzafjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzzv zzzvVar;
        com.google.android.gms.ads.internal.js.zzy zzyVar;
        com.google.android.gms.ads.internal.js.zzy zzyVar2;
        zzzvVar = this.zzcrc.zzcnj;
        zzzvVar.zza(this.zzamz);
        zzyVar = this.zzcrc.zzcrb;
        if (zzyVar != null) {
            zzyVar2 = this.zzcrc.zzcrb;
            zzyVar2.release();
            this.zzcrc.zzcrb = null;
        }
    }
}
