package com.bumptech.glide.load.resource.b;

import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.InputStream;
/* compiled from: StreamFileDataLoadProvider.java */
/* loaded from: classes.dex */
public class d implements com.bumptech.glide.f.b<InputStream, File> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f908a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final e<File, File> f909b = new com.bumptech.glide.load.resource.b.a();

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.b<InputStream> f910c = new o();

    @Override // com.bumptech.glide.f.b
    public e<File, File> a() {
        return this.f909b;
    }

    @Override // com.bumptech.glide.f.b
    public e<InputStream, File> b() {
        return f908a;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.b<InputStream> c() {
        return this.f910c;
    }

    @Override // com.bumptech.glide.f.b
    public f<File> d() {
        return com.bumptech.glide.load.resource.b.b();
    }

    /* compiled from: StreamFileDataLoadProvider.java */
    /* loaded from: classes.dex */
    private static class a implements e<InputStream, File> {
        private a() {
        }

        @Override // com.bumptech.glide.load.e
        public k<File> a(InputStream inputStream, int i, int i2) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }

        @Override // com.bumptech.glide.load.e
        public String a() {
            return "";
        }
    }
}
