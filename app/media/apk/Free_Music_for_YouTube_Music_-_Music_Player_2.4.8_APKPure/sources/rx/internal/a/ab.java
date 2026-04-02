package rx.internal.a;

import rx.f;
import rx.internal.a.aa;
import rx.j;
/* compiled from: SingleToObservable.java */
/* loaded from: classes2.dex */
public final class ab<T> implements f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final j.a<T> f5315a;

    public ab(j.a<T> aVar) {
        this.f5315a = aVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.l<? super T> lVar) {
        aa.a aVar = new aa.a(lVar);
        lVar.add(aVar);
        this.f5315a.call(aVar);
    }
}
