package l2;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
/* loaded from: classes.dex */
public final class e extends m2.a {
    public static final Parcelable.Creator<e> CREATOR = new c0(2);

    /* renamed from: p  reason: collision with root package name */
    public static final Scope[] f3784p = new Scope[0];

    /* renamed from: q  reason: collision with root package name */
    public static final i2.c[] f3785q = new i2.c[0];

    /* renamed from: b  reason: collision with root package name */
    public final int f3786b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3787c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3788d;

    /* renamed from: e  reason: collision with root package name */
    public String f3789e;

    /* renamed from: f  reason: collision with root package name */
    public IBinder f3790f;

    /* renamed from: g  reason: collision with root package name */
    public Scope[] f3791g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f3792h;

    /* renamed from: i  reason: collision with root package name */
    public Account f3793i;

    /* renamed from: j  reason: collision with root package name */
    public i2.c[] f3794j;

    /* renamed from: k  reason: collision with root package name */
    public i2.c[] f3795k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f3796l;

    /* renamed from: m  reason: collision with root package name */
    public final int f3797m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3798n;
    public final String o;

    public e(int i5, int i6, int i7, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, i2.c[] cVarArr, i2.c[] cVarArr2, boolean z4, int i8, boolean z5, String str2) {
        scopeArr = scopeArr == null ? f3784p : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        i2.c[] cVarArr3 = f3785q;
        cVarArr = cVarArr == null ? cVarArr3 : cVarArr;
        cVarArr2 = cVarArr2 == null ? cVarArr3 : cVarArr2;
        this.f3786b = i5;
        this.f3787c = i6;
        this.f3788d = i7;
        if ("com.google.android.gms".equals(str)) {
            this.f3789e = "com.google.android.gms";
        } else {
            this.f3789e = str;
        }
        if (i5 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int i9 = a.f3760a;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface i0Var = queryLocalInterface instanceof g ? (g) queryLocalInterface : new i0(iBinder);
                if (i0Var != null) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            account2 = ((i0) i0Var).a();
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                        }
                    } finally {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                    }
                }
            }
            this.f3793i = account2;
        } else {
            this.f3790f = iBinder;
            this.f3793i = account;
        }
        this.f3791g = scopeArr;
        this.f3792h = bundle;
        this.f3794j = cVarArr;
        this.f3795k = cVarArr2;
        this.f3796l = z4;
        this.f3797m = i8;
        this.f3798n = z5;
        this.o = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        c0.a(this, parcel, i5);
    }
}
