package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.GraphResponse;
import com.google.android.gms.common.internal.zzbp;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class zzyu implements zzrn {
    private /* synthetic */ com.google.android.gms.ads.internal.js.zzai zzbsy;
    private /* synthetic */ zzyt zzclz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyu(zzyt zzytVar, com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        this.zzclz = zzytVar;
        this.zzbsy = zzaiVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        JSONObject jSONObject;
        boolean z;
        try {
            String str = map.get(GraphResponse.SUCCESS_KEY);
            String str2 = map.get("failure");
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject(str);
                z = true;
            } else {
                jSONObject = new JSONObject(str2);
                z = false;
            }
        } catch (JSONException e) {
            zzafx.zzb("Malformed native JSON response.", e);
        }
        if (this.zzclz.zzclv.equals(jSONObject.optString("ads_id", ""))) {
            this.zzbsy.zzb("/nativeAdPreProcess", this.zzclz.zzclw.zzcmt);
            if (z) {
                JSONArray optJSONArray = jSONObject.optJSONArray("ads");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.zzclz.zzclx.set(optJSONArray.getJSONObject(0));
                    return;
                }
                this.zzclz.zzcly.zzy(3);
                this.zzclz.zzclx.set(null);
                return;
            }
            this.zzclz.zzcly.zzy(0);
            zzbp.zza(this.zzclz.zzcly.zzoa(), "Unable to set the ad state error!");
            this.zzclz.zzclx.set(null);
        }
    }
}
