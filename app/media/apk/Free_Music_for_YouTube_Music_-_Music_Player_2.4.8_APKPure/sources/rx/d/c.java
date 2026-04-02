package rx.d;

import rx.g;
/* compiled from: SerializedObserver.java */
/* loaded from: classes2.dex */
public class c<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    private final g<? super T> f5256a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5257b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f5258c;
    private a d;

    /* compiled from: SerializedObserver.java */
    /* loaded from: classes2.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        Object[] f5259a;

        /* renamed from: b  reason: collision with root package name */
        int f5260b;

        a() {
        }

        public void a(Object obj) {
            Object[] objArr;
            int i = this.f5260b;
            Object[] objArr2 = this.f5259a;
            if (objArr2 == null) {
                objArr = new Object[16];
                this.f5259a = objArr;
            } else if (i == objArr2.length) {
                objArr = new Object[(i >> 2) + i];
                System.arraycopy(objArr2, 0, objArr, 0, i);
                this.f5259a = objArr;
            } else {
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.f5260b = i + 1;
        }
    }

    public c(g<? super T> gVar) {
        this.f5256a = gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0032, code lost:
        continue;
     */
    @Override // rx.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onNext(T r8) {
        /*
            r7 = this;
            r1 = 0
            r6 = 1
            boolean r0 = r7.f5258c
            if (r0 == 0) goto L7
        L6:
            return
        L7:
            monitor-enter(r7)
            boolean r0 = r7.f5258c     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L11
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Le
            goto L6
        Le:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Le
            throw r0
        L11:
            boolean r0 = r7.f5257b     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L29
            rx.d.c$a r0 = r7.d     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto L20
            rx.d.c$a r0 = new rx.d.c$a     // Catch: java.lang.Throwable -> Le
            r0.<init>()     // Catch: java.lang.Throwable -> Le
            r7.d = r0     // Catch: java.lang.Throwable -> Le
        L20:
            java.lang.Object r1 = rx.internal.a.d.a(r8)     // Catch: java.lang.Throwable -> Le
            r0.a(r1)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Le
            goto L6
        L29:
            r0 = 1
            r7.f5257b = r0     // Catch: java.lang.Throwable -> Le
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Le
            rx.g<? super T> r0 = r7.f5256a     // Catch: java.lang.Throwable -> L3f
            r0.onNext(r8)     // Catch: java.lang.Throwable -> L3f
        L32:
            monitor-enter(r7)
            rx.d.c$a r0 = r7.d     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L48
            r0 = 0
            r7.f5257b = r0     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L3c
            goto L6
        L3c:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L3c
            throw r0
        L3f:
            r0 = move-exception
            r7.f5258c = r6
            rx.g<? super T> r1 = r7.f5256a
            rx.b.b.a(r0, r1, r8)
            goto L6
        L48:
            r2 = 0
            r7.d = r2     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L3c
            java.lang.Object[] r2 = r0.f5259a
            int r3 = r2.length
            r0 = r1
        L50:
            if (r0 >= r3) goto L32
            r4 = r2[r0]
            if (r4 == 0) goto L32
            rx.g<? super T> r5 = r7.f5256a     // Catch: java.lang.Throwable -> L62
            boolean r4 = rx.internal.a.d.a(r5, r4)     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L72
            r0 = 1
            r7.f5258c = r0     // Catch: java.lang.Throwable -> L62
            goto L6
        L62:
            r0 = move-exception
            r7.f5258c = r6
            rx.b.b.b(r0)
            rx.g<? super T> r1 = r7.f5256a
            java.lang.Throwable r0 = rx.b.g.a(r0, r8)
            r1.onError(r0)
            goto L6
        L72:
            int r0 = r0 + 1
            goto L50
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.d.c.onNext(java.lang.Object):void");
    }

    @Override // rx.g
    public void onError(Throwable th) {
        rx.b.b.b(th);
        if (!this.f5258c) {
            synchronized (this) {
                if (!this.f5258c) {
                    this.f5258c = true;
                    if (this.f5257b) {
                        a aVar = this.d;
                        if (aVar == null) {
                            aVar = new a();
                            this.d = aVar;
                        }
                        aVar.a(rx.internal.a.d.a(th));
                        return;
                    }
                    this.f5257b = true;
                    this.f5256a.onError(th);
                }
            }
        }
    }

    @Override // rx.g
    public void onCompleted() {
        if (!this.f5258c) {
            synchronized (this) {
                if (!this.f5258c) {
                    this.f5258c = true;
                    if (this.f5257b) {
                        a aVar = this.d;
                        if (aVar == null) {
                            aVar = new a();
                            this.d = aVar;
                        }
                        aVar.a(rx.internal.a.d.a());
                        return;
                    }
                    this.f5257b = true;
                    this.f5256a.onCompleted();
                }
            }
        }
    }
}
