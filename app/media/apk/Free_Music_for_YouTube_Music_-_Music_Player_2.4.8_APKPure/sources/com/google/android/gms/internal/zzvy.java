package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzvy<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzve {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzcdc;
    private final NETWORK_EXTRAS zzcdd;

    public zzvy(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzcdc = mediationAdapter;
        this.zzcdd = network_extras;
    }

    private final SERVER_PARAMETERS zza(String str, int i, String str2) throws RemoteException {
        HashMap hashMap;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } else {
                hashMap = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.zzcdc.getServerParametersType();
            if (serverParametersType != null) {
                SERVER_PARAMETERS newInstance = serverParametersType.newInstance();
                newInstance.load(hashMap);
                return newInstance;
            }
            return null;
        } catch (Throwable th) {
            zzaji.zzc("Could not get MediationServerParameters.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void destroy() throws RemoteException {
        try {
            this.zzcdc.destroy();
        } catch (Throwable th) {
            zzaji.zzc("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzky getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final IObjectWrapper getView() throws RemoteException {
        if (!(this.zzcdc instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzcdc.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.zzn.zzw(((MediationBannerAdapter) this.zzcdc).getBannerView());
        } catch (Throwable th) {
            zzaji.zzc("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void showInterstitial() throws RemoteException {
        if (!(this.zzcdc instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzcdc.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzcdc).showInterstitial();
        } catch (Throwable th) {
            zzaji.zzc("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void showVideo() {
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzaeg zzaegVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, zzaeg zzaegVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, zzvg zzvgVar) throws RemoteException {
        zza(iObjectWrapper, zzixVar, str, (String) null, zzvgVar);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, String str2, zzvg zzvgVar) throws RemoteException {
        if (!(this.zzcdc instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzcdc.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzcdc).requestInterstitialAd(new zzvz(zzvgVar), (Activity) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper), zza(str, zzixVar.zzbbp, str2), zzwl.zzn(zzixVar), this.zzcdd);
        } catch (Throwable th) {
            zzaji.zzc("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, String str2, zzvg zzvgVar, zzot zzotVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzjb zzjbVar, zzix zzixVar, String str, zzvg zzvgVar) throws RemoteException {
        zza(iObjectWrapper, zzjbVar, zzixVar, str, null, zzvgVar);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzjb zzjbVar, zzix zzixVar, String str, String str2, zzvg zzvgVar) throws RemoteException {
        if (!(this.zzcdc instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzcdc.getClass().getCanonicalName());
            zzaji.zzcs(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzaji.zzcb("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.zzcdc).requestBannerAd(new zzvz(zzvgVar), (Activity) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper), zza(str, zzixVar.zzbbp, str2), zzwl.zzb(zzjbVar), zzwl.zzn(zzixVar), this.zzcdd);
        } catch (Throwable th) {
            zzaji.zzc("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(zzix zzixVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zzc(zzix zzixVar, String str) {
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzvm zzls() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzvp zzlt() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final Bundle zzlu() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzvd
    public final Bundle zzlv() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzvd
    public final boolean zzlw() {
        return false;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzpt zzlx() {
        return null;
    }
}
