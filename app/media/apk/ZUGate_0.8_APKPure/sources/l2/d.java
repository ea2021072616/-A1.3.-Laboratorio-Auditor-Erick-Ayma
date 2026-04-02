package l2;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class d extends m2.a {
    public static final Parcelable.Creator<d> CREATOR = new c0(1);

    /* renamed from: b  reason: collision with root package name */
    public final j f3774b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3775c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3776d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f3777e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3778f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f3779g;

    public d(j jVar, boolean z4, boolean z5, int[] iArr, int i5, int[] iArr2) {
        this.f3774b = jVar;
        this.f3775c = z4;
        this.f3776d = z5;
        this.f3777e = iArr;
        this.f3778f = i5;
        this.f3779g = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = b4.j.o0(parcel, 20293);
        b4.j.i0(parcel, 1, this.f3774b, i5);
        b4.j.g0(parcel, 2, this.f3775c);
        b4.j.g0(parcel, 3, this.f3776d);
        int[] iArr = this.f3777e;
        if (iArr != null) {
            int o03 = b4.j.o0(parcel, 4);
            parcel.writeIntArray(iArr);
            b4.j.t0(parcel, o03);
        }
        b4.j.h0(parcel, 5, this.f3778f);
        int[] iArr2 = this.f3779g;
        if (iArr2 != null) {
            int o04 = b4.j.o0(parcel, 6);
            parcel.writeIntArray(iArr2);
            b4.j.t0(parcel, o04);
        }
        b4.j.t0(parcel, o02);
    }
}
