package g0;

import n.e;
/* loaded from: classes.dex */
public final class b extends e {

    /* renamed from: d  reason: collision with root package name */
    public final Object f2926d;

    public b() {
        super(12, 1);
        this.f2926d = new Object();
    }

    @Override // n.e
    public final Object a() {
        Object a5;
        synchronized (this.f2926d) {
            a5 = super.a();
        }
        return a5;
    }

    @Override // n.e
    public final boolean b(Object obj) {
        boolean b5;
        synchronized (this.f2926d) {
            b5 = super.b(obj);
        }
        return b5;
    }
}
