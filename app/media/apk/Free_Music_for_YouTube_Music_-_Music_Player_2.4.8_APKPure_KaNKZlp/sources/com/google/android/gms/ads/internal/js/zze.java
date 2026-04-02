package com.google.android.gms.ads.internal.js;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzaje;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzakw;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzqu;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzxe;
import com.google.android.gms.internal.zzzt;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zze implements zza {
    private final Context mContext;
    private final zzakk zzbvz;

    public zze(Context context, zzajk zzajkVar, @Nullable zzcv zzcvVar, com.google.android.gms.ads.internal.zzv zzvVar) throws zzakw {
        this.mContext = context;
        this.zzbvz = zzbv.zzeb().zza(context, new zzjb(), false, false, zzcvVar, zzajkVar, null, null, zzvVar, zzil.zzhf());
        this.zzbvz.getWebView().setWillNotDraw(true);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzjo.zzhu();
        if (zzaje.zzrq()) {
            runnable.run();
        } else {
            zzahf.zzdbo.post(runnable);
        }
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final void destroy() {
        this.zzbvz.destroy();
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final void zza(zzb zzbVar) {
        this.zzbvz.zzsb().zza(new zzk(this, zzbVar));
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final void zza(zzis zzisVar, com.google.android.gms.ads.internal.overlay.zzw zzwVar, zzqu zzquVar, com.google.android.gms.ads.internal.overlay.zzag zzagVar, boolean z, zzrw zzrwVar, com.google.android.gms.ads.internal.zzw zzwVar2, zzxe zzxeVar) {
        this.zzbvz.zzsb().zza(zzisVar, zzwVar, zzquVar, zzagVar, false, null, new com.google.android.gms.ads.internal.zzw(this.mContext, null, null), null, null);
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zza(String str, zzrn zzrnVar) {
        this.zzbvz.zzsb().zza(str, zzrnVar);
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zza(String str, JSONObject jSONObject) {
        runOnUiThread(new zzf(this, str, jSONObject));
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zzb(String str, zzrn zzrnVar) {
        this.zzbvz.zzsb().zzb(str, zzrnVar);
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzbvz.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final void zzbc(String str) {
        runOnUiThread(new zzh(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final void zzbd(String str) {
        runOnUiThread(new zzj(this, str));
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final void zzbe(String str) {
        runOnUiThread(new zzi(this, str));
    }

    @Override // com.google.android.gms.ads.internal.js.zzai
    public final void zzi(String str, String str2) {
        runOnUiThread(new zzg(this, str, str2));
    }

    @Override // com.google.android.gms.ads.internal.js.zza
    public final zzaj zzla() {
        return new zzak(this);
    }
}
