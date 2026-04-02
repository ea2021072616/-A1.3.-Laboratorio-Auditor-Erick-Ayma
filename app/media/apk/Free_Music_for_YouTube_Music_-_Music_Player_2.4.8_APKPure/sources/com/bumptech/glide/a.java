package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.p;
import java.io.InputStream;
/* compiled from: BitmapRequestBuilder.java */
/* loaded from: classes.dex */
public class a<ModelType, TranscodeType> extends e<ModelType, com.bumptech.glide.load.c.g, Bitmap, TranscodeType> {
    private final com.bumptech.glide.load.b.a.c g;
    private com.bumptech.glide.load.resource.bitmap.f h;
    private com.bumptech.glide.load.a i;
    private com.bumptech.glide.load.e<InputStream, Bitmap> j;
    private com.bumptech.glide.load.e<ParcelFileDescriptor, Bitmap> k;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    public /* synthetic */ e b(Object obj) {
        return a((a<ModelType, TranscodeType>) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.bumptech.glide.f.f<ModelType, com.bumptech.glide.load.c.g, Bitmap, TranscodeType> fVar, Class<TranscodeType> cls, e<ModelType, ?, ?, ?> eVar) {
        super(fVar, cls, eVar);
        this.h = com.bumptech.glide.load.resource.bitmap.f.f921a;
        this.g = eVar.f667c.a();
        this.i = eVar.f667c.g();
        this.j = new p(this.g, this.i);
        this.k = new com.bumptech.glide.load.resource.bitmap.h(this.g, this.i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public a<ModelType, TranscodeType> b(com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, Bitmap> eVar) {
        super.b((com.bumptech.glide.load.e) eVar);
        return this;
    }

    public a<ModelType, TranscodeType> a(com.bumptech.glide.load.resource.bitmap.d... dVarArr) {
        super.b((com.bumptech.glide.load.g[]) dVarArr);
        return this;
    }

    public a<ModelType, TranscodeType> a() {
        return a(this.f667c.c());
    }

    public a<ModelType, TranscodeType> b() {
        return a(this.f667c.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public a<ModelType, TranscodeType> b(com.bumptech.glide.load.g<Bitmap>... gVarArr) {
        super.b((com.bumptech.glide.load.g[]) gVarArr);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: c */
    public a<ModelType, TranscodeType> i() {
        super.i();
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public a<ModelType, TranscodeType> d(int i) {
        super.d(i);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public a<ModelType, TranscodeType> b(Drawable drawable) {
        super.b(drawable);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: b */
    public a<ModelType, TranscodeType> c(int i) {
        super.c(i);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public a<ModelType, TranscodeType> b(boolean z) {
        super.b(z);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public a<ModelType, TranscodeType> b(com.bumptech.glide.load.b.b bVar) {
        super.b(bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public a<ModelType, TranscodeType> b(int i, int i2) {
        super.b(i, i2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public a<ModelType, TranscodeType> b(com.bumptech.glide.load.b<com.bumptech.glide.load.c.g> bVar) {
        super.b((com.bumptech.glide.load.b) bVar);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: d */
    public a<ModelType, TranscodeType> j() {
        super.j();
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: a */
    public a<ModelType, TranscodeType> b(com.bumptech.glide.load.c cVar) {
        super.b(cVar);
        return this;
    }

    public a<ModelType, TranscodeType> a(ModelType modeltype) {
        super.b((a<ModelType, TranscodeType>) modeltype);
        return this;
    }

    @Override // com.bumptech.glide.e
    /* renamed from: e */
    public a<ModelType, TranscodeType> h() {
        return (a) super.clone();
    }

    @Override // com.bumptech.glide.e
    public com.bumptech.glide.g.b.j<TranscodeType> a(ImageView imageView) {
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
