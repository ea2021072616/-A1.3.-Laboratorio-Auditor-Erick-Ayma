package l;

import java.util.ConcurrentModificationException;
import java.util.Map;
/* loaded from: classes.dex */
public class j {

    /* renamed from: e  reason: collision with root package name */
    public static Object[] f3699e;

    /* renamed from: f  reason: collision with root package name */
    public static int f3700f;

    /* renamed from: g  reason: collision with root package name */
    public static Object[] f3701g;

    /* renamed from: h  reason: collision with root package name */
    public static int f3702h;

    /* renamed from: b  reason: collision with root package name */
    public int[] f3703b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f3704c;

    /* renamed from: d  reason: collision with root package name */
    public int f3705d;

    public j() {
        this.f3703b = b4.j.f1676p;
        this.f3704c = b4.j.f1677q;
        this.f3705d = 0;
    }

    private void a(int i5) {
        if (i5 == 8) {
            synchronized (j.class) {
                Object[] objArr = f3701g;
                if (objArr != null) {
                    this.f3704c = objArr;
                    f3701g = (Object[]) objArr[0];
                    this.f3703b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f3702h--;
                    return;
                }
            }
        } else if (i5 == 4) {
            synchronized (j.class) {
                Object[] objArr2 = f3699e;
                if (objArr2 != null) {
                    this.f3704c = objArr2;
                    f3699e = (Object[]) objArr2[0];
                    this.f3703b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f3700f--;
                    return;
                }
            }
        }
        this.f3703b = new int[i5];
        this.f3704c = new Object[i5 << 1];
    }

