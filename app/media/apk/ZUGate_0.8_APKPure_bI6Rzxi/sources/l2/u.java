package l2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class u implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f3892a;

    public u(IBinder iBinder) {
        this.f3892a = iBinder;
    }

    public final void a(x xVar, e eVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(xVar);
            obtain.writeInt(1);
            c0.a(eVar, obtain, 0);
            this.f3892a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3892a;
    }
}
