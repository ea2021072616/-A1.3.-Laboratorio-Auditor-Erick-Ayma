package k2;

import android.content.Context;
import android.os.Handler;
import java.util.Set;
/* loaded from: classes.dex */
public final class x extends u2.c implements j2.f, j2.g {

    /* renamed from: h  reason: collision with root package name */
    public static final n2.c f3628h = t2.b.f5027a;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3629a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f3630b;

    /* renamed from: c  reason: collision with root package name */
    public final n2.c f3631c = f3628h;

    /* renamed from: d  reason: collision with root package name */
    public final Set f3632d;

    /* renamed from: e  reason: collision with root package name */
    public final l2.c f3633e;

    /* renamed from: f  reason: collision with root package name */
    public t2.c f3634f;

    /* renamed from: g  reason: collision with root package name */
    public h1.c f3635g;

    public x(Context context, r2.d dVar, l2.c cVar) {
        this.f3629a = context;
        this.f3630b = dVar;
        this.f3633e = cVar;
        this.f3632d = cVar.f3767b;
    }

    @Override // k2.h
    public final void a(i2.a aVar) {
        this.f3635g.b(aVar);
    }

    @Override // k2.c
    public final void b(int i5) {
        h1.c cVar = this.f3635g;
        o oVar = (o) ((d) cVar.f3267l).f3586j.get(cVar.f3264i);
        if (oVar != null) {
            if (oVar.f3605i) {
                oVar.p(new i2.a(17));
            } else {
                oVar.b(i5);
            }
        }
    }

    @Override // k2.c
    public final void c() {
        this.f3634f.c(this);
    }
}
