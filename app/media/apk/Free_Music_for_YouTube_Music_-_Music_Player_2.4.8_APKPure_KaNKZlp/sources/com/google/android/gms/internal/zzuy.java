package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zzuy implements Runnable {
    private /* synthetic */ zzur zzccr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuy(zzux zzuxVar, zzur zzurVar) {
        this.zzccr = zzurVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzccr.zzccb.destroy();
        } catch (RemoteException e) {
            zzafx.zzc("Could not destroy mediation adapter.", e);
        }
    }
}
