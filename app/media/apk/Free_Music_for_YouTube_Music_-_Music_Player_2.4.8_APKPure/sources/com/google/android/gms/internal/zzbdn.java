package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public final class zzbdn {
    private static Context zzfzk;
    private static Boolean zzfzl;

    public static synchronized boolean zzcq(Context context) {
        boolean booleanValue;
        synchronized (zzbdn.class) {
            Context applicationContext = context.getApplicationContext();
            if (zzfzk == null || zzfzl == null || zzfzk != applicationContext) {
                zzfzl = null;
                if (com.google.android.gms.common.util.zzp.isAtLeastO()) {
                    try {
                        zzfzl = (Boolean) PackageManager.class.getDeclaredMethod("isInstantApp", new Class[0]).invoke(applicationContext.getPackageManager(), new Object[0]);
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                        zzfzl = false;
                    }
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzfzl = true;
                    } catch (ClassNotFoundException e2) {
                        zzfzl = false;
                    }
                }
                zzfzk = applicationContext;
                booleanValue = zzfzl.booleanValue();
            } else {
                booleanValue = zzfzl.booleanValue();
            }
        }
        return booleanValue;
    }
}
