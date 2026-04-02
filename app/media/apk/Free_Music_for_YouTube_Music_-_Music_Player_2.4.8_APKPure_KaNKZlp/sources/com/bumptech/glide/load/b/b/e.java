package com.bumptech.glide.load.b.b;

import android.util.Log;
import com.bumptech.glide.a.a;
import com.bumptech.glide.load.b.b.a;
import java.io.File;
import java.io.IOException;
/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static e f807a = null;

    /* renamed from: b  reason: collision with root package name */
    private final c f808b = new c();

    /* renamed from: c  reason: collision with root package name */
    private final j f809c = new j();
    private final File d;
    private final int e;
    private com.bumptech.glide.a.a f;

    public static synchronized a a(File file, int i) {
        e eVar;
        synchronized (e.class) {
            if (f807a == null) {
                f807a = new e(file, i);
            }
            eVar = f807a;
        }
        return eVar;
    }

    protected e(File file, int i) {
        this.d = file;
        this.e = i;
    }

    private synchronized com.bumptech.glide.a.a b() throws IOException {
        if (this.f == null) {
            this.f = com.bumptech.glide.a.a.a(this.d, 1, 1, this.e);
        }
        return this.f;
    }

    private synchronized void c() {
        this.f = null;
    }

    @Override // com.bumptech.glide.load.b.b.a
    public File a(com.bumptech.glide.load.c cVar) {
        try {
            a.c a2 = b().a(this.f809c.a(cVar));
            if (a2 == null) {
                return null;
            }
            return a2.a(0);
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.b.b.a
    public void a(com.bumptech.glide.load.c cVar, a.b bVar) {
        String a2 = this.f809c.a(cVar);
        this.f808b.a(cVar);
        try {
            a.C0019a b2 = b().b(a2);
            if (b2 != null) {
                try {
                    if (bVar.a(b2.a(0))) {
                        b2.a();
                    }
                } finally {
                    b2.c();
                }
            }
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
            }
        } finally {
            this.f808b.b(cVar);
        }
    }

    @Override // com.bumptech.glide.load.b.b.a
    public void b(com.bumptech.glide.load.c cVar) {
        try {
            b().c(this.f809c.a(cVar));
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }

    @Override // com.bumptech.glide.load.b.b.a
    public synchronized void a() {
        try {
            b().a();
            c();
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to clear disk cache", e);
            }
        }
    }
}
