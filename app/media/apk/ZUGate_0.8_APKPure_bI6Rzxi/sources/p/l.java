package p;

import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class l extends e {

    /* renamed from: q0  reason: collision with root package name */
    public ArrayList f4243q0 = new ArrayList();

    @Override // p.e
    public void D() {
        this.f4243q0.clear();
        super.D();
    }

    @Override // p.e
    public final void G(g.f fVar) {
        super.G(fVar);
        int size = this.f4243q0.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((e) this.f4243q0.get(i5)).G(fVar);
        }
    }

    public abstract void R();
}
