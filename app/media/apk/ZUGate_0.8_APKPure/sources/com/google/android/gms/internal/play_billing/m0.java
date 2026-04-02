package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class m0 extends t implements RandomAccess, p0, p1 {

    /* renamed from: e  reason: collision with root package name */
    public static final m0 f1924e = new m0(new int[0], 0, false);

    /* renamed from: c  reason: collision with root package name */
    public int[] f1925c;

    /* renamed from: d  reason: collision with root package name */
    public int f1926d;

    public m0(int[] iArr, int i5, boolean z4) {
        super(z4);
        this.f1925c = iArr;
        this.f1926d = i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        int i6;
        int intValue = ((Integer) obj).intValue();
        e();
        if (i5 >= 0 && i5 <= (i6 = this.f1926d)) {
            int i7 = i5 + 1;
            int[] iArr = this.f1925c;
            if (i6 < iArr.length) {
                System.arraycopy(iArr, i5, iArr, i7, i6 - i5);
            } else {
                int[] iArr2 = new int[((i6 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i5);
                System.arraycopy(this.f1925c, i5, iArr2, i7, this.f1926d - i5);
                this.f1925c = iArr2;
            }
            this.f1925c[i5] = intValue;
            this.f1926d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index:" + i5 + ", Size:" + this.f1926d);
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        e();
        Charset charset = s0.f1953a;
        collection.getClass();
        if (collection instanceof m0) {
            m0 m0Var = (m0) collection;
            int i5 = m0Var.f1926d;
            if (i5 == 0) {
                return false;
            }
            int i6 = this.f1926d;
            if (Integer.MAX_VALUE - i6 >= i5) {
                int i7 = i6 + i5;
                int[] iArr = this.f1925c;
                if (i7 > iArr.length) {
                    this.f1925c = Arrays.copyOf(iArr, i7);
                }
                System.arraycopy(m0Var.f1925c, 0, this.f1925c, this.f1926d, m0Var.f1926d);
                this.f1926d = i7;
                ((AbstractList) this).modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        return super.addAll(collection);
    }

    @Override // com.google.android.gms.internal.play_billing.r0
    public final /* bridge */ /* synthetic */ r0 b(int i5) {
        if (i5 >= this.f1926d) {
            return new m0(Arrays.copyOf(this.f1925c, i5), this.f1926d, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m0) {
            m0 m0Var = (m0) obj;
            if (this.f1926d != m0Var.f1926d) {
                return false;
            }
            int[] iArr = m0Var.f1925c;
            for (int i5 = 0; i5 < this.f1926d; i5++) {
                if (this.f1925c[i5] != iArr[i5]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    public final int g(int i5) {
        i(i5);
        return this.f1925c[i5];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        i(i5);
        return Integer.valueOf(this.f1925c[i5]);
    }

    public final void h(int i5) {
        e();
        int i6 = this.f1926d;
        int[] iArr = this.f1925c;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[((i6 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.f1925c = iArr2;
        }
        int[] iArr3 = this.f1925c;
        int i7 = this.f1926d;
        this.f1926d = i7 + 1;
        iArr3[i7] = i5;
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f1926d; i6++) {
            i5 = (i5 * 31) + this.f1925c[i6];
        }
        return i5;
    }

    public final void i(int i5) {
        if (i5 < 0 || i5 >= this.f1926d) {
            int i6 = this.f1926d;
            throw new IndexOutOfBoundsException("Index:" + i5 + ", Size:" + i6);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int i5 = this.f1926d;
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.f1925c[i6] == intValue) {
                    return i6;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i5) {
        int i6;
        e();
        i(i5);
        int[] iArr = this.f1925c;
        int i7 = iArr[i5];
        if (i5 < this.f1926d - 1) {
            System.arraycopy(iArr, i5 + 1, iArr, i5, (i6 - i5) - 1);
        }
        this.f1926d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i7);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i5, int i6) {
        e();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f1925c;
        System.arraycopy(iArr, i6, iArr, i5, this.f1926d - i6);
        this.f1926d -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        int intValue = ((Integer) obj).intValue();
        e();
        i(i5);
        int[] iArr = this.f1925c;
        int i6 = iArr[i5];
        iArr[i5] = intValue;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1926d;
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        h(((Integer) obj).intValue());
        return true;
    }
}
