package androidx.fragment.app;
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s1 f909b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ s1 f910c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f911d;

    public h(s1 s1Var, s1 s1Var2, boolean z4, l.b bVar) {
        this.f909b = s1Var;
        this.f910c = s1Var2;
        this.f911d = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Fragment fragment = this.f909b.f1001c;
        Fragment fragment2 = this.f910c.f1001c;
        m1 m1Var = h1.f913a;
        if (this.f911d) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }
}
