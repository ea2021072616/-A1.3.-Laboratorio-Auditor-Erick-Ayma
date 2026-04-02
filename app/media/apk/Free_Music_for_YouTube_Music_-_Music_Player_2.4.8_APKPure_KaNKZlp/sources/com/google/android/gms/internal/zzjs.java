package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzjs extends zzef implements zzjr {
    public zzjs() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            onAdClicked();
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
