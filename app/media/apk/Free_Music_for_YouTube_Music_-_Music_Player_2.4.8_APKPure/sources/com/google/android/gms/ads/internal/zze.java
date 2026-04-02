package com.google.android.gms.ads.internal;

import android.webkit.CookieManager;
import com.google.android.gms.internal.zzmu;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zze implements Callable<String> {
    private /* synthetic */ zzd zzanc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zzd zzdVar) {
        this.zzanc = zzdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        CookieManager zzav;
        return (!((Boolean) zzbv.zzen().zzd(zzmu.zzboh)).booleanValue() || (zzav = zzbv.zzec().zzav(this.zzanc.zzams.zzaie)) == null) ? "" : zzav.getCookie("googleads.g.doubleclick.net");
    }
}
