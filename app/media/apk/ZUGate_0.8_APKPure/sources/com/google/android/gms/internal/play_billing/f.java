package com.google.android.gms.internal.play_billing;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public abstract class f extends c implements List, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public static final d f1859c = new d(j.f1896f, 0);

    public static f l(List list) {
        if (list instanceof c) {
            f h5 = ((c) list).h();
            if (h5.i()) {
                Object[] array = h5.toArray();
                int length = array.length;
                return length == 0 ? j.f1896f : new j(length, array);
            }
            return h5;
        }
        Object[] array2 = list.toArray();
        int length2 = array2.length;
        for (int i5 = 0; i5 < length2; i5++) {
            if (array2[i5] == null) {
                throw new NullPointerException(androidx.appcompat.widget.b0.f("at index ", i5));
            }
        }
        int length3 = array2.length;
        return length3 == 0 ? j.f1896f : new j(length3, array2);
    }

    @Override // java.util.List
    public final void add(int i5, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i5, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public int e(Object[] objArr) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            objArr[i5] = get(i5);
        }
        return size;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        boolean z4;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i5 = 0; i5 < size; i5++) {
                        Object obj2 = get(i5);
                        Object obj3 = list.get(i5);
                        if (obj2 == obj3 || (obj2 != null && obj2.equals(obj3))) {
                        }
                    }
                    return true;
                }
                d listIterator = listIterator(0);
                Iterator it = list.iterator();
                while (true) {
                    if (listIterator.hasNext()) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = listIterator.next();
                        Object next2 = it.next();
                        if (next == next2 || (next != null && next.equals(next2))) {
                            z4 = true;
                            continue;
                        } else {
                            z4 = false;
                            continue;
                        }
                        if (!z4) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final f h() {
        return this;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = (i5 * 31) + get(i6).hashCode();
        }
        return i5;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (obj.equals(get(i5))) {
                return i5;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: k */
    public f subList(int i5, int i6) {
        b4.j.v0(i5, i6, size());
        int i7 = i6 - i5;
        return i7 == size() ? this : i7 == 0 ? j.f1896f : new e(this, i5, i7);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: m */
    public final d listIterator(int i5) {
        b4.j.s0(i5, size());
        return isEmpty() ? f1859c : new d(this, i5);
    }

    @Override // java.util.List
    public final Object remove(int i5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i5, Object obj) {
        throw new UnsupportedOperationException();
    }
}
