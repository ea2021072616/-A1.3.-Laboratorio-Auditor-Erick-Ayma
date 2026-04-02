package com.google.android.gms.internal;

import org.json.JSONObject;
/* loaded from: classes2.dex */
final class zzrq implements Runnable {
    private /* synthetic */ JSONObject zzbvj;
    private /* synthetic */ zzrp zzbvk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrq(zzrp zzrpVar, JSONObject jSONObject) {
        this.zzbvk = zzrpVar;
        this.zzbvj = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbvk.zzbvh.zzb("fetchHttpRequestCompleted", this.zzbvj);
        zzafx.zzcb("Dispatched http response.");
    }
}
