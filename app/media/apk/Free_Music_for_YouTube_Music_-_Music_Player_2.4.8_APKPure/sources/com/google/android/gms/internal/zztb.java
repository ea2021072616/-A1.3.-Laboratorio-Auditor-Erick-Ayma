package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes2.dex */
final class zztb implements zztr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zztb(zzsu zzsuVar) {
    }

    @Override // com.google.android.gms.internal.zztr
    public final void zzb(zzts zztsVar) throws RemoteException {
        if (zztsVar.zzaoq != null) {
            zztsVar.zzaoq.onAdClicked();
        }
    }
}
