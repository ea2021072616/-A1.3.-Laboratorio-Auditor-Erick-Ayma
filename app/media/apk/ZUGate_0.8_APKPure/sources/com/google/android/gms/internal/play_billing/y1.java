package com.google.android.gms.internal.play_billing;

import java.util.ListIterator;
/* loaded from: classes.dex */
public final class y1 implements ListIterator {

    /* renamed from: b  reason: collision with root package name */
    public final ListIterator f1993b;

    public y1(a2 a2Var, int i5) {
        this.f1993b = a2Var.f1836b.listIterator(i5);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f1993b.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f1993b.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f1993b.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f1993b.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f1993b.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f1993b.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
