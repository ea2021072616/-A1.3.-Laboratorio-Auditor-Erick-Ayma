package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzno extends zzef implements zznn {
    public zzno() {
        attachInterface(this, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public static zznn zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
        return queryLocalInterface instanceof zznn ? (zznn) queryLocalInterface : new zznp(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zznk zznmVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zznmVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                zznmVar = queryLocalInterface instanceof zznk ? (zznk) queryLocalInterface : new zznm(readStrongBinder);
            }
            zza(zznmVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
