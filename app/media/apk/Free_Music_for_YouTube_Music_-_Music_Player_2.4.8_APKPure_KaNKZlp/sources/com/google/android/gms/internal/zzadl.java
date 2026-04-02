package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class zzadl extends zzee implements zzadj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdClosed() throws RemoteException {
        zzb(4, zzax());
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(7, zzax);
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        zzb(6, zzax());
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        zzb(1, zzax());
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdOpened() throws RemoteException {
        zzb(2, zzax());
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoStarted() throws RemoteException {
        zzb(3, zzax());
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void zza(zzadb zzadbVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzadbVar);
        zzb(5, zzax);
    }
}
