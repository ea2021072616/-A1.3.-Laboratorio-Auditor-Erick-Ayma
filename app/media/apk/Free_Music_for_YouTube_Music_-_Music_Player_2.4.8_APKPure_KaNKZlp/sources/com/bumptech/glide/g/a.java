package com.bumptech.glide.g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.g.b.h;
import com.bumptech.glide.g.b.j;
import com.bumptech.glide.load.b.c;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.g;
import java.util.Queue;
/* compiled from: GenericRequest.java */
/* loaded from: classes.dex */
public final class a<A, T, Z, R> implements b, h, e {

    /* renamed from: a  reason: collision with root package name */
    private static final Queue<a<?, ?, ?, ?>> f679a = com.bumptech.glide.i.h.a(0);
    private k<?> A;
    private c.C0028c B;
    private long C;
    private EnumC0021a D;

    /* renamed from: b  reason: collision with root package name */
    private final String f680b = String.valueOf(hashCode());

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.load.c f681c;
    private Drawable d;
    private int e;
    private int f;
    private int g;
    private Context h;
    private g<Z> i;
    private com.bumptech.glide.f.f<A, T, Z, R> j;
    private c k;
    private A l;
    private Class<R> m;
    private boolean n;
    private com.bumptech.glide.k o;
    private j<R> p;
    private d<? super A, R> q;
    private float r;
    private com.bumptech.glide.load.b.c s;
    private com.bumptech.glide.g.a.d<R> t;
    private int u;
    private int v;
    private com.bumptech.glide.load.b.b w;
    private Drawable x;
    private Drawable y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GenericRequest.java */
    /* renamed from: com.bumptech.glide.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0021a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    public static <A, T, Z, R> a<A, T, Z, R> a(com.bumptech.glide.f.f<A, T, Z, R> fVar, A a2, com.bumptech.glide.load.c cVar, Context context, com.bumptech.glide.k kVar, j<R> jVar, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, d<? super A, R> dVar, c cVar2, com.bumptech.glide.load.b.c cVar3, g<Z> gVar, Class<R> cls, boolean z, com.bumptech.glide.g.a.d<R> dVar2, int i4, int i5, com.bumptech.glide.load.b.b bVar) {
        a<A, T, Z, R> aVar = (a<A, T, Z, R>) f679a.poll();
        if (aVar == null) {
            aVar = new a<>();
        }
        aVar.b(fVar, a2, cVar, context, kVar, jVar, f, drawable, i, drawable2, i2, drawable3, i3, dVar, cVar2, cVar3, gVar, cls, z, dVar2, i4, i5, bVar);
        return aVar;
    }

    private a() {
    }

    @Override // com.bumptech.glide.g.b
    public void a() {
        this.j = null;
        this.l = null;
        this.h = null;
        this.p = null;
        this.x = null;
        this.y = null;
        this.d = null;
        this.q = null;
        this.k = null;
        this.i = null;
        this.t = null;
        this.z = false;
        this.B = null;
        f679a.offer(this);
    }

    private void b(com.bumptech.glide.f.f<A, T, Z, R> fVar, A a2, com.bumptech.glide.load.c cVar, Context context, com.bumptech.glide.k kVar, j<R> jVar, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, d<? super A, R> dVar, c cVar2, com.bumptech.glide.load.b.c cVar3, g<Z> gVar, Class<R> cls, boolean z, com.bumptech.glide.g.a.d<R> dVar2, int i4, int i5, com.bumptech.glide.load.b.b bVar) {
        this.j = fVar;
        this.l = a2;
        this.f681c = cVar;
        this.d = drawable3;
        this.e = i3;
        this.h = context.getApplicationContext();
        this.o = kVar;
        this.p = jVar;
        this.r = f;
        this.x = drawable;
        this.f = i;
        this.y = drawable2;
        this.g = i2;
        this.q = dVar;
        this.k = cVar2;
        this.s = cVar3;
        this.i = gVar;
        this.m = cls;
        this.n = z;
        this.t = dVar2;
        this.u = i4;
        this.v = i5;
        this.w = bVar;
        this.D = EnumC0021a.PENDING;
        if (a2 != null) {
            a("ModelLoader", fVar.e(), "try .using(ModelLoader)");
            a("Transcoder", fVar.f(), "try .as*(Class).transcode(ResourceTranscoder)");
            a("Transformation", gVar, "try .transform(UnitTransformation.get())");
            if (bVar.a()) {
                a("SourceEncoder", fVar.c(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                a("SourceDecoder", fVar.b(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (bVar.a() || bVar.b()) {
                a("CacheDecoder", fVar.a(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (bVar.b()) {
                a("Encoder", fVar.d(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private static void a(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(" must not be null");
            if (str2 != null) {
                sb.append(", ");
                sb.append(str2);
            }
            throw new NullPointerException(sb.toString());
        }
    }

    @Override // com.bumptech.glide.g.b
    public void b() {
        this.C = com.bumptech.glide.i.d.a();
        if (this.l == null) {
            a((Exception) null);
            return;
        }
        this.D = EnumC0021a.WAITING_FOR_SIZE;
        if (com.bumptech.glide.i.h.a(this.u, this.v)) {
            a(this.u, this.v);
        } else {
            this.p.getSize(this);
        }
        if (!g() && !j() && o()) {
            this.p.onLoadStarted(m());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished run method in " + com.bumptech.glide.i.d.a(this.C));
        }
    }

    void c() {
        this.D = EnumC0021a.CANCELLED;
        if (this.B != null) {
            this.B.a();
            this.B = null;
        }
    }

    @Override // com.bumptech.glide.g.b
    public void d() {
        com.bumptech.glide.i.h.a();
        if (this.D != EnumC0021a.CLEARED) {
            c();
            if (this.A != null) {
                b(this.A);
            }
            if (o()) {
                this.p.onLoadCleared(m());
            }
            this.D = EnumC0021a.CLEARED;
        }
    }

    @Override // com.bumptech.glide.g.b
    public void e() {
        d();
        this.D = EnumC0021a.PAUSED;
    }

    private void b(k kVar) {
        this.s.a(kVar);
        this.A = null;
    }

    @Override // com.bumptech.glide.g.b
    public boolean f() {
        return this.D == EnumC0021a.RUNNING || this.D == EnumC0021a.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.g.b
    public boolean g() {
        return this.D == EnumC0021a.COMPLETE;
    }

    @Override // com.bumptech.glide.g.b
    public boolean h() {
        return g();
    }

    @Override // com.bumptech.glide.g.b
    public boolean i() {
        return this.D == EnumC0021a.CANCELLED || this.D == EnumC0021a.CLEARED;
    }

    public boolean j() {
        return this.D == EnumC0021a.FAILED;
    }

    private Drawable k() {
        if (this.d == null && this.e > 0) {
            this.d = this.h.getResources().getDrawable(this.e);
        }
        return this.d;
    }

    private void b(Exception exc) {
        if (o()) {
            Drawable k = this.l == null ? k() : null;
            if (k == null) {
                k = l();
            }
            if (k == null) {
                k = m();
            }
            this.p.onLoadFailed(exc, k);
        }
    }

    private Drawable l() {
        if (this.y == null && this.g > 0) {
            this.y = this.h.getResources().getDrawable(this.g);
        }
        return this.y;
    }

    private Drawable m() {
        if (this.x == null && this.f > 0) {
            this.x = this.h.getResources().getDrawable(this.f);
        }
        return this.x;
    }

    @Override // com.bumptech.glide.g.b.h
    public void a(int i, int i2) {
        if (Log.isLoggable("GenericRequest", 2)) {
            a("Got onSizeReady in " + com.bumptech.glide.i.d.a(this.C));
        }
        if (this.D == EnumC0021a.WAITING_FOR_SIZE) {
            this.D = EnumC0021a.RUNNING;
            int round = Math.round(this.r * i);
            int round2 = Math.round(this.r * i2);
            com.bumptech.glide.load.a.c<T> a2 = this.j.e().a(this.l, round, round2);
            if (a2 == null) {
                a(new Exception("Failed to load model: '" + this.l + "'"));
                return;
            }
            com.bumptech.glide.load.resource.e.c<Z, R> f = this.j.f();
            if (Log.isLoggable("GenericRequest", 2)) {
                a("finished setup for calling load in " + com.bumptech.glide.i.d.a(this.C));
            }
            this.z = true;
            this.B = this.s.a(this.f681c, round, round2, a2, this.j, this.i, f, this.o, this.n, this.w, this);
            this.z = this.A != null;
            if (Log.isLoggable("GenericRequest", 2)) {
                a("finished onSizeReady in " + com.bumptech.glide.i.d.a(this.C));
            }
        }
    }

    private boolean n() {
        return this.k == null || this.k.a(this);
    }

    private boolean o() {
        return this.k == null || this.k.b(this);
    }

    private boolean p() {
        return this.k == null || !this.k.c();
    }

    private void q() {
        if (this.k != null) {
            this.k.c(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.g.e
    public void a(k<?> kVar) {
        if (kVar == null) {
            a(new Exception("Expected to receive a Resource<R> with an object of " + this.m + " inside, but instead got null."));
            return;
        }
        Object b2 = kVar.b();
        if (b2 == null || !this.m.isAssignableFrom(b2.getClass())) {
            b(kVar);
            a(new Exception("Expected to receive an object of " + this.m + " but instead got " + (b2 != null ? b2.getClass() : "") + "{" + b2 + "} inside Resource{" + kVar + "}." + (b2 != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
        } else if (!n()) {
            b(kVar);
            this.D = EnumC0021a.COMPLETE;
        } else {
            a(kVar, (k<?>) b2);
        }
    }

    private void a(k<?> kVar, R r) {
        boolean p = p();
        this.D = EnumC0021a.COMPLETE;
        this.A = kVar;
        if (this.q == null || !this.q.a(r, (A) this.l, this.p, this.z, p)) {
            this.p.onResourceReady(r, this.t.a(this.z, p));
        }
        q();
        if (Log.isLoggable("GenericRequest", 2)) {
            a("Resource ready in " + com.bumptech.glide.i.d.a(this.C) + " size: " + (kVar.c() * 9.5367431640625E-7d) + " fromCache: " + this.z);
        }
    }

    @Override // com.bumptech.glide.g.e
    public void a(Exception exc) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exc);
        }
        this.D = EnumC0021a.FAILED;
        if (this.q == null || !this.q.a(exc, (A) this.l, this.p, p())) {
            b(exc);
        }
    }

    private void a(String str) {
        Log.v("GenericRequest", str + " this: " + this.f680b);
    }
}
