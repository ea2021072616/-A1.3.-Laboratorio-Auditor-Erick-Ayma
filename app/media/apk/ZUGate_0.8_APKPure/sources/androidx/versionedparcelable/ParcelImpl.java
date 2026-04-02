package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.a;
import g1.b;
import g1.c;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a(19);

    /* renamed from: b  reason: collision with root package name */
    public final c f1588b;

    public ParcelImpl(Parcel parcel) {
        this.f1588b = new b(parcel).h();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        new b(parcel).j(this.f1588b);
    }
}
