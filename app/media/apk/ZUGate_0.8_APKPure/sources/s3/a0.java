package s3;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.widget.n3;
/* loaded from: classes.dex */
public final class a0 extends p0.b {
    public static final Parcelable.Creator<a0> CREATOR = new n3(11);

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f4862d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4863e;

    public a0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f4862d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f4863e = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f4862d) + "}";
    }

    @Override // p0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f4245b, i5);
        TextUtils.writeToParcel(this.f4862d, parcel, i5);
        parcel.writeInt(this.f4863e ? 1 : 0);
    }
}
