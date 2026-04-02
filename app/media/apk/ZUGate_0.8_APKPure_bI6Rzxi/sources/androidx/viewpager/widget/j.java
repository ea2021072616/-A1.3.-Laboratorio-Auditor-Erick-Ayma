package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.n3;
/* loaded from: classes.dex */
public final class j extends p0.b {
    public static final Parcelable.Creator<j> CREATOR = new n3(5);

    /* renamed from: d  reason: collision with root package name */
    public int f1602d;

    /* renamed from: e  reason: collision with root package name */
    public Parcelable f1603e;

    /* renamed from: f  reason: collision with root package name */
    public final ClassLoader f1604f;

    public j(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? j.class.getClassLoader() : classLoader;
        this.f1602d = parcel.readInt();
        this.f1603e = parcel.readParcelable(classLoader);
        this.f1604f = classLoader;
    }

    public final String toString() {
        return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1602d + "}";
    }

    @Override // p0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
        parcel.writeInt(this.f1602d);
        parcel.writeParcelable(this.f1603e, i5);
    }
}
