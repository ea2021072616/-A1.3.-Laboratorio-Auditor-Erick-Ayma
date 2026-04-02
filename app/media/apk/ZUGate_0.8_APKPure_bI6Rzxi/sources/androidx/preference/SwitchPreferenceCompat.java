package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import androidx.appcompat.widget.SwitchCompat;
import com.github.appintro.R;
import y0.a;
import y0.d0;
import y0.e0;
/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    public final a T;
    public CharSequence U;
    public CharSequence V;

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.switchPreferenceCompatStyle);
        this.T = new a(this, 2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.f5617m, R.attr.switchPreferenceCompatStyle, 0);
        this.P = m0.a.n(obtainStyledAttributes, 7, 0);
        if (this.O) {
            i();
        }
        this.Q = m0.a.n(obtainStyledAttributes, 6, 1);
        if (!this.O) {
            i();
        }
        this.U = m0.a.n(obtainStyledAttributes, 9, 3);
        i();
        this.V = m0.a.n(obtainStyledAttributes, 8, 4);
        i();
        this.S = obtainStyledAttributes.getBoolean(5, obtainStyledAttributes.getBoolean(2, false));
        obtainStyledAttributes.recycle();
    }

    public final void C(View view) {
        boolean z4 = view instanceof SwitchCompat;
        if (z4) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.O);
        }
        if (z4) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.U);
            switchCompat.setTextOff(this.V);
            switchCompat.setOnCheckedChangeListener(this.T);
        }
    }

    @Override // androidx.preference.Preference
    public final void m(d0 d0Var) {
        super.m(d0Var);
        C(d0Var.q(R.id.switchWidget));
        B(d0Var.q(16908304));
    }

    @Override // androidx.preference.Preference
    public final void t(View view) {
        super.t(view);
        if (((AccessibilityManager) this.f1177b.getSystemService("accessibility")).isEnabled()) {
            C(view.findViewById(R.id.switchWidget));
            B(view.findViewById(16908304));
        }
    }
}
