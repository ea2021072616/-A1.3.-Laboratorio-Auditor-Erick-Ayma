package j3;

import android.view.View;
import h0.m0;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class l implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        WeakHashMap weakHashMap = z0.f3233a;
        m0.c(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
