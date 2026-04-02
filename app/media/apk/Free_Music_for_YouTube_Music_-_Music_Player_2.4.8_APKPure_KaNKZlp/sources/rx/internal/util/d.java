package rx.internal.util;

import java.util.List;
import rx.f;
import rx.internal.a.p;
/* compiled from: InternalObservableUtils.java */
/* loaded from: classes2.dex */
public enum d {
    ;
    

    /* renamed from: a  reason: collision with root package name */
    public static final f f5589a = new rx.c.f<Long, Object, Long>() { // from class: rx.internal.util.d.f
        @Override // rx.c.f
        public Long a(Long l, Object obj) {
            return Long.valueOf(l.longValue() + 1);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final C0119d f5590b = new rx.c.f<Object, Object, Boolean>() { // from class: rx.internal.util.d.d
        @Override // rx.c.f
        /* renamed from: b */
        public Boolean a(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final i f5591c = new rx.c.e<List<? extends rx.f<?>>, rx.f<?>[]>() { // from class: rx.internal.util.d.i
        @Override // rx.c.e
        public rx.f<?>[] a(List<? extends rx.f<?>> list) {
            return (rx.f[]) list.toArray(new rx.f[list.size()]);
        }
    };
    static final h d = new rx.c.e<Object, Void>() { // from class: rx.internal.util.d.h
        @Override // rx.c.e
        /* renamed from: b */
        public Void a(Object obj) {
            return null;
        }
    };
    public static final e e = new rx.c.f<Integer, Object, Integer>() { // from class: rx.internal.util.d.e
        @Override // rx.c.f
        public Integer a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    static final c f = new c();
    public static final rx.c.b<Throwable> g = new rx.c.b<Throwable>() { // from class: rx.internal.util.d.a
        @Override // rx.c.b
        /* renamed from: a */
        public void call(Throwable th) {
            throw new rx.b.f(th);
        }
    };
    public static final f.b<Boolean, Object> h = new p(k.a(), true);

    public static rx.c.e<Object, Boolean> a(Class<?> cls) {
        return new b(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InternalObservableUtils.java */
    /* loaded from: classes2.dex */
    public static final class b implements rx.c.e<Object, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final Class<?> f5592a;

        public b(Class<?> cls) {
            this.f5592a = cls;
        }

        @Override // rx.c.e
        /* renamed from: b */
        public Boolean a(Object obj) {
            return Boolean.valueOf(this.f5592a.isInstance(obj));
        }
    }

    public static rx.c.e<rx.f<? extends rx.e<?>>, rx.f<?>> a(rx.c.e<? super rx.f<? extends Throwable>, ? extends rx.f<?>> eVar) {
        return new g(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InternalObservableUtils.java */
    /* loaded from: classes2.dex */
    public static final class g implements rx.c.e<rx.f<? extends rx.e<?>>, rx.f<?>> {

        /* renamed from: a  reason: collision with root package name */
        final rx.c.e<? super rx.f<? extends Throwable>, ? extends rx.f<?>> f5593a;

        public g(rx.c.e<? super rx.f<? extends Throwable>, ? extends rx.f<?>> eVar) {
            this.f5593a = eVar;
        }

        @Override // rx.c.e
        public rx.f<?> a(rx.f<? extends rx.e<?>> fVar) {
            return this.f5593a.a(fVar.c(d.f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InternalObservableUtils.java */
    /* loaded from: classes2.dex */
    public static final class c implements rx.c.e<rx.e<?>, Throwable> {
        c() {
        }

        @Override // rx.c.e
        public Throwable a(rx.e<?> eVar) {
            return eVar.b();
        }
    }
}
