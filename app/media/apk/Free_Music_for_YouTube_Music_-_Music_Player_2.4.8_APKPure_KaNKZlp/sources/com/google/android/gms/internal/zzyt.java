package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzyt extends zzyr {
    final /* synthetic */ String zzclv;
    final /* synthetic */ zzzc zzclw;
    final /* synthetic */ zzajx zzclx;
    final /* synthetic */ zzys zzcly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyt(zzys zzysVar, String str, zzzc zzzcVar, zzajx zzajxVar) {
        this.zzcly = zzysVar;
        this.zzclv = str;
        this.zzclw = zzzcVar;
        this.zzclx = zzajxVar;
    }

    @Override // com.google.android.gms.internal.zzyr
    public final void zzd(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zzafj zzafjVar;
        zzyu zzyuVar = new zzyu(this, zzaiVar);
        this.zzclw.zzcmt = zzyuVar;
        zzaiVar.zza("/nativeAdPreProcess", zzyuVar);
        try {
            zzafjVar = this.zzcly.zzckj;
            JSONObject jSONObject = new JSONObject(zzafjVar.zzcyp.body);
            jSONObject.put("ads_id", this.zzclv);
            zzaiVar.zza("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
        } catch (JSONException e) {
            zzafx.zzc("Exception occurred while invoking javascript", e);
            this.zzclx.set(null);
        }
    }

    @Override // com.google.android.gms.internal.zzyr
    public final void zzny() {
        this.zzclx.set(null);
    }
}
