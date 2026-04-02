package l2;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class j extends m2.a {
    public static final Parcelable.Creator<j> CREATOR = new androidx.activity.result.a(29);

    /* renamed from: b  reason: collision with root package name */
    public final int f3861b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3862c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3863d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3864e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3865f;

    public j(int i5, boolean z4, boolean z5, int i6, int i7) {
        this.f3861b = i5;
        this.f3862c = z4;
        this.f3863d = z5;
        this.f3864e = i6;
        this.f3865f = i7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = b4.j.o0(parcel, 20293);
        b4.j.h0(parcel, 1, this.f3861b);
        b4.j.g0(parcel, 2, this.f3862c);
        b4.j.g0(parcel, 3, this.f3863d);
        b4.j.h0(parcel, 4, this.f3864e);
        b4.j.h0(parcel, 5, this.f3865f);
        b4.j.t0(parcel, o02);
    }
}
