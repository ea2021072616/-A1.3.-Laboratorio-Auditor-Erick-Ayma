package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzmu;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
final class zzbu {
    private final String zzarv;
    private final Map<String, String> zzarw = new TreeMap();
    private String zzarx;
    private String zzary;

    public zzbu(String str) {
        this.zzarv = str;
    }

    public final String getQuery() {
        return this.zzarx;
    }

    public final void zza(zzix zzixVar, zzajk zzajkVar) {
        this.zzarx = zzixVar.zzbbs.zzbfg;
        Bundle bundle = zzixVar.zzbbv != null ? zzixVar.zzbbv.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle == null) {
            return;
        }
        String str = (String) zzbv.zzen().zzd(zzmu.zzbny);
        for (String str2 : bundle.keySet()) {
            if (str.equals(str2)) {
                this.zzary = bundle.getString(str2);
            } else if (str2.startsWith("csa_")) {
                this.zzarw.put(str2.substring(4), bundle.getString(str2));
            }
        }
        this.zzarw.put("SDKVersion", zzajkVar.zzcp);
    }

    public final String zzds() {
        return this.zzary;
    }

    public final String zzdt() {
        return this.zzarv;
    }

    public final Map<String, String> zzdu() {
        return this.zzarw;
    }
}
