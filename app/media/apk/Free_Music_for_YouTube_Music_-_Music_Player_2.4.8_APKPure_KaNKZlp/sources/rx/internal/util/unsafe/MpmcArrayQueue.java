package rx.internal.util.unsafe;
/* loaded from: classes2.dex */
public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> {
    long p30;
    long p31;
    long p32;
    long p33;
    long p34;
    long p35;
    long p36;
    long p37;
    long p40;
    long p41;
    long p42;
    long p43;
    long p44;
    long p45;
    long p46;

    public MpmcArrayQueue(int i) {
        super(Math.max(2, i));
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long j = this.mask + 1;
        long[] jArr = this.sequenceBuffer;
        long j2 = Long.MAX_VALUE;
        while (true) {
            long j3 = j2;
            long lvProducerIndex = lvProducerIndex();
            long calcSequenceOffset = calcSequenceOffset(lvProducerIndex);
            long lvSequence = lvSequence(jArr, calcSequenceOffset) - lvProducerIndex;
            if (lvSequence == 0) {
                if (casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
                    spElement(calcElementOffset(lvProducerIndex), e);
                    soSequence(jArr, calcSequenceOffset, 1 + lvProducerIndex);
                    return true;
                }
            } else if (lvSequence < 0 && lvProducerIndex - j <= j3) {
                j3 = lvConsumerIndex();
                if (lvProducerIndex - j <= j3) {
                    return false;
                }
            }
            j2 = j3;
        }
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long[] jArr = this.sequenceBuffer;
        long j = -1;
        while (true) {
            long j2 = j;
            long lvConsumerIndex = lvConsumerIndex();
            long calcSequenceOffset = calcSequenceOffset(lvConsumerIndex);
            long lvSequence = lvSequence(jArr, calcSequenceOffset) - (1 + lvConsumerIndex);
            if (lvSequence == 0) {
                if (casConsumerIndex(lvConsumerIndex, 1 + lvConsumerIndex)) {
                    long calcElementOffset = calcElementOffset(lvConsumerIndex);
                    E lpElement = lpElement(calcElementOffset);
                    spElement(calcElementOffset, null);
                    soSequence(jArr, calcSequenceOffset, this.mask + lvConsumerIndex + 1);
                    return lpElement;
                }
            } else if (lvSequence < 0 && lvConsumerIndex >= j2) {
                j2 = lvProducerIndex();
                if (lvConsumerIndex == j2) {
                    return null;
                }
            }
            j = j2;
        }
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        long lvConsumerIndex;
        E lpElement;
        do {
            lvConsumerIndex = lvConsumerIndex();
            lpElement = lpElement(calcElementOffset(lvConsumerIndex));
            if (lpElement != null) {
                break;
            }
        } while (lvConsumerIndex != lvProducerIndex());
        return lpElement;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }
}
