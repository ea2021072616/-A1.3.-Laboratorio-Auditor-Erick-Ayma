package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Internal;
import rx.c.d;
import rx.f;
/* JADX INFO: Access modifiers changed from: package-private */
@Internal
/* loaded from: classes2.dex */
public class RxUtils {
    RxUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Internal
    public static <T> f<T> fromCallable(final Callable<T> callable) {
        return f.a((d) new d<f<T>>() { // from class: org.greenrobot.greendao.rx.RxUtils.1
            @Override // rx.c.d, java.util.concurrent.Callable
            public f<T> call() {
                try {
                    return f.a(callable.call());
                } catch (Exception e) {
                    return f.a((Throwable) e);
                }
            }
        });
    }
}
