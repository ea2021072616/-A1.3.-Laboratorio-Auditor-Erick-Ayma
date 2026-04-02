package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zztp implements zztr {
    private /* synthetic */ int zzbwv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztp(zzti zztiVar, int i) {
        this.zzbwv = i;
    }

    @Override // com.google.android.gms.internal.zztr
    public final void zzb(zzts zztsVar) throws RemoteException {
        if (zztsVar.zzbxe != null) {
            zztsVar.zzbxe.onRewardedVideoAdFailedToLoad(this.zzbwv);
        }
    }
}
