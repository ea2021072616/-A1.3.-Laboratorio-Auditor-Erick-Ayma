package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class t0 implements Parcelable {
    public static final Parcelable.Creator<t0> CREATOR = new androidx.activity.result.a(6);

    /* renamed from: b  reason: collision with root package name */
    public final String f1008b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1009c;

    public t0(String str, int i5) {
        this.f1008b = str;
        this.f1009c = i5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f1008b);
        parcel.writeInt(this.f1009c);
    }

    public t0(Parcel parcel) {
        this.f1008b = parcel.readString();
        this.f1009c = parcel.readInt();
    }
}
