package com.google.android.gms.ads.internal.overlay;
/* loaded from: classes.dex */
final class zzac implements Runnable {
    private /* synthetic */ zzaa zzchy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(zzaa zzaaVar) {
        this.zzchy = zzaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzchy.zza("surfaceDestroyed", new String[0]);
    }
}
