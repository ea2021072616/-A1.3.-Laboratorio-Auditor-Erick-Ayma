package com.google.android.gms.ads.internal.overlay;
/* loaded from: classes.dex */
final class zzj implements Runnable {
    private /* synthetic */ zzd zzcft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(zzd zzdVar) {
        this.zzcft = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzx zzxVar;
        zzx zzxVar2;
        zzx zzxVar3;
        zzxVar = this.zzcft.zzcfs;
        if (zzxVar != null) {
            zzxVar2 = this.zzcft.zzcfs;
            zzxVar2.onPaused();
            zzxVar3 = this.zzcft.zzcfs;
            zzxVar3.zzmz();
        }
    }
}
