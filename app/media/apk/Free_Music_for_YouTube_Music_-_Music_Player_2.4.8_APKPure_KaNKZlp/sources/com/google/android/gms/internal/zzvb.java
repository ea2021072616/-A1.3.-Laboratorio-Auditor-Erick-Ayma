package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzvb extends zzef implements zzva {
    public zzvb() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzva zzs(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzva ? (zzva) queryLocalInterface : new zzvc(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzvd zzbh = zzbh(parcel.readString());
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzbh);
                return true;
            case 2:
                boolean zzbi = zzbi(parcel.readString());
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzbi);
                return true;
            default:
                return false;
        }
    }
}
