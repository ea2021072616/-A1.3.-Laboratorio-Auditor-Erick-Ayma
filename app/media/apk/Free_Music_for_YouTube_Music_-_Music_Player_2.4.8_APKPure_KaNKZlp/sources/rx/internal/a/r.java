package rx.internal.a;

import java.util.concurrent.TimeUnit;
import rx.f;
import rx.i;
/* compiled from: OperatorDebounceWithTime.java */
/* loaded from: classes2.dex */
public final class r<T> implements f.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f5399a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f5400b;

    /* renamed from: c  reason: collision with root package name */
    final rx.i f5401c;

    @Override // rx.c.e
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((rx.l) ((rx.l) obj));
    }

    public r(long j, TimeUnit timeUnit, rx.i iVar) {
        this.f5399a = j;
        this.f5400b = timeUnit;
        this.f5401c = iVar;
    }

    public rx.l<? super T> a(rx.l<? super T> lVar) {
        i.a createWorker = this.f5401c.createWorker();
        rx.d.d dVar = new rx.d.d(lVar);
        rx.g.d dVar2 = new rx.g.d();
        dVar.add(createWorker);
        dVar.add(dVar2);
        return new AnonymousClass1(lVar, dVar2, createWorker, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDebounceWithTime.java */
    /* renamed from: rx.internal.a.r$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final a<T> f5402a;

        /* renamed from: b  reason: collision with root package name */
        final rx.l<?> f5403b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.g.d f5404c;
        final /* synthetic */ i.a d;
        final /* synthetic */ rx.d.d e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(rx.l lVar, rx.g.d dVar, i.a aVar, rx.d.d dVar2) {
            super(lVar);
            this.f5404c = dVar;
            this.d = aVar;
            this.e = dVar2;
            this.f5402a = new a<>();
            this.f5403b = this;
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.g
        public void onNext(T t) {
            final int a2 = this.f5402a.a(t);
            this.f5404c.a(this.d.a(new rx.c.a() { // from class: rx.internal.a.r.1.1
                @Override // rx.c.a
                public void a() {
                    AnonymousClass1.this.f5402a.a(a2, AnonymousClass1.this.e, AnonymousClass1.this.f5403b);
                }
            }, r.this.f5399a, r.this.f5400b));
        }

        @Override // rx.g
        public void onError(Throwable th) {
            this.e.onError(th);
            unsubscribe();
            this.f5402a.a();
        }

        @Override // rx.g
        public void onCompleted() {
            this.f5402a.a(this.e, this);
        }
    }

    /* compiled from: OperatorDebounceWithTime.java */
    /* loaded from: classes2.dex */
    static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        int f5407a;

        /* renamed from: b  reason: collision with root package name */
        T f5408b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5409c;
        boolean d;
        boolean e;

        a() {
        }

        public synchronized int a(T t) {
            int i;
            this.f5408b = t;
            this.f5409c = true;
            i = this.f5407a + 1;
            this.f5407a = i;
            return i;
        }

        public void a(int i, rx.l<T> lVar, rx.l<?> lVar2) {
            synchronized (this) {
                if (!this.e && this.f5409c && i == this.f5407a) {
                    T t = this.f5408b;
                    this.f5408b = null;
                    this.f5409c = false;
                    this.e = true;
                    try {
                        lVar.onNext(t);
                        synchronized (this) {
                            if (!this.d) {
                                this.e = false;
                            } else {
                                lVar.onCompleted();
                            }
                        }
                    } catch (Throwable th) {
                        rx.b.b.a(th, lVar2, t);
                    }
                }
            }
        }

        public void a(rx.l<T> lVar, rx.l<?> lVar2) {
            synchronized (this) {
                if (this.e) {
                    this.d = true;
                    return;
                }
                T t = this.f5408b;
                boolean z = this.f5409c;
                this.f5408b = null;
                this.f5409c = false;
                this.e = true;
                if (z) {
                    try {
                        lVar.onNext(t);
                    } catch (Throwable th) {
                        rx.b.b.a(th, lVar2, t);
                        return;
                    }
                }
                lVar.onCompleted();
            }
        }

        public synchronized void a() {
            this.f5407a++;
            this.f5408b = null;
            this.f5409c = false;
        }
    }
}
