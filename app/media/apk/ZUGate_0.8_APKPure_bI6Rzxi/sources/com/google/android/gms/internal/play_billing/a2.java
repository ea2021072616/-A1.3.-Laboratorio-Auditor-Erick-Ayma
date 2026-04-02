package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class a2 extends AbstractList implements RandomAccess, x0 {

    /* renamed from: b  reason: collision with root package name */
    public final x0 f1836b;

    public a2(x0 x0Var) {
        this.f1836b = x0Var;
    }

    @Override // com.google.android.gms.internal.play_billing.x0
    public final x0 a() {
        return this;
    }

    @Override // com.google.android.gms.internal.play_billing.x0
    public final List c() {
        return this.f1836b.c();
    }

    @Override // com.google.android.gms.internal.play_billing.x0
    public final Object d(int i5) {
        return this.f1836b.d(i5);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i5) {
        return ((w0) this.f1836b).get(i5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new z1(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i5) {
        return new y1(this, i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1836b.size();
    }
}
