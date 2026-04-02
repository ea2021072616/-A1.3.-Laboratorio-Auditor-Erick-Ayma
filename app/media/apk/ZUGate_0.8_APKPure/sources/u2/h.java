package u2;

import android.os.Parcel;
import android.os.Parcelable;
import b4.j;
import l2.c0;
import l2.q;
/* loaded from: classes.dex */
public final class h extends m2.a {
    public static final Parcelable.Creator<h> CREATOR = new c0(7);

    /* renamed from: b  reason: collision with root package name */
    public final int f5142b;

    /* renamed from: c  reason: collision with root package name */
    public final q f5143c;

    public h(int i5, q qVar) {
        this.f5142b = i5;
        this.f5143c = qVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = j.o0(parcel, 20293);
        j.h0(parcel, 1, this.f5142b);
        j.i0(parcel, 2, this.f5143c, i5);
        j.t0(parcel, o02);
    }
}
