package com.bumptech.glide.load.resource.bitmap;
/* compiled from: GlideBitmapDrawableResource.java */
/* loaded from: classes.dex */
public class k extends com.bumptech.glide.load.resource.a.a<j> {

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.c f936b;

    public k(j jVar, com.bumptech.glide.load.b.a.c cVar) {
        super(jVar);
        this.f936b = cVar;
    }

    @Override // com.bumptech.glide.load.b.k
    public int c() {
        return com.bumptech.glide.i.h.a(((j) this.f903a).b());
    }

    @Override // com.bumptech.glide.load.b.k
    public void d() {
        this.f936b.a(((j) this.f903a).b());
    }
}
