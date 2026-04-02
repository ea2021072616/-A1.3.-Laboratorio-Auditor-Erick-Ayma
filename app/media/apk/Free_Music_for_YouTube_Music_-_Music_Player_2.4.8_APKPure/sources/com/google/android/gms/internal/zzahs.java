package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebSettings;
@TargetApi(16)
/* loaded from: classes.dex */
public class zzahs extends zzahp {
    @Override // com.google.android.gms.internal.zzahk
    public final void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    @Override // com.google.android.gms.internal.zzahk
    public final void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override // com.google.android.gms.internal.zzahn, com.google.android.gms.internal.zzahk
    public boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }

    @Override // com.google.android.gms.internal.zzahk
    public final void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
    }
}
