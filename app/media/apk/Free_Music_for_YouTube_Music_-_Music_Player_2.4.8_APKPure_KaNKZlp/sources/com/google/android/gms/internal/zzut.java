package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzut {
    private static String zza(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public static List<String> zza(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.getString(i));
            }
            return Collections.unmodifiableList(arrayList);
        }
        return null;
    }

    public static void zza(Context context, String str, zzafi zzafiVar, String str2, boolean z, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String str3 = z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        for (String str4 : list) {
            String zza = zza(zza(zza(zza(zza(zza(zza(str4, "@gw_adlocid@", str2), "@gw_adnetrefresh@", str3), "@gw_qdata@", zzafiVar.zzcye.zzcaz), "@gw_sdkver@", str), "@gw_sessid@", com.google.android.gms.ads.internal.zzbv.zzee().getSessionId()), "@gw_seqnum@", zzafiVar.zzcnz), "@gw_adnetstatus@", zzafiVar.zzcyf);
            if (zzafiVar.zzcca != null) {
                zza = zza(zza(zza, "@gw_adnetid@", zzafiVar.zzcca.zzcab), "@gw_allocid@", zzafiVar.zzcca.zzcad);
            }
            String zzb = zzafc.zzb(zza, context);
            com.google.android.gms.ads.internal.zzbv.zzea();
            zzahf.zzd(context, str, zzb);
        }
    }

    public static boolean zza(String str, int[] iArr) {
        if (!TextUtils.isEmpty(str) && iArr.length == 2) {
            String[] split = str.split("x");
            if (split.length == 2) {
                try {
                    iArr[0] = Integer.parseInt(split[0]);
                    iArr[1] = Integer.parseInt(split[1]);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }
}
