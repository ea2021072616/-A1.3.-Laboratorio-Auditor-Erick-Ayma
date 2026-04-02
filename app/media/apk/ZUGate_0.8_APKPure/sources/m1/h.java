package m1;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class h extends e implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new androidx.activity.result.a(20);

    /* renamed from: d  reason: collision with root package name */
    public float f3962d;

    public h(float f5) {
        super(0);
        this.f3962d = f5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "Entry, x: " + this.f3962d + " y: " + a();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeFloat(this.f3962d);
        parcel.writeFloat(a());
        Object obj = this.f3934c;
        if (obj == null) {
            parcel.writeInt(0);
        } else if (!(obj instanceof Parcelable)) {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) this.f3934c, i5);
        }
    }

    public h(Parcel parcel) {
        this.f3962d = 0.0f;
        this.f3962d = parcel.readFloat();
        this.f3933b = parcel.readFloat();
        if (parcel.readInt() == 1) {
            this.f3934c = parcel.readParcelable(Object.class.getClassLoader());
        }
    }
}
