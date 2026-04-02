package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.j;
import com.google.android.youtube.player.internal.k;
/* loaded from: classes2.dex */
public interface l extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements l {

        /* renamed from: com.google.android.youtube.player.internal.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0094a implements l {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f4949a;

            C0094a(IBinder iBinder) {
                this.f4949a = iBinder;
            }

            @Override // com.google.android.youtube.player.internal.l
            public final IBinder a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    this.f4949a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.youtube.player.internal.l
            public final k a(j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f4949a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return k.a.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.youtube.player.internal.l
            public final void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f4949a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4949a;
            }
        }

        public static l a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IYouTubeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof l)) ? new C0094a(iBinder) : (l) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            j c0092a;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    IBinder a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        c0092a = null;
                    } else {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                        c0092a = (queryLocalInterface == null || !(queryLocalInterface instanceof j)) ? new j.a.C0092a(readStrongBinder) : (j) queryLocalInterface;
                    }
                    k a3 = a(c0092a);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a3 != null ? a3.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IYouTubeService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder a() throws RemoteException;

    k a(j jVar) throws RemoteException;

    void a(boolean z) throws RemoteException;
}
