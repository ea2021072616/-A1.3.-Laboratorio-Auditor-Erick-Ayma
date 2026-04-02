package e1;

import android.animation.ObjectAnimator;
import android.view.View;
import com.github.appintro.R;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class g extends r {
    public static final String[] D = {"android:visibility:visibility", "android:visibility:parent"};
    public int C;

    public g() {
        this.C = 3;
    }

    public static float N(a0 a0Var, float f5) {
        Float f6;
        return (a0Var == null || (f6 = (Float) a0Var.f2585a.get("android:fade:transitionAlpha")) == null) ? f5 : f6.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static e1.n0 O(e1.a0 r8, e1.a0 r9) {
        /*
            e1.n0 r0 = new e1.n0
            r0.<init>()
            r1 = 0
            r0.f2632a = r1
            r0.f2633b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f2585a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f2634c = r7
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f2636e = r6
            goto L33
        L2f:
            r0.f2634c = r4
            r0.f2636e = r3
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f2585a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r3 = r6.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f2635d = r3
            java.lang.Object r2 = r6.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f2637f = r2
            goto L56
        L52:
            r0.f2635d = r4
            r0.f2637f = r3
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f2634c
            int r9 = r0.f2635d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f2636e
            android.view.ViewGroup r4 = r0.f2637f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f2633b = r1
            r0.f2632a = r2
            goto L9f
        L71:
            if (r9 != 0) goto L9f
            r0.f2633b = r2
            r0.f2632a = r2
            goto L9f
        L78:
            android.view.ViewGroup r8 = r0.f2637f
            if (r8 != 0) goto L81
            r0.f2633b = r1
            r0.f2632a = r2
            goto L9f
        L81:
            android.view.ViewGroup r8 = r0.f2636e
            if (r8 != 0) goto L9f
            r0.f2633b = r2
            r0.f2632a = r2
            goto L9f
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f2635d
            if (r8 != 0) goto L95
            r0.f2633b = r2
            r0.f2632a = r2
            goto L9f
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f2634c
            if (r8 != 0) goto L9f
            r0.f2633b = r1
            r0.f2632a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.g.O(e1.a0, e1.a0):e1.n0");
    }

    public final void L(a0 a0Var) {
        View view = a0Var.f2586b;
        int visibility = view.getVisibility();
        HashMap hashMap = a0Var.f2585a;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    public final ObjectAnimator M(View view, float f5, float f6) {
        if (f5 == f6) {
            return null;
        }
        c0.f2590a.S(view, f5);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c0.f2591b, f6);
        f fVar = new f(view);
        ofFloat.addListener(fVar);
        p().a(fVar);
        return ofFloat;
    }

    @Override // e1.r
    public final void e(a0 a0Var) {
        L(a0Var);
    }

    @Override // e1.r
    public final void h(a0 a0Var) {
        L(a0Var);
        View view = a0Var.f2586b;
        Float f5 = (Float) view.getTag(R.id.transition_pause_alpha);
        if (f5 == null) {
            f5 = view.getVisibility() == 0 ? Float.valueOf(c0.f2590a.w(view)) : Float.valueOf(0.0f);
        }
        a0Var.f2585a.put("android:fade:transitionAlpha", f5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (O(o(r3, false), s(r3, false)).f2632a != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c8  */
    @Override // e1.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator l(android.view.ViewGroup r20, e1.a0 r21, e1.a0 r22) {
        /*
            Method dump skipped, instructions count: 701
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.g.l(android.view.ViewGroup, e1.a0, e1.a0):android.animation.Animator");
    }

    @Override // e1.r
    public final /* bridge */ /* synthetic */ String[] r() {
        return D;
    }

    @Override // e1.r
    public final boolean u(a0 a0Var, a0 a0Var2) {
        if ((a0Var != null || a0Var2 != null) && (a0Var == null || a0Var2 == null || a0Var2.f2585a.containsKey("android:visibility:visibility") == a0Var.f2585a.containsKey("android:visibility:visibility"))) {
            n0 O = O(a0Var, a0Var2);
            if (O.f2632a && (O.f2634c == 0 || O.f2635d == 0)) {
                return true;
            }
        }
        return false;
    }

    public g(int i5) {
        this.C = 3;
        if ((i5 & (-4)) == 0) {
            this.C = i5;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}
