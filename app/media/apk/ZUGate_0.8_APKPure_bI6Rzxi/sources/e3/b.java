package e3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.widget.b0;
import l2.c0;
/* loaded from: classes.dex */
public final class b extends View.BaseSavedState {
    public static final Parcelable.Creator<b> CREATOR = new c0(9);

    /* renamed from: b  reason: collision with root package name */
    public int f2686b;

    public b(Parcel parcel) {
        super(parcel);
        this.f2686b = ((Integer) parcel.readValue(b.class.getClassLoader())).intValue();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MaterialCheckBox.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" CheckedState=");
        int i5 = this.f2686b;
        return b0.i(sb, i5 != 1 ? i5 != 2 ? "unchecked" : "indeterminate" : "checked", "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeValue(Integer.valueOf(this.f2686b));
    }
}
