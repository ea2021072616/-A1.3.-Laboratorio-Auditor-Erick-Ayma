package com.google.android.gms.internal;

import android.content.Context;
/* loaded from: classes.dex */
final class zzabw implements Runnable {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzaca zzcsa;
    private /* synthetic */ zzabr zzcsf;
    private /* synthetic */ zzaak zzcsg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabw(zzabr zzabrVar, Context context, zzaak zzaakVar, zzaca zzacaVar) {
        this.zzcsf = zzabrVar;
        this.zzaok = context;
        this.zzcsg = zzaakVar;
        this.zzcsa = zzacaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcsf.zzcrr.zza(this.zzaok, this.zzcsg.zzatj, this.zzcsa.zzcsn);
    }
}
