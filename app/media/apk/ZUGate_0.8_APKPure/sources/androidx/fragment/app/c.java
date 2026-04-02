package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new androidx.activity.result.a(5);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f837b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f838c;

    public c(Parcel parcel) {
        this.f837b = parcel.createStringArrayList();
        this.f838c = parcel.createTypedArrayList(b.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeStringList(this.f837b);
        parcel.writeTypedList(this.f838c);
    }
}
