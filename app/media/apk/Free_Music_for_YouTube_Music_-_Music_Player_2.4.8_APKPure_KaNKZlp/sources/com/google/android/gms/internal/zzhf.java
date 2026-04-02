package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebView;
/* loaded from: classes2.dex */
final class zzhf implements Runnable {
    final /* synthetic */ zzhd zzayz;
    private ValueCallback<String> zzaza = new zzhg(this);
    final /* synthetic */ zzgx zzazb;
    final /* synthetic */ WebView zzazc;
    final /* synthetic */ boolean zzazd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhf(zzhd zzhdVar, zzgx zzgxVar, WebView webView, boolean z) {
        this.zzayz = zzhdVar;
        this.zzazb = zzgxVar;
        this.zzazc = webView;
        this.zzazd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzazc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzazc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzaza);
            } catch (Throwable th) {
                this.zzaza.onReceiveValue("");
            }
        }
    }
}
