package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzdf implements Runnable {
    private /* synthetic */ zzdc zzaiv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdf(zzdc zzdcVar) {
        this.zzaiv = zzdcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmu.initialize(this.zzaiv.zzaie);
    }
}
