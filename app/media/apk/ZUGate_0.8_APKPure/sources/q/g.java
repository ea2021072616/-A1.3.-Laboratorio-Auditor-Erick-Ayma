package q;

import java.util.Iterator;
/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: m  reason: collision with root package name */
    public int f4397m;

    public g(o oVar) {
        super(oVar);
        if (oVar instanceof j) {
            this.f4389e = 2;
        } else {
            this.f4389e = 3;
        }
    }

    @Override // q.f
    public final void d(int i5) {
        if (this.f4394j) {
            return;
        }
        this.f4394j = true;
        this.f4391g = i5;
        Iterator it = this.f4395k.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            dVar.a(dVar);
        }
    }
}
