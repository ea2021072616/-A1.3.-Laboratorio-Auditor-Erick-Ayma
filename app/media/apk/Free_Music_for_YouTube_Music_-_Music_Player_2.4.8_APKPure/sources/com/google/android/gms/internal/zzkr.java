package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzkr extends zzef implements zzkq {
    public zzkr() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            long value = getValue();
            parcel2.writeNoException();
            parcel2.writeLong(value);
            return true;
        }
        return false;
    }
}
