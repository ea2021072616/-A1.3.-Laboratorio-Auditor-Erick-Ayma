package u2;

import android.os.Parcel;
import android.os.Parcelable;
import b4.j;
import java.util.ArrayList;
import java.util.List;
import l2.c0;
/* loaded from: classes.dex */
public final class g extends m2.a {
    public static final Parcelable.Creator<g> CREATOR = new c0(6);

    /* renamed from: b  reason: collision with root package name */
    public final List f5140b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5141c;

    public g(String str, ArrayList arrayList) {
        this.f5140b = arrayList;
        this.f5141c = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = j.o0(parcel, 20293);
        List<String> list = this.f5140b;
        if (list != null) {
            int o03 = j.o0(parcel, 1);
            parcel.writeStringList(list);
            j.t0(parcel, o03);
        }
        j.j0(parcel, 2, this.f5141c);
        j.t0(parcel, o02);
    }
}
