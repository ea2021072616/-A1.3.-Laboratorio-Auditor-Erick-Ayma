package com.bumptech.glide.load.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class f implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config f787a = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    private final g f788b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Bitmap.Config> f789c;
    private final int d;
    private final a e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    f(int i, g gVar, Set<Bitmap.Config> set) {
        this.d = i;
        this.f = i;
        this.f788b = gVar;
        this.f789c = set;
        this.e = new b();
    }

    public f(int i) {
        this(i, e(), f());
    }

    @Override // com.bumptech.glide.load.b.a.c
    public synchronized boolean a(Bitmap bitmap) {
        boolean z;
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (!bitmap.isMutable() || this.f788b.c(bitmap) > this.f || !this.f789c.contains(bitmap.getConfig())) {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f788b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f789c.contains(bitmap.getConfig()));
            }
            z = false;
        } else {
            int c2 = this.f788b.c(bitmap);
            this.f788b.a(bitmap);
            this.e.a(bitmap);
            this.j++;
            this.g = c2 + this.g;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f788b.b(bitmap));
            }
            c();
            b();
            z = true;
        }
        return z;
    }

    private void b() {
        b(this.f);
    }

    @Override // com.bumptech.glide.load.b.a.c
    public synchronized Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap b2;
        b2 = b(i, i2, config);
        if (b2 != null) {
            b2.eraseColor(0);
        }
        return b2;
    }

    @Override // com.bumptech.glide.load.b.a.c
    @TargetApi(12)
    public synchronized Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap a2;
        a2 = this.f788b.a(i, i2, config != null ? config : f787a);
        if (a2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f788b.b(i, i2, config));
            }
            this.i++;
        } else {
            this.h++;
            this.g -= this.f788b.c(a2);
            this.e.b(a2);
            if (Build.VERSION.SDK_INT >= 12) {
                a2.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f788b.b(i, i2, config));
        }
        c();
        return a2;
    }

    @Override // com.bumptech.glide.load.b.a.c
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        b(0);
    }

    @Override // com.bumptech.glide.load.b.a.c
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 60) {
            a();
        } else if (i >= 40) {
            b(this.f / 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        r4.g = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (android.util.Log.isLoggable("LruBitmapPool", 5) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        android.util.Log.w("LruBitmapPool", "Size mismatch, resetting");
        d();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void b(int r5) {
        /*
            r4 = this;
            monitor-enter(r4)
        L1:
            int r0 = r4.g     // Catch: java.lang.Throwable -> L69
            if (r0 <= r5) goto L23
            com.bumptech.glide.load.b.a.g r0 = r4.f788b     // Catch: java.lang.Throwable -> L69
            android.graphics.Bitmap r0 = r0.a()     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L25
            java.lang.String r0 = "LruBitmapPool"
            r1 = 5
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L20
            java.lang.String r0 = "LruBitmapPool"
            java.lang.String r1 = "Size mismatch, resetting"
            android.util.Log.w(r0, r1)     // Catch: java.lang.Throwable -> L69
            r4.d()     // Catch: java.lang.Throwable -> L69
        L20:
            r0 = 0
            r4.g = r0     // Catch: java.lang.Throwable -> L69
        L23:
            monitor-exit(r4)
            return
        L25:
            com.bumptech.glide.load.b.a.f$a r1 = r4.e     // Catch: java.lang.Throwable -> L69
            r1.b(r0)     // Catch: java.lang.Throwable -> L69
            int r1 = r4.g     // Catch: java.lang.Throwable -> L69
            com.bumptech.glide.load.b.a.g r2 = r4.f788b     // Catch: java.lang.Throwable -> L69
            int r2 = r2.c(r0)     // Catch: java.lang.Throwable -> L69
            int r1 = r1 - r2
            r4.g = r1     // Catch: java.lang.Throwable -> L69
            r0.recycle()     // Catch: java.lang.Throwable -> L69
            int r1 = r4.k     // Catch: java.lang.Throwable -> L69
            int r1 = r1 + 1
            r4.k = r1     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "LruBitmapPool"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L65
            java.lang.String r1 = "LruBitmapPool"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
            r2.<init>()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = "Evicting bitmap="
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L69
            com.bumptech.glide.load.b.a.g r3 = r4.f788b     // Catch: java.lang.Throwable -> L69
            java.lang.String r0 = r3.b(r0)     // Catch: java.lang.Throwable -> L69
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L69
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L69
            android.util.Log.d(r1, r0)     // Catch: java.lang.Throwable -> L69
        L65:
            r4.c()     // Catch: java.lang.Throwable -> L69
            goto L1
        L69:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.f.b(int):void");
    }

    private void c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            d();
        }
    }

    private void d() {
        Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.f788b);
    }

    private static g e() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new i();
        }
        return new com.bumptech.glide.load.b.a.a();
    }

    private static Set<Bitmap.Config> f() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    private static class b implements a {
        private b() {
        }

        @Override // com.bumptech.glide.load.b.a.f.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.b.a.f.a
        public void b(Bitmap bitmap) {
        }
    }
}
