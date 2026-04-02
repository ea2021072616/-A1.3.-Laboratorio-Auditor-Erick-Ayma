package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class z implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new androidx.activity.result.a(16);

    /* renamed from: b  reason: collision with root package name */
    public int f1584b;

    /* renamed from: c  reason: collision with root package name */
    public int f1585c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1586d;

    public z(Parcel parcel) {
        this.f1584b = parcel.readInt();
        this.f1585c = parcel.readInt();
        this.f1586d = parcel.readInt() == 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f1584b);
        parcel.writeInt(this.f1585c);
        parcel.writeInt(this.f1586d ? 1 : 0);
    }

    public z(z zVar) {
        this.f1584b = zVar.f1584b;
        this.f1585c = zVar.f1585c;
        this.f1586d = zVar.f1586d;
    }
}
