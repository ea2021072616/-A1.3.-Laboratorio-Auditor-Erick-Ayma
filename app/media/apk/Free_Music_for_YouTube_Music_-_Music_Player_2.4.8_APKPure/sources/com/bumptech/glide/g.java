package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.io.InputStream;
/* compiled from: GifRequestBuilder.java */
/* loaded from: classes.dex */
public class g<ModelType> extends e<ModelType, InputStream, com.bumptech.glide.load.resource.c.b, com.bumptech.glide.load.resource.c.b> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public /* synthetic */ e b(Object obj) {
        return a((g<ModelType>) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.bumptech.glide.f.f<ModelType, InputStream, com.bumptech.glide.load.resource.c.b, com.bumptech.glide.load.resource.c.b> fVar, Class<com.bumptech.glide.load.resource.c.b> cls, e<ModelType, ?, ?, ?> eVar) {
        super(fVar, cls, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public g<ModelType> b(com.bumptech.glide.load.e<InputStream, com.bumptech.glide.load.resource.c.b> eVar) {
        super.b((com.bumptech.glide.load.e) eVar);
        return this;
    }

    public g<ModelType> a() {
        return a(this.f667c.c());
    }

    public g<ModelType> b() {
        return a(this.f667c.d());
    }

    public g<ModelType> a(com.bumptech.glide.load.resource.bitmap.d... dVarArr) {
        return b((com.bumptech.glide.load.g<com.bumptech.glide.load.resource.c.b>[]) c(dVarArr));
    }

    private com.bumptech.glide.load.resource.c.e[] c(com.bumptech.glide.load.g<Bitmap>[] gVarArr) {
        com.bumptech.glide.load.resource.c.e[] eVarArr = new com.bumptech.glide.load.resource.c.e[gVarArr.length];
        for (int i = 0; i < gVarArr.length; i++) {
            eVarArr[i] = new com.bumptech.glide.load.resource.c.e(gVarArr[i], this.f667c.a());
        }
        return eVarArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public g<ModelType> b(com.bumptech.glide.load.g<com.bumptech.glide.load.resource.c.b>... gVarArr) {
        super.b((com.bumptech.glide.load.g[]) gVarArr);
        return this;
    }

    public g<ModelType> c() {
        super.a((com.bumptech.glide.g.a.d) new com.bumptech.glide.g.a.a());
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: d */
    public g<ModelType> i() {
        super.i();
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public g<ModelType> d(int i) {
        super.d(i);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public g<ModelType> b(Drawable drawable) {
        super.b(drawable);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: b */
    public g<ModelType> c(int i) {
        super.c(i);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public g<ModelType> b(boolean z) {
        super.b(z);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public g<ModelType> b(com.bumptech.glide.load.b.b bVar) {
        super.b(bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public g<ModelType> b(int i, int i2) {
        super.b(i, i2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public g<ModelType> b(com.bumptech.glide.load.b<InputStream> bVar) {
        super.b((com.bumptech.glide.load.b) bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: e */
    public g<ModelType> j() {
        super.j();
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public g<ModelType> b(com.bumptech.glide.load.c cVar) {
        super.b(cVar);
        return this;
    }

    public g<ModelType> a(ModelType modeltype) {
        super.b((g<ModelType>) modeltype);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: k */
    public g<ModelType> h() {
        return (g) super.clone();
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
