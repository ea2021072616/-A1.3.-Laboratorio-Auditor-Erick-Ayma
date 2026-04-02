package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzjw extends zzee implements zzju {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdClicked() throws RemoteException {
        zzb(6, zzax());
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdClosed() throws RemoteException {
        zzb(1, zzax());
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdImpression() throws RemoteException {
        zzb(7, zzax());
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdLeftApplication() throws RemoteException {
        zzb(3, zzax());
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdLoaded() throws RemoteException {
        zzb(4, zzax());
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdOpened() throws RemoteException {
        zzb(5, zzax());
    }
}
