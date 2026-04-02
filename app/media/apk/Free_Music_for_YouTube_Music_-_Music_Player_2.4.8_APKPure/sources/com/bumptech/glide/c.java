package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.d.m;
/* compiled from: DrawableRequestBuilder.java */
/* loaded from: classes.dex */
public class c<ModelType> extends e<ModelType, com.bumptech.glide.load.c.g, com.bumptech.glide.load.resource.d.a, com.bumptech.glide.load.resource.a.b> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public /* synthetic */ e b(Object obj) {
        return a((c<ModelType>) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, Class<ModelType> cls, com.bumptech.glide.f.f<ModelType, com.bumptech.glide.load.c.g, com.bumptech.glide.load.resource.d.a, com.bumptech.glide.load.resource.a.b> fVar, i iVar, m mVar, com.bumptech.glide.d.g gVar) {
        super(context, cls, fVar, com.bumptech.glide.load.resource.a.b.class, iVar, mVar, gVar);
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public c<ModelType> b(com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, com.bumptech.glide.load.resource.d.a> eVar) {
        super.b((com.bumptech.glide.load.e) eVar);
        return this;
    }

    public c<ModelType> a(com.bumptech.glide.load.resource.bitmap.d... dVarArr) {
        return a((com.bumptech.glide.load.g<Bitmap>[]) dVarArr);
    }

    public c<ModelType> a() {
        return b(this.f667c.e());
    }

    public c<ModelType> b() {
        return b(this.f667c.f());
    }

    public c<ModelType> a(com.bumptech.glide.load.g<Bitmap>... gVarArr) {
        com.bumptech.glide.load.resource.d.f[] fVarArr = new com.bumptech.glide.load.resource.d.f[gVarArr.length];
        for (int i = 0; i < gVarArr.length; i++) {
            fVarArr[i] = new com.bumptech.glide.load.resource.d.f(this.f667c.a(), gVarArr[i]);
        }
        return b(fVarArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: c */
    public c<ModelType> b(com.bumptech.glide.load.g<com.bumptech.glide.load.resource.d.a>... gVarArr) {
        super.b((com.bumptech.glide.load.g[]) gVarArr);
        return this;
    }

    public final c<ModelType> c() {
        super.a((com.bumptech.glide.g.a.d) new com.bumptech.glide.g.a.a());
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: d */
    public c<ModelType> i() {
        super.i();
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public c<ModelType> d(int i) {
        super.d(i);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public c<ModelType> b(Drawable drawable) {
        super.b(drawable);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: b */
    public c<ModelType> c(int i) {
        super.c(i);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public c<ModelType> b(com.bumptech.glide.load.b.b bVar) {
        super.b(bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public c<ModelType> b(boolean z) {
        super.b(z);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public c<ModelType> b(int i, int i2) {
        super.b(i, i2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public c<ModelType> b(com.bumptech.glide.load.b<com.bumptech.glide.load.c.g> bVar) {
        super.b((com.bumptech.glide.load.b) bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: e */
    public c<ModelType> j() {
        super.j();
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public c<ModelType> b(com.bumptech.glide.load.c cVar) {
        super.b(cVar);
        return this;
    }

    public c<ModelType> a(ModelType modeltype) {
        super.b((c<ModelType>) modeltype);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: k */
    public c<ModelType> h() {
        return (c) super.clone();
    }

    @Override // com.bumptech.glide.e
    public com.bumptech.glide.g.b.j<com.bumptech.glide.load.resource.a.b> a(ImageView imageView) {
        return super.a(imageView);
    }

    @Override // com.bumptech.glide.e
    void f() {
        b();
    }

    @Override // com.bumptech.glide.e
    void g() {
        a();
    }
}
