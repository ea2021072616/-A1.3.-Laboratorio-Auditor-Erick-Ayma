package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzyg implements Runnable {
    private /* synthetic */ zzafi zzckq;
    private /* synthetic */ zzyf zzckr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyg(zzyf zzyfVar, zzafi zzafiVar) {
        this.zzckr = zzyfVar;
        this.zzckq = zzafiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzyd zzydVar;
        zzydVar = this.zzckr.zzcki;
        zzydVar.zzb(this.zzckq);
    }
}
