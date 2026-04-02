package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzvt extends zzve {
    private final MediationAdapter zzccu;
    private zzvu zzccv;

    public zzvt(MediationAdapter mediationAdapter) {
        this.zzccu = mediationAdapter;
    }

    private final Bundle zza(String str, zzix zzixVar, String str2) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzaji.zzcs(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zzccu instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzixVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzixVar.zzbbp);
                }
            }
            return bundle;
        } catch (Throwable th) {
            zzaji.zzc("Could not get Server Parameters Bundle.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void destroy() throws RemoteException {
        try {
            this.zzccu.onDestroy();
        } catch (Throwable th) {
            zzaji.zzc("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final Bundle getInterstitialAdapterInfo() {
        if (this.zzccu instanceof zzalt) {
            return ((zzalt) this.zzccu).getInterstitialAdapterInfo();
        }
        String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
        zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a v2 MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a v2 MediationInterstitialAdapter: "));
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzky getVideoController() {
        if (this.zzccu instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) this.zzccu).getVideoController();
            } catch (Throwable th) {
                zzaji.zzc("Could not get video controller.", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final IObjectWrapper getView() throws RemoteException {
        if (!(this.zzccu instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.zzn.zzw(((MediationBannerAdapter) this.zzccu).getBannerView());
        } catch (Throwable th) {
            zzaji.zzc("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final boolean isInitialized() throws RemoteException {
        if (!(this.zzccu instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.zzccu).isInitialized();
        } catch (Throwable th) {
            zzaji.zzc("Could not check if adapter is initialized.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void pause() throws RemoteException {
        try {
            this.zzccu.onPause();
        } catch (Throwable th) {
            zzaji.zzc("Could not pause adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void resume() throws RemoteException {
        try {
            this.zzccu.onResume();
        } catch (Throwable th) {
            zzaji.zzc("Could not resume adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void setImmersiveMode(boolean z) throws RemoteException {
        if (!(this.zzccu instanceof OnImmersiveModeUpdatedListener)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcr(valueOf.length() != 0 ? "MediationAdapter is not an OnImmersiveModeUpdatedListener: ".concat(valueOf) : new String("MediationAdapter is not an OnImmersiveModeUpdatedListener: "));
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) this.zzccu).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzaji.zzc("Could not set immersive mode.", th);
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void showInterstitial() throws RemoteException {
        if (!(this.zzccu instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzccu).showInterstitial();
        } catch (Throwable th) {
            zzaji.zzc("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void showVideo() throws RemoteException {
        if (!(this.zzccu instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.zzccu).showVideo();
        } catch (Throwable th) {
            zzaji.zzc("Could not show rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzaeg zzaegVar, List<String> list) throws RemoteException {
        if (!(this.zzccu instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not an InitializableMediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not an InitializableMediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzccu;
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                arrayList.add(zza(str, (zzix) null, (String) null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper), new zzaej(zzaegVar), arrayList);
        } catch (Throwable th) {
            zzaji.zzc("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, zzaeg zzaegVar, String str2) throws RemoteException {
        Bundle bundle;
        zzvs zzvsVar;
        if (!(this.zzccu instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzccu;
            Bundle zza = zza(str2, zzixVar, (String) null);
            if (zzixVar != null) {
                zzvs zzvsVar2 = new zzvs(zzixVar.zzbbl == -1 ? null : new Date(zzixVar.zzbbl), zzixVar.zzbbm, zzixVar.zzbbn != null ? new HashSet(zzixVar.zzbbn) : null, zzixVar.zzbbt, zzixVar.zzbbo, zzixVar.zzbbp, zzixVar.zzbca);
                if (zzixVar.zzbbv != null) {
                    bundle = zzixVar.zzbbv.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                    zzvsVar = zzvsVar2;
                } else {
                    bundle = null;
                    zzvsVar = zzvsVar2;
                }
            } else {
                bundle = null;
                zzvsVar = null;
            }
            mediationRewardedVideoAdAdapter.initialize((Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper), zzvsVar, str, new zzaej(zzaegVar), zza, bundle);
        } catch (Throwable th) {
            zzaji.zzc("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, zzvg zzvgVar) throws RemoteException {
        zza(iObjectWrapper, zzixVar, str, (String) null, zzvgVar);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, String str2, zzvg zzvgVar) throws RemoteException {
        if (!(this.zzccu instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzccu;
            mediationInterstitialAdapter.requestInterstitialAd((Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper), new zzvu(zzvgVar), zza(str, zzixVar, str2), new zzvs(zzixVar.zzbbl == -1 ? null : new Date(zzixVar.zzbbl), zzixVar.zzbbm, zzixVar.zzbbn != null ? new HashSet(zzixVar.zzbbn) : null, zzixVar.zzbbt, zzixVar.zzbbo, zzixVar.zzbbp, zzixVar.zzbca), zzixVar.zzbbv != null ? zzixVar.zzbbv.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzaji.zzc("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, String str2, zzvg zzvgVar, zzot zzotVar, List<String> list) throws RemoteException {
        if (!(this.zzccu instanceof MediationNativeAdapter)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationNativeAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationNativeAdapter: "));
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.zzccu;
            zzvx zzvxVar = new zzvx(zzixVar.zzbbl == -1 ? null : new Date(zzixVar.zzbbl), zzixVar.zzbbm, zzixVar.zzbbn != null ? new HashSet(zzixVar.zzbbn) : null, zzixVar.zzbbt, zzixVar.zzbbo, zzixVar.zzbbp, zzotVar, list, zzixVar.zzbca);
            Bundle bundle = zzixVar.zzbbv != null ? zzixVar.zzbbv.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.zzccv = new zzvu(zzvgVar);
            mediationNativeAdapter.requestNativeAd((Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper), this.zzccv, zza(str, zzixVar, str2), zzvxVar, bundle);
        } catch (Throwable th) {
            zzaji.zzc("Could not request native ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzjb zzjbVar, zzix zzixVar, String str, zzvg zzvgVar) throws RemoteException {
        zza(iObjectWrapper, zzjbVar, zzixVar, str, null, zzvgVar);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzjb zzjbVar, zzix zzixVar, String str, String str2, zzvg zzvgVar) throws RemoteException {
        if (!(this.zzccu instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzccu;
            mediationBannerAdapter.requestBannerAd((Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper), new zzvu(zzvgVar), zza(str, zzixVar, str2), com.google.android.gms.ads.zzb.zza(zzjbVar.width, zzjbVar.height, zzjbVar.zzbcq), new zzvs(zzixVar.zzbbl == -1 ? null : new Date(zzixVar.zzbbl), zzixVar.zzbbm, zzixVar.zzbbn != null ? new HashSet(zzixVar.zzbbn) : null, zzixVar.zzbbt, zzixVar.zzbbo, zzixVar.zzbbp, zzixVar.zzbca), zzixVar.zzbbv != null ? zzixVar.zzbbv.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzaji.zzc("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(zzix zzixVar, String str, String str2) throws RemoteException {
        if (!(this.zzccu instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzccu;
            mediationRewardedVideoAdAdapter.loadAd(new zzvs(zzixVar.zzbbl == -1 ? null : new Date(zzixVar.zzbbl), zzixVar.zzbbm, zzixVar.zzbbn != null ? new HashSet(zzixVar.zzbbn) : null, zzixVar.zzbbt, zzixVar.zzbbo, zzixVar.zzbbp, zzixVar.zzbca), zza(str, zzixVar, str2), zzixVar.zzbbv != null ? zzixVar.zzbbv.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzaji.zzc("Could not load rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zzc(zzix zzixVar, String str) throws RemoteException {
        zza(zzixVar, str, (String) null);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        try {
            ((OnContextChangedListener) this.zzccu).onContextChanged((Context) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
        } catch (Throwable th) {
            zzaji.zza("Could not inform adapter of changed context", th);
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzvm zzls() {
        NativeAdMapper zzma = this.zzccv.zzma();
        if (zzma instanceof NativeAppInstallAdMapper) {
            return new zzvv((NativeAppInstallAdMapper) zzma);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzvp zzlt() {
        NativeAdMapper zzma = this.zzccv.zzma();
        if (zzma instanceof NativeContentAdMapper) {
            return new zzvw((NativeContentAdMapper) zzma);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final Bundle zzlu() {
        if (this.zzccu instanceof zzals) {
            return ((zzals) this.zzccu).zzlu();
        }
        String valueOf = String.valueOf(this.zzccu.getClass().getCanonicalName());
        zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a v2 MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a v2 MediationBannerAdapter: "));
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzvd
    public final Bundle zzlv() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzvd
    public final boolean zzlw() {
        return this.zzccu instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzpt zzlx() {
        NativeCustomTemplateAd zzmb = this.zzccv.zzmb();
        if (zzmb instanceof zzpw) {
            return ((zzpw) zzmb).zzjz();
        }
        return null;
    }
}
