package com.bumptech.glide.load.c;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
/* compiled from: ImageVideoModelLoader.java */
/* loaded from: classes.dex */
public class f<A> implements l<A, g> {

    /* renamed from: a  reason: collision with root package name */
    private final l<A, InputStream> f875a;

    /* renamed from: b  reason: collision with root package name */
    private final l<A, ParcelFileDescriptor> f876b;

    public f(l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2) {
        if (lVar == null && lVar2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.f875a = lVar;
        this.f876b = lVar2;
    }

    @Override // com.bumptech.glide.load.c.l
    public com.bumptech.glide.load.a.c<g> a(A a2, int i, int i2) {
        com.bumptech.glide.load.a.c<InputStream> a3 = this.f875a != null ? this.f875a.a(a2, i, i2) : null;
        com.bumptech.glide.load.a.c<ParcelFileDescriptor> a4 = this.f876b != null ? this.f876b.a(a2, i, i2) : null;
        if (a3 == null && a4 == null) {
            return null;
        }
        return new a(a3, a4);
    }

    /* compiled from: ImageVideoModelLoader.java */
    /* loaded from: classes.dex */
    static class a implements com.bumptech.glide.load.a.c<g> {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.load.a.c<InputStream> f877a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.load.a.c<ParcelFileDescriptor> f878b;

        public a(com.bumptech.glide.load.a.c<InputStream> cVar, com.bumptech.glide.load.a.c<ParcelFileDescriptor> cVar2) {
            this.f877a = cVar;
            this.f878b = cVar2;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0013 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.bumptech.glide.load.a.c
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.bumptech.glide.load.c.g a(com.bumptech.glide.k r6) throws java.lang.Exception {
            /*
                r5 = this;
                r2 = 0
                r4 = 2
                com.bumptech.glide.load.a.c<java.io.InputStream> r0 = r5.f877a
                if (r0 == 0) goto L4a
                com.bumptech.glide.load.a.c<java.io.InputStream> r0 = r5.f877a     // Catch: java.lang.Exception -> L22
                java.lang.Object r0 = r0.a(r6)     // Catch: java.lang.Exception -> L22
                java.io.InputStream r0 = (java.io.InputStream) r0     // Catch: java.lang.Exception -> L22
                r1 = r0
            Lf:
                com.bumptech.glide.load.a.c<android.os.ParcelFileDescriptor> r0 = r5.f878b
                if (r0 == 0) goto L1c
                com.bumptech.glide.load.a.c<android.os.ParcelFileDescriptor> r0 = r5.f878b     // Catch: java.lang.Exception -> L37
                java.lang.Object r0 = r0.a(r6)     // Catch: java.lang.Exception -> L37
                android.os.ParcelFileDescriptor r0 = (android.os.ParcelFileDescriptor) r0     // Catch: java.lang.Exception -> L37
                r2 = r0
            L1c:
                com.bumptech.glide.load.c.g r0 = new com.bumptech.glide.load.c.g
                r0.<init>(r1, r2)
                return r0
            L22:
                r0 = move-exception
                java.lang.String r1 = "IVML"
                boolean r1 = android.util.Log.isLoggable(r1, r4)
                if (r1 == 0) goto L32
                java.lang.String r1 = "IVML"
                java.lang.String r3 = "Exception fetching input stream, trying ParcelFileDescriptor"
                android.util.Log.v(r1, r3, r0)
            L32:
                com.bumptech.glide.load.a.c<android.os.ParcelFileDescriptor> r1 = r5.f878b
                if (r1 != 0) goto L4a
                throw r0
            L37:
                r0 = move-exception
                java.lang.String r3 = "IVML"
                boolean r3 = android.util.Log.isLoggable(r3, r4)
                if (r3 == 0) goto L47
                java.lang.String r3 = "IVML"
                java.lang.String r4 = "Exception fetching ParcelFileDescriptor"
                android.util.Log.v(r3, r4, r0)
            L47:
                if (r1 != 0) goto L1c
                throw r0
            L4a:
                r1 = r2
                goto Lf
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.c.f.a.a(com.bumptech.glide.k):com.bumptech.glide.load.c.g");
        }

        @Override // com.bumptech.glide.load.a.c
        public void a() {
            if (this.f877a != null) {
                this.f877a.a();
            }
            if (this.f878b != null) {
                this.f878b.a();
            }
        }

        @Override // com.bumptech.glide.load.a.c
        public String b() {
            return this.f877a != null ? this.f877a.b() : this.f878b.b();
        }

        @Override // com.bumptech.glide.load.a.c
        public void c() {
            if (this.f877a != null) {
                this.f877a.c();
            }
            if (this.f878b != null) {
                this.f878b.c();
            }
        }
    }
}
