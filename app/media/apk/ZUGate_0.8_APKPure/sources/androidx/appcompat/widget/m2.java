package androidx.appcompat.widget;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public final class m2 implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o2 f413a;

    public m2(o2 o2Var) {
        this.f413a = o2Var;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i5, int i6, int i7) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i5) {
        if (i5 == 1) {
            o2 o2Var = this.f413a;
            if ((o2Var.F.getInputMethodMode() == 2) || o2Var.F.getContentView() == null) {
                return;
            }
            Handler handler = o2Var.B;
            h2 h2Var = o2Var.f466x;
            handler.removeCallbacks(h2Var);
            h2Var.run();
        }
    }
}
