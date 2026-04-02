package com.bumptech.glide.load.resource.c;

import com.bumptech.glide.k;
import com.bumptech.glide.load.c.l;
/* compiled from: GifFrameModelLoader.java */
/* loaded from: classes.dex */
class g implements l<com.bumptech.glide.b.a, com.bumptech.glide.b.a> {
    @Override // com.bumptech.glide.load.c.l
    public com.bumptech.glide.load.a.c<com.bumptech.glide.b.a> a(com.bumptech.glide.b.a aVar, int i, int i2) {
        return new a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GifFrameModelLoader.java */
    /* loaded from: classes.dex */
    public static class a implements com.bumptech.glide.load.a.c<com.bumptech.glide.b.a> {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.b.a f975a;

        public a(com.bumptech.glide.b.a aVar) {
            this.f975a = aVar;
        }

        @Override // com.bumptech.glide.load.a.c
        /* renamed from: b */
        public com.bumptech.glide.b.a a(k kVar) {
            return this.f975a;
        }

        @Override // com.bumptech.glide.load.a.c
        public void a() {
        }

        @Override // com.bumptech.glide.load.a.c
        public String b() {
            return String.valueOf(this.f975a.d());
        }

        @Override // com.bumptech.glide.load.a.c
        public void c() {
        }
    }
}
