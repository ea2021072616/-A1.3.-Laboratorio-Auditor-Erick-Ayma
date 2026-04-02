package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@zzzt
/* loaded from: classes.dex */
public final class zzlg {
    private final boolean zzalt;
    private final int zzbcc;
    private final int zzbcf;
    private final String zzbcg;
    private final String zzbci;
    private final Bundle zzbck;
    private final String zzbcm;
    private final boolean zzbco;
    private final Bundle zzbdq;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzbdr;
    private final SearchAdRequest zzbds;
    private final Set<String> zzbdt;
    private final Set<String> zzbdu;
    private final Date zzha;
    private final Set<String> zzhc;
    private final Location zzhe;

    public zzlg(zzlh zzlhVar) {
        this(zzlhVar, null);
    }

    public zzlg(zzlh zzlhVar, SearchAdRequest searchAdRequest) {
        Date date;
        String str;
        int i;
        HashSet hashSet;
        Location location;
        boolean z;
        Bundle bundle;
        HashMap hashMap;
        String str2;
        String str3;
        int i2;
        HashSet hashSet2;
        Bundle bundle2;
        HashSet hashSet3;
        boolean z2;
        date = zzlhVar.zzha;
        this.zzha = date;
        str = zzlhVar.zzbci;
        this.zzbci = str;
        i = zzlhVar.zzbcc;
        this.zzbcc = i;
        hashSet = zzlhVar.zzbdv;
        this.zzhc = Collections.unmodifiableSet(hashSet);
        location = zzlhVar.zzhe;
        this.zzhe = location;
        z = zzlhVar.zzalt;
        this.zzalt = z;
        bundle = zzlhVar.zzbdq;
        this.zzbdq = bundle;
        hashMap = zzlhVar.zzbdw;
        this.zzbdr = Collections.unmodifiableMap(hashMap);
        str2 = zzlhVar.zzbcg;
        this.zzbcg = str2;
        str3 = zzlhVar.zzbcm;
        this.zzbcm = str3;
        this.zzbds = searchAdRequest;
        i2 = zzlhVar.zzbcf;
        this.zzbcf = i2;
        hashSet2 = zzlhVar.zzbdx;
        this.zzbdt = Collections.unmodifiableSet(hashSet2);
        bundle2 = zzlhVar.zzbck;
        this.zzbck = bundle2;
        hashSet3 = zzlhVar.zzbdy;
        this.zzbdu = Collections.unmodifiableSet(hashSet3);
        z2 = zzlhVar.zzbco;
        this.zzbco = z2;
    }

    public final Date getBirthday() {
        return this.zzha;
    }

    public final String getContentUrl() {
        return this.zzbci;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzbdq.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.zzbck;
    }

    public final int getGender() {
        return this.zzbcc;
    }

    public final Set<String> getKeywords() {
        return this.zzhc;
    }

    public final Location getLocation() {
        return this.zzhe;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzalt;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzbdr.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.zzbdq.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.zzbcg;
    }

    public final boolean isDesignedForFamilies() {
        return this.zzbco;
    }

    public final boolean isTestDevice(Context context) {
        Set<String> set = this.zzbdt;
        zzjo.zzhu();
        return set.contains(zzaje.zzay(context));
    }

    public final String zzhz() {
        return this.zzbcm;
    }

    public final SearchAdRequest zzia() {
        return this.zzbds;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzib() {
        return this.zzbdr;
    }

    public final Bundle zzic() {
        return this.zzbdq;
    }

    public final int zzid() {
        return this.zzbcf;
    }

    public final Set<String> zzie() {
        return this.zzbdu;
    }
}
