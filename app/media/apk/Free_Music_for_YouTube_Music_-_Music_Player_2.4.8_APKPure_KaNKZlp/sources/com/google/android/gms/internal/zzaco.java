package com.google.android.gms.internal;

import org.json.JSONObject;
/* loaded from: classes.dex */
final class zzaco implements zzakc<com.google.android.gms.ads.internal.js.zzai> {
    private /* synthetic */ com.google.android.gms.ads.internal.js.zzy zzcvi;
    private /* synthetic */ zzrn zzcvk;
    private /* synthetic */ JSONObject zzcvl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaco(zzacm zzacmVar, zzrn zzrnVar, JSONObject jSONObject, com.google.android.gms.ads.internal.js.zzy zzyVar) {
        this.zzcvk = zzrnVar;
        this.zzcvl = jSONObject;
        this.zzcvi = zzyVar;
    }

    @Override // com.google.android.gms.internal.zzakc
    public final /* synthetic */ void zzc(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        com.google.android.gms.ads.internal.js.zzai zzaiVar2 = zzaiVar;
        zzaiVar2.zza("/loadSdkConstants", this.zzcvk);
        try {
            zzaiVar2.zza("AFMA_getSdkConstants", this.zzcvl);
        } catch (Exception e) {
            zzafx.zzb("Error requesting an ad url", e);
            this.zzcvi.release();
        }
    }
}
