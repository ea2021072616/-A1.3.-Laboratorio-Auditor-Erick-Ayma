package l;
/* loaded from: classes.dex */
public final class k implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f3706e = new Object();

    /* renamed from: b  reason: collision with root package name */
    public int[] f3707b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f3708c;

    /* renamed from: d  reason: collision with root package name */
    public int f3709d;

    public k() {
        int i5;
        int i6 = 4;
        while (true) {
            i5 = 40;
            if (i6 >= 32) {
                break;
            }
            int i7 = (1 << i6) - 12;
            if (40 <= i7) {
                i5 = i7;
                break;
            }
            i6++;
        }
        int i8 = i5 / 4;
        this.f3707b = new int[i8];
        this.f3708c = new Object[i8];
    }

    public final void a(int i5, Object obj) {
        int i6 = this.f3709d;
        if (i6 != 0 && i5 <= this.f3707b[i6 - 1]) {
            d(i5, obj);
            return;
        }
        if (i6 >= this.f3707b.length) {
            int i7 = (i6 + 1) * 4;
            int i8 = 4;
            while (true) {
                if (i8 >= 32) {
                    break;
                }
                int i9 = (1 << i8) - 12;
                if (i7 <= i9) {
                    i7 = i9;
                    break;
                }
                i8++;
            }
            int i10 = i7 / 4;
            int[] iArr = new int[i10];
            Object[] objArr = new Object[i10];
            int[] iArr2 = this.f3707b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f3708c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f3707b = iArr;
            this.f3708c = objArr;
        }
        this.f3707b[i6] = i5;
        this.f3708c[i6] = obj;
        this.f3709d = i6 + 1;
    }

    /* renamed from: b */
    public final k clone() {
        try {
            k kVar = (k) super.clone();
            kVar.f3707b = (int[]) this.f3707b.clone();
            kVar.f3708c = (Object[]) this.f3708c.clone();
            return kVar;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public final Object c(int i5, Integer num) {
        Object obj;
        int b5 = b4.j.b(this.f3709d, i5, this.f3707b);
        return (b5 < 0 || (obj = this.f3708c[b5]) == f3706e) ? num : obj;
    }

    public final void d(int i5, Object obj) {
        int b5 = b4.j.b(this.f3709d, i5, this.f3707b);
        if (b5 >= 0) {
            this.f3708c[b5] = obj;
            return;
        }
        int i6 = ~b5;
        int i7 = this.f3709d;
        if (i6 < i7) {
            Object[] objArr = this.f3708c;
            if (objArr[i6] == f3706e) {
                this.f3707b[i6] = i5;
                objArr[i6] = obj;
                return;
            }
        }
        if (i7 >= this.f3707b.length) {
            int i8 = (i7 + 1) * 4;
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
            int i11 = i8 / 4;
            int[] iArr = new int[i11];
            Object[] objArr2 = new Object[i11];
            int[] iArr2 = this.f3707b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f3708c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f3707b = iArr;
            this.f3708c = objArr2;
        }
        int i12 = this.f3709d - i6;
        if (i12 != 0) {
            int[] iArr3 = this.f3707b;
            int i13 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i13, i12);
            Object[] objArr4 = this.f3708c;
            System.arraycopy(objArr4, i6, objArr4, i13, this.f3709d - i6);
        }
        this.f3707b[i6] = i5;
        this.f3708c[i6] = obj;
        this.f3709d++;
    }

    public final String toString() {
        int i5 = this.f3709d;
        if (i5 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i5 * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.f3709d; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(this.f3707b[i6]);
            sb.append('=');
            Object obj = this.f3708c[i6];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
