package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout {

    /* renamed from: g  reason: collision with root package name */
    public c2 f221g;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        c2 c2Var = this.f221g;
        if (c2Var != null) {
            rect.top = ((d.a0) c2Var).f2280h.L(null, rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(c2 c2Var) {
        this.f221g = c2Var;
    }
}
