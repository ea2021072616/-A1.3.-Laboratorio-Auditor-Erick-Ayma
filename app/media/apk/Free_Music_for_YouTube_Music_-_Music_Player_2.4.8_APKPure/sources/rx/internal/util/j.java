package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.m;
/* compiled from: SubscriptionList.java */
/* loaded from: classes2.dex */
public final class j implements m {

    /* renamed from: a  reason: collision with root package name */
    private List<m> f5622a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f5623b;

    public j() {
    }

    public j(m... mVarArr) {
        this.f5622a = new LinkedList(Arrays.asList(mVarArr));
    }

    public j(m mVar) {
        this.f5622a = new LinkedList();
        this.f5622a.add(mVar);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f5623b;
    }

    public void a(m mVar) {
        if (!mVar.isUnsubscribed()) {
            if (!this.f5623b) {
                synchronized (this) {
                    if (!this.f5623b) {
                        List list = this.f5622a;
                        if (list == null) {
                            list = new LinkedList();
                            this.f5622a = list;
                        }
                        list.add(mVar);
                        return;
                    }
                }
            }
            mVar.unsubscribe();
        }
    }

    public void b(m mVar) {
        if (!this.f5623b) {
            synchronized (this) {
                List<m> list = this.f5622a;
                if (!this.f5623b && list != null) {
                    boolean remove = list.remove(mVar);
                    if (remove) {
                        mVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.m
    public void unsubscribe() {
        if (!this.f5623b) {
            synchronized (this) {
                if (!this.f5623b) {
                    this.f5623b = true;
                    List<m> list = this.f5622a;
                    this.f5622a = null;
                    a(list);
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
