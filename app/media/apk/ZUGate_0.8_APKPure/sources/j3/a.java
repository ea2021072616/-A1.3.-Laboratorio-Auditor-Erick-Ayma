package j3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.n3;
/* loaded from: classes.dex */
public final class a extends p0.b {
    public static final Parcelable.Creator<a> CREATOR = new n3(9);

    /* renamed from: d  reason: collision with root package name */
    public boolean f3451d;

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f3451d = parcel.readInt() == 1;
    }

    @Override // p0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
        parcel.writeInt(this.f3451d ? 1 : 0);
    }
}
