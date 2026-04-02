package l2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class b0 extends m2.a {
    public static final Parcelable.Creator<b0> CREATOR = new c0(0);

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f3762b;

    /* renamed from: c  reason: collision with root package name */
    public final i2.c[] f3763c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3764d;

    /* renamed from: e  reason: collision with root package name */
    public final d f3765e;

    public b0(Bundle bundle, i2.c[] cVarArr, int i5, d dVar) {
        this.f3762b = bundle;
        this.f3763c = cVarArr;
        this.f3764d = i5;
        this.f3765e = dVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = b4.j.o0(parcel, 20293);
        Bundle bundle = this.f3762b;
        if (bundle != null) {
            int o03 = b4.j.o0(parcel, 1);
            parcel.writeBundle(bundle);
            b4.j.t0(parcel, o03);
        }
        b4.j.k0(parcel, 2, this.f3763c, i5);
        b4.j.h0(parcel, 3, this.f3764d);
        b4.j.i0(parcel, 4, this.f3765e, i5);
        b4.j.t0(parcel, o02);
    }
}
