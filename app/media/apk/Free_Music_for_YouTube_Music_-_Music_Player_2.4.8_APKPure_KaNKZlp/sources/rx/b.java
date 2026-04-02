package rx;
/* compiled from: Completable.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final b f5233a = new b(new a() { // from class: rx.b.1
        @Override // rx.c.b
        /* renamed from: a */
        public void call(c cVar) {
            cVar.a(rx.g.e.a());
            cVar.a();
        }
    }, false);

    /* renamed from: b  reason: collision with root package name */
    static final b f5234b = new b(new a() { // from class: rx.b.3
        @Override // rx.c.b
        /* renamed from: a */
        public void call(c cVar) {
            cVar.a(rx.g.e.a());
        }
    }, false);

    /* renamed from: c  reason: collision with root package name */
    private final a f5235c;

    /* compiled from: Completable.java */
    /* loaded from: classes2.dex */
    public interface a extends rx.c.b<c> {
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0107b extends rx.c.e<c, c> {
    }

    public static b a(a aVar) {
        a(aVar);
        try {
            return new b(aVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            rx.e.c.a(th);
            throw a(th);
        }
    }

    public static b a(final f<?> fVar) {
        a(fVar);
        return a(new a() { // from class: rx.b.2
            @Override // rx.c.b
            /* renamed from: a */
            public void call(final c cVar) {
                l<Object> lVar = new l<Object>() { // from class: rx.b.2.1
                    @Override // rx.g
                    public void onCompleted() {
                        cVar.a();
                    }

                    @Override // rx.g
                    public void onError(Throwable th) {
                        cVar.a(th);
                    }

                    @Override // rx.g
                    public void onNext(Object obj) {
                    }
                };
                cVar.a(lVar);
                f.this.a((l) lVar);
            }
        });
    }

    static <T> T a(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    static NullPointerException a(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    protected b(a aVar) {
        this.f5235c = rx.e.c.a(aVar);
    }

    protected b(a aVar, boolean z) {
        this.f5235c = z ? rx.e.c.a(aVar) : aVar;
    }

    public final m a() {
        final rx.g.c cVar = new rx.g.c();
        a(new c() { // from class: rx.b.4
            @Override // rx.c
            public void a() {
                cVar.unsubscribe();
            }

            @Override // rx.c
            public void a(Throwable th) {
                rx.e.c.a(th);
                cVar.unsubscribe();
                b.b(th);
            }

            @Override // rx.c
            public void a(m mVar) {
                cVar.a(mVar);
            }
        });
        return cVar;
    }

    static void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public final void a(c cVar) {
        a(cVar);
        try {
            rx.e.c.a(this, this.f5235c).call(cVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            rx.b.b.b(th);
            Throwable d = rx.e.c.d(th);
            rx.e.c.a(d);
            throw a(d);
        }
    }
}
