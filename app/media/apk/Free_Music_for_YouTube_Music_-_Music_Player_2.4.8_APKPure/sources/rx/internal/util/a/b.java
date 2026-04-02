package rx.internal.util.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: LinkedQueueNode.java */
/* loaded from: classes2.dex */
public final class b<E> extends AtomicReference<b<E>> {
    private static final long serialVersionUID = 2404266111789071508L;

    /* renamed from: a  reason: collision with root package name */
    private E f5575a;

    public b() {
    }

    public b(E e) {
        a((b<E>) e);
    }

    public E a() {
        E b2 = b();
        a((b<E>) null);
        return b2;
    }

    public E b() {
        return this.f5575a;
    }

    public void a(E e) {
        this.f5575a = e;
    }

    public void a(b<E> bVar) {
        lazySet(bVar);
    }

    public b<E> c() {
        return get();
    }
}
