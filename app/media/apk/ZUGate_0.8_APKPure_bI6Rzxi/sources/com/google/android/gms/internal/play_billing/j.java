package com.google.android.gms.internal.play_billing;

import java.util.Objects;
/* loaded from: classes.dex */
public final class j extends f {

    /* renamed from: f  reason: collision with root package name */
    public static final j f1896f = new j(0, new Object[0]);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f1897d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f1898e;

    public j(int i5, Object[] objArr) {
        this.f1897d = objArr;
        this.f1898e = i5;
    }

    @Override // com.google.android.gms.internal.play_billing.f, com.google.android.gms.internal.play_billing.c
    public final int e(Object[] objArr) {
        Object[] objArr2 = this.f1897d;
        int i5 = this.f1898e;
        System.arraycopy(objArr2, 0, objArr, 0, i5);
        return i5;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final int f() {
        return this.f1898e;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final int g() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        b4.j.q0(i5, this.f1898e);
        Object obj = this.f1897d[i5];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final boolean i() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final Object[] j() {
        return this.f1897d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1898e;
    }
}
