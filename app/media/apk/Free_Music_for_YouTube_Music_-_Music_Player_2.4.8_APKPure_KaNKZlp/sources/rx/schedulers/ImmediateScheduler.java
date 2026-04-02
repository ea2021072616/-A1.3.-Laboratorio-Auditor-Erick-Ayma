package rx.schedulers;

import rx.i;
@Deprecated
/* loaded from: classes.dex */
public final class ImmediateScheduler extends i {
    private ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }

    @Override // rx.i
    public i.a createWorker() {
        return null;
    }
}
