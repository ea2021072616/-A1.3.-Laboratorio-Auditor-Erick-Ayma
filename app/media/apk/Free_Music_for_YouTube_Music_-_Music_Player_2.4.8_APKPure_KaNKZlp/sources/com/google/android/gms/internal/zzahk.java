package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
@zzzt
@TargetApi(8)
/* loaded from: classes.dex */
public class zzahk {
    private zzahk() {
    }

    public static boolean zzk(zzakk zzakkVar) {
        if (zzakkVar == null) {
            return false;
        }
        zzakkVar.onPause();
        return true;
    }

    public static boolean zzl(zzakk zzakkVar) {
        if (zzakkVar == null) {
            return false;
        }
        zzakkVar.onResume();
        return true;
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public void setBackground(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public String zza(SslError sslError) {
        return "";
    }

    public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean zza(DownloadManager.Request request) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean zza(Window window) {
        return false;
    }

    public void zzau(Context context) {
        com.google.android.gms.ads.internal.zzbv.zzee().zzql();
    }

    public CookieManager zzav(Context context) {
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Exception e) {
            zzafx.zzb("Failed to obtain CookieManager.", e);
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public zzakl zzb(zzakk zzakkVar, boolean z) {
        return new zzakl(zzakkVar, z);
    }

    public void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
    }

    public Set<String> zzh(Uri uri) {
        String encodedQuery;
        if (!uri.isOpaque() && (encodedQuery = uri.getEncodedQuery()) != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            do {
                int indexOf = encodedQuery.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
                i = indexOf + 1;
            } while (i < encodedQuery.length());
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.emptySet();
    }

    public WebChromeClient zzm(zzakk zzakkVar) {
        return null;
    }

    public boolean zzq(View view) {
        return false;
    }

    public int zzqy() {
        return 0;
    }

    public int zzqz() {
        return 1;
    }

    public boolean zzr(View view) {
        return false;
    }

    public int zzra() {
        return 5;
    }

    public ViewGroup.LayoutParams zzrb() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public int zzrc() {
        return 0;
    }
}
