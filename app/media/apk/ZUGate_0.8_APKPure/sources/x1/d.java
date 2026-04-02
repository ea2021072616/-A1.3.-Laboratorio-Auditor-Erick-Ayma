package x1;

import androidx.appcompat.widget.d0;
/* loaded from: classes.dex */
public final class d implements v3.d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f5445a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final v3.c f5446b;

    /* renamed from: c  reason: collision with root package name */
    public static final v3.c f5447c;

    static {
        d0 a5 = v3.c.a("logSource");
        y3.d dVar = y3.d.DEFAULT;
        a5.n(new y3.a(1, dVar));
        f5446b = a5.g();
        d0 a6 = v3.c.a("logEventDropped");
        a6.n(new y3.a(2, dVar));
        f5447c = a6.g();
    }

    @Override // v3.a
    public final void a(Object obj, Object obj2) {
        a2.e eVar = (a2.e) obj;
        v3.e eVar2 = (v3.e) obj2;
        eVar2.d(f5446b, eVar.f21a);
        eVar2.d(f5447c, eVar.f22b);
    }
}
