package rx.f;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.f;
import rx.g;
import rx.l;
/* compiled from: SubjectSubscriptionManager.java */
/* loaded from: classes2.dex */
final class e<T> extends AtomicReference<a<T>> implements f.a<T> {
    private static final long serialVersionUID = 6035251036011671568L;

    /* renamed from: a  reason: collision with root package name */
    volatile Object f5294a;

    /* renamed from: b  reason: collision with root package name */
    boolean f5295b;

    /* renamed from: c  reason: collision with root package name */
    rx.c.b<b<T>> f5296c;
    rx.c.b<b<T>> d;
    rx.c.b<b<T>> e;

    @Override // rx.c.b
    public /* synthetic */ void call(Object obj) {
        a((l) ((l) obj));
    }

    public e() {
        super(a.e);
        this.f5295b = true;
        this.f5296c = rx.c.c.a();
        this.d = rx.c.c.a();
        this.e = rx.c.c.a();
    }

    public void a(l<? super T> lVar) {
        b<T> bVar = new b<>(lVar);
        a(lVar, bVar);
        this.f5296c.call(bVar);
        if (!lVar.isUnsubscribed() && a((b) bVar) && lVar.isUnsubscribed()) {
            b((b) bVar);
        }
    }

    void a(l<? super T> lVar, final b<T> bVar) {
        lVar.add(rx.g.e.a(new rx.c.a() { // from class: rx.f.e.1
            @Override // rx.c.a
            public void a() {
                e.this.b((b) bVar);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj) {
        this.f5294a = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a() {
        return this.f5294a;
    }

    boolean a(b<T> bVar) {
        a<T> aVar;
        do {
            aVar = get();
            if (aVar.f5300a) {
                this.e.call(bVar);
                return false;
            }
        } while (!compareAndSet(aVar, aVar.a(bVar)));
        this.d.call(bVar);
        return true;
    }

    void b(b<T> bVar) {
        a<T> aVar;
        a<T> b2;
        do {
            aVar = get();
            if (aVar.f5300a || (b2 = aVar.b(bVar)) == aVar) {
                return;
            }
        } while (!compareAndSet(aVar, b2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b<T>[] b(Object obj) {
        a(obj);
        return get().f5301b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b<T>[] c(Object obj) {
        a(obj);
        this.f5295b = false;
        return get().f5300a ? a.f5299c : getAndSet(a.d).f5301b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: SubjectSubscriptionManager.java */
    /* loaded from: classes2.dex */
    public static final class a<T> {

        /* renamed from: c  reason: collision with root package name */
        static final b[] f5299c = new b[0];
        static final a d = new a(true, f5299c);
        static final a e = new a(false, f5299c);

        /* renamed from: a  reason: collision with root package name */
        final boolean f5300a;

        /* renamed from: b  reason: collision with root package name */
        final b[] f5301b;

        public a(boolean z, b[] bVarArr) {
            this.f5300a = z;
            this.f5301b = bVarArr;
        }

        public a a(b bVar) {
            int length = this.f5301b.length;
            b[] bVarArr = new b[length + 1];
            System.arraycopy(this.f5301b, 0, bVarArr, 0, length);
            bVarArr[length] = bVar;
            return new a(this.f5300a, bVarArr);
        }

        public a b(b bVar) {
            b[] bVarArr;
            int i;
            b[] bVarArr2 = this.f5301b;
            int length = bVarArr2.length;
            if (length == 1 && bVarArr2[0] == bVar) {
                return e;
            }
            if (length != 0) {
                b[] bVarArr3 = new b[length - 1];
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    b bVar2 = bVarArr2[i2];
                    if (bVar2 == bVar) {
                        i = i3;
                    } else if (i3 != length - 1) {
                        i = i3 + 1;
                        bVarArr3[i3] = bVar2;
                    } else {
                        return this;
                    }
                    i2++;
                    i3 = i;
                }
                if (i3 == 0) {
                    return e;
                }
                if (i3 < length - 1) {
                    bVarArr = new b[i3];
                    System.arraycopy(bVarArr3, 0, bVarArr, 0, i3);
                } else {
                    bVarArr = bVarArr3;
                }
                return new a(this.f5300a, bVarArr);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: SubjectSubscriptionManager.java */
    /* loaded from: classes2.dex */
    public static final class b<T> implements g<T> {

        /* renamed from: a  reason: collision with root package name */
        final l<? super T> f5302a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5303b = true;

        /* renamed from: c  reason: collision with root package name */
        boolean f5304c;
        List<Object> d;
        boolean e;

        public b(l<? super T> lVar) {
            this.f5302a = lVar;
        }

        @Override // rx.g
        public void onNext(T t) {
            this.f5302a.onNext(t);
        }

        @Override // rx.g
        public void onError(Throwable th) {
            this.f5302a.onError(th);
        }

        @Override // rx.g
        public void onCompleted() {
            this.f5302a.onCompleted();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Object obj) {
            if (!this.e) {
                synchronized (this) {
                    this.f5303b = false;
                    if (this.f5304c) {
                        if (this.d == null) {
                            this.d = new ArrayList();
                        }
                        this.d.add(obj);
                        return;
                    }
                    this.e = true;
                }
            }
            rx.internal.a.d.a(this.f5302a, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(Object obj) {
            synchronized (this) {
                if (this.f5303b && !this.f5304c) {
                    this.f5303b = false;
                    this.f5304c = obj != null;
                    if (obj != null) {
                        a(null, obj);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(java.util.List<java.lang.Object> r6, java.lang.Object r7) {
            /*
                r5 = this;
                r1 = 1
                r2 = 0
                r0 = r1
            L3:
                if (r6 == 0) goto L20
                java.util.Iterator r3 = r6.iterator()     // Catch: java.lang.Throwable -> L17
            L9:
                boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L17
                if (r4 == 0) goto L20
                java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L17
                r5.c(r4)     // Catch: java.lang.Throwable -> L17
                goto L9
            L17:
                r0 = move-exception
            L18:
                if (r2 != 0) goto L1f
                monitor-enter(r5)
                r1 = 0
                r5.f5304c = r1     // Catch: java.lang.Throwable -> L3c
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L3c
            L1f:
                throw r0
            L20:
                if (r0 == 0) goto L26
                r5.c(r7)     // Catch: java.lang.Throwable -> L17
                r0 = r2
            L26:
                monitor-enter(r5)     // Catch: java.lang.Throwable -> L17
                java.util.List<java.lang.Object> r6 = r5.d     // Catch: java.lang.Throwable -> L35
                r3 = 0
                r5.d = r3     // Catch: java.lang.Throwable -> L35
                if (r6 != 0) goto L33
                r0 = 0
                r5.f5304c = r0     // Catch: java.lang.Throwable -> L35
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L3f
                return
            L33:
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L35
                goto L3
            L35:
                r0 = move-exception
                r1 = r2
            L37:
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L3f
                throw r0     // Catch: java.lang.Throwable -> L39
            L39:
                r0 = move-exception
                r2 = r1
                goto L18
            L3c:
                r0 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L3c
                throw r0
            L3f:
                r0 = move-exception
                goto L37
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.f.e.b.a(java.util.List, java.lang.Object):void");
        }

        void c(Object obj) {
            if (obj != null) {
                rx.internal.a.d.a(this.f5302a, obj);
            }
        }
    }
}
