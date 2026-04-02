package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzzx implements Runnable {
    private /* synthetic */ zzzw zzcnn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzx(zzzw zzzwVar) {
        this.zzcnn = zzzwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzcnn.zzckm;
        synchronized (obj) {
            if (this.zzcnn.zzcnm == null) {
                return;
            }
            this.zzcnn.onStop();
            this.zzcnn.zzd(2, "Timed out waiting for ad response.");
        }
    }
}
