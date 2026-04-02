package c2;

import java.util.Map;
import ru.zdevs.zugate.MainActivity;
/* loaded from: classes.dex */
public final /* synthetic */ class i implements e2.b, y4.e {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f1737g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f1738h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1739i;

    public /* synthetic */ i(Object obj, int i5, Object obj2) {
        this.f1737g = i5;
        this.f1738h = obj;
        this.f1739i = obj2;
    }

    @Override // y4.e
    public final void a(String str, boolean z4) {
        MainActivity mainActivity = (MainActivity) this.f1738h;
        String str2 = (String) this.f1739i;
        int i5 = MainActivity.f4551q;
        mainActivity.getClass();
        if (str2 == null || !(str == null || z4)) {
            b4.j.V(mainActivity, str != null ? z4 ? "1" : "2" : "0");
        }
    }

    @Override // e2.b
    public final Object b() {
        int i5 = this.f1737g;
        Object obj = this.f1739i;
        Object obj2 = this.f1738h;
        switch (i5) {
            case 0:
                Iterable iterable = (Iterable) obj;
                d2.k kVar = (d2.k) ((k) obj2).f1745c;
                kVar.getClass();
                if (iterable.iterator().hasNext()) {
                    kVar.j().compileStatement("DELETE FROM events WHERE _id in " + d2.k.K(iterable)).execute();
                }
                return null;
            default:
                k kVar2 = (k) obj2;
                kVar2.getClass();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    a2.c cVar = a2.c.f14h;
                    d2.k kVar3 = (d2.k) kVar2.f1751i;
                    kVar3.getClass();
                    kVar3.H(new j(((Integer) entry.getValue()).intValue(), (String) entry.getKey(), cVar));
                }
                return null;
        }
    }
}
