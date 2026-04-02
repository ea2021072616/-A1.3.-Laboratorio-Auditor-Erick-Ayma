package com.google.android.gms.ads.internal.overlay;
/* loaded from: classes.dex */
final class zzab implements Runnable {
    private /* synthetic */ zzaa zzchy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(zzaa zzaaVar) {
        this.zzchy = zzaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzchy.zza("surfaceCreated", new String[0]);
    }
}
