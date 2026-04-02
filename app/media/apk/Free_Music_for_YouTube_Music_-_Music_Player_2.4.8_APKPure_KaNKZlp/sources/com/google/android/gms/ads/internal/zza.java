package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzacw;
import com.google.android.gms.internal.zzadj;
import com.google.android.gms.internal.zzaek;
import com.google.android.gms.internal.zzafc;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzafk;
import com.google.android.gms.internal.zzafs;
import com.google.android.gms.internal.zzaft;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzaje;
import com.google.android.gms.internal.zzfl;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zzqu;
import com.google.android.gms.internal.zzxn;
import com.google.android.gms.internal.zzxt;
import com.google.android.gms.internal.zzyd;
import com.google.android.gms.internal.zzzt;
import com.google.android.gms.internal.zzzv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
@zzzt
/* loaded from: classes.dex */
public abstract class zza extends zzkg implements com.google.android.gms.ads.internal.overlay.zzag, zzafs, zzis, zzqu, zzyd, zzzv {
    protected zznh zzamn;
    protected zznf zzamo;
    private zznf zzamp;
    protected boolean zzamq = false;
    protected final zzbl zzamr = new zzbl(this);
    protected final zzbw zzams;
    @Nullable
    protected transient zzix zzamt;
    protected final zzfl zzamu;
    protected final zzv zzamv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(zzbw zzbwVar, @Nullable zzbl zzblVar, zzv zzvVar) {
        this.zzams = zzbwVar;
        this.zzamv = zzvVar;
        zzbv.zzea().zzah(this.zzams.zzaie);
        zzbv.zzee().zzd(this.zzams.zzaie, this.zzams.zzatj);
        zzbv.zzef().initialize(this.zzams.zzaie);
        this.zzamu = zzbv.zzee().zzqk();
        zzbv.zzed().initialize(this.zzams.zzaie);
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbng)).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(new zzb(this, new CountDownLatch(((Integer) zzbv.zzen().zzd(zzmu.zzbni)).intValue()), timer), 0L, ((Long) zzbv.zzen().zzd(zzmu.zzbnh)).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean zza(zzix zzixVar) {
        Bundle bundle = zzixVar.zzbbv.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        return bundle == null || !bundle.containsKey("gw");
    }

    private static long zzq(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            zzafx.zzcs("Invalid index for Url fetch time in CSI latency info.");
            return -1L;
        } catch (NumberFormatException e2) {
            zzafx.zzcs("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1L;
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public void destroy() {
        com.google.android.gms.common.internal.zzbp.zzfx("destroy must be called on the main UI thread.");
        this.zzamr.cancel();
        this.zzamu.zzh(this.zzams.zzato);
        zzbw zzbwVar = this.zzams;
        if (zzbwVar.zzatk != null) {
            zzbwVar.zzatk.zzfh();
        }
        zzbwVar.zzats = null;
        zzbwVar.zzatt = null;
        zzbwVar.zzaue = null;
        zzbwVar.zzatu = null;
        zzbwVar.zzf(false);
        if (zzbwVar.zzatk != null) {
            zzbwVar.zzatk.removeAllViews();
        }
        zzbwVar.zzfb();
        zzbwVar.zzfc();
        zzbwVar.zzato = null;
    }

    @Override // com.google.android.gms.internal.zzkf
    public String getAdUnitId() {
        return this.zzams.zzath;
    }

    @Override // com.google.android.gms.internal.zzkf
    public zzky getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean isLoading() {
        return this.zzamq;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean isReady() {
        com.google.android.gms.common.internal.zzbp.zzfx("isLoaded must be called on the main UI thread.");
        return this.zzams.zzatl == null && this.zzams.zzatm == null && this.zzams.zzato != null;
    }

    @Override // com.google.android.gms.internal.zzis
    public void onAdClicked() {
        if (this.zzams.zzato == null) {
            zzafx.zzcs("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzafx.zzcb("Pinging click URLs.");
        if (this.zzams.zzatq != null) {
            this.zzams.zzatq.zzpg();
        }
        if (this.zzams.zzato.zzcau != null) {
            zzbv.zzea();
            zzahf.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, zzb(this.zzams.zzato.zzcau));
        }
        if (this.zzams.zzatr != null) {
            try {
                this.zzams.zzatr.onAdClicked();
            } catch (RemoteException e) {
                zzafx.zzc("Could not notify onAdClicked event.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzqu
    public final void onAppEvent(String str, @Nullable String str2) {
        if (this.zzams.zzatt != null) {
            try {
                this.zzams.zzatt.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzafx.zzc("Could not call the AppEventListener.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public void pause() {
        com.google.android.gms.common.internal.zzbp.zzfx("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.zzkf
    public void resume() {
        com.google.android.gms.common.internal.zzbp.zzfx("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.zzkf
    public void setImmersiveMode(boolean z) {
        throw new IllegalStateException("onImmersiveModeUpdated is not supported for current ad type");
    }

    @Override // com.google.android.gms.internal.zzkf
    public void setManualImpressionsEnabled(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void setUserId(String str) {
        zzafx.zzcs("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void stopLoading() {
        com.google.android.gms.common.internal.zzbp.zzfx("stopLoading must be called on the main UI thread.");
        this.zzamq = false;
        this.zzams.zzf(true);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzadj zzadjVar) {
        com.google.android.gms.common.internal.zzbp.zzfx("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzams.zzauf = zzadjVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(@Nullable zzaek zzaekVar) {
        if (this.zzams.zzauf == null) {
            return;
        }
        String str = "";
        int i = 1;
        if (zzaekVar != null) {
            try {
                str = zzaekVar.type;
                i = zzaekVar.zzcww;
            } catch (RemoteException e) {
                zzafx.zzc("Could not call RewardedVideoAdListener.onRewarded().", e);
                return;
            }
        }
        this.zzams.zzauf.zza(new zzacw(str, i));
    }

    @Override // com.google.android.gms.internal.zzzv
    public final void zza(zzafj zzafjVar) {
        if (zzafjVar.zzcyp.zzcps != -1 && !TextUtils.isEmpty(zzafjVar.zzcyp.zzcqb)) {
            long zzq = zzq(zzafjVar.zzcyp.zzcqb);
            if (zzq != -1) {
                this.zzamn.zza(this.zzamn.zzc(zzq + zzafjVar.zzcyp.zzcps), "stc");
            }
        }
        this.zzamn.zzan(zzafjVar.zzcyp.zzcqb);
        this.zzamn.zza(this.zzamo, "arf");
        this.zzamp = this.zzamn.zziu();
        this.zzamn.zzh("gqi", zzafjVar.zzcyp.zzcqc);
        this.zzams.zzatl = null;
        this.zzams.zzatp = zzafjVar;
        zzafjVar.zzcyo.zza(new zzc(this, zzafjVar));
        zzafjVar.zzcyo.zzhg();
        zza(zzafjVar, this.zzamn);
    }

    protected abstract void zza(zzafj zzafjVar, zznh zznhVar);

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzjb zzjbVar) {
        com.google.android.gms.common.internal.zzbp.zzfx("setAdSize must be called on the main UI thread.");
        this.zzams.zzatn = zzjbVar;
        if (this.zzams.zzato != null && this.zzams.zzato.zzcgz != null && this.zzams.zzauj == 0) {
            this.zzams.zzato.zzcgz.zza(zzjbVar);
        }
        if (this.zzams.zzatk == null) {
            return;
        }
        if (this.zzams.zzatk.getChildCount() > 1) {
            this.zzams.zzatk.removeView(this.zzams.zzatk.getNextView());
        }
        this.zzams.zzatk.setMinimumWidth(zzjbVar.widthPixels);
        this.zzams.zzatk.setMinimumHeight(zzjbVar.heightPixels);
        this.zzams.zzatk.requestLayout();
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzjr zzjrVar) {
        com.google.android.gms.common.internal.zzbp.zzfx("setAdListener must be called on the main UI thread.");
        this.zzams.zzatr = zzjrVar;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzju zzjuVar) {
        com.google.android.gms.common.internal.zzbp.zzfx("setAdListener must be called on the main UI thread.");
        this.zzams.zzats = zzjuVar;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzkk zzkkVar) {
        com.google.android.gms.common.internal.zzbp.zzfx("setAppEventListener must be called on the main UI thread.");
        this.zzams.zzatt = zzkkVar;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzkq zzkqVar) {
        com.google.android.gms.common.internal.zzbp.zzfx("setCorrelationIdProvider must be called on the main UI thread");
        this.zzams.zzatu = zzkqVar;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(@Nullable zzle zzleVar) {
        com.google.android.gms.common.internal.zzbp.zzfx("setIconAdOptions must be called on the main UI thread.");
        this.zzams.zzaub = zzleVar;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(@Nullable zzmd zzmdVar) {
        com.google.android.gms.common.internal.zzbp.zzfx("setVideoOptions must be called on the main UI thread.");
        this.zzams.zzaua = zzmdVar;
    }

    public final void zza(zznf zznfVar) {
        this.zzamn = new zznh(((Boolean) zzbv.zzen().zzd(zzmu.zzbhr)).booleanValue(), "load_ad", this.zzams.zzatn.zzbcq);
        this.zzamp = new zznf(-1L, null, null);
        if (zznfVar == null) {
            this.zzamo = new zznf(-1L, null, null);
        } else {
            this.zzamo = new zznf(zznfVar.getTime(), zznfVar.zzir(), zznfVar.zzis());
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public void zza(zznn zznnVar) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    @Override // com.google.android.gms.internal.zzkf
    public void zza(zzxn zzxnVar) {
        zzafx.zzcs("setInAppPurchaseListener is deprecated and should not be called.");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzxt zzxtVar, String str) {
        zzafx.zzcs("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    @Override // com.google.android.gms.internal.zzafs
    public final void zza(HashSet<zzafk> hashSet) {
        this.zzams.zza(hashSet);
    }

    boolean zza(zzafi zzafiVar) {
        return false;
    }

    protected abstract boolean zza(@Nullable zzafi zzafiVar, zzafi zzafiVar2);

    protected abstract boolean zza(zzix zzixVar, zznh zznhVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<String> zzb(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(zzafc.zzb(str, this.zzams.zzaie));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb(View view) {
        zzbx zzbxVar = this.zzams.zzatk;
        if (zzbxVar != null) {
            zzbxVar.addView(view, zzbv.zzec().zzrb());
        }
    }

    @Override // com.google.android.gms.internal.zzyd
    public void zzb(zzafi zzafiVar) {
        this.zzamn.zza(this.zzamp, "awr");
        this.zzams.zzatm = null;
        if (zzafiVar.errorCode != -2 && zzafiVar.errorCode != 3 && this.zzams.zzfa() != null) {
            zzbv.zzee().zzb(this.zzams.zzfa());
        }
        if (zzafiVar.errorCode == -1) {
            this.zzamq = false;
            return;
        }
        if (zza(zzafiVar)) {
            zzafx.zzcb("Ad refresh scheduled.");
        }
        if (zzafiVar.errorCode != -2) {
            zzg(zzafiVar.errorCode);
            return;
        }
        if (this.zzams.zzauh == null) {
            this.zzams.zzauh = new zzaft(this.zzams.zzath);
        }
        this.zzamu.zzg(this.zzams.zzato);
        if (zza(this.zzams.zzato, zzafiVar)) {
            this.zzams.zzato = zzafiVar;
            zzbw zzbwVar = this.zzams;
            if (zzbwVar.zzatq != null) {
                if (zzbwVar.zzato != null) {
                    zzbwVar.zzatq.zzh(zzbwVar.zzato.zzcyi);
                    zzbwVar.zzatq.zzi(zzbwVar.zzato.zzcyj);
                    zzbwVar.zzatq.zzx(zzbwVar.zzato.zzcpo);
                }
                zzbwVar.zzatq.zzw(zzbwVar.zzatn.zzbcr);
            }
            this.zzamn.zzh("is_mraid", this.zzams.zzato.zzfo() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.zzamn.zzh("is_mediation", this.zzams.zzato.zzcpo ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (this.zzams.zzato.zzcgz != null && this.zzams.zzato.zzcgz.zzsb() != null) {
                this.zzamn.zzh("is_delay_pl", this.zzams.zzato.zzcgz.zzsb().zzsx() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            this.zzamn.zza(this.zzamo, "ttc");
            if (zzbv.zzee().zzpt() != null) {
                zzbv.zzee().zzpt().zza(this.zzamn);
            }
            zzbv();
            if (this.zzams.zzfd()) {
                zzbr();
            }
        }
        if (zzafiVar.zzcax != null) {
            zzbv.zzea().zza(this.zzams.zzaie, zzafiVar.zzcax);
        }
    }

    @Override // com.google.android.gms.internal.zzkf
    public boolean zzb(zzix zzixVar) {
        com.google.android.gms.common.internal.zzbp.zzfx("loadAd must be called on the main UI thread.");
        zzbv.zzef().zzgy();
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbjt)).booleanValue()) {
            zzix.zzh(zzixVar);
        }
        if (com.google.android.gms.common.util.zzi.zzcl(this.zzams.zzaie) && zzixVar.zzbbt != null) {
            zzixVar = new zziy(zzixVar).zza(null).zzhl();
        }
        if (this.zzams.zzatl != null || this.zzams.zzatm != null) {
            if (this.zzamt != null) {
                zzafx.zzcs("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            } else {
                zzafx.zzcs("Loading already in progress, saving this object for future refreshes.");
            }
            this.zzamt = zzixVar;
            return false;
        }
        zzafx.zzcr("Starting ad request.");
        zza((zznf) null);
        this.zzamo = this.zzamn.zziu();
        if (zzixVar.zzbbo) {
            zzafx.zzcr("This request is sent from a test device.");
        } else {
            zzjo.zzhu();
            String zzay = zzaje.zzay(this.zzams.zzaie);
            zzafx.zzcr(new StringBuilder(String.valueOf(zzay).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(zzay).append("\") to get test ads on this device.").toString());
        }
        this.zzamr.zzf(zzixVar);
        this.zzamq = zza(zzixVar, this.zzamn);
        return this.zzamq;
    }

    public final zzv zzbj() {
        return this.zzamv;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final IObjectWrapper zzbk() {
        com.google.android.gms.common.internal.zzbp.zzfx("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zzn.zzw(this.zzams.zzatk);
    }

    @Override // com.google.android.gms.internal.zzkf
    @Nullable
    public final zzjb zzbl() {
        com.google.android.gms.common.internal.zzbp.zzfx("getAdSize must be called on the main UI thread.");
        if (this.zzams.zzatn == null) {
            return null;
        }
        return new zzmb(this.zzams.zzatn);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzag
    public final void zzbm() {
        zzbp();
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zzbn() {
        com.google.android.gms.common.internal.zzbp.zzfx("recordManualImpression must be called on the main UI thread.");
        if (this.zzams.zzato == null) {
            zzafx.zzcs("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzafx.zzcb("Pinging manual tracking URLs.");
        if (this.zzams.zzato.zzcym) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.zzams.zzato.zzcpq != null) {
            arrayList.addAll(this.zzams.zzato.zzcpq);
        }
        if (this.zzams.zzato.zzcca != null && this.zzams.zzato.zzcca.zzcah != null) {
            arrayList.addAll(this.zzams.zzato.zzcca.zzcah);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        zzbv.zzea();
        zzahf.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, arrayList);
        this.zzams.zzato.zzcym = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzbo() {
        zzafx.zzcr("Ad closing.");
        if (this.zzams.zzats != null) {
            try {
                this.zzams.zzats.onAdClosed();
            } catch (RemoteException e) {
                zzafx.zzc("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.zzams.zzauf != null) {
            try {
                this.zzams.zzauf.onRewardedVideoAdClosed();
            } catch (RemoteException e2) {
                zzafx.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzbp() {
        zzafx.zzcr("Ad leaving application.");
        if (this.zzams.zzats != null) {
            try {
                this.zzams.zzats.onAdLeftApplication();
            } catch (RemoteException e) {
                zzafx.zzc("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.zzams.zzauf != null) {
            try {
                this.zzams.zzauf.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e2) {
                zzafx.zzc("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzbq() {
        zzafx.zzcr("Ad opening.");
        if (this.zzams.zzats != null) {
            try {
                this.zzams.zzats.onAdOpened();
            } catch (RemoteException e) {
                zzafx.zzc("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.zzams.zzauf != null) {
            try {
                this.zzams.zzauf.onRewardedVideoAdOpened();
            } catch (RemoteException e2) {
                zzafx.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzbr() {
        zzc(false);
    }

    public final void zzbs() {
        zzafx.zzcr("Ad impression.");
        if (this.zzams.zzats != null) {
            try {
                this.zzams.zzats.onAdImpression();
            } catch (RemoteException e) {
                zzafx.zzc("Could not call AdListener.onAdImpression().", e);
            }
        }
    }

    public final void zzbt() {
        zzafx.zzcr("Ad clicked.");
        if (this.zzams.zzats != null) {
            try {
                this.zzams.zzats.onAdClicked();
            } catch (RemoteException e) {
                zzafx.zzc("Could not call AdListener.onAdClicked().", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzbu() {
        if (this.zzams.zzauf == null) {
            return;
        }
        try {
            this.zzams.zzauf.onRewardedVideoStarted();
        } catch (RemoteException e) {
            zzafx.zzc("Could not call RewardedVideoAdListener.onVideoStarted().", e);
        }
    }

    public final void zzbv() {
        zzafi zzafiVar = this.zzams.zzato;
        if (zzafiVar == null || TextUtils.isEmpty(zzafiVar.zzcqk) || zzafiVar.zzcyn || !zzbv.zzej().zzrh()) {
            return;
        }
        zzafx.zzcb("Sending troubleshooting signals to the server.");
        zzbv.zzej().zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, zzafiVar.zzcqk, this.zzams.zzath);
        zzafiVar.zzcyn = true;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzkk zzbw() {
        return this.zzams.zzatt;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzju zzbx() {
        return this.zzams.zzats;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzc(int i, boolean z) {
        zzafx.zzcs(new StringBuilder(30).append("Failed to load ad: ").append(i).toString());
        this.zzamq = z;
        if (this.zzams.zzats != null) {
            try {
                this.zzams.zzats.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzafx.zzc("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.zzams.zzauf != null) {
            try {
                this.zzams.zzauf.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e2) {
                zzafx.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzc(boolean z) {
        zzafx.zzcr("Ad finished loading.");
        this.zzamq = z;
        if (this.zzams.zzats != null) {
            try {
                this.zzams.zzats.onAdLoaded();
            } catch (RemoteException e) {
                zzafx.zzc("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.zzams.zzauf != null) {
            try {
                this.zzams.zzauf.onRewardedVideoAdLoaded();
            } catch (RemoteException e2) {
                zzafx.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zzc(zzix zzixVar) {
        if (this.zzams.zzatk == null) {
            return false;
        }
        ViewParent parent = this.zzams.zzatk.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            return zzbv.zzea().zza(view, view.getContext());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzg(int i) {
        zzc(i, false);
    }
}
