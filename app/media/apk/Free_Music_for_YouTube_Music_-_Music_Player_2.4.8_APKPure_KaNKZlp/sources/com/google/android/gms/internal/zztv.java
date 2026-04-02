package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@zzzt
/* loaded from: classes.dex */
public final class zztv {
    private final Map<zztw, zztx> zzbxh = new HashMap();
    private final LinkedList<zztw> zzbxi = new LinkedList<>();
    @Nullable
    private zzss zzbxj;

    private static void zza(String str, zztw zztwVar) {
        if (zzafx.zzad(2)) {
            zzafx.v(String.format(str, zztwVar));
        }
    }

    private static String[] zzay(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), C.UTF8_NAME);
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private static boolean zzaz(String str) {
        try {
            return Pattern.matches((String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkh), str);
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    private static String zzba(String str) {
        try {
            Matcher matcher = Pattern.compile("([^/]+/[0-9]+).*").matcher(str);
            return matcher.matches() ? matcher.group(1) : str;
        } catch (RuntimeException e) {
            return str;
        }
    }

    private static void zzc(Bundle bundle, String str) {
        while (true) {
            String[] split = str.split("/", 2);
            if (split.length == 0) {
                return;
            }
            String str2 = split[0];
            if (split.length == 1) {
                bundle.remove(str2);
                return;
            }
            bundle = bundle.getBundle(str2);
            if (bundle == null) {
                return;
            }
            str = split[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<String> zzi(zzix zzixVar) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(zzixVar.extras.keySet());
        Bundle bundle = zzixVar.zzbbv.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzix zzj(zzix zzixVar) {
        zzix zzl = zzl(zzixVar);
        Bundle bundle = zzl.zzbbv.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean("_skipMediation", true);
        }
        zzl.extras.putBoolean("_skipMediation", true);
        return zzl;
    }

    private static zzix zzk(zzix zzixVar) {
        String[] split;
        zzix zzl = zzl(zzixVar);
        for (String str : ((String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkd)).split(",")) {
            zzc(zzl.zzbbv, str);
            if (str.startsWith("com.google.ads.mediation.admob.AdMobAdapter/")) {
                zzc(zzl.extras, str.replaceFirst("com.google.ads.mediation.admob.AdMobAdapter/", ""));
            }
        }
        return zzl;
    }

    private final String zzkj() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<zztw> it = this.zzbxi.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(it.next().toString().getBytes(C.UTF8_NAME), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private static zzix zzl(zzix zzixVar) {
        Parcel obtain = Parcel.obtain();
        zzixVar.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        zzix createFromParcel = zzix.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjt)).booleanValue()) {
            zzix.zzh(createFromParcel);
        }
        return createFromParcel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzty zza(zzix zzixVar, String str) {
        zztx zztxVar;
        if (zzaz(str)) {
            return null;
        }
        int i = new zzaci(this.zzbxj.getApplicationContext()).zzop().zzcur;
        zzix zzk = zzk(zzixVar);
        String zzba = zzba(str);
        zztw zztwVar = new zztw(zzk, zzba, i);
        zztx zztxVar2 = this.zzbxh.get(zztwVar);
        if (zztxVar2 == null) {
            zza("Interstitial pool created at %s.", zztwVar);
            zztx zztxVar3 = new zztx(zzk, zzba, i);
            this.zzbxh.put(zztwVar, zztxVar3);
            zztxVar = zztxVar3;
        } else {
            zztxVar = zztxVar2;
        }
        this.zzbxi.remove(zztwVar);
        this.zzbxi.add(zztwVar);
        zztxVar.zzkn();
        while (this.zzbxi.size() > ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbke)).intValue()) {
            zztw remove = this.zzbxi.remove();
            zztx zztxVar4 = this.zzbxh.get(remove);
            zza("Evicting interstitial queue for %s.", remove);
            while (zztxVar4.size() > 0) {
                zzty zzm = zztxVar4.zzm(null);
                if (zzm.zzbxs) {
                    zztz.zzkp().zzkr();
                }
                zzm.zzbxo.zzda();
            }
            this.zzbxh.remove(remove);
        }
        while (zztxVar.size() > 0) {
            zzty zzm2 = zztxVar.zzm(zzk);
            if (zzm2.zzbxs) {
                if (com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis() - zzm2.zzbxr > 1000 * ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkg)).intValue()) {
                    zza("Expired interstitial at %s.", zztwVar);
                    zztz.zzkp().zzkq();
                }
            }
            String str2 = zzm2.zzbxp != null ? " (inline) " : " ";
            zza(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), zztwVar);
            return zzm2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzss zzssVar) {
        if (this.zzbxj == null) {
            this.zzbxj = zzssVar.zzkh();
            if (this.zzbxj != null) {
                SharedPreferences sharedPreferences = this.zzbxj.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
                while (this.zzbxi.size() > 0) {
                    zztw remove = this.zzbxi.remove();
                    zztx zztxVar = this.zzbxh.get(remove);
                    zza("Flushing interstitial queue for %s.", remove);
                    while (zztxVar.size() > 0) {
                        zztxVar.zzm(null).zzbxo.zzda();
                    }
                    this.zzbxh.remove(remove);
                }
                try {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                        if (!entry.getKey().equals("PoolKeys")) {
                            zzub zzbb = zzub.zzbb((String) entry.getValue());
                            zztw zztwVar = new zztw(zzbb.zzari, zzbb.zzapb, zzbb.zzbxm);
                            if (!this.zzbxh.containsKey(zztwVar)) {
                                this.zzbxh.put(zztwVar, new zztx(zzbb.zzari, zzbb.zzapb, zzbb.zzbxm));
                                hashMap.put(zztwVar.toString(), zztwVar);
                                zza("Restored interstitial queue for %s.", zztwVar);
                            }
                        }
                    }
                    for (String str : zzay(sharedPreferences.getString("PoolKeys", ""))) {
                        zztw zztwVar2 = (zztw) hashMap.get(str);
                        if (this.zzbxh.containsKey(zztwVar2)) {
                            this.zzbxi.add(zztwVar2);
                        }
                    }
                } catch (IOException | RuntimeException e) {
                    com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "InterstitialAdPool.restore");
                    zzafx.zzc("Malformed preferences value for InterstitialAdPool.", e);
                    this.zzbxh.clear();
                    this.zzbxi.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzix zzixVar, String str) {
        if (this.zzbxj == null) {
            return;
        }
        int i = new zzaci(this.zzbxj.getApplicationContext()).zzop().zzcur;
        zzix zzk = zzk(zzixVar);
        String zzba = zzba(str);
        zztw zztwVar = new zztw(zzk, zzba, i);
        zztx zztxVar = this.zzbxh.get(zztwVar);
        if (zztxVar == null) {
            zza("Interstitial pool created at %s.", zztwVar);
            zztxVar = new zztx(zzk, zzba, i);
            this.zzbxh.put(zztwVar, zztxVar);
        }
        zztxVar.zza(this.zzbxj, zzixVar);
        zztxVar.zzkn();
        zza("Inline entry added to the queue at %s.", zztwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzki() {
        int size;
        int zzkl;
        if (this.zzbxj == null) {
            return;
        }
        for (Map.Entry<zztw, zztx> entry : this.zzbxh.entrySet()) {
            zztw key = entry.getKey();
            zztx value = entry.getValue();
            if (zzafx.zzad(2) && (zzkl = value.zzkl()) < (size = value.size())) {
                zzafx.v(String.format("Loading %s/%s pooled interstitials for %s.", Integer.valueOf(size - zzkl), Integer.valueOf(size), key));
            }
            int zzkm = value.zzkm() + 0;
            while (value.size() < ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkf)).intValue()) {
                zza("Pooling and loading one new interstitial for %s.", key);
                if (value.zzb(this.zzbxj)) {
                    zzkm++;
                }
            }
            zztz.zzkp().zzs(zzkm);
        }
        if (this.zzbxj != null) {
            SharedPreferences.Editor edit = this.zzbxj.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Map.Entry<zztw, zztx> entry2 : this.zzbxh.entrySet()) {
                zztw key2 = entry2.getKey();
                zztx value2 = entry2.getValue();
                if (value2.zzko()) {
                    edit.putString(key2.toString(), new zzub(value2).zzky());
                    zza("Saved interstitial queue for %s.", key2);
                }
            }
            edit.putString("PoolKeys", zzkj());
            edit.apply();
        }
    }
}
