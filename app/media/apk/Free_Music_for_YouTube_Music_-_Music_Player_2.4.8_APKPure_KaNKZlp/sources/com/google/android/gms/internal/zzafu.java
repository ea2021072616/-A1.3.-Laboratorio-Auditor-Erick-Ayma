package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;
@zzzt
/* loaded from: classes.dex */
public final class zzafu {
    private static final Object zzaqm = new Object();
    private static String zzdar;

    public static String zzb(Context context, String str, String str2) {
        String str3;
        synchronized (zzaqm) {
            if (zzdar == null && !TextUtils.isEmpty(str)) {
                ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
                Class<?> cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
                BigInteger bigInteger = new BigInteger(new byte[1]);
                String[] split = str.split(",");
                BigInteger bigInteger2 = bigInteger;
                for (int i = 0; i < split.length; i++) {
                    com.google.android.gms.ads.internal.zzbv.zzea();
                    if (zzahf.zza(classLoader, cls, split[i])) {
                        bigInteger2 = bigInteger2.setBit(i);
                    }
                }
                zzdar = String.format(Locale.US, "%X", bigInteger2);
            }
            str3 = zzdar;
        }
        return str3;
    }

    public static String zzqp() {
        String str;
        synchronized (zzaqm) {
            str = zzdar;
        }
        return str;
    }
}
