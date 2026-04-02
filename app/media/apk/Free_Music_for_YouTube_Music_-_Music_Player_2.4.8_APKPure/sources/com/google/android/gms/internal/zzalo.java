package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;
@zzzt
@TargetApi(11)
/* loaded from: classes.dex */
public final class zzalo extends zzalq {
    public zzalo(zzakk zzakkVar, boolean z) {
        super(zzakkVar, z);
    }

    @Override // com.google.android.gms.internal.zzakl, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, (Map<String, String>) null);
    }
}
