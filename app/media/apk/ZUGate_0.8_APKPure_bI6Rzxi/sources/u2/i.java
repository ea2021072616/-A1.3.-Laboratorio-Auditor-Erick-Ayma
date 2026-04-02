package u2;

import android.os.Parcel;
import android.os.Parcelable;
import b4.j;
import l2.c0;
import l2.r;
/* loaded from: classes.dex */
public final class i extends m2.a {
    public static final Parcelable.Creator<i> CREATOR = new c0(8);

    /* renamed from: b  reason: collision with root package name */
    public final int f5144b;

    /* renamed from: c  reason: collision with root package name */
    public final i2.a f5145c;

    /* renamed from: d  reason: collision with root package name */
    public final r f5146d;

    public i(int i5, i2.a aVar, r rVar) {
        this.f5144b = i5;
        this.f5145c = aVar;
        this.f5146d = rVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = j.o0(parcel, 20293);
        j.h0(parcel, 1, this.f5144b);
        j.i0(parcel, 2, this.f5145c, i5);
        j.i0(parcel, 3, this.f5146d, i5);
        j.t0(parcel, o02);
    }
}
