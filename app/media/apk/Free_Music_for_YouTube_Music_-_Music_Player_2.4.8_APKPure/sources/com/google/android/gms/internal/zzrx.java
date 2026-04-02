package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzrx implements zzrn {
    private HashMap<String, zzajx<JSONObject>> zzbvv = new HashMap<>();

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        String str = map.get("request_id");
        String str2 = map.get("fetched_ad");
        zzafx.zzcb("Received ad from the cache.");
        zzajx<JSONObject> zzajxVar = this.zzbvv.get(str);
        if (zzajxVar == null) {
            zzafx.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            zzajxVar.set(new JSONObject(str2));
        } catch (JSONException e) {
            zzafx.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzajxVar.set(null);
        } finally {
            this.zzbvv.remove(str);
        }
    }

    public final Future<JSONObject> zzas(String str) {
        zzajx<JSONObject> zzajxVar = new zzajx<>();
        this.zzbvv.put(str, zzajxVar);
        return zzajxVar;
    }

    public final void zzat(String str) {
        zzajx<JSONObject> zzajxVar = this.zzbvv.get(str);
        if (zzajxVar == null) {
            zzafx.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzajxVar.isDone()) {
            zzajxVar.cancel(true);
        }
        this.zzbvv.remove(str);
    }
}
