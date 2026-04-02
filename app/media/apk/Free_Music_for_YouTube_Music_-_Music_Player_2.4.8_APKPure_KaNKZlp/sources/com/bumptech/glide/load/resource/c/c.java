package com.bumptech.glide.load.resource.c;

import android.content.Context;
import com.bumptech.glide.load.c.o;
import java.io.File;
import java.io.InputStream;
/* compiled from: GifDrawableLoadProvider.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.f.b<InputStream, b> {

    /* renamed from: a  reason: collision with root package name */
    private final i f962a;

    /* renamed from: b  reason: collision with root package name */
    private final j f963b;

    /* renamed from: c  reason: collision with root package name */
    private final o f964c = new o();
    private final com.bumptech.glide.load.resource.b.c<b> d;

    public c(Context context, com.bumptech.glide.load.b.a.c cVar) {
        this.f962a = new i(context, cVar);
        this.d = new com.bumptech.glide.load.resource.b.c<>(this.f962a);
        this.f963b = new j(cVar);
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<File, b> a() {
        return this.d;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<InputStream, b> b() {
        return this.f962a;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.b<InputStream> c() {
        return this.f964c;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.f<b> d() {
        return this.f963b;
    }
}
