package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
@zzzt
/* loaded from: classes.dex */
public class zzakl extends WebViewClient {
    private static final String[] zzdfn = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzdfo = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private final Object mLock;
    @Nullable
    protected zzaev zzanu;
    private boolean zzauy;
    private zzis zzbbj;
    private zzqu zzbul;
    private zzrw zzbvu;
    private com.google.android.gms.ads.internal.zzw zzbvw;
    private zzwt zzbvx;
    protected zzakk zzbvz;
    private zzxe zzcea;
    private final HashMap<String, List<zzrn>> zzdfp;
    private com.google.android.gms.ads.internal.overlay.zzw zzdfq;
    private zzakp zzdfr;
    private zzakq zzdfs;
    private zzakr zzdft;
    private boolean zzdfu;
    private boolean zzdfv;
    private ViewTreeObserver.OnGlobalLayoutListener zzdfw;
    private ViewTreeObserver.OnScrollChangedListener zzdfx;
    private boolean zzdfy;
    private com.google.android.gms.ads.internal.overlay.zzag zzdfz;
    private final zzxc zzdga;
    private zzakt zzdgb;
    private boolean zzdgc;
    private boolean zzdgd;
    private boolean zzdge;
    private int zzdgf;
    private View.OnAttachStateChangeListener zzdgg;

    public zzakl(zzakk zzakkVar, boolean z) {
        this(zzakkVar, z, new zzxc(zzakkVar, zzakkVar.zzry(), new zzmf(zzakkVar.getContext())), null);
    }

