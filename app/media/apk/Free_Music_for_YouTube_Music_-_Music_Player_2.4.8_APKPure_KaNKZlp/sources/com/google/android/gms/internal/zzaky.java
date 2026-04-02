package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActivityChooserView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.zzbo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
final class zzaky extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzakk {
    private final Object mLock;
    private final com.google.android.gms.ads.internal.zzv zzamv;
    private final zzajk zzapc;
    private zzjb zzaro;
    private zzajd zzaus;
    private final WindowManager zzavh;
    @Nullable
    private final zzcv zzbsr;
    private int zzcer;
    private int zzces;
    private int zzceu;
    private int zzcev;
    private String zzcjq;
    private zznf zzcjr;
    private Boolean zzczr;
    private final zzalb zzdgs;
    private final zzbo zzdgt;
    private zzakl zzdgu;
    private com.google.android.gms.ads.internal.overlay.zzm zzdgv;
    private boolean zzdgw;
    private boolean zzdgx;
    private boolean zzdgy;
    private boolean zzdgz;
    private int zzdha;
    private boolean zzdhb;
    private boolean zzdhc;
    private zzalc zzdhd;
    private boolean zzdhe;
    private boolean zzdhf;
    private zzoc zzdhg;
    private int zzdhh;
    private int zzdhi;
    private zznf zzdhj;
    private zznf zzdhk;
    private zzng zzdhl;
    private WeakReference<View.OnClickListener> zzdhm;
    private com.google.android.gms.ads.internal.overlay.zzm zzdhn;
    private boolean zzdho;
    private Map<String, zzsl> zzdhp;
    private final zzil zzdhq;

