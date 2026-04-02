package l;
/* loaded from: classes.dex */
public final class d implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f3676f = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f3677b = false;

    /* renamed from: c  reason: collision with root package name */
    public long[] f3678c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f3679d;

    /* renamed from: e  reason: collision with root package name */
    public int f3680e;

    public d() {
        int i5;
        int i6 = 4;
        while (true) {
            i5 = 80;
            if (i6 >= 32) {
                break;
            }
            int i7 = (1 << i6) - 12;
            if (80 <= i7) {
                i5 = i7;
                break;
            }
            i6++;
        }
        int i8 = i5 / 8;
        this.f3678c = new long[i8];
        this.f3679d = new Object[i8];
    }

    public final void a() {
        int i5 = this.f3680e;
        Object[] objArr = this.f3679d;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.f3680e = 0;
        this.f3677b = false;
    }

    /* renamed from: b */
    public final d clone() {
        try {
            d dVar = (d) super.clone();
            dVar.f3678c = (long[]) this.f3678c.clone();
            dVar.f3679d = (Object[]) this.f3679d.clone();
            return dVar;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public final void c() {
        int i5 = this.f3680e;
        long[] jArr = this.f3678c;
        Object[] objArr = this.f3679d;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != f3676f) {
                if (i7 != i6) {
                    jArr[i6] = jArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        this.f3677b = false;
        this.f3680e = i6;
    }

    public final Object d(long j5, Long l5) {
        Object obj;
        int c5 = b4.j.c(this.f3678c, this.f3680e, j5);
        return (c5 < 0 || (obj = this.f3679d[c5]) == f3676f) ? l5 : obj;
    }

    public final void e(long j5, Object obj) {
        int c5 = b4.j.c(this.f3678c, this.f3680e, j5);
        if (c5 >= 0) {
            this.f3679d[c5] = obj;
            return;
        }
        int i5 = ~c5;
        int i6 = this.f3680e;
        if (i5 < i6) {
            Object[] objArr = this.f3679d;
            if (objArr[i5] == f3676f) {
                this.f3678c[i5] = j5;
                objArr[i5] = obj;
                return;
            }
        }
        if (this.f3677b && i6 >= this.f3678c.length) {
            c();
            i5 = ~b4.j.c(this.f3678c, this.f3680e, j5);
        }
        int i7 = this.f3680e;
        if (i7 >= this.f3678c.length) {
            int i8 = (i7 + 1) * 8;
            int i9 = 4;
            while (true) {
                if (i9 >= 32) {
                    break;
                }
                int i10 = (1 << i9) - 12;
                if (i8 <= i10) {
                    i8 = i10;
                    break;
                }
                i9++;
            }
            int i11 = i8 / 8;
            long[] jArr = new long[i11];
            Object[] objArr2 = new Object[i11];
            long[] jArr2 = this.f3678c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f3679d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f3678c = jArr;
            this.f3679d = objArr2;
        }
        int i12 = this.f3680e - i5;
        if (i12 != 0) {
            long[] jArr3 = this.f3678c;
            int i13 = i5 + 1;
            System.arraycopy(jArr3, i5, jArr3, i13, i12);
            Object[] objArr4 = this.f3679d;
            System.arraycopy(objArr4, i5, objArr4, i13, this.f3680e - i5);
        }
        this.f3678c[i5] = j5;
        this.f3679d[i5] = obj;
        this.f3680e++;
    }

    public final Object f(int i5) {
        if (this.f3677b) {
            c();
        }
        return this.f3679d[i5];
    }

    public final String toString() {
        if (this.f3677b) {
            c();
        }
        int i5 = this.f3680e;
        if (i5 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i5 * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.f3680e; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            if (this.f3677b) {
                c();
            }
            sb.append(this.f3678c[i6]);
            sb.append('=');
            Object f5 = f(i6);
            if (f5 != this) {
                sb.append(f5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
