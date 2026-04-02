package com.bumptech.glide.f;

import com.bumptech.glide.load.c.l;
import java.io.File;
/* compiled from: FixedLoadProvider.java */
/* loaded from: classes.dex */
public class e<A, T, Z, R> implements f<A, T, Z, R> {

    /* renamed from: a  reason: collision with root package name */
    private final l<A, T> f676a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.resource.e.c<Z, R> f677b;

    /* renamed from: c  reason: collision with root package name */
    private final b<T, Z> f678c;

    public e(l<A, T> lVar, com.bumptech.glide.load.resource.e.c<Z, R> cVar, b<T, Z> bVar) {
        if (lVar == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.f676a = lVar;
        if (cVar == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.f677b = cVar;
        if (bVar == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.f678c = bVar;
    }

    @Override // com.bumptech.glide.f.f
    public l<A, T> e() {
        return this.f676a;
    }

    @Override // com.bumptech.glide.f.f
    public com.bumptech.glide.load.resource.e.c<Z, R> f() {
        return this.f677b;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<File, Z> a() {
        return this.f678c.a();
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<T, Z> b() {
        return this.f678c.b();
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.b<T> c() {
        return this.f678c.c();
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.f<Z> d() {
        return this.f678c.d();
    }
}
