package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;
@zzzt
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzalp extends zzalg {
    public zzalp(zzakk zzakkVar) {
        super(zzakkVar);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zza(view, i, customViewCallback);
    }
}
