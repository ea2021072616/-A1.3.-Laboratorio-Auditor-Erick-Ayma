package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zznw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbg implements Runnable {
    private /* synthetic */ zznw zzanm;
    private /* synthetic */ zzbc zzara;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbg(zzbc zzbcVar, zznw zznwVar) {
        this.zzara = zzbcVar;
        this.zzanm = zznwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzara.zzams.zzatv != null) {
                this.zzara.zzams.zzatv.zza(this.zzanm);
            }
        } catch (RemoteException e) {
            zzafx.zzc("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }
}
