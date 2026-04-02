package com.google.android.gms.ads.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzakc;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class zzaf implements zzakc<com.google.android.gms.ads.internal.js.zzai> {
    private /* synthetic */ zzae zzaol;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(zzae zzaeVar) {
        this.zzaol = zzaeVar;
    }

    @Override // com.google.android.gms.internal.zzakc
    public final /* synthetic */ void zzc(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        com.google.android.gms.ads.internal.js.zzai zzaiVar2 = zzaiVar;
        zzaiVar2.zza("/appSettingsFetched", this.zzaol.zzaog);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.zzaol.zzaoh)) {
                jSONObject.put("app_id", this.zzaol.zzaoh);
            } else if (!TextUtils.isEmpty(this.zzaol.zzaoi)) {
                jSONObject.put("ad_unit_id", this.zzaol.zzaoi);
            }
            jSONObject.put("is_init", this.zzaol.zzaoj);
            jSONObject.put("pn", this.zzaol.zzaok.getPackageName());
            zzaiVar2.zza("AFMA_fetchAppSettings", jSONObject);
        } catch (Exception e) {
            zzaiVar2.zzb("/appSettingsFetched", this.zzaol.zzaog);
            zzafx.zzb("Error requesting application settings", e);
        }
    }
}
