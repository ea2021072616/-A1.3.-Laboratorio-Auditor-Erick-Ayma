package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class o3 extends p0.b {
    public static final Parcelable.Creator<o3> CREATOR = new n3(0);

    /* renamed from: d  reason: collision with root package name */
    public int f469d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f470e;

    public o3(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f469d = parcel.readInt();
        this.f470e = parcel.readInt() != 0;
    }

    @Override // p0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
        parcel.writeInt(this.f469d);
        parcel.writeInt(this.f470e ? 1 : 0);
    }
}
