package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzpy extends zzef implements zzpx {
    public zzpy() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public static zzpx zzn(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
        return queryLocalInterface instanceof zzpx ? (zzpx) queryLocalInterface : new zzpz(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzpl zzpnVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzpnVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                zzpnVar = queryLocalInterface instanceof zzpl ? (zzpl) queryLocalInterface : new zzpn(readStrongBinder);
            }
            zza(zzpnVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
