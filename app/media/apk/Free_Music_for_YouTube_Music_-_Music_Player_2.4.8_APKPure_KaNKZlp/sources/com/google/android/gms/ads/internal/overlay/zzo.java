package com.google.android.gms.ads.internal.overlay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzo implements Runnable {
    private /* synthetic */ zzm zzcgr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzm zzmVar) {
        this.zzcgr = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcgr.zzmq();
    }
}
