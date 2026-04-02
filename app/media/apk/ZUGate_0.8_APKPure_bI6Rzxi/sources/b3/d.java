package b3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import androidx.appcompat.widget.n3;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
/* loaded from: classes.dex */
public final class d extends p0.b {
    public static final Parcelable.Creator<d> CREATOR = new n3(7);

    /* renamed from: d  reason: collision with root package name */
    public final int f1637d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1638e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1639f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f1640g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1641h;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f1637d = parcel.readInt();
        this.f1638e = parcel.readInt();
        this.f1639f = parcel.readInt() == 1;
        this.f1640g = parcel.readInt() == 1;
        this.f1641h = parcel.readInt() == 1;
    }

    @Override // p0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
        parcel.writeInt(this.f1637d);
        parcel.writeInt(this.f1638e);
        parcel.writeInt(this.f1639f ? 1 : 0);
        parcel.writeInt(this.f1640g ? 1 : 0);
        parcel.writeInt(this.f1641h ? 1 : 0);
    }

    public d(AbsSavedState absSavedState, BottomSheetBehavior bottomSheetBehavior) {
        super(absSavedState);
        this.f1637d = bottomSheetBehavior.L;
        this.f1638e = bottomSheetBehavior.f2029e;
        this.f1639f = bottomSheetBehavior.f2023b;
        this.f1640g = bottomSheetBehavior.I;
        this.f1641h = bottomSheetBehavior.J;
    }
}
