package x4;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public final class k extends FutureTask {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f5530b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, Callable callable) {
        super(callable);
        this.f5530b = lVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        try {
            this.f5530b.g((a) get());
        } catch (CancellationException | Exception unused) {
        }
    }
}
