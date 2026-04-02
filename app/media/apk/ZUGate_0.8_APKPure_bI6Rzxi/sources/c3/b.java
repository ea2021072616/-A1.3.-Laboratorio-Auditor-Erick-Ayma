package c3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.n3;
/* loaded from: classes.dex */
public final class b extends p0.b {
    public static final Parcelable.Creator<b> CREATOR = new n3(8);

    /* renamed from: d  reason: collision with root package name */
    public boolean f1764d;

    public b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            b.class.getClassLoader();
        }
        this.f1764d = parcel.readInt() == 1;
    }

    @Override // p0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
        parcel.writeInt(this.f1764d ? 1 : 0);
    }
}
