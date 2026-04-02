package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzmu;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
final class zzbt extends AsyncTask<Void, Void, String> {
    private /* synthetic */ zzbp zzaru;

    private zzbt(zzbp zzbpVar) {
        this.zzaru = zzbpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbt(zzbp zzbpVar, zzbq zzbqVar) {
        this(zzbpVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        Future future;
        try {
            zzbp zzbpVar = this.zzaru;
            future = this.zzaru.zzarp;
            zzbpVar.zzars = (zzev) future.get(((Long) zzbv.zzen().zzd(zzmu.zzbnz)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e = e;
            zzafx.zzc("Failed to load ad data", e);
        } catch (ExecutionException e2) {
            e = e2;
            zzafx.zzc("Failed to load ad data", e);
        } catch (TimeoutException e3) {
            zzafx.zzcs("Timed out waiting for ad data");
        }
        return this.zzaru.zzdq();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(String str) {
        WebView webView;
        WebView webView2;
        String str2 = str;
        webView = this.zzaru.zzarr;
        if (webView == null || str2 == null) {
            return;
        }
        webView2 = this.zzaru.zzarr;
        webView2.loadUrl(str2);
    }
}
