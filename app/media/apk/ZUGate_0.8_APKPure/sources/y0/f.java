package y0;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class f extends k {
    public static final Parcelable.Creator<f> CREATOR = new androidx.activity.result.a(10);

    /* renamed from: b  reason: collision with root package name */
    public String f5618b;

    public f(Parcel parcel) {
        super(parcel);
        this.f5618b = parcel.readString();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeString(this.f5618b);
    }
}
