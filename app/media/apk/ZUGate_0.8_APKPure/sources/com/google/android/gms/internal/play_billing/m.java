package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
/* loaded from: classes.dex */
public final class m extends i {

    /* renamed from: d  reason: collision with root package name */
    public final transient h f1922d;

    /* renamed from: e  reason: collision with root package name */
    public final transient f f1923e;

    public m(h hVar, n nVar) {
        this.f1922d = hVar;
        this.f1923e = nVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f1922d.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final int e(Object[] objArr) {
        return this.f1923e.e(objArr);
    }

    @Override // com.google.android.gms.internal.play_billing.i, com.google.android.gms.internal.play_billing.c
    public final f h() {
        return this.f1923e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.f1923e.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return ((o) this.f1922d).f1936g;
    }
}
