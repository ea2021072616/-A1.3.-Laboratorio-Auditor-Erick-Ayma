package com.google.android.gms.internal;

import android.os.Handler;
/* loaded from: classes2.dex */
final class zzzy implements Runnable {
    private /* synthetic */ zzzw zzcnn;
    private /* synthetic */ zzajz zzcno;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzy(zzzw zzzwVar, zzajz zzajzVar) {
        this.zzcnn = zzzwVar;
        this.zzcno = zzajzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        zzaal zzaalVar;
        Runnable runnable;
        obj = this.zzcnn.zzckm;
        synchronized (obj) {
            zzzw zzzwVar = this.zzcnn;
            zzzw zzzwVar2 = this.zzcnn;
            zzaalVar = this.zzcnn.zzcnk;
            zzzwVar.zzcnm = zzzwVar2.zza(zzaalVar.zzatj, this.zzcno);
            if (this.zzcnn.zzcnm == null) {
                this.zzcnn.zzd(0, "Could not start the ad request service.");
                Handler handler = zzahf.zzdbo;
                runnable = this.zzcnn.zzckl;
                handler.removeCallbacks(runnable);
            }
        }
    }
}
