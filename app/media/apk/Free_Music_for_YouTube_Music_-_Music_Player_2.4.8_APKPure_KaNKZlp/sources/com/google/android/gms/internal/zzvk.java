package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzvk extends zzef implements zzvj {
    public zzvk() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            int zzlq = zzlq();
            parcel2.writeNoException();
            parcel2.writeInt(zzlq);
            return true;
        }
        return false;
    }
}
