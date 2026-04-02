package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzacm extends zzacq {
    private final Object mLock = new Object();
    @Nullable
    private SharedPreferences zzcvh;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzoq() {
        this.zzcvh.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis()).apply();
    }

    @Override // com.google.android.gms.internal.zzacq
    public final void zza(Context context, zzajk zzajkVar, com.google.android.gms.ads.internal.js.zzy zzyVar) {
        synchronized (this.mLock) {
            if (this.zzcvh == null) {
                this.zzcvh = context.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis() - this.zzcvh.getLong("js_last_update", 0L) < ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmn)).longValue()) {
            zzyVar.release();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzajkVar.zzcp);
            jSONObject.put("mf", com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmo));
            jSONObject.put("cl", "164654066");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            zzyVar.zza(new zzaco(this, new zzacn(this, context, zzyVar), jSONObject, zzyVar), new zzacp(this, zzyVar));
        } catch (JSONException e) {
            zzafx.zzb("Unable to populate SDK Core Constants parameters.", e);
            zzyVar.release();
        }
    }
}
