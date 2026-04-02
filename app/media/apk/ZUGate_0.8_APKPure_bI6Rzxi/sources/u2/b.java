package u2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import b4.j;
import l2.c0;
/* loaded from: classes.dex */
public final class b extends m2.a {
    public static final Parcelable.Creator<b> CREATOR = new c0(5);

    /* renamed from: b  reason: collision with root package name */
    public final int f5137b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5138c;

    /* renamed from: d  reason: collision with root package name */
    public final Intent f5139d;

    public b(int i5, int i6, Intent intent) {
        this.f5137b = i5;
        this.f5138c = i6;
        this.f5139d = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = j.o0(parcel, 20293);
        j.h0(parcel, 1, this.f5137b);
        j.h0(parcel, 2, this.f5138c);
        j.i0(parcel, 3, this.f5139d, i5);
        j.t0(parcel, o02);
    }
}
