package com.google.android.gms.ads.internal.overlay;
/* loaded from: classes.dex */
final class zzk implements Runnable {
    private /* synthetic */ zzd zzcft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(zzd zzdVar) {
        this.zzcft = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzx zzxVar;
        zzx zzxVar2;
        zzxVar = this.zzcft.zzcfs;
        if (zzxVar != null) {
            zzxVar2 = this.zzcft.zzcfs;
            zzxVar2.zzmx();
        }
    }
}
