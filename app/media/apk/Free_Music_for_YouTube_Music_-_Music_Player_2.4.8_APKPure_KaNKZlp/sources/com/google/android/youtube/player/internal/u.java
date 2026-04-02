package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface u extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements u {

        /* renamed from: com.google.android.youtube.player.internal.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0095a implements u {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f4988a;

            C0095a(IBinder iBinder) {
                this.f4988a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4988a;
            }
        }

        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
        }

        public static u a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof u)) ? new C0095a(iBinder) : (u) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
