package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public final class l extends i {

    /* renamed from: d  reason: collision with root package name */
    public final transient h f1906d;

    /* renamed from: e  reason: collision with root package name */
    public final transient Object[] f1907e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f1908f;

    public l(h hVar, Object[] objArr, int i5) {
        this.f1906d = hVar;
        this.f1907e = objArr;
        this.f1908f = i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f1906d.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final int e(Object[] objArr) {
        return h().e(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return h().listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.i
    public final f k() {
        return new k(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f1908f;
    }
}
