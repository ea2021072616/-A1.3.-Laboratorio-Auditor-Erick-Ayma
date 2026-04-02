package androidx.recyclerview.widget;
/* loaded from: classes.dex */
public final class l1 extends v0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1415a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f0 f1416b;

    public l1(f0 f0Var) {
        this.f1416b = f0Var;
    }

    @Override // androidx.recyclerview.widget.v0
    public final void a(RecyclerView recyclerView, int i5) {
        if (i5 == 0 && this.f1415a) {
            this.f1415a = false;
            this.f1416b.f();
        }
    }

    @Override // androidx.recyclerview.widget.v0
    public final void b(RecyclerView recyclerView, int i5, int i6) {
        if (i5 == 0 && i6 == 0) {
            return;
        }
        this.f1415a = true;
    }
}
