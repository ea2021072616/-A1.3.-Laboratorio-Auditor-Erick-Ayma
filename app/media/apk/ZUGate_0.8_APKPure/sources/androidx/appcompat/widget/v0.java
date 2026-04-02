package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
/* loaded from: classes.dex */
public final class v0 extends View.BaseSavedState {
    public static final Parcelable.Creator<v0> CREATOR = new androidx.activity.result.a(2);

    /* renamed from: b  reason: collision with root package name */
    public boolean f548b;

    public v0(Parcel parcel) {
        super(parcel);
        this.f548b = parcel.readByte() != 0;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeByte(this.f548b ? (byte) 1 : (byte) 0);
    }
}
