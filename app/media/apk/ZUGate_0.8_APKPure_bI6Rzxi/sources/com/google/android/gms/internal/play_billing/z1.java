package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
/* loaded from: classes.dex */
public final class z1 implements Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final Iterator f1996b;

    public z1(a2 a2Var) {
        this.f1996b = a2Var.f1836b.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1996b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f1996b.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
