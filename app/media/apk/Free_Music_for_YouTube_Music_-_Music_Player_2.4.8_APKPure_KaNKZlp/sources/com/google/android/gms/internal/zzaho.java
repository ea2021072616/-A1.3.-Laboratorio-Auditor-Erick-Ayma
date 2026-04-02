package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zzaho implements Callable<Boolean> {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ WebSettings zzdbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaho(zzahn zzahnVar, Context context, WebSettings webSettings) {
        this.zzaok = context;
        this.zzdbx = webSettings;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        if (this.zzaok.getCacheDir() != null) {
            this.zzdbx.setAppCachePath(this.zzaok.getCacheDir().getAbsolutePath());
            this.zzdbx.setAppCacheMaxSize(0L);
            this.zzdbx.setAppCacheEnabled(true);
        }
        this.zzdbx.setDatabasePath(this.zzaok.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        this.zzdbx.setDatabaseEnabled(true);
        this.zzdbx.setDomStorageEnabled(true);
        this.zzdbx.setDisplayZoomControls(false);
        this.zzdbx.setBuiltInZoomControls(true);
        this.zzdbx.setSupportZoom(true);
        this.zzdbx.setAllowContentAccess(false);
        return true;
    }
}
