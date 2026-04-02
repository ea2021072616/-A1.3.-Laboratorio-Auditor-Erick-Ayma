package y0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class h extends k {
    public static final Parcelable.Creator<h> CREATOR = new androidx.activity.result.a(11);

    /* renamed from: b  reason: collision with root package name */
    public HashSet f5621b;

    public h(Parcel parcel) {
        super(parcel);
        int readInt = parcel.readInt();
        this.f5621b = new HashSet();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Collections.addAll(this.f5621b, strArr);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f5621b.size());
        HashSet hashSet = this.f5621b;
        parcel.writeStringArray((String[]) hashSet.toArray(new String[hashSet.size()]));
    }
}
