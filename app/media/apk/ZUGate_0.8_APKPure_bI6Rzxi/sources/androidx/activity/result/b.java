package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a(0);

    /* renamed from: b  reason: collision with root package name */
    public final int f82b;

    /* renamed from: c  reason: collision with root package name */
    public final Intent f83c;

    public b(Intent intent, int i5) {
        this.f82b = i5;
        this.f83c = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int i5 = this.f82b;
        sb.append(i5 != -1 ? i5 != 0 ? String.valueOf(i5) : "RESULT_CANCELED" : "RESULT_OK");
        sb.append(", data=");
        sb.append(this.f83c);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f82b);
        Intent intent = this.f83c;
        parcel.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(parcel, i5);
        }
    }

    public b(Parcel parcel) {
        this.f82b = parcel.readInt();
        this.f83c = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