    private zzakl(zzakk zzakkVar, boolean z, zzxc zzxcVar, zzwt zzwtVar) {
        this.zzdfp = new HashMap<>();
        this.mLock = new Object();
        this.zzdfu = false;
        this.zzbvz = zzakkVar;
        this.zzauy = z;
        this.zzdga = zzxcVar;
        this.zzbvx = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzakr zza(zzakl zzaklVar, zzakr zzakrVar) {
        zzaklVar.zzdft = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view, zzaev zzaevVar, int i) {
        if (!zzaevVar.zzpc() || i <= 0) {
            return;
        }
        zzaevVar.zzk(view);
        if (zzaevVar.zzpc()) {
            zzahf.zzdbo.postDelayed(new zzakm(this, view, zzaevVar, i), 100L);
        }
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean zzmf = this.zzbvx != null ? this.zzbvx.zzmf() : false;
        com.google.android.gms.ads.internal.zzbv.zzdy();
        com.google.android.gms.ads.internal.overlay.zzu.zza(this.zzbvz.getContext(), adOverlayInfoParcel, zzmf ? false : true);
        if (this.zzanu != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzcgw != null) {
                str = adOverlayInfoParcel.zzcgw.url;
            }
            this.zzanu.zzbz(str);
        }
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        String str4;
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbky)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompat.CATEGORY_ERROR, str);
            bundle.putString("code", str2);
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str4 = parse.getHost();
                    bundle.putString("host", str4);
                    com.google.android.gms.ads.internal.zzbv.zzea().zza(context, this.zzbvz.zzse().zzcp, "gmob-apps", bundle, true);
                }
            }
            str4 = "";
            bundle.putString("host", str4);
            com.google.android.gms.ads.internal.zzbv.zzea().zza(context, this.zzbvz.zzse().zzcp, "gmob-apps", bundle, true);
        }
    }

    private final void zzi(Uri uri) {
        String path = uri.getPath();
        List<zzrn> list = this.zzdfp.get(path);
        if (list == null) {
            String valueOf = String.valueOf(uri);
            zzafx.v(new StringBuilder(String.valueOf(valueOf).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf).toString());
            return;
        }
        com.google.android.gms.ads.internal.zzbv.zzea();
        Map<String, String> zzg = zzahf.zzg(uri);
        if (zzafx.zzad(2)) {
            String valueOf2 = String.valueOf(path);
            zzafx.v(valueOf2.length() != 0 ? "Received GMSG: ".concat(valueOf2) : new String("Received GMSG: "));
            for (String str : zzg.keySet()) {
                String str2 = zzg.get(str);
                zzafx.v(new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length()).append("  ").append(str).append(": ").append(str2).toString());
            }
        }
        for (zzrn zzrnVar : list) {
            zzrnVar.zza(this.zzbvz, zzg);
        }
    }

    private final void zzsz() {
        if (this.zzdgg == null) {
            return;
        }
        zzakk zzakkVar = this.zzbvz;
        if (zzakkVar == null) {
            throw null;
        }
        ((View) zzakkVar).removeOnAttachStateChangeListener(this.zzdgg);
    }

    private final void zzte() {
        if (this.zzdfr != null && ((this.zzdgd && this.zzdgf <= 0) || this.zzdge)) {
            this.zzdfr.zza(this.zzbvz, !this.zzdge);
            this.zzdfr = null;
        }
        this.zzbvz.zzsp();
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzafx.v(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzi(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.mLock) {
            if (this.zzdgc) {
                zzafx.v("Blank page loaded, 1...");
                this.zzbvz.zzsg();
                return;
            }
            this.zzdgd = true;
            if (this.zzdfs != null) {
                this.zzdfs.zzj(this.zzbvz);
                this.zzdfs = null;
            }
            zzte();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        zzc(this.zzbvz.getContext(), "http_err", (i >= 0 || (-i) + (-1) >= zzdfn.length) ? String.valueOf(i) : zzdfn[(-i) - 1], str2);
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            zzc(this.zzbvz.getContext(), "ssl_err", (primaryError < 0 || primaryError >= zzdfo.length) ? String.valueOf(primaryError) : zzdfo[primaryError], com.google.android.gms.ads.internal.zzbv.zzec().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void reset() {
        if (this.zzanu != null) {
            this.zzanu.zzpe();
            this.zzanu = null;
        }
        zzsz();
        synchronized (this.mLock) {
            this.zzdfp.clear();
            this.zzbbj = null;
            this.zzdfq = null;
            this.zzdfr = null;
            this.zzdfs = null;
            this.zzbul = null;
            this.zzdfu = false;
            this.zzauy = false;
            this.zzdfv = false;
            this.zzdfy = false;
            this.zzdfz = null;
            this.zzdft = null;
            if (this.zzbvx != null) {
                this.zzbvx.zzl(true);
                this.zzbvx = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse webResourceResponse;
        try {
            String zzb = zzafc.zzb(str, this.zzbvz.getContext());
            if (zzb.equals(str)) {
                zzie zzaa = zzie.zzaa(str);
                if (zzaa == null) {
                    webResourceResponse = null;
                } else {
                    zzib zza = com.google.android.gms.ads.internal.zzbv.zzef().zza(zzaa);
                    webResourceResponse = (zza == null || !zza.zzgz()) ? null : new WebResourceResponse("", "", zza.zzha());
                }
            } else {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(zzb).openConnection();
                com.google.android.gms.ads.internal.zzbv.zzea().zza(this.zzbvz.getContext(), this.zzbvz.zzse().zzcp, true, httpURLConnection);
                webResourceResponse = new WebResourceResponse(httpURLConnection.getContentType(), httpURLConnection.getHeaderField("encoding"), httpURLConnection.getInputStream());
            }
            return webResourceResponse;
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "AdWebViewClient.shouldInterceptRequest");
            return null;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 128:
            case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
            case 222:
                return true;
            default:
                return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        Uri uri2;
        String valueOf = String.valueOf(str);
        zzafx.v(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzi(parse);
        } else {
            if (this.zzdfu && webView == this.zzbvz.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    if (this.zzbbj != null) {
                        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbip)).booleanValue()) {
                            this.zzbbj.onAdClicked();
                            if (this.zzanu != null) {
                                this.zzanu.zzbz(str);
                            }
                            this.zzbbj = null;
                        }
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.zzbvz.getWebView().willNotDraw()) {
                String valueOf2 = String.valueOf(str);
                zzafx.zzcs(valueOf2.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf2) : new String("AdWebView unable to handle URL: "));
            } else {
                try {
                    zzcv zzsd = this.zzbvz.zzsd();
                    if (zzsd == null || !zzsd.zzc(parse)) {
                        uri2 = parse;
                    } else {
                        Context context = this.zzbvz.getContext();
                        zzakk zzakkVar = this.zzbvz;
                        if (zzakkVar == null) {
                            throw null;
                        }
                        uri2 = zzsd.zza(parse, context, (View) zzakkVar);
                    }
                    uri = uri2;
                } catch (zzcw e) {
                    String valueOf3 = String.valueOf(str);
                    zzafx.zzcs(valueOf3.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf3) : new String("Unable to append parameter to URL: "));
                    uri = parse;
                }
                if (this.zzbvw == null || this.zzbvw.zzcq()) {
                    zza(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.zzbvw.zzs(str);
                }
            }
        }
        return true;
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzdga.zzc(i, i2);
        if (this.zzbvx != null) {
            this.zzbvx.zza(i, i2, z);
        }
    }

    public final void zza(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.mLock) {
            this.zzdfv = true;
            this.zzbvz.zzso();
            this.zzdfw = onGlobalLayoutListener;
            this.zzdfx = onScrollChangedListener;
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        boolean zzsf = this.zzbvz.zzsf();
        zza(new AdOverlayInfoParcel(zzcVar, (!zzsf || this.zzbvz.zzbl().zzbcr) ? this.zzbbj : null, zzsf ? null : this.zzdfq, this.zzdfz, this.zzbvz.zzse()));
    }

    public final void zza(zzakp zzakpVar) {
        this.zzdfr = zzakpVar;
    }

    public final void zza(zzakq zzakqVar) {
        this.zzdfs = zzakqVar;
    }

    public final void zza(zzakr zzakrVar) {
        this.zzdft = zzakrVar;
    }

    public final void zza(zzakt zzaktVar) {
        this.zzdgb = zzaktVar;
    }

    public final void zza(zzis zzisVar, com.google.android.gms.ads.internal.overlay.zzw zzwVar, zzqu zzquVar, com.google.android.gms.ads.internal.overlay.zzag zzagVar, boolean z, @Nullable zzrw zzrwVar, com.google.android.gms.ads.internal.zzw zzwVar2, zzxe zzxeVar, @Nullable zzaev zzaevVar) {
        if (zzwVar2 == null) {
            zzwVar2 = new com.google.android.gms.ads.internal.zzw(this.zzbvz.getContext(), zzaevVar, null);
        }
        this.zzbvx = new zzwt(this.zzbvz, zzxeVar);
        this.zzanu = zzaevVar;
        zza("/appEvent", new zzqt(zzquVar));
        zza("/backButton", zzqx.zzbuw);
        zza("/refresh", zzqx.zzbux);
        zza("/canOpenURLs", zzqx.zzbun);
        zza("/canOpenIntents", zzqx.zzbuo);
        zza("/click", zzqx.zzbup);
        zza("/close", zzqx.zzbuq);
        zza("/customClose", zzqx.zzbur);
        zza("/instrument", zzqx.zzbvc);
        zza("/delayPageLoaded", zzqx.zzbve);
        zza("/delayPageClosed", zzqx.zzbvf);
        zza("/getLocationInfo", zzqx.zzbvg);
        zza("/httpTrack", zzqx.zzbus);
        zza("/log", zzqx.zzbut);
        zza("/mraid", new zzrz(zzwVar2, this.zzbvx));
        zza("/mraidLoaded", this.zzdga);
        zza("/open", new zzsa(zzwVar2, this.zzbvx));
        zza("/precache", zzqx.zzbvb);
        zza("/touch", zzqx.zzbuv);
        zza("/video", zzqx.zzbuy);
        zza("/videoMeta", zzqx.zzbuz);
        if (com.google.android.gms.ads.internal.zzbv.zzez().zzr(this.zzbvz.getContext())) {
            zza("/logScionEvent", zzqx.zzbva);
        }
        if (zzrwVar != null) {
            zza("/setInterstitialProperties", new zzrv(zzrwVar));
        }
        this.zzbbj = zzisVar;
        this.zzdfq = zzwVar;
        this.zzbul = zzquVar;
        this.zzdfz = zzagVar;
        this.zzbvw = zzwVar2;
        this.zzcea = zzxeVar;
        this.zzbvu = zzrwVar;
        this.zzdfu = z;
    }

    public final void zza(String str, zzrn zzrnVar) {
        synchronized (this.mLock) {
            List<zzrn> list = this.zzdfp.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.zzdfp.put(str, list);
            }
            list.add(zzrnVar);
        }
    }

    public final void zza(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.zzbvz.zzsf() || this.zzbvz.zzbl().zzbcr) ? this.zzbbj : null, this.zzdfq, this.zzdfz, this.zzbvz, z, i, this.zzbvz.zzse()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzsf = this.zzbvz.zzsf();
        zza(new AdOverlayInfoParcel((!zzsf || this.zzbvz.zzbl().zzbcr) ? this.zzbbj : null, zzsf ? null : new zzaks(this.zzbvz, this.zzdfq), this.zzbul, this.zzdfz, this.zzbvz, z, i, str, this.zzbvz.zzse()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzsf = this.zzbvz.zzsf();
        zza(new AdOverlayInfoParcel((!zzsf || this.zzbvz.zzbl().zzbcr) ? this.zzbbj : null, zzsf ? null : new zzaks(this.zzbvz, this.zzdfq), this.zzbul, this.zzdfz, this.zzbvz, z, i, str, str2, this.zzbvz.zzse()));
    }

    public final void zzaf(boolean z) {
        this.zzdfu = false;
    }

    public final void zzb(int i, int i2) {
        if (this.zzbvx != null) {
            this.zzbvx.zzb(i, i2);
        }
    }

    public final void zzb(String str, zzrn zzrnVar) {
        synchronized (this.mLock) {
            List<zzrn> list = this.zzdfp.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzrnVar);
        }
    }

    public final boolean zzfo() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzauy;
        }
        return z;
    }

    public final void zzmo() {
        synchronized (this.mLock) {
            this.zzdfu = false;
            this.zzauy = true;
            com.google.android.gms.ads.internal.zzbv.zzea();
            zzahf.runOnUiThread(new zzako(this));
        }
    }

    public final com.google.android.gms.ads.internal.zzw zzst() {
        return this.zzbvw;
    }

    public final boolean zzsu() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdfv;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzsv() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.mLock) {
            onGlobalLayoutListener = this.zzdfw;
        }
        return onGlobalLayoutListener;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzsw() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        synchronized (this.mLock) {
            onScrollChangedListener = this.zzdfx;
        }
        return onScrollChangedListener;
    }

    public final boolean zzsx() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdfy;
        }
        return z;
    }

    public final void zzsy() {
        synchronized (this.mLock) {
            zzafx.v("Loading blank page in WebView, 2...");
            this.zzdgc = true;
            this.zzbvz.zzct("about:blank");
        }
    }

    public final void zzta() {
        zzaev zzaevVar = this.zzanu;
        if (zzaevVar != null) {
            WebView webView = this.zzbvz.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza(webView, zzaevVar, 10);
                return;
            }
            zzsz();
            this.zzdgg = new zzakn(this, zzaevVar);
            zzakk zzakkVar = this.zzbvz;
            if (zzakkVar == null) {
                throw null;
            }
            ((View) zzakkVar).addOnAttachStateChangeListener(this.zzdgg);
        }
    }

    public final void zztb() {
        synchronized (this.mLock) {
            this.zzdfy = true;
        }
        this.zzdgf++;
        zzte();
    }

    public final void zztc() {
        this.zzdgf--;
        zzte();
    }

    public final void zztd() {
        this.zzdge = true;
        zzte();
    }

    public final zzakt zztf() {
        return this.zzdgb;
    }
}
