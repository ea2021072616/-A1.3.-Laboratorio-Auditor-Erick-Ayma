package rx.internal.c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.b;
import rx.i;
/* compiled from: SchedulerWhen.java */
/* loaded from: classes2.dex */
public class l extends rx.i implements rx.m {

    /* renamed from: a  reason: collision with root package name */
    static final rx.m f5540a = new rx.m() { // from class: rx.internal.c.l.3
        @Override // rx.m
        public void unsubscribe() {
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return false;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final rx.m f5541b = rx.g.e.a();

    /* renamed from: c  reason: collision with root package name */
    private final rx.i f5542c;
    private final rx.g<rx.f<rx.b>> d;
    private final rx.m e;

    public l(rx.c.e<rx.f<rx.f<rx.b>>, rx.b> eVar, rx.i iVar) {
        this.f5542c = iVar;
        rx.f.b e = rx.f.b.e();
        this.d = new rx.d.c(e);
        this.e = eVar.a(e.d()).a();
    }

    @Override // rx.m
    public void unsubscribe() {
        this.e.unsubscribe();
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.e.isUnsubscribed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.i
    public i.a createWorker() {
        final i.a createWorker = this.f5542c.createWorker();
        rx.internal.a.b e = rx.internal.a.b.e();
        final rx.d.c cVar = new rx.d.c(e);
        Object c2 = e.c(new rx.c.e<d, rx.b>() { // from class: rx.internal.c.l.1
            @Override // rx.c.e
            public rx.b a(final d dVar) {
                return rx.b.a(new b.a() { // from class: rx.internal.c.l.1.1
                    @Override // rx.c.b
                    /* renamed from: a */
                    public void call(rx.c cVar2) {
                        cVar2.a(dVar);
                        dVar.b(createWorker, cVar2);
                    }
                });
            }
        });
        i.a aVar = new i.a() { // from class: rx.internal.c.l.2
            private final AtomicBoolean d = new AtomicBoolean();

            @Override // rx.m
            public void unsubscribe() {
                if (this.d.compareAndSet(false, true)) {
                    createWorker.unsubscribe();
                    cVar.onCompleted();
                }
            }

            @Override // rx.m
            public boolean isUnsubscribed() {
                return this.d.get();
            }

            @Override // rx.i.a
            public rx.m a(rx.c.a aVar2, long j, TimeUnit timeUnit) {
                a aVar3 = new a(aVar2, j, timeUnit);
                cVar.onNext(aVar3);
                return aVar3;
            }

            @Override // rx.i.a
            public rx.m a(rx.c.a aVar2) {
                b bVar = new b(aVar2);
                cVar.onNext(bVar);
                return bVar;
            }
        };
        this.d.onNext(c2);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes2.dex */
    public static abstract class d extends AtomicReference<rx.m> implements rx.m {
        protected abstract rx.m a(i.a aVar, rx.c cVar);

        public d() {
            super(l.f5540a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(i.a aVar, rx.c cVar) {
            rx.m mVar = get();
            if (mVar != l.f5541b && mVar == l.f5540a) {
                rx.m a2 = a(aVar, cVar);
                if (!compareAndSet(l.f5540a, a2)) {
                    a2.unsubscribe();
                }
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            rx.m mVar;
            rx.m mVar2 = l.f5541b;
            do {
                mVar = get();
                if (mVar == l.f5541b) {
                    return;
                }
            } while (!compareAndSet(mVar, mVar2));
            if (mVar != l.f5540a) {
                mVar.unsubscribe();
            }
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes2.dex */
    static class b extends d {

        /* renamed from: a  reason: collision with root package name */
        private final rx.c.a f5553a;

        public b(rx.c.a aVar) {
            this.f5553a = aVar;
        }

        @Override // rx.internal.c.l.d
        protected rx.m a(i.a aVar, rx.c cVar) {
            return aVar.a(new c(this.f5553a, cVar));
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes2.dex */
    static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private final rx.c.a f5550a;

        /* renamed from: b  reason: collision with root package name */
        private final long f5551b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f5552c;

        public a(rx.c.a aVar, long j, TimeUnit timeUnit) {
            this.f5550a = aVar;
            this.f5551b = j;
            this.f5552c = timeUnit;
        }

        @Override // rx.internal.c.l.d
        protected rx.m a(i.a aVar, rx.c cVar) {
            return aVar.a(new c(this.f5550a, cVar), this.f5551b, this.f5552c);
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes2.dex */
    static class c implements rx.c.a {

        /* renamed from: a  reason: collision with root package name */
        private rx.c f5554a;

        /* renamed from: b  reason: collision with root package name */
        private rx.c.a f5555b;

        public c(rx.c.a aVar, rx.c cVar) {
            this.f5555b = aVar;
            this.f5554a = cVar;
        }

        @Override // rx.c.a
        public void a() {
            try {
                this.f5555b.a();
            } finally {
                this.f5554a.a();
            }
        }
    }
}
