package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a(1);

    /* renamed from: b  reason: collision with root package name */
    public final IntentSender f103b;

    /* renamed from: c  reason: collision with root package name */
    public final Intent f104c;

    /* renamed from: d  reason: collision with root package name */
    public final int f105d;

    /* renamed from: e  reason: collision with root package name */
    public final int f106e;

    public k(IntentSender intentSender, Intent intent, int i5, int i6) {
        e4.e.f(intentSender, "intentSender");
        this.f103b = intentSender;
        this.f104c = intent;
        this.f105d = i5;
        this.f106e = i6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        e4.e.f(parcel, "dest");
        parcel.writeParcelable(this.f103b, i5);
        parcel.writeParcelable(this.f104c, i5);
        parcel.writeInt(this.f105d);
        parcel.writeInt(this.f106e);
    }
}
