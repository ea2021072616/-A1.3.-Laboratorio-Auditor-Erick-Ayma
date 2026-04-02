package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
public final class j0 extends PopupWindow {
    public j0(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f1701s, i5, i6);
        if (obtainStyledAttributes.hasValue(2)) {
            n0.l.c(this, obtainStyledAttributes.getBoolean(2, false));
        }
        setBackgroundDrawable((!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : p2.a.x(context, resourceId));
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i5, int i6) {
        super.showAsDropDown(view, i5, i6);
    }

    @Override // android.widget.PopupWindow
    public final void update(View view, int i5, int i6, int i7, int i8) {
        super.update(view, i5, i6, i7, i8);
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i5, int i6, int i7) {
        super.showAsDropDown(view, i5, i6, i7);
    }
}
