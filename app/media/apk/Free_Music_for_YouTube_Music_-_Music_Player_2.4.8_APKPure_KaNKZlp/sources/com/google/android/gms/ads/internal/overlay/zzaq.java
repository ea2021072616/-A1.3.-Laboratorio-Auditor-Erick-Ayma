package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzzt;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzaq {
    private String zzcjm;
    private boolean zzcjn;
    private int zzcjo;
    private int zzcjp;

    public zzaq(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
            }
        } else {
            jSONObject = null;
        }
        jSONObject2 = jSONObject;
        this.zzcjn = zza(jSONObject2, "aggressive_media_codec_release", zzmu.zzbgz);
        this.zzcjm = zzc(jSONObject2, "exo_player_version", zzmu.zzbgi);
        this.zzcjp = zzb(jSONObject2, "exo_cache_buffer_size", zzmu.zzbgn);
        this.zzcjo = zzb(jSONObject2, "exo_allocator_segment_size", zzmu.zzbgm);
    }

    private static boolean zza(JSONObject jSONObject, String str, zzmk<Boolean> zzmkVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException e) {
            }
        }
        return ((Boolean) zzbv.zzen().zzd(zzmkVar)).booleanValue();
    }

    private static int zzb(JSONObject jSONObject, String str, zzmk<Integer> zzmkVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException e) {
            }
        }
        return ((Integer) zzbv.zzen().zzd(zzmkVar)).intValue();
    }

    private static String zzc(JSONObject jSONObject, String str, zzmk<String> zzmkVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e) {
            }
        }
        return (String) zzbv.zzen().zzd(zzmkVar);
    }
}
