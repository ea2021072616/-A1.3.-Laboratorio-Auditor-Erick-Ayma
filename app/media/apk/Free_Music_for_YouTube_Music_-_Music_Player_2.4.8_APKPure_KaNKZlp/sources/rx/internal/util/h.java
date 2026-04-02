package rx.internal.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: RxThreadFactory.java */
/* loaded from: classes2.dex */
public final class h extends AtomicLong implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadFactory f5600a = new ThreadFactory() { // from class: rx.internal.util.h.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    };
    private static final long serialVersionUID = -8841098858898482335L;

    /* renamed from: b  reason: collision with root package name */
    final String f5601b;

    public h(String str) {
        this.f5601b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f5601b + incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
