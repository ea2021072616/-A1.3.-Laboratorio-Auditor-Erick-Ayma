package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class r1 extends t implements RandomAccess {

    /* renamed from: e  reason: collision with root package name */
    public static final r1 f1943e = new r1(new Object[0], 0, false);

    /* renamed from: c  reason: collision with root package name */
    public Object[] f1944c;

    /* renamed from: d  reason: collision with root package name */
    public int f1945d;

    public r1(Object[] objArr, int i5, boolean z4) {
        super(z4);
        this.f1944c = objArr;
        this.f1945d = i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        int i6;
        e();
        if (i5 >= 0 && i5 <= (i6 = this.f1945d)) {
            int i7 = i5 + 1;
            Object[] objArr = this.f1944c;
            if (i6 < objArr.length) {
                System.arraycopy(objArr, i5, objArr, i7, i6 - i5);
            } else {
                Object[] objArr2 = new Object[((i6 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i5);
                System.arraycopy(this.f1944c, i5, objArr2, i7, this.f1945d - i5);
                this.f1944c = objArr2;
            }
            this.f1944c[i5] = obj;
            this.f1945d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index:" + i5 + ", Size:" + this.f1945d);
    }

    @Override // com.google.android.gms.internal.play_billing.r0
    public final /* bridge */ /* synthetic */ r0 b(int i5) {
        if (i5 >= this.f1945d) {
            return new r1(Arrays.copyOf(this.f1944c, i5), this.f1945d, true);
        }
        throw new IllegalArgumentException();
    }

    public final void g(int i5) {
        if (i5 < 0 || i5 >= this.f1945d) {
            int i6 = this.f1945d;
            throw new IndexOutOfBoundsException("Index:" + i5 + ", Size:" + i6);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i5) {
        g(i5);
        return this.f1944c[i5];
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractList, java.util.List
    public final Object remove(int i5) {
        int i6;
        e();
        g(i5);
        Object[] objArr = this.f1944c;
        Object obj = objArr[i5];
        if (i5 < this.f1945d - 1) {
            System.arraycopy(objArr, i5 + 1, objArr, i5, (i6 - i5) - 1);
        }
        this.f1945d--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        e();
        g(i5);
        Object[] objArr = this.f1944c;
        Object obj2 = objArr[i5];
        objArr[i5] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1945d;
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        e();
        int i5 = this.f1945d;
        Object[] objArr = this.f1944c;
        if (i5 == objArr.length) {
            this.f1944c = Arrays.copyOf(objArr, ((i5 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f1944c;
        int i6 = this.f1945d;
        this.f1945d = i6 + 1;
        objArr2[i6] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
