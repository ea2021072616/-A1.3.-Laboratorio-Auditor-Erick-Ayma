package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class zzrp implements Runnable {
    private /* synthetic */ Map zzbta;
    final /* synthetic */ zzakk zzbvh;
    private /* synthetic */ zzro zzbvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrp(zzro zzroVar, Map map, zzakk zzakkVar) {
        this.zzbvi = zzroVar;
        this.zzbta = map;
        this.zzbvh = zzakkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzafx.zzcb("Received Http request.");
        JSONObject zzar = this.zzbvi.zzar((String) this.zzbta.get("http_request"));
        if (zzar == null) {
            zzafx.e("Response should not be null.");
        } else {
            zzahf.zzdbo.post(new zzrq(this, zzar));
        }
    }
}
