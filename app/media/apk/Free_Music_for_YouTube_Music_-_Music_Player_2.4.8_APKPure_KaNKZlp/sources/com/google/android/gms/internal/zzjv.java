package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzjv extends zzef implements zzju {
    public zzjv() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                onAdClosed();
                break;
            case 2:
                onAdFailedToLoad(parcel.readInt());
                break;
            case 3:
                onAdLeftApplication();
                break;
            case 4:
                onAdLoaded();
                break;
            case 5:
                onAdOpened();
                break;
            case 6:
                onAdClicked();
                break;
            case 7:
                onAdImpression();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
