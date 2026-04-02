package rx;

import java.util.concurrent.TimeUnit;
import rx.internal.a.n;
import rx.internal.a.o;
import rx.internal.a.q;
import rx.internal.a.r;
import rx.internal.a.s;
import rx.internal.a.t;
import rx.internal.a.u;
import rx.internal.a.v;
import rx.internal.a.w;
import rx.internal.a.x;
import rx.internal.a.y;
import rx.schedulers.Schedulers;
/* compiled from: Observable.java */
/* loaded from: classes.dex */
public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    final a<T> f5280a;

    /* compiled from: Observable.java */
    /* loaded from: classes2.dex */
    public interface a<T> extends rx.c.b<l<? super T>> {
    }

    /* compiled from: Observable.java */
    /* loaded from: classes2.dex */
    public interface b<R, T> extends rx.c.e<l<? super R>, l<? super T>> {
    }

    /* compiled from: Observable.java */
    /* loaded from: classes2.dex */
    public interface c<T, R> extends rx.c.e<f<T>, f<R>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(a<T> aVar) {
        this.f5280a = aVar;
    }

    @Deprecated
    public static <T> f<T> a(a<T> aVar) {
        return new f<>(rx.e.c.a(aVar));
    }

    public static <T> f<T> b(a<T> aVar) {
        return new f<>(rx.e.c.a(aVar));
    }

    public final <R> f<R> a(b<? extends R, ? super T> bVar) {
        return b((a) new rx.internal.a.i(this.f5280a, bVar));
    }

    public <R> f<R> a(c<? super T, ? extends R> cVar) {
        return (f) cVar.a(this);
    }

    public j<T> a() {
        return new j<>(rx.internal.a.l.a(this));
    }

    public rx.b b() {
        return rx.b.a((f<?>) this);
    }

    public static <T> f<T> a(rx.c.d<f<T>> dVar) {
        return b((a) new rx.internal.a.f(dVar));
    }

    public static <T> f<T> c() {
        return rx.internal.a.c.a();
    }

    public static <T> f<T> a(Throwable th) {
        return b((a) new rx.internal.a.m(th));
    }

    public static f<Long> a(long j, TimeUnit timeUnit) {
        return a(j, j, timeUnit, Schedulers.computation());
    }

    public static f<Long> a(long j, long j2, TimeUnit timeUnit) {
        return a(j, j2, timeUnit, Schedulers.computation());
    }

    public static f<Long> a(long j, long j2, TimeUnit timeUnit, i iVar) {
        return b((a) new o(j, j2, timeUnit, iVar));
    }

    public static <T> f<T> a(T t) {
        return rx.internal.util.i.b(t);
    }

    public static <T> f<T> a(f<? extends f<? extends T>> fVar) {
        return fVar.getClass() == rx.internal.util.i.class ? ((rx.internal.util.i) fVar).f(rx.internal.util.k.b()) : (f<T>) fVar.a((b<? extends R, ? super Object>) s.a(false));
    }

    public static f<Long> b(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, Schedulers.computation());
    }

    public static f<Long> a(long j, TimeUnit timeUnit, i iVar) {
        return b((a) new n(j, timeUnit, iVar));
    }

    public static <T1, T2, R> f<R> a(f<? extends T1> fVar, f<? extends T2> fVar2, rx.c.f<? super T1, ? super T2, ? extends R> fVar3) {
        return a(new f[]{fVar, fVar2}).a((b) new y(fVar3));
    }

    public final <R> f<R> a(Class<R> cls) {
        return a((b) new q(cls));
    }

    public final f<T> b(long j, TimeUnit timeUnit, i iVar) {
        return (f<T>) a((b) new r(j, timeUnit, iVar));
    }

    public final f<T> a(rx.c.b<? super T> bVar) {
        return b((a) new rx.internal.a.g(this, new rx.internal.util.a(bVar, rx.c.c.a(), rx.c.c.a())));
    }

    public final f<T> a(rx.c.e<? super T, Boolean> eVar) {
        return b((a) new rx.internal.a.h(this, eVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> f<R> b(rx.c.e<? super T, ? extends f<? extends R>> eVar) {
        return getClass() == rx.internal.util.i.class ? ((rx.internal.util.i) this).f(eVar) : a((f) c(eVar));
    }

    public final <R> f<R> c(rx.c.e<? super T, ? extends R> eVar) {
        return b((a) new rx.internal.a.j(this, eVar));
    }

    public final f<T> a(i iVar) {
        return a(iVar, rx.internal.util.g.f5597b);
    }

    public final f<T> a(i iVar, int i) {
        return a(iVar, false, i);
    }

    public final f<T> a(i iVar, boolean z, int i) {
        return this instanceof rx.internal.util.i ? ((rx.internal.util.i) this).d(iVar) : (f<T>) a((b) new t(iVar, z, i));
    }

    public final <R> f<R> b(Class<R> cls) {
        return a((rx.c.e) rx.internal.util.d.a((Class<?>) cls)).a((Class) cls);
    }

    public final f<T> d() {
        return (f<T>) a((b) u.a());
    }

    public final f<T> d(rx.c.e<? super Throwable, ? extends T> eVar) {
        return (f<T>) a((b) v.a((rx.c.e) eVar));
    }

    public final f<T> e(rx.c.e<? super f<? extends Throwable>, ? extends f<?>> eVar) {
        return rx.internal.a.k.a(this, rx.internal.util.d.a(eVar));
    }

    public final m b(rx.c.b<? super T> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        return b(new rx.internal.util.b(bVar, rx.internal.util.d.g, rx.c.c.a()));
    }

    public final m a(rx.c.b<? super T> bVar, rx.c.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        return b(new rx.internal.util.b(bVar, bVar2, rx.c.c.a()));
    }

    public final m a(g<? super T> gVar) {
        if (gVar instanceof l) {
            return b((l) gVar);
        }
        if (gVar == null) {
            throw new NullPointerException("observer is null");
        }
        return b(new rx.internal.util.e(gVar));
    }

    public final m a(l<? super T> lVar) {
        try {
            lVar.onStart();
            rx.e.c.a(this, this.f5280a).call(lVar);
            return rx.e.c.a(lVar);
        } catch (Throwable th) {
            rx.b.b.b(th);
            try {
                lVar.onError(rx.e.c.c(th));
                return rx.g.e.a();
            } catch (Throwable th2) {
                rx.b.b.b(th2);
                rx.b.e eVar = new rx.b.e("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                rx.e.c.c(eVar);
                throw eVar;
            }
        }
    }

    public final m b(l<? super T> lVar) {
        return a(lVar, this);
    }

    static <T> m a(l<? super T> lVar, f<T> fVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (fVar.f5280a == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        lVar.onStart();
        if (!(lVar instanceof rx.d.b)) {
            lVar = new rx.d.b(lVar);
        }
        try {
            rx.e.c.a(fVar, fVar.f5280a).call(lVar);
            return rx.e.c.a(lVar);
        } catch (Throwable th) {
            rx.b.b.b(th);
            if (lVar.isUnsubscribed()) {
                rx.e.c.a(rx.e.c.c(th));
            } else {
                try {
                    lVar.onError(rx.e.c.c(th));
                } catch (Throwable th2) {
                    rx.b.b.b(th2);
                    rx.b.e eVar = new rx.b.e("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    rx.e.c.c(eVar);
                    throw eVar;
                }
            }
            return rx.g.e.a();
        }
    }

    public final f<T> b(i iVar) {
        return a(iVar, !(this.f5280a instanceof rx.internal.a.e));
    }

    public final f<T> a(i iVar, boolean z) {
        return this instanceof rx.internal.util.i ? ((rx.internal.util.i) this).d(iVar) : b((a) new w(this, iVar, z));
    }

    public final f<T> c(i iVar) {
        return (f<T>) a((b) new x(iVar));
    }
}
