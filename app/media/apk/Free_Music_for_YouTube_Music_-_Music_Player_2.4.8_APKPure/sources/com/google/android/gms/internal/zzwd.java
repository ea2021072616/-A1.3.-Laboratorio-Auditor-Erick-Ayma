package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zzwd implements Runnable {
    private /* synthetic */ zzvz zzcde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwd(zzvz zzvzVar) {
        this.zzcde = zzvzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzvg zzvgVar;
        try {
            zzvgVar = this.zzcde.zzccw;
            zzvgVar.onAdClosed();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClosed.", e);
        }
    }
}
