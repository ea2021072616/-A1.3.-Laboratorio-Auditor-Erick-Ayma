package com.google.android.gms.internal;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzok extends zzyr {
    private /* synthetic */ JSONObject zzbsv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzok(zzoi zzoiVar, JSONObject jSONObject) {
        this.zzbsv = jSONObject;
    }

    @Override // com.google.android.gms.internal.zzyr
    public final void zzd(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zzaiVar.zza("google.afma.nativeAds.handleImpressionPing", this.zzbsv);
    }
}
