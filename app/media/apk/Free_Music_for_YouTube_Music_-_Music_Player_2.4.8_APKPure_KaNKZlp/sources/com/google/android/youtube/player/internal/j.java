package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface j extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements j {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.youtube.player.internal.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0092a implements j {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f4947a;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0092a(IBinder iBinder) {
                this.f4947a = iBinder;
            }

            @Override // com.google.android.youtube.player.internal.j
            public final void a(Bitmap bitmap, String str, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f4947a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.youtube.player.internal.j
            public final void a(String str, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f4947a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4947a;
            }
        }

        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IThumbnailLoaderClient");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    a(parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    a(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(Bitmap bitmap, String str, boolean z, boolean z2) throws RemoteException;

    void a(String str, boolean z, boolean z2) throws RemoteException;
}
