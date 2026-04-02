package com.google.android.gms.internal;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzze implements Runnable {
    final /* synthetic */ JSONObject zzcmw;
    final /* synthetic */ zzajx zzcmx;
    final /* synthetic */ zzzd zzcmy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzze(zzzd zzzdVar, JSONObject jSONObject, zzajx zzajxVar) {
        this.zzcmy = zzzdVar;
        this.zzcmw = jSONObject;
        this.zzcmx = zzajxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzbc zzbcVar;
        ViewTreeObserver.OnGlobalLayoutListener zza;
        ViewTreeObserver.OnScrollChangedListener zzb;
        try {
            zzakk zzoc = this.zzcmy.zzoc();
            zzbcVar = this.zzcmy.zzclf;
            zzbcVar.zzd(zzoc);
            WeakReference weakReference = new WeakReference(zzoc);
            zzakl zzsb = zzoc.zzsb();
            zza = this.zzcmy.zza(weakReference);
            zzb = this.zzcmy.zzb(weakReference);
            zzsb.zza(zza, zzb);
            this.zzcmy.zzi(zzoc);
            zzoc.zzsb().zza(new zzzf(this, zzoc));
            zzoc.zzsb().zza(new zzzg(this));
            zzoc.loadUrl((String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmt));
        } catch (Exception e) {
            zzafx.zzc("Exception occurred while getting video view", e);
            this.zzcmx.set(null);
        }
    }
}
