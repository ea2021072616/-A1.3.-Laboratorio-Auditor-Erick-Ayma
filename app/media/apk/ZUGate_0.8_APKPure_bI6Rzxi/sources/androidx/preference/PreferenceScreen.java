package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import com.github.appintro.R;
import m0.a;
import y0.s;
import y0.y;
/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public final boolean U;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, a.f(context, R.attr.preferenceScreenStyle, 16842891));
        this.U = true;
    }

    @Override // androidx.preference.Preference
    public final void n() {
        y yVar;
        if (this.f1189n != null || this.o != null || C() == 0 || (yVar = this.f1178c.f5593j) == null) {
            return;
        }
        s sVar = (s) yVar;
        for (Fragment fragment = sVar; fragment != null; fragment = fragment.getParentFragment()) {
        }
        sVar.getContext();
        sVar.a();
    }
}
