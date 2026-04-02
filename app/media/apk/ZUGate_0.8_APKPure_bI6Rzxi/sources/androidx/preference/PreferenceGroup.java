package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import java.util.ArrayList;
import l.j;
import y0.e0;
import y0.t;
/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public final j O;
    public final ArrayList P;
    public boolean Q;
    public int R;
    public boolean S;
    public int T;

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.O = new j();
        new Handler(Looper.getMainLooper());
        this.Q = true;
        this.R = 0;
        this.S = false;
        this.T = Integer.MAX_VALUE;
        this.P = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.f5613i, i5, 0);
        this.Q = obtainStyledAttributes.getBoolean(2, obtainStyledAttributes.getBoolean(2, true));
        if (obtainStyledAttributes.hasValue(1)) {
            D(obtainStyledAttributes.getInt(1, obtainStyledAttributes.getInt(1, Integer.MAX_VALUE)));
        }
        obtainStyledAttributes.recycle();
    }

    public final Preference A(CharSequence charSequence) {
        Preference A;
        if (charSequence != null) {
            if (TextUtils.equals(this.f1188m, charSequence)) {
                return this;
            }
            int C = C();
            for (int i5 = 0; i5 < C; i5++) {
                Preference B = B(i5);
                if (TextUtils.equals(B.f1188m, charSequence)) {
                    return B;
                }
                if ((B instanceof PreferenceGroup) && (A = ((PreferenceGroup) B).A(charSequence)) != null) {
                    return A;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("Key cannot be null");
    }

    public final Preference B(int i5) {
        return (Preference) this.P.get(i5);
    }

    public final int C() {
        return this.P.size();
    }

    public final void D(int i5) {
        if (i5 != Integer.MAX_VALUE && !(!TextUtils.isEmpty(this.f1188m))) {
            Log.e("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
        }
        this.T = i5;
    }

    @Override // androidx.preference.Preference
    public final void b(Bundle bundle) {
        super.b(bundle);
        int C = C();
        for (int i5 = 0; i5 < C; i5++) {
            B(i5).b(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void c(Bundle bundle) {
        super.c(bundle);
        int C = C();
        for (int i5 = 0; i5 < C; i5++) {
            B(i5).c(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void j(boolean z4) {
        super.j(z4);
        int C = C();
        for (int i5 = 0; i5 < C; i5++) {
            Preference B = B(i5);
            if (B.f1197w == z4) {
                B.f1197w = !z4;
                B.j(B.y());
                B.i();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void k() {
        super.k();
        this.S = true;
        int C = C();
        for (int i5 = 0; i5 < C; i5++) {
            B(i5).k();
        }
    }

    @Override // androidx.preference.Preference
    public final void o() {
        super.o();
        this.S = false;
        int C = C();
        for (int i5 = 0; i5 < C; i5++) {
            B(i5).o();
        }
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(t.class)) {
            super.q(parcelable);
            return;
        }
        t tVar = (t) parcelable;
        this.T = tVar.f5644b;
        super.q(tVar.getSuperState());
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        this.K = true;
        return new t(AbsSavedState.EMPTY_STATE, this.T);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
