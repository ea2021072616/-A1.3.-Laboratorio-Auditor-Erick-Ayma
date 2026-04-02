package androidx.preference;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import y0.a;
import y0.d0;
/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final a T;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CheckBoxPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130968759(0x7f0400b7, float:1.754618E38)
            r1 = 16842895(0x101008f, float:2.369396E-38)
            int r0 = m0.a.f(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            y0.a r1 = new y0.a
            r2 = 0
            r1.<init>(r3, r2)
            r3.T = r1
            int[] r1 = y0.e0.f5606b
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            r5 = 5
            java.lang.String r5 = m0.a.n(r4, r5, r2)
            r3.P = r5
            boolean r5 = r3.O
            if (r5 == 0) goto L29
            r3.i()
        L29:
            r5 = 4
            r0 = 1
            java.lang.String r5 = m0.a.n(r4, r5, r0)
            r3.Q = r5
            boolean r5 = r3.O
            if (r5 != 0) goto L38
            r3.i()
        L38:
            r5 = 2
            boolean r5 = r4.getBoolean(r5, r2)
            r0 = 3
            boolean r5 = r4.getBoolean(r0, r5)
            r3.S = r5
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.CheckBoxPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final void C(View view) {
        boolean z4 = view instanceof CompoundButton;
        if (z4) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.O);
        }
        if (z4) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.T);
        }
    }

    @Override // androidx.preference.Preference
    public final void m(d0 d0Var) {
        super.m(d0Var);
        C(d0Var.q(16908289));
        B(d0Var.q(16908304));
    }

    @Override // androidx.preference.Preference
    public final void t(View view) {
        super.t(view);
        if (((AccessibilityManager) this.f1177b.getSystemService("accessibility")).isEnabled()) {
            C(view.findViewById(16908289));
            B(view.findViewById(16908304));
        }
    }
}
