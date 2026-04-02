package b4;

import java.util.AbstractList;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class a extends AbstractList implements List {
    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i5) {
        c cVar = (c) this;
        z0.d.a(i5, cVar.f1657d);
        if (i5 == e4.e.r(cVar)) {
            if (cVar.isEmpty()) {
                throw new NoSuchElementException("ArrayDeque is empty.");
            }
            int i6 = cVar.i(e4.e.r(cVar) + cVar.f1655b);
            Object[] objArr = cVar.f1656c;
            Object obj = objArr[i6];
            objArr[i6] = null;
            cVar.f1657d--;
            return obj;
        } else if (i5 == 0) {
            if (cVar.isEmpty()) {
                throw new NoSuchElementException("ArrayDeque is empty.");
            }
            Object[] objArr2 = cVar.f1656c;
            int i7 = cVar.f1655b;
            Object obj2 = objArr2[i7];
            objArr2[i7] = null;
            cVar.f1655b = cVar.h(i7);
            cVar.f1657d--;
            return obj2;
        } else {
            int i8 = cVar.i(cVar.f1655b + i5);
            Object[] objArr3 = cVar.f1656c;
            Object obj3 = objArr3[i8];
            if (i5 < (cVar.f1657d >> 1)) {
                int i9 = cVar.f1655b;
                if (i8 >= i9) {
                    d.k0(objArr3, objArr3, i9 + 1, i9, i8);
                } else {
                    d.k0(objArr3, objArr3, 1, 0, i8);
                    Object[] objArr4 = cVar.f1656c;
                    objArr4[0] = objArr4[objArr4.length - 1];
                    int i10 = cVar.f1655b;
                    d.k0(objArr4, objArr4, i10 + 1, i10, objArr4.length - 1);
                }
                Object[] objArr5 = cVar.f1656c;
                int i11 = cVar.f1655b;
                objArr5[i11] = null;
                cVar.f1655b = cVar.h(i11);
            } else {
                int i12 = cVar.i(e4.e.r(cVar) + cVar.f1655b);
                if (i8 <= i12) {
                    Object[] objArr6 = cVar.f1656c;
                    d.k0(objArr6, objArr6, i8, i8 + 1, i12 + 1);
                } else {
                    Object[] objArr7 = cVar.f1656c;
                    d.k0(objArr7, objArr7, i8, i8 + 1, objArr7.length);
                    Object[] objArr8 = cVar.f1656c;
                    objArr8[objArr8.length - 1] = objArr8[0];
                    d.k0(objArr8, objArr8, 0, 1, i12 + 1);
                }
                cVar.f1656c[i12] = null;
            }
            cVar.f1657d--;
            return obj3;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return ((c) this).f1657d;
    }
}
