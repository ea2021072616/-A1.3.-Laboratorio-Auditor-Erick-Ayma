package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class b extends p {

    /* renamed from: b  reason: collision with root package name */
    public final int f1838b;

    /* renamed from: c  reason: collision with root package name */
    public int f1839c;

    public b(int i5, int i6) {
        b4.j.s0(i6, i5);
        this.f1838b = i5;
        this.f1839c = i6;
    }

    public abstract Object b(int i5);

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f1839c < this.f1838b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f1839c > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            int i5 = this.f1839c;
            this.f1839c = i5 + 1;
            return b(i5);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f1839c;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i5 = this.f1839c - 1;
            this.f1839c = i5;
            return b(i5);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f1839c - 1;
    }
}
