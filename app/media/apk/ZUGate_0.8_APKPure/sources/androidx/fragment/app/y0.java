package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class y0 implements Parcelable {
    public static final Parcelable.Creator<y0> CREATOR = new androidx.activity.result.a(7);

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f1068b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f1069c;

    /* renamed from: d  reason: collision with root package name */
    public b[] f1070d;

    /* renamed from: e  reason: collision with root package name */
    public int f1071e;

    /* renamed from: f  reason: collision with root package name */
    public String f1072f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f1073g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f1074h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f1075i;

    public y0() {
        this.f1072f = null;
        this.f1073g = new ArrayList();
        this.f1074h = new ArrayList();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeStringList(this.f1068b);
        parcel.writeStringList(this.f1069c);
        parcel.writeTypedArray(this.f1070d, i5);
        parcel.writeInt(this.f1071e);
        parcel.writeString(this.f1072f);
        parcel.writeStringList(this.f1073g);
        parcel.writeTypedList(this.f1074h);
        parcel.writeTypedList(this.f1075i);
    }

    public y0(Parcel parcel) {
        this.f1072f = null;
        this.f1073g = new ArrayList();
        this.f1074h = new ArrayList();
        this.f1068b = parcel.createStringArrayList();
        this.f1069c = parcel.createStringArrayList();
        this.f1070d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1071e = parcel.readInt();
        this.f1072f = parcel.readString();
        this.f1073g = parcel.createStringArrayList();
        this.f1074h = parcel.createTypedArrayList(c.CREATOR);
        this.f1075i = parcel.createTypedArrayList(t0.CREATOR);
    }
}
