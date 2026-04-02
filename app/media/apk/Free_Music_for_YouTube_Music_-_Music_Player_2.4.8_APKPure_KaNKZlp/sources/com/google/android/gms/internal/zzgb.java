package com.google.android.gms.internal;

import org.json.JSONObject;
/* loaded from: classes2.dex */
final class zzgb implements zzakc<com.google.android.gms.ads.internal.js.zzai> {
    private /* synthetic */ JSONObject zzawn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgb(zzfy zzfyVar, JSONObject jSONObject) {
        this.zzawn = jSONObject;
    }

    @Override // com.google.android.gms.internal.zzakc
    public final /* synthetic */ void zzc(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zzaiVar.zza("AFMA_updateActiveView", this.zzawn);
    }
}
