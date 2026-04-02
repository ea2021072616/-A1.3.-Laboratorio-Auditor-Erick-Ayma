package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class zzoo implements zzakp {
    private /* synthetic */ Map zzbta;
    private /* synthetic */ zzon zzbtb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoo(zzon zzonVar, Map map) {
        this.zzbtb = zzonVar;
        this.zzbta = map;
    }

    @Override // com.google.android.gms.internal.zzakp
    public final void zza(zzakk zzakkVar, boolean z) {
        String str;
        this.zzbtb.zzbsz.zzbsx = (String) this.zzbta.get("id");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("messageType", "htmlLoaded");
            str = this.zzbtb.zzbsz.zzbsx;
            jSONObject.put("id", str);
            this.zzbtb.zzbsy.zzb("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            zzafx.zzb("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
