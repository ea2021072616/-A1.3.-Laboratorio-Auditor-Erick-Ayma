package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import java.util.Map;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
final class zzakx extends FrameLayout implements zzakk {
    private static final int zzcfy = Color.argb(0, 0, 0, 0);
    private final zzakk zzdgq;
    private final zzakj zzdgr;

    public zzakx(zzakk zzakkVar) {
        super(zzakkVar.getContext());
        this.zzdgq = zzakkVar;
        this.zzdgr = new zzakj(zzakkVar.zzry(), this, this);
        zzakl zzsb = this.zzdgq.zzsb();
        if (zzsb != null) {
            zzsb.zzbvz = this;
        }
        zzakk zzakkVar2 = this.zzdgq;
        if (zzakkVar2 == null) {
            throw null;
        }
        addView((View) zzakkVar2);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void destroy() {
        this.zzdgq.destroy();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final String getRequestId() {
        return this.zzdgq.getRequestId();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final int getRequestedOrientation() {
        return this.zzdgq.getRequestedOrientation();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final WebView getWebView() {
        return this.zzdgq.getWebView();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean isDestroyed() {
        return this.zzdgq.isDestroyed();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void loadData(String str, String str2, String str3) {
        this.zzdgq.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzdgq.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void loadUrl(String str) {
        this.zzdgq.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void onPause() {
        this.zzdgr.onPause();
        this.zzdgq.onPause();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void onResume() {
        this.zzdgq.onResume();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void setContext(Context context) {
        this.zzdgq.setContext(context);
    }

    @Override // android.view.View, com.google.android.gms.internal.zzakk
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzdgq.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.zzakk
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzdgq.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void setRequestedOrientation(int i) {
        this.zzdgq.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzdgq.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzdgq.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void stopLoading() {
        this.zzdgq.stopLoading();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zza(Context context, zzjb zzjbVar, zznh zznhVar) {
        this.zzdgr.onDestroy();
        this.zzdgq.zza(context, zzjbVar, zznhVar);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zza(zzalc zzalcVar) {
        this.zzdgq.zza(zzalcVar);
    }

    @Override // com.google.android.gms.internal.zzgm
    public final void zza(zzgl zzglVar) {
        this.zzdgq.zza(zzglVar);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zza(zzjb zzjbVar) {
        this.zzdgq.zza(zzjbVar);
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zza(String str, zzrn zzrnVar) {
        this.zzdgq.zza(str, zzrnVar);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zza(String str, Map<String, ?> map) {
        this.zzdgq.zza(str, map);
    }

    @Override // com.google.android.gms.internal.zzakk, com.google.android.gms.ads.internal.js.zzai
    public final void zza(String str, JSONObject jSONObject) {
        this.zzdgq.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzab(boolean z) {
        this.zzdgq.zzab(z);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzac(boolean z) {
        this.zzdgq.zzac(z);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzad(boolean z) {
        this.zzdgq.zzad(z);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzae(int i) {
        this.zzdgq.zzae(i);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzae(boolean z) {
        this.zzdgq.zzae(z);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzb(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzdgq.zzb(zzmVar);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzb(@Nullable zzoc zzocVar) {
        this.zzdgq.zzb(zzocVar);
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zzb(String str, zzrn zzrnVar) {
        this.zzdgq.zzb(str, zzrnVar);
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzdgq.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final com.google.android.gms.ads.internal.zzv zzbj() {
        return this.zzdgq.zzbj();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzjb zzbl() {
        return this.zzdgq.zzbl();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzc(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzdgq.zzc(zzmVar);
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzci() {
        this.zzdgq.zzci();
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzcj() {
        this.zzdgq.zzcj();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzct(String str) {
        this.zzdgq.zzct(str);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzcu(String str) {
        this.zzdgq.zzcu(str);
    }

    @Override // com.google.android.gms.internal.zzakk, com.google.android.gms.ads.internal.js.zzai
    public final void zzi(String str, String str2) {
        this.zzdgq.zzi(str, str2);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzms() {
        this.zzdgq.zzms();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzrv() {
        this.zzdgq.zzrv();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzrw() {
        this.zzdgq.zzrw();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final Activity zzrx() {
        return this.zzdgq.zzrx();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final Context zzry() {
        return this.zzdgq.zzry();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final com.google.android.gms.ads.internal.overlay.zzm zzrz() {
        return this.zzdgq.zzrz();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final com.google.android.gms.ads.internal.overlay.zzm zzsa() {
        return this.zzdgq.zzsa();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzakl zzsb() {
        return this.zzdgq.zzsb();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean zzsc() {
        return this.zzdgq.zzsc();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzcv zzsd() {
        return this.zzdgq.zzsd();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzajk zzse() {
        return this.zzdgq.zzse();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean zzsf() {
        return this.zzdgq.zzsf();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzsg() {
        this.zzdgr.onDestroy();
        this.zzdgq.zzsg();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean zzsh() {
        return this.zzdgq.zzsh();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean zzsi() {
        return this.zzdgq.zzsi();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzakj zzsj() {
        return this.zzdgr;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zznf zzsk() {
        return this.zzdgq.zzsk();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzng zzsl() {
        return this.zzdgq.zzsl();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzalc zzsm() {
        return this.zzdgq.zzsm();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean zzsn() {
        return this.zzdgq.zzsn();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzso() {
        this.zzdgq.zzso();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzsp() {
        this.zzdgq.zzsp();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final View.OnClickListener zzsq() {
        return this.zzdgq.zzsq();
    }

    @Override // com.google.android.gms.internal.zzakk
    @Nullable
    public final zzoc zzsr() {
        return this.zzdgq.zzsr();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzss() {
        setBackgroundColor(zzcfy);
        this.zzdgq.setBackgroundColor(zzcfy);
    }
}
