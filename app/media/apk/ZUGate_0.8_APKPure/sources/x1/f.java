package x1;

import androidx.appcompat.widget.d0;
/* loaded from: classes.dex */
public final class f implements v3.d {

    /* renamed from: a  reason: collision with root package name */
    public static final f f5449a = new f();

    /* renamed from: b  reason: collision with root package name */
    public static final v3.c f5450b;

    /* renamed from: c  reason: collision with root package name */
    public static final v3.c f5451c;

    static {
        d0 a5 = v3.c.a("currentCacheSizeBytes");
        y3.d dVar = y3.d.DEFAULT;
        a5.n(new y3.a(1, dVar));
        f5450b = a5.g();
        d0 a6 = v3.c.a("maxCacheSizeBytes");
        a6.n(new y3.a(2, dVar));
        f5451c = a6.g();
    }

    @Override // v3.a
    public final void a(Object obj, Object obj2) {
        a2.f fVar = (a2.f) obj;
        v3.e eVar = (v3.e) obj2;
        eVar.c(f5450b, fVar.f23a);
        eVar.c(f5451c, fVar.f24b);
    }
}
