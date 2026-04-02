package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zzwc implements Runnable {
    private /* synthetic */ zzvz zzcde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwc(zzvz zzvzVar) {
        this.zzcde = zzvzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzvg zzvgVar;
        try {
            zzvgVar = this.zzcde.zzccw;
            zzvgVar.onAdLoaded();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLoaded.", e);
        }
    }
}
