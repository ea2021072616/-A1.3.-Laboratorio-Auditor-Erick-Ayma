package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zzwb implements Runnable {
    private /* synthetic */ zzvz zzcde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwb(zzvz zzvzVar) {
        this.zzcde = zzvzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzvg zzvgVar;
        try {
            zzvgVar = this.zzcde.zzccw;
            zzvgVar.onAdOpened();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdOpened.", e);
        }
    }
}
