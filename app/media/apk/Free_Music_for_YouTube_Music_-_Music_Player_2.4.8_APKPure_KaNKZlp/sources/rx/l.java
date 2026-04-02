package rx;
/* compiled from: Subscriber.java */
/* loaded from: classes2.dex */
public abstract class l<T> implements g<T>, m {
    private static final long NOT_SET = Long.MIN_VALUE;
    private h producer;
    private long requested;
    private final l<?> subscriber;
    private final rx.internal.util.j subscriptions;

    /* JADX INFO: Access modifiers changed from: protected */
    public l() {
        this(null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l(l<?> lVar) {
        this(lVar, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l(l<?> lVar, boolean z) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = lVar;
        this.subscriptions = (!z || lVar == null) ? new rx.internal.util.j() : lVar.subscriptions;
    }

    public final void add(m mVar) {
        this.subscriptions.a(mVar);
    }

    @Override // rx.m
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    @Override // rx.m
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + j);
        }
        synchronized (this) {
            if (this.producer != null) {
                this.producer.request(j);
                return;
            }
            addToRequested(j);
        }
    }

    private void addToRequested(long j) {
        if (this.requested == Long.MIN_VALUE) {
            this.requested = j;
            return;
        }
        long j2 = this.requested + j;
        if (j2 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j2;
        }
    }

    public void setProducer(h hVar) {
        long j;
        boolean z = false;
        synchronized (this) {
            j = this.requested;
            this.producer = hVar;
            if (this.subscriber != null && j == Long.MIN_VALUE) {
                z = true;
            }
        }
        if (z) {
            this.subscriber.setProducer(this.producer);
        } else if (j == Long.MIN_VALUE) {
            this.producer.request(Long.MAX_VALUE);
        } else {
            this.producer.request(j);
        }
    }
}
