package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzjy extends zzef implements zzjx {
    public zzjy() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzd((zzix) zzeg.zza(parcel, zzix.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 3:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzeg.zza(parcel2, isLoading);
                break;
            case 4:
                String zzch = zzch();
                parcel2.writeNoException();
                parcel2.writeString(zzch);
                break;
            case 5:
                zza((zzix) zzeg.zza(parcel, zzix.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
