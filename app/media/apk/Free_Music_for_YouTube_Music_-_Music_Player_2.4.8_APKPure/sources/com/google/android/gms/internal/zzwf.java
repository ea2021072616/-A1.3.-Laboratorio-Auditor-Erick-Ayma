package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zzwf implements Runnable {
    private /* synthetic */ zzvz zzcde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwf(zzvz zzvzVar) {
        this.zzcde = zzvzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzvg zzvgVar;
        try {
            zzvgVar = this.zzcde.zzccw;
            zzvgVar.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLeftApplication.", e);
        }
    }
}
