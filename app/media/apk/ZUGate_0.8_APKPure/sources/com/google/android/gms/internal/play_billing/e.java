package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: d  reason: collision with root package name */
    public final transient int f1852d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f1853e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ f f1854f;

    public e(f fVar, int i5, int i6) {
        this.f1854f = fVar;
        this.f1852d = i5;
        this.f1853e = i6;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final int f() {
        return this.f1854f.g() + this.f1852d + this.f1853e;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final int g() {
        return this.f1854f.g() + this.f1852d;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        b4.j.q0(i5, this.f1853e);
        return this.f1854f.get(i5 + this.f1852d);
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final boolean i() {
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public final Object[] j() {
        return this.f1854f.j();
    }

    @Override // com.google.android.gms.internal.play_billing.f, java.util.List
    /* renamed from: k */
    public final f subList(int i5, int i6) {
        b4.j.v0(i5, i6, this.f1853e);
        int i7 = this.f1852d;
        return this.f1854f.subList(i5 + i7, i6 + i7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1853e;
    }
}
