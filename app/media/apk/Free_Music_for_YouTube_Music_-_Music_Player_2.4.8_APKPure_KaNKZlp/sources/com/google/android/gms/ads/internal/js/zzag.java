package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzaif;
/* loaded from: classes.dex */
final class zzag implements Runnable {
    private /* synthetic */ zza zzbzr;
    private /* synthetic */ zzaf zzbzs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(zzaf zzafVar, zza zzaVar) {
        this.zzbzs = zzafVar;
        this.zzbzr = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaif zzaifVar;
        zzaifVar = this.zzbzs.zzbzq.zzbyv;
        zzaifVar.zzc(this.zzbzr);
        this.zzbzr.destroy();
    }
}
