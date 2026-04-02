package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.webkit.WebChromeClient;
@TargetApi(14)
/* loaded from: classes.dex */
public class zzahp extends zzahn {
    @Override // com.google.android.gms.internal.zzahk
    public final String zza(SslError sslError) {
        return sslError.getUrl();
    }

    @Override // com.google.android.gms.internal.zzahn, com.google.android.gms.internal.zzahk
    public final WebChromeClient zzm(zzakk zzakkVar) {
        return new zzalp(zzakkVar);
    }

    @Override // com.google.android.gms.internal.zzahk
    public int zzrc() {
        return 1;
    }
}
