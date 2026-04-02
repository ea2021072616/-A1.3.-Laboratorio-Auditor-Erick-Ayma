package b.a.a.a.a.a;

import android.content.Context;
/* compiled from: MemoryValueCache.java */
/* loaded from: classes.dex */
public class b<T> extends a<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f85a;

    public b() {
        this(null);
    }

    public b(c<T> cVar) {
        super(cVar);
    }

    @Override // b.a.a.a.a.a.a
    protected T a(Context context) {
        return this.f85a;
    }

    @Override // b.a.a.a.a.a.a
    protected void a(Context context, T t) {
        this.f85a = t;
    }
}
