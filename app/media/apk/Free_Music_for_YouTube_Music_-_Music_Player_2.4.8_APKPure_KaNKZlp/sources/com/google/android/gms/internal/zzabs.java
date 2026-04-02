package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzabs extends zzaat {
    private static final Object zzaqm = new Object();
    private static zzabs zzcrx;
    private final Context mContext;
    private final com.google.android.gms.ads.internal.js.zzl zzbzz;
    private final zzabr zzcry;
    private final zzmh zzcrz;

    private zzabs(Context context, zzmh zzmhVar, zzabr zzabrVar) {
        this(context, zzmhVar, zzabrVar, com.google.android.gms.ads.internal.zzbv.zzeq().zzb(context, new zzajk(11200208, 11200208, true)).zzlh());
    }

    private zzabs(Context context, zzmh zzmhVar, zzabr zzabrVar, com.google.android.gms.ads.internal.js.zzl zzlVar) {
        this.mContext = context;
        this.zzcry = zzabrVar;
        this.zzcrz = zzmhVar;
        this.zzbzz = zzlVar;
    }

    private static zzaao zza(Context context, com.google.android.gms.ads.internal.js.zzl zzlVar, zzmh zzmhVar, zzabr zzabrVar, zzaak zzaakVar) {
        String string;
        zzafx.zzcb("Starting ad request from service using: AFMA_getAd");
        zznh zznhVar = new zznh(((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhr)).booleanValue(), "load_ad", zzaakVar.zzatn.zzbcq);
        if (zzaakVar.versionCode > 10 && zzaakVar.zzcom != -1) {
            zznhVar.zza(zznhVar.zzc(zzaakVar.zzcom), "cts");
        }
        zznf zziu = zznhVar.zziu();
        zzajr<Bundle> zzl = zzabrVar.zzcrv.zzl(context);
        zzajr<zzact> zzq = zzabrVar.zzcru.zzq(context);
        zzajr<String> zzcc = zzabrVar.zzcrp.zzcc(zzaakVar.zzcnx.packageName);
        zzajr<String> zza = zzabrVar.zzcrw.zza(zzaakVar.zzcny, zzaakVar.zzcnx);
        Future<zzach> zzp = com.google.android.gms.ads.internal.zzbv.zzek().zzp(context);
        zzajq zzg = zzajn.zzg(null);
        Bundle bundle = zzaakVar.zzcnw.extras;
        zzajq zza2 = (!zzaakVar.zzcos || (bundle != null && bundle.getString("_ad") != null)) ? zzg : zzabrVar.zzcrs.zza(zzaakVar.applicationInfo);
        zzajq zzac = ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjo)).booleanValue() ? zzabrVar.zzcrw.zzac(context) : zzajn.zzg(null);
        Bundle bundle2 = (zzaakVar.versionCode < 4 || zzaakVar.zzcod == null) ? null : zzaakVar.zzcod;
        ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbih)).booleanValue();
        com.google.android.gms.ads.internal.zzbv.zzea();
        if (zzahf.zzc(context, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE") && ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            zzafx.zzcb("Device is offline.");
        }
        String uuid = zzaakVar.versionCode >= 7 ? zzaakVar.zzcoj : UUID.randomUUID().toString();
        zzaca zzacaVar = new zzaca(uuid, zzaakVar.applicationInfo.packageName);
        if (zzaakVar.zzcnw.extras == null || (string = zzaakVar.zzcnw.extras.getString("_ad")) == null) {
            List<String> zze = zzabrVar.zzcrq.zze(zzaakVar.zzcok);
            Bundle bundle3 = (Bundle) zzajn.zza(zzl, null, ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbod)).longValue(), TimeUnit.MILLISECONDS);
            zzact zzactVar = (zzact) zzajn.zza(zzq, null, ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzblh)).longValue(), TimeUnit.MILLISECONDS);
            Location location = (Location) zzajn.zza(zza2, null, ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbnm)).longValue(), TimeUnit.MILLISECONDS);
            AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) zzajn.zza(zzac, null, ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjp)).longValue(), TimeUnit.MILLISECONDS);
            String str = (String) zzajn.zza(zza, null);
            String str2 = (String) zzajn.zza(zzcc, null);
            zzach zzachVar = (zzach) zzajn.zza(zzp, null);
            if (zzachVar == null) {
                zzafx.zzcs("Error fetching device info. This is not recoverable.");
                return new zzaao(0);
            }
            zzabq zzabqVar = new zzabq();
            zzabqVar.zzcrj = zzaakVar;
            zzabqVar.zzcrk = zzachVar;
            zzabqVar.zzcrh = zzactVar;
            zzabqVar.zzbbt = location;
            zzabqVar.zzcrg = bundle3;
            zzabqVar.zzcny = str;
            zzabqVar.zzahj = info;
            if (zze == null) {
                zzabqVar.zzcok.clear();
            }
            zzabqVar.zzcok = zze;
            zzabqVar.zzcod = bundle2;
            zzabqVar.zzcri = str2;
            zzabqVar.zzcrl = zzabrVar.zzcro.zzh(context);
            zzabqVar.zzcrm = zzabrVar.zzcrm;
            JSONObject zza3 = zzabz.zza(context, zzabqVar);
            if (zza3 == null) {
                return new zzaao(0);
            }
            if (zzaakVar.versionCode < 7) {
                try {
                    zza3.put("request_id", uuid);
                } catch (JSONException e) {
                }
            }
            String jSONObject = zza3.toString();
            zznhVar.zza(zziu, "arc");
            zzahf.zzdbo.post(new zzabt(zzlVar, zzacaVar, zznhVar, zznhVar.zziu(), jSONObject));
            try {
                zzacg zzacgVar = zzacaVar.zzoj().get(10L, TimeUnit.SECONDS);
                if (zzacgVar == null) {
                    return new zzaao(0);
                }
                if (zzacgVar.getErrorCode() != -2) {
                    return new zzaao(zzacgVar.getErrorCode());
                }
                if (zznhVar.zziy() != null) {
                    zznhVar.zza(zznhVar.zziy(), "rur");
                }
                zzaao zza4 = TextUtils.isEmpty(zzacgVar.zzoo()) ? null : zzabz.zza(context, zzaakVar, zzacgVar.zzoo());
                if (zza4 == null && !TextUtils.isEmpty(zzacgVar.getUrl())) {
                    zza4 = zza(zzaakVar, context, zzaakVar.zzatj.zzcp, zzacgVar.getUrl(), str2, zzacgVar, zznhVar, zzabrVar);
                }
                if (zza4 == null) {
                    zza4 = new zzaao(0);
                }
                zznhVar.zza(zziu, "tts");
                zza4.zzcqb = zznhVar.zziw();
                return zza4;
            } catch (Exception e2) {
                return new zzaao(0);
            } finally {
                zzahf.zzdbo.post(new zzabw(zzabrVar, context, zzaakVar, zzacaVar));
            }
        }
        return zzabz.zza(context, zzaakVar, string);
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:?, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x016d, code lost:
        com.google.android.gms.internal.zzafx.zzcs(new java.lang.StringBuilder(46).append("Received error HTTP response code: ").append(r9).toString());
        r3 = new com.google.android.gms.internal.zzaao(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0189, code lost:
        r2.disconnect();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.zzaao zza(com.google.android.gms.internal.zzaak r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.google.android.gms.internal.zzacg r18, com.google.android.gms.internal.zznh r19, com.google.android.gms.internal.zzabr r20) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzabs.zza(com.google.android.gms.internal.zzaak, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzacg, com.google.android.gms.internal.zznh, com.google.android.gms.internal.zzabr):com.google.android.gms.internal.zzaao");
    }

    public static zzabs zza(Context context, zzmh zzmhVar, zzabr zzabrVar) {
        zzabs zzabsVar;
        synchronized (zzaqm) {
            if (zzcrx == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzmu.initialize(context);
                zzcrx = new zzabs(context, zzmhVar, zzabrVar);
            }
            zzabsVar = zzcrx;
        }
        return zzabsVar;
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzafx.zzad(2)) {
            zzafx.v(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    zzafx.v(new StringBuilder(String.valueOf(str3).length() + 5).append("    ").append(str3).append(":").toString());
                    for (String str4 : map.get(str3)) {
                        String valueOf = String.valueOf(str4);
                        zzafx.v(valueOf.length() != 0 ? "      ".concat(valueOf) : new String("      "));
                    }
                }
            }
            zzafx.v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), (int) DefaultOggSeeker.MATCH_BYTE_RANGE); i2 += 1000) {
                    zzafx.v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzafx.v("    null");
            }
            zzafx.v(new StringBuilder(34).append("  Response Code:\n    ").append(i).append("\n}").toString());
        }
    }

    @Override // com.google.android.gms.internal.zzaas
    public final void zza(zzaak zzaakVar, zzaav zzaavVar) {
        com.google.android.gms.ads.internal.zzbv.zzee().zzd(this.mContext, zzaakVar.zzatj);
        zzajr<Void> zza = zzagz.zza(new zzabx(this, zzaakVar, zzaavVar));
        com.google.android.gms.ads.internal.zzbv.zzer().zzrj();
        com.google.android.gms.ads.internal.zzbv.zzer().getHandler().postDelayed(new zzaby(this, zza), 60000L);
    }

    @Override // com.google.android.gms.internal.zzaas
    public final void zza(zzabd zzabdVar, zzaay zzaayVar) {
        zzafx.v("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.zzaas
    public final zzaao zzb(zzaak zzaakVar) {
        return zza(this.mContext, this.zzbzz, this.zzcrz, this.zzcry, zzaakVar);
    }
}
