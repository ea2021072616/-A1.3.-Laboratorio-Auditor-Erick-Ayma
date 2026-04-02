package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.util.Set;
@TargetApi(11)
/* loaded from: classes.dex */
public class zzahn extends zzahm {
    @Override // com.google.android.gms.internal.zzahm, com.google.android.gms.internal.zzahk
    public final boolean zza(DownloadManager.Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }

    @Override // com.google.android.gms.internal.zzahk
    public boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        return ((Boolean) zzaiz.zza(new zzaho(this, context, webSettings))).booleanValue();
    }

    @Override // com.google.android.gms.internal.zzahk
    public final boolean zza(Window window) {
        window.setFlags(16777216, 16777216);
        return true;
    }

    @Override // com.google.android.gms.internal.zzahk
    public zzakl zzb(zzakk zzakkVar, boolean z) {
        return new zzalo(zzakkVar, z);
    }

    @Override // com.google.android.gms.internal.zzahk
    public final Set<String> zzh(Uri uri) {
        return uri.getQueryParameterNames();
    }

    @Override // com.google.android.gms.internal.zzahk
    public WebChromeClient zzm(zzakk zzakkVar) {
        return new zzalg(zzakkVar);
    }

    @Override // com.google.android.gms.internal.zzahk
    public final boolean zzq(View view) {
        view.setLayerType(0, null);
        return true;
    }

    @Override // com.google.android.gms.internal.zzahk
    public final boolean zzr(View view) {
        view.setLayerType(1, null);
        return true;
    }
}
