package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.b0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import u.a;
import u.d;
/* loaded from: classes.dex */
public class FloatingActionButton$BaseBehavior<T> extends a {
    public FloatingActionButton$BaseBehavior() {
    }

    @Override // u.a
    public final boolean e(View view) {
        b0.m(view);
        throw null;
    }

    @Override // u.a
    public final void g(d dVar) {
        if (dVar.f5103h == 0) {
            dVar.f5103h = 80;
        }
    }

    @Override // u.a
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b0.m(view);
        throw null;
    }

    @Override // u.a
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, int i5) {
        b0.m(view);
        throw null;
    }

    public FloatingActionButton$BaseBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w2.a.f5392g);
        obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }
}
