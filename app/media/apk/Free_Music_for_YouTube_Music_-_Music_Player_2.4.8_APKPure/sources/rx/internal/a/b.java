package rx.internal.a;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.f;
/* compiled from: BufferUntilSubscriber.java */
/* loaded from: classes2.dex */
public final class b<T> extends rx.f.d<T, T> {

    /* renamed from: c  reason: collision with root package name */
    static final rx.g f5316c = new rx.g() { // from class: rx.internal.a.b.1
        @Override // rx.g
        public void onCompleted() {
        }

        @Override // rx.g
        public void onError(Throwable th) {
        }

        @Override // rx.g
        public void onNext(Object obj) {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    final C0110b<T> f5317b;
    private boolean d;

    public static <T> b<T> e() {
        return new b<>(new C0110b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BufferUntilSubscriber.java */
    /* renamed from: rx.internal.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0110b<T> extends AtomicReference<rx.g<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;

        /* renamed from: b  reason: collision with root package name */
        boolean f5321b;

        /* renamed from: a  reason: collision with root package name */
        final Object f5320a = new Object();

        /* renamed from: c  reason: collision with root package name */
        final ConcurrentLinkedQueue<Object> f5322c = new ConcurrentLinkedQueue<>();

        C0110b() {
        }

        boolean a(rx.g<? super T> gVar, rx.g<? super T> gVar2) {
            return compareAndSet(gVar, gVar2);
        }
    }

    /* compiled from: BufferUntilSubscriber.java */
    /* loaded from: classes2.dex */
    static final class a<T> implements f.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final C0110b<T> f5318a;

        public a(C0110b<T> c0110b) {
            this.f5318a = c0110b;
        }

        @Override // rx.c.b
        /* renamed from: a */
        public void call(rx.l<? super T> lVar) {
            boolean z = true;
            if (this.f5318a.a(null, lVar)) {
                lVar.add(rx.g.e.a(new rx.c.a() { // from class: rx.internal.a.b.a.1
                    @Override // rx.c.a
                    public void a() {
                        a.this.f5318a.set(b.f5316c);
                    }
                }));
                synchronized (this.f5318a.f5320a) {
                    if (this.f5318a.f5321b) {
                        z = false;
                    } else {
                        this.f5318a.f5321b = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.f5318a.f5322c.poll();
                    if (poll != null) {
                        d.a(this.f5318a.get(), poll);
                    } else {
                        synchronized (this.f5318a.f5320a) {
                            if (this.f5318a.f5322c.isEmpty()) {
                                this.f5318a.f5321b = false;
                                return;
                            }
                        }
                    }
                }
            } else {
                lVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    private b(C0110b<T> c0110b) {
        super(new a(c0110b));
        this.f5317b = c0110b;
    }

    private void b(Object obj) {
        synchronized (this.f5317b.f5320a) {
            this.f5317b.f5322c.add(obj);
            if (this.f5317b.get() != null && !this.f5317b.f5321b) {
                this.d = true;
                this.f5317b.f5321b = true;
            }
        }
        if (!this.d) {
            return;
        }
        while (true) {
            Object poll = this.f5317b.f5322c.poll();
            if (poll != null) {
                d.a(this.f5317b.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.g
    public void onCompleted() {
        if (this.d) {
            this.f5317b.get().onCompleted();
        } else {
            b(d.a());
        }
    }

    @Override // rx.g
    public void onError(Throwable th) {
        if (this.d) {
            this.f5317b.get().onError(th);
        } else {
            b(d.a(th));
        }
    }

    @Override // rx.g
    public void onNext(T t) {
        if (this.d) {
            this.f5317b.get().onNext(t);
        } else {
            b(d.a(t));
        }
    }
}
