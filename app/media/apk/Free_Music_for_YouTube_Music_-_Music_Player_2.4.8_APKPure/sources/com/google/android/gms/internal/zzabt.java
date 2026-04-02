package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzabt implements Runnable {
    final /* synthetic */ zznh zzang;
    private /* synthetic */ com.google.android.gms.ads.internal.js.zzl zzaof;
    final /* synthetic */ zzaca zzcsa;
    private /* synthetic */ zznf zzcsb;
    final /* synthetic */ String zzcsc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabt(com.google.android.gms.ads.internal.js.zzl zzlVar, zzaca zzacaVar, zznh zznhVar, zznf zznfVar, String str) {
        this.zzaof = zzlVar;
        this.zzcsa = zzacaVar;
        this.zzang = zznhVar;
        this.zzcsb = zznfVar;
        this.zzcsc = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.js.zzy zzb = this.zzaof.zzb((zzcv) null);
        this.zzcsa.zzcsn = zzb;
        this.zzang.zza(this.zzcsb, "rwc");
        zzb.zza(new zzabu(this, this.zzang.zziu()), new zzabv(this));
    }
}
