package com.facebook.ads.internal.i.b;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final n f1436a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.ads.internal.i.b.a f1437b;
    private volatile Thread f;
    private volatile boolean g;

    /* renamed from: c  reason: collision with root package name */
    private final Object f1438c = new Object();
    private final Object d = new Object();
    private volatile int h = -1;
    private final AtomicInteger e = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.e();
        }
    }

    public k(n nVar, com.facebook.ads.internal.i.b.a aVar) {
        this.f1436a = (n) j.a(nVar);
        this.f1437b = (com.facebook.ads.internal.i.b.a) j.a(aVar);
    }

    private void b() {
        int i = this.e.get();
        if (i >= 1) {
            this.e.set(0);
            throw new l("Error reading source " + i + " times");
        }
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.f1438c) {
            this.f1438c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.g && !this.f1437b.d() && !z) {
            this.f = new Thread(new a(), "Source reader for " + this.f1436a);
            this.f.start();
        }
    }

    private void d() {
        synchronized (this.f1438c) {
            try {
                this.f1438c.wait(1000L);
            } catch (InterruptedException e) {
                throw new l("Waiting source data is interrupted!", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i;
        int i2 = 0;
        try {
            i2 = this.f1437b.a();
            this.f1436a.a(i2);
            i = this.f1436a.a();
        } catch (Throwable th) {
            th = th;
            i = -1;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.f1436a.a(bArr);
                if (a2 == -1) {
                    f();
                    return;
                }
                synchronized (this.d) {
                    if (g()) {
                        return;
                    }
                    this.f1437b.a(bArr, a2);
                }
                i2 += a2;
                b(i2, i);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                this.e.incrementAndGet();
                a(th);
            } finally {
                h();
                b(i2, i);
            }
        }
    }

    private void f() {
        synchronized (this.d) {
            if (!g() && this.f1437b.a() == this.f1436a.a()) {
                this.f1437b.c();
            }
        }
    }

    private boolean g() {
        return Thread.currentThread().isInterrupted() || this.g;
    }

    private void h() {
        try {
            this.f1436a.b();
        } catch (l e) {
            a(new l("Error closing source " + this.f1436a, e));
        }
    }

    public int a(byte[] bArr, long j, int i) {
        m.a(bArr, j, i);
        while (!this.f1437b.d() && this.f1437b.a() < i + j && !this.g) {
            c();
            d();
            b();
        }
        int a2 = this.f1437b.a(bArr, j, i);
        if (this.f1437b.d() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.d) {
            Log.d("ProxyCache", "Shutdown proxy for " + this.f1436a);
            try {
                this.g = true;
                if (this.f != null) {
                    this.f.interrupt();
                }
                this.f1437b.b();
            } catch (l e) {
                a(e);
            }
        }
    }

    protected void a(int i) {
    }

    protected void a(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((100 * j) / j2);
        boolean z = i != this.h;
        if ((j2 >= 0) && z) {
            a(i);
        }
        this.h = i;
    }

    protected final void a(Throwable th) {
        if (th instanceof i) {
            Log.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            Log.e("ProxyCache", "ProxyCache error", th);
        }
    }
}
