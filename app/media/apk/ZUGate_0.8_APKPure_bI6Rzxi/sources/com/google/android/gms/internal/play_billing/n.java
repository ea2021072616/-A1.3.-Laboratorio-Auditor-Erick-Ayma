package com.google.android.gms.internal.play_billing;

import java.util.Objects;
/* loaded from: classes.dex */
public final class n extends f {

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f1930d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f1931e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f1932f;

    public n(int i5, int i6, Object[] objArr) {
        this.f1930d = objArr;
        this.f1931e = i5;
        this.f1932f = i6;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        b4.j.q0(i5, this.f1932f);
        Object obj = this.f1930d[i5 + i5 + this.f1931e];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final boolean i() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1932f;
    }
}