    private zzaky(zzalb zzalbVar, zzjb zzjbVar, boolean z, boolean z2, @Nullable zzcv zzcvVar, zzajk zzajkVar, zznh zznhVar, zzbo zzboVar, com.google.android.gms.ads.internal.zzv zzvVar, zzil zzilVar) {
        super(zzalbVar);
        this.mLock = new Object();
        this.zzdhb = true;
        this.zzdhc = false;
        this.zzcjq = "";
        this.zzces = -1;
        this.zzcer = -1;
        this.zzceu = -1;
        this.zzcev = -1;
        this.zzdgs = zzalbVar;
        this.zzaro = zzjbVar;
        this.zzdgy = z;
        this.zzdha = -1;
        this.zzbsr = zzcvVar;
        this.zzapc = zzajkVar;
        this.zzdgt = zzboVar;
        this.zzamv = zzvVar;
        this.zzavh = (WindowManager) getContext().getSystemService("window");
        this.zzdhq = zzilVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzafx.zzb("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzbv.zzea().zzs(zzalbVar, zzajkVar.zzcp));
        com.google.android.gms.ads.internal.zzbv.zzec().zza(getContext(), settings);
        setDownloadListener(this);
        zzti();
        if (com.google.android.gms.common.util.zzp.zzalf()) {
            addJavascriptInterface(new zzalf(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzaus = new zzajd(this.zzdgs.zzrx(), this, this, null);
        zzd(zznhVar);
        com.google.android.gms.ads.internal.zzbv.zzec().zzau(zzalbVar);
    }

    private final void zza(Boolean bool) {
        synchronized (this.mLock) {
            this.zzczr = bool;
        }
        com.google.android.gms.ads.internal.zzbv.zzee().zza(bool);
    }

    private final void zzag(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zza("onAdVisibilityChanged", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzaky zzb(Context context, zzjb zzjbVar, boolean z, boolean z2, @Nullable zzcv zzcvVar, zzajk zzajkVar, zznh zznhVar, zzbo zzboVar, com.google.android.gms.ads.internal.zzv zzvVar, zzil zzilVar) {
        return new zzaky(new zzalb(context), zzjbVar, z, z2, zzcvVar, zzajkVar, zznhVar, zzboVar, zzvVar, zzilVar);
    }

    private final void zzcv(String str) {
        synchronized (this.mLock) {
            if (isDestroyed()) {
                zzafx.zzcs("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    private final void zzcw(String str) {
        if (!com.google.android.gms.common.util.zzp.zzalh()) {
            String valueOf = String.valueOf(str);
            zzcv(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        if (zzpy() == null) {
            synchronized (this.mLock) {
                this.zzczr = com.google.android.gms.ads.internal.zzbv.zzee().zzpy();
                if (this.zzczr == null) {
                    try {
                        evaluateJavascript("(function(){})()", null);
                        zza((Boolean) true);
                    } catch (IllegalStateException e) {
                        zza((Boolean) false);
                    }
                }
            }
        }
        if (!zzpy().booleanValue()) {
            String valueOf2 = String.valueOf(str);
            zzcv(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
            return;
        }
        synchronized (this.mLock) {
            if (isDestroyed()) {
                zzafx.zzcs("The webview is destroyed. Ignoring action.");
            } else {
                evaluateJavascript(str, null);
            }
        }
    }

    private final void zzd(zznh zznhVar) {
        zztl();
        this.zzdhl = new zzng(new zznh(true, "make_wv", this.zzaro.zzbcq));
        this.zzdhl.zzit().zzc(zznhVar);
        this.zzcjr = zzna.zzb(this.zzdhl.zzit());
        this.zzdhl.zza("native:view_create", this.zzcjr);
        this.zzdhk = null;
        this.zzdhj = null;
    }

    private final Boolean zzpy() {
        Boolean bool;
        synchronized (this.mLock) {
            bool = this.zzczr;
        }
        return bool;
    }

    private final void zzqm() {
        synchronized (this.mLock) {
            if (!this.zzdho) {
                this.zzdho = true;
                com.google.android.gms.ads.internal.zzbv.zzee().zzqm();
            }
        }
    }

    private final boolean zztg() {
        int i;
        int i2;
        if (this.zzdgu.zzfo() || this.zzdgu.zzsu()) {
            com.google.android.gms.ads.internal.zzbv.zzea();
            DisplayMetrics zza = zzahf.zza(this.zzavh);
            zzjo.zzhu();
            int zzb = zzaje.zzb(zza, zza.widthPixels);
            zzjo.zzhu();
            int zzb2 = zzaje.zzb(zza, zza.heightPixels);
            Activity zzrx = this.zzdgs.zzrx();
            if (zzrx == null || zzrx.getWindow() == null) {
                i = zzb2;
                i2 = zzb;
            } else {
                com.google.android.gms.ads.internal.zzbv.zzea();
                int[] zzf = zzahf.zzf(zzrx);
                zzjo.zzhu();
                i2 = zzaje.zzb(zza, zzf[0]);
                zzjo.zzhu();
                i = zzaje.zzb(zza, zzf[1]);
            }
            if (this.zzcer == zzb && this.zzces == zzb2 && this.zzceu == i2 && this.zzcev == i) {
                return false;
            }
            boolean z = (this.zzcer == zzb && this.zzces == zzb2) ? false : true;
            this.zzcer = zzb;
            this.zzces = zzb2;
            this.zzceu = i2;
            this.zzcev = i;
            new zzxd(this).zza(zzb, zzb2, i2, i, zza.density, this.zzavh.getDefaultDisplay().getRotation());
            return z;
        }
        return false;
    }

    private final void zzth() {
        zzna.zza(this.zzdhl.zzit(), this.zzcjr, "aeh2");
    }

    private final void zzti() {
        synchronized (this.mLock) {
            if (this.zzdgy || this.zzaro.zzbcr) {
                zzafx.zzcb("Enabling hardware acceleration on an overlay.");
                zztj();
            } else if (Build.VERSION.SDK_INT < 18) {
                zzafx.zzcb("Disabling hardware acceleration on an AdView.");
                synchronized (this.mLock) {
                    if (!this.zzdgz) {
                        com.google.android.gms.ads.internal.zzbv.zzec().zzr(this);
                    }
                    this.zzdgz = true;
                }
            } else {
                zzafx.zzcb("Enabling hardware acceleration on an AdView.");
                zztj();
            }
        }
    }

    private final void zztj() {
        synchronized (this.mLock) {
            if (this.zzdgz) {
                com.google.android.gms.ads.internal.zzbv.zzec().zzq(this);
            }
            this.zzdgz = false;
        }
    }

    private final void zztk() {
        synchronized (this.mLock) {
            this.zzdhp = null;
        }
    }

    private final void zztl() {
        zznh zzit;
        if (this.zzdhl == null || (zzit = this.zzdhl.zzit()) == null || com.google.android.gms.ads.internal.zzbv.zzee().zzpt() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzbv.zzee().zzpt().zza(zzit);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzakk
    public final void destroy() {
        synchronized (this.mLock) {
            zztl();
            this.zzaus.zzrm();
            if (this.zzdgv != null) {
                this.zzdgv.close();
                this.zzdgv.onDestroy();
                this.zzdgv = null;
            }
            this.zzdgu.reset();
            if (this.zzdgx) {
                return;
            }
            com.google.android.gms.ads.internal.zzbv.zzex();
            zzsk.zze(this);
            zztk();
            this.zzdgx = true;
            zzafx.v("Initiating WebView self destruct sequence in 3...");
            this.zzdgu.zzsy();
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.mLock) {
            if (!isDestroyed()) {
                super.evaluateJavascript(str, valueCallback);
                return;
            }
            zzafx.zzcs("The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.mLock != null) {
                synchronized (this.mLock) {
                    if (!this.zzdgx) {
                        this.zzdgu.reset();
                        com.google.android.gms.ads.internal.zzbv.zzex();
                        zzsk.zze(this);
                        zztk();
                        zzqm();
                    }
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final String getRequestId() {
        String str;
        synchronized (this.mLock) {
            str = this.zzcjq;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final int getRequestedOrientation() {
        int i;
        synchronized (this.mLock) {
            i = this.zzdha;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean isDestroyed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdgx;
        }
        return z;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzakk
    public final void loadData(String str, String str2, String str3) {
        synchronized (this.mLock) {
            if (isDestroyed()) {
                zzafx.zzcs("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzakk
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.mLock) {
            if (isDestroyed()) {
                zzafx.zzcs("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzakk
    public final void loadUrl(String str) {
        synchronized (this.mLock) {
            if (isDestroyed()) {
                zzafx.zzcs("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                    com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "AdWebViewImpl.loadUrl");
                    zzafx.zzc("Could not call loadUrl. ", e);
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        boolean z = true;
        synchronized (this.mLock) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzaus.onAttachedToWindow();
            }
            boolean z2 = this.zzdhe;
            if (this.zzdgu == null || !this.zzdgu.zzsu()) {
                z = z2;
            } else {
                if (!this.zzdhf) {
                    ViewTreeObserver.OnGlobalLayoutListener zzsv = this.zzdgu.zzsv();
                    if (zzsv != null) {
                        com.google.android.gms.ads.internal.zzbv.zzey();
                        if (this == null) {
                            throw null;
                        }
                        zzakf.zza(this, zzsv);
                    }
                    ViewTreeObserver.OnScrollChangedListener zzsw = this.zzdgu.zzsw();
                    if (zzsw != null) {
                        com.google.android.gms.ads.internal.zzbv.zzey();
                        if (this == null) {
                            throw null;
                        }
                        zzakf.zza(this, zzsw);
                    }
                    this.zzdhf = true;
                }
                zztg();
            }
            zzag(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this.mLock) {
            if (!isDestroyed()) {
                this.zzaus.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzdhf && this.zzdgu != null && this.zzdgu.zzsu() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener zzsv = this.zzdgu.zzsv();
                if (zzsv != null) {
                    com.google.android.gms.ads.internal.zzbv.zzec().zza(getViewTreeObserver(), zzsv);
                }
                ViewTreeObserver.OnScrollChangedListener zzsw = this.zzdgu.zzsw();
                if (zzsw != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(zzsw);
                }
                this.zzdhf = false;
            }
        }
        zzag(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.zzbv.zzea();
            zzahf.zzb(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzafx.zzcb(new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
        if (this.zzdgu == null || this.zzdgu.zztf() == null) {
            return;
        }
        this.zzdgu.zztf().zzcr();
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjh)).booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if (motionEvent.getActionMasked() == 8 && ((axisValue > 0.0f && !canScrollVertically(-1)) || ((axisValue < 0.0f && !canScrollVertically(1)) || ((axisValue2 > 0.0f && !canScrollHorizontally(-1)) || (axisValue2 < 0.0f && !canScrollHorizontally(1)))))) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zztg = zztg();
        com.google.android.gms.ads.internal.overlay.zzm zzrz = zzrz();
        if (zzrz == null || !zztg) {
            return;
        }
        zzrz.zzmr();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected final void onMeasure(int i, int i2) {
        int size;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        synchronized (this.mLock) {
            if (isDestroyed()) {
                setMeasuredDimension(0, 0);
            } else if (isInEditMode() || this.zzdgy || this.zzaro.zzbct) {
                super.onMeasure(i, i2);
            } else if (this.zzaro.zzbcu) {
                if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbnf)).booleanValue() || !com.google.android.gms.common.util.zzp.zzalf()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zza("/contentHeight", new zzakz(this));
                zzcw("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                float f = this.zzdgs.getResources().getDisplayMetrics().density;
                int size2 = View.MeasureSpec.getSize(i);
                switch (this.zzdhi) {
                    case -1:
                        size = View.MeasureSpec.getSize(i2);
                        break;
                    default:
                        size = (int) (f * this.zzdhi);
                        break;
                }
                setMeasuredDimension(size2, size);
            } else if (this.zzaro.zzbcr) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.zzavh.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                int mode = View.MeasureSpec.getMode(i);
                int size3 = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                int size4 = View.MeasureSpec.getSize(i2);
                int i4 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size3 : Integer.MAX_VALUE;
                if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                    i3 = size4;
                }
                if (this.zzaro.widthPixels > i4 || this.zzaro.heightPixels > i3) {
                    float f2 = this.zzdgs.getResources().getDisplayMetrics().density;
                    zzafx.zzcs(new StringBuilder(103).append("Not enough space to show ad. Needs ").append((int) (this.zzaro.widthPixels / f2)).append("x").append((int) (this.zzaro.heightPixels / f2)).append(" dp, but only has ").append((int) (size3 / f2)).append("x").append((int) (size4 / f2)).append(" dp.").toString());
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                } else {
                    if (getVisibility() != 8) {
                        setVisibility(0);
                    }
                    setMeasuredDimension(this.zzaro.widthPixels, this.zzaro.heightPixels);
                }
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzakk
    public final void onPause() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e) {
            zzafx.zzb("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzakk
    public final void onResume() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e) {
            zzafx.zzb("Could not resume webview.", e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzdgu.zzsu()) {
            synchronized (this.mLock) {
                if (this.zzdhg != null) {
                    this.zzdhg.zzc(motionEvent);
                }
            }
        } else if (this.zzbsr != null) {
            this.zzbsr.zza(motionEvent);
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void setContext(Context context) {
        this.zzdgs.setBaseContext(context);
        this.zzaus.zzi(this.zzdgs.zzrx());
    }

    @Override // android.view.View, com.google.android.gms.internal.zzakk
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzdhm = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void setRequestedOrientation(int i) {
        synchronized (this.mLock) {
            this.zzdha = i;
            if (this.zzdgv != null) {
                this.zzdgv.setRequestedOrientation(this.zzdha);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzakk
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzakl) {
            this.zzdgu = (zzakl) webViewClient;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzakk
    public final void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzafx.zzb("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zza(Context context, zzjb zzjbVar, zznh zznhVar) {
        synchronized (this.mLock) {
            this.zzaus.zzrm();
            setContext(context);
            this.zzdgv = null;
            this.zzaro = zzjbVar;
            this.zzdgy = false;
            this.zzdgw = false;
            this.zzcjq = "";
            this.zzdha = -1;
            com.google.android.gms.ads.internal.zzbv.zzec();
            zzahk.zzl(this);
            loadUrl("about:blank");
            this.zzdgu.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.zzdhb = true;
            this.zzdhc = false;
            this.zzdhd = null;
            zzd(zznhVar);
            this.zzdhe = false;
            this.zzdhh = 0;
            com.google.android.gms.ads.internal.zzbv.zzex();
            zzsk.zze(this);
            zztk();
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zza(zzalc zzalcVar) {
        synchronized (this.mLock) {
            if (this.zzdhd != null) {
                zzafx.e("Attempt to create multiple AdWebViewVideoControllers.");
            } else {
                this.zzdhd = zzalcVar;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgm
    public final void zza(zzgl zzglVar) {
        synchronized (this.mLock) {
            this.zzdhe = zzglVar.zzaxi;
        }
        zzag(zzglVar.zzaxi);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zza(zzjb zzjbVar) {
        synchronized (this.mLock) {
            this.zzaro = zzjbVar;
            requestLayout();
        }
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zza(String str, zzrn zzrnVar) {
        if (this.zzdgu != null) {
            this.zzdgu.zza(str, zzrnVar);
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, com.google.android.gms.ads.internal.zzbv.zzea().zzk(map));
        } catch (JSONException e) {
            zzafx.zzcs("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.zzakk, com.google.android.gms.ads.internal.js.zzai
    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzi(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzab(boolean z) {
        synchronized (this.mLock) {
            boolean z2 = z != this.zzdgy;
            this.zzdgy = z;
            zzti();
            if (z2) {
                new zzxd(this).zzbp(z ? "expanded" : "default");
            }
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzac(boolean z) {
        synchronized (this.mLock) {
            if (this.zzdgv != null) {
                this.zzdgv.zza(this.zzdgu.zzfo(), z);
            } else {
                this.zzdgw = z;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzad(boolean z) {
        synchronized (this.mLock) {
            this.zzdhb = z;
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzae(int i) {
        if (i == 0) {
            zzna.zza(this.zzdhl.zzit(), this.zzcjr, "aebb2");
        }
        zzth();
        if (this.zzdhl.zzit() != null) {
            this.zzdhl.zzit().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.zzapc.zzcp);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzae(boolean z) {
        synchronized (this.mLock) {
            this.zzdhh = (z ? 1 : -1) + this.zzdhh;
            if (this.zzdhh <= 0 && this.zzdgv != null) {
                this.zzdgv.zzmu();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzb(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        synchronized (this.mLock) {
            this.zzdgv = zzmVar;
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzb(zzoc zzocVar) {
        synchronized (this.mLock) {
            this.zzdhg = zzocVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zzb(String str, zzrn zzrnVar) {
        if (this.zzdgu != null) {
            this.zzdgu.zzb(str, zzrnVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzafx.zzcb(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzcw(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzakk
    public final com.google.android.gms.ads.internal.zzv zzbj() {
        return this.zzamv;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzjb zzbl() {
        zzjb zzjbVar;
        synchronized (this.mLock) {
            zzjbVar = this.zzaro;
        }
        return zzjbVar;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzc(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        synchronized (this.mLock) {
            this.zzdhn = zzmVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzci() {
        synchronized (this.mLock) {
            this.zzdhc = true;
            if (this.zzdgt != null) {
                this.zzdgt.zzci();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzcj() {
        synchronized (this.mLock) {
            this.zzdhc = false;
            if (this.zzdgt != null) {
                this.zzdgt.zzcj();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzct(String str) {
        synchronized (this.mLock) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
                com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "AdWebViewImpl.loadUrlUnsafe");
                zzafx.zzc("Could not call loadUrl. ", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzcu(String str) {
        synchronized (this.mLock) {
            if (str == null) {
                str = "";
            }
            this.zzcjq = str;
        }
    }

    @Override // com.google.android.gms.internal.zzakk, com.google.android.gms.ads.internal.js.zzai
    public final void zzi(String str, String str2) {
        zzcw(new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()).append(str).append("(").append(str2).append(");").toString());
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzms() {
        if (this.zzdhj == null) {
            zzna.zza(this.zzdhl.zzit(), this.zzcjr, "aes2");
            this.zzdhj = zzna.zzb(this.zzdhl.zzit());
            this.zzdhl.zza("native:view_show", this.zzdhj);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.zzapc.zzcp);
        zza("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzrv() {
        zzth();
        HashMap hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.zzapc.zzcp);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzrw() {
        HashMap hashMap = new HashMap(3);
        com.google.android.gms.ads.internal.zzbv.zzea();
        hashMap.put("app_muted", String.valueOf(zzahf.zzdg()));
        com.google.android.gms.ads.internal.zzbv.zzea();
        hashMap.put("app_volume", String.valueOf(zzahf.zzde()));
        com.google.android.gms.ads.internal.zzbv.zzea();
        hashMap.put("device_volume", String.valueOf(zzahf.zzap(getContext())));
        zza("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.zzakk
    public final Activity zzrx() {
        return this.zzdgs.zzrx();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final Context zzry() {
        return this.zzdgs.zzry();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final com.google.android.gms.ads.internal.overlay.zzm zzrz() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        synchronized (this.mLock) {
            zzmVar = this.zzdgv;
        }
        return zzmVar;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final com.google.android.gms.ads.internal.overlay.zzm zzsa() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        synchronized (this.mLock) {
            zzmVar = this.zzdhn;
        }
        return zzmVar;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzakl zzsb() {
        return this.zzdgu;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean zzsc() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdgw;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzcv zzsd() {
        return this.zzbsr;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzajk zzse() {
        return this.zzapc;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean zzsf() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdgy;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzsg() {
        synchronized (this.mLock) {
            zzafx.v("Destroying WebView!");
            zzqm();
            zzahf.zzdbo.post(new zzala(this));
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean zzsh() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdhb;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean zzsi() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdhc;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzakj zzsj() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zznf zzsk() {
        return this.zzcjr;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzng zzsl() {
        return this.zzdhl;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzalc zzsm() {
        zzalc zzalcVar;
        synchronized (this.mLock) {
            zzalcVar = this.zzdhd;
        }
        return zzalcVar;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final boolean zzsn() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdhh > 0;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzso() {
        this.zzaus.zzrl();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzsp() {
        if (this.zzdhk == null) {
            this.zzdhk = zzna.zzb(this.zzdhl.zzit());
            this.zzdhl.zza("native:view_load", this.zzdhk);
        }
    }

    @Override // com.google.android.gms.internal.zzakk
    public final View.OnClickListener zzsq() {
        return this.zzdhm.get();
    }

    @Override // com.google.android.gms.internal.zzakk
    public final zzoc zzsr() {
        zzoc zzocVar;
        synchronized (this.mLock) {
            zzocVar = this.zzdhg;
        }
        return zzocVar;
    }

    @Override // com.google.android.gms.internal.zzakk
    public final void zzss() {
        setBackgroundColor(0);
    }
}
