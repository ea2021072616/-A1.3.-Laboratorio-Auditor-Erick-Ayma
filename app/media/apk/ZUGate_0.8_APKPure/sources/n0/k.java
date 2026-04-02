package n0;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
/* loaded from: classes.dex */
public final class k extends View.BaseSavedState {
    public static final Parcelable.Creator<k> CREATOR = new androidx.activity.result.a(3);

    /* renamed from: b  reason: collision with root package name */
    public int f4071b;

    public k(Parcel parcel) {
        super(parcel);
        this.f4071b = parcel.readInt();
    }

    public final String toString() {
        return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f4071b + "}";
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f4071b);
    }
}
