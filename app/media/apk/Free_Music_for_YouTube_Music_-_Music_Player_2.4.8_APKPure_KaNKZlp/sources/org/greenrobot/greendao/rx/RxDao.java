package org.greenrobot.greendao.rx;

import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import rx.f;
import rx.i;
@Experimental
/* loaded from: classes2.dex */
public class RxDao<T, K> extends RxBase {
    private final AbstractDao<T, K> dao;

    @Override // org.greenrobot.greendao.rx.RxBase
    @Experimental
    public /* bridge */ /* synthetic */ i getScheduler() {
        return super.getScheduler();
    }

    @Experimental
    public RxDao(AbstractDao<T, K> abstractDao) {
        this(abstractDao, null);
    }

    @Experimental
    public RxDao(AbstractDao<T, K> abstractDao, i iVar) {
        super(iVar);
        this.dao = abstractDao;
    }

    @Experimental
    public f<List<T>> loadAll() {
        return (f<List<T>>) wrap((Callable<List<T>>) new Callable<List<T>>() { // from class: org.greenrobot.greendao.rx.RxDao.1
            @Override // java.util.concurrent.Callable
            public List<T> call() throws Exception {
                return RxDao.this.dao.loadAll();
            }
        });
    }

    @Experimental
    public f<T> load(final K k) {
        return (f<T>) wrap((Callable<T>) new Callable<T>() { // from class: org.greenrobot.greendao.rx.RxDao.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                return (T) RxDao.this.dao.load(k);
            }
        });
    }

    @Experimental
    public f<T> refresh(final T t) {
        return (f<T>) wrap((Callable<T>) new Callable<T>() { // from class: org.greenrobot.greendao.rx.RxDao.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                RxDao.this.dao.refresh(t);
                return (T) t;
            }
        });
    }

    @Experimental
    public f<T> insert(final T t) {
        return (f<T>) wrap((Callable<T>) new Callable<T>() { // from class: org.greenrobot.greendao.rx.RxDao.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                RxDao.this.dao.insert(t);
                return (T) t;
            }
        });
    }

    @Experimental
    public f<Iterable<T>> insertInTx(final Iterable<T> iterable) {
        return (f<Iterable<T>>) wrap((Callable<Iterable<T>>) new Callable<Iterable<T>>() { // from class: org.greenrobot.greendao.rx.RxDao.5
            @Override // java.util.concurrent.Callable
            public Iterable<T> call() throws Exception {
                RxDao.this.dao.insertInTx(iterable);
                return iterable;
            }
        });
    }

    @Experimental
    public f<Object[]> insertInTx(final T... tArr) {
        return wrap(new Callable<Object[]>() { // from class: org.greenrobot.greendao.rx.RxDao.6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public Object[] call() throws Exception {
                RxDao.this.dao.insertInTx(tArr);
                return tArr;
            }
        });
    }

    @Experimental
    public f<T> insertOrReplace(final T t) {
        return (f<T>) wrap((Callable<T>) new Callable<T>() { // from class: org.greenrobot.greendao.rx.RxDao.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                RxDao.this.dao.insertOrReplace(t);
                return (T) t;
            }
        });
    }

    @Experimental
    public f<Iterable<T>> insertOrReplaceInTx(final Iterable<T> iterable) {
        return (f<Iterable<T>>) wrap((Callable<Iterable<T>>) new Callable<Iterable<T>>() { // from class: org.greenrobot.greendao.rx.RxDao.8
            @Override // java.util.concurrent.Callable
            public Iterable<T> call() throws Exception {
                RxDao.this.dao.insertOrReplaceInTx(iterable);
                return iterable;
            }
        });
    }

    @Experimental
    public f<Object[]> insertOrReplaceInTx(final T... tArr) {
        return wrap(new Callable<Object[]>() { // from class: org.greenrobot.greendao.rx.RxDao.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public Object[] call() throws Exception {
                RxDao.this.dao.insertOrReplaceInTx(tArr);
                return tArr;
            }
        });
    }

    @Experimental
    public f<T> save(final T t) {
        return (f<T>) wrap((Callable<T>) new Callable<T>() { // from class: org.greenrobot.greendao.rx.RxDao.10
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                RxDao.this.dao.save(t);
                return (T) t;
            }
        });
    }

    @Experimental
    public f<Iterable<T>> saveInTx(final Iterable<T> iterable) {
        return (f<Iterable<T>>) wrap((Callable<Iterable<T>>) new Callable<Iterable<T>>() { // from class: org.greenrobot.greendao.rx.RxDao.11
            @Override // java.util.concurrent.Callable
            public Iterable<T> call() throws Exception {
                RxDao.this.dao.saveInTx(iterable);
                return iterable;
            }
        });
    }

    @Experimental
    public f<Object[]> saveInTx(final T... tArr) {
        return wrap(new Callable<Object[]>() { // from class: org.greenrobot.greendao.rx.RxDao.12
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public Object[] call() throws Exception {
                RxDao.this.dao.saveInTx(tArr);
                return tArr;
            }
        });
    }

    @Experimental
    public f<T> update(final T t) {
        return (f<T>) wrap((Callable<T>) new Callable<T>() { // from class: org.greenrobot.greendao.rx.RxDao.13
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                RxDao.this.dao.update(t);
                return (T) t;
            }
        });
    }

    @Experimental
    public f<Iterable<T>> updateInTx(final Iterable<T> iterable) {
        return (f<Iterable<T>>) wrap((Callable<Iterable<T>>) new Callable<Iterable<T>>() { // from class: org.greenrobot.greendao.rx.RxDao.14
            @Override // java.util.concurrent.Callable
            public Iterable<T> call() throws Exception {
                RxDao.this.dao.updateInTx(iterable);
                return iterable;
            }
        });
    }

    @Experimental
    public f<Object[]> updateInTx(final T... tArr) {
        return wrap(new Callable<Object[]>() { // from class: org.greenrobot.greendao.rx.RxDao.15
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public Object[] call() throws Exception {
                RxDao.this.dao.updateInTx(tArr);
                return tArr;
            }
        });
    }

    @Experimental
    public f<Void> delete(final T t) {
        return wrap(new Callable<Void>() { // from class: org.greenrobot.greendao.rx.RxDao.16
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                RxDao.this.dao.delete(t);
                return null;
            }
        });
    }

    @Experimental
    public f<Void> deleteByKey(final K k) {
        return wrap(new Callable<Void>() { // from class: org.greenrobot.greendao.rx.RxDao.17
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                RxDao.this.dao.deleteByKey(k);
                return null;
            }
        });
    }

    @Experimental
    public f<Void> deleteAll() {
        return wrap(new Callable<Void>() { // from class: org.greenrobot.greendao.rx.RxDao.18
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                RxDao.this.dao.deleteAll();
                return null;
            }
        });
    }

    @Experimental
    public f<Void> deleteInTx(final Iterable<T> iterable) {
        return wrap(new Callable<Void>() { // from class: org.greenrobot.greendao.rx.RxDao.19
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                RxDao.this.dao.deleteInTx(iterable);
                return null;
            }
        });
    }

    @Experimental
    public f<Void> deleteInTx(final T... tArr) {
        return wrap(new Callable<Void>() { // from class: org.greenrobot.greendao.rx.RxDao.20
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                RxDao.this.dao.deleteInTx(tArr);
                return null;
            }
        });
    }

    @Experimental
    public f<Void> deleteByKeyInTx(final Iterable<K> iterable) {
        return wrap(new Callable<Void>() { // from class: org.greenrobot.greendao.rx.RxDao.21
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                RxDao.this.dao.deleteByKeyInTx(iterable);
                return null;
            }
        });
    }

    @Experimental
    public f<Void> deleteByKeyInTx(final K... kArr) {
        return wrap(new Callable<Void>() { // from class: org.greenrobot.greendao.rx.RxDao.22
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                RxDao.this.dao.deleteByKeyInTx(kArr);
                return null;
            }
        });
    }

    @Experimental
    public f<Long> count() {
        return wrap(new Callable<Long>() { // from class: org.greenrobot.greendao.rx.RxDao.23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() throws Exception {
                return Long.valueOf(RxDao.this.dao.count());
            }
        });
    }

    @Experimental
    public AbstractDao<T, K> getDao() {
        return this.dao;
    }
}
