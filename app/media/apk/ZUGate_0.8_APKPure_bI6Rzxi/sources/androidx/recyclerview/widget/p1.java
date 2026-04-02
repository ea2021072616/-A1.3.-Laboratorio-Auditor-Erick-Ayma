package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public final class p1 implements Parcelable {
    public static final Parcelable.Creator<p1> CREATOR = new androidx.activity.result.a(18);

    /* renamed from: b  reason: collision with root package name */
    public int f1447b;

    /* renamed from: c  reason: collision with root package name */
    public int f1448c;

    /* renamed from: d  reason: collision with root package name */
    public int f1449d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f1450e;

    /* renamed from: f  reason: collision with root package name */
    public int f1451f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f1452g;

    /* renamed from: h  reason: collision with root package name */
    public List f1453h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1454i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1455j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1456k;

    public p1(Parcel parcel) {
        this.f1447b = parcel.readInt();
        this.f1448c = parcel.readInt();
        int readInt = parcel.readInt();
        this.f1449d = readInt;
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            this.f1450e = iArr;
            parcel.readIntArray(iArr);
        }
        int readInt2 = parcel.readInt();
        this.f1451f = readInt2;
        if (readInt2 > 0) {
            int[] iArr2 = new int[readInt2];
            this.f1452g = iArr2;
            parcel.readIntArray(iArr2);
        }
        this.f1454i = parcel.readInt() == 1;
        this.f1455j = parcel.readInt() == 1;
        this.f1456k = parcel.readInt() == 1;
        this.f1453h = parcel.readArrayList(o1.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f1447b);
        parcel.writeInt(this.f1448c);
        parcel.writeInt(this.f1449d);
        if (this.f1449d > 0) {
            parcel.writeIntArray(this.f1450e);
        }
        parcel.writeInt(this.f1451f);
        if (this.f1451f > 0) {
            parcel.writeIntArray(this.f1452g);
        }
        parcel.writeInt(this.f1454i ? 1 : 0);
        parcel.writeInt(this.f1455j ? 1 : 0);
        parcel.writeInt(this.f1456k ? 1 : 0);
        parcel.writeList(this.f1453h);
    }

    public p1(p1 p1Var) {
        this.f1449d = p1Var.f1449d;
        this.f1447b = p1Var.f1447b;
        this.f1448c = p1Var.f1448c;
        this.f1450e = p1Var.f1450e;
        this.f1451f = p1Var.f1451f;
        this.f1452g = p1Var.f1452g;
        this.f1454i = p1Var.f1454i;
        this.f1455j = p1Var.f1455j;
        this.f1456k = p1Var.f1456k;
        this.f1453h = p1Var.f1453h;
    }
}
