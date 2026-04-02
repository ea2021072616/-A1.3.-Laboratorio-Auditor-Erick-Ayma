package l;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public final class c implements Collection, Set {

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f3666f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f3667g = new Object[0];

    /* renamed from: h  reason: collision with root package name */
    public static Object[] f3668h;

    /* renamed from: i  reason: collision with root package name */
    public static int f3669i;

    /* renamed from: j  reason: collision with root package name */
    public static Object[] f3670j;

    /* renamed from: k  reason: collision with root package name */
    public static int f3671k;

    /* renamed from: b  reason: collision with root package name */
    public int[] f3672b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f3673c;

    /* renamed from: d  reason: collision with root package name */
    public int f3674d;

    /* renamed from: e  reason: collision with root package name */
    public a f3675e;

    public c(int i5) {
        if (i5 == 0) {
            this.f3672b = f3666f;
            this.f3673c = f3667g;
        } else {
            e(i5);
        }
        this.f3674d = 0;
    }

    public static void f(int[] iArr, Object[] objArr, int i5) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (f3671k < 10) {
                    objArr[0] = f3670j;
                    objArr[1] = iArr;
                    for (int i6 = i5 - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    f3670j = objArr;
                    f3671k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (c.class) {
                if (f3669i < 10) {
                    objArr[0] = f3668h;
                    objArr[1] = iArr;
                    for (int i7 = i5 - 1; i7 >= 2; i7--) {
                        objArr[i7] = null;
                    }
                    f3668h = objArr;
                    f3669i++;
                }
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i5;
        int g5;
        if (obj == null) {
            g5 = h();
            i5 = 0;
        } else {
            int hashCode = obj.hashCode();
            i5 = hashCode;
            g5 = g(hashCode, obj);
        }
        if (g5 >= 0) {
            return false;
        }
        int i6 = ~g5;
        int i7 = this.f3674d;
        int[] iArr = this.f3672b;
        if (i7 >= iArr.length) {
            int i8 = 8;
            if (i7 >= 8) {
                i8 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i8 = 4;
            }
            Object[] objArr = this.f3673c;
            e(i8);
            int[] iArr2 = this.f3672b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f3673c, 0, objArr.length);
            }
            f(iArr, objArr, this.f3674d);
        }
        int i9 = this.f3674d;
        if (i6 < i9) {
            int[] iArr3 = this.f3672b;
            int i10 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i10, i9 - i6);
            Object[] objArr2 = this.f3673c;
            System.arraycopy(objArr2, i6, objArr2, i10, this.f3674d - i6);
        }
        this.f3672b[i6] = i5;
        this.f3673c[i6] = obj;
        this.f3674d++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.f3674d;
        int[] iArr = this.f3672b;
        boolean z4 = false;
        if (iArr.length < size) {
            Object[] objArr = this.f3673c;
            e(size);
            int i5 = this.f3674d;
            if (i5 > 0) {
                System.arraycopy(iArr, 0, this.f3672b, 0, i5);
                System.arraycopy(objArr, 0, this.f3673c, 0, this.f3674d);
            }
            f(iArr, objArr, this.f3674d);
        }
        for (Object obj : collection) {
            z4 |= add(obj);
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i5 = this.f3674d;
        if (i5 != 0) {
            f(this.f3672b, this.f3673c, i5);
            this.f3672b = f3666f;
            this.f3673c = f3667g;
            this.f3674d = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    public final void e(int i5) {
        if (i5 == 8) {
            synchronized (c.class) {
                Object[] objArr = f3670j;
                if (objArr != null) {
                    this.f3673c = objArr;
                    f3670j = (Object[]) objArr[0];
                    this.f3672b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f3671k--;
                    return;
                }
            }
        } else if (i5 == 4) {
            synchronized (c.class) {
                Object[] objArr2 = f3668h;
                if (objArr2 != null) {
                    this.f3673c = objArr2;
                    f3668h = (Object[]) objArr2[0];
                    this.f3672b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f3669i--;
                    return;
                }
            }
        }
        this.f3672b = new int[i5];
        this.f3673c = new Object[i5];
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f3674d != set.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f3674d; i5++) {
                try {
                    if (!set.contains(this.f3673c[i5])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g(int i5, Object obj) {
        int i6 = this.f3674d;
        if (i6 == 0) {
            return -1;
        }
        int b5 = b4.j.b(i6, i5, this.f3672b);
        if (b5 >= 0 && !obj.equals(this.f3673c[b5])) {
            int i7 = b5 + 1;
            while (i7 < i6 && this.f3672b[i7] == i5) {
                if (obj.equals(this.f3673c[i7])) {
                    return i7;
                }
                i7++;
            }
            for (int i8 = b5 - 1; i8 >= 0 && this.f3672b[i8] == i5; i8--) {
                if (obj.equals(this.f3673c[i8])) {
                    return i8;
                }
            }
            return ~i7;
        }
        return b5;
    }

    public final int h() {
        int i5 = this.f3674d;
        if (i5 == 0) {
            return -1;
        }
        int b5 = b4.j.b(i5, 0, this.f3672b);
        if (b5 >= 0 && this.f3673c[b5] != null) {
            int i6 = b5 + 1;
            while (i6 < i5 && this.f3672b[i6] == 0) {
                if (this.f3673c[i6] == null) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = b5 - 1; i7 >= 0 && this.f3672b[i7] == 0; i7--) {
                if (this.f3673c[i7] == null) {
                    return i7;
                }
            }
            return ~i6;
        }
        return b5;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f3672b;
        int i5 = this.f3674d;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += iArr[i7];
        }
        return i6;
    }

    public final void i(int i5) {
        Object[] objArr = this.f3673c;
        Object obj = objArr[i5];
        int i6 = this.f3674d;
        if (i6 <= 1) {
            f(this.f3672b, objArr, i6);
            this.f3672b = f3666f;
            this.f3673c = f3667g;
            this.f3674d = 0;
            return;
        }
        int[] iArr = this.f3672b;
        if (iArr.length <= 8 || i6 >= iArr.length / 3) {
            int i7 = i6 - 1;
            this.f3674d = i7;
            if (i5 < i7) {
                int i8 = i5 + 1;
                System.arraycopy(iArr, i8, iArr, i5, i7 - i5);
                Object[] objArr2 = this.f3673c;
                System.arraycopy(objArr2, i8, objArr2, i5, this.f3674d - i5);
            }
            this.f3673c[this.f3674d] = null;
            return;
        }
        e(i6 > 8 ? i6 + (i6 >> 1) : 8);
        this.f3674d--;
        if (i5 > 0) {
            System.arraycopy(iArr, 0, this.f3672b, 0, i5);
            System.arraycopy(objArr, 0, this.f3673c, 0, i5);
        }
        int i9 = this.f3674d;
        if (i5 < i9) {
            int i10 = i5 + 1;
            System.arraycopy(iArr, i10, this.f3672b, i5, i9 - i5);
            System.arraycopy(objArr, i10, this.f3673c, i5, this.f3674d - i5);
        }
    }

    public final int indexOf(Object obj) {
        return obj == null ? h() : g(obj.hashCode(), obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f3674d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        if (this.f3675e == null) {
            this.f3675e = new a(1, this);
        }
        a aVar = this.f3675e;
        if (((g) aVar.f2961h) == null) {
            aVar.f2961h = new g(aVar, 1);
        }
        return ((g) aVar.f2961h).iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            i(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        boolean z4 = false;
        for (Object obj : collection) {
            z4 |= remove(obj);
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z4 = false;
        for (int i5 = this.f3674d - 1; i5 >= 0; i5--) {
            if (!collection.contains(this.f3673c[i5])) {
                i(i5);
                z4 = true;
            }
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f3674d;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i5 = this.f3674d;
        Object[] objArr = new Object[i5];
        System.arraycopy(this.f3673c, 0, objArr, 0, i5);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3674d * 14);
        sb.append('{');
        for (int i5 = 0; i5 < this.f3674d; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object obj = this.f3673c[i5];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f3674d) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f3674d);
        }
        System.arraycopy(this.f3673c, 0, objArr, 0, this.f3674d);
        int length = objArr.length;
        int i5 = this.f3674d;
        if (length > i5) {
            objArr[i5] = null;
        }
        return objArr;
    }
}
