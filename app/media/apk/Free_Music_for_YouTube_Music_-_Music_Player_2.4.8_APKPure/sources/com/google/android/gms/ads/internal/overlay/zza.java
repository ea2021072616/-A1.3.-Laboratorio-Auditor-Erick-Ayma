package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zza {
    private static boolean zza(Context context, Intent intent, zzag zzagVar) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzafx.v(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzbv.zzea();
            zzahf.zzb(context, intent);
            if (zzagVar != null) {
                zzagVar.zzbm();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzafx.zzcs(e.getMessage());
            return false;
        }
    }

    public static boolean zza(Context context, zzc zzcVar, zzag zzagVar) {
        int i;
        if (zzcVar == null) {
            zzafx.zzcs("No intent data for launcher overlay.");
            return false;
        }
        zzmu.initialize(context);
        if (zzcVar.intent != null) {
            return zza(context, zzcVar.intent, zzagVar);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzcVar.url)) {
            zzafx.zzcs("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(zzcVar.mimeType)) {
            intent.setData(Uri.parse(zzcVar.url));
        } else {
            intent.setDataAndType(Uri.parse(zzcVar.url), zzcVar.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzcVar.packageName)) {
            intent.setPackage(zzcVar.packageName);
        }
        if (!TextUtils.isEmpty(zzcVar.zzcfa)) {
            String[] split = zzcVar.zzcfa.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzcVar.zzcfa);
                zzafx.zzcs(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        String str = zzcVar.zzcfb;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                zzafx.zzcs("Could not parse intent flags.");
                i = 0;
            }
            intent.addFlags(i);
        }
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbov)).booleanValue()) {
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzbv.zzen().zzd(zzmu.zzbou)).booleanValue()) {
                zzbv.zzea();
                zzahf.zzc(context, intent);
            }
        }
        return zza(context, intent, zzagVar);
    }
}
