package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqj;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzzt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzai extends zzjy {
    private final Context mContext;
    private final zzv zzamv;
    private final zzva zzana;
    private final zzju zzaoq;
    @Nullable
    private final zzpx zzaor;
    @Nullable
    private final zzqa zzaos;
    @Nullable
    private final zzqj zzaot;
    @Nullable
    private final zzjb zzaou;
    @Nullable
    private final PublisherAdViewOptions zzaov;
    private final SimpleArrayMap<String, zzqg> zzaow;
    private final SimpleArrayMap<String, zzqd> zzaox;
    private final zzot zzaoy;
    private final zzkq zzapa;
    private final String zzapb;
    private final zzajk zzapc;
    @Nullable
    private WeakReference<zzd> zzapd;
    private final Object mLock = new Object();
    private final List<String> zzaoz = zzcx();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(Context context, String str, zzva zzvaVar, zzajk zzajkVar, zzju zzjuVar, zzpx zzpxVar, zzqa zzqaVar, SimpleArrayMap<String, zzqg> simpleArrayMap, SimpleArrayMap<String, zzqd> simpleArrayMap2, zzot zzotVar, zzkq zzkqVar, zzv zzvVar, zzqj zzqjVar, zzjb zzjbVar, PublisherAdViewOptions publisherAdViewOptions) {
        this.mContext = context;
        this.zzapb = str;
        this.zzana = zzvaVar;
        this.zzapc = zzajkVar;
        this.zzaoq = zzjuVar;
        this.zzaos = zzqaVar;
        this.zzaor = zzpxVar;
        this.zzaow = simpleArrayMap;
        this.zzaox = simpleArrayMap2;
        this.zzaoy = zzotVar;
        this.zzapa = zzkqVar;
        this.zzamv = zzvVar;
        this.zzaot = zzqjVar;
        this.zzaou = zzjbVar;
        this.zzaov = publisherAdViewOptions;
        zzmu.initialize(this.mContext);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzahf.zzdbo.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzix zzixVar, int i) {
        zzbc zzbcVar = new zzbc(this.mContext, this.zzamv, zzjb.zzi(this.mContext), this.zzapb, this.zzana, this.zzapc);
        this.zzapd = new WeakReference<>(zzbcVar);
        zzpx zzpxVar = this.zzaor;
        com.google.android.gms.common.internal.zzbp.zzfx("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        zzbcVar.zzams.zzatv = zzpxVar;
        zzqa zzqaVar = this.zzaos;
        com.google.android.gms.common.internal.zzbp.zzfx("setOnContentAdLoadedListener must be called on the main UI thread.");
        zzbcVar.zzams.zzatw = zzqaVar;
        SimpleArrayMap<String, zzqg> simpleArrayMap = this.zzaow;
        com.google.android.gms.common.internal.zzbp.zzfx("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        zzbcVar.zzams.zzaty = simpleArrayMap;
        zzbcVar.zza(this.zzaoq);
        SimpleArrayMap<String, zzqd> simpleArrayMap2 = this.zzaox;
        com.google.android.gms.common.internal.zzbp.zzfx("setOnCustomClickListener must be called on the main UI thread.");
        zzbcVar.zzams.zzatx = simpleArrayMap2;
        zzbcVar.zzc(zzcx());
        zzot zzotVar = this.zzaoy;
        com.google.android.gms.common.internal.zzbp.zzfx("setNativeAdOptions must be called on the main UI thread.");
        zzbcVar.zzams.zzatz = zzotVar;
        zzbcVar.zza(this.zzapa);
        zzbcVar.zzh(i);
        zzbcVar.zzb(zzixVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzcv() {
        return ((Boolean) zzbv.zzen().zzd(zzmu.zzbjr)).booleanValue() && this.zzaot != null;
    }

    private final boolean zzcw() {
        return (this.zzaor == null && this.zzaos == null && (this.zzaow == null || this.zzaow.size() <= 0)) ? false : true;
    }

    private final List<String> zzcx() {
        ArrayList arrayList = new ArrayList();
        if (this.zzaos != null) {
            arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (this.zzaor != null) {
            arrayList.add("2");
        }
        if (this.zzaow.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(zzix zzixVar) {
        zzq zzqVar = new zzq(this.mContext, this.zzamv, this.zzaou, this.zzapb, this.zzana, this.zzapc);
        this.zzapd = new WeakReference<>(zzqVar);
        zzqj zzqjVar = this.zzaot;
        com.google.android.gms.common.internal.zzbp.zzfx("setOnPublisherAdViewLoadedListener must be called on the main UI thread.");
        zzqVar.zzams.zzauc = zzqjVar;
        if (this.zzaov != null) {
            if (this.zzaov.zzbh() != null) {
                zzqVar.zza(this.zzaov.zzbh());
            }
            zzqVar.setManualImpressionsEnabled(this.zzaov.getManualImpressionsEnabled());
        }
        zzpx zzpxVar = this.zzaor;
        com.google.android.gms.common.internal.zzbp.zzfx("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        zzqVar.zzams.zzatv = zzpxVar;
        zzqa zzqaVar = this.zzaos;
        com.google.android.gms.common.internal.zzbp.zzfx("setOnContentAdLoadedListener must be called on the main UI thread.");
        zzqVar.zzams.zzatw = zzqaVar;
        SimpleArrayMap<String, zzqg> simpleArrayMap = this.zzaow;
        com.google.android.gms.common.internal.zzbp.zzfx("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        zzqVar.zzams.zzaty = simpleArrayMap;
        SimpleArrayMap<String, zzqd> simpleArrayMap2 = this.zzaox;
        com.google.android.gms.common.internal.zzbp.zzfx("setOnCustomClickListener must be called on the main UI thread.");
        zzqVar.zzams.zzatx = simpleArrayMap2;
        zzot zzotVar = this.zzaoy;
        com.google.android.gms.common.internal.zzbp.zzfx("setNativeAdOptions must be called on the main UI thread.");
        zzqVar.zzams.zzatz = zzotVar;
        zzqVar.zzc(zzcx());
        zzqVar.zza(this.zzaoq);
        zzqVar.zza(this.zzapa);
        ArrayList arrayList = new ArrayList();
        if (zzcw()) {
            arrayList.add(1);
        }
        if (this.zzaot != null) {
            arrayList.add(2);
        }
        zzqVar.zzd(arrayList);
        if (zzcw()) {
            zzixVar.extras.putBoolean("ina", true);
        }
        if (this.zzaot != null) {
            zzixVar.extras.putBoolean("iba", true);
        }
        zzqVar.zzb(zzixVar);
    }

    @Override // com.google.android.gms.internal.zzjx
    @Nullable
    public final String getMediationAdapterClassName() {
        synchronized (this.mLock) {
            if (this.zzapd != null) {
                zzd zzdVar = this.zzapd.get();
                return zzdVar != null ? zzdVar.getMediationAdapterClassName() : null;
            }
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzjx
    public final boolean isLoading() {
        synchronized (this.mLock) {
            if (this.zzapd != null) {
                zzd zzdVar = this.zzapd.get();
                return zzdVar != null ? zzdVar.isLoading() : false;
            }
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzjx
    public final void zza(zzix zzixVar, int i) {
        int intValue = ((Integer) zzbv.zzen().zzd(zzmu.zzbne)).intValue();
        if (i > intValue) {
            throw new IllegalArgumentException(new StringBuilder(48).append("Cannot request more than ").append(intValue).append(" ads at once").toString());
        }
        if (i <= 0) {
            throw new IllegalArgumentException("Number of ads has to be more than 0");
        }
        runOnUiThread(new zzak(this, zzixVar, i));
    }

    @Override // com.google.android.gms.internal.zzjx
    @Nullable
    public final String zzch() {
        synchronized (this.mLock) {
            if (this.zzapd != null) {
                zzd zzdVar = this.zzapd.get();
                return zzdVar != null ? zzdVar.zzch() : null;
            }
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzjx
    public final void zzd(zzix zzixVar) {
        runOnUiThread(new zzaj(this, zzixVar));
    }
}
