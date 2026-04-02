package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.internal.zzbdp;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class zzw {
    private static final Method zzfzc = zzall();
    private static final Method zzfzd = zzalm();
    private static final Method zzfze = zzaln();
    private static final Method zzfzf = zzalo();
    private static final Method zzfzg = zzalp();

    private static int zza(WorkSource workSource) {
        if (zzfze != null) {
            try {
                return ((Integer) zzfze.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    @Nullable
    private static String zza(WorkSource workSource, int i) {
        if (zzfzg != null) {
            try {
                return (String) zzfzg.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return null;
    }

    @Nullable
    public static WorkSource zzad(Context context, @Nullable String str) {
        if (context == null || context.getPackageManager() == null || str == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = zzbdp.zzcs(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                String valueOf = String.valueOf(str);
                Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
                return null;
            }
            return zze(applicationInfo.uid, str);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf2 = String.valueOf(str);
            Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            return null;
        }
    }

    private static Method zzall() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzalm() {
        if (zzp.zzalg()) {
            try {
                return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static Method zzaln() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzalo() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzalp() {
        if (zzp.zzalg()) {
            try {
                return WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static List<String> zzb(@Nullable WorkSource workSource) {
        int zza = workSource == null ? 0 : zza(workSource);
        if (zza == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zza; i++) {
            String zza2 = zza(workSource, i);
            if (!zzs.zzgl(zza2)) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }

    public static boolean zzcp(Context context) {
        return (context == null || context.getPackageManager() == null || zzbdp.zzcs(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    private static WorkSource zze(int i, String str) {
        WorkSource workSource = new WorkSource();
        if (zzfzd != null) {
            if (str == null) {
                str = "";
            }
            try {
                zzfzd.invoke(workSource, Integer.valueOf(i), str);
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else if (zzfzc != null) {
            try {
                zzfzc.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return workSource;
    }
}
