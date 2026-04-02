package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.n3;
/* loaded from: classes.dex */
public final class a0 implements Parcelable {
    public static final Parcelable.Creator<a0> CREATOR = new n3(3);

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f821b;

    public a0(Parcel parcel, ClassLoader classLoader) {
        Bundle readBundle = parcel.readBundle();
        this.f821b = readBundle;
        if (classLoader == null || readBundle == null) {
            return;
        }
        readBundle.setClassLoader(classLoader);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeBundle(this.f821b);
    }
}
