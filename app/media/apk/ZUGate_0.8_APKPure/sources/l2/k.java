package l2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public final class k extends m2.a {
    public static final Parcelable.Creator<k> CREATOR = new androidx.activity.result.a(25);

    /* renamed from: b  reason: collision with root package name */
    public final int f3866b;

    /* renamed from: c  reason: collision with root package name */
    public List f3867c;

    public k(int i5, List list) {
        this.f3866b = i5;
        this.f3867c = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = b4.j.o0(parcel, 20293);
        b4.j.h0(parcel, 1, this.f3866b);
        b4.j.l0(parcel, 2, this.f3867c);
        b4.j.t0(parcel, o02);
    }
}
