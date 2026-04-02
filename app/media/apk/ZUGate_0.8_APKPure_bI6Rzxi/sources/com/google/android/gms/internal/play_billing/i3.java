package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class i3 implements k3, IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f1895a;

    public i3(IBinder iBinder) {
        this.f1895a = iBinder;
    }

    public final int a(int i5, String str, String str2, Bundle bundle) {
        Parcel b5 = b();
        b5.writeInt(i5);
        b5.writeString(str);
        b5.writeString(str2);
        int i6 = l3.f1921a;
        b5.writeInt(1);
        bundle.writeToParcel(b5, 0);
        Parcel c5 = c(b5, 10);
        int readInt = c5.readInt();
        c5.recycle();
        return readInt;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1895a;
    }

    public final Parcel b() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        return obtain;
    }

    public final Parcel c(Parcel parcel, int i5) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f1895a.transact(i5, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e5) {
                obtain.recycle();
                throw e5;
            }
        } finally {
            parcel.recycle();
        }
    }
}
