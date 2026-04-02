package org.greenrobot.greendao.rx;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.query.LazyList;
import org.greenrobot.greendao.query.Query;
import rx.b.b;
import rx.f;
import rx.i;
import rx.l;
@Experimental
/* loaded from: classes2.dex */
public class RxQuery<T> extends RxBase {
    private final Query<T> query;

    @Override // org.greenrobot.greendao.rx.RxBase
    @Experimental
    public /* bridge */ /* synthetic */ i getScheduler() {
        return super.getScheduler();
    }

    public RxQuery(Query<T> query) {
        this.query = query;
    }

    public RxQuery(Query<T> query, i iVar) {
        super(iVar);
        this.query = query;
    }

    @Experimental
    public f<List<T>> list() {
        return (f<List<T>>) wrap((Callable<List<T>>) new Callable<List<T>>() { // from class: org.greenrobot.greendao.rx.RxQuery.1
            @Override // java.util.concurrent.Callable
            public List<T> call() throws Exception {
                return RxQuery.this.query.forCurrentThread().list();
            }
        });
    }

    @Experimental
    public f<T> unique() {
        return (f<T>) wrap((Callable<T>) new Callable<T>() { // from class: org.greenrobot.greendao.rx.RxQuery.2
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                return RxQuery.this.query.forCurrentThread().unique();
            }
        });
    }

    public f<T> oneByOne() {
        return (f<T>) wrap(f.a((f.a) new f.a<T>() { // from class: org.greenrobot.greendao.rx.RxQuery.3
            @Override // rx.c.b
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((l) ((l) obj));
            }

            public void call(l<? super T> lVar) {
                try {
                    LazyList<T> listLazyUncached = RxQuery.this.query.forCurrentThread().listLazyUncached();
                    Iterator<T> it = listLazyUncached.iterator();
                    while (it.hasNext()) {
                        Object obj = (T) it.next();
                        if (lVar.isUnsubscribed()) {
                            break;
                        }
                        lVar.onNext(obj);
                    }
                    listLazyUncached.close();
                    if (!lVar.isUnsubscribed()) {
                        lVar.onCompleted();
                    }
                } catch (Throwable th) {
                    b.b(th);
                    lVar.onError(th);
                }
            }
        }));
    }
}
