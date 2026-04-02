package rx.g;

import java.util.concurrent.atomic.AtomicReference;
import rx.m;
/* compiled from: BooleanSubscription.java */
/* loaded from: classes2.dex */
public final class a implements m {

    /* renamed from: b  reason: collision with root package name */
    static final rx.c.a f5305b = new rx.c.a() { // from class: rx.g.a.1
        @Override // rx.c.a
        public void a() {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<rx.c.a> f5306a;

    public a() {
        this.f5306a = new AtomicReference<>();
    }

    private a(rx.c.a aVar) {
        this.f5306a = new AtomicReference<>(aVar);
    }

    public static a a(rx.c.a aVar) {
        return new a(aVar);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f5306a.get() == f5305b;
    }

    @Override // rx.m
    public void unsubscribe() {
        rx.c.a andSet;
        if (this.f5306a.get() != f5305b && (andSet = this.f5306a.getAndSet(f5305b)) != null && andSet != f5305b) {
            andSet.a();
        }
    }
}
