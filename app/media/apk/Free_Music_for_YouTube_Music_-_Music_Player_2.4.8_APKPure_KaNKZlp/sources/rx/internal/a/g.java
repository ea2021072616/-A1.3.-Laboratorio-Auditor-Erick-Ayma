package rx.internal.a;

import java.util.Arrays;
import rx.f;
/* compiled from: OnSubscribeDoOnEach.java */
/* loaded from: classes2.dex */
public class g<T> implements f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.g<? super T> f5338a;

    /* renamed from: b  reason: collision with root package name */
    private final rx.f<T> f5339b;

    public g(rx.f<T> fVar, rx.g<? super T> gVar) {
        this.f5339b = fVar;
        this.f5338a = gVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.l<? super T> lVar) {
        this.f5339b.a((rx.l) new a(lVar, this.f5338a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OnSubscribeDoOnEach.java */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.l<? super T> f5340a;

        /* renamed from: b  reason: collision with root package name */
        private final rx.g<? super T> f5341b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5342c;

        a(rx.l<? super T> lVar, rx.g<? super T> gVar) {
            super(lVar);
            this.f5340a = lVar;
            this.f5341b = gVar;
        }

        @Override // rx.g
        public void onCompleted() {
            if (!this.f5342c) {
                try {
                    this.f5341b.onCompleted();
                    this.f5342c = true;
                    this.f5340a.onCompleted();
                } catch (Throwable th) {
                    rx.b.b.a(th, this);
                }
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            if (this.f5342c) {
                rx.e.c.a(th);
                return;
            }
            this.f5342c = true;
            try {
                this.f5341b.onError(th);
                this.f5340a.onError(th);
            } catch (Throwable th2) {
                rx.b.b.b(th2);
                this.f5340a.onError(new rx.b.a(Arrays.asList(th, th2)));
            }
        }

        @Override // rx.g
        public void onNext(T t) {
            if (!this.f5342c) {
                try {
                    this.f5341b.onNext(t);
                    this.f5340a.onNext(t);
                } catch (Throwable th) {
                    rx.b.b.a(th, this, t);
                }
            }
        }
    }
}
