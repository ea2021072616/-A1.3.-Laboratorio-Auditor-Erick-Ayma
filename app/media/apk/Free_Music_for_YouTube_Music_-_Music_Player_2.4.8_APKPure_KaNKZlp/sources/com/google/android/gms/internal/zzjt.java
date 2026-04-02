package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzjt extends zzee implements zzjr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    @Override // com.google.android.gms.internal.zzjr
    public final void onAdClicked() throws RemoteException {
        zzb(1, zzax());
    }
}
