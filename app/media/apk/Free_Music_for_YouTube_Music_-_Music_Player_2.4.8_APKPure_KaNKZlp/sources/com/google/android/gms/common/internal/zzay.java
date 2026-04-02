package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzay implements zzax {
    private final IBinder zzakc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(IBinder iBinder) {
        this.zzakc = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zzakc;
    }

    @Override // com.google.android.gms.common.internal.zzax
    public final void zza(zzav zzavVar, zzy zzyVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(zzavVar.asBinder());
            obtain.writeInt(1);
            zzyVar.writeToParcel(obtain, 0);
            this.zzakc.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
