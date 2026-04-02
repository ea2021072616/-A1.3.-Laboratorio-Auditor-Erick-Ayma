package rx.e;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.f;
import rx.internal.a.ab;
import rx.internal.a.z;
import rx.j;
import rx.m;
/* compiled from: RxJavaHooks.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    static volatile rx.c.b<Throwable> f5270a;

    /* renamed from: b  reason: collision with root package name */
    static volatile rx.c.e<f.a, f.a> f5271b;

    /* renamed from: c  reason: collision with root package name */
    static volatile rx.c.e<j.a, j.a> f5272c;
    static volatile rx.c.e<b.a, b.a> d;
    static volatile rx.c.f<rx.f, f.a, f.a> e;
    static volatile rx.c.f<j, j.a, j.a> f;
    static volatile rx.c.f<rx.b, b.a, b.a> g;
    static volatile rx.c.e<rx.i, rx.i> h;
    static volatile rx.c.e<rx.i, rx.i> i;
    static volatile rx.c.e<rx.i, rx.i> j;
    static volatile rx.c.e<rx.c.a, rx.c.a> k;
    static volatile rx.c.e<m, m> l;
    static volatile rx.c.e<m, m> m;
    static volatile rx.c.d<? extends ScheduledExecutorService> n;
    static volatile rx.c.e<Throwable, Throwable> o;
    static volatile rx.c.e<Throwable, Throwable> p;
    static volatile rx.c.e<Throwable, Throwable> q;
    static volatile rx.c.e<f.b, f.b> r;
    static volatile rx.c.e<f.b, f.b> s;
    static volatile rx.c.e<b.InterfaceC0107b, b.InterfaceC0107b> t;

    static {
        a();
    }

    static void a() {
        f5270a = new rx.c.b<Throwable>() { // from class: rx.e.c.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                f.a().b().a(th);
            }
        };
        e = new rx.c.f<rx.f, f.a, f.a>() { // from class: rx.e.c.9
            @Override // rx.c.f
            public f.a a(rx.f fVar, f.a aVar) {
                return f.a().c().a(fVar, aVar);
            }
        };
        l = new rx.c.e<m, m>() { // from class: rx.e.c.10
            @Override // rx.c.e
            public m a(m mVar) {
                return f.a().c().a(mVar);
            }
        };
        f = new rx.c.f<j, j.a, j.a>() { // from class: rx.e.c.11
            @Override // rx.c.f
            public j.a a(j jVar, j.a aVar) {
                h d2 = f.a().d();
                return d2 == i.a() ? aVar : new z(d2.a(jVar, new ab(aVar)));
            }
        };
        m = new rx.c.e<m, m>() { // from class: rx.e.c.12
            @Override // rx.c.e
            public m a(m mVar) {
                return f.a().d().a(mVar);
            }
        };
        g = new rx.c.f<rx.b, b.a, b.a>() { // from class: rx.e.c.13
            @Override // rx.c.f
            public b.a a(rx.b bVar, b.a aVar) {
                return f.a().e().a(bVar, aVar);
            }
        };
        k = new rx.c.e<rx.c.a, rx.c.a>() { // from class: rx.e.c.14
            @Override // rx.c.e
            public rx.c.a a(rx.c.a aVar) {
                return f.a().f().a(aVar);
            }
        };
        o = new rx.c.e<Throwable, Throwable>() { // from class: rx.e.c.15
            @Override // rx.c.e
            public Throwable a(Throwable th) {
                return f.a().c().a(th);
            }
        };
        r = new rx.c.e<f.b, f.b>() { // from class: rx.e.c.16
            @Override // rx.c.e
            public f.b a(f.b bVar) {
                return f.a().c().a(bVar);
            }
        };
        p = new rx.c.e<Throwable, Throwable>() { // from class: rx.e.c.2
            @Override // rx.c.e
            public Throwable a(Throwable th) {
                return f.a().d().a(th);
            }
        };
        s = new rx.c.e<f.b, f.b>() { // from class: rx.e.c.3
            @Override // rx.c.e
            public f.b a(f.b bVar) {
                return f.a().d().a(bVar);
            }
        };
        q = new rx.c.e<Throwable, Throwable>() { // from class: rx.e.c.4
            @Override // rx.c.e
            public Throwable a(Throwable th) {
                return f.a().e().a(th);
            }
        };
        t = new rx.c.e<b.InterfaceC0107b, b.InterfaceC0107b>() { // from class: rx.e.c.5
            @Override // rx.c.e
            public b.InterfaceC0107b a(b.InterfaceC0107b interfaceC0107b) {
                return f.a().e().a(interfaceC0107b);
            }
        };
        b();
    }

    static void b() {
        f5271b = new rx.c.e<f.a, f.a>() { // from class: rx.e.c.6
            @Override // rx.c.e
            public f.a a(f.a aVar) {
                return f.a().c().a(aVar);
            }
        };
        f5272c = new rx.c.e<j.a, j.a>() { // from class: rx.e.c.7
            @Override // rx.c.e
            public j.a a(j.a aVar) {
                return f.a().d().a(aVar);
            }
        };
        d = new rx.c.e<b.a, b.a>() { // from class: rx.e.c.8
            @Override // rx.c.e
            public b.a a(b.a aVar) {
                return f.a().e().a(aVar);
            }
        };
    }

    public static void a(Throwable th) {
        rx.c.b<Throwable> bVar = f5270a;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                ThrowableExtension.printStackTrace(th2);
                b(th2);
            }
        }
        b(th);
    }

    static void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> f.a<T> a(f.a<T> aVar) {
        rx.c.e<f.a, f.a> eVar = f5271b;
        return eVar != null ? eVar.a(aVar) : aVar;
    }

    public static <T> j.a<T> a(j.a<T> aVar) {
        rx.c.e<j.a, j.a> eVar = f5272c;
        return eVar != null ? eVar.a(aVar) : aVar;
    }

    public static b.a a(b.a aVar) {
        rx.c.e<b.a, b.a> eVar = d;
        return eVar != null ? eVar.a(aVar) : aVar;
    }

    public static rx.i a(rx.i iVar) {
        rx.c.e<rx.i, rx.i> eVar = h;
        return eVar != null ? eVar.a(iVar) : iVar;
    }

    public static rx.i b(rx.i iVar) {
        rx.c.e<rx.i, rx.i> eVar = i;
        return eVar != null ? eVar.a(iVar) : iVar;
    }

    public static rx.i c(rx.i iVar) {
        rx.c.e<rx.i, rx.i> eVar = j;
        return eVar != null ? eVar.a(iVar) : iVar;
    }

    public static rx.c.a a(rx.c.a aVar) {
        rx.c.e<rx.c.a, rx.c.a> eVar = k;
        return eVar != null ? eVar.a(aVar) : aVar;
    }

    public static <T> f.a<T> a(rx.f<T> fVar, f.a<T> aVar) {
        rx.c.f<rx.f, f.a, f.a> fVar2 = e;
        return fVar2 != null ? fVar2.a(fVar, aVar) : aVar;
    }

    public static m a(m mVar) {
        rx.c.e<m, m> eVar = l;
        return eVar != null ? eVar.a(mVar) : mVar;
    }

    public static Throwable c(Throwable th) {
        rx.c.e<Throwable, Throwable> eVar = o;
        return eVar != null ? eVar.a(th) : th;
    }

    public static <T, R> f.b<R, T> a(f.b<R, T> bVar) {
        rx.c.e<f.b, f.b> eVar = r;
        return eVar != null ? eVar.a(bVar) : bVar;
    }

    public static <T, R> f.b<R, T> b(f.b<R, T> bVar) {
        rx.c.e<f.b, f.b> eVar = s;
        return eVar != null ? eVar.a(bVar) : bVar;
    }

    public static <T> b.a a(rx.b bVar, b.a aVar) {
        rx.c.f<rx.b, b.a, b.a> fVar = g;
        return fVar != null ? fVar.a(bVar, aVar) : aVar;
    }

    public static Throwable d(Throwable th) {
        rx.c.e<Throwable, Throwable> eVar = q;
        return eVar != null ? eVar.a(th) : th;
    }

    public static rx.c.d<? extends ScheduledExecutorService> c() {
        return n;
    }
}
