package androidx.appcompat.widget;
/* loaded from: classes.dex */
public final class h2 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f372b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o2 f373c;

    public /* synthetic */ h2(o2 o2Var, int i5) {
        this.f372b = i5;
        this.f373c = o2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f372b;
        o2 o2Var = this.f373c;
        switch (i5) {
            case 1:
                b2 b2Var = o2Var.f452i;
                if (b2Var != null) {
                    b2Var.setListSelectionHidden(true);
                    b2Var.requestLayout();
                    return;
                }
                return;
            default:
                b2 b2Var2 = o2Var.f452i;
                if (b2Var2 == null || !b2Var2.isAttachedToWindow() || o2Var.f452i.getCount() <= o2Var.f452i.getChildCount() || o2Var.f452i.getChildCount() > o2Var.f461s) {
                    return;
                }
                o2Var.F.setInputMethodMode(2);
                o2Var.f();
                return;
        }
    }
}
