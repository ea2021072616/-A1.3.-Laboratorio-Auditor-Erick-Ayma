package x1;

import androidx.appcompat.widget.d0;
/* loaded from: classes.dex */
public final class g implements v3.d {

    /* renamed from: a  reason: collision with root package name */
    public static final g f5452a = new g();

    /* renamed from: b  reason: collision with root package name */
    public static final v3.c f5453b;

    /* renamed from: c  reason: collision with root package name */
    public static final v3.c f5454c;

    static {
        d0 a5 = v3.c.a("startMs");
        y3.d dVar = y3.d.DEFAULT;
        a5.n(new y3.a(1, dVar));
        f5453b = a5.g();
        d0 a6 = v3.c.a("endMs");
        a6.n(new y3.a(2, dVar));
        f5454c = a6.g();
    }

    @Override // v3.a
    public final void a(Object obj, Object obj2) {
        a2.g gVar = (a2.g) obj;
        v3.e eVar = (v3.e) obj2;
        eVar.c(f5453b, gVar.f25a);
        eVar.c(f5454c, gVar.f26b);
    }
}
