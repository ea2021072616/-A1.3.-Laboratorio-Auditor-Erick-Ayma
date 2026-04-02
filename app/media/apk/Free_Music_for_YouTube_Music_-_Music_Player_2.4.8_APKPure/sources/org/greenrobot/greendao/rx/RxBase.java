package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.annotation.apihint.Internal;
import rx.f;
import rx.i;
/* JADX INFO: Access modifiers changed from: package-private */
@Internal
/* loaded from: classes2.dex */
public class RxBase {
    protected final i scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxBase() {
        this.scheduler = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Experimental
    public RxBase(i iVar) {
        this.scheduler = iVar;
    }

    @Experimental
    public i getScheduler() {
        return this.scheduler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <R> f<R> wrap(Callable<R> callable) {
        return wrap(RxUtils.fromCallable(callable));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <R> f<R> wrap(f<R> fVar) {
        if (this.scheduler != null) {
            return fVar.b(this.scheduler);
        }
        return fVar;
    }
}
