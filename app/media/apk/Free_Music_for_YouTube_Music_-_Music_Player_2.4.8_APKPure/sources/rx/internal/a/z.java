package rx.internal.a;

import java.util.NoSuchElementException;
import rx.f;
import rx.j;
/* compiled from: SingleFromObservable.java */
/* loaded from: classes2.dex */
public final class z<T> implements j.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final f.a<T> f5468a;

    public z(f.a<T> aVar) {
        this.f5468a = aVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.a((rx.m) aVar);
        this.f5468a.call(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleFromObservable.java */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.k<? super T> f5469a;

        /* renamed from: b  reason: collision with root package name */
        T f5470b;

        /* renamed from: c  reason: collision with root package name */
        int f5471c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(rx.k<? super T> kVar) {
            this.f5469a = kVar;
        }

        @Override // rx.g
        public void onNext(T t) {
            int i = this.f5471c;
            if (i == 0) {
                this.f5471c = 1;
                this.f5470b = t;
            } else if (i == 1) {
                this.f5471c = 2;
                this.f5469a.a((Throwable) new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            if (this.f5471c == 2) {
                rx.e.c.a(th);
                return;
            }
            this.f5470b = null;
            this.f5469a.a(th);
        }

        @Override // rx.g
        public void onCompleted() {
            int i = this.f5471c;
            if (i == 0) {
                this.f5469a.a((Throwable) new NoSuchElementException());
            } else if (i == 1) {
                this.f5471c = 2;
                T t = this.f5470b;
                this.f5470b = null;
                this.f5469a.a((rx.k<? super T>) t);
            }
        }
    }
}
