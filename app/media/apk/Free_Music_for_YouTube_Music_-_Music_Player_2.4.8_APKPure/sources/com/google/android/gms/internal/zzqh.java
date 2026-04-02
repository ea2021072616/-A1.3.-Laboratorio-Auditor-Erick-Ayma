package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzqh extends zzef implements zzqg {
    public zzqh() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public static zzqg zzq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
        return queryLocalInterface instanceof zzqg ? (zzqg) queryLocalInterface : new zzqi(iBinder);
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
            zza(zzpvVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
