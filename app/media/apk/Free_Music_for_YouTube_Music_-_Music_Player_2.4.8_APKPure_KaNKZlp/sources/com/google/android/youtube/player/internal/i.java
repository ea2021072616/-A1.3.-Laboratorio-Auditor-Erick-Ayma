package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.c;
/* loaded from: classes2.dex */
public interface i extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements i {

        /* renamed from: com.google.android.youtube.player.internal.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0091a implements i {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f4946a;

            C0091a(IBinder iBinder) {
                this.f4946a = iBinder;
            }

            @Override // com.google.android.youtube.player.internal.i
            public final void a(c cVar, int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IServiceBroker");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4946a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4946a;
            }
        }

        public static i a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof i)) ? new C0091a(iBinder) : (i) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            c c0085a;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IServiceBroker");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        c0085a = null;
                    } else {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
                        c0085a = (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new c.a.C0085a(readStrongBinder) : (c) queryLocalInterface;
                    }
                    a(c0085a, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IServiceBroker");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(c cVar, int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;
}
