package com.google.android.material.bottomappbar;

import a3.a;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.b0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
/* loaded from: classes.dex */
public class BottomAppBar$Behavior extends HideBottomViewOnScrollBehavior<Object> {
    public BottomAppBar$Behavior() {
        new a(this);
        new Rect();
    }

    @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, u.a
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, int i5) {
        b0.m(view);
        throw null;
    }

    @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, u.a
    public final boolean s(View view, int i5, int i6) {
        b0.m(view);
        throw null;
    }

    public BottomAppBar$Behavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new a(this);
        new Rect();
    }
}
