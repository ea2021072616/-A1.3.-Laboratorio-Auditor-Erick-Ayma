package androidx.recyclerview.widget;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1298a;

    /* renamed from: b  reason: collision with root package name */
    public long f1299b;

    /* renamed from: c  reason: collision with root package name */
    public Object f1300c;

    public c(int i5) {
        this.f1298a = i5;
        if (i5 != 1) {
            this.f1299b = 0L;
            return;
        }
        this.f1299b = 0L;
        this.f1300c = a2.c.f9c;
    }

    public final void a(int i5) {
        if (i5 < 64) {
            this.f1299b &= ~(1 << i5);
            return;
        }
        Object obj = this.f1300c;
        if (((c) obj) != null) {
            ((c) obj).a(i5 - 64);
        }
    }

    public final int b(int i5) {
        Object obj = this.f1300c;
        if (((c) obj) == null) {
            return i5 >= 64 ? Long.bitCount(this.f1299b) : Long.bitCount(this.f1299b & ((1 << i5) - 1));
        } else if (i5 < 64) {
            return Long.bitCount(this.f1299b & ((1 << i5) - 1));
        } else {
            return Long.bitCount(this.f1299b) + ((c) obj).b(i5 - 64);
        }
    }

    public final void c() {
        if (((c) this.f1300c) == null) {
            this.f1300c = new c(0);
        }
    }

    public final boolean d(int i5) {
        if (i5 < 64) {
            return (this.f1299b & (1 << i5)) != 0;
        }
        c();
        return ((c) this.f1300c).d(i5 - 64);
    }

    public final void e(int i5, boolean z4) {
        if (i5 >= 64) {
            c();
            ((c) this.f1300c).e(i5 - 64, z4);
            return;
        }
        long j5 = this.f1299b;
        boolean z5 = (Long.MIN_VALUE & j5) != 0;
        long j6 = (1 << i5) - 1;
        this.f1299b = ((j5 & (~j6)) << 1) | (j5 & j6);
        if (z4) {
            h(i5);
        } else {
            a(i5);
        }
        if (z5 || ((c) this.f1300c) != null) {
            c();
            ((c) this.f1300c).e(0, z5);
        }
    }

    public final boolean f(int i5) {
        if (i5 >= 64) {
            c();
            return ((c) this.f1300c).f(i5 - 64);
        }
        long j5 = 1 << i5;
        long j6 = this.f1299b;
        boolean z4 = (j6 & j5) != 0;
        long j7 = j6 & (~j5);
        this.f1299b = j7;
        long j8 = j5 - 1;
        this.f1299b = (j7 & j8) | Long.rotateRight((~j8) & j7, 1);
        Object obj = this.f1300c;
        if (((c) obj) != null) {
            if (((c) obj).d(0)) {
                h(63);
            }
            ((c) this.f1300c).f(0);
        }
        return z4;
    }

    public final void g() {
        this.f1299b = 0L;
        Object obj = this.f1300c;
        if (((c) obj) != null) {
            ((c) obj).g();
        }
    }

    public final void h(int i5) {
        if (i5 < 64) {
            this.f1299b |= 1 << i5;
            return;
        }
        c();
        ((c) this.f1300c).h(i5 - 64);
    }

    public final String toString() {
        switch (this.f1298a) {
            case 0:
                if (((c) this.f1300c) == null) {
                    return Long.toBinaryString(this.f1299b);
                }
                return ((c) this.f1300c).toString() + "xx" + Long.toBinaryString(this.f1299b);
            default:
                return super.toString();
        }
    }
}
