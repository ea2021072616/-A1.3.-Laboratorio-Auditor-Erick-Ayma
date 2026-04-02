package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzagz;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzaji;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzajx;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzakw;
import com.google.android.gms.internal.zzfl;
import com.google.android.gms.internal.zzfo;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zzny;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zzod;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzog;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzvp;
import com.google.android.gms.internal.zzxn;
import com.google.android.gms.internal.zzyc;
import com.google.android.gms.internal.zzym;
import com.google.android.gms.internal.zzzt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzbc extends zzd implements zzof {
    private final Object mLock;
    private boolean zzand;
    private boolean zzaqv;
    private zzajx<zzog> zzaqw;
    private zzakk zzaqx;
    private int zzaqy;
    private zzym zzaqz;

    public zzbc(Context context, zzv zzvVar, zzjb zzjbVar, String str, zzva zzvaVar, zzajk zzajkVar) {
        this(context, zzvVar, zzjbVar, str, zzvaVar, zzajkVar, false);
    }

    public zzbc(Context context, zzv zzvVar, zzjb zzjbVar, String str, zzva zzvaVar, zzajk zzajkVar, boolean z) {
        super(context, zzjbVar, str, zzvaVar, zzajkVar, zzvVar);
        this.mLock = new Object();
        this.zzaqw = new zzajx<>();
        this.zzaqy = 1;
        this.zzaqv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzbw zzbwVar, zzbw zzbwVar2) {
        if (zzbwVar2.zzatv == null) {
            zzbwVar2.zzatv = zzbwVar.zzatv;
        }
        if (zzbwVar2.zzatw == null) {
            zzbwVar2.zzatw = zzbwVar.zzatw;
        }
        if (zzbwVar2.zzatx == null) {
            zzbwVar2.zzatx = zzbwVar.zzatx;
        }
        if (zzbwVar2.zzaty == null) {
            zzbwVar2.zzaty = zzbwVar.zzaty;
        }
        if (zzbwVar2.zzaua == null) {
            zzbwVar2.zzaua = zzbwVar.zzaua;
        }
        if (zzbwVar2.zzatz == null) {
            zzbwVar2.zzatz = zzbwVar.zzatz;
        }
        if (zzbwVar2.zzaug == null) {
            zzbwVar2.zzaug = zzbwVar.zzaug;
        }
        if (zzbwVar2.zzatq == null) {
            zzbwVar2.zzatq = zzbwVar.zzatq;
        }
        if (zzbwVar2.zzauh == null) {
            zzbwVar2.zzauh = zzbwVar.zzauh;
        }
        if (zzbwVar2.zzatr == null) {
            zzbwVar2.zzatr = zzbwVar.zzatr;
        }
        if (zzbwVar2.zzats == null) {
            zzbwVar2.zzats = zzbwVar.zzats;
        }
        if (zzbwVar2.zzatn == null) {
            zzbwVar2.zzatn = zzbwVar.zzatn;
        }
        if (zzbwVar2.zzato == null) {
            zzbwVar2.zzato = zzbwVar.zzato;
        }
        if (zzbwVar2.zzatp == null) {
            zzbwVar2.zzatp = zzbwVar.zzatp;
        }
    }

    private final void zza(zznw zznwVar) {
        zzahf.zzdbo.post(new zzbg(this, zznwVar));
    }

    private final void zza(zzny zznyVar) {
        zzahf.zzdbo.post(new zzbh(this, zznyVar));
    }

    private final void zzdo() {
        zzahf.zzb(new zzbk(this));
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final String getAdUnitId() {
        return this.zzams.zzath;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzkf
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zza
    public final void zza(zzafj zzafjVar, zznh zznhVar) {
        if (zzafjVar.zzatn != null) {
            this.zzams.zzatn = zzafjVar.zzatn;
        }
        if (zzafjVar.errorCode != -2) {
            zzahf.zzdbo.post(new zzbd(this, zzafjVar));
            return;
        }
        int i = zzafjVar.zzcrj.zzcph;
        if (i == 1) {
            this.zzams.zzauj = 0;
            zzbw zzbwVar = this.zzams;
            zzbv.zzdz();
            zzbwVar.zzatm = zzyc.zza(this.zzams.zzaie, this, zzafjVar, this.zzams.zzati, null, this.zzana, this, zznhVar);
            String valueOf = String.valueOf(this.zzams.zzatm.getClass().getName());
            zzafx.zzcb(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONObject(zzafjVar.zzcyp.body).getJSONArray("slots");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArray3 = jSONArray2.getJSONObject(i2).getJSONArray("ads");
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    jSONArray.put(jSONArray3.get(i3));
                }
            }
            zzdo();
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i; i4++) {
                arrayList.add(zzagz.zza(newFixedThreadPool, new zzbe(this, i4, jSONArray, i, zzafjVar)));
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                try {
                    zzahf.zzdbo.post(new zzbf(this, (zzog) ((zzajr) arrayList.get(i5)).get(((Long) zzbv.zzen().zzd(zzmu.zzbln)).longValue(), TimeUnit.MILLISECONDS), i5, arrayList));
                } catch (InterruptedException e) {
                    zzafx.zzc("Exception occurred while getting an ad response", e);
                    Thread.currentThread().interrupt();
                } catch (CancellationException e2) {
                    e = e2;
                    zzafx.zzc("Exception occurred while getting an ad response", e);
                } catch (ExecutionException e3) {
                    e = e3;
                    zzafx.zzc("Exception occurred while getting an ad response", e);
                } catch (TimeoutException e4) {
                    e = e4;
                    zzafx.zzc("Exception occurred while getting an ad response", e);
                }
            }
        } catch (JSONException e5) {
            zzafx.zzc("Malformed native ad response", e5);
            zzg(0);
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void zza(zznn zznnVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.internal.zzof
    public final void zza(zzoc zzocVar) {
        if (this.zzaqx != null) {
            this.zzaqx.zzb(zzocVar);
        }
    }

    @Override // com.google.android.gms.internal.zzof
    public final void zza(zzoe zzoeVar) {
        if (this.zzams.zzato.zzcyc != null) {
            zzbv.zzee().zzqk().zza(this.zzams.zzatn, this.zzams.zzato, new zzfo(zzoeVar), (com.google.android.gms.ads.internal.js.zzai) null);
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void zza(zzxn zzxnVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    protected final boolean zza(zzafi zzafiVar, zzafi zzafiVar2) {
        zzc((List<String>) null);
        if (this.zzams.zzfd()) {
            if (zzafiVar2.zzcpo) {
                if (((Boolean) zzbv.zzen().zzd(zzmu.zzbmv)).booleanValue()) {
                    zzdo();
                }
                try {
                    zzvm zzls = zzafiVar2.zzccb != null ? zzafiVar2.zzccb.zzls() : null;
                    zzvp zzlt = zzafiVar2.zzccb != null ? zzafiVar2.zzccb.zzlt() : null;
                    zzpt zzlx = zzafiVar2.zzccb != null ? zzafiVar2.zzccb.zzlx() : null;
                    if (zzls != null && this.zzams.zzatv != null) {
                        zznw zznwVar = new zznw(zzls.getHeadline(), zzls.getImages(), zzls.getBody(), zzls.zzji() != null ? zzls.zzji() : null, zzls.getCallToAction(), zzls.getStarRating(), zzls.getStore(), zzls.getPrice(), null, zzls.getExtras(), zzls.getVideoController(), zzls.zzlz() != null ? (View) com.google.android.gms.dynamic.zzn.zzab(zzls.zzlz()) : null);
                        zznwVar.zzb(new zzod(this.zzams.zzaie, this, this.zzams.zzati, zzls, zznwVar));
                        zza(zznwVar);
                    } else if (zzlt != null && this.zzams.zzatw != null) {
                        zzny zznyVar = new zzny(zzlt.getHeadline(), zzlt.getImages(), zzlt.getBody(), zzlt.zzjo() != null ? zzlt.zzjo() : null, zzlt.getCallToAction(), zzlt.getAdvertiser(), null, zzlt.getExtras(), zzlt.getVideoController(), zzlt.zzlz() != null ? (View) com.google.android.gms.dynamic.zzn.zzab(zzlt.zzlz()) : null);
                        zznyVar.zzb(new zzod(this.zzams.zzaie, this, this.zzams.zzati, zzlt, zznyVar));
                        zza(zznyVar);
                    } else if (zzlx == null || this.zzams.zzaty == null || this.zzams.zzaty.get(zzlx.getCustomTemplateId()) == null) {
                        zzafx.zzcs("No matching mapper/listener for retrieved native ad template.");
                        zzg(0);
                        return false;
                    } else {
                        zzahf.zzdbo.post(new zzbj(this, zzlx));
                    }
                } catch (RemoteException e) {
                    zzafx.zzc("Failed to get native ad mapper", e);
                }
            } else {
                zzog zzogVar = zzafiVar2.zzcyk;
                if (this.zzaqv) {
                    this.zzaqw.set(zzogVar);
                } else if ((zzogVar instanceof zzny) && this.zzams.zzatw != null) {
                    zza((zzny) zzafiVar2.zzcyk);
                } else if ((zzogVar instanceof zznw) && this.zzams.zzatv != null) {
                    zza((zznw) zzafiVar2.zzcyk);
                } else if (!(zzogVar instanceof zzoa) || this.zzams.zzaty == null || this.zzams.zzaty.get(((zzoa) zzogVar).getCustomTemplateId()) == null) {
                    zzafx.zzcs("No matching listener for retrieved native ad template.");
                    zzg(0);
                    return false;
                } else {
                    zzahf.zzdbo.post(new zzbi(this, ((zzoa) zzogVar).getCustomTemplateId(), zzafiVar2));
                }
            }
            return super.zza(zzafiVar, zzafiVar2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    @Override // com.google.android.gms.ads.internal.zzd
    protected final boolean zza(zzix zzixVar, zzafi zzafiVar, boolean z) {
        return this.zzamr.zzdp();
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzix zzixVar, zznh zznhVar) {
        try {
            zzdh();
            return super.zza(zzixVar, zznhVar, this.zzaqy);
        } catch (Exception e) {
            if (zzaji.zzad(4)) {
                Log.i(AdRequest.LOGTAG, "Error initializing webview.", e);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzbr() {
        zzc(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzc(int i, boolean z) {
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbmv)).booleanValue()) {
            zzdo();
        }
        super.zzc(i, z);
    }

    public final void zzc(@Nullable List<String> list) {
        com.google.android.gms.common.internal.zzbp.zzfx("setNativeTemplates must be called on the main UI thread.");
        this.zzams.zzaug = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzc(boolean z) {
        super.zzc(z);
        if (this.zzand) {
            if (((Boolean) zzbv.zzen().zzd(zzmu.zzbnd)).booleanValue()) {
                zzdk();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzum
    public final void zzcb() {
        if (this.zzams.zzato == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzams.zzato.zzccc)) {
            super.zzcb();
        } else {
            zzbt();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzum
    public final void zzcg() {
        if (this.zzams.zzato == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzams.zzato.zzccc)) {
            super.zzcg();
        } else {
            zzbs();
        }
    }

    @Override // com.google.android.gms.internal.zzof
    public final void zzcn() {
        if (this.zzaqx != null) {
            this.zzaqx.destroy();
            this.zzaqx = null;
        }
    }

    @Override // com.google.android.gms.internal.zzof
    public final boolean zzco() {
        return this.zzams.zzato != null && this.zzams.zzato.zzcpo && this.zzams.zzato.zzcye != null && this.zzams.zzato.zzcye.zzcbg;
    }

    public final void zzd(zzakk zzakkVar) {
        this.zzaqx = zzakkVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzdh() throws zzakw {
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbmv)).booleanValue()) {
            synchronized (this.mLock) {
                this.zzaqz = new zzym(this.zzams.zzaie, this, this.zzams.zzati, this.zzams.zzatj);
                this.zzaqz.zznv();
                this.zzaqz.zznw();
            }
        }
    }

    @Nullable
    public final zzym zzdi() {
        zzym zzymVar;
        synchronized (this.mLock) {
            zzymVar = this.zzaqz;
        }
        return zzymVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Future<zzog> zzdj() {
        return this.zzaqw;
    }

    public final void zzdk() {
        if (this.zzams.zzato == null || this.zzaqx == null) {
            this.zzand = true;
            zzafx.zzcs("Request to enable ActiveView before adState is available.");
            return;
        }
        zzfl zzqk = zzbv.zzee().zzqk();
        zzjb zzjbVar = this.zzams.zzatn;
        zzafi zzafiVar = this.zzams.zzato;
        zzakk zzakkVar = this.zzaqx;
        if (zzakkVar == null) {
            throw null;
        }
        zzqk.zza(zzjbVar, zzafiVar, (View) zzakkVar, this.zzaqx);
        this.zzand = false;
    }

    public final void zzdl() {
        this.zzand = false;
        if (this.zzams.zzato == null || this.zzaqx == null) {
            zzafx.zzcs("Request to enable ActiveView before adState is available.");
        } else {
            zzbv.zzee().zzqk().zzg(this.zzams.zzato);
        }
    }

    public final SimpleArrayMap<String, zzqg> zzdm() {
        com.google.android.gms.common.internal.zzbp.zzfx("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzams.zzaty;
    }

    public final void zzdn() {
        if (this.zzaqx == null || this.zzaqx.zzsm() == null || this.zzams.zzatz == null || this.zzams.zzatz.zzbtg == null) {
            return;
        }
        this.zzaqx.zzsm().zzb(this.zzams.zzatz.zzbtg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzg(int i) {
        zzc(i, false);
    }

    public final void zzh(int i) {
        com.google.android.gms.common.internal.zzbp.zzfx("setMaxNumberOfAds must be called on the main UI thread.");
        this.zzaqy = i;
    }

    @Override // com.google.android.gms.internal.zzof
    @Nullable
    public final zzqd zzr(String str) {
        com.google.android.gms.common.internal.zzbp.zzfx("getOnCustomClickListener must be called on the main UI thread.");
        if (this.zzams.zzatx == null) {
            return null;
        }
        return this.zzams.zzatx.get(str);
    }
}
