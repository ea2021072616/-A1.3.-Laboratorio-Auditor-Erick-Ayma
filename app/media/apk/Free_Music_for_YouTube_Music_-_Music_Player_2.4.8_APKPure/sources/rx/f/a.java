package rx.f;

import java.util.ArrayList;
import rx.f;
import rx.f.e;
/* compiled from: BehaviorSubject.java */
/* loaded from: classes2.dex */
public final class a<T> extends d<T, T> {

    /* renamed from: b  reason: collision with root package name */
    private static final Object[] f5281b = new Object[0];

    /* renamed from: c  reason: collision with root package name */
    private final e<T> f5282c;

    public static <T> a<T> e() {
        return a((Object) null, false);
    }

    private static <T> a<T> a(T t, boolean z) {
        final e eVar = new e();
        if (z) {
            eVar.a(rx.internal.a.d.a(t));
        }
        eVar.d = new rx.c.b<e.b<T>>() { // from class: rx.f.a.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(e.b<T> bVar) {
                bVar.b(e.this.a());
            }
        };
        eVar.e = eVar.d;
        return new a<>(eVar, eVar);
    }

    protected a(f.a<T> aVar, e<T> eVar) {
        super(aVar);
        this.f5282c = eVar;
    }

    @Override // rx.g
    public void onCompleted() {
        if (this.f5282c.a() == null || this.f5282c.f5295b) {
            Object a2 = rx.internal.a.d.a();
            for (e.b<T> bVar : this.f5282c.c(a2)) {
                bVar.a(a2);
            }
        }
    }

    @Override // rx.g
    public void onError(Throwable th) {
        if (this.f5282c.a() == null || this.f5282c.f5295b) {
            Object a2 = rx.internal.a.d.a(th);
            ArrayList arrayList = null;
            for (e.b<T> bVar : this.f5282c.c(a2)) {
                try {
                    bVar.a(a2);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.b.b.a(arrayList);
        }
    }

    @Override // rx.g
    public void onNext(T t) {
        if (this.f5282c.a() == null || this.f5282c.f5295b) {
            Object a2 = rx.internal.a.d.a(t);
            for (e.b<T> bVar : this.f5282c.b(a2)) {
                bVar.a(a2);
            }
        }
    }
}
