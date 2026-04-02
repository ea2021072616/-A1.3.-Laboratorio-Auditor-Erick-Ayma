package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import h0.z0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import u.a;
import u.d;
import y2.c;
/* loaded from: classes.dex */
public class AppBarLayout$ScrollingViewBehavior extends c {

    /* renamed from: c  reason: collision with root package name */
    public int f1997c;

    public AppBarLayout$ScrollingViewBehavior() {
        new Rect();
        new Rect();
    }

    public static void w(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) arrayList.get(i5);
        }
    }

    @Override // u.a
    public final void f(View view) {
    }

    @Override // u.a
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        a aVar = ((d) view2.getLayoutParams()).f5096a;
        if (aVar instanceof AppBarLayout$BaseBehavior) {
            ((AppBarLayout$BaseBehavior) aVar).getClass();
            int bottom = (view2.getBottom() - view.getTop()) + 0 + 0;
            int i5 = this.f1997c;
            int a5 = bottom - (i5 == 0 ? 0 : m0.a.a((int) (i5 * 0.0f), 0, i5));
            WeakHashMap weakHashMap = z0.f3233a;
            view.offsetTopAndBottom(a5);
        }
        return false;
    }

    @Override // u.a
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i5, int i6, int i7) {
        int i8 = view.getLayoutParams().height;
        if (i8 == -1 || i8 == -2) {
            w(coordinatorLayout.j(view));
            return false;
        }
        return false;
    }

    @Override // u.a
    public final void p(CoordinatorLayout coordinatorLayout, View view) {
        w(coordinatorLayout.j(view));
    }

    @Override // y2.c
    public final void v(CoordinatorLayout coordinatorLayout, View view, int i5) {
        w(coordinatorLayout.j(view));
        coordinatorLayout.q(view, i5);
    }

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        new Rect();
        new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w2.a.f5405u);
        this.f1997c = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }
}
