package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.internal.zzbdp;
/* loaded from: classes.dex */
public final class zzv {
    @TargetApi(19)
    public static boolean zzb(Context context, int i, String str) {
        return zzbdp.zzcs(context).zzf(i, str);
    }

    public static boolean zzf(Context context, int i) {
        if (zzb(context, i, "com.google.android.gms")) {
            try {
                return com.google.android.gms.common.zzp.zzca(context).zza(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
            } catch (PackageManager.NameNotFoundException e) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                    return false;
                }
                return false;
            }
        }
        return false;
    }
}
