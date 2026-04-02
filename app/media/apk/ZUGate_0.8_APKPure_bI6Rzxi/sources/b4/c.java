package b4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final Object[] f1654e = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    public int f1655b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f1656c = f1654e;

    /* renamed from: d  reason: collision with root package name */
    public int f1657d;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        z0.d.b(i5, this.f1657d);
        int i6 = this.f1657d;
        if (i5 == i6) {
            e(obj);
        } else if (i5 == 0) {
            g(i6 + 1);
            int i7 = this.f1655b;
            if (i7 == 0) {
                Object[] objArr = this.f1656c;
                e4.e.f(objArr, "<this>");
                i7 = objArr.length;
            }
            int i8 = i7 - 1;
            this.f1655b = i8;
            this.f1656c[i8] = obj;
            this.f1657d++;
        } else {
            g(i6 + 1);
            int i9 = i(this.f1655b + i5);
            int i10 = this.f1657d;
            if (i5 < ((i10 + 1) >> 1)) {
                if (i9 == 0) {
                    Object[] objArr2 = this.f1656c;
                    e4.e.f(objArr2, "<this>");
                    i9 = objArr2.length;
                }
                int i11 = i9 - 1;
                int i12 = this.f1655b;
                if (i12 == 0) {
                    Object[] objArr3 = this.f1656c;
                    e4.e.f(objArr3, "<this>");
                    i12 = objArr3.length;
                }
                int i13 = i12 - 1;
                int i14 = this.f1655b;
                if (i11 >= i14) {
                    Object[] objArr4 = this.f1656c;
                    objArr4[i13] = objArr4[i14];
                    d.k0(objArr4, objArr4, i14, i14 + 1, i11 + 1);
                } else {
                    Object[] objArr5 = this.f1656c;
                    d.k0(objArr5, objArr5, i14 - 1, i14, objArr5.length);
                    Object[] objArr6 = this.f1656c;
                    objArr6[objArr6.length - 1] = objArr6[0];
                    d.k0(objArr6, objArr6, 0, 1, i11 + 1);
                }
                this.f1656c[i11] = obj;
                this.f1655b = i13;
            } else {
                int i15 = i(this.f1655b + i10);
                if (i9 < i15) {
                    Object[] objArr7 = this.f1656c;
                    d.k0(objArr7, objArr7, i9 + 1, i9, i15);
                } else {
                    Object[] objArr8 = this.f1656c;
                    d.k0(objArr8, objArr8, 1, 0, i15);
                    Object[] objArr9 = this.f1656c;
                    objArr9[0] = objArr9[objArr9.length - 1];
                    d.k0(objArr9, objArr9, i9 + 1, i9, objArr9.length - 1);
                }
                this.f1656c[i9] = obj;
            }
            this.f1657d++;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i5, Collection collection) {
        e4.e.f(collection, "elements");
        z0.d.b(i5, this.f1657d);
        if (collection.isEmpty()) {
            return false;
        }
        int i6 = this.f1657d;
        if (i5 == i6) {
            return addAll(collection);
        }
        g(collection.size() + i6);
        int i7 = i(this.f1655b + this.f1657d);
        int i8 = i(this.f1655b + i5);
        int size = collection.size();
        if (i5 < ((this.f1657d + 1) >> 1)) {
            int i9 = this.f1655b;
            int i10 = i9 - size;
            if (i8 < i9) {
                Object[] objArr = this.f1656c;
                d.k0(objArr, objArr, i10, i9, objArr.length);
                if (size >= i8) {
                    Object[] objArr2 = this.f1656c;
                    d.k0(objArr2, objArr2, objArr2.length - size, 0, i8);
                } else {
                    Object[] objArr3 = this.f1656c;
                    d.k0(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f1656c;
                    d.k0(objArr4, objArr4, 0, size, i8);
                }
            } else if (i10 >= 0) {
                Object[] objArr5 = this.f1656c;
                d.k0(objArr5, objArr5, i10, i9, i8);
            } else {
                Object[] objArr6 = this.f1656c;
                i10 += objArr6.length;
                int i11 = i8 - i9;
                int length = objArr6.length - i10;
                if (length >= i11) {
                    d.k0(objArr6, objArr6, i10, i9, i8);
                } else {
                    d.k0(objArr6, objArr6, i10, i9, i9 + length);
                    Object[] objArr7 = this.f1656c;
                    d.k0(objArr7, objArr7, 0, this.f1655b + length, i8);
                }
            }
            this.f1655b = i10;
            int i12 = i8 - size;
            if (i12 < 0) {
                i12 += this.f1656c.length;
            }
            f(i12, collection);
        } else {
            int i13 = i8 + size;
            if (i8 < i7) {
                int i14 = size + i7;
                Object[] objArr8 = this.f1656c;
                if (i14 <= objArr8.length) {
                    d.k0(objArr8, objArr8, i13, i8, i7);
                } else if (i13 >= objArr8.length) {
                    d.k0(objArr8, objArr8, i13 - objArr8.length, i8, i7);
                } else {
                    int length2 = i7 - (i14 - objArr8.length);
                    d.k0(objArr8, objArr8, 0, length2, i7);
                    Object[] objArr9 = this.f1656c;
                    d.k0(objArr9, objArr9, i13, i8, length2);
                }
            } else {
                Object[] objArr10 = this.f1656c;
                d.k0(objArr10, objArr10, size, 0, i7);
                Object[] objArr11 = this.f1656c;
                if (i13 >= objArr11.length) {
                    d.k0(objArr11, objArr11, i13 - objArr11.length, i8, objArr11.length);
                } else {
                    d.k0(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f1656c;
                    d.k0(objArr12, objArr12, i13, i8, objArr12.length - size);
                }
            }
            f(i8, collection);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int i5 = i(this.f1655b + this.f1657d);
        int i6 = this.f1655b;
        if (i6 < i5) {
            Object[] objArr = this.f1656c;
            e4.e.f(objArr, "<this>");
            Arrays.fill(objArr, i6, i5, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f1656c;
            Arrays.fill(objArr2, this.f1655b, objArr2.length, (Object) null);
            Object[] objArr3 = this.f1656c;
            e4.e.f(objArr3, "<this>");
            Arrays.fill(objArr3, 0, i5, (Object) null);
        }
        this.f1655b = 0;
        this.f1657d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void e(Object obj) {
        g(this.f1657d + 1);
        this.f1656c[i(this.f1655b + this.f1657d)] = obj;
        this.f1657d++;
    }

    public final void f(int i5, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f1656c.length;
        while (i5 < length && it.hasNext()) {
            this.f1656c[i5] = it.next();
            i5++;
        }
        int i6 = this.f1655b;
        for (int i7 = 0; i7 < i6 && it.hasNext(); i7++) {
            this.f1656c[i7] = it.next();
        }
        this.f1657d = collection.size() + this.f1657d;
    }

    public final void g(int i5) {
        if (i5 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f1656c;
        if (i5 <= objArr.length) {
            return;
        }
        if (objArr == f1654e) {
            if (i5 < 10) {
                i5 = 10;
            }
            this.f1656c = new Object[i5];
            return;
        }
        int length = objArr.length;
        int i6 = length + (length >> 1);
        if (i6 - i5 < 0) {
            i6 = i5;
        }
        if (i6 - 2147483639 > 0) {
            i6 = i5 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i6];
        d.k0(objArr, objArr2, 0, this.f1655b, objArr.length);
        Object[] objArr3 = this.f1656c;
        int length2 = objArr3.length;
        int i7 = this.f1655b;
        d.k0(objArr3, objArr2, length2 - i7, 0, i7);
        this.f1655b = 0;
        this.f1656c = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i5) {
        z0.d.a(i5, this.f1657d);
        return this.f1656c[i(this.f1655b + i5)];
    }

    public final int h(int i5) {
        Object[] objArr = this.f1656c;
        e4.e.f(objArr, "<this>");
        if (i5 == objArr.length - 1) {
            return 0;
        }
        return i5 + 1;
    }

    public final int i(int i5) {
        Object[] objArr = this.f1656c;
        return i5 >= objArr.length ? i5 - objArr.length : i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i5;
        int i6 = i(this.f1655b + this.f1657d);
        int i7 = this.f1655b;
        if (i7 < i6) {
            while (i7 < i6) {
                if (e4.e.a(obj, this.f1656c[i7])) {
                    i5 = this.f1655b;
                } else {
                    i7++;
                }
            }
            return -1;
        } else if (i7 < i6) {
            return -1;
        } else {
            int length = this.f1656c.length;
            while (true) {
                if (i7 >= length) {
                    for (int i8 = 0; i8 < i6; i8++) {
                        if (e4.e.a(obj, this.f1656c[i8])) {
                            i7 = i8 + this.f1656c.length;
                            i5 = this.f1655b;
                        }
                    }
                    return -1;
                } else if (e4.e.a(obj, this.f1656c[i7])) {
                    i5 = this.f1655b;
                    break;
                } else {
                    i7++;
                }
            }
        }
        return i7 - i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f1657d == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i5;
        int i6 = i(this.f1655b + this.f1657d);
        int i7 = this.f1655b;
        if (i7 < i6) {
            length = i6 - 1;
            if (i7 <= length) {
                while (!e4.e.a(obj, this.f1656c[length])) {
                    if (length != i7) {
                        length--;
                    }
                }
                i5 = this.f1655b;
                return length - i5;
            }
            return -1;
        }
        if (i7 > i6) {
            int i8 = i6 - 1;
            while (true) {
                if (-1 >= i8) {
                    Object[] objArr = this.f1656c;
                    e4.e.f(objArr, "<this>");
                    length = objArr.length - 1;
                    int i9 = this.f1655b;
                    if (i9 <= length) {
                        while (!e4.e.a(obj, this.f1656c[length])) {
                            if (length != i9) {
                                length--;
                            }
                        }
                        i5 = this.f1655b;
                    }
                } else if (e4.e.a(obj, this.f1656c[i8])) {
                    length = i8 + this.f1656c.length;
                    i5 = this.f1655b;
                    break;
                } else {
                    i8--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int i5;
        e4.e.f(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty()) {
            if ((this.f1656c.length == 0 ? 1 : null) == null) {
                int i6 = i(this.f1655b + this.f1657d);
                int i7 = this.f1655b;
                if (i7 < i6) {
                    i5 = i7;
                    while (i7 < i6) {
                        Object obj = this.f1656c[i7];
                        if (!collection.contains(obj)) {
                            this.f1656c[i5] = obj;
                            i5++;
                        } else {
                            z4 = true;
                        }
                        i7++;
                    }
                    Object[] objArr = this.f1656c;
                    e4.e.f(objArr, "<this>");
                    Arrays.fill(objArr, i5, i6, (Object) null);
                } else {
                    int length = this.f1656c.length;
                    boolean z5 = false;
                    int i8 = i7;
                    while (i7 < length) {
                        Object[] objArr2 = this.f1656c;
                        Object obj2 = objArr2[i7];
                        objArr2[i7] = null;
                        if (!collection.contains(obj2)) {
                            this.f1656c[i8] = obj2;
                            i8++;
                        } else {
                            z5 = true;
                        }
                        i7++;
                    }
                    i5 = i(i8);
                    for (int i9 = 0; i9 < i6; i9++) {
                        Object[] objArr3 = this.f1656c;
                        Object obj3 = objArr3[i9];
                        objArr3[i9] = null;
                        if (!collection.contains(obj3)) {
                            this.f1656c[i5] = obj3;
                            i5 = h(i5);
                        } else {
                            z5 = true;
                        }
                    }
                    z4 = z5;
                }
                if (z4) {
                    int i10 = i5 - this.f1655b;
                    if (i10 < 0) {
                        i10 += this.f1656c.length;
                    }
                    this.f1657d = i10;
                }
            }
        }
        return z4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int i5;
        e4.e.f(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty()) {
            if ((this.f1656c.length == 0 ? 1 : null) == null) {
                int i6 = i(this.f1655b + this.f1657d);
                int i7 = this.f1655b;
                if (i7 < i6) {
                    i5 = i7;
                    while (i7 < i6) {
                        Object obj = this.f1656c[i7];
                        if (collection.contains(obj)) {
                            this.f1656c[i5] = obj;
                            i5++;
                        } else {
                            z4 = true;
                        }
                        i7++;
                    }
                    Object[] objArr = this.f1656c;
                    e4.e.f(objArr, "<this>");
                    Arrays.fill(objArr, i5, i6, (Object) null);
                } else {
                    int length = this.f1656c.length;
                    boolean z5 = false;
                    int i8 = i7;
                    while (i7 < length) {
                        Object[] objArr2 = this.f1656c;
                        Object obj2 = objArr2[i7];
                        objArr2[i7] = null;
                        if (collection.contains(obj2)) {
                            this.f1656c[i8] = obj2;
                            i8++;
                        } else {
                            z5 = true;
                        }
                        i7++;
                    }
                    i5 = i(i8);
                    for (int i9 = 0; i9 < i6; i9++) {
                        Object[] objArr3 = this.f1656c;
                        Object obj3 = objArr3[i9];
                        objArr3[i9] = null;
                        if (collection.contains(obj3)) {
                            this.f1656c[i5] = obj3;
                            i5 = h(i5);
                        } else {
                            z5 = true;
                        }
                    }
                    z4 = z5;
                }
                if (z4) {
                    int i10 = i5 - this.f1655b;
                    if (i10 < 0) {
                        i10 += this.f1656c.length;
                    }
                    this.f1657d = i10;
                }
            }
        }
        return z4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        z0.d.a(i5, this.f1657d);
        int i6 = i(this.f1655b + i5);
        Object[] objArr = this.f1656c;
        Object obj2 = objArr[i6];
        objArr[i6] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.f1657d]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        e4.e.f(objArr, "array");
        int length = objArr.length;
        int i5 = this.f1657d;
        if (length < i5) {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i5);
            e4.e.d(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) newInstance;
        }
        int i6 = i(this.f1655b + this.f1657d);
        int i7 = this.f1655b;
        if (i7 < i6) {
            d.l0(this.f1656c, objArr, 0, i7, i6, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f1656c;
            d.k0(objArr2, objArr, 0, this.f1655b, objArr2.length);
            Object[] objArr3 = this.f1656c;
            d.k0(objArr3, objArr, objArr3.length - this.f1655b, 0, i6);
        }
        int length2 = objArr.length;
        int i8 = this.f1657d;
        if (length2 > i8) {
            objArr[i8] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        e(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        e4.e.f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        g(collection.size() + this.f1657d);
        f(i(this.f1655b + this.f1657d), collection);
        return true;
    }
}
