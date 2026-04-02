package x1;

import androidx.appcompat.widget.d0;
/* loaded from: classes.dex */
public final class c implements v3.d {

    /* renamed from: a  reason: collision with root package name */
    public static final c f5442a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final v3.c f5443b;

    /* renamed from: c  reason: collision with root package name */
    public static final v3.c f5444c;

    static {
        d0 a5 = v3.c.a("eventsDroppedCount");
        y3.d dVar = y3.d.DEFAULT;
        a5.n(new y3.a(1, dVar));
        f5443b = a5.g();
        d0 a6 = v3.c.a("reason");
        a6.n(new y3.a(3, dVar));
        f5444c = a6.g();
    }

    @Override // v3.a
    public final void a(Object obj, Object obj2) {
        a2.d dVar = (a2.d) obj;
        v3.e eVar = (v3.e) obj2;
        eVar.c(f5443b, dVar.f18a);
        eVar.d(f5444c, dVar.f19b);
    }
}
