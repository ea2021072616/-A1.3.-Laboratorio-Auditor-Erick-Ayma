package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zzny;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zzod;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzvp;
import com.google.android.gms.internal.zzyc;
import com.google.android.gms.internal.zzzt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzq extends zzd implements zzof {
    private boolean zzalt;
    private zzafi zzanj;
    private boolean zzank;

    public zzq(Context context, zzv zzvVar, zzjb zzjbVar, String str, zzva zzvaVar, zzajk zzajkVar) {
        super(context, zzjbVar, str, zzvaVar, zzajkVar, zzvVar);
        this.zzank = false;
    }

    private static zzafi zza(zzafj zzafjVar, int i) {
        return new zzafi(zzafjVar.zzcrj.zzcnw, null, zzafjVar.zzcyp.zzcau, i, zzafjVar.zzcyp.zzcav, zzafjVar.zzcyp.zzcpq, zzafjVar.zzcyp.orientation, zzafjVar.zzcyp.zzcba, zzafjVar.zzcrj.zzcnz, zzafjVar.zzcyp.zzcpo, null, null, null, zzafjVar.zzcye, null, zzafjVar.zzcyp.zzcpp, zzafjVar.zzatn, zzafjVar.zzcyp.zzcpn, zzafjVar.zzcyi, zzafjVar.zzcyj, zzafjVar.zzcyp.zzcpt, zzafjVar.zzcyc, null, zzafjVar.zzcyp.zzcqd, zzafjVar.zzcyp.zzcqe, zzafjVar.zzcyp.zzcqe, zzafjVar.zzcyp.zzcqg, zzafjVar.zzcyp.zzcqh, null, zzafjVar.zzcyp.zzcax, zzafjVar.zzcyp.zzcqk, zzafjVar.zzcyo);
    }

    private final boolean zzb(zzafi zzafiVar, zzafi zzafiVar2) {
        zzc((List<String>) null);
        if (!this.zzams.zzfd()) {
            zzafx.zzcs("Native ad does not have custom rendering mode.");
            zzg(0);
            return false;
        }
        try {
            zzvm zzls = zzafiVar2.zzccb != null ? zzafiVar2.zzccb.zzls() : null;
            zzvp zzlt = zzafiVar2.zzccb != null ? zzafiVar2.zzccb.zzlt() : null;
            zzpt zzlx = zzafiVar2.zzccb != null ? zzafiVar2.zzccb.zzlx() : null;
            if (zzls != null && this.zzams.zzatv != null) {
                zznw zznwVar = new zznw(zzls.getHeadline(), zzls.getImages(), zzls.getBody(), zzls.zzji() != null ? zzls.zzji() : null, zzls.getCallToAction(), zzls.getStarRating(), zzls.getStore(), zzls.getPrice(), null, zzls.getExtras(), zzls.getVideoController(), zzls.zzlz() != null ? (View) com.google.android.gms.dynamic.zzn.zzab(zzls.zzlz()) : null);
                zznwVar.zzb(new zzod(this.zzams.zzaie, this, this.zzams.zzati, zzls, zznwVar));
                zzahf.zzdbo.post(new zzs(this, zznwVar));
            } else if (zzlt != null && this.zzams.zzatw != null) {
                zzny zznyVar = new zzny(zzlt.getHeadline(), zzlt.getImages(), zzlt.getBody(), zzlt.zzjo() != null ? zzlt.zzjo() : null, zzlt.getCallToAction(), zzlt.getAdvertiser(), null, zzlt.getExtras(), zzlt.getVideoController(), zzlt.zzlz() != null ? (View) com.google.android.gms.dynamic.zzn.zzab(zzlt.zzlz()) : null);
                zznyVar.zzb(new zzod(this.zzams.zzaie, this, this.zzams.zzati, zzlt, zznyVar));
                zzahf.zzdbo.post(new zzt(this, zznyVar));
            } else if (zzlx == null || this.zzams.zzaty == null || this.zzams.zzaty.get(zzlx.getCustomTemplateId()) == null) {
                zzafx.zzcs("No matching mapper/listener for retrieved native ad template.");
                zzg(0);
                return false;
            } else {
                zzahf.zzdbo.post(new zzu(this, zzlx));
            }
            return super.zza(zzafiVar, zzafiVar2);
        } catch (RemoteException e) {
            zzafx.zzc("Failed to get native ad mapper", e);
            zzg(0);
            return false;
        }
    }

    private final boolean zzc(zzafi zzafiVar, zzafi zzafiVar2) {
        View zzd = zzas.zzd(zzafiVar2);
        if (zzd == null) {
            return false;
        }
        View nextView = this.zzams.zzatk.getNextView();
        if (nextView != null) {
            if (nextView instanceof zzakk) {
                ((zzakk) nextView).destroy();
            }
            this.zzams.zzatk.removeView(nextView);
        }
        if (!zzas.zze(zzafiVar2)) {
            try {
                zzb(zzd);
            } catch (Throwable th) {
                zzbv.zzee().zza(th, "AdLoaderManager.swapBannerViews");
                zzafx.zzc("Could not add mediation view to view hierarchy.", th);
                return false;
            }
        }
        if (this.zzams.zzatk.getChildCount() > 1) {
            this.zzams.zzatk.showNext();
        }
        if (zzafiVar != null) {
            View nextView2 = this.zzams.zzatk.getNextView();
            if (nextView2 != null) {
                this.zzams.zzatk.removeView(nextView2);
            }
            this.zzams.zzfc();
        }
        this.zzams.zzatk.setMinimumWidth(zzbl().widthPixels);
        this.zzams.zzatk.setMinimumHeight(zzbl().heightPixels);
        this.zzams.zzatk.requestLayout();
        this.zzams.zzatk.setVisibility(0);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    @Nullable
    public final zzky getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void pause() {
        if (!this.zzank) {
            throw new IllegalStateException("Native Ad does not support pause().");
        }
        super.pause();
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void resume() {
        if (!this.zzank) {
            throw new IllegalStateException("Native Ad does not support resume().");
        }
        super.resume();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void setManualImpressionsEnabled(boolean z) {
        com.google.android.gms.common.internal.zzbp.zzfx("setManualImpressionsEnabled must be called from the main thread.");
        this.zzalt = z;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzkf
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
    }

    @Override // com.google.android.gms.ads.internal.zza
    public final void zza(zzafj zzafjVar, zznh zznhVar) {
        this.zzanj = null;
        if (zzafjVar.errorCode != -2) {
            this.zzanj = zza(zzafjVar, zzafjVar.errorCode);
        } else if (!zzafjVar.zzcyp.zzcpo) {
            zzafx.zzcs("partialAdState is not mediation");
            this.zzanj = zza(zzafjVar, 0);
        }
        if (this.zzanj != null) {
            zzahf.zzdbo.post(new zzr(this));
            return;
        }
        if (zzafjVar.zzatn != null) {
            this.zzams.zzatn = zzafjVar.zzatn;
        }
        this.zzams.zzauj = 0;
        zzbw zzbwVar = this.zzams;
        zzbv.zzdz();
        zzbwVar.zzatm = zzyc.zza(this.zzams.zzaie, this, zzafjVar, this.zzams.zzati, null, this.zzana, this, zznhVar);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void zza(zznn zznnVar) {
        throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
    }

    @Override // com.google.android.gms.internal.zzof
    public final void zza(zzoc zzocVar) {
        zzafx.zzcs("Unexpected call to AdLoaderManager method");
    }

    @Override // com.google.android.gms.internal.zzof
    public final void zza(zzoe zzoeVar) {
        zzafx.zzcs("Unexpected call to AdLoaderManager method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public final boolean zza(@Nullable zzafi zzafiVar, zzafi zzafiVar2) {
        boolean z;
        if (this.zzams.zzfd()) {
            if (!zzafiVar2.zzcpo) {
                zzg(0);
                zzafx.zzcs("newState is not mediation.");
                return false;
            }
            if (zzafiVar2.zzcca != null && zzafiVar2.zzcca.zzlj()) {
                if (this.zzams.zzfd() && this.zzams.zzatk != null) {
                    this.zzams.zzatk.zzfg().zzco(zzafiVar2.zzcpt);
                }
                if (!super.zza(zzafiVar, zzafiVar2)) {
                    z = false;
                } else if (!this.zzams.zzfd() || zzc(zzafiVar, zzafiVar2)) {
                    if (!this.zzams.zzfe()) {
                        super.zza(zzafiVar2, false);
                    }
                    z = true;
                } else {
                    zzg(0);
                    z = false;
                }
                if (!z) {
                    return false;
                }
                this.zzank = true;
            } else if (zzafiVar2.zzcca == null || !zzafiVar2.zzcca.zzlk()) {
                zzg(0);
                zzafx.zzcs("Response is neither banner nor native.");
                return false;
            } else if (!zzb(zzafiVar, zzafiVar2)) {
                return false;
            }
            zzd(new ArrayList(Arrays.asList(2)));
            return true;
        }
        throw new IllegalStateException("AdLoader API does not support custom rendering.");
    }

    @Override // com.google.android.gms.ads.internal.zzd
    protected final boolean zza(zzix zzixVar, zzafi zzafiVar, boolean z) {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final boolean zzb(zzix zzixVar) {
        if (this.zzams.zzaud != null && this.zzams.zzaud.size() == 1 && this.zzams.zzaud.get(0).intValue() == 2) {
            zzafx.e("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
            zzg(0);
            return false;
        } else if (this.zzams.zzauc != null) {
            if (zzixVar.zzbbq != this.zzalt) {
                zzixVar = new zzix(zzixVar.versionCode, zzixVar.zzbbl, zzixVar.extras, zzixVar.zzbbm, zzixVar.zzbbn, zzixVar.zzbbo, zzixVar.zzbbp, zzixVar.zzbbq || this.zzalt, zzixVar.zzbbr, zzixVar.zzbbs, zzixVar.zzbbt, zzixVar.zzbbu, zzixVar.zzbbv, zzixVar.zzbbw, zzixVar.zzbbx, zzixVar.zzbby, zzixVar.zzbbz, zzixVar.zzbca);
            }
            return super.zzb(zzixVar);
        } else {
            return super.zzb(zzixVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzbr() {
        super.zzbr();
        zzafi zzafiVar = this.zzams.zzato;
        if (zzafiVar == null || zzafiVar.zzcca == null || !zzafiVar.zzcca.zzlj() || this.zzams.zzauc == null) {
            return;
        }
        try {
            this.zzams.zzauc.zza(this, com.google.android.gms.dynamic.zzn.zzw(this.zzams.zzaie));
        } catch (RemoteException e) {
            zzafx.zzc("Could not call PublisherAdViewLoadedListener.onPublisherAdViewLoaded().", e);
        }
    }

    public final void zzc(@Nullable List<String> list) {
        com.google.android.gms.common.internal.zzbp.zzfx("setNativeTemplates must be called on the main UI thread.");
        this.zzams.zzaug = list;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzum
    public final void zzcb() {
        if (this.zzams.zzato == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzams.zzato.zzccc) || this.zzams.zzato.zzcca == null || !this.zzams.zzato.zzcca.zzlk()) {
            super.zzcb();
        } else {
            zzbt();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzum
    public final void zzcg() {
        if (this.zzams.zzato == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzams.zzato.zzccc) || this.zzams.zzato.zzcca == null || !this.zzams.zzato.zzcca.zzlk()) {
            super.zzcg();
        } else {
            zzbs();
        }
    }

    @Override // com.google.android.gms.internal.zzof
    public final void zzcn() {
        zzafx.zzcs("Unexpected call to AdLoaderManager method");
    }

    @Override // com.google.android.gms.internal.zzof
    public final boolean zzco() {
        return this.zzams.zzato != null && this.zzams.zzato.zzcpo && this.zzams.zzato.zzcye != null && this.zzams.zzato.zzcye.zzcbg;
    }

    public final void zzd(List<Integer> list) {
        com.google.android.gms.common.internal.zzbp.zzfx("setAllowedAdTypes must be called on the main UI thread.");
        this.zzams.zzaud = list;
    }

    @Override // com.google.android.gms.internal.zzof
    @Nullable
    public final zzqd zzr(String str) {
        com.google.android.gms.common.internal.zzbp.zzfx("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzams.zzatx.get(str);
    }
}
