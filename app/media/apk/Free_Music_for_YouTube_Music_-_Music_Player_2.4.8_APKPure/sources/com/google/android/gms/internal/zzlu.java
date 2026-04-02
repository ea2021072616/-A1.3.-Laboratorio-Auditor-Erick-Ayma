package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zzlu implements Runnable {
    private /* synthetic */ zzlt zzber;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlu(zzlt zzltVar) {
        this.zzber = zzltVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzju zzjuVar;
        zzju zzjuVar2;
        zzjuVar = this.zzber.zzaoq;
        if (zzjuVar != null) {
            try {
                zzjuVar2 = this.zzber.zzaoq;
                zzjuVar2.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaji.zzc("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
