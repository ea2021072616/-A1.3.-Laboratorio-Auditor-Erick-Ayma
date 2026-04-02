package z;

import android.graphics.Insets;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final c f5748e = new c(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f5749a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5750b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5751c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5752d;

    public c(int i5, int i6, int i7, int i8) {
        this.f5749a = i5;
        this.f5750b = i6;
        this.f5751c = i7;
        this.f5752d = i8;
    }

    public static c a(c cVar, c cVar2) {
        return b(Math.max(cVar.f5749a, cVar2.f5749a), Math.max(cVar.f5750b, cVar2.f5750b), Math.max(cVar.f5751c, cVar2.f5751c), Math.max(cVar.f5752d, cVar2.f5752d));
    }

    public static c b(int i5, int i6, int i7, int i8) {
        return (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) ? f5748e : new c(i5, i6, i7, i8);
    }

    public static c c(Insets insets) {
        int i5;
        int i6;
        int i7;
        int i8;
        i5 = insets.left;
        i6 = insets.top;
        i7 = insets.right;
        i8 = insets.bottom;
        return b(i5, i6, i7, i8);
    }

    public final Insets d() {
        return b.a(this.f5749a, this.f5750b, this.f5751c, this.f5752d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5752d == cVar.f5752d && this.f5749a == cVar.f5749a && this.f5751c == cVar.f5751c && this.f5750b == cVar.f5750b;
    }

    public final int hashCode() {
        return (((((this.f5749a * 31) + this.f5750b) * 31) + this.f5751c) * 31) + this.f5752d;
    }

    public final String toString() {
        return "Insets{left=" + this.f5749a + ", top=" + this.f5750b + ", right=" + this.f5751c + ", bottom=" + this.f5752d + '}';
    }
}
