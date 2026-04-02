package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
/* loaded from: classes.dex */
public abstract class zzat extends zzef implements zzas {
    public zzat() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    public static zzas zzak(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof zzas ? (zzas) queryLocalInterface : new zzau(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IObjectWrapper zzaey = zzaey();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzaey);
                return true;
            case 2:
                int zzaez = zzaez();
                parcel2.writeNoException();
                parcel2.writeInt(zzaez);
                return true;
            default:
                return false;
        }
    }
}
