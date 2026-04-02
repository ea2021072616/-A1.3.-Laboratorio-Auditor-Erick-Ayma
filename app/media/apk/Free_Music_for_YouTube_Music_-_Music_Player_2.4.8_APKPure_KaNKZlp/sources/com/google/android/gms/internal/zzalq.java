package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import b.a.a.a.a.b.a;
import com.google.android.exoplayer2.C;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzt
@TargetApi(11)
/* loaded from: classes.dex */
public class zzalq extends zzakl {
    public zzalq(zzakk zzakkVar, boolean z) {
        super(zzakkVar, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WebResourceResponse zza(WebView webView, String str, @Nullable Map<String, String> map) {
        if (!(webView instanceof zzakk)) {
            zzafx.zzcs("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzakk zzakkVar = (zzakk) webView;
        if (this.zzanu != null) {
            this.zzanu.zza(str, map, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (zzakkVar.zzsb() != null) {
                zzakkVar.zzsb().zzmo();
            }
            String str2 = zzakkVar.zzbl().zzbcr ? (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhq) : zzakkVar.zzsf() ? (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhp) : (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbho);
            try {
                Context context = zzakkVar.getContext();
                String str3 = zzakkVar.zzse().zzcp;
                HashMap hashMap = new HashMap();
                hashMap.put(a.HEADER_USER_AGENT, com.google.android.gms.ads.internal.zzbv.zzea().zzs(context, str3));
                hashMap.put("Cache-Control", "max-stale=3600");
                String str4 = new zzaik(context).zzb(str2, hashMap).get(60L, TimeUnit.SECONDS);
                if (str4 == null) {
                    return null;
                }
                return new WebResourceResponse("application/javascript", C.UTF8_NAME, new ByteArrayInputStream(str4.getBytes(C.UTF8_NAME)));
            } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
                String valueOf = String.valueOf(e.getMessage());
                zzafx.zzcs(valueOf.length() != 0 ? "Could not fetch MRAID JS. ".concat(valueOf) : new String("Could not fetch MRAID JS. "));
                return null;
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
