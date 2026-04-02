package rx.f;

import rx.f;
import rx.g;
/* compiled from: Subject.java */
/* loaded from: classes2.dex */
public abstract class d<T, R> extends f<R> implements g<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public d(f.a<R> aVar) {
        super(aVar);
    }

    public final c<T, R> f() {
        return getClass() == c.class ? (c) this : new c<>(this);
    }
}
