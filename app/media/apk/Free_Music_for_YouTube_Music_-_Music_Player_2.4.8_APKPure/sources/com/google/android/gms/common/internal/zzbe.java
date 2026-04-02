package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzbdp;
/* loaded from: classes.dex */
public final class zzbe {
    private static Object zzaqm = new Object();
    private static boolean zzcld;
    private static String zzfvi;
    private static int zzfvj;

    public static String zzcg(Context context) {
        zzci(context);
        return zzfvi;
    }

    public static int zzch(Context context) {
        zzci(context);
        return zzfvj;
    }

    private static void zzci(Context context) {
        Bundle bundle;
        synchronized (zzaqm) {
            if (zzcld) {
                return;
            }
            zzcld = true;
            try {
                bundle = zzbdp.zzcs(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
            if (bundle == null) {
                return;
            }
            zzfvi = bundle.getString("com.google.app.id");
            zzfvj = bundle.getInt("com.google.android.gms.version");
        }
    }
}
