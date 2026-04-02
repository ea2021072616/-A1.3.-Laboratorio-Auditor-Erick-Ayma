package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zzajb implements Callable<String> {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ Context zzddv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajb(zzaja zzajaVar, Context context, Context context2) {
        this.zzddv = context;
        this.zzaok = context2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.zzddv != null) {
            zzafx.v("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.zzddv.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzafx.v("Attempting to read user agent from local cache.");
            sharedPreferences = this.zzaok.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzafx.v("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.zzaok);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzafx.v("Persisting user agent.");
            }
        }
        return string;
    }
}
