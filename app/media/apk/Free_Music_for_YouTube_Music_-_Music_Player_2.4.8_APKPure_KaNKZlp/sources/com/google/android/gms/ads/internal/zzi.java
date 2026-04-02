package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzajk;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzakw;
import com.google.android.gms.internal.zzfl;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzxe;
import com.google.android.gms.internal.zzyc;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public class zzi extends zzd implements zzag, zzxe {
    private boolean zzand;

    public zzi(Context context, zzjb zzjbVar, String str, zzva zzvaVar, zzajk zzajkVar, zzv zzvVar) {
        super(context, zzjbVar, str, zzvaVar, zzajkVar, zzvVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzakk zza(zzafj zzafjVar, @Nullable zzw zzwVar, @Nullable zzaev zzaevVar) throws zzakw {
        zzakk zzakkVar;
        zzakk zzakkVar2 = null;
        View nextView = this.zzams.zzatk.getNextView();
        if (nextView instanceof zzakk) {
            zzakkVar2 = (zzakk) nextView;
            if (((Boolean) zzbv.zzen().zzd(zzmu.zzbjg)).booleanValue()) {
                zzafx.zzcb("Reusing webview...");
                zzakkVar2.zza(this.zzams.zzaie, this.zzams.zzatn, this.zzamn);
            } else {
                zzakkVar2.destroy();
                zzakkVar2 = null;
            }
        }
        if (zzakkVar2 == null) {
            if (nextView != null) {
                this.zzams.zzatk.removeView(nextView);
            }
            zzakk zza = zzbv.zzeb().zza(this.zzams.zzaie, this.zzams.zzatn, false, false, this.zzams.zzati, this.zzams.zzatj, this.zzamn, this, this.zzamv, zzafjVar.zzcyo);
            if (this.zzams.zzatn.zzbcs == null) {
                if (zza == null) {
                    throw null;
                }
                zzb((View) zza);
            }
            zzakkVar = zza;
        } else {
            zzakkVar = zzakkVar2;
        }
        zzakkVar.zzsb().zza(this, this, this, this, false, null, zzwVar, this, zzaevVar);
        zza((com.google.android.gms.ads.internal.js.zzai) zzakkVar);
        zzakkVar.zzcu(zzafjVar.zzcrj.zzcoj);
        return zzakkVar;
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void zza(int i, int i2, int i3, int i4) {
        zzbq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zzaiVar.zza("/trackActiveViewUnit", new zzj(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public void zza(zzafj zzafjVar, zznh zznhVar) {
        if (zzafjVar.errorCode != -2) {
            zzahf.zzdbo.post(new zzk(this, zzafjVar));
            return;
        }
        if (zzafjVar.zzatn != null) {
            this.zzams.zzatn = zzafjVar.zzatn;
        }
        if (!zzafjVar.zzcyp.zzcpo || zzafjVar.zzcyp.zzbcv) {
            zzahf.zzdbo.post(new zzl(this, zzafjVar, this.zzamv.zzanr.zza(this.zzams.zzaie, this.zzams.zzatj, zzafjVar.zzcyp), zznhVar));
            return;
        }
        this.zzams.zzauj = 0;
        zzbw zzbwVar = this.zzams;
        zzbv.zzdz();
        zzbwVar.zzatm = zzyc.zza(this.zzams.zzaie, this, zzafjVar, this.zzams.zzati, null, this.zzana, this, zznhVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzakk zzakkVar) {
        if (this.zzams.zzato == null) {
            this.zzand = true;
            zzafx.zzcs("Request to enable ActiveView before adState is available.");
            return;
        }
        zzfl zzflVar = this.zzamu;
        zzjb zzjbVar = this.zzams.zzatn;
        zzafi zzafiVar = this.zzams.zzato;
        if (zzakkVar == null) {
            throw null;
        }
        zzflVar.zza(zzjbVar, zzafiVar, (View) zzakkVar, zzakkVar);
        this.zzand = false;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzkf
    public final void zza(zznn zznnVar) {
        com.google.android.gms.common.internal.zzbp.zzfx("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzams.zzaue = zznnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public boolean zza(@Nullable zzafi zzafiVar, zzafi zzafiVar2) {
        if (this.zzams.zzfd() && this.zzams.zzatk != null) {
            this.zzams.zzatk.zzfg().zzco(zzafiVar2.zzcpt);
        }
        return super.zza(zzafiVar, zzafiVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public void zzbr() {
        super.zzbr();
        if (this.zzand) {
            if (((Boolean) zzbv.zzen().zzd(zzmu.zzbnd)).booleanValue()) {
                zza(this.zzams.zzato.zzcgz);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzag
    public final void zzc(View view) {
        this.zzams.zzaui = view;
        zzb(new zzafi(this.zzams.zzatp, null, null, null, null, null, null, null));
    }

    @Override // com.google.android.gms.ads.internal.zzag
    public final void zzck() {
        onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzag
    public final void zzcl() {
        recordImpression();
        zzbn();
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void zzcm() {
        zzbo();
    }
}
