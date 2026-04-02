package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzul {
    public final List<zzuk> zzcas;
    public final long zzcat;
    public final List<String> zzcau;
    public final List<String> zzcav;
    public final List<String> zzcaw;
    public final List<String> zzcax;
    public final boolean zzcay;
    public final String zzcaz;
    public final long zzcba;
    public final String zzcbb;
    public final int zzcbc;
    public final int zzcbd;
    public final long zzcbe;
    public final boolean zzcbf;
    public final boolean zzcbg;
    public int zzcbh;
    public int zzcbi;
    public boolean zzcbj;

    public zzul(String str) throws JSONException {
        this(new JSONObject(str));
    }

    public zzul(List<zzuk> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.zzcas = list;
        this.zzcat = j;
        this.zzcau = list2;
        this.zzcav = list3;
        this.zzcaw = list4;
        this.zzcax = list5;
        this.zzcay = z;
        this.zzcaz = str;
        this.zzcba = -1L;
        this.zzcbh = 0;
        this.zzcbi = 1;
        this.zzcbb = null;
        this.zzcbc = 0;
        this.zzcbd = -1;
        this.zzcbe = -1L;
        this.zzcbf = false;
        this.zzcbg = false;
        this.zzcbj = false;
    }

    public zzul(JSONObject jSONObject) throws JSONException {
        if (zzafx.zzad(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzafx.v(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzuk zzukVar = new zzuk(jSONArray.getJSONObject(i2));
            if (zzukVar.zzlj()) {
                this.zzcbj = true;
            }
            arrayList.add(zzukVar);
            if (i < 0 && zza(zzukVar)) {
                i = i2;
            }
        }
        this.zzcbh = i;
        this.zzcbi = jSONArray.length();
        this.zzcas = Collections.unmodifiableList(arrayList);
        this.zzcaz = jSONObject.optString("qdata");
        this.zzcbd = jSONObject.optInt("fs_model_type", -1);
        this.zzcbe = jSONObject.optLong("timeout_ms", -1L);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject == null) {
            this.zzcat = -1L;
            this.zzcau = null;
            this.zzcav = null;
            this.zzcaw = null;
            this.zzcax = null;
            this.zzcba = -1L;
            this.zzcbb = null;
            this.zzcbc = 0;
            this.zzcbf = false;
            this.zzcay = false;
            this.zzcbg = false;
            return;
        }
        this.zzcat = optJSONObject.optLong("ad_network_timeout_millis", -1L);
        com.google.android.gms.ads.internal.zzbv.zzeu();
        this.zzcau = zzut.zza(optJSONObject, "click_urls");
        com.google.android.gms.ads.internal.zzbv.zzeu();
        this.zzcav = zzut.zza(optJSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzbv.zzeu();
        this.zzcaw = zzut.zza(optJSONObject, "nofill_urls");
        com.google.android.gms.ads.internal.zzbv.zzeu();
        this.zzcax = zzut.zza(optJSONObject, "remote_ping_urls");
        this.zzcay = optJSONObject.optBoolean("render_in_browser", false);
        long optLong = optJSONObject.optLong("refresh", -1L);
        this.zzcba = optLong > 0 ? optLong * 1000 : -1L;
        zzaek zza = zzaek.zza(optJSONObject.optJSONArray("rewards"));
        if (zza == null) {
            this.zzcbb = null;
            this.zzcbc = 0;
        } else {
            this.zzcbb = zza.type;
            this.zzcbc = zza.zzcww;
        }
        this.zzcbf = optJSONObject.optBoolean("use_displayed_impression", false);
        this.zzcbg = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
    }

    private static boolean zza(zzuk zzukVar) {
        for (String str : zzukVar.zzcac) {
            if (str.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
