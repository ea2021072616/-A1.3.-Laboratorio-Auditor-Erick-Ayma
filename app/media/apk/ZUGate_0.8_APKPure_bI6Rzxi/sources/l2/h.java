package l2;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class h extends m2.a {
    public static final Parcelable.Creator<h> CREATOR = new androidx.activity.result.a(26);

    /* renamed from: b  reason: collision with root package name */
    public final int f3841b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3842c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3843d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3844e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3845f;

    /* renamed from: g  reason: collision with root package name */
    public final String f3846g;

    /* renamed from: h  reason: collision with root package name */
    public final String f3847h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3848i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3849j;

    public h(int i5, int i6, int i7, long j5, long j6, String str, String str2, int i8, int i9) {
        this.f3841b = i5;
        this.f3842c = i6;
        this.f3843d = i7;
        this.f3844e = j5;
        this.f3845f = j6;
        this.f3846g = str;
        this.f3847h = str2;
        this.f3848i = i8;
        this.f3849j = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = b4.j.o0(parcel, 20293);
        b4.j.h0(parcel, 1, this.f3841b);
        b4.j.h0(parcel, 2, this.f3842c);
        b4.j.h0(parcel, 3, this.f3843d);
        parcel.writeInt(524292);
        parcel.writeLong(this.f3844e);
        parcel.writeInt(524293);
        parcel.writeLong(this.f3845f);
        b4.j.j0(parcel, 6, this.f3846g);
        b4.j.j0(parcel, 7, this.f3847h);
        b4.j.h0(parcel, 8, this.f3848i);
        b4.j.h0(parcel, 9, this.f3849j);
        b4.j.t0(parcel, o02);
    }
}
