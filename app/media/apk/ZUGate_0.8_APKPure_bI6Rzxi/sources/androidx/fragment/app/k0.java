package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class k0 implements LayoutInflater.Factory2 {

    /* renamed from: g  reason: collision with root package name */
    public final w0 f935g;

    public k0(w0 w0Var) {
        this.f935g = w0Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z4;
        d1 f5;
        boolean equals = FragmentContainerView.class.getName().equals(str);
        w0 w0Var = this.f935g;
        if (equals) {
            return new FragmentContainerView(context, attributeSet, w0Var);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t0.a.f4979a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    z4 = Fragment.class.isAssignableFrom(q0.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    z4 = false;
                }
                if (z4) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    Fragment B = resourceId != -1 ? w0Var.B(resourceId) : null;
                    if (B == null && string != null) {
                        B = w0Var.C(string);
                    }
                    if (B == null && id != -1) {
                        B = w0Var.B(id);
                    }
                    if (B == null) {
                        q0 F = w0Var.F();
                        context.getClassLoader();
                        B = F.a(attributeValue);
                        B.mFromLayout = true;
                        B.mFragmentId = resourceId != 0 ? resourceId : id;
                        B.mContainerId = id;
                        B.mTag = string;
                        B.mInLayout = true;
                        B.mFragmentManager = w0Var;
                        i0 i0Var = w0Var.f1043t;
                        B.mHost = i0Var;
                        B.onInflate(i0Var.f919h, attributeSet, B.mSavedFragmentState);
                        f5 = w0Var.a(B);
                        if (w0.I(2)) {
                            Log.v("FragmentManager", "Fragment " + B + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else if (!B.mInLayout) {
                        B.mInLayout = true;
                        B.mFragmentManager = w0Var;
                        i0 i0Var2 = w0Var.f1043t;
                        B.mHost = i0Var2;
                        B.onInflate(i0Var2.f919h, attributeSet, B.mSavedFragmentState);
                        f5 = w0Var.f(B);
                        if (w0.I(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + B + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    u0.b bVar = u0.c.f5128a;
                    u0.d dVar = new u0.d(B, viewGroup, 0);
                    u0.c.c(dVar);
                    u0.b a5 = u0.c.a(B);
                    if (a5.f5126a.contains(u0.a.DETECT_FRAGMENT_TAG_USAGE) && u0.c.e(a5, B.getClass(), u0.d.class)) {
                        u0.c.b(a5, dVar);
                    }
                    B.mContainer = viewGroup;
                    f5.j();
                    f5.i();
                    View view2 = B.mView;
                    if (view2 != null) {
                        if (resourceId != 0) {
                            view2.setId(resourceId);
                        }
                        if (B.mView.getTag() == null) {
                            B.mView.setTag(string);
                        }
                        B.mView.addOnAttachStateChangeListener(new j0(this, f5));
                        return B.mView;
                    }
                    throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
                }
            }
            return null;
        }
        return null;
    }
}
