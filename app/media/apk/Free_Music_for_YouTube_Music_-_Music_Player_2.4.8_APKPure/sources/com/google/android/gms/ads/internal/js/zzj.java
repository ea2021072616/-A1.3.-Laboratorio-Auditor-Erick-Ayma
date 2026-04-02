package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzakk;
/* loaded from: classes.dex */
final class zzj implements Runnable {
    private /* synthetic */ String zzbyl;
    private /* synthetic */ zze zzbyp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(zze zzeVar, String str) {
        this.zzbyp = zzeVar;
        this.zzbyl = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzakk zzakkVar;
        zzakkVar = this.zzbyp.zzbvz;
        zzakkVar.loadUrl(this.zzbyl);
    }
}
