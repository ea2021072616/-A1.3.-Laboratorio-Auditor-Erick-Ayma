package com.google.android.gms.ads.internal.js;
/* loaded from: classes.dex */
final class zzp implements Runnable {
    private /* synthetic */ zzo zzbze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzo zzoVar) {
        this.zzbze = zzoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbze.zzbzd.zzbzb.destroy();
    }
}
