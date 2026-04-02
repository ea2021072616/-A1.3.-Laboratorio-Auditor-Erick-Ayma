package com.bumptech.glide.load.b;

import android.util.Log;
import com.bumptech.glide.load.b.b.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
public class a<A, T, Z> {

    /* renamed from: a  reason: collision with root package name */
    private static final b f770a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final f f771b;

    /* renamed from: c  reason: collision with root package name */
    private final int f772c;
    private final int d;
    private final com.bumptech.glide.load.a.c<A> e;
    private final com.bumptech.glide.f.b<A, T> f;
    private final com.bumptech.glide.load.g<T> g;
    private final com.bumptech.glide.load.resource.e.c<T, Z> h;
    private final InterfaceC0024a i;
    private final com.bumptech.glide.load.b.b j;
    private final com.bumptech.glide.k k;
    private final b l;
    private volatile boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0024a {
        com.bumptech.glide.load.b.b.a a();
    }

    public a(f fVar, int i, int i2, com.bumptech.glide.load.a.c<A> cVar, com.bumptech.glide.f.b<A, T> bVar, com.bumptech.glide.load.g<T> gVar, com.bumptech.glide.load.resource.e.c<T, Z> cVar2, InterfaceC0024a interfaceC0024a, com.bumptech.glide.load.b.b bVar2, com.bumptech.glide.k kVar) {
        this(fVar, i, i2, cVar, bVar, gVar, cVar2, interfaceC0024a, bVar2, kVar, f770a);
    }

    a(f fVar, int i, int i2, com.bumptech.glide.load.a.c<A> cVar, com.bumptech.glide.f.b<A, T> bVar, com.bumptech.glide.load.g<T> gVar, com.bumptech.glide.load.resource.e.c<T, Z> cVar2, InterfaceC0024a interfaceC0024a, com.bumptech.glide.load.b.b bVar2, com.bumptech.glide.k kVar, b bVar3) {
        this.f771b = fVar;
        this.f772c = i;
        this.d = i2;
        this.e = cVar;
        this.f = bVar;
        this.g = gVar;
        this.h = cVar2;
        this.i = interfaceC0024a;
        this.j = bVar2;
        this.k = kVar;
        this.l = bVar3;
    }

    public k<Z> a() throws Exception {
        if (!this.j.b()) {
            return null;
        }
        long a2 = com.bumptech.glide.i.d.a();
        k<T> a3 = a((com.bumptech.glide.load.c) this.f771b);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded transformed from cache", a2);
        }
        long a4 = com.bumptech.glide.i.d.a();
        k<Z> d = d(a3);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transcoded transformed from cache", a4);
            return d;
        }
        return d;
    }

    public k<Z> b() throws Exception {
        if (!this.j.a()) {
            return null;
        }
        long a2 = com.bumptech.glide.i.d.a();
        k<T> a3 = a(this.f771b.a());
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded source from cache", a2);
        }
        return a((k) a3);
    }

    public k<Z> c() throws Exception {
        return a((k) e());
    }

    public void d() {
        this.m = true;
        this.e.c();
    }

    private k<Z> a(k<T> kVar) {
        long a2 = com.bumptech.glide.i.d.a();
        k<T> c2 = c(kVar);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transformed resource from source", a2);
        }
        b((k) c2);
        long a3 = com.bumptech.glide.i.d.a();
        k<Z> d = d(c2);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transcoded transformed from source", a3);
        }
        return d;
    }

    private void b(k<T> kVar) {
        if (kVar != null && this.j.b()) {
            long a2 = com.bumptech.glide.i.d.a();
            this.i.a().a(this.f771b, new c(this.f.d(), kVar));
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Wrote transformed from source to cache", a2);
            }
        }
    }

    private k<T> e() throws Exception {
        try {
            long a2 = com.bumptech.glide.i.d.a();
            A a3 = this.e.a(this.k);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Fetched data", a2);
            }
            if (!this.m) {
                return a((a<A, T, Z>) a3);
            }
            return null;
        } finally {
            this.e.a();
        }
    }

    private k<T> a(A a2) throws IOException {
        if (this.j.a()) {
            return b((a<A, T, Z>) a2);
        }
        long a3 = com.bumptech.glide.i.d.a();
        k<T> a4 = this.f.b().a(a2, this.f772c, this.d);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded from source", a3);
            return a4;
        }
        return a4;
    }

    private k<T> b(A a2) throws IOException {
        long a3 = com.bumptech.glide.i.d.a();
        this.i.a().a(this.f771b.a(), new c(this.f.c(), a2));
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Wrote source to cache", a3);
        }
        long a4 = com.bumptech.glide.i.d.a();
        k<T> a5 = a(this.f771b.a());
        if (Log.isLoggable("DecodeJob", 2) && a5 != null) {
            a("Decoded source from cache", a4);
        }
        return a5;
    }

    private k<T> a(com.bumptech.glide.load.c cVar) throws IOException {
        k<T> kVar = null;
        File a2 = this.i.a().a(cVar);
        if (a2 != null) {
            try {
                kVar = this.f.a().a(a2, this.f772c, this.d);
                if (kVar == null) {
                    this.i.a().b(cVar);
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    this.i.a().b(cVar);
                }
                throw th;
            }
        }
        return kVar;
    }

    private k<T> c(k<T> kVar) {
        if (kVar == null) {
            return null;
        }
        k<T> transform = this.g.transform(kVar, this.f772c, this.d);
        if (!kVar.equals(transform)) {
            kVar.d();
            return transform;
        }
        return transform;
    }

    private k<Z> d(k<T> kVar) {
        if (kVar == null) {
            return null;
        }
        return this.h.a(kVar);
    }

    private void a(String str, long j) {
        Log.v("DecodeJob", str + " in " + com.bumptech.glide.i.d.a(j) + ", key: " + this.f771b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public class c<DataType> implements a.b {

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.load.b<DataType> f780b;

        /* renamed from: c  reason: collision with root package name */
        private final DataType f781c;

        public c(com.bumptech.glide.load.b<DataType> bVar, DataType datatype) {
            this.f780b = bVar;
            this.f781c = datatype;
        }

        @Override // com.bumptech.glide.load.b.b.a.b
        public boolean a(File file) {
            boolean z = false;
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = a.this.l.a(file);
                    z = this.f780b.a(this.f781c, outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "Failed to find file to write to disk cache", e3);
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
            return z;
        }
    }

    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        public OutputStream a(File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }
}
