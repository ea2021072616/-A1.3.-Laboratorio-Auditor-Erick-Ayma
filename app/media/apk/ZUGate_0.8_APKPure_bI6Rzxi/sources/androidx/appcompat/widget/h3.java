package androidx.appcompat.widget;
/* loaded from: classes.dex */
public final /* synthetic */ class h3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f374b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Toolbar f375c;

    public /* synthetic */ h3(Toolbar toolbar, int i5) {
        this.f374b = i5;
        this.f375c = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f374b;
        Toolbar toolbar = this.f375c;
        switch (i5) {
            case 0:
                toolbar.l();
                return;
            default:
                k3 k3Var = toolbar.S;
                h.q qVar = k3Var == null ? null : k3Var.f400h;
                if (qVar != null) {
                    qVar.collapseActionView();
                    return;
                }
                return;
        }
    }
}
