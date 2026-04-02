package p0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.n3;
/* loaded from: classes.dex */
public abstract class b implements Parcelable {

    /* renamed from: b  reason: collision with root package name */
    public final Parcelable f4245b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f4244c = new a();
    public static final Parcelable.Creator<b> CREATOR = new n3(2);

    public b() {
        this.f4245b = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
    }

    public b(Parcelable parcelable) {
        if (parcelable != null) {
            this.f4245b = parcelable == f4244c ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public b(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f4245b = readParcelable == null ? f4244c : readParcelable;
    }
}
