package y0;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class h0 extends k {
    public static final Parcelable.Creator<h0> CREATOR = new androidx.activity.result.a(14);

    /* renamed from: b  reason: collision with root package name */
    public int f5622b;

    /* renamed from: c  reason: collision with root package name */
    public int f5623c;

    /* renamed from: d  reason: collision with root package name */
    public int f5624d;

    public h0(Parcel parcel) {
        super(parcel);
        this.f5622b = parcel.readInt();
        this.f5623c = parcel.readInt();
        this.f5624d = parcel.readInt();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f5622b);
        parcel.writeInt(this.f5623c);
        parcel.writeInt(this.f5624d);
    }
}
