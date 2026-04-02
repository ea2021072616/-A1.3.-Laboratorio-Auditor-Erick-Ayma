package e1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.b3;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class e extends r {
    public static final String[] C = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final b3 D = new b3(PointF.class, "topLeft", 1);
    public static final b3 E = new b3(PointF.class, "bottomRight", 2);
    public static final b3 F = new b3(PointF.class, "bottomRight", 3);
    public static final b3 G = new b3(PointF.class, "topLeft", 4);
    public static final b3 H = new b3(PointF.class, "position", 5);

    public final void L(a0 a0Var) {
        View view = a0Var.f2586b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap hashMap = a0Var.f2585a;
        hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        hashMap.put("android:changeBounds:parent", view.getParent());
    }

    @Override // e1.r
    public final void e(a0 a0Var) {
        L(a0Var);
    }

    @Override // e1.r
    public final void h(a0 a0Var) {
        L(a0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e1.r
    public final Animator l(ViewGroup viewGroup, a0 a0Var, a0 a0Var2) {
        int i5;
        ObjectAnimator a5;
        if (a0Var == null || a0Var2 == null) {
            return null;
        }
        HashMap hashMap = a0Var.f2585a;
        HashMap hashMap2 = a0Var2.f2585a;
        ViewGroup viewGroup2 = (ViewGroup) hashMap.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) hashMap2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        Rect rect = (Rect) hashMap.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) hashMap2.get("android:changeBounds:bounds");
        int i6 = rect.left;
        int i7 = rect2.left;
        int i8 = rect.top;
        int i9 = rect2.top;
        int i10 = rect.right;
        int i11 = rect2.right;
        int i12 = rect.bottom;
        int i13 = rect2.bottom;
        int i14 = i10 - i6;
        int i15 = i12 - i8;
        int i16 = i11 - i7;
        int i17 = i13 - i9;
        Rect rect3 = (Rect) hashMap.get("android:changeBounds:clip");
        Rect rect4 = (Rect) hashMap2.get("android:changeBounds:clip");
        if ((i14 == 0 || i15 == 0) && (i16 == 0 || i17 == 0)) {
            i5 = 0;
        } else {
            i5 = (i6 == i7 && i8 == i9) ? 0 : 1;
            if (i10 != i11 || i12 != i13) {
                i5++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i5++;
        }
        int i18 = i5;
        if (i18 > 0) {
            View view = a0Var2.f2586b;
            c0.a(view, i6, i8, i10, i12);
            if (i18 == 2) {
                if (i14 == i16 && i15 == i17) {
                    this.f2672x.getClass();
                    a5 = m.a(view, H, z0.d.d(i6, i8, i7, i9));
                } else {
                    d dVar = new d(view);
                    this.f2672x.getClass();
                    ObjectAnimator a6 = m.a(dVar, D, z0.d.d(i6, i8, i7, i9));
                    this.f2672x.getClass();
                    ObjectAnimator a7 = m.a(dVar, E, z0.d.d(i10, i12, i11, i13));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(a6, a7);
                    animatorSet.addListener(new b(dVar));
                    a5 = animatorSet;
                }
            } else if (i6 == i7 && i8 == i9) {
                this.f2672x.getClass();
                a5 = m.a(view, F, z0.d.d(i10, i12, i11, i13));
            } else {
                this.f2672x.getClass();
                a5 = m.a(view, G, z0.d.d(i6, i8, i7, i9));
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                com.google.android.gms.internal.play_billing.i0.S(viewGroup4, true);
                p().a(new c(viewGroup4));
            }
            return a5;
        }
        return null;
    }

    @Override // e1.r
    public final String[] r() {
        return C;
    }
}
