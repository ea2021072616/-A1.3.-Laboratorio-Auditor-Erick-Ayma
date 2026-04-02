package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import y0.i0;
/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    public boolean O;
    public CharSequence P;
    public CharSequence Q;
    public boolean R;
    public boolean S;

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public final void A(boolean z4) {
        boolean z5 = this.O != z4;
        if (z5 || !this.R) {
            this.O = z4;
            this.R = true;
            if (z()) {
                boolean z6 = !z4;
                boolean z7 = z();
                String str = this.f1188m;
                if (z7) {
                    z6 = this.f1178c.c().getBoolean(str, z6);
                }
                if (z4 != z6) {
                    SharedPreferences.Editor b5 = this.f1178c.b();
                    b5.putBoolean(str, z4);
                    if (!this.f1178c.f5588e) {
                        b5.apply();
                    }
                }
            }
            if (z5) {
                j(y());
                i();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.O
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r4.P
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r4.P
            r5.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r4.O
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r4.Q
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r4.Q
            r5.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r2 = r4.g()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L3e
            r5.setText(r2)
            r0 = r1
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L4c
            r5.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.B(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    public final void n() {
        boolean z4 = !this.O;
        if (a(Boolean.valueOf(z4))) {
            A(z4);
        }
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i5) {
        return Boolean.valueOf(typedArray.getBoolean(i5, false));
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(i0.class)) {
            super.q(parcelable);
            return;
        }
        i0 i0Var = (i0) parcelable;
        super.q(i0Var.getSuperState());
        A(i0Var.f5626b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        this.K = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f1193s) {
            return absSavedState;
        }
        i0 i0Var = new i0(absSavedState);
        i0Var.f5626b = this.O;
        return i0Var;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (z()) {
            booleanValue = this.f1178c.c().getBoolean(this.f1188m, booleanValue);
        }
        A(booleanValue);
    }

    @Override // androidx.preference.Preference
    public final boolean y() {
        return (this.S ? this.O : !this.O) || super.y();
    }
}
