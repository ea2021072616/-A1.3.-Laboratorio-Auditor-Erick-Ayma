package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzakk;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class zzf implements Runnable {
    private /* synthetic */ String zzbyn;
    private /* synthetic */ JSONObject zzbyo;
    private /* synthetic */ zze zzbyp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(zze zzeVar, String str, JSONObject jSONObject) {
        this.zzbyp = zzeVar;
        this.zzbyn = str;
        this.zzbyo = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzakk zzakkVar;
        zzakkVar = this.zzbyp.zzbvz;
        zzakkVar.zza(this.zzbyn, this.zzbyo);
    }
}
