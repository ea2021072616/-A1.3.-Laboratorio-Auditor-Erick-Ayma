package m4;

import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class a implements Iterable {

    /* renamed from: b  reason: collision with root package name */
    public final int f3986b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3987c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3988d;

    public a(int i5, int i6, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i7 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3986b = i5;
        if (i7 > 0) {
            if (i5 < i6) {
                int i8 = i6 % i7;
                int i9 = i5 % i7;
                int i10 = ((i8 < 0 ? i8 + i7 : i8) - (i9 < 0 ? i9 + i7 : i9)) % i7;
                i6 -= i10 < 0 ? i10 + i7 : i10;
            }
        } else if (i7 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else {
            if (i5 > i6) {
                int i11 = -i7;
                int i12 = i5 % i11;
                int i13 = i6 % i11;
                int i14 = ((i12 < 0 ? i12 + i11 : i12) - (i13 < 0 ? i13 + i11 : i13)) % i11;
                i6 += i14 < 0 ? i14 + i11 : i14;
            }
        }
        this.f3987c = i6;
        this.f3988d = i7;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f3986b, this.f3987c, this.f3988d);
    }
}
