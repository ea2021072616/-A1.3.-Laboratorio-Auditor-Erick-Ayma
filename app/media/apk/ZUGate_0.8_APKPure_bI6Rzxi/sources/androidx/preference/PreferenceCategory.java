package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.github.appintro.R;
import m0.a;
import y0.d0;
/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, a.f(context, R.attr.preferenceCategoryStyle, 16842892));
    }

    @Override // androidx.preference.Preference
    public final boolean h() {
        return false;
    }

    @Override // androidx.preference.Preference
    public final void m(d0 d0Var) {
        super.m(d0Var);
        if (Build.VERSION.SDK_INT >= 28) {
            d0Var.f1376a.setAccessibilityHeading(true);
        }
    }

    @Override // androidx.preference.Preference
    public final boolean y() {
        return !super.h();
    }
}
