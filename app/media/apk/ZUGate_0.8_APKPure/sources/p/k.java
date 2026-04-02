package p;

import java.util.ArrayList;
import q.n;
/* loaded from: classes.dex */
public abstract class k extends e implements j {

    /* renamed from: q0  reason: collision with root package name */
    public e[] f4241q0 = new e[4];

    /* renamed from: r0  reason: collision with root package name */
    public int f4242r0 = 0;

    public final void R(int i5, n nVar, ArrayList arrayList) {
        for (int i6 = 0; i6 < this.f4242r0; i6++) {
            e eVar = this.f4241q0[i6];
            ArrayList arrayList2 = nVar.f4412a;
            if (!arrayList2.contains(eVar)) {
                arrayList2.add(eVar);
            }
        }
        for (int i7 = 0; i7 < this.f4242r0; i7++) {
            m0.a.e(this.f4241q0[i7], i5, arrayList, nVar);
        }
    }

    public void a() {
    }
}
