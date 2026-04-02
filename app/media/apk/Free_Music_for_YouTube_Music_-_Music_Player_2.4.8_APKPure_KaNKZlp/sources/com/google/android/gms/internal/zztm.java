package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zztm implements zztr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zztm(zzti zztiVar) {
    }

    @Override // com.google.android.gms.internal.zztr
    public final void zzb(zzts zztsVar) throws RemoteException {
        if (zztsVar.zzbxe != null) {
            zztsVar.zzbxe.onRewardedVideoAdClosed();
        }
    }
}
