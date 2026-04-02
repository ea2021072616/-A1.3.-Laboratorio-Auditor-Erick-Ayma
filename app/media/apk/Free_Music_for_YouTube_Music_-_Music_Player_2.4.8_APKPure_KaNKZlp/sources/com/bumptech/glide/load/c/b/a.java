package com.bumptech.glide.load.c.b;

import android.content.Context;
import com.bumptech.glide.load.c.k;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import java.io.InputStream;
/* compiled from: HttpUrlGlideUrlLoader.java */
/* loaded from: classes.dex */
public class a implements l<com.bumptech.glide.load.c.d, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final k<com.bumptech.glide.load.c.d, com.bumptech.glide.load.c.d> f864a;

    /* compiled from: HttpUrlGlideUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0030a implements m<com.bumptech.glide.load.c.d, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final k<com.bumptech.glide.load.c.d, com.bumptech.glide.load.c.d> f865a = new k<>(500);

        @Override // com.bumptech.glide.load.c.m
        public l<com.bumptech.glide.load.c.d, InputStream> a(Context context, com.bumptech.glide.load.c.c cVar) {
            return new a(this.f865a);
        }

        @Override // com.bumptech.glide.load.c.m
        public void a() {
        }
    }

    public a() {
        this(null);
    }

    public a(k<com.bumptech.glide.load.c.d, com.bumptech.glide.load.c.d> kVar) {
        this.f864a = kVar;
    }

    @Override // com.bumptech.glide.load.c.l
    public com.bumptech.glide.load.a.c<InputStream> a(com.bumptech.glide.load.c.d dVar, int i, int i2) {
        if (this.f864a != null) {
            com.bumptech.glide.load.c.d a2 = this.f864a.a(dVar, 0, 0);
            if (a2 == null) {
                this.f864a.a(dVar, 0, 0, dVar);
            } else {
                dVar = a2;
            }
        }
        return new com.bumptech.glide.load.a.f(dVar);
    }
}
