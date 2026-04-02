package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.b0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import h0.z0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import u.a;
@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends a {
    public ExpandableBehavior() {
    }

    @Override // u.a
    public abstract void f(View view);

    @Override // u.a
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b0.n(view2);
        throw null;
    }

    @Override // u.a
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, int i5) {
        WeakHashMap weakHashMap = z0.f3233a;
        if (!view.isLaidOut()) {
            ArrayList j5 = coordinatorLayout.j(view);
            int size = j5.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view2 = (View) j5.get(i6);
                f(view);
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(0);
    }
}
