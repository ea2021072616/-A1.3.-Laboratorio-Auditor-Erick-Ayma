package l2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class r extends m2.a {
    public static final Parcelable.Creator<r> CREATOR = new androidx.activity.result.a(28);

    /* renamed from: b  reason: collision with root package name */
    public final int f3881b;

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f3882c;

    /* renamed from: d  reason: collision with root package name */
    public final i2.a f3883d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3884e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3885f;

    public r(int i5, IBinder iBinder, i2.a aVar, boolean z4, boolean z5) {
        this.f3881b = i5;
        this.f3882c = iBinder;
        this.f3883d = aVar;
        this.f3884e = z4;
        this.f3885f = z5;
    }

    public final boolean equals(Object obj) {
        Object i0Var;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f3883d.equals(rVar.f3883d)) {
                Object obj2 = null;
                IBinder iBinder = this.f3882c;
                if (iBinder == null) {
                    i0Var = null;
                } else {
                    int i5 = a.f3760a;
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    i0Var = queryLocalInterface instanceof g ? (g) queryLocalInterface : new i0(iBinder);
                }
                IBinder iBinder2 = rVar.f3882c;
                if (iBinder2 != null) {
                    int i6 = a.f3760a;
                    IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    obj2 = queryLocalInterface2 instanceof g ? (g) queryLocalInterface2 : new i0(iBinder2);
                }
                if (b4.j.p(i0Var, obj2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = b4.j.o0(parcel, 20293);
        b4.j.h0(parcel, 1, this.f3881b);
        IBinder iBinder = this.f3882c;
        if (iBinder != null) {
            int o03 = b4.j.o0(parcel, 2);
            parcel.writeStrongBinder(iBinder);
            b4.j.t0(parcel, o03);
        }
        b4.j.i0(parcel, 3, this.f3883d, i5);
        b4.j.g0(parcel, 4, this.f3884e);
        b4.j.g0(parcel, 5, this.f3885f);
        b4.j.t0(parcel, o02);
    }
}
