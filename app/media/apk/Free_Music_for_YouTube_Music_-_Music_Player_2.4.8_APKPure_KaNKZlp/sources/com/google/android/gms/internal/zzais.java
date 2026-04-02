package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzais implements Runnable {
    private /* synthetic */ zzaip zzddk;
    private /* synthetic */ zzajr zzddl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzais(zzaip zzaipVar, zzajr zzajrVar) {
        this.zzddk = zzaipVar;
        this.zzddl = zzajrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzv zzvVar;
        try {
            zzvVar = this.zzddk.zzcd;
            zzvVar.zzb(this.zzddl.get());
        } catch (Exception e) {
            zzafx.zzb("Error occured while dispatching http response in getter.", e);
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "HttpGetter.deliverResponse.1");
        }
    }
}
