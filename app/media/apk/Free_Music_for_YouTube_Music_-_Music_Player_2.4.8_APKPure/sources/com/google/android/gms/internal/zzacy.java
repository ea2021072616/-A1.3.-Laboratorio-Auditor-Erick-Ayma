package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.common.internal.zzbp;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzacy extends com.google.android.gms.ads.internal.zzd implements zzadz {
    private static zzacy zzcvr;
    private static final zzuz zzcvs = new zzuz();
    private boolean zzapq;
    private zzaey zzapr;
    private final Map<String, zzaef> zzcvt;
    private boolean zzcvu;

    public zzacy(Context context, com.google.android.gms.ads.internal.zzv zzvVar, zzjb zzjbVar, zzva zzvaVar, zzajk zzajkVar) {
        super(context, zzjbVar, null, zzvaVar, zzajkVar, zzvVar);
        this.zzcvt = new HashMap();
        zzcvr = this;
        this.zzapr = com.google.android.gms.ads.internal.zzbv.zzez().zzv(context) ? new zzaey(context, null) : null;
    }

    private static zzafj zzc(zzafj zzafjVar) {
        zzafx.v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = zzabz.zzb(zzafjVar.zzcyp).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzafjVar.zzcrj.zzath);
            return new zzafj(zzafjVar.zzcrj, zzafjVar.zzcyp, new zzul(Arrays.asList(new zzuk(jSONObject, null, Arrays.asList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null)), ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbln)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1L, 0, 1, null, 0, -1, -1L, false), zzafjVar.zzatn, zzafjVar.errorCode, zzafjVar.zzcyi, zzafjVar.zzcyj, zzafjVar.zzcyc, zzafjVar.zzcyo);
        } catch (JSONException e) {
            zzafx.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return new zzafj(zzafjVar.zzcrj, zzafjVar.zzcyp, (zzul) null, zzafjVar.zzatn, 0, zzafjVar.zzcyi, zzafjVar.zzcyj, zzafjVar.zzcyc, zzafjVar.zzcyo);
        }
    }

    public static zzacy zzor() {
        return zzcvr;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void destroy() {
        zzbp.zzfx("destroy must be called on the main UI thread.");
        for (String str : this.zzcvt.keySet()) {
            try {
                zzaef zzaefVar = this.zzcvt.get(str);
                if (zzaefVar != null && zzaefVar.zzoz() != null) {
                    zzaefVar.zzoz().destroy();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(str);
                zzafx.zzcs(valueOf.length() != 0 ? "Fail to destroy adapter: ".concat(valueOf) : new String("Fail to destroy adapter: "));
            }
        }
    }

    public final boolean isLoaded() {
        zzbp.zzfx("isLoaded must be called on the main UI thread.");
        return this.zzams.zzatl == null && this.zzams.zzatm == null && this.zzams.zzato != null && !this.zzcvu;
    }

    public final void onContextChanged(@NonNull Context context) {
        for (zzaef zzaefVar : this.zzcvt.values()) {
            try {
                zzaefVar.zzoz().zzk(com.google.android.gms.dynamic.zzn.zzw(context));
            } catch (RemoteException e) {
                zzafx.zzb("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzadz
    public final void onRewardedVideoAdClosed() {
        if (com.google.android.gms.ads.internal.zzbv.zzez().zzv(this.zzams.zzaie)) {
            this.zzapr.zzv(false);
        }
        zzbo();
    }

    @Override // com.google.android.gms.internal.zzadz
    public final void onRewardedVideoAdLeftApplication() {
        zzbp();
    }

    @Override // com.google.android.gms.internal.zzadz
    public final void onRewardedVideoAdOpened() {
        if (com.google.android.gms.ads.internal.zzbv.zzez().zzv(this.zzams.zzaie)) {
            this.zzapr.zzv(true);
        }
        zza(this.zzams.zzato, false);
        zzbq();
    }

    @Override // com.google.android.gms.internal.zzadz
    public final void onRewardedVideoStarted() {
        if (this.zzams.zzato != null && this.zzams.zzato.zzcca != null) {
            com.google.android.gms.ads.internal.zzbv.zzeu();
            zzut.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, this.zzams.zzato, this.zzams.zzath, false, this.zzams.zzato.zzcca.zzcak);
        }
        zzbu();
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void pause() {
        zzbp.zzfx("pause must be called on the main UI thread.");
        for (String str : this.zzcvt.keySet()) {
            try {
                zzaef zzaefVar = this.zzcvt.get(str);
                if (zzaefVar != null && zzaefVar.zzoz() != null) {
                    zzaefVar.zzoz().pause();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(str);
                zzafx.zzcs(valueOf.length() != 0 ? "Fail to pause adapter: ".concat(valueOf) : new String("Fail to pause adapter: "));
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void resume() {
        zzbp.zzfx("resume must be called on the main UI thread.");
        for (String str : this.zzcvt.keySet()) {
            try {
                zzaef zzaefVar = this.zzcvt.get(str);
                if (zzaefVar != null && zzaefVar.zzoz() != null) {
                    zzaefVar.zzoz().resume();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(str);
                zzafx.zzcs(valueOf.length() != 0 ? "Fail to resume adapter: ".concat(valueOf) : new String("Fail to resume adapter: "));
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void setImmersiveMode(boolean z) {
        zzbp.zzfx("setImmersiveMode must be called on the main UI thread.");
        this.zzapq = z;
    }

    public final void zza(zzadp zzadpVar) {
        zzbp.zzfx("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(zzadpVar.zzath)) {
            zzafx.zzcs("Invalid ad unit id. Aborting.");
            zzahf.zzdbo.post(new zzacz(this));
            return;
        }
        this.zzcvu = false;
        this.zzams.zzath = zzadpVar.zzath;
        if (this.zzapr != null) {
            this.zzapr.setAdUnitId(zzadpVar.zzath);
        }
        super.zzb(zzadpVar.zzcnw);
    }

    @Override // com.google.android.gms.ads.internal.zza
    public final void zza(zzafj zzafjVar, zznh zznhVar) {
        if (zzafjVar.errorCode != -2) {
            zzahf.zzdbo.post(new zzada(this, zzafjVar));
            return;
        }
        this.zzams.zzatp = zzafjVar;
        if (zzafjVar.zzcye == null) {
            this.zzams.zzatp = zzc(zzafjVar);
        }
        this.zzams.zzauj = 0;
        com.google.android.gms.ads.internal.zzbw zzbwVar = this.zzams;
        com.google.android.gms.ads.internal.zzbv.zzdz();
        zzaec zzaecVar = new zzaec(this.zzams.zzaie, this.zzams.zzatp, this);
        String valueOf = String.valueOf(zzaecVar.getClass().getName());
        zzafx.zzcb(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzaecVar.zzns();
        zzbwVar.zzatm = zzaecVar;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzafi zzafiVar, zzafi zzafiVar2) {
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zzd
    protected final boolean zza(zzix zzixVar, zzafi zzafiVar, boolean z) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzbo() {
        this.zzams.zzato = null;
        super.zzbo();
    }

    @Nullable
    public final zzaef zzbu(String str) {
        Exception exc;
        zzaef zzaefVar;
        zzaef zzaefVar2 = this.zzcvt.get(str);
        if (zzaefVar2 == null) {
            try {
                zzaefVar = new zzaef(("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? zzcvs : this.zzana).zzbh(str), this);
            } catch (Exception e) {
                exc = e;
                zzaefVar = zzaefVar2;
            }
            try {
                this.zzcvt.put(str, zzaefVar);
                return zzaefVar;
            } catch (Exception e2) {
                exc = e2;
                String valueOf = String.valueOf(str);
                zzafx.zzc(valueOf.length() != 0 ? "Fail to instantiate adapter ".concat(valueOf) : new String("Fail to instantiate adapter "), exc);
                return zzaefVar;
            }
        }
        return zzaefVar2;
    }

    @Override // com.google.android.gms.internal.zzadz
    public final void zzc(@Nullable zzaek zzaekVar) {
        if (this.zzams.zzato != null && this.zzams.zzato.zzcca != null) {
            com.google.android.gms.ads.internal.zzbv.zzeu();
            zzut.zza(this.zzams.zzaie, this.zzams.zzatj.zzcp, this.zzams.zzato, this.zzams.zzath, false, this.zzams.zzato.zzcca.zzcal);
        }
        if (this.zzams.zzato != null && this.zzams.zzato.zzcye != null && !TextUtils.isEmpty(this.zzams.zzato.zzcye.zzcbb)) {
            zzaekVar = new zzaek(this.zzams.zzato.zzcye.zzcbb, this.zzams.zzato.zzcye.zzcbc);
        }
        zza(zzaekVar);
    }

    public final void zzos() {
        zzbp.zzfx("showAd must be called on the main UI thread.");
        if (!isLoaded()) {
            zzafx.zzcs("The reward video has not loaded.");
            return;
        }
        this.zzcvu = true;
        zzaef zzbu = zzbu(this.zzams.zzato.zzccc);
        if (zzbu == null || zzbu.zzoz() == null) {
            return;
        }
        try {
            zzbu.zzoz().setImmersiveMode(this.zzapq);
            zzbu.zzoz().showVideo();
        } catch (RemoteException e) {
            zzafx.zzc("Could not call showVideo.", e);
        }
    }

    @Override // com.google.android.gms.internal.zzadz
    public final void zzot() {
        onAdClicked();
    }
}
