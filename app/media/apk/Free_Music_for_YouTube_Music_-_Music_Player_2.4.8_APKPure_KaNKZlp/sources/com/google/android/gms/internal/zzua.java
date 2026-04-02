package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
@zzzt
/* loaded from: classes.dex */
public final class zzua extends zzkg {
    private final String zzapb;
    private boolean zzapq;
    private final zzss zzbxj;
    @Nullable
    private com.google.android.gms.ads.internal.zzam zzbxo;
    private final zzts zzbyb;

    public zzua(Context context, String str, zzva zzvaVar, zzajk zzajkVar, com.google.android.gms.ads.internal.zzv zzvVar) {
        this(str, new zzss(context, zzvaVar, zzajkVar, zzvVar));
    }

    private zzua(String str, zzss zzssVar) {
        this.zzapb = str;
        this.zzbxj = zzssVar;
        this.zzbyb = new zzts();
        com.google.android.gms.ads.internal.zzbv.zzep().zza(zzssVar);
    }

    private final void abort() {
        if (this.zzbxo != null) {
            return;
        }
        this.zzbxo = this.zzbxj.zzaw(this.zzapb);
        this.zzbyb.zzd(this.zzbxo);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void destroy() throws RemoteException {
        if (this.zzbxo != null) {
            this.zzbxo.destroy();
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.zzkf
    @Nullable
    public final String getMediationAdapterClassName() throws RemoteException {
        if (this.zzbxo != null) {
            return this.zzbxo.getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzky getVideoController() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean isLoading() throws RemoteException {
        return this.zzbxo != null && this.zzbxo.isLoading();
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean isReady() throws RemoteException {
        return this.zzbxo != null && this.zzbxo.isReady();
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void pause() throws RemoteException {
        if (this.zzbxo != null) {
            this.zzbxo.pause();
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void resume() throws RemoteException {
        if (this.zzbxo != null) {
            this.zzbxo.resume();
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void setImmersiveMode(boolean z) {
        this.zzapq = z;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        abort();
        if (this.zzbxo != null) {
            this.zzbxo.setManualImpressionsEnabled(z);
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void showInterstitial() throws RemoteException {
        if (this.zzbxo == null) {
            zzafx.zzcs("Interstitial ad must be loaded before showInterstitial().");
            return;
        }
        this.zzbxo.setImmersiveMode(this.zzapq);
        this.zzbxo.showInterstitial();
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void stopLoading() throws RemoteException {
        if (this.zzbxo != null) {
            this.zzbxo.stopLoading();
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzadj zzadjVar) {
        this.zzbyb.zzbxe = zzadjVar;
        if (this.zzbxo != null) {
            this.zzbyb.zzd(this.zzbxo);
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzjb zzjbVar) throws RemoteException {
        if (this.zzbxo != null) {
            this.zzbxo.zza(zzjbVar);
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzjr zzjrVar) throws RemoteException {
        this.zzbyb.zzbxd = zzjrVar;
        if (this.zzbxo != null) {
            this.zzbyb.zzd(this.zzbxo);
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzju zzjuVar) throws RemoteException {
        this.zzbyb.zzaoq = zzjuVar;
        if (this.zzbxo != null) {
            this.zzbyb.zzd(this.zzbxo);
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzkk zzkkVar) throws RemoteException {
        this.zzbyb.zzbxb = zzkkVar;
        if (this.zzbxo != null) {
            this.zzbyb.zzd(this.zzbxo);
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzkq zzkqVar) throws RemoteException {
        abort();
        if (this.zzbxo != null) {
            this.zzbxo.zza(zzkqVar);
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzle zzleVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzmd zzmdVar) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zznn zznnVar) throws RemoteException {
        this.zzbyb.zzbxc = zznnVar;
        if (this.zzbxo != null) {
            this.zzbyb.zzd(this.zzbxo);
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzxn zzxnVar) throws RemoteException {
        zzafx.zzcs("setInAppPurchaseListener is deprecated and should not be called.");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzxt zzxtVar, String str) throws RemoteException {
        zzafx.zzcs("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean zzb(zzix zzixVar) throws RemoteException {
        if (!zztv.zzi(zzixVar).contains("gw")) {
            abort();
        }
        if (zztv.zzi(zzixVar).contains("_skipMediation")) {
            abort();
        }
        if (zzixVar.zzbbs != null) {
            abort();
        }
        if (this.zzbxo != null) {
            return this.zzbxo.zzb(zzixVar);
        }
        zztv zzep = com.google.android.gms.ads.internal.zzbv.zzep();
        if (zztv.zzi(zzixVar).contains("_ad")) {
            zzep.zzb(zzixVar, this.zzapb);
        }
        zzty zza = zzep.zza(zzixVar, this.zzapb);
        if (zza == null) {
            abort();
            zztz.zzkp().zzkt();
            return this.zzbxo.zzb(zzixVar);
        }
        if (zza.zzbxs) {
            zztz.zzkp().zzks();
        } else {
            zza.load();
            zztz.zzkp().zzkt();
        }
        this.zzbxo = zza.zzbxo;
        zza.zzbxq.zza(this.zzbyb);
        this.zzbyb.zzd(this.zzbxo);
        return zza.zzbxt;
    }

    @Override // com.google.android.gms.internal.zzkf
    @Nullable
    public final IObjectWrapper zzbk() throws RemoteException {
        if (this.zzbxo != null) {
            return this.zzbxo.zzbk();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzkf
    @Nullable
    public final zzjb zzbl() throws RemoteException {
        if (this.zzbxo != null) {
            return this.zzbxo.zzbl();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zzbn() throws RemoteException {
        if (this.zzbxo != null) {
            this.zzbxo.zzbn();
        } else {
            zzafx.zzcs("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzkk zzbw() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzju zzbx() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.zzkf
    @Nullable
    public final String zzch() throws RemoteException {
        if (this.zzbxo != null) {
            return this.zzbxo.zzch();
        }
        return null;
    }
}
