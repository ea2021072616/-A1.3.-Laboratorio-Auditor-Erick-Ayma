package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzor implements zzrn {
    private /* synthetic */ com.google.android.gms.ads.internal.js.zzai zzbsy;
    private /* synthetic */ zzom zzbsz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzor(zzom zzomVar, com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        this.zzbsz = zzomVar;
        this.zzbsy = zzaiVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : map.keySet()) {
                jSONObject.put(str2, map.get(str2));
            }
            str = this.zzbsz.zzbsx;
            jSONObject.put("id", str);
            this.zzbsy.zzb("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            zzafx.zzb("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
