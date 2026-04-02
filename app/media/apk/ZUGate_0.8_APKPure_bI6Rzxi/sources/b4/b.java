package b4;

import h0.f1;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class b implements Collection {

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f1652b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1653c = false;

    public b(Object[] objArr) {
        this.f1652b = objArr;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        int i5;
        Object[] objArr = this.f1652b;
        e4.e.f(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length;
            i5 = 0;
            while (i5 < length) {
                if (objArr[i5] == null) {
                    break;
                }
                i5++;
            }
            i5 = -1;
        } else {
            int length2 = objArr.length;
            for (int i6 = 0; i6 < length2; i6++) {
                if (e4.e.a(obj, objArr[i6])) {
                    i5 = i6;
                    break;
                }
            }
            i5 = -1;
        }
        return i5 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        e4.e.f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f1652b.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        Object[] objArr = this.f1652b;
        e4.e.f(objArr, "array");
        return new f1(objArr);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f1652b.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] objArr = this.f1652b;
        e4.e.f(objArr, "<this>");
        if (this.f1653c && e4.e.a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        e4.e.e(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        e4.e.f(objArr, "array");
        return p2.a.Z(this, objArr);
    }
}
