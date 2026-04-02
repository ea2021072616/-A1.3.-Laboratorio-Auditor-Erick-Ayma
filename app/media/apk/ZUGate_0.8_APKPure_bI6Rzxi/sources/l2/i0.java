package l2;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class i0 implements g, IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f3860a;

    public i0(IBinder iBinder) {
        this.f3860a = iBinder;
    }

    public final Account a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
        obtain = Parcel.obtain();
        try {
            this.f3860a.transact(2, obtain, obtain, 0);
            obtain.readException();
            obtain.recycle();
            return (Account) s2.b.a(obtain, Account.CREATOR);
        } catch (RuntimeException e5) {
            throw e5;
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3860a;
    }
}
