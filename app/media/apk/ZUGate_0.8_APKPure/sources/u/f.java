package u;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.appcompat.widget.n3;
/* loaded from: classes.dex */
public final class f extends p0.b {
    public static final Parcelable.Creator<f> CREATOR = new n3(1);

    /* renamed from: d  reason: collision with root package name */
    public SparseArray f5112d;

    public f(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        this.f5112d = new SparseArray(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            this.f5112d.append(iArr[i5], readParcelableArray[i5]);
        }
    }

    @Override // p0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
        SparseArray sparseArray = this.f5112d;
        int size = sparseArray != null ? sparseArray.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = this.f5112d.keyAt(i6);
            parcelableArr[i6] = (Parcelable) this.f5112d.valueAt(i6);
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i5);
    }
}
