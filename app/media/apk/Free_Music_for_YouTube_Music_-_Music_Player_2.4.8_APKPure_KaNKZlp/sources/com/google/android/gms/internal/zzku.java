package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public abstract class zzku extends zzef implements zzkt {
    public zzku() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                initialize();
                break;
            case 2:
                setAppVolume(parcel.readFloat());
                break;
            case 3:
                zzt(parcel.readString());
                break;
            case 4:
                setAppMuted(zzeg.zza(parcel));
                break;
            case 5:
                zzc(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readString());
                break;
            case 6:
                zzc(parcel.readString(), IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
