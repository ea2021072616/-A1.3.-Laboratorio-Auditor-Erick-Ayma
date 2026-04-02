package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.facebook.internal.NativeProtocol;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.zzaao;
import com.google.android.gms.internal.zzabz;
import com.google.android.gms.internal.zzaek;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzaey;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzahk;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzakl;
import com.google.android.gms.internal.zzakw;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.internal.zzsf;
import com.google.android.gms.internal.zzuk;
import com.google.android.gms.internal.zzul;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzzt;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzam extends zzi implements zzrw, zzsf {
    private transient boolean zzapm;
    private int zzapn;
    private boolean zzapo;
    private float zzapp;
    private boolean zzapq;
    private zzaey zzapr;
    private String zzaps;
    private final String zzapt;

    public zzam(Context context, zzjb zzjbVar, String str, zzva zzvaVar, zzajk zzajkVar, zzv zzvVar) {
        super(context, zzjbVar, str, zzvaVar, zzajkVar, zzvVar);
        this.zzapn = -1;
        this.zzapm = false;
        this.zzapt = (zzjbVar == null || !"reward_mb".equals(zzjbVar.zzbcq)) ? "/Interstitial" : "/Rewarded";
    }

    private final void zza(Bundle bundle) {
        zzbv.zzea().zzb(this.zzams.zzaie, this.zzams.zzatj.zzcp, "gmob-apps", bundle, false);
    }

    private static zzafj zzb(zzafj zzafjVar) {
        try {
            String jSONObject = zzabz.zzb(zzafjVar.zzcyp).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzafjVar.zzcrj.zzath);
            zzuk zzukVar = new zzuk(jSONObject, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null);
            zzaao zzaaoVar = zzafjVar.zzcyp;
            zzul zzulVar = new zzul(Collections.singletonList(zzukVar), ((Long) zzbv.zzen().zzd(zzmu.zzbln)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), zzaaoVar.zzcax, zzaaoVar.zzcay, "", -1L, 0, 1, null, 0, -1, -1L, false);
            return new zzafj(zzafjVar.zzcrj, new zzaao(zzafjVar.zzcrj, zzaaoVar.zzchb, zzaaoVar.body, Collections.emptyList(), Collections.emptyList(), zzaaoVar.zzcpn, true, zzaaoVar.zzcpp, Collections.emptyList(), zzaaoVar.zzcba, zzaaoVar.orientation, zzaaoVar.zzcpr, zzaaoVar.zzcps, zzaaoVar.zzcpt, zzaaoVar.zzcpu, zzaaoVar.zzcpv, null, zzaaoVar.zzcpx, zzaaoVar.zzbct, zzaaoVar.zzcoe, zzaaoVar.zzcpy, zzaaoVar.zzcpz, zzaaoVar.zzcqc, zzaaoVar.zzbcu, zzaaoVar.zzbcv, null, Collections.emptyList(), Collections.emptyList(), zzaaoVar.zzcqg, zzaaoVar.zzcqh, zzaaoVar.zzcos, zzaaoVar.zzcot, zzaaoVar.zzcax, zzaaoVar.zzcay, zzaaoVar.zzcqi, null, zzaaoVar.zzcqk, zzaaoVar.zzcql, zzaaoVar.zzcpe), zzulVar, zzafjVar.zzatn, zzafjVar.errorCode, zzafjVar.zzcyi, zzafjVar.zzcyj, (JSONObject) null, zzafjVar.zzcyo);
        } catch (JSONException e) {
            zzafx.zzb("Unable to generate ad state for an interstitial ad with pooling.", e);
            return zzafjVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void setImmersiveMode(boolean z) {
        com.google.android.gms.common.internal.zzbp.zzfx("setImmersiveMode must be called on the main UI thread.");
        this.zzapq = z;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzkf
    public final void showInterstitial() {
        Bitmap bitmap = null;
        com.google.android.gms.common.internal.zzbp.zzfx("showInterstitial must be called on the main UI thread.");
        if (zzbv.zzez().zzu(this.zzams.zzaie)) {
            this.zzaps = zzbv.zzez().zzw(this.zzams.zzaie);
            String valueOf = String.valueOf(this.zzaps);
            String valueOf2 = String.valueOf(this.zzapt);
            this.zzaps = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        if (this.zzams.zzato == null) {
            zzafx.zzcs("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) zzbv.zzen().zzd(zzmu.zzbkx)).booleanValue()) {
            String packageName = this.zzams.zzaie.getApplicationContext() != null ? this.zzams.zzaie.getApplicationContext().getPackageName() : this.zzams.zzaie.getPackageName();
            if (!this.zzapm) {
                zzafx.zzcs("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "show_interstitial_before_load_finish");
                zza(bundle);
            }
            zzbv.zzea();
            if (!zzahf.zzam(this.zzams.zzaie)) {
                zzafx.zzcs("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("appid", packageName);
                bundle2.putString(NativeProtocol.WEB_DIALOG_ACTION, "show_interstitial_app_not_in_foreground");
                zza(bundle2);
            }
        }
        if (this.zzams.zzfe()) {
            return;
        }
        if (this.zzams.zzato.zzcpo && this.zzams.zzato.zzccb != null) {
            try {
                if (((Boolean) zzbv.zzen().zzd(zzmu.zzbjv)).booleanValue()) {
                    this.zzams.zzato.zzccb.setImmersiveMode(this.zzapq);
                }
                this.zzams.zzato.zzccb.showInterstitial();
            } catch (RemoteException e) {
                zzafx.zzc("Could not show interstitial.", e);
                zzda();
            }
        } else if (this.zzams.zzato.zzcgz == null) {
            zzafx.zzcs("The interstitial failed to load.");
        } else if (this.zzams.zzato.zzcgz.zzsf()) {
            zzafx.zzcs("The interstitial is already showing.");
        } else {
            this.zzams.zzato.zzcgz.zzab(true);
            if (this.zzams.zzato.zzcyc != null) {
                this.zzamu.zza(this.zzams.zzatn, this.zzams.zzato);
            }
            zzafi zzafiVar = this.zzams.zzato;
            if (zzafiVar.zzfo()) {
                Context context = this.zzams.zzaie;
                zzakk zzakkVar = zzafiVar.zzcgz;
                if (zzakkVar == null) {
                    throw null;
                }
                new zzgi(context, (View) zzakkVar).zza(zzafiVar.zzcgz);
            } else {
                zzafiVar.zzcgz.zzsb().zza(new zzan(this, zzafiVar));
            }
            if (this.zzams.zzapy) {
                zzbv.zzea();
                bitmap = zzahf.zzan(this.zzams.zzaie);
            }
            this.zzapn = zzbv.zzew().zzb(bitmap);
            if (((Boolean) zzbv.zzen().zzd(zzmu.zzbmi)).booleanValue() && bitmap != null) {
                new zzao(this, this.zzapn).zzqq();
                return;
            }
            zzaq zzaqVar = new zzaq(this.zzams.zzapy, zzcz(), false, 0.0f, -1, this.zzapq);
            int requestedOrientation = this.zzams.zzato.zzcgz.getRequestedOrientation();
            if (requestedOrientation == -1) {
                requestedOrientation = this.zzams.zzato.orientation;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this, this, this, this.zzams.zzato.zzcgz, requestedOrientation, this.zzams.zzatj, this.zzams.zzato.zzcpt, zzaqVar);
            zzbv.zzdy();
            com.google.android.gms.ads.internal.overlay.zzu.zza(this.zzams.zzaie, adOverlayInfoParcel, true);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzi
    protected final zzakk zza(zzafj zzafjVar, @Nullable zzw zzwVar, @Nullable zzaev zzaevVar) throws zzakw {
        zzakk zza = zzbv.zzeb().zza(this.zzams.zzaie, this.zzams.zzatn, false, false, this.zzams.zzati, this.zzams.zzatj, this.zzamn, this, this.zzamv, zzafjVar.zzcyo);
        zza.zzsb().zza(this, null, this, this, ((Boolean) zzbv.zzen().zzd(zzmu.zzbio)).booleanValue(), this, zzwVar, null, zzaevVar);
        zza((com.google.android.gms.ads.internal.js.zzai) zza);
        zza.zzcu(zzafjVar.zzcrj.zzcoj);
        zza.zzsb().zza("/reward", new zzse(this));
        return zza;
    }

    @Override // com.google.android.gms.ads.internal.zzi, com.google.android.gms.ads.internal.zza
    public final void zza(zzafj zzafjVar, zznh zznhVar) {
        if (!((Boolean) zzbv.zzen().zzd(zzmu.zzbka)).booleanValue()) {
            super.zza(zzafjVar, zznhVar);
        } else if (zzafjVar.errorCode != -2) {
            super.zza(zzafjVar, zznhVar);
        } else {
            boolean z = !zzafjVar.zzcyp.zzcpo;
            if (zza(zzafjVar.zzcrj.zzcnw) && z) {
                this.zzams.zzatp = zzb(zzafjVar);
            }
            super.zza(this.zzams.zzatp, zznhVar);
        }
    }

    @Override // com.google.android.gms.internal.zzrw
    public final void zza(boolean z, float f) {
        this.zzapo = z;
        this.zzapp = f;
    }

    @Override // com.google.android.gms.ads.internal.zzi, com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public final boolean zza(@Nullable zzafi zzafiVar, zzafi zzafiVar2) {
        if (super.zza(zzafiVar, zzafiVar2)) {
            if (!this.zzams.zzfd() && this.zzams.zzaui != null && zzafiVar2.zzcyc != null) {
                this.zzamu.zza(this.zzams.zzatn, zzafiVar2, this.zzams.zzaui);
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zzd
    protected final boolean zza(zzix zzixVar, zzafi zzafiVar, boolean z) {
        if (this.zzams.zzfd() && zzafiVar.zzcgz != null) {
            zzbv.zzec();
            zzahk.zzk(zzafiVar.zzcgz);
        }
        return this.zzamr.zzdp();
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzix zzixVar, zznh zznhVar) {
        if (this.zzams.zzato != null) {
            zzafx.zzcs("An interstitial is already loading. Aborting.");
            return false;
        }
        if (this.zzapr == null && zza(zzixVar) && zzbv.zzez().zzu(this.zzams.zzaie) && !TextUtils.isEmpty(this.zzams.zzath)) {
            this.zzapr = new zzaey(this.zzams.zzaie, this.zzams.zzath);
        }
        return super.zza(zzixVar, zznhVar);
    }

    @Override // com.google.android.gms.internal.zzsf
    public final void zzb(zzaek zzaekVar) {
        if (this.zzams.zzato != null) {
            if (this.zzams.zzato.zzcqf != null) {
                zzbv.zzea();
                zzahf.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, this.zzams.zzato.zzcqf);
            }
            if (this.zzams.zzato.zzcqd != null) {
                zzaekVar = this.zzams.zzato.zzcqd;
            }
        }
        zza(zzaekVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzbo() {
        zzda();
        super.zzbo();
    }

    @Override // com.google.android.gms.ads.internal.zzi, com.google.android.gms.ads.internal.zza
    protected final void zzbr() {
        super.zzbr();
        this.zzapm = true;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.overlay.zzw
    public final void zzbz() {
        super.zzbz();
        this.zzamu.zzg(this.zzams.zzato);
        if (this.zzapr != null) {
            this.zzapr.zzv(false);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.overlay.zzw
    public final void zzca() {
        zzakl zzsb;
        recordImpression();
        super.zzca();
        if (this.zzams.zzato != null && this.zzams.zzato.zzcgz != null && (zzsb = this.zzams.zzato.zzcgz.zzsb()) != null) {
            zzsb.zzta();
        }
        if (zzbv.zzez().zzu(this.zzams.zzaie) && this.zzams.zzato != null && this.zzams.zzato.zzcgz != null) {
            zzbv.zzez().zze(this.zzams.zzato.zzcgz.getContext(), this.zzaps);
        }
        if (this.zzapr != null) {
            this.zzapr.zzv(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzcz() {
        if (this.zzams.zzaie instanceof Activity) {
            Window window = ((Activity) this.zzams.zzaie).getWindow();
            if (window == null || window.getDecorView() == null) {
                return false;
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzrw
    public final void zzd(boolean z) {
        this.zzams.zzapy = z;
    }

    public final void zzda() {
        zzbv.zzew().zzb(Integer.valueOf(this.zzapn));
        if (this.zzams.zzfd()) {
            this.zzams.zzfb();
            this.zzams.zzato = null;
            this.zzams.zzapy = false;
            this.zzapm = false;
        }
    }

    @Override // com.google.android.gms.internal.zzsf
    public final void zzdb() {
        if (this.zzams.zzato != null && this.zzams.zzato.zzcyh != null) {
            zzbv.zzea();
            zzahf.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, this.zzams.zzato.zzcyh);
        }
        zzbu();
    }
}
