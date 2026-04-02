package e1;

import android.util.Log;
/* loaded from: classes.dex */
public final /* synthetic */ class h implements d0.b, e2.b, d2.i {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2603g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f2604h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f2605i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f2606j;

    public /* synthetic */ h(r rVar, e0.a aVar) {
        this.f2603g = 0;
        this.f2604h = null;
        this.f2606j = rVar;
        this.f2605i = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02f0  */
    @Override // d2.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 942
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.h.a(java.lang.Object):java.lang.Object");
    }

    @Override // e2.b
    public final Object b() {
        b2.b bVar = (b2.b) this.f2604h;
        x1.i iVar = (x1.i) this.f2605i;
        x1.h hVar = (x1.h) this.f2606j;
        d2.k kVar = (d2.k) bVar.f1627d;
        kVar.getClass();
        Object[] objArr = {iVar.f5463c, hVar.f5455a, iVar.f5461a};
        String x5 = b4.j.x("SQLiteEventStore");
        if (Log.isLoggable(x5, 3)) {
            Log.d(x5, String.format("Storing event with priority=%s, name=%s for destination %s", objArr));
        }
        ((Long) kVar.H(new h(kVar, hVar, iVar, 2))).longValue();
        ((c2.d) bVar.f1624a).a(iVar, 1, false);
        return null;
    }

    @Override // d0.b
    public final void c() {
        Runnable runnable = (Runnable) this.f2604h;
        r rVar = (r) this.f2606j;
        Runnable runnable2 = (Runnable) this.f2605i;
        if (runnable != null) {
            runnable.run();
            return;
        }
        rVar.d();
        runnable2.run();
    }

    public /* synthetic */ h(Object obj, Object obj2, Object obj3, int i5) {
        this.f2603g = i5;
        this.f2604h = obj;
        this.f2605i = obj2;
        this.f2606j = obj3;
    }
}
