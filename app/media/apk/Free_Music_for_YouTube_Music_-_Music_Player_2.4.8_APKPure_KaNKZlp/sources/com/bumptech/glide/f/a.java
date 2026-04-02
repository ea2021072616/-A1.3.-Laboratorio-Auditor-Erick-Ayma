package com.bumptech.glide.f;

import com.bumptech.glide.load.c.l;
import java.io.File;
/* compiled from: ChildLoadProvider.java */
/* loaded from: classes.dex */
public class a<A, T, Z, R> implements f<A, T, Z, R>, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final f<A, T, Z, R> f670a;

    /* renamed from: b  reason: collision with root package name */
    private com.bumptech.glide.load.e<File, Z> f671b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.load.e<T, Z> f672c;
    private com.bumptech.glide.load.f<Z> d;
    private com.bumptech.glide.load.resource.e.c<Z, R> e;
    private com.bumptech.glide.load.b<T> f;

    public a(f<A, T, Z, R> fVar) {
        this.f670a = fVar;
    }

    @Override // com.bumptech.glide.f.f
    public l<A, T> e() {
        return this.f670a.e();
    }

    public void a(com.bumptech.glide.load.e<T, Z> eVar) {
        this.f672c = eVar;
    }

    public void a(com.bumptech.glide.load.b<T> bVar) {
        this.f = bVar;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<File, Z> a() {
        return this.f671b != null ? this.f671b : this.f670a.a();
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<T, Z> b() {
        return this.f672c != null ? this.f672c : this.f670a.b();
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.b<T> c() {
        return this.f != null ? this.f : this.f670a.c();
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.f<Z> d() {
        return this.d != null ? this.d : this.f670a.d();
    }

    @Override // com.bumptech.glide.f.f
    public com.bumptech.glide.load.resource.e.c<Z, R> f() {
        return this.e != null ? this.e : this.f670a.f();
    }

    /* renamed from: g */
    public a<A, T, Z, R> clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
