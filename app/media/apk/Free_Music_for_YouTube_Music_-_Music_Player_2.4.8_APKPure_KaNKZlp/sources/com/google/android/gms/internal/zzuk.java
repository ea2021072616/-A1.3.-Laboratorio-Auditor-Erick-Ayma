package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzuk {
    public final String zzcaa;
    public final String zzcab;
    public final List<String> zzcac;
    public final String zzcad;
    public final String zzcae;
    public final List<String> zzcaf;
    public final List<String> zzcag;
    public final List<String> zzcah;
    public final List<String> zzcai;
    public final String zzcaj;
    public final List<String> zzcak;
    public final List<String> zzcal;
    @Nullable
    public final String zzcam;
    @Nullable
    public final String zzcan;
    public final String zzcao;
    @Nullable
    public final List<String> zzcap;
    public final String zzcaq;
    @Nullable
    private String zzcar;

    public zzuk(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, List<String> list4, String str5, String str6, List<String> list5, List<String> list6, String str7, String str8, String str9, List<String> list7, String str10, List<String> list8, String str11) {
        this.zzcaa = str;
        this.zzcab = null;
        this.zzcac = list;
        this.zzcad = null;
        this.zzcae = null;
        this.zzcaf = list2;
        this.zzcag = list3;
        this.zzcah = list4;
        this.zzcaj = str5;
        this.zzcak = list5;
        this.zzcal = list6;
        this.zzcam = null;
        this.zzcan = null;
        this.zzcao = null;
        this.zzcap = null;
        this.zzcaq = null;
        this.zzcai = list8;
        this.zzcar = null;
    }

    public zzuk(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.zzcab = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzcac = Collections.unmodifiableList(arrayList);
        this.zzcad = jSONObject.optString("allocation_id", null);
        com.google.android.gms.ads.internal.zzbv.zzeu();
        this.zzcaf = zzut.zza(jSONObject, "clickurl");
        com.google.android.gms.ads.internal.zzbv.zzeu();
        this.zzcag = zzut.zza(jSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzbv.zzeu();
        this.zzcai = zzut.zza(jSONObject, "fill_urls");
        com.google.android.gms.ads.internal.zzbv.zzeu();
        this.zzcak = zzut.zza(jSONObject, "video_start_urls");
        com.google.android.gms.ads.internal.zzbv.zzeu();
        this.zzcal = zzut.zza(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            com.google.android.gms.ads.internal.zzbv.zzeu();
            list = zzut.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzcah = list;
        this.zzcaa = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA);
        this.zzcaj = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzcae = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzcam = jSONObject.optString("html_template", null);
        this.zzcan = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzcao = optJSONObject3 != null ? optJSONObject3.toString() : null;
        com.google.android.gms.ads.internal.zzbv.zzeu();
        this.zzcap = zzut.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzcaq = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzcar = jSONObject.optString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, null);
    }

    public final boolean zzlj() {
        return "banner".equalsIgnoreCase(this.zzcar);
    }

    public final boolean zzlk() {
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equalsIgnoreCase(this.zzcar);
    }
}
