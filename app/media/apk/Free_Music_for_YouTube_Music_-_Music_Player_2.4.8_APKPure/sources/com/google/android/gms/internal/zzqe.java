package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzqe extends zzef implements zzqd {
    public zzqe() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public static zzqd zzp(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
        return queryLocalInterface instanceof zzqd ? (zzqd) queryLocalInterface : new zzqf(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzpt zzpvVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzpvVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                zzpvVar = queryLocalInterface instanceof zzpt ? (zzpt) queryLocalInterface : new zzpv(readStrongBinder);
            }
            zzb(zzpvVar, parcel.readString());
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
