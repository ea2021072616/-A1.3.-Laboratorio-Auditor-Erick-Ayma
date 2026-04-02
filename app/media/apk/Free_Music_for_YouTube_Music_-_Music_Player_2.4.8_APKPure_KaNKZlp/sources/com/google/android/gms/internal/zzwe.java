package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
/* loaded from: classes2.dex */
final class zzwe implements Runnable {
    private /* synthetic */ zzvz zzcde;
    private /* synthetic */ AdRequest.ErrorCode zzcdf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwe(zzvz zzvzVar, AdRequest.ErrorCode errorCode) {
        this.zzcde = zzvzVar;
        this.zzcdf = errorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzvg zzvgVar;
        try {
            zzvgVar = this.zzcde.zzccw;
            zzvgVar.onAdFailedToLoad(zzwl.zza(this.zzcdf));
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdFailedToLoad.", e);
        }
    }
}
