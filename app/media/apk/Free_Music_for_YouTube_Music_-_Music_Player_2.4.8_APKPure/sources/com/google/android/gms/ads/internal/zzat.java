package com.google.android.gms.ads.internal;

import com.facebook.applinks.AppLinkData;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzakp;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zzpc;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzat implements zzakp {
    private /* synthetic */ zznw zzaqf;
    private /* synthetic */ String zzaqg;
    private /* synthetic */ zzakk zzaqh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(zznw zznwVar, String str, zzakk zzakkVar) {
        this.zzaqf = zznwVar;
        this.zzaqg = str;
        this.zzaqh = zzakkVar;
    }

    @Override // com.google.android.gms.internal.zzakp
    public final void zza(zzakk zzakkVar, boolean z) {
        JSONObject zza;
        zzpc zzd;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", this.zzaqf.getHeadline());
            jSONObject.put(TtmlNode.TAG_BODY, this.zzaqf.getBody());
            jSONObject.put("call_to_action", this.zzaqf.getCallToAction());
            jSONObject.put("price", this.zzaqf.getPrice());
            jSONObject.put("star_rating", String.valueOf(this.zzaqf.getStarRating()));
            jSONObject.put("store", this.zzaqf.getStore());
            jSONObject.put("icon", zzas.zza(this.zzaqf.zzji()));
            JSONArray jSONArray = new JSONArray();
            List<Object> images = this.zzaqf.getImages();
            if (images != null) {
                for (Object obj : images) {
                    zzd = zzas.zzd(obj);
                    jSONArray.put(zzas.zza(zzd));
                }
            }
            jSONObject.put("images", jSONArray);
            zza = zzas.zza(this.zzaqf.getExtras(), this.zzaqg);
            jSONObject.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, zza);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "2");
            this.zzaqh.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            zzafx.zzc("Exception occurred when loading assets", e);
        }
    }
}
