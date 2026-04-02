package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class o1 implements Parcelable {
    public static final Parcelable.Creator<o1> CREATOR = new androidx.activity.result.a(17);

    /* renamed from: b  reason: collision with root package name */
    public int f1440b;

    /* renamed from: c  reason: collision with root package name */
    public int f1441c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f1442d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1443e;

    public o1(Parcel parcel) {
        this.f1440b = parcel.readInt();
        this.f1441c = parcel.readInt();
        this.f1443e = parcel.readInt() == 1;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            this.f1442d = iArr;
            parcel.readIntArray(iArr);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f1440b + ", mGapDir=" + this.f1441c + ", mHasUnwantedGapAfter=" + this.f1443e + ", mGapPerSpan=" + Arrays.toString(this.f1442d) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f1440b);
        parcel.writeInt(this.f1441c);
        parcel.writeInt(this.f1443e ? 1 : 0);
        int[] iArr = this.f1442d;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(iArr.length);
        parcel.writeIntArray(this.f1442d);
    }
}
