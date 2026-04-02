package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzqb extends zzef implements zzqa {
    public zzqb() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public static zzqa zzo(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        return queryLocalInterface instanceof zzqa ? (zzqa) queryLocalInterface : new zzqc(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzpp zzprVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzprVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                zzprVar = queryLocalInterface instanceof zzpp ? (zzpp) queryLocalInterface : new zzpr(readStrongBinder);
            }
            zza(zzprVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
