package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzaee implements Runnable {
    private /* synthetic */ zzafi zzaob;
    private /* synthetic */ zzaec zzcwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaee(zzaec zzaecVar, zzafi zzafiVar) {
        this.zzcwt = zzaecVar;
        this.zzaob = zzafiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzacy zzacyVar;
        zzacyVar = this.zzcwt.zzcws;
        zzacyVar.zzb(this.zzaob);
    }
}
