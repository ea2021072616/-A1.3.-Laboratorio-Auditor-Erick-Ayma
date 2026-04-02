package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzadt implements Runnable {
    private /* synthetic */ zzix zzape;
    private /* synthetic */ zzvd zzcwf;
    private /* synthetic */ zzads zzcwg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadt(zzads zzadsVar, zzix zzixVar, zzvd zzvdVar) {
        this.zzcwg = zzadsVar;
        this.zzape = zzixVar;
        this.zzcwf = zzvdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcwg.zza(this.zzape, this.zzcwf);
    }
}
