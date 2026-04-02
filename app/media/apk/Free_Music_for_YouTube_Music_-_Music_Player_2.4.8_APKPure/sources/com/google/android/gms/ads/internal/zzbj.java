package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzpt;
/* loaded from: classes.dex */
final class zzbj implements Runnable {
    private /* synthetic */ zzpt zzano;
    private /* synthetic */ zzbc zzara;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbj(zzbc zzbcVar, zzpt zzptVar) {
        this.zzara = zzbcVar;
        this.zzano = zzptVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzara.zzams.zzaty.get(this.zzano.getCustomTemplateId()).zza(this.zzano);
        } catch (RemoteException e) {
            zzafx.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
