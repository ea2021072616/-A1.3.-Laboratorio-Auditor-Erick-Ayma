package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.d;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.github.appintro.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import u.a;
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends a {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f2004a;

    /* renamed from: b  reason: collision with root package name */
    public int f2005b;

    /* renamed from: c  reason: collision with root package name */
    public int f2006c;

    /* renamed from: d  reason: collision with root package name */
    public TimeInterpolator f2007d;

    /* renamed from: e  reason: collision with root package name */
    public TimeInterpolator f2008e;

    /* renamed from: f  reason: collision with root package name */
    public int f2009f;

    /* renamed from: g  reason: collision with root package name */
    public int f2010g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPropertyAnimator f2011h;

    public HideBottomViewOnScrollBehavior() {
        this.f2004a = new LinkedHashSet();
        this.f2009f = 0;
        this.f2010g = 2;
    }

    @Override // u.a
    public boolean k(CoordinatorLayout coordinatorLayout, View view, int i5) {
        this.f2009f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f2005b = p2.a.Q(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f2006c = p2.a.Q(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f2007d = p2.a.R(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, x2.a.f5487d);
        this.f2008e = p2.a.R(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, x2.a.f5486c);
        return false;
    }

    @Override // u.a
    public final void o(CoordinatorLayout coordinatorLayout, View view, int i5, int i6, int i7, int[] iArr) {
        LinkedHashSet linkedHashSet = this.f2004a;
        if (i5 > 0) {
            if (this.f2010g == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.f2011h;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f2010g = 1;
            Iterator it = linkedHashSet.iterator();
            if (it.hasNext()) {
                b0.n(it.next());
                throw null;
            } else {
                v(view, this.f2009f + 0, this.f2006c, this.f2008e);
            }
        } else if (i5 < 0) {
            if (this.f2010g == 2) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator2 = this.f2011h;
            if (viewPropertyAnimator2 != null) {
                viewPropertyAnimator2.cancel();
                view.clearAnimation();
            }
            this.f2010g = 2;
            Iterator it2 = linkedHashSet.iterator();
            if (it2.hasNext()) {
                b0.n(it2.next());
                throw null;
            } else {
                v(view, 0, this.f2005b, this.f2007d);
            }
        }
    }

    @Override // u.a
    public boolean s(View view, int i5, int i6) {
        return i5 == 2;
    }

    public final void v(View view, int i5, long j5, TimeInterpolator timeInterpolator) {
        this.f2011h = view.animate().translationY(i5).setInterpolator(timeInterpolator).setDuration(j5).setListener(new d(3, this));
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        this.f2004a = new LinkedHashSet();
        this.f2009f = 0;
        this.f2010g = 2;
    }
}
