package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zzls implements Runnable {
    private /* synthetic */ zzlr zzbeq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzls(zzlr zzlrVar) {
        this.zzbeq = zzlrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzlp.zza(this.zzbeq.zzbep) != null) {
            try {
                zzlp.zza(this.zzbeq.zzbep).onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaji.zzc("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
