package rx.internal.util.unsafe;

import rx.internal.util.a.b;
/* loaded from: classes2.dex */
public final class MpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public MpscLinkedQueue() {
        this.consumerNode = new b<>();
        xchgProducerNode(this.consumerNode);
    }

    protected b<E> xchgProducerNode(b<E> bVar) {
        b<E> bVar2;
        do {
            bVar2 = this.producerNode;
        } while (!UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, bVar2, bVar));
        return bVar2;
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        b<E> bVar = new b<>(e);
        xchgProducerNode(bVar).a((b) bVar);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        b<E> c2;
        b<E> lpConsumerNode = lpConsumerNode();
        b<E> c3 = lpConsumerNode.c();
        if (c3 != null) {
            E a2 = c3.a();
            spConsumerNode(c3);
            return a2;
        } else if (lpConsumerNode != lvProducerNode()) {
            do {
                c2 = lpConsumerNode.c();
            } while (c2 == null);
            E a3 = c2.a();
            this.consumerNode = c2;
            return a3;
        } else {
            return null;
        }
    }

    @Override // java.util.Queue
    public E peek() {
        b<E> c2;
        b<E> bVar = this.consumerNode;
        b<E> c3 = bVar.c();
        if (c3 != null) {
            return c3.b();
        }
        if (bVar != lvProducerNode()) {
            do {
                c2 = bVar.c();
            } while (c2 == null);
            return c2.b();
        }
        return null;
    }
}
