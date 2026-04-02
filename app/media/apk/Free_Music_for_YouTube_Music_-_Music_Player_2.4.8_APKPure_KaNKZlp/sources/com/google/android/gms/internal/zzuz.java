package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzuz extends zzvb {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> zzccs;

    private final <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> zzvd zzbj(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, zzuz.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new zzvy(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.zzccs.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzvt((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance());
            } else {
                zzaji.zzcs(new StringBuilder(String.valueOf(str).length() + 64).append("Could not instantiate mediation adapter: ").append(str).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        } catch (Throwable th) {
            return zzbk(str);
        }
    }

    private final zzvd zzbk(String str) throws RemoteException {
        try {
            zzaji.zzcb("Reflection failed, retrying using direct instantiation");
        } catch (Throwable th) {
            zzaji.zzc(new StringBuilder(String.valueOf(str).length() + 43).append("Could not instantiate mediation adapter: ").append(str).append(". ").toString(), th);
        }
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
            return new zzvt(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new zzvt(new AdUrlAdapter());
        }
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            return new zzvt(new CustomEventAdapter());
        }
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
            return new zzvy(customEventAdapter, (CustomEventExtras) this.zzccs.get(customEventAdapter.getAdditionalParametersType()));
        }
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzvd zzbh(String str) throws RemoteException {
        return zzbj(str);
    }

    @Override // com.google.android.gms.internal.zzva
    public final boolean zzbi(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzuz.class.getClassLoader()));
        } catch (Throwable th) {
            zzaji.zzcs(new StringBuilder(String.valueOf(str).length() + 80).append("Could not load custom event implementation class: ").append(str).append(", assuming old implementation.").toString());
            return false;
        }
    }

    public final void zzh(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.zzccs = map;
    }
}
