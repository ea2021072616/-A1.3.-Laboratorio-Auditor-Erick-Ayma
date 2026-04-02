package rx.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: RxJavaPlugins.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<b> f5276c = new AtomicReference<>();
    private final AtomicReference<d> d = new AtomicReference<>();
    private final AtomicReference<h> e = new AtomicReference<>();
    private final AtomicReference<a> f = new AtomicReference<>();
    private final AtomicReference<g> g = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private static final f f5275b = new f();

    /* renamed from: a  reason: collision with root package name */
    static final b f5274a = new b() { // from class: rx.e.f.1
    };

    @Deprecated
    public static f a() {
        return f5275b;
    }

    f() {
    }

    public b b() {
        if (this.f5276c.get() == null) {
            Object a2 = a(b.class, System.getProperties());
            if (a2 == null) {
                this.f5276c.compareAndSet(null, f5274a);
            } else {
                this.f5276c.compareAndSet(null, (b) a2);
            }
        }
        return this.f5276c.get();
    }

    public d c() {
        if (this.d.get() == null) {
            Object a2 = a(d.class, System.getProperties());
            if (a2 == null) {
                this.d.compareAndSet(null, e.a());
            } else {
                this.d.compareAndSet(null, (d) a2);
            }
        }
        return this.d.get();
    }

    public h d() {
        if (this.e.get() == null) {
            Object a2 = a(h.class, System.getProperties());
            if (a2 == null) {
                this.e.compareAndSet(null, i.a());
            } else {
                this.e.compareAndSet(null, (h) a2);
            }
        }
        return this.e.get();
    }

    public a e() {
        if (this.f.get() == null) {
            Object a2 = a(a.class, System.getProperties());
            if (a2 == null) {
                this.f.compareAndSet(null, new a() { // from class: rx.e.f.2
                });
            } else {
                this.f.compareAndSet(null, (a) a2);
            }
        }
        return this.f.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0149 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.Object a(java.lang.Class<?> r10, java.util.Properties r11) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.e.f.a(java.lang.Class, java.util.Properties):java.lang.Object");
    }

    public g f() {
        if (this.g.get() == null) {
            Object a2 = a(g.class, System.getProperties());
            if (a2 == null) {
                this.g.compareAndSet(null, g.g());
            } else {
                this.g.compareAndSet(null, (g) a2);
            }
        }
        return this.g.get();
    }
}
