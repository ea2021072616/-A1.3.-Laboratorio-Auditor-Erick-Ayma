package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap;
import java.util.Objects;
/* loaded from: classes.dex */
public final class k extends f {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ l f1901d;

    public k(l lVar) {
        this.f1901d = lVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i5) {
        l lVar = this.f1901d;
        b4.j.q0(i5, lVar.f1908f);
        int i6 = i5 + i5;
        Object[] objArr = lVar.f1907e;
        Object obj = objArr[i6];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i6 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final boolean i() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1901d.f1908f;
    }
}
