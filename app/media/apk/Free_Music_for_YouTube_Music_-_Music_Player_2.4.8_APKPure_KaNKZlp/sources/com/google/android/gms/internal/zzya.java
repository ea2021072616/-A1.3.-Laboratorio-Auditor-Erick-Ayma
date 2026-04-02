package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzya implements Runnable {
    private /* synthetic */ zzafi zzaob;
    private /* synthetic */ zzxy zzckp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzya(zzxy zzxyVar, zzafi zzafiVar) {
        this.zzckp = zzxyVar;
        this.zzaob = zzafiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzckp.mLock) {
            zzxy zzxyVar = this.zzckp;
            zzxyVar.zzcki.zzb(this.zzaob);
        }
    }
}
