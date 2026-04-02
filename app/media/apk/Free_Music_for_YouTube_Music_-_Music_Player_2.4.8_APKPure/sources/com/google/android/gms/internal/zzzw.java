package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzzw extends zzafv implements zzaac {
    private final Context mContext;
    private zzul zzcbo;
    private zzaak zzccg;
    private zzaao zzckk;
    private Runnable zzckl;
    private final Object zzckm = new Object();
    private final zzzv zzcnj;
    private final zzaal zzcnk;
    private final zzio zzcnl;
    zzahv zzcnm;

    public zzzw(Context context, zzaal zzaalVar, zzzv zzzvVar, zzio zzioVar) {
        this.zzcnj = zzzvVar;
        this.mContext = context;
        this.zzcnk = zzaalVar;
        this.zzcnl = zzioVar;
    }

    private final zzjb zza(zzaak zzaakVar) throws zzzz {
        zzjb[] zzjbVarArr;
        zzjb[] zzjbVarArr2;
        boolean z = true;
        if (!((this.zzccg == null || this.zzccg.zzaud == null || this.zzccg.zzaud.size() <= 1) ? false : false) || this.zzcbo == null || this.zzcbo.zzcbj) {
            if (this.zzckk.zzbcu) {
                for (zzjb zzjbVar : zzaakVar.zzatn.zzbcs) {
                    if (zzjbVar.zzbcu) {
                        return new zzjb(zzjbVar, zzaakVar.zzatn.zzbcs);
                    }
                }
            }
            if (this.zzckk.zzcpr == null) {
                throw new zzzz("The ad response must specify one of the supported ad sizes.", 0);
            }
            String[] split = this.zzckk.zzcpr.split("x");
            if (split.length != 2) {
                String valueOf = String.valueOf(this.zzckk.zzcpr);
                throw new zzzz(valueOf.length() != 0 ? "Invalid ad size format from the ad response: ".concat(valueOf) : new String("Invalid ad size format from the ad response: "), 0);
            }
            try {
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                for (zzjb zzjbVar2 : zzaakVar.zzatn.zzbcs) {
                    float f = this.mContext.getResources().getDisplayMetrics().density;
                    int i = zzjbVar2.width == -1 ? (int) (zzjbVar2.widthPixels / f) : zzjbVar2.width;
                    int i2 = zzjbVar2.height == -2 ? (int) (zzjbVar2.heightPixels / f) : zzjbVar2.height;
                    if (parseInt == i && parseInt2 == i2 && !zzjbVar2.zzbcu) {
                        return new zzjb(zzjbVar2, zzaakVar.zzatn.zzbcs);
                    }
                }
                String valueOf2 = String.valueOf(this.zzckk.zzcpr);
                throw new zzzz(valueOf2.length() != 0 ? "The ad size from the ad response was not one of the requested sizes: ".concat(valueOf2) : new String("The ad size from the ad response was not one of the requested sizes: "), 0);
            } catch (NumberFormatException e) {
                String valueOf3 = String.valueOf(this.zzckk.zzcpr);
                throw new zzzz(valueOf3.length() != 0 ? "Invalid ad size number from the ad response: ".concat(valueOf3) : new String("Invalid ad size number from the ad response: "), 0);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(int i, String str) {
        if (i == 3 || i == -1) {
            zzafx.zzcr(str);
        } else {
            zzafx.zzcs(str);
        }
        if (this.zzckk == null) {
            this.zzckk = new zzaao(i);
        } else {
            this.zzckk = new zzaao(i, this.zzckk.zzcba);
        }
        this.zzcnj.zza(new zzafj(this.zzccg != null ? this.zzccg : new zzaak(this.zzcnk, -1L, null, null, null), this.zzckk, this.zzcbo, (zzjb) null, i, -1L, this.zzckk.zzcps, (JSONObject) null, this.zzcnl));
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void onStop() {
        synchronized (this.zzckm) {
            if (this.zzcnm != null) {
                this.zzcnm.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzahv zza(zzajk zzajkVar, zzajz<zzaak> zzajzVar) {
        Context context = this.mContext;
        if (new zzaab(context).zza(zzajkVar)) {
            zzafx.zzcb("Fetching ad response from local ad request service.");
            zzaah zzaahVar = new zzaah(context, zzajzVar, this);
            zzaahVar.zzns();
            return zzaahVar;
        }
        zzafx.zzcb("Fetching ad response from remote ad request service.");
        zzjo.zzhu();
        if (zzaje.zzba(context)) {
            return new zzaai(context, zzajkVar, zzajzVar, this);
        }
        zzafx.zzcs("Failed to connect to remote ad request service.");
        return null;
    }

    @Override // com.google.android.gms.internal.zzaac
    public final void zza(@NonNull zzaao zzaaoVar) {
        JSONObject jSONObject;
        zzafx.zzcb("Received ad response.");
        this.zzckk = zzaaoVar;
        long elapsedRealtime = com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime();
        synchronized (this.zzckm) {
            this.zzcnm = null;
        }
        com.google.android.gms.ads.internal.zzbv.zzee().zzf(this.mContext, this.zzckk.zzcos);
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbka)).booleanValue()) {
            if (this.zzckk.zzcpe) {
                com.google.android.gms.ads.internal.zzbv.zzee();
                Context context = this.mContext;
                String str = this.zzccg.zzath;
                SharedPreferences sharedPreferences = context.getSharedPreferences("admob", 0);
                Set<String> stringSet = sharedPreferences.getStringSet("never_pool_slots", Collections.emptySet());
                if (!stringSet.contains(str)) {
                    HashSet hashSet = new HashSet(stringSet);
                    hashSet.add(str);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putStringSet("never_pool_slots", hashSet);
                    edit.apply();
                }
            } else {
                com.google.android.gms.ads.internal.zzbv.zzee();
                Context context2 = this.mContext;
                String str2 = this.zzccg.zzath;
                SharedPreferences sharedPreferences2 = context2.getSharedPreferences("admob", 0);
                Set<String> stringSet2 = sharedPreferences2.getStringSet("never_pool_slots", Collections.emptySet());
                if (stringSet2.contains(str2)) {
                    HashSet hashSet2 = new HashSet(stringSet2);
                    hashSet2.remove(str2);
                    SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                    edit2.putStringSet("never_pool_slots", hashSet2);
                    edit2.apply();
                }
            }
        }
        try {
            if (this.zzckk.errorCode != -2 && this.zzckk.errorCode != -3) {
                throw new zzzz(new StringBuilder(66).append("There was a problem getting an ad response. ErrorCode: ").append(this.zzckk.errorCode).toString(), this.zzckk.errorCode);
            }
            if (this.zzckk.errorCode != -3) {
                if (TextUtils.isEmpty(this.zzckk.body)) {
                    throw new zzzz("No fill from ad server.", 3);
                }
                com.google.android.gms.ads.internal.zzbv.zzee().zze(this.mContext, this.zzckk.zzcoe);
                if (this.zzckk.zzcpo) {
                    try {
                        this.zzcbo = new zzul(this.zzckk.body);
                        com.google.android.gms.ads.internal.zzbv.zzee().zzaa(this.zzcbo.zzcay);
                    } catch (JSONException e) {
                        zzafx.zzb("Could not parse mediation config.", e);
                        String valueOf = String.valueOf(this.zzckk.body);
                        throw new zzzz(valueOf.length() != 0 ? "Could not parse mediation config: ".concat(valueOf) : new String("Could not parse mediation config: "), 0);
                    }
                } else {
                    com.google.android.gms.ads.internal.zzbv.zzee().zzaa(this.zzckk.zzcay);
                }
                if (!TextUtils.isEmpty(this.zzckk.zzcot)) {
                    if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzboh)).booleanValue()) {
                        zzafx.zzcb("Received cookie from server. Setting webview cookie in CookieManager.");
                        CookieManager zzav = com.google.android.gms.ads.internal.zzbv.zzec().zzav(this.mContext);
                        if (zzav != null) {
                            zzav.setCookie("googleads.g.doubleclick.net", this.zzckk.zzcot);
                        }
                    }
                }
            }
            zzjb zza = this.zzccg.zzatn.zzbcs != null ? zza(this.zzccg) : null;
            com.google.android.gms.ads.internal.zzbv.zzee().zzy(this.zzckk.zzcpy);
            com.google.android.gms.ads.internal.zzbv.zzee().zzz(this.zzckk.zzcql);
            if (!TextUtils.isEmpty(this.zzckk.zzcpw)) {
                try {
                    jSONObject = new JSONObject(this.zzckk.zzcpw);
                } catch (Exception e2) {
                    zzafx.zzb("Error parsing the JSON for Active View.", e2);
                }
                this.zzcnj.zza(new zzafj(this.zzccg, this.zzckk, this.zzcbo, zza, -2, elapsedRealtime, this.zzckk.zzcps, jSONObject, this.zzcnl));
                zzahf.zzdbo.removeCallbacks(this.zzckl);
            }
            jSONObject = null;
            this.zzcnj.zza(new zzafj(this.zzccg, this.zzckk, this.zzcbo, zza, -2, elapsedRealtime, this.zzckk.zzcps, jSONObject, this.zzcnl));
            zzahf.zzdbo.removeCallbacks(this.zzckl);
        } catch (zzzz e3) {
            zzd(e3.getErrorCode(), e3.getMessage());
            zzahf.zzdbo.removeCallbacks(this.zzckl);
        }
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        String string;
        zzafx.zzcb("AdLoaderBackgroundTask started.");
        this.zzckl = new zzzx(this);
        zzahf.zzdbo.postDelayed(this.zzckl, ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzblm)).longValue());
        long elapsedRealtime = com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime();
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzblk)).booleanValue() && this.zzcnk.zzcnw.extras != null && (string = this.zzcnk.zzcnw.extras.getString("_ad")) != null) {
            this.zzccg = new zzaak(this.zzcnk, elapsedRealtime, null, null, null);
            zza(zzabz.zza(this.mContext, this.zzccg, string));
            return;
        }
        zzakd zzakdVar = new zzakd();
        zzagz.zza(new zzzy(this, zzakdVar));
        String zzx = com.google.android.gms.ads.internal.zzbv.zzez().zzx(this.mContext);
        String zzy = com.google.android.gms.ads.internal.zzbv.zzez().zzy(this.mContext);
        String zzz = com.google.android.gms.ads.internal.zzbv.zzez().zzz(this.mContext);
        com.google.android.gms.ads.internal.zzbv.zzez().zzh(this.mContext, zzz);
        this.zzccg = new zzaak(this.zzcnk, elapsedRealtime, zzx, zzy, zzz);
        zzakdVar.zzf(this.zzccg);
    }
}
