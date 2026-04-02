package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zzly implements Runnable {
    private /* synthetic */ zzlx zzbet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzly(zzlx zzlxVar) {
        this.zzbet = zzlxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzadj zzadjVar;
        zzadj zzadjVar2;
        zzadjVar = this.zzbet.zzbes;
        if (zzadjVar != null) {
            try {
                zzadjVar2 = this.zzbet.zzbes;
                zzadjVar2.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaji.zzc("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