    public static void c(int[] iArr, Object[] objArr, int i5) {
        if (iArr.length == 8) {
            synchronized (j.class) {
                if (f3702h < 10) {
                    objArr[0] = f3701g;
                    objArr[1] = iArr;
                    for (int i6 = (i5 << 1) - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    f3701g = objArr;
                    f3702h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (j.class) {
                if (f3700f < 10) {
                    objArr[0] = f3699e;
                    objArr[1] = iArr;
                    for (int i7 = (i5 << 1) - 1; i7 >= 2; i7--) {
                        objArr[i7] = null;
                    }
                    f3699e = objArr;
                    f3700f++;
                }
            }
        }
    }

    public final void b(int i5) {
        int i6 = this.f3705d;
        int[] iArr = this.f3703b;
        if (iArr.length < i5) {
            Object[] objArr = this.f3704c;
            a(i5);
            if (this.f3705d > 0) {
                System.arraycopy(iArr, 0, this.f3703b, 0, i6);
                System.arraycopy(objArr, 0, this.f3704c, 0, i6 << 1);
            }
            c(iArr, objArr, i6);
        }
        if (this.f3705d != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public final void clear() {
        int i5 = this.f3705d;
        if (i5 > 0) {
            int[] iArr = this.f3703b;
            Object[] objArr = this.f3704c;
            this.f3703b = b4.j.f1676p;
            this.f3704c = b4.j.f1677q;
            this.f3705d = 0;
            c(iArr, objArr, i5);
        }
        if (this.f3705d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final int d(int i5, Object obj) {
        int i6 = this.f3705d;
        if (i6 == 0) {
            return -1;
        }
        try {
            int b5 = b4.j.b(i6, i5, this.f3703b);
            if (b5 >= 0 && !obj.equals(this.f3704c[b5 << 1])) {
                int i7 = b5 + 1;
                while (i7 < i6 && this.f3703b[i7] == i5) {
                    if (obj.equals(this.f3704c[i7 << 1])) {
                        return i7;
                    }
                    i7++;
                }
                for (int i8 = b5 - 1; i8 >= 0 && this.f3703b[i8] == i5; i8--) {
                    if (obj.equals(this.f3704c[i8 << 1])) {
                        return i8;
                    }
                }
                return ~i7;
            }
            return b5;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        return obj == null ? f() : d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.f3705d != jVar.f3705d) {
                return false;
            }
            for (int i5 = 0; i5 < this.f3705d; i5++) {
                try {
                    Object h5 = h(i5);
                    Object j5 = j(i5);
                    Object orDefault = jVar.getOrDefault(h5, null);
                    if (j5 == null) {
                        if (orDefault != null || !jVar.containsKey(h5)) {
                            return false;
                        }
                    } else if (!j5.equals(orDefault)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f3705d != map.size()) {
                return false;
            }
            for (int i6 = 0; i6 < this.f3705d; i6++) {
                try {
                    Object h6 = h(i6);
                    Object j6 = j(i6);
                    Object obj2 = map.get(h6);
                    if (j6 == null) {
                        if (obj2 != null || !map.containsKey(h6)) {
                            return false;
                        }
                    } else if (!j6.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i5 = this.f3705d;
        if (i5 == 0) {
            return -1;
        }
        try {
            int b5 = b4.j.b(i5, 0, this.f3703b);
            if (b5 >= 0 && this.f3704c[b5 << 1] != null) {
                int i6 = b5 + 1;
                while (i6 < i5 && this.f3703b[i6] == 0) {
                    if (this.f3704c[i6 << 1] == null) {
                        return i6;
                    }
                    i6++;
                }
                for (int i7 = b5 - 1; i7 >= 0 && this.f3703b[i7] == 0; i7--) {
                    if (this.f3704c[i7 << 1] == null) {
                        return i7;
                    }
                }
                return ~i6;
            }
            return b5;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int g(Object obj) {
        int i5 = this.f3705d * 2;
        Object[] objArr = this.f3704c;
        if (obj == null) {
            for (int i6 = 1; i6 < i5; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i7 = 1; i7 < i5; i7 += 2) {
            if (obj.equals(objArr[i7])) {
                return i7 >> 1;
            }
        }
        return -1;
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int e5 = e(obj);
        return e5 >= 0 ? this.f3704c[(e5 << 1) + 1] : obj2;
    }

    public final Object h(int i5) {
        return this.f3704c[i5 << 1];
    }

    public final int hashCode() {
        int[] iArr = this.f3703b;
        Object[] objArr = this.f3704c;
        int i5 = this.f3705d;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            i8 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i7];
            i7++;
            i6 += 2;
        }
        return i8;
    }

    public final Object i(int i5) {
        Object[] objArr = this.f3704c;
        int i6 = i5 << 1;
        Object obj = objArr[i6 + 1];
        int i7 = this.f3705d;
        int i8 = 0;
        if (i7 <= 1) {
            c(this.f3703b, objArr, i7);
            this.f3703b = b4.j.f1676p;
            this.f3704c = b4.j.f1677q;
        } else {
            int i9 = i7 - 1;
            int[] iArr = this.f3703b;
            if (iArr.length <= 8 || i7 >= iArr.length / 3) {
                if (i5 < i9) {
                    int i10 = i5 + 1;
                    int i11 = i9 - i5;
                    System.arraycopy(iArr, i10, iArr, i5, i11);
                    Object[] objArr2 = this.f3704c;
                    System.arraycopy(objArr2, i10 << 1, objArr2, i6, i11 << 1);
                }
                Object[] objArr3 = this.f3704c;
                int i12 = i9 << 1;
                objArr3[i12] = null;
                objArr3[i12 + 1] = null;
            } else {
                a(i7 > 8 ? i7 + (i7 >> 1) : 8);
                if (i7 != this.f3705d) {
                    throw new ConcurrentModificationException();
                }
                if (i5 > 0) {
                    System.arraycopy(iArr, 0, this.f3703b, 0, i5);
                    System.arraycopy(objArr, 0, this.f3704c, 0, i6);
                }
                if (i5 < i9) {
                    int i13 = i5 + 1;
                    int i14 = i9 - i5;
                    System.arraycopy(iArr, i13, this.f3703b, i5, i14);
                    System.arraycopy(objArr, i13 << 1, this.f3704c, i6, i14 << 1);
                }
            }
            i8 = i9;
        }
        if (i7 == this.f3705d) {
            this.f3705d = i8;
            return obj;
        }
        throw new ConcurrentModificationException();
    }

    public final boolean isEmpty() {
        return this.f3705d <= 0;
    }

    public final Object j(int i5) {
        return this.f3704c[(i5 << 1) + 1];
    }

    public final Object put(Object obj, Object obj2) {
        int i5;
        int d5;
        int i6 = this.f3705d;
        if (obj == null) {
            d5 = f();
            i5 = 0;
        } else {
            int hashCode = obj.hashCode();
            i5 = hashCode;
            d5 = d(hashCode, obj);
        }
        if (d5 >= 0) {
            int i7 = (d5 << 1) + 1;
            Object[] objArr = this.f3704c;
            Object obj3 = objArr[i7];
            objArr[i7] = obj2;
            return obj3;
        }
        int i8 = ~d5;
        int[] iArr = this.f3703b;
        if (i6 >= iArr.length) {
            int i9 = 8;
            if (i6 >= 8) {
                i9 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i9 = 4;
            }
            Object[] objArr2 = this.f3704c;
            a(i9);
            if (i6 != this.f3705d) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f3703b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f3704c, 0, objArr2.length);
            }
            c(iArr, objArr2, i6);
        }
        if (i8 < i6) {
            int[] iArr3 = this.f3703b;
            int i10 = i8 + 1;
            System.arraycopy(iArr3, i8, iArr3, i10, i6 - i8);
            Object[] objArr3 = this.f3704c;
            System.arraycopy(objArr3, i8 << 1, objArr3, i10 << 1, (this.f3705d - i8) << 1);
        }
        int i11 = this.f3705d;
        if (i6 == i11) {
            int[] iArr4 = this.f3703b;
            if (i8 < iArr4.length) {
                iArr4[i8] = i5;
                Object[] objArr4 = this.f3704c;
                int i12 = i8 << 1;
                objArr4[i12] = obj;
                objArr4[i12 + 1] = obj2;
                this.f3705d = i11 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, null);
        return orDefault == null ? put(obj, obj2) : orDefault;
    }

    public final Object remove(Object obj) {
        int e5 = e(obj);
        if (e5 >= 0) {
            return i(e5);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int e5 = e(obj);
        if (e5 >= 0) {
            int i5 = (e5 << 1) + 1;
            Object[] objArr = this.f3704c;
            Object obj3 = objArr[i5];
            objArr[i5] = obj2;
            return obj3;
        }
        return null;
    }

    public final int size() {
        return this.f3705d;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3705d * 28);
        sb.append('{');
        for (int i5 = 0; i5 < this.f3705d; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object h5 = h(i5);
            if (h5 != this) {
                sb.append(h5);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object j5 = j(i5);
            if (j5 != this) {
                sb.append(j5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean remove(Object obj, Object obj2) {
        int e5 = e(obj);
        if (e5 >= 0) {
            Object j5 = j(e5);
            if (obj2 == j5 || (obj2 != null && obj2.equals(j5))) {
                i(e5);
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int e5 = e(obj);
        if (e5 >= 0) {
            Object j5 = j(e5);
            if (j5 == obj2 || (obj2 != null && obj2.equals(j5))) {
                int i5 = (e5 << 1) + 1;
                Object[] objArr = this.f3704c;
                Object obj4 = objArr[i5];
                objArr[i5] = obj3;
                return true;
            }
            return false;
        }
        return false;
    }

    public j(int i5) {
        if (i5 == 0) {
            this.f3703b = b4.j.f1676p;
            this.f3704c = b4.j.f1677q;
        } else {
            a(i5);
        }
        this.f3705d = 0;
    }
}
