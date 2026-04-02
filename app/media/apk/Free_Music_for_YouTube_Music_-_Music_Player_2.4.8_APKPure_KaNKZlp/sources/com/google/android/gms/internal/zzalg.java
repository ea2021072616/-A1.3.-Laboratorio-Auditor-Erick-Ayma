package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
@zzzt
@TargetApi(11)
/* loaded from: classes.dex */
public class zzalg extends WebChromeClient {
    private final zzakk zzbvz;

    public zzalg(zzakk zzakkVar) {
        this.zzbvz = zzakkVar;
    }

    private static Context zza(WebView webView) {
        if (webView instanceof zzakk) {
            zzakk zzakkVar = (zzakk) webView;
            Activity zzrx = zzakkVar.zzrx();
            return zzrx == null ? zzakkVar.getContext() : zzrx;
        }
        return webView.getContext();
    }

    private final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        com.google.android.gms.ads.internal.zzw zzst;
        boolean z2 = true;
        try {
            if (this.zzbvz == null || this.zzbvz.zzsb() == null || this.zzbvz.zzsb().zzst() == null || (zzst = this.zzbvz.zzsb().zzst()) == null || zzst.zzcq()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(str2);
                if (z) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    builder.setView(linearLayout).setPositiveButton(17039370, new zzalm(jsPromptResult, editText)).setNegativeButton(17039360, new zzall(jsPromptResult)).setOnCancelListener(new zzalk(jsPromptResult)).create().show();
                } else {
                    builder.setMessage(str3).setPositiveButton(17039370, new zzalj(jsResult)).setNegativeButton(17039360, new zzali(jsResult)).setOnCancelListener(new zzalh(jsResult)).create().show();
                }
            } else {
                zzst.zzs(new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length()).append("window.").append(str).append("('").append(str3).append("')").toString());
                z2 = false;
            }
        } catch (WindowManager.BadTokenException e) {
            zzafx.zzc("Fail to display Dialog.", e);
        }
        return z2;
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzakk)) {
            zzafx.zzcs("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzrz = ((zzakk) webView).zzrz();
        if (zzrz == null) {
            zzafx.zzcs("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzrz.close();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        String sb = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length()).append("JS: ").append(message).append(" (").append(sourceId).append(":").append(consoleMessage.lineNumber()).append(")").toString();
        if (sb.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (zzaln.zzdij[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                zzafx.e(sb);
                break;
            case 2:
                zzafx.zzcs(sb);
                break;
            case 3:
            case 4:
                zzafx.zzcr(sb);
                break;
            case 5:
                zzafx.zzcb(sb);
                break;
            default:
                zzafx.zzcr(sb);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.zzbvz.zzsb());
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(Math.min(131072L, j4) + j, (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            } else if (j2 <= Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            com.google.android.gms.ads.internal.zzbv.zzea();
            if (!zzahf.zzc(this.zzbvz.getContext(), this.zzbvz.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION")) {
                com.google.android.gms.ads.internal.zzbv.zzea();
                if (!zzahf.zzc(this.zzbvz.getContext(), this.zzbvz.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzm zzrz = this.zzbvz.zzrz();
        if (zzrz == null) {
            zzafx.zzcs("Could not get ad overlay when hiding custom view.");
        } else {
            zzrz.zzml();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zza(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0L);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        zza(view, -1, customViewCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzm zzrz = this.zzbvz.zzrz();
        if (zzrz == null) {
            zzafx.zzcs("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzrz.zza(view, customViewCallback);
        zzrz.setRequestedOrientation(i);
    }
}
