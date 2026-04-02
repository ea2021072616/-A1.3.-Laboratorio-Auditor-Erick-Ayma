package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zztq implements Runnable {
    private /* synthetic */ zztr zzbwz;
    private /* synthetic */ zzts zzbxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztq(zzst zzstVar, zztr zztrVar, zzts zztsVar) {
        this.zzbwz = zztrVar;
        this.zzbxa = zztsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzbwz.zzb(this.zzbxa);
        } catch (RemoteException e) {
            zzafx.zzc("Could not propagate interstitial ad event.", e);
        }
    }
}
