package com.google.android.gms.ads.internal.overlay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzg implements Runnable {
    private /* synthetic */ zzd zzcft;
    private /* synthetic */ String zzcfu;
    private /* synthetic */ String zzcfv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zzd zzdVar, String str, String str2) {
        this.zzcft = zzdVar;
        this.zzcfu = str;
        this.zzcfv = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzx zzxVar;
        zzx zzxVar2;
        zzxVar = this.zzcft.zzcfs;
        if (zzxVar != null) {
            zzxVar2 = this.zzcft.zzcfs;
            zzxVar2.zzj(this.zzcfu, this.zzcfv);
        }
    }
}
