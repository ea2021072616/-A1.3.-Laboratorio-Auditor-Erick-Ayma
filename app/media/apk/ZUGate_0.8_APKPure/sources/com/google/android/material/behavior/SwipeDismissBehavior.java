package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import h0.z0;
import i0.e;
import java.util.WeakHashMap;
import n2.b;
import q0.d;
import r3.h;
import u.a;
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends a {

    /* renamed from: a  reason: collision with root package name */
    public d f2012a;

    /* renamed from: b  reason: collision with root package name */
    public h f2013b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2014c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2015d;

    /* renamed from: e  reason: collision with root package name */
    public int f2016e = 2;

    /* renamed from: f  reason: collision with root package name */
    public final float f2017f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    public float f2018g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f2019h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    public final z2.a f2020i = new z2.a(this);

    @Override // u.a
    public boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z4 = this.f2014c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z4 = coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f2014c = z4;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2014c = false;
        }
        if (z4) {
            if (this.f2012a == null) {
                this.f2012a = new d(coordinatorLayout.getContext(), coordinatorLayout, this.f2020i);
            }
            return !this.f2015d && this.f2012a.r(motionEvent);
        }
        return false;
    }

    @Override // u.a
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, int i5) {
        WeakHashMap weakHashMap = z0.f3233a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            z0.k(view, 1048576);
            z0.h(view, 0);
            if (v(view)) {
                z0.l(view, e.f3367j, new b((Object) this));
            }
        }
        return false;
    }

    @Override // u.a
    public final boolean u(View view, MotionEvent motionEvent) {
        if (this.f2012a != null) {
            if (this.f2015d && motionEvent.getActionMasked() == 3) {
                return true;
            }
            this.f2012a.k(motionEvent);
            return true;
        }
        return false;
    }

    public boolean v(View view) {
        return true;
    }
}
