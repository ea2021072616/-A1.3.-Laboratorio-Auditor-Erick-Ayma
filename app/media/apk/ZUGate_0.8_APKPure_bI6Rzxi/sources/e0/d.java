package e0;

import androidx.appcompat.widget.d0;
import java.util.ArrayList;
import l.j;
/* loaded from: classes.dex */
public final class d implements g0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2569a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2570b;

    public /* synthetic */ d(int i5, Object obj) {
        this.f2569a = i5;
        this.f2570b = obj;
    }

    @Override // g0.a
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        switch (this.f2569a) {
            case 0:
                b((e) obj);
                return;
            default:
                b((e) obj);
                return;
        }
    }

    public final void b(e eVar) {
        switch (this.f2569a) {
            case 0:
                if (eVar == null) {
                    eVar = new e(-3);
                }
                ((d0) this.f2570b).m(eVar);
                return;
            default:
                synchronized (f.f2575c) {
                    j jVar = f.f2576d;
                    ArrayList arrayList = (ArrayList) jVar.getOrDefault((String) this.f2570b, null);
                    if (arrayList == null) {
                        return;
                    }
                    jVar.remove((String) this.f2570b);
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        ((g0.a) arrayList.get(i5)).a(eVar);
                    }
                    return;
                }
        }
    }
}
