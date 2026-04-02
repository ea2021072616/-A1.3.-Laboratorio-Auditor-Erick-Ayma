package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
/* compiled from: BackpressureDrainManager.java */
/* loaded from: classes2.dex */
public final class c extends AtomicLong implements rx.h {
    private static final long serialVersionUID = 2826241102729529449L;

    /* renamed from: a  reason: collision with root package name */
    boolean f5586a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f5587b;

    /* renamed from: c  reason: collision with root package name */
    Throwable f5588c;
    final a d;

    /* compiled from: BackpressureDrainManager.java */
    /* loaded from: classes2.dex */
    public interface a {
        Object a();

        void a(Throwable th);

        boolean a(Object obj);

        Object b();
    }

    public c(a aVar) {
        this.d = aVar;
    }

    public void a() {
        this.f5587b = true;
        b();
    }

    public void a(Throwable th) {
        if (!this.f5587b) {
            this.f5588c = th;
            this.f5587b = true;
            b();
        }
    }

    @Override // rx.h
    public void request(long j) {
        long j2;
        boolean z;
        long j3;
        if (j != 0) {
            do {
                j2 = get();
                z = j2 == 0;
                if (j2 == Long.MAX_VALUE) {
                    break;
                } else if (j == Long.MAX_VALUE) {
                    j3 = j;
                    z = true;
                } else {
                    j3 = j2 > Long.MAX_VALUE - j ? Long.MAX_VALUE : j2 + j;
                }
            } while (!compareAndSet(j2, j3));
            if (z) {
                b();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
        if (r3 == 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
        r13.f5586a = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003f, code lost:
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0041, code lost:
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0042, code lost:
        r2 = r13.f5587b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
        if (r6.a() == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004a, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0057, code lost:
        if (get() != Long.MAX_VALUE) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0059, code lost:
        if (r4 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005b, code lost:
        if (r2 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x005f, code lost:
        r13.f5586a = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0061, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0064, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0065, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0066, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0067, code lost:
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007c, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007f, code lost:
        r0 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0084, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0086, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0087, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0089, code lost:
        r0 = addAndGet(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0093, code lost:
        if (r0 == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0095, code lost:
        if (r4 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0097, code lost:
        if (r2 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0099, code lost:
        if (r4 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x009d, code lost:
        r13.f5586a = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x009f, code lost:
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r13 = this;
            monitor-enter(r13)
            boolean r0 = r13.f5586a     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L7
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L38
        L6:
            return
        L7:
            r0 = 1
            r13.f5586a = r0     // Catch: java.lang.Throwable -> L38
            boolean r2 = r13.f5587b     // Catch: java.lang.Throwable -> L38
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L38
            long r0 = r13.get()
            r3 = 0
            rx.internal.util.c$a r6 = r13.d     // Catch: java.lang.Throwable -> L2f
        L14:
            r4 = 0
            r12 = r4
            r4 = r0
            r1 = r12
        L18:
            r8 = 0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 > 0) goto L20
            if (r2 == 0) goto L41
        L20:
            if (r2 == 0) goto L69
            java.lang.Object r0 = r6.a()     // Catch: java.lang.Throwable -> L2f
            if (r0 != 0) goto L3b
            r3 = 1
            java.lang.Throwable r0 = r13.f5588c     // Catch: java.lang.Throwable -> L2f
            r6.a(r0)     // Catch: java.lang.Throwable -> L2f
            goto L6
        L2f:
            r0 = move-exception
        L30:
            if (r3 != 0) goto L37
            monitor-enter(r13)
            r1 = 0
            r13.f5586a = r1     // Catch: java.lang.Throwable -> La2
            monitor-exit(r13)     // Catch: java.lang.Throwable -> La2
        L37:
            throw r0
        L38:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L38
            throw r0
        L3b:
            r8 = 0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 != 0) goto L69
        L41:
            monitor-enter(r13)     // Catch: java.lang.Throwable -> L2f
            boolean r2 = r13.f5587b     // Catch: java.lang.Throwable -> L86
            java.lang.Object r0 = r6.a()     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L7c
            r0 = 1
            r4 = r0
        L4c:
            long r8 = r13.get()     // Catch: java.lang.Throwable -> L86
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 != 0) goto L89
            if (r4 != 0) goto L7f
            if (r2 != 0) goto L7f
            r1 = 1
            r0 = 0
            r13.f5586a = r0     // Catch: java.lang.Throwable -> L63
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L63
            goto L6
        L63:
            r0 = move-exception
        L64:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L63
            throw r0     // Catch: java.lang.Throwable -> L66
        L66:
            r0 = move-exception
            r3 = r1
            goto L30
        L69:
            java.lang.Object r0 = r6.b()     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L41
            boolean r0 = r6.a(r0)     // Catch: java.lang.Throwable -> L2f
            if (r0 != 0) goto L6
            r8 = 1
            long r4 = r4 - r8
            int r0 = r1 + 1
            r1 = r0
            goto L18
        L7c:
            r0 = 0
            r4 = r0
            goto L4c
        L7f:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L84:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L86
            goto L14
        L86:
            r0 = move-exception
            r1 = r3
            goto L64
        L89:
            int r0 = -r1
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L86
            long r0 = r13.addAndGet(r0)     // Catch: java.lang.Throwable -> L86
            r8 = 0
            int r5 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r5 == 0) goto L97
            if (r4 != 0) goto L84
        L97:
            if (r2 == 0) goto L9b
            if (r4 == 0) goto L84
        L9b:
            r1 = 1
            r0 = 0
            r13.f5586a = r0     // Catch: java.lang.Throwable -> L63
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L63
            goto L6
        La2:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> La2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.c.b():void");
    }
}
