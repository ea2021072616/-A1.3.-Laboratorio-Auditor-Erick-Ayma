package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.n3;
/* loaded from: classes.dex */
public final class b1 extends p0.b {
    public static final Parcelable.Creator<b1> CREATOR = new n3(4);

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f1297d;

    public b1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f1297d = parcel.readParcelable(classLoader == null ? r0.class.getClassLoader() : classLoader);
    }

    @Override // p0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
        parcel.writeParcelable(this.f1297d, 0);
    }
}
