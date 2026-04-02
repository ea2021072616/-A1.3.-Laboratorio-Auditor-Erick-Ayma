package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class zzlh {
    private String zzbcg;
    private String zzbci;
    private String zzbcm;
    private boolean zzbco;
    private Date zzha;
    private Location zzhe;
    private final HashSet<String> zzbdv = new HashSet<>();
    private final Bundle zzbdq = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzbdw = new HashMap<>();
    private final HashSet<String> zzbdx = new HashSet<>();
    private final Bundle zzbck = new Bundle();
    private final HashSet<String> zzbdy = new HashSet<>();
    private int zzbcc = -1;
    private boolean zzalt = false;
    private int zzbcf = -1;

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzalt = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzbdw.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(Class<? extends MediationAdapter> cls, Bundle bundle) {
        this.zzbdq.putBundle(cls.getName(), bundle);
    }

    public final void zza(Date date) {
        this.zzha = date;
    }

    public final void zzac(String str) {
        this.zzbdv.add(str);
    }

    public final void zzad(String str) {
        this.zzbdx.add(str);
    }

    public final void zzae(String str) {
        this.zzbdx.remove(str);
    }

    public final void zzaf(String str) {
        this.zzbci = str;
    }

    public final void zzag(String str) {
        this.zzbcg = str;
    }

    public final void zzah(String str) {
        this.zzbcm = str;
    }

    public final void zzai(String str) {
        this.zzbdy.add(str);
    }

    public final void zzb(Location location) {
        this.zzhe = location;
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzbdq.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzbdq.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzbdq.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzf(String str, String str2) {
        this.zzbck.putString(str, str2);
    }

    public final void zzi(boolean z) {
        this.zzbcf = z ? 1 : 0;
    }

    public final void zzj(boolean z) {
        this.zzbco = z;
    }

    public final void zzp(int i) {
        this.zzbcc = i;
    }
}
