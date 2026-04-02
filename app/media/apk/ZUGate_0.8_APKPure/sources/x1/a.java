package x1;

import androidx.appcompat.widget.d0;
/* loaded from: classes.dex */
public final class a implements v3.d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5435a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final v3.c f5436b;

    /* renamed from: c  reason: collision with root package name */
    public static final v3.c f5437c;

    /* renamed from: d  reason: collision with root package name */
    public static final v3.c f5438d;

    /* renamed from: e  reason: collision with root package name */
    public static final v3.c f5439e;

    static {
        d0 a5 = v3.c.a("window");
        y3.d dVar = y3.d.DEFAULT;
        a5.n(new y3.a(1, dVar));
        f5436b = a5.g();
        d0 a6 = v3.c.a("logSourceMetrics");
        a6.n(new y3.a(2, dVar));
        f5437c = a6.g();
        d0 a7 = v3.c.a("globalMetrics");
        a7.n(new y3.a(3, dVar));
        f5438d = a7.g();
        d0 a8 = v3.c.a("appNamespace");
        a8.n(new y3.a(4, dVar));
        f5439e = a8.g();
    }

    @Override // v3.a
    public final void a(Object obj, Object obj2) {
        a2.a aVar = (a2.a) obj;
        v3.e eVar = (v3.e) obj2;
        eVar.d(f5436b, aVar.f4a);
        eVar.d(f5437c, aVar.f5b);
        eVar.d(f5438d, aVar.f6c);
        eVar.d(f5439e, aVar.f7d);
    }
}
