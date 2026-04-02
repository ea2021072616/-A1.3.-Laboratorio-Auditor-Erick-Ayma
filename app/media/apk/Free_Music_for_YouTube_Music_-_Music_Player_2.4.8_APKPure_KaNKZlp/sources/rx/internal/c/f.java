package rx.internal.c;

import java.util.concurrent.TimeUnit;
import rx.i;
/* compiled from: ImmediateScheduler.java */
/* loaded from: classes2.dex */
public final class f extends rx.i {

    /* renamed from: a  reason: collision with root package name */
    public static final f f5521a = new f();

    private f() {
    }

    @Override // rx.i
    public i.a createWorker() {
        return new a();
    }

    /* compiled from: ImmediateScheduler.java */
    /* loaded from: classes2.dex */
    final class a extends i.a implements rx.m {

        /* renamed from: a  reason: collision with root package name */
        final rx.g.a f5522a = new rx.g.a();

        a() {
        }

        @Override // rx.i.a
        public rx.m a(rx.c.a aVar, long j, TimeUnit timeUnit) {
            return a(new m(aVar, this, f.this.now() + timeUnit.toMillis(j)));
        }

        @Override // rx.i.a
        public rx.m a(rx.c.a aVar) {
            aVar.a();
            return rx.g.e.a();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f5522a.unsubscribe();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5522a.isUnsubscribed();
        }
    }
}
