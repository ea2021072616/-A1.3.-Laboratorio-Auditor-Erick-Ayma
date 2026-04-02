package rx.internal.c;

import java.util.concurrent.ThreadFactory;
import rx.i;
/* compiled from: NewThreadScheduler.java */
/* loaded from: classes2.dex */
public final class g extends rx.i {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f5524a;

    public g(ThreadFactory threadFactory) {
        this.f5524a = threadFactory;
    }

    @Override // rx.i
    public i.a createWorker() {
        return new h(this.f5524a);
    }
}
