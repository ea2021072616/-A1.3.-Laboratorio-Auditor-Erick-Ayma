package rx.internal.d;

import java.util.concurrent.atomic.AtomicReference;
import rx.m;
/* compiled from: SequentialSubscription.java */
/* loaded from: classes2.dex */
public final class a extends AtomicReference<m> implements m {
    private static final long serialVersionUID = 995205034283130269L;

    public a() {
    }

    public a(m mVar) {
        lazySet(mVar);
    }

    public boolean a(m mVar) {
        m mVar2;
        do {
            mVar2 = get();
            if (mVar2 == b.INSTANCE) {
                if (mVar != null) {
                    mVar.unsubscribe();
                }
                return false;
            }
        } while (!compareAndSet(mVar2, mVar));
        if (mVar2 != null) {
            mVar2.unsubscribe();
        }
        return true;
    }

    public boolean b(m mVar) {
        m mVar2;
        do {
            mVar2 = get();
            if (mVar2 == b.INSTANCE) {
                if (mVar != null) {
                    mVar.unsubscribe();
                }
                return false;
            }
        } while (!compareAndSet(mVar2, mVar));
        return true;
    }

    @Override // rx.m
    public void unsubscribe() {
        m andSet;
        if (get() != b.INSTANCE && (andSet = getAndSet(b.INSTANCE)) != null && andSet != b.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return get() == b.INSTANCE;
    }
}
