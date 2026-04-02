package androidx.preference;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.Switch;
import y0.a;
import y0.d0;
/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    public final a T;
    public CharSequence U;
    public CharSequence V;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SwitchPreference(android.content.Context r5, android.util.AttributeSet r6) {
        /*
            r4 = this;
            r0 = 2130969694(0x7f04045e, float:1.7548077E38)
            r1 = 16843629(0x101036d, float:2.3696016E-38)
            int r0 = m0.a.f(r5, r0, r1)
            r4.<init>(r5, r6, r0)
            y0.a r1 = new y0.a
            r2 = 1
            r1.<init>(r4, r2)
            r4.T = r1
            int[] r1 = y0.e0.f5616l
            r3 = 0
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r6, r1, r0, r3)
            r6 = 7
            java.lang.String r6 = m0.a.n(r5, r6, r3)
            r4.P = r6
            boolean r6 = r4.O
            if (r6 == 0) goto L2a
            r4.i()
        L2a:
            r6 = 6
            java.lang.String r6 = m0.a.n(r5, r6, r2)
            r4.Q = r6
            boolean r6 = r4.O
            if (r6 != 0) goto L38
            r4.i()
        L38:
            r6 = 9
            r0 = 3
            java.lang.String r6 = m0.a.n(r5, r6, r0)
            r4.U = r6
            r4.i()
            r6 = 8
            r0 = 4
            java.lang.String r6 = m0.a.n(r5, r6, r0)
            r4.V = r6
            r4.i()
            r6 = 2
            boolean r6 = r5.getBoolean(r6, r3)
            r0 = 5
            boolean r6 = r5.getBoolean(r0, r6)
            r4.S = r6
            r5.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.SwitchPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final void C(View view) {
        boolean z4 = view instanceof Switch;
        if (z4) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.O);
        }
        if (z4) {
            Switch r42 = (Switch) view;
            r42.setTextOn(this.U);
            r42.setTextOff(this.V);
            r42.setOnCheckedChangeListener(this.T);
        }
    }

    @Override // androidx.preference.Preference
    public final void m(d0 d0Var) {
        super.m(d0Var);
        C(d0Var.q(16908352));
        B(d0Var.q(16908304));
    }

    @Override // androidx.preference.Preference
    public final void t(View view) {
        super.t(view);
        if (((AccessibilityManager) this.f1177b.getSystemService("accessibility")).isEnabled()) {
            C(view.findViewById(16908352));
            B(view.findViewById(16908304));
        }
    }
}
