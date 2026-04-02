package androidx.recyclerview.widget;
/* loaded from: classes.dex */
public abstract class i0 {

    /* renamed from: g  reason: collision with root package name */
    public final j0 f1372g = new j0();

    /* renamed from: h  reason: collision with root package name */
    public boolean f1373h = false;

    /* renamed from: i  reason: collision with root package name */
    public final int f1374i = 1;

    public abstract int a();

    public long b(int i5) {
        return -1L;
    }

    public int c(int i5) {
        return 0;
    }

    public abstract void d(i1 i1Var, int i5);

    public abstract i1 e(RecyclerView recyclerView, int i5);

    public final void f(boolean z4) {
        if (this.f1372g.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.f1373h = z4;
    }
}
