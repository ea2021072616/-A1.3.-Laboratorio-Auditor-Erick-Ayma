package y0;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class i0 extends k {
    public static final Parcelable.Creator<i0> CREATOR = new androidx.activity.result.a(15);

    /* renamed from: b  reason: collision with root package name */
    public boolean f5626b;

    public i0(Parcel parcel) {
        super(parcel);
        this.f5626b = parcel.readInt() == 1;
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f5626b ? 1 : 0);
    }
}
