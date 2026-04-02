package g1;

import android.os.Parcel;
import android.util.SparseIntArray;
import androidx.appcompat.widget.b0;
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f2930d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f2931e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2932f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2933g;

    /* renamed from: h  reason: collision with root package name */
    public final String f2934h;

    /* renamed from: i  reason: collision with root package name */
    public int f2935i;

    /* renamed from: j  reason: collision with root package name */
    public int f2936j;

    /* renamed from: k  reason: collision with root package name */
    public int f2937k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new l.b(), new l.b(), new l.b());
    }

    @Override // g1.a
    public final b a() {
        Parcel parcel = this.f2931e;
        int dataPosition = parcel.dataPosition();
        int i5 = this.f2936j;
        if (i5 == this.f2932f) {
            i5 = this.f2933g;
        }
        return new b(parcel, dataPosition, i5, b0.i(new StringBuilder(), this.f2934h, "  "), this.f2927a, this.f2928b, this.f2929c);
    }

    @Override // g1.a
    public final boolean e(int i5) {
        while (this.f2936j < this.f2933g) {
            int i6 = this.f2937k;
            if (i6 == i5) {
                return true;
            }
            if (String.valueOf(i6).compareTo(String.valueOf(i5)) > 0) {
                return false;
            }
            int i7 = this.f2936j;
            Parcel parcel = this.f2931e;
            parcel.setDataPosition(i7);
            int readInt = parcel.readInt();
            this.f2937k = parcel.readInt();
            this.f2936j += readInt;
        }
        return this.f2937k == i5;
    }

    @Override // g1.a
    public final void i(int i5) {
        int i6 = this.f2935i;
        SparseIntArray sparseIntArray = this.f2930d;
        Parcel parcel = this.f2931e;
        if (i6 >= 0) {
            int i7 = sparseIntArray.get(i6);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i7);
            parcel.writeInt(dataPosition - i7);
            parcel.setDataPosition(dataPosition);
        }
        this.f2935i = i5;
        sparseIntArray.put(i5, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i5);
    }

    public b(Parcel parcel, int i5, int i6, String str, l.b bVar, l.b bVar2, l.b bVar3) {
        super(bVar, bVar2, bVar3);
        this.f2930d = new SparseIntArray();
        this.f2935i = -1;
        this.f2937k = -1;
        this.f2931e = parcel;
        this.f2932f = i5;
        this.f2933g = i6;
        this.f2936j = i5;
        this.f2934h = str;
    }
}
