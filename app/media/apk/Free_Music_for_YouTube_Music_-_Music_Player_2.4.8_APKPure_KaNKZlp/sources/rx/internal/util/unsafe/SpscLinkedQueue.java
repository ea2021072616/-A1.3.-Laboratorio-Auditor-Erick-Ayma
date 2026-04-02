package rx.internal.util.unsafe;

import rx.internal.util.a.b;
/* loaded from: classes2.dex */
public final class SpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public SpscLinkedQueue() {
        spProducerNode(new b<>());
        spConsumerNode(this.producerNode);
        this.consumerNode.a((b) null);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        b<E> bVar = new b<>(e);
        this.producerNode.a((b) bVar);
        this.producerNode = bVar;
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        b<E> c2 = this.consumerNode.c();
        if (c2 != null) {
            E a2 = c2.a();
            this.consumerNode = c2;
            return a2;
        }
        return null;
    }

    @Override // java.util.Queue
    public E peek() {
        b<E> c2 = this.consumerNode.c();
        if (c2 != null) {
            return c2.b();
        }
        return null;
    }
}
