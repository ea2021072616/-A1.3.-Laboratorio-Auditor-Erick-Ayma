package y0;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
/* loaded from: classes.dex */
public final class t extends k {
    public static final Parcelable.Creator<t> CREATOR = new androidx.activity.result.a(13);

    /* renamed from: b  reason: collision with root package name */
    public final int f5644b;

    public t(Parcel parcel) {
        super(parcel);
        this.f5644b = parcel.readInt();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f5644b);
    }

    public t(AbsSavedState absSavedState, int i5) {
        super(absSavedState);
        this.f5644b = i5;
    }
}
