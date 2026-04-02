package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@zzzt
/* loaded from: classes.dex */
public final class zzafm {
    private String mAppId;
    private final long zzczb;
    private String zzczf;
    private final List<String> zzczc = new ArrayList();
    private final List<String> zzczd = new ArrayList();
    private final Map<String, zzul> zzcze = new HashMap();
    private boolean zzczg = false;

    public zzafm(String str, long j) {
        this.zzczf = str;
        this.zzczb = j;
        zzcd(str);
    }

    private final void zzcd(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("status", -1) != 1) {
                this.zzczg = false;
                zzafx.zzcs("App settings could not be fetched successfully.");
                return;
            }
            this.zzczg = true;
            this.mAppId = jSONObject.optString("app_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
                    String optString2 = jSONObject2.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        if ("interstitial".equalsIgnoreCase(optString)) {
                            this.zzczd.add(optString2);
                        } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject2.optJSONObject("mediation_config")) != null) {
                            this.zzcze.put(optString2, new zzul(optJSONObject));
                        }
                    }
                }
            }
            zzg(jSONObject);
        } catch (JSONException e) {
            zzafx.zzc("Exception occurred while processing app setting json", e);
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "AppSettings.parseAppSettingsJson");
        }
    }

    private final void zzg(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("persistable_banner_ad_unit_ids");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.zzczc.add(optJSONArray.optString(i));
            }
        }
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final long zzpl() {
        return this.zzczb;
    }

    public final boolean zzpm() {
        return this.zzczg;
    }

    public final String zzpn() {
        return this.zzczf;
    }

    public final Map<String, zzul> zzpo() {
        return this.zzcze;
    }
}
