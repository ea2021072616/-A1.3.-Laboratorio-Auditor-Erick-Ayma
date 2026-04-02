package androidx.fragment.app;
/* loaded from: classes.dex */
public final class r1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f994b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ s1 f995c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ t1 f996d;

    public /* synthetic */ r1(t1 t1Var, s1 s1Var, int i5) {
        this.f994b = i5;
        this.f996d = t1Var;
        this.f995c = s1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f994b;
        s1 s1Var = this.f995c;
        t1 t1Var = this.f996d;
        switch (i5) {
            case 0:
                if (t1Var.f1011b.contains(s1Var)) {
                    androidx.appcompat.widget.b0.a(s1Var.f999a, s1Var.f1001c.mView);
                    return;
                }
                return;
            default:
                t1Var.f1011b.remove(s1Var);
                t1Var.f1012c.remove(s1Var);
                return;
        }
    }
}
