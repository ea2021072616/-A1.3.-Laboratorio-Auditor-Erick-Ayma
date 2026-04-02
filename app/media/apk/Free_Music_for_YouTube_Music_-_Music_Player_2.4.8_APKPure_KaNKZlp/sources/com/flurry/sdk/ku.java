package com.flurry.sdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ku extends mb {
    static final String e = ku.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private int f2088c;
    private int d;
    public String g;
    public a h;
    public c l;
    public boolean m;
    public Exception p;
    public boolean r;
    public boolean t;
    private HttpURLConnection v;
    private boolean w;
    private boolean x;

    /* renamed from: a  reason: collision with root package name */
    private final kd<String, String> f2086a = new kd<>();
    public final kd<String, String> f = new kd<>();

    /* renamed from: b  reason: collision with root package name */
    private final Object f2087b = new Object();
    public int i = 10000;
    public int j = 15000;
    public boolean k = true;
    long n = -1;
    public long o = -1;
    public int q = -1;
    public int s = 25000;
    private kt y = new kt(this);

    /* loaded from: classes.dex */
    public interface c {
        void a(ku kuVar);

        void a(ku kuVar, InputStream inputStream) throws Exception;

        void a(OutputStream outputStream) throws Exception;
    }

    public final void a(String str, String str2) {
        this.f2086a.a((kd<String, String>) str, str2);
    }

    public final boolean b() {
        return !c() && d();
    }

    public final boolean c() {
        return this.p != null;
    }

    public final boolean d() {
        return this.q >= 200 && this.q < 400 && !this.t;
    }

    public final List<String> a(String str) {
        return this.f.a((kd<String, String>) str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        if (this.l != null && !g()) {
            this.l.a(this);
        }
    }

    public final void f() {
        km.a(3, e, "Cancelling http request: " + this.g);
        synchronized (this.f2087b) {
            this.x = true;
        }
        if (this.w) {
            return;
        }
        this.w = true;
        if (this.v == null) {
            return;
        }
        new Thread() { // from class: com.flurry.sdk.ku.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    if (ku.this.v != null) {
                        ku.this.v.disconnect();
                    }
                } catch (Throwable th) {
                }
            }
        }.start();
    }

    public final boolean g() {
        boolean z;
        synchronized (this.f2087b) {
            z = this.x;
        }
        return z;
    }

    @Override // com.flurry.sdk.ma
    public void a() {
        try {
            if (this.g == null) {
                return;
            }
            if (!jr.a().f2000b) {
                km.a(3, e, "Network not available, aborting http request: " + this.g);
                return;
            }
            if (this.h == null || a.kUnknown.equals(this.h)) {
                this.h = a.kGet;
            }
            i();
            km.a(4, e, "HTTP status: " + this.q + " for url: " + this.g);
        } catch (Exception e2) {
            km.a(4, e, "HTTP status: " + this.q + " for url: " + this.g);
            km.a(3, e, "Exception during http request: " + this.g, e2);
            this.d = this.v.getReadTimeout();
            this.f2088c = this.v.getConnectTimeout();
            this.p = e2;
        } finally {
            this.y.a();
            e();
        }
    }

    private void i() throws Exception {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        InputStream inputStream = null;
        if (this.x) {
            return;
        }
        this.g = ly.a(this.g);
        try {
            this.v = (HttpURLConnection) new URL(this.g).openConnection();
            this.v.setConnectTimeout(this.i);
            this.v.setReadTimeout(this.j);
            this.v.setRequestMethod(this.h.toString());
            this.v.setInstanceFollowRedirects(this.k);
            this.v.setDoOutput(a.kPost.equals(this.h));
            this.v.setDoInput(true);
            for (Map.Entry<String, String> entry : this.f2086a.b()) {
                this.v.addRequestProperty(entry.getKey(), entry.getValue());
            }
            if (!a.kGet.equals(this.h) && !a.kPost.equals(this.h)) {
                this.v.setRequestProperty("Accept-Encoding", "");
            }
            if (this.x) {
                return;
            }
            if (a.kPost.equals(this.h)) {
                try {
                    OutputStream outputStream = this.v.getOutputStream();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = null;
                        inputStream = outputStream;
                    }
                    try {
                        if (this.l != null && !g()) {
                            this.l.a(bufferedOutputStream);
                        }
                        ly.a(bufferedOutputStream);
                        ly.a(outputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = outputStream;
                        ly.a(bufferedOutputStream);
                        ly.a(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
            }
            if (this.m) {
                this.n = System.currentTimeMillis();
            }
            if (this.r) {
                this.y.a(this.s);
            }
            this.q = this.v.getResponseCode();
            if (this.m && this.n != -1) {
                this.o = System.currentTimeMillis() - this.n;
            }
            this.y.a();
            for (Map.Entry<String, List<String>> entry2 : this.v.getHeaderFields().entrySet()) {
                for (String str : entry2.getValue()) {
                    this.f.a((kd<String, String>) entry2.getKey(), str);
                }
            }
            if (!a.kGet.equals(this.h) && !a.kPost.equals(this.h)) {
                return;
            }
            if (this.x) {
                return;
            }
            try {
                InputStream inputStream2 = this.v.getInputStream();
                try {
                    bufferedInputStream2 = new BufferedInputStream(inputStream2);
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = null;
                    inputStream = inputStream2;
                }
                try {
                    if (this.l != null && !g()) {
                        this.l.a(this, bufferedInputStream2);
                    }
                    ly.a((Closeable) bufferedInputStream2);
                    ly.a((Closeable) inputStream2);
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = inputStream2;
                    bufferedInputStream = bufferedInputStream2;
                    ly.a((Closeable) bufferedInputStream);
                    ly.a((Closeable) inputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
            }
        } finally {
            j();
        }
    }

    private void j() {
        if (!this.w) {
            this.w = true;
            if (this.v != null) {
                this.v.disconnect();
            }
        }
    }

    @Override // com.flurry.sdk.mb
    public final void h() {
        f();
    }

    /* loaded from: classes.dex */
    public enum a {
        kUnknown,
        kGet,
        kPost,
        kPut,
        kDelete,
        kHead;

        @Override // java.lang.Enum
        public final String toString() {
            switch (this) {
                case kPost:
                    return "POST";
                case kPut:
                    return "PUT";
                case kDelete:
                    return "DELETE";
                case kHead:
                    return "HEAD";
                case kGet:
                    return "GET";
                default:
                    return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c {
        @Override // com.flurry.sdk.ku.c
        public final void a(OutputStream outputStream) throws Exception {
        }

        @Override // com.flurry.sdk.ku.c
        public void a(ku kuVar, InputStream inputStream) throws Exception {
        }

        @Override // com.flurry.sdk.ku.c
        public void a(ku kuVar) {
        }
    }
}
