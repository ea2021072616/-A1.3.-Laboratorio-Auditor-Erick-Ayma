package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.r;
import com.github.appintro.R;
import m0.a;
import y0.d;
import y0.e0;
import y0.g;
import y0.j;
import y0.s;
import y0.x;
/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    public final CharSequence O;
    public final String P;
    public final Drawable Q;
    public final String R;
    public final String S;
    public final int T;

    public DialogPreference(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.f5607c, i5, 0);
        String n5 = a.n(obtainStyledAttributes, 9, 0);
        this.O = n5;
        if (n5 == null) {
            this.O = this.f1184i;
        }
        this.P = a.n(obtainStyledAttributes, 8, 1);
        Drawable drawable = obtainStyledAttributes.getDrawable(6);
        this.Q = drawable == null ? obtainStyledAttributes.getDrawable(2) : drawable;
        this.R = a.n(obtainStyledAttributes, 11, 3);
        this.S = a.n(obtainStyledAttributes, 10, 4);
        this.T = obtainStyledAttributes.getResourceId(7, obtainStyledAttributes.getResourceId(5, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void n() {
        r jVar;
        x xVar = this.f1178c.f5592i;
        if (xVar != null) {
            s sVar = (s) xVar;
            for (Fragment fragment = sVar; fragment != null; fragment = fragment.getParentFragment()) {
            }
            sVar.getContext();
            sVar.a();
            if (sVar.getParentFragmentManager().C("androidx.preference.PreferenceFragment.DIALOG") != null) {
                return;
            }
            boolean z4 = this instanceof EditTextPreference;
            String str = this.f1188m;
            if (z4) {
                jVar = new d();
                Bundle bundle = new Bundle(1);
                bundle.putString("key", str);
                jVar.setArguments(bundle);
            } else if (this instanceof ListPreference) {
                jVar = new g();
                Bundle bundle2 = new Bundle(1);
                bundle2.putString("key", str);
                jVar.setArguments(bundle2);
            } else if (!(this instanceof MultiSelectListPreference)) {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            } else {
                jVar = new j();
                Bundle bundle3 = new Bundle(1);
                bundle3.putString("key", str);
                jVar.setArguments(bundle3);
            }
            jVar.setTargetFragment(sVar, 0);
            jVar.j(sVar.getParentFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.f(context, R.attr.dialogPreferenceStyle, 16842897));
    }
}
