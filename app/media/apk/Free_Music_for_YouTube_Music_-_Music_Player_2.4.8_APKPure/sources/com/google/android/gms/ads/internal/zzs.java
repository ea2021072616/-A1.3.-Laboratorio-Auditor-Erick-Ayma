package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zznw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzs implements Runnable {
    private /* synthetic */ zzq zzanl;
    private /* synthetic */ zznw zzanm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(zzq zzqVar, zznw zznwVar) {
        this.zzanl = zzqVar;
        this.zzanm = zznwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzanl.zzams.zzatv != null) {
                this.zzanl.zzams.zzatv.zza(this.zzanm);
            }
        } catch (RemoteException e) {
            zzafx.zzc("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }
}
