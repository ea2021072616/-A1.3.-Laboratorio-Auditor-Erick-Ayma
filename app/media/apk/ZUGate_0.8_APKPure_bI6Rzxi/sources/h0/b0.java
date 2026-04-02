package h0;

import android.view.View;
/* loaded from: classes.dex */
public class b0 extends p3.e {

    /* renamed from: k  reason: collision with root package name */
    public final View f3107k;

    public b0(View view) {
        super(7);
        this.f3107k = view;
    }

    @Override // p3.e
    public void x() {
        View view;
        View view2 = this.f3107k;
        if (view2 == null) {
            return;
        }
        if (view2.isInEditMode() || view2.onCheckIsTextEditor()) {
            view2.requestFocus();
            view = view2;
        } else {
            view = view2.getRootView().findFocus();
        }
        if (view == null) {
            view = view2.getRootView().findViewById(16908290);
        }
        if (view == null || !view.hasWindowFocus()) {
            return;
        }
        view.post(new androidx.activity.d(5, view));
    }
}
