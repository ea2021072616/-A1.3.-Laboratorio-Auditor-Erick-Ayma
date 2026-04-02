package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.zzee;
/* loaded from: classes.dex */
public final class zzar extends zzee implements zzap {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
    }

    @Override // com.google.android.gms.common.internal.zzap
    public final void cancel() throws RemoteException {
        zzc(2, zzax());
    }
}
