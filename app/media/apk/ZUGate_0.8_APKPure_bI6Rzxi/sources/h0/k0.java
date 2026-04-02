package h0;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class k0 implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

    /* renamed from: g  reason: collision with root package name */
    public final WeakHashMap f3164g = new WeakHashMap();

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (Build.VERSION.SDK_INT < 28) {
            for (Map.Entry entry : this.f3164g.entrySet()) {
                View view = (View) entry.getKey();
                boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                boolean z4 = view.isShown() && view.getWindowVisibility() == 0;
                if (booleanValue != z4) {
                    z0.h(view, z4 ? 16 : 32);
                    entry.setValue(Boolean.valueOf(z4));
                }
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
