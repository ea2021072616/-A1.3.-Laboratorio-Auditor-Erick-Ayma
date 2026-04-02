package rx.internal.a;

import android.support.v7.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.f;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
/* compiled from: OperatorMerge.java */
/* loaded from: classes2.dex */
public final class s<T> implements f.b<T, rx.f<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f5410a;

    /* renamed from: b  reason: collision with root package name */
    final int f5411b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final s<Object> f5412a = new s<>(true, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final s<Object> f5413a = new s<>(false, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @Override // rx.c.e
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((rx.l) ((rx.l) obj));
    }

    public static <T> s<T> a(boolean z) {
        return z ? (s<T>) a.f5412a : (s<T>) b.f5413a;
    }

    s(boolean z, int i) {
        this.f5410a = z;
        this.f5411b = i;
    }

    public rx.l<rx.f<? extends T>> a(rx.l<? super T> lVar) {
        e eVar = new e(lVar, this.f5410a, this.f5411b);
        d<T> dVar = new d<>(eVar);
        eVar.d = dVar;
        lVar.add(eVar);
        lVar.setProducer(dVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes2.dex */
    public static final class d<T> extends AtomicLong implements rx.h {
        private static final long serialVersionUID = -1214379189873595503L;

        /* renamed from: a  reason: collision with root package name */
        final e<T> f5417a;

        public d(e<T> eVar) {
            this.f5417a = eVar;
        }

        @Override // rx.h
        public void request(long j) {
            if (j > 0) {
                if (get() != Long.MAX_VALUE) {
                    rx.internal.a.a.a(this, j);
                    this.f5417a.d();
                }
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }

        public long a(int i) {
            return addAndGet(-i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes2.dex */
    public static final class e<T> extends rx.l<rx.f<? extends T>> {
        static final c<?>[] p = new c[0];

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f5418a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f5419b;

        /* renamed from: c  reason: collision with root package name */
        final int f5420c;
        d<T> d;
        volatile Queue<Object> e;
        volatile rx.g.b f;
        volatile ConcurrentLinkedQueue<Throwable> g;
        volatile boolean h;
        boolean i;
        boolean j;
        final Object k = new Object();
        volatile c<?>[] l = p;
        long m;
        long n;
        int o;
        final int q;
        int r;

        @Override // rx.g
        public /* synthetic */ void onNext(Object obj) {
            a((rx.f) ((rx.f) obj));
        }

        public e(rx.l<? super T> lVar, boolean z, int i) {
            this.f5418a = lVar;
            this.f5419b = z;
            this.f5420c = i;
            if (i == Integer.MAX_VALUE) {
                this.q = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                request(Long.MAX_VALUE);
                return;
            }
            this.q = Math.max(1, i >> 1);
            request(i);
        }

        Queue<Throwable> a() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.g;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.g;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.g = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        rx.g.b b() {
            boolean z;
            rx.g.b bVar = this.f;
            if (bVar == null) {
                synchronized (this) {
                    rx.g.b bVar2 = this.f;
                    if (bVar2 != null) {
                        bVar = bVar2;
                        z = false;
                    } else {
                        rx.g.b bVar3 = new rx.g.b();
                        this.f = bVar3;
                        bVar = bVar3;
                        z = true;
                    }
                }
                if (z) {
                    add(bVar);
                }
            }
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(rx.f<? extends T> fVar) {
            if (fVar != null) {
                if (fVar == rx.f.c()) {
                    c();
                } else if (fVar instanceof rx.internal.util.i) {
                    a((e<T>) ((rx.internal.util.i) fVar).e());
                } else {
                    long j = this.m;
                    this.m = 1 + j;
                    c cVar = new c(this, j);
                    a(cVar);
                    fVar.a((rx.l<? super Object>) cVar);
                    d();
                }
            }
        }

        void c() {
            int i = this.r + 1;
            if (i == this.q) {
                this.r = 0;
                a(i);
                return;
            }
            this.r = i;
        }

        private void g() {
            ArrayList arrayList = new ArrayList(this.g);
            if (arrayList.size() == 1) {
                this.f5418a.onError((Throwable) arrayList.get(0));
            } else {
                this.f5418a.onError(new rx.b.a(arrayList));
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            a().offer(th);
            this.h = true;
            d();
        }

        @Override // rx.g
        public void onCompleted() {
            this.h = true;
            d();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a(c<T> cVar) {
            b().a(cVar);
            synchronized (this.k) {
                c<?>[] cVarArr = this.l;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.l = cVarArr2;
            }
        }

        void b(c<T> cVar) {
            int i = 0;
            rx.internal.util.g gVar = cVar.d;
            if (gVar != null) {
                gVar.c();
            }
            this.f.b(cVar);
            synchronized (this.k) {
                c<?>[] cVarArr = this.l;
                int length = cVarArr.length;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (cVar.equals(cVarArr[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        this.l = p;
                        return;
                    }
                    c<?>[] cVarArr2 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                    System.arraycopy(cVarArr, i + 1, cVarArr2, i, (length - i) - 1);
                    this.l = cVarArr2;
                }
            }
        }

        void a(c<T> cVar, T t) {
            boolean z = false;
            long j = this.d.get();
            if (j != 0) {
                synchronized (this) {
                    j = this.d.get();
                    if (!this.i && j != 0) {
                        this.i = true;
                        z = true;
                    }
                }
            }
            if (z) {
                rx.internal.util.g gVar = cVar.d;
                if (gVar == null || gVar.e()) {
                    a(cVar, t, j);
                    return;
                }
                b(cVar, t);
                e();
                return;
            }
            b(cVar, t);
            d();
        }

        protected void b(c<T> cVar, T t) {
            rx.internal.util.g gVar = cVar.d;
            if (gVar == null) {
                gVar = rx.internal.util.g.a();
                cVar.add(gVar);
                cVar.d = gVar;
            }
            try {
                gVar.a(rx.internal.a.d.a(t));
            } catch (IllegalStateException e) {
                if (!cVar.isUnsubscribed()) {
                    cVar.unsubscribe();
                    cVar.onError(e);
                }
            } catch (rx.b.c e2) {
                cVar.unsubscribe();
                cVar.onError(e2);
            }
        }

        protected void a(c<T> cVar, T t, long j) {
            try {
                this.f5418a.onNext(t);
                if (j != Long.MAX_VALUE) {
                    try {
                        this.d.a(1);
                    } catch (Throwable th) {
                        if (0 == 0) {
                            synchronized (this) {
                                this.i = false;
                            }
                        }
                        throw th;
                    }
                }
                cVar.a(1L);
                synchronized (this) {
                    if (!this.j) {
                        this.i = false;
                        return;
                    }
                    this.j = false;
                    e();
                }
            }
        }

        public void a(long j) {
            request(j);
        }

        void a(T t) {
            boolean z = false;
            long j = this.d.get();
            if (j != 0) {
                synchronized (this) {
                    j = this.d.get();
                    if (!this.i && j != 0) {
                        this.i = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue = this.e;
                if (queue == null || queue.isEmpty()) {
                    a((e<T>) t, j);
                    return;
                }
                b((e<T>) t);
                e();
                return;
            }
            b((e<T>) t);
            d();
        }

        protected void b(T t) {
            Queue<Object> queue = this.e;
            if (queue == null) {
                int i = this.f5420c;
                if (i == Integer.MAX_VALUE) {
                    queue = new rx.internal.util.a.e<>(rx.internal.util.g.f5597b);
                } else if (Pow2.isPowerOfTwo(i)) {
                    if (UnsafeAccess.isUnsafeAvailable()) {
                        queue = new SpscArrayQueue<>(i);
                    } else {
                        queue = new rx.internal.util.a.c<>(i);
                    }
                } else {
                    queue = new rx.internal.util.a.d<>(i);
                }
                this.e = queue;
            }
            if (!queue.offer(rx.internal.a.d.a(t))) {
                unsubscribe();
                onError(rx.b.g.a(new rx.b.c(), t));
            }
        }

        protected void a(T t, long j) {
            try {
                this.f5418a.onNext(t);
                if (j != Long.MAX_VALUE) {
                    this.d.a(1);
                }
                int i = this.r + 1;
                if (i == this.q) {
                    this.r = 0;
                    a(i);
                } else {
                    this.r = i;
                }
                synchronized (this) {
                    try {
                        if (!this.j) {
                            this.i = false;
                        } else {
                            this.j = false;
                            e();
                        }
                    }
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    synchronized (this) {
                        this.i = false;
                    }
                }
                throw th;
            }
        }

        void d() {
            synchronized (this) {
                if (this.i) {
                    this.j = true;
                    return;
                }
                this.i = true;
                e();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x0172 A[Catch: all -> 0x0078, TryCatch #3 {all -> 0x0078, blocks: (B:3:0x0001, B:4:0x0005, B:7:0x000c, B:15:0x002e, B:45:0x0086, B:53:0x00b2, B:25:0x004d, B:28:0x0060, B:31:0x0068, B:33:0x006e, B:54:0x00bb, B:35:0x0074, B:57:0x00c3, B:59:0x00cf, B:73:0x0104, B:75:0x010a, B:79:0x0114, B:81:0x011a, B:118:0x0198, B:120:0x019e, B:85:0x0124, B:86:0x012c, B:90:0x013a, B:93:0x0146, B:95:0x014c, B:97:0x0159, B:101:0x0164, B:103:0x0172, B:105:0x017a, B:67:0x00e1, B:114:0x018d, B:117:0x0194, B:69:0x00eb, B:121:0x01a2, B:106:0x017b, B:108:0x0181, B:109:0x0187, B:137:0x01d6, B:138:0x01da, B:46:0x008a), top: B:148:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:144:0x01e3  */
        /* JADX WARN: Removed duplicated region for block: B:155:0x017a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:158:0x0005 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00c3 A[Catch: all -> 0x0078, TryCatch #3 {all -> 0x0078, blocks: (B:3:0x0001, B:4:0x0005, B:7:0x000c, B:15:0x002e, B:45:0x0086, B:53:0x00b2, B:25:0x004d, B:28:0x0060, B:31:0x0068, B:33:0x006e, B:54:0x00bb, B:35:0x0074, B:57:0x00c3, B:59:0x00cf, B:73:0x0104, B:75:0x010a, B:79:0x0114, B:81:0x011a, B:118:0x0198, B:120:0x019e, B:85:0x0124, B:86:0x012c, B:90:0x013a, B:93:0x0146, B:95:0x014c, B:97:0x0159, B:101:0x0164, B:103:0x0172, B:105:0x017a, B:67:0x00e1, B:114:0x018d, B:117:0x0194, B:69:0x00eb, B:121:0x01a2, B:106:0x017b, B:108:0x0181, B:109:0x0187, B:137:0x01d6, B:138:0x01da, B:46:0x008a), top: B:148:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void e() {
            /*
                Method dump skipped, instructions count: 490
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.a.s.e.e():void");
        }

        boolean f() {
            if (this.f5418a.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.g;
            if (!this.f5419b && concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                try {
                    g();
                    return true;
                } finally {
                    unsubscribe();
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes2.dex */
    public static final class c<T> extends rx.l<T> {
        static final int f = rx.internal.util.g.f5597b / 4;

        /* renamed from: a  reason: collision with root package name */
        final e<T> f5414a;

        /* renamed from: b  reason: collision with root package name */
        final long f5415b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f5416c;
        volatile rx.internal.util.g d;
        int e;

        public c(e<T> eVar, long j) {
            this.f5414a = eVar;
            this.f5415b = j;
        }

        @Override // rx.l
        public void onStart() {
            this.e = rx.internal.util.g.f5597b;
            request(rx.internal.util.g.f5597b);
        }

        @Override // rx.g
        public void onNext(T t) {
            this.f5414a.a((c<c<T>>) this, (c<T>) t);
        }

        @Override // rx.g
        public void onError(Throwable th) {
            this.f5416c = true;
            this.f5414a.a().offer(th);
            this.f5414a.d();
        }

        @Override // rx.g
        public void onCompleted() {
            this.f5416c = true;
            this.f5414a.d();
        }

        public void a(long j) {
            int i = this.e - ((int) j);
            if (i > f) {
                this.e = i;
                return;
            }
            this.e = rx.internal.util.g.f5597b;
            int i2 = rx.internal.util.g.f5597b - i;
            if (i2 > 0) {
                request(i2);
            }
        }
    }
}
