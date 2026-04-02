package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzakk;
/* loaded from: classes.dex */
final class zzg implements Runnable {
    private /* synthetic */ String zzbyn;
    private /* synthetic */ zze zzbyp;
    private /* synthetic */ String zzbyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zze zzeVar, String str, String str2) {
        this.zzbyp = zzeVar;
        this.zzbyn = str;
        this.zzbyq = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzakk zzakkVar;
        zzakkVar = this.zzbyp.zzbvz;
        zzakkVar.zzi(this.zzbyn, this.zzbyq);
    }
}
