package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzkl extends zzef implements zzkk {
    public zzkl() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public static zzkk zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        return queryLocalInterface instanceof zzkk ? (zzkk) queryLocalInterface : new zzkm(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            onAppEvent(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
