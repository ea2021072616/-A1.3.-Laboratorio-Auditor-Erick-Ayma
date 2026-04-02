package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzyl implements Runnable {
    private /* synthetic */ zzafi zzaob;
    private /* synthetic */ zzyk zzclb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyl(zzyk zzykVar, zzafi zzafiVar) {
        this.zzclb = zzykVar;
        this.zzaob = zzafiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzyd zzydVar;
        zzydVar = this.zzclb.zzcki;
        zzydVar.zzb(this.zzaob);
    }
}
