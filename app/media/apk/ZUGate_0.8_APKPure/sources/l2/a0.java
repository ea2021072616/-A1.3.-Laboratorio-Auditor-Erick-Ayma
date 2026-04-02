package l2;
/* loaded from: classes.dex */
public final class a0 extends s {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f f3761g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(f fVar, int i5) {
        super(fVar, i5, null);
        this.f3761g = fVar;
    }

    @Override // l2.s
    public final void b(i2.a aVar) {
        f fVar = this.f3761g;
        fVar.getClass();
        fVar.f3815i.a(aVar);
        System.currentTimeMillis();
    }

    @Override // l2.s
    public final boolean c() {
        this.f3761g.f3815i.a(i2.a.f3379f);
        return true;
    }
}
