package l2;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
/* loaded from: classes.dex */
public final class q extends m2.a {
    public static final Parcelable.Creator<q> CREATOR = new androidx.activity.result.a(27);

    /* renamed from: b  reason: collision with root package name */
    public final int f3877b;

    /* renamed from: c  reason: collision with root package name */
    public final Account f3878c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3879d;

    /* renamed from: e  reason: collision with root package name */
    public final GoogleSignInAccount f3880e;

    public q(int i5, Account account, int i6, GoogleSignInAccount googleSignInAccount) {
        this.f3877b = i5;
        this.f3878c = account;
        this.f3879d = i6;
        this.f3880e = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = b4.j.o0(parcel, 20293);
        b4.j.h0(parcel, 1, this.f3877b);
        b4.j.i0(parcel, 2, this.f3878c, i5);
        b4.j.h0(parcel, 3, this.f3879d);
        b4.j.i0(parcel, 4, this.f3880e, i5);
        b4.j.t0(parcel, o02);
    }
}
