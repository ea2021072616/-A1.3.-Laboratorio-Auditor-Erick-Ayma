package com.google.android.gms.ads.internal.overlay;
/* loaded from: classes.dex */
final class zzi implements Runnable {
    private /* synthetic */ zzd zzcft;
    private /* synthetic */ int zzcfw;
    private /* synthetic */ int zzcfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(zzd zzdVar, int i, int i2) {
        this.zzcft = zzdVar;
        this.zzcfw = i;
        this.zzcfx = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzx zzxVar;
        zzx zzxVar2;
        zzxVar = this.zzcft.zzcfs;
        if (zzxVar != null) {
            zzxVar2 = this.zzcft.zzcfs;
            zzxVar2.zzd(this.zzcfw, this.zzcfx);
        }
    }
}
