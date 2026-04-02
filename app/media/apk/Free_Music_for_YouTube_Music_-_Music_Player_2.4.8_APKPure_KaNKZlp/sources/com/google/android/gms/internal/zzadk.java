package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public abstract class zzadk extends zzef implements zzadj {
    public zzadk() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public static zzadj zzy(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
        return queryLocalInterface instanceof zzadj ? (zzadj) queryLocalInterface : new zzadl(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzadb zzaddVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                onRewardedVideoAdLoaded();
                break;
            case 2:
                onRewardedVideoAdOpened();
                break;
            case 3:
                onRewardedVideoStarted();
                break;
            case 4:
                onRewardedVideoAdClosed();
                break;
            case 5:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaddVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardItem");
                    zzaddVar = queryLocalInterface instanceof zzadb ? (zzadb) queryLocalInterface : new zzadd(readStrongBinder);
                }
                zza(zzaddVar);
                break;
            case 6:
                onRewardedVideoAdLeftApplication();
                break;
            case 7:
                onRewardedVideoAdFailedToLoad(parcel.readInt());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
