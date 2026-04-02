package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import java.io.File;
/* loaded from: classes2.dex */
public final class zzas {
    public static zzs zza(Context context, zzan zzanVar) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = new StringBuilder(String.valueOf(packageName).length() + 12).append(packageName).append("/").append(context.getPackageManager().getPackageInfo(packageName, 0).versionCode).toString();
        } catch (PackageManager.NameNotFoundException e) {
        }
        zzs zzsVar = new zzs(new zzag(file), new zzad(Build.VERSION.SDK_INT >= 9 ? new zzao() : new zzak(AndroidHttpClient.newInstance(str))));
        zzsVar.start();
        return zzsVar;
    }
}
