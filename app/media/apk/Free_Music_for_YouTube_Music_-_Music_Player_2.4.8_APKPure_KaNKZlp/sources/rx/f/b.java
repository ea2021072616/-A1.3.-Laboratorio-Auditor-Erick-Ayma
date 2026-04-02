package rx.f;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.f;
import rx.g;
import rx.h;
import rx.l;
import rx.m;
/* compiled from: PublishSubject.java */
/* loaded from: classes2.dex */
public final class b<T> extends d<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final C0109b<T> f5284b;

    public static <T> b<T> e() {
        return new b<>(new C0109b());
    }

    protected b(C0109b<T> c0109b) {
        super(c0109b);
        this.f5284b = c0109b;
    }

    @Override // rx.g
    public void onNext(T t) {
        this.f5284b.onNext(t);
    }

    @Override // rx.g
    public void onError(Throwable th) {
        this.f5284b.onError(th);
    }

    @Override // rx.g
    public void onCompleted() {
        this.f5284b.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublishSubject.java */
    /* renamed from: rx.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0109b<T> extends AtomicReference<a<T>[]> implements f.a<T>, g<T> {

        /* renamed from: a  reason: collision with root package name */
        static final a[] f5288a = new a[0];

        /* renamed from: b  reason: collision with root package name */
        static final a[] f5289b = new a[0];
        private static final long serialVersionUID = -7568940796666027140L;

        /* renamed from: c  reason: collision with root package name */
        Throwable f5290c;

        public C0109b() {
            lazySet(f5288a);
        }

        @Override // rx.c.b
        /* renamed from: a */
        public void call(l<? super T> lVar) {
            a<T> aVar = new a<>(this, lVar);
            lVar.add(aVar);
            lVar.setProducer(aVar);
            if (a(aVar)) {
                if (aVar.isUnsubscribed()) {
                    b(aVar);
                    return;
                }
                return;
            }
            Throwable th = this.f5290c;
            if (th != null) {
                lVar.onError(th);
            } else {
                lVar.onCompleted();
            }
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == f5289b) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        void b(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr != f5289b && aVarArr != f5288a) {
                    int length = aVarArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (aVarArr[i2] == aVar) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            aVarArr2 = f5288a;
                        } else {
                            aVarArr2 = new a[length - 1];
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, i);
                            System.arraycopy(aVarArr, i + 1, aVarArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }

        @Override // rx.g
        public void onNext(T t) {
            for (a<T> aVar : get()) {
                aVar.onNext(t);
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            this.f5290c = th;
            ArrayList arrayList = null;
            for (a<T> aVar : getAndSet(f5289b)) {
                try {
                    aVar.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th2);
                }
            }
            rx.b.b.a(arrayList);
        }

        @Override // rx.g
        public void onCompleted() {
            for (a<T> aVar : getAndSet(f5289b)) {
                aVar.onCompleted();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublishSubject.java */
    /* loaded from: classes2.dex */
    public static final class a<T> extends AtomicLong implements g<T>, h, m {
        private static final long serialVersionUID = 6451806817170721536L;

        /* renamed from: a  reason: collision with root package name */
        final C0109b<T> f5285a;

        /* renamed from: b  reason: collision with root package name */
        final l<? super T> f5286b;

        /* renamed from: c  reason: collision with root package name */
        long f5287c;

        public a(C0109b<T> c0109b, l<? super T> lVar) {
            this.f5285a = c0109b;
            this.f5286b = lVar;
        }

        @Override // rx.h
        public void request(long j) {
            long j2;
            if (rx.internal.a.a.a(j)) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j2, rx.internal.a.a.a(j2, j)));
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.m
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f5285a.b(this);
            }
        }

        @Override // rx.g
        public void onNext(T t) {
            long j = get();
            if (j != Long.MIN_VALUE) {
                long j2 = this.f5287c;
                if (j != j2) {
                    this.f5287c = 1 + j2;
                    this.f5286b.onNext(t);
                    return;
                }
                unsubscribe();
                this.f5286b.onError(new rx.b.c("PublishSubject: could not emit value due to lack of requests"));
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f5286b.onError(th);
            }
        }

        @Override // rx.g
        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.f5286b.onCompleted();
            }
        }
    }
}
