package androidx.recyclerview.widget;
/* loaded from: classes.dex */
public final class r1 {

    /* renamed from: a  reason: collision with root package name */
    public int f1510a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f1511b;

    /* renamed from: c  reason: collision with root package name */
    public int f1512c;

    /* renamed from: d  reason: collision with root package name */
    public int f1513d;

    /* renamed from: e  reason: collision with root package name */
    public int f1514e;

    public final boolean a() {
        int i5 = this.f1510a;
        int i6 = 2;
        if ((i5 & 7) != 0) {
            int i7 = this.f1513d;
            int i8 = this.f1511b;
            if ((((i7 > i8 ? 1 : i7 == i8 ? 2 : 4) << 0) & i5) == 0) {
                return false;
            }
        }
        if ((i5 & 112) != 0) {
            int i9 = this.f1513d;
            int i10 = this.f1512c;
            if ((((i9 > i10 ? 1 : i9 == i10 ? 2 : 4) << 4) & i5) == 0) {
                return false;
            }
        }
        if ((i5 & 1792) != 0) {
            int i11 = this.f1514e;
            int i12 = this.f1511b;
            if ((((i11 > i12 ? 1 : i11 == i12 ? 2 : 4) << 8) & i5) == 0) {
                return false;
            }
        }
        if ((i5 & 28672) != 0) {
            int i13 = this.f1514e;
            int i14 = this.f1512c;
            if (i13 > i14) {
                i6 = 1;
            } else if (i13 != i14) {
                i6 = 4;
            }
            if ((i5 & (i6 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
