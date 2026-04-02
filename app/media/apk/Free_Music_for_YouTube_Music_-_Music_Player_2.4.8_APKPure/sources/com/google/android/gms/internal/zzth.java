package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zzth implements zztr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzth(zztg zztgVar) {
    }

    @Override // com.google.android.gms.internal.zztr
    public final void zzb(zzts zztsVar) throws RemoteException {
        if (zztsVar.zzbxd != null) {
            zztsVar.zzbxd.onAdClicked();
        }
    }
}
