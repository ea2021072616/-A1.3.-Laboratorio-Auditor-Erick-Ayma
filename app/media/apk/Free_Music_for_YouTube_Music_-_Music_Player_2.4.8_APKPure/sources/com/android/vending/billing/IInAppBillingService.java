package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes.dex */
public interface IInAppBillingService extends IInterface {
    int a(int i, String str, String str2) throws RemoteException;

    int a(int i, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle a(int i, String str, String str2, String str3) throws RemoteException;

    Bundle a(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle a(int i, String str, String str2, String str3, String str4) throws RemoteException;

    Bundle a(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException;

    Bundle a(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException;

    int b(int i, String str, String str2) throws RemoteException;

    int c(int i, String str, String str2) throws RemoteException;

    Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements IInAppBillingService {
        public a() {
            attachInterface(this, "com.android.vending.billing.IInAppBillingService");
        }

        public static IInAppBillingService a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IInAppBillingService)) {
                return (IInAppBillingService) queryLocalInterface;
            }
            return new C0018a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int a2 = a(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle skuDetails = getSkuDetails(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (skuDetails != null) {
                        parcel2.writeInt(1);
                        skuDetails.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle a3 = a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (a3 != null) {
                        parcel2.writeInt(1);
                        a3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle a4 = a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (a4 != null) {
                        parcel2.writeInt(1);
                        a4.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int b2 = b(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(b2);
                    return true;
                case 6:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int c2 = c(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c2);
                    return true;
                case 7:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle a5 = a(parcel.readInt(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (a5 != null) {
                        parcel2.writeInt(1);
                        a5.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle a6 = a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a6 != null) {
                        parcel2.writeInt(1);
                        a6.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 9:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle a7 = a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a7 != null) {
                        parcel2.writeInt(1);
                        a7.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 10:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int a8 = a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(a8);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.android.vending.billing.IInAppBillingService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.android.vending.billing.IInAppBillingService$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0018a implements IInAppBillingService {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f591a;

            C0018a(IBinder iBinder) {
                this.f591a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f591a;
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public int a(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f591a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f591a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle a(int i, String str, String str2, String str3, String str4) throws RemoteException {
                Bundle bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.f591a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle a(int i, String str, String str2, String str3) throws RemoteException {
                Bundle bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f591a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public int b(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f591a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public int c(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f591a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle a(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException {
                Bundle bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.f591a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle a(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f591a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle a(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
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
                    this.f591a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public int a(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f591a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
