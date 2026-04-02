package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzada implements Runnable {
    private /* synthetic */ zzafj zzamz;
    private /* synthetic */ zzacy zzcvv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzada(zzacy zzacyVar, zzafj zzafjVar) {
        this.zzcvv = zzacyVar;
        this.zzamz = zzafjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcvv.zzb(new zzafi(this.zzamz, null, null, null, null, null, null, null));
    }
}
