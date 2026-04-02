package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzafw implements Runnable {
    private /* synthetic */ zzafv zzdau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafw(zzafv zzafvVar) {
        this.zzdau = zzafvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdau.zzdas = Thread.currentThread();
        this.zzdau.zzdc();
    }
}
