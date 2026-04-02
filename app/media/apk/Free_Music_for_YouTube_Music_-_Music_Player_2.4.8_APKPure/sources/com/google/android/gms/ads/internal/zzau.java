package com.google.android.gms.ads.internal;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.applinks.AppLinkData;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzakp;
import com.google.android.gms.internal.zzny;
import com.google.android.gms.internal.zzpc;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzau implements zzakp {
    private /* synthetic */ String zzaqg;
    private /* synthetic */ zzakk zzaqh;
    private /* synthetic */ zzny zzaqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzau(zzny zznyVar, String str, zzakk zzakkVar) {
        this.zzaqi = zznyVar;
        this.zzaqg = str;
        this.zzaqh = zzakkVar;
    }

    @Override // com.google.android.gms.internal.zzakp
    public final void zza(zzakk zzakkVar, boolean z) {
        JSONObject zza;
        zzpc zzd;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", this.zzaqi.getHeadline());
            jSONObject.put(TtmlNode.TAG_BODY, this.zzaqi.getBody());
            jSONObject.put("call_to_action", this.zzaqi.getCallToAction());
            jSONObject.put("advertiser", this.zzaqi.getAdvertiser());
            jSONObject.put("logo", zzas.zza(this.zzaqi.zzjo()));
            JSONArray jSONArray = new JSONArray();
            List<Object> images = this.zzaqi.getImages();
            if (images != null) {
                for (Object obj : images) {
                    zzd = zzas.zzd(obj);
                    jSONArray.put(zzas.zza(zzd));
                }
            }
            jSONObject.put("images", jSONArray);
            zza = zzas.zza(this.zzaqi.getExtras(), this.zzaqg);
            jSONObject.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, zza);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            this.zzaqh.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            zzafx.zzc("Exception occurred when loading assets", e);
        }
    }
}
