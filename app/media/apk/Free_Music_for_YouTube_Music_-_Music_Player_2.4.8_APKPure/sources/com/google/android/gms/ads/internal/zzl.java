package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzakk;
import com.google.android.gms.internal.zzakw;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zzyc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzl implements Runnable {
    final /* synthetic */ zzafj zzamz;
    final /* synthetic */ zzi zzane;
    final /* synthetic */ zzaev zzanf;
    private /* synthetic */ zznh zzang;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(zzi zziVar, zzafj zzafjVar, zzaev zzaevVar, zznh zznhVar) {
        this.zzane = zziVar;
        this.zzamz = zzafjVar;
        this.zzanf = zzaevVar;
        this.zzang = zznhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzamz.zzcyp.zzcpx && this.zzane.zzams.zzaue != null) {
            String str = null;
            if (this.zzamz.zzcyp.zzchb != null) {
                zzbv.zzea();
                str = zzahf.zzch(this.zzamz.zzcyp.zzchb);
            }
            zzni zzniVar = new zzni(this.zzane, str, this.zzamz.zzcyp.body);
            this.zzane.zzams.zzauj = 1;
            try {
                this.zzane.zzamq = false;
                this.zzane.zzams.zzaue.zza(zzniVar);
                return;
            } catch (RemoteException e) {
                zzafx.zzc("Could not call the onCustomRenderedAdLoadedListener.", e);
                this.zzane.zzamq = true;
            }
        }
        zzw zzwVar = new zzw(this.zzane.zzams.zzaie, this.zzanf, this.zzamz.zzcyp.zzcqh);
        try {
            zzakk zza = this.zzane.zza(this.zzamz, zzwVar, this.zzanf);
            zza.setOnTouchListener(new zzn(this, zzwVar));
            zza.setOnClickListener(new zzo(this, zzwVar));
            this.zzane.zzams.zzauj = 0;
            zzbw zzbwVar = this.zzane.zzams;
            zzbv.zzdz();
            zzbwVar.zzatm = zzyc.zza(this.zzane.zzams.zzaie, this.zzane, this.zzamz, this.zzane.zzams.zzati, zza, this.zzane.zzana, this.zzane, this.zzang);
        } catch (zzakw e2) {
            zzafx.zzb("Could not obtain webview.", e2);
            zzahf.zzdbo.post(new zzm(this));
        }
    }
}
