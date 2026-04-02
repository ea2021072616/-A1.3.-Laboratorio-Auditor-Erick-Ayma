package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private final b f773a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final e<C0025a, Bitmap> f774b = new e<>();

    @Override // com.bumptech.glide.load.b.a.g
    public void a(Bitmap bitmap) {
        this.f774b.a(this.f773a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.b.a.g
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f774b.a((e<C0025a, Bitmap>) this.f773a.a(i, i2, config));
    }

    @Override // com.bumptech.glide.load.b.a.g
    public Bitmap a() {
        return this.f774b.a();
    }

    @Override // com.bumptech.glide.load.b.a.g
    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.bumptech.glide.load.b.a.g
    public String b(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }

    @Override // com.bumptech.glide.load.b.a.g
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.i.h.a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f774b;
    }

    private static String d(Bitmap bitmap) {
        return d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    /* compiled from: AttributeStrategy.java */
    /* loaded from: classes.dex */
    static class b extends com.bumptech.glide.load.b.a.b<C0025a> {
        b() {
        }

        public C0025a a(int i, int i2, Bitmap.Config config) {
            C0025a c2 = c();
            c2.a(i, i2, config);
            return c2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.b.a.b
        /* renamed from: a */
        public C0025a b() {
            return new C0025a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AttributeStrategy.java */
    /* renamed from: com.bumptech.glide.load.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0025a implements h {

        /* renamed from: a  reason: collision with root package name */
        private final b f775a;

        /* renamed from: b  reason: collision with root package name */
        private int f776b;

        /* renamed from: c  reason: collision with root package name */
        private int f777c;
        private Bitmap.Config d;

        public C0025a(b bVar) {
            this.f775a = bVar;
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.f776b = i;
            this.f777c = i2;
            this.d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0025a) {
                C0025a c0025a = (C0025a) obj;
                return this.f776b == c0025a.f776b && this.f777c == c0025a.f777c && this.d == c0025a.d;
            }
            return false;
        }

        public int hashCode() {
            return (this.d != null ? this.d.hashCode() : 0) + (((this.f776b * 31) + this.f777c) * 31);
        }

        public String toString() {
            return a.d(this.f776b, this.f777c, this.d);
        }

        @Override // com.bumptech.glide.load.b.a.h
        public void a() {
            this.f775a.a(this);
        }
    }
}
