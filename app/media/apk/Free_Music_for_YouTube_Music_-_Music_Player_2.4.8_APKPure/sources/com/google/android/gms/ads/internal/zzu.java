package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzpt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzu implements Runnable {
    private /* synthetic */ zzq zzanl;
    private /* synthetic */ zzpt zzano;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(zzq zzqVar, zzpt zzptVar) {
        this.zzanl = zzqVar;
        this.zzano = zzptVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzanl.zzams.zzaty.get(this.zzano.getCustomTemplateId()).zza(this.zzano);
        } catch (RemoteException e) {
            zzafx.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
