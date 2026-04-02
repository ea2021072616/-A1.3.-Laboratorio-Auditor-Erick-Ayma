package e4;

import c4.g;
/* loaded from: classes.dex */
public abstract class f extends a {
    public f(c4.b bVar) {
        super(bVar);
        if (bVar != null) {
            if (!(bVar.a() == g.f1790b)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // c4.b
    public final c4.f a() {
        return g.f1790b;
    }
}
