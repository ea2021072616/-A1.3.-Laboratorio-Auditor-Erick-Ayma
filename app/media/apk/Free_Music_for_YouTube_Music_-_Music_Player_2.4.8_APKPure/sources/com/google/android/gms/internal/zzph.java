package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public abstract class zzph extends zzef implements zzpg {
    public zzph() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzpg zzl(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return queryLocalInterface instanceof zzpg ? (zzpg) queryLocalInterface : new zzpi(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzd(parcel.readString(), IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper zzak = zzak(parcel.readString());
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzak);
                return true;
            case 3:
                zze(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                destroy();
                parcel2.writeNoException();
                return true;
            case 5:
                zzb(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
