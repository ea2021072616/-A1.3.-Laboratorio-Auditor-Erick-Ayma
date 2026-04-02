package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzuo implements zzus {
    private final Context mContext;
    private final zzva zzana;
    private final zzot zzaoy;
    private final List<String> zzaoz;
    private final zzajk zzapc;
    private zzix zzari;
    private final zzjb zzaro;
    private final boolean zzauz;
    private final String zzcbm;
    private final long zzcbn;
    private final zzul zzcbo;
    private final zzuk zzcbp;
    private final List<String> zzcbq;
    private final List<String> zzcbr;
    private final boolean zzcbs;
    private zzvd zzcbt;
    private zzvj zzcbv;
    private final Object mLock = new Object();
    private int zzcbu = -2;

    public zzuo(Context context, String str, zzva zzvaVar, zzul zzulVar, zzuk zzukVar, zzix zzixVar, zzjb zzjbVar, zzajk zzajkVar, boolean z, boolean z2, zzot zzotVar, List<String> list, List<String> list2, List<String> list3) {
        this.mContext = context;
        this.zzana = zzvaVar;
        this.zzcbp = zzukVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.zzcbm = zzll();
        } else {
            this.zzcbm = str;
        }
        this.zzcbo = zzulVar;
        this.zzcbn = zzulVar.zzcat != -1 ? zzulVar.zzcat : 10000L;
        this.zzari = zzixVar;
        this.zzaro = zzjbVar;
        this.zzapc = zzajkVar;
        this.zzauz = z;
        this.zzcbs = z2;
        this.zzaoy = zzotVar;
        this.zzaoz = list;
        this.zzcbq = list2;
        this.zzcbr = list3;
    }

    private static zzvd zza(MediationAdapter mediationAdapter) {
        return new zzvt(mediationAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzun zzunVar) {
        String zzbf = zzbf(this.zzcbp.zzcaj);
        try {
            if (this.zzapc.zzdem < 4100000) {
                if (this.zzaro.zzbcr) {
                    this.zzcbt.zza(com.google.android.gms.dynamic.zzn.zzw(this.mContext), this.zzari, zzbf, zzunVar);
                } else {
                    this.zzcbt.zza(com.google.android.gms.dynamic.zzn.zzw(this.mContext), this.zzaro, this.zzari, zzbf, zzunVar);
                }
            } else if (this.zzauz || this.zzcbp.zzlk()) {
                ArrayList arrayList = new ArrayList(this.zzaoz);
                if (this.zzcbq != null) {
                    for (String str : this.zzcbq) {
                        String str2 = ":false";
                        if (this.zzcbr != null && this.zzcbr.contains(str)) {
                            str2 = ":true";
                        }
                        arrayList.add(new StringBuilder(String.valueOf(str).length() + 7 + String.valueOf(str2).length()).append("custom:").append(str).append(str2).toString());
                    }
                }
                this.zzcbt.zza(com.google.android.gms.dynamic.zzn.zzw(this.mContext), this.zzari, zzbf, this.zzcbp.zzcaa, zzunVar, this.zzaoy, arrayList);
            } else if (this.zzaro.zzbcr) {
                this.zzcbt.zza(com.google.android.gms.dynamic.zzn.zzw(this.mContext), this.zzari, zzbf, this.zzcbp.zzcaa, zzunVar);
            } else if (!this.zzcbs) {
                this.zzcbt.zza(com.google.android.gms.dynamic.zzn.zzw(this.mContext), this.zzaro, this.zzari, zzbf, this.zzcbp.zzcaa, zzunVar);
            } else if (this.zzcbp.zzcam != null) {
                this.zzcbt.zza(com.google.android.gms.dynamic.zzn.zzw(this.mContext), this.zzari, zzbf, this.zzcbp.zzcaa, zzunVar, new zzot(zzbg(this.zzcbp.zzcaq)), this.zzcbp.zzcap);
            } else {
                this.zzcbt.zza(com.google.android.gms.dynamic.zzn.zzw(this.mContext), this.zzaro, this.zzari, zzbf, this.zzcbp.zzcaa, zzunVar);
            }
        } catch (RemoteException e) {
            zzafx.zzc("Could not request ad from mediation adapter.", e);
            zzt(5);
        }
    }

    private final String zzbf(String str) {
        if (str == null || !zzlo() || zzu(2)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove("cpm_floor_cents");
            return jSONObject.toString();
        } catch (JSONException e) {
            zzafx.zzcs("Could not remove field. Returning the original value");
            return str;
        }
    }

    private static NativeAdOptions zzbg(String str) {
        int i = 0;
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (str == null) {
            return builder.build();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.setRequestMultipleImages(jSONObject.optBoolean("multiple_images", false));
            builder.setReturnUrlsForImageAssets(jSONObject.optBoolean("only_urls", false));
            String optString = jSONObject.optString("native_image_orientation", "any");
            if ("landscape".equals(optString)) {
                i = 2;
            } else if ("portrait".equals(optString)) {
                i = 1;
            } else if (!"any".equals(optString)) {
                i = -1;
            }
            builder.setImageOrientation(i);
        } catch (JSONException e) {
            zzafx.zzc("Exception occurred when creating native ad options", e);
        }
        return builder.build();
    }

    private final String zzll() {
        try {
            if (!TextUtils.isEmpty(this.zzcbp.zzcae)) {
                return this.zzana.zzbi(this.zzcbp.zzcae) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            zzafx.zzcs("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private final zzvj zzlm() {
        if (this.zzcbu == 0 && zzlo()) {
            try {
                if (zzu(4) && this.zzcbv != null && this.zzcbv.zzlq() != 0) {
                    return this.zzcbv;
                }
            } catch (RemoteException e) {
                zzafx.zzcs("Could not get cpm value from MediationResponseMetadata");
            }
            return new zzuq(zzlp());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzvd zzln() {
        String valueOf = String.valueOf(this.zzcbm);
        zzafx.zzcr(valueOf.length() != 0 ? "Instantiating mediation adapter: ".concat(valueOf) : new String("Instantiating mediation adapter: "));
        if (!this.zzauz && !this.zzcbp.zzlk()) {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbli)).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzcbm)) {
                return zza(new AdMobAdapter());
            }
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzblj)).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.zzcbm)) {
                return zza(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.zzcbm)) {
                return new zzvt(new zzwn());
            }
        }
        try {
            return this.zzana.zzbh(this.zzcbm);
        } catch (RemoteException e) {
            String valueOf2 = String.valueOf(this.zzcbm);
            zzafx.zza(valueOf2.length() != 0 ? "Could not instantiate mediation adapter: ".concat(valueOf2) : new String("Could not instantiate mediation adapter: "), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzlo() {
        return this.zzcbo.zzcbd != -1;
    }

    private final int zzlp() {
        if (this.zzcbp.zzcaj == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.zzcbp.zzcaj);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzcbm)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = zzu(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            zzafx.zzcs("Could not convert to json. Returning 0");
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzu(int i) {
        try {
            Bundle zzlv = this.zzauz ? this.zzcbt.zzlv() : this.zzaro.zzbcr ? this.zzcbt.getInterstitialAdapterInfo() : this.zzcbt.zzlu();
            return zzlv != null && (zzlv.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            zzafx.zzcs("Could not get adapter info. Returning false");
            return false;
        }
    }

    public final void cancel() {
        synchronized (this.mLock) {
            try {
                if (this.zzcbt != null) {
                    this.zzcbt.destroy();
                }
            } catch (RemoteException e) {
                zzafx.zzc("Could not destroy mediation adapter.", e);
            }
            this.zzcbu = -1;
            this.mLock.notify();
        }
    }

    public final zzur zza(long j, long j2) {
        zzur zzurVar;
        synchronized (this.mLock) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzun zzunVar = new zzun();
            zzahf.zzdbo.post(new zzup(this, zzunVar));
            long j3 = this.zzcbn;
            while (this.zzcbu == -2) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                long j4 = j3 - (elapsedRealtime2 - elapsedRealtime);
                long j5 = j2 - (elapsedRealtime2 - j);
                if (j4 <= 0 || j5 <= 0) {
                    zzafx.zzcr("Timed out waiting for adapter.");
                    this.zzcbu = 3;
                } else {
                    try {
                        this.mLock.wait(Math.min(j4, j5));
                    } catch (InterruptedException e) {
                        this.zzcbu = 5;
                    }
                }
            }
            zzurVar = new zzur(this.zzcbp, this.zzcbt, this.zzcbm, zzunVar, this.zzcbu, zzlm(), com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime() - elapsedRealtime);
        }
        return zzurVar;
    }

    @Override // com.google.android.gms.internal.zzus
    public final void zza(int i, zzvj zzvjVar) {
        synchronized (this.mLock) {
            this.zzcbu = 0;
            this.zzcbv = zzvjVar;
            this.mLock.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzus
    public final void zzt(int i) {
        synchronized (this.mLock) {
            this.zzcbu = i;
            this.mLock.notify();
        }
    }
}
