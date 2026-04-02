package y2;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public abstract class c extends u.a {

    /* renamed from: a  reason: collision with root package name */
    public d f5685a;

    /* renamed from: b  reason: collision with root package name */
    public int f5686b;

    public c() {
        this.f5686b = 0;
    }

    @Override // u.a
    public boolean k(CoordinatorLayout coordinatorLayout, View view, int i5) {
        v(coordinatorLayout, view, i5);
        if (this.f5685a == null) {
            this.f5685a = new d(view);
        }
        d dVar = this.f5685a;
        View view2 = dVar.f5687a;
        dVar.f5688b = view2.getTop();
        dVar.f5689c = view2.getLeft();
        this.f5685a.a();
        int i6 = this.f5686b;
        if (i6 != 0) {
            d dVar2 = this.f5685a;
            if (dVar2.f5690d != i6) {
                dVar2.f5690d = i6;
                dVar2.a();
            }
            this.f5686b = 0;
            return true;
        }
        return true;
    }

    public void v(CoordinatorLayout coordinatorLayout, View view, int i5) {
        coordinatorLayout.q(view, i5);
    }

    public c(int i5) {
        super(0);
        this.f5686b = 0;
    }
}
