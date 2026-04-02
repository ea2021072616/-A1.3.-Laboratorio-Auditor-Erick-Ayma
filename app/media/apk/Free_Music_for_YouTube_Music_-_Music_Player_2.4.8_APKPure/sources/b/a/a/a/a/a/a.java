package b.a.a.a.a.a;

import android.content.Context;
/* compiled from: AbstractValueCache.java */
/* loaded from: classes.dex */
public abstract class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final c<T> f84a;

    protected abstract T a(Context context);

    protected abstract void a(Context context, T t);

    public a(c<T> cVar) {
        this.f84a = cVar;
    }

    @Override // b.a.a.a.a.a.c
    public final synchronized T a(Context context, d<T> dVar) throws Exception {
        T a2;
        a2 = a(context);
        if (a2 == null) {
            a2 = this.f84a != null ? this.f84a.a(context, dVar) : dVar.load(context);
            b(context, a2);
        }
        return a2;
    }

    private void b(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        a(context, (Context) t);
    }
}
