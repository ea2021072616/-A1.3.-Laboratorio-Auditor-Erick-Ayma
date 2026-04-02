package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.b.k;
/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class c<T> implements k<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f954a;

    public c(T t) {
        if (t == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.f954a = t;
    }

    @Override // com.bumptech.glide.load.b.k
    public final T b() {
        return this.f954a;
    }

    @Override // com.bumptech.glide.load.b.k
    public final int c() {
        return 1;
    }

    @Override // com.bumptech.glide.load.b.k
    public void d() {
    }
}
