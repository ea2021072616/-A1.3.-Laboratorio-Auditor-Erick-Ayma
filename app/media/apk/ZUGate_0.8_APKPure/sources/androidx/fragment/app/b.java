package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new androidx.activity.result.a(4);

    /* renamed from: b  reason: collision with root package name */
    public final int[] f822b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f823c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f824d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f825e;

    /* renamed from: f  reason: collision with root package name */
    public final int f826f;

    /* renamed from: g  reason: collision with root package name */
    public final String f827g;

    /* renamed from: h  reason: collision with root package name */
    public final int f828h;

    /* renamed from: i  reason: collision with root package name */
    public final int f829i;

    /* renamed from: j  reason: collision with root package name */
    public final CharSequence f830j;

    /* renamed from: k  reason: collision with root package name */
    public final int f831k;

    /* renamed from: l  reason: collision with root package name */
    public final CharSequence f832l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f833m;

    /* renamed from: n  reason: collision with root package name */
    public final ArrayList f834n;
    public final boolean o;

    public b(a aVar) {
        int size = aVar.f894a.size();
        this.f822b = new int[size * 6];
        if (aVar.f900g) {
            this.f823c = new ArrayList(size);
            this.f824d = new int[size];
            this.f825e = new int[size];
            int i5 = 0;
            int i6 = 0;
            while (i5 < size) {
                f1 f1Var = (f1) aVar.f894a.get(i5);
                int i7 = i6 + 1;
                this.f822b[i6] = f1Var.f880a;
                ArrayList arrayList = this.f823c;
                Fragment fragment = f1Var.f881b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f822b;
                int i8 = i7 + 1;
                iArr[i7] = f1Var.f882c ? 1 : 0;
                int i9 = i8 + 1;
                iArr[i8] = f1Var.f883d;
                int i10 = i9 + 1;
                iArr[i9] = f1Var.f884e;
                int i11 = i10 + 1;
                iArr[i10] = f1Var.f885f;
                iArr[i11] = f1Var.f886g;
                this.f824d[i5] = f1Var.f887h.ordinal();
                this.f825e[i5] = f1Var.f888i.ordinal();
                i5++;
                i6 = i11 + 1;
            }
            this.f826f = aVar.f899f;
            this.f827g = aVar.f902i;
            this.f828h = aVar.f820s;
            this.f829i = aVar.f903j;
            this.f830j = aVar.f904k;
            this.f831k = aVar.f905l;
            this.f832l = aVar.f906m;
            this.f833m = aVar.f907n;
            this.f834n = aVar.o;
            this.o = aVar.f908p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeIntArray(this.f822b);
        parcel.writeStringList(this.f823c);
        parcel.writeIntArray(this.f824d);
        parcel.writeIntArray(this.f825e);
        parcel.writeInt(this.f826f);
        parcel.writeString(this.f827g);
        parcel.writeInt(this.f828h);
        parcel.writeInt(this.f829i);
        TextUtils.writeToParcel(this.f830j, parcel, 0);
        parcel.writeInt(this.f831k);
        TextUtils.writeToParcel(this.f832l, parcel, 0);
        parcel.writeStringList(this.f833m);
        parcel.writeStringList(this.f834n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f822b = parcel.createIntArray();
        this.f823c = parcel.createStringArrayList();
        this.f824d = parcel.createIntArray();
        this.f825e = parcel.createIntArray();
        this.f826f = parcel.readInt();
        this.f827g = parcel.readString();
        this.f828h = parcel.readInt();
        this.f829i = parcel.readInt();
        this.f830j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f831k = parcel.readInt();
        this.f832l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f833m = parcel.createStringArrayList();
        this.f834n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }
}
