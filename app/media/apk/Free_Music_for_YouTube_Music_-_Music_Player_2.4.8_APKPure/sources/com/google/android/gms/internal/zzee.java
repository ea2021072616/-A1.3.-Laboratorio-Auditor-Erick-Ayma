package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public class zzee implements IInterface {
    private final IBinder zzakc;
    private final String zzakd;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzee(IBinder iBinder, String str) {
        this.zzakc = iBinder;
        this.zzakd = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzakc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel zza(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zzakc.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel zzax() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzakd);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzakc.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc(int i, Parcel parcel) throws RemoteException {
        try {
            this.zzakc.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
