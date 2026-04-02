package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzbo;
import java.util.Map;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public interface zzakk extends com.google.android.gms.ads.internal.js.zzai, zzbo, zzgm {
    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    String getRequestId();

    int getRequestedOrientation();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    void zza(Context context, zzjb zzjbVar, zznh zznhVar);

    void zza(zzalc zzalcVar);

    void zza(zzjb zzjbVar);

    void zza(String str, Map<String, ?> map);

    @Override // com.google.android.gms.ads.internal.js.zzai
    void zza(String str, JSONObject jSONObject);

    void zzab(boolean z);

    void zzac(boolean z);

    void zzad(boolean z);

    void zzae(int i);

    void zzae(boolean z);

    void zzb(com.google.android.gms.ads.internal.overlay.zzm zzmVar);

    void zzb(zzoc zzocVar);

    com.google.android.gms.ads.internal.zzv zzbj();

    zzjb zzbl();

    void zzc(com.google.android.gms.ads.internal.overlay.zzm zzmVar);

    void zzct(String str);

    void zzcu(String str);

    @Override // com.google.android.gms.ads.internal.js.zzai
    void zzi(String str, String str2);

    void zzms();

    void zzrv();

    void zzrw();

    Activity zzrx();

    Context zzry();

    com.google.android.gms.ads.internal.overlay.zzm zzrz();

    com.google.android.gms.ads.internal.overlay.zzm zzsa();

    @Nullable
    zzakl zzsb();

    boolean zzsc();

    zzcv zzsd();

    zzajk zzse();

    boolean zzsf();

    void zzsg();

    boolean zzsh();

    boolean zzsi();

    @Nullable
    zzakj zzsj();

    @Nullable
    zznf zzsk();

    zzng zzsl();

    @Nullable
    zzalc zzsm();

    boolean zzsn();

    void zzso();

    void zzsp();

    @Nullable
    View.OnClickListener zzsq();

    zzoc zzsr();

    void zzss();
}
