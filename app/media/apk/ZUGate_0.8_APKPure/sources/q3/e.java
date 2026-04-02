package q3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import androidx.appcompat.widget.n3;
import com.google.android.material.sidesheet.SideSheetBehavior;
/* loaded from: classes.dex */
public final class e extends p0.b {
    public static final Parcelable.Creator<e> CREATOR = new n3(10);

    /* renamed from: d  reason: collision with root package name */
    public final int f4464d;

    public e(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f4464d = parcel.readInt();
    }

    @Override // p0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
        parcel.writeInt(this.f4464d);
    }

    public e(AbsSavedState absSavedState, SideSheetBehavior sideSheetBehavior) {
        super(absSavedState);
        this.f4464d = sideSheetBehavior.f2179h;
    }
}
