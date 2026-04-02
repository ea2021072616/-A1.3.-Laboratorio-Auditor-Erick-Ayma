package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.github.appintro.R;
import h0.h2;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f814g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f815h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f816i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f817j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        String str;
        e4.e.f(context, "context");
        this.f814g = new ArrayList();
        this.f815h = new ArrayList();
        this.f817j = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t0.a.f4980b, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    public final void a(View view) {
        if (this.f815h.contains(view)) {
            this.f814g.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        e4.e.f(view, "child");
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(view, i5, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        h2 i5;
        e4.e.f(windowInsets, "insets");
        h2 i6 = h2.i(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f816i;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            e4.e.e(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            i5 = h2.i(null, onApplyWindowInsets);
        } else {
            i5 = h0.z0.i(this, i6);
        }
        e4.e.e(i5, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!i5.f3144a.m()) {
            int childCount = getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                h0.z0.b(getChildAt(i7), i5);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        e4.e.f(canvas, "canvas");
        if (this.f817j) {
            Iterator it = this.f814g.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        e4.e.f(canvas, "canvas");
        e4.e.f(view, "child");
        if (this.f817j) {
            ArrayList arrayList = this.f814g;
            if ((!arrayList.isEmpty()) && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j5);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        e4.e.f(view, "view");
        this.f815h.remove(view);
        if (this.f814g.remove(view)) {
            this.f817j = true;
        }
        super.endViewTransition(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v14, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    public final <F extends Fragment> F getFragment() {
        d0 d0Var;
        Fragment fragment;
        w0 supportFragmentManager;
        FragmentContainerView fragmentContainerView = this;
        while (true) {
            d0Var = null;
            if (fragmentContainerView == 0) {
                fragment = null;
                break;
            }
            Object tag = fragmentContainerView.getTag(R.id.fragment_container_view_tag);
            fragment = tag instanceof Fragment ? (Fragment) tag : null;
            if (fragment != null) {
                break;
            }
            ViewParent parent = fragmentContainerView.getParent();
            fragmentContainerView = parent instanceof View ? (View) parent : 0;
        }
        if (fragment == null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof d0) {
                    d0Var = (d0) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (d0Var == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            supportFragmentManager = d0Var.getSupportFragmentManager();
        } else if (!fragment.isAdded()) {
            throw new IllegalStateException("The Fragment " + fragment + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        } else {
            supportFragmentManager = fragment.getChildFragmentManager();
        }
        return (F) supportFragmentManager.B(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        e4.e.f(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            }
            View childAt = getChildAt(childCount);
            e4.e.e(childAt, "view");
            a(childAt);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        e4.e.f(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i5) {
        View childAt = getChildAt(i5);
        e4.e.e(childAt, "view");
        a(childAt);
        super.removeViewAt(i5);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        e4.e.f(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i5, int i6) {
        int i7 = i5 + i6;
        for (int i8 = i5; i8 < i7; i8++) {
            View childAt = getChildAt(i8);
            e4.e.e(childAt, "view");
            a(childAt);
        }
        super.removeViews(i5, i6);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i5, int i6) {
        int i7 = i5 + i6;
        for (int i8 = i5; i8 < i7; i8++) {
            View childAt = getChildAt(i8);
            e4.e.e(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i5, i6);
    }

    public final void setDrawDisappearingViewsLast(boolean z4) {
        this.f817j = z4;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        e4.e.f(onApplyWindowInsetsListener, "listener");
        this.f816i = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        e4.e.f(view, "view");
        if (view.getParent() == this) {
            this.f815h.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, w0 w0Var) {
        super(context, attributeSet);
        View view;
        e4.e.f(context, "context");
        e4.e.f(attributeSet, "attrs");
        e4.e.f(w0Var, "fm");
        this.f814g = new ArrayList();
        this.f815h = new ArrayList();
        this.f817j = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t0.a.f4980b, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment B = w0Var.B(id);
        if (classAttribute != null && B == null) {
            if (id == -1) {
                String concat = string != null ? " with tag ".concat(string) : "";
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + concat);
            }
            q0 F = w0Var.F();
            context.getClassLoader();
            Fragment a5 = F.a(classAttribute);
            e4.e.e(a5, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            a5.onInflate(context, attributeSet, (Bundle) null);
            a aVar = new a(w0Var);
            aVar.f908p = true;
            a5.mContainer = this;
            aVar.c(getId(), a5, string, 1);
            if (!aVar.f900g) {
                aVar.f901h = false;
                aVar.f818q.y(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        Iterator it = w0Var.f1027c.d().iterator();
        while (it.hasNext()) {
            d1 d1Var = (d1) it.next();
            Fragment fragment = d1Var.f860c;
            if (fragment.mContainerId == getId() && (view = fragment.mView) != null && view.getParent() == null) {
                fragment.mContainer = this;
                d1Var.a();
            }
        }
    }
}
