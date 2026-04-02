package rx.e;

import java.util.concurrent.ThreadFactory;
/* compiled from: RxJavaSchedulersHook.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final g f5278a = new g();

    public static rx.i a() {
        return a(new rx.internal.util.h("RxComputationScheduler-"));
    }

    public static rx.i a(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.c.b(threadFactory);
    }

    public static rx.i b() {
        return b(new rx.internal.util.h("RxIoScheduler-"));
    }

    public static rx.i b(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.c.a(threadFactory);
    }

    public static rx.i c() {
        return c(new rx.internal.util.h("RxNewThreadScheduler-"));
    }

    public static rx.i c(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.c.g(threadFactory);
    }

    public rx.i d() {
        return null;
    }

    public rx.i e() {
        return null;
    }

    public rx.i f() {
        return null;
    }

    @Deprecated
    public rx.c.a a(rx.c.a aVar) {
        return aVar;
    }

    public static g g() {
        return f5278a;
    }
}
