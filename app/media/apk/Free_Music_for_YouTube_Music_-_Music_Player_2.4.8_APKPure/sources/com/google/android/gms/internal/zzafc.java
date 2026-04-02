package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
@zzzt
/* loaded from: classes.dex */
public final class zzafc {
    public static String zzb(String str, Context context) {
        String zzz;
        if (!com.google.android.gms.ads.internal.zzbv.zzez().zzr(context) || TextUtils.isEmpty(str) || (zzz = com.google.android.gms.ads.internal.zzbv.zzez().zzz(context)) == null) {
            return str;
        }
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjb)).booleanValue()) {
            CharSequence charSequence = (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjc);
            if (str.contains(charSequence)) {
                com.google.android.gms.ads.internal.zzbv.zzea();
                if (zzahf.zzck(str)) {
                    com.google.android.gms.ads.internal.zzbv.zzez().zzf(context, zzz);
                    return str.replace(charSequence, zzz);
                }
                com.google.android.gms.ads.internal.zzbv.zzea();
                if (zzahf.zzcl(str)) {
                    com.google.android.gms.ads.internal.zzbv.zzez().zzg(context, zzz);
                    return str.replace(charSequence, zzz);
                }
                return str;
            }
            return str;
        } else if (str.contains("fbs_aeid")) {
            return str;
        } else {
            com.google.android.gms.ads.internal.zzbv.zzea();
            if (zzahf.zzck(str)) {
                com.google.android.gms.ads.internal.zzbv.zzez().zzf(context, zzz);
                com.google.android.gms.ads.internal.zzbv.zzea();
                return zzahf.zzb(str, "fbs_aeid", zzz).toString();
            }
            com.google.android.gms.ads.internal.zzbv.zzea();
            if (zzahf.zzcl(str)) {
                com.google.android.gms.ads.internal.zzbv.zzez().zzg(context, zzz);
                com.google.android.gms.ads.internal.zzbv.zzea();
                return zzahf.zzb(str, "fbs_aeid", zzz).toString();
            }
            return str;
        }
    }
}
