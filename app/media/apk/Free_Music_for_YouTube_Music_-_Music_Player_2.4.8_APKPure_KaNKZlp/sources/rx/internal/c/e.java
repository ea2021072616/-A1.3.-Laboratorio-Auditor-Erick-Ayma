package rx.internal.c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
/* compiled from: GenericScheduledExecutorServiceFactory.java */
/* loaded from: classes2.dex */
enum e {
    ;
    

    /* renamed from: a  reason: collision with root package name */
    static final rx.internal.util.h f5519a = new rx.internal.util.h("RxScheduledExecutorPool-");

    static ThreadFactory a() {
        return f5519a;
    }

    public static ScheduledExecutorService b() {
        rx.c.d<? extends ScheduledExecutorService> c2 = rx.e.c.c();
        return c2 == null ? c() : c2.call();
    }

    static ScheduledExecutorService c() {
        return Executors.newScheduledThreadPool(1, a());
    }
}
