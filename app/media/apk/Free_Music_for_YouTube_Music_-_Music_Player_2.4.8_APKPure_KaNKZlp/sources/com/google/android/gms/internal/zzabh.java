package com.google.android.gms.internal;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzabh implements Runnable {
    private /* synthetic */ zzabf zzcrc;
    final /* synthetic */ JSONObject zzcrd;
    final /* synthetic */ String zzcre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabh(zzabf zzabfVar, JSONObject jSONObject, String str) {
        this.zzcrc = zzabfVar;
        this.zzcrd = jSONObject;
        this.zzcre = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.js.zzl zzlVar;
        com.google.android.gms.ads.internal.js.zzy zzyVar;
        zzabf zzabfVar = this.zzcrc;
        zzlVar = zzabf.zzcle;
        zzabfVar.zzcrb = zzlVar.zzb((zzcv) null);
        zzyVar = this.zzcrc.zzcrb;
        zzyVar.zza(new zzabi(this), new zzabj(this));
    }
}
