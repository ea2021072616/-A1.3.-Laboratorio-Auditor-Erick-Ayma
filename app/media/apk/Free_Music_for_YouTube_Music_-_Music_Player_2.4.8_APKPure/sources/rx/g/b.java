package rx.g;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.m;
/* compiled from: CompositeSubscription.java */
/* loaded from: classes2.dex */
public final class b implements m {

    /* renamed from: a  reason: collision with root package name */
    private Set<m> f5307a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f5308b;

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f5308b;
    }

    public void a(m mVar) {
        if (!mVar.isUnsubscribed()) {
            if (!this.f5308b) {
                synchronized (this) {
                    if (!this.f5308b) {
                        if (this.f5307a == null) {
                            this.f5307a = new HashSet(4);
                        }
                        this.f5307a.add(mVar);
                        return;
                    }
                }
            }
            mVar.unsubscribe();
        }
    }

    public void b(m mVar) {
        if (!this.f5308b) {
            synchronized (this) {
                if (!this.f5308b && this.f5307a != null) {
                    boolean remove = this.f5307a.remove(mVar);
                    if (remove) {
                        mVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.m
    public void unsubscribe() {
        if (!this.f5308b) {
            synchronized (this) {
                if (!this.f5308b) {
                    this.f5308b = true;
                    Set<m> set = this.f5307a;
                    this.f5307a = null;
                    a(set);
                }
            }
        }
    }

    private static void a(Collection<m> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (m mVar : collection) {
                try {
                    mVar.unsubscribe();
                } catch (Throwable th) {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(th);
                    arrayList = arrayList2;
                }
            }
            rx.b.b.a(arrayList);
        }
    }
}
