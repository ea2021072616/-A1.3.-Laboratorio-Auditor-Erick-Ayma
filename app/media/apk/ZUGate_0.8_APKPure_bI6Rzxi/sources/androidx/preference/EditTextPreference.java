package androidx.preference;

import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.AbsSavedState;
import y0.c;
/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    public String U;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public EditTextPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130969023(0x7f0401bf, float:1.7546716E38)
            r1 = 16842898(0x1010092, float:2.3693967E-38)
            int r0 = m0.a.f(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            int[] r1 = y0.e0.f5608d
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            boolean r5 = r4.getBoolean(r2, r2)
            boolean r5 = r4.getBoolean(r2, r5)
            if (r5 == 0) goto L32
            p3.e r5 = p3.e.f4271i
            if (r5 != 0) goto L2b
            p3.e r5 = new p3.e
            r0 = 27
            r5.<init>(r0)
            p3.e.f4271i = r5
        L2b:
            p3.e r5 = p3.e.f4271i
            r3.M = r5
            r3.i()
        L32:
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.EditTextPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final void A(String str) {
        boolean y5 = y();
        this.U = str;
        v(str);
        boolean y6 = y();
        if (y6 != y5) {
            j(y6);
        }
        i();
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i5) {
        return typedArray.getString(i5);
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(c.class)) {
            super.q(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.q(cVar.getSuperState());
        A(cVar.f5596b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        this.K = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f1193s) {
            return absSavedState;
        }
        c cVar = new c(absSavedState);
        cVar.f5596b = this.U;
        return cVar;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        A(f((String) obj));
    }

    @Override // androidx.preference.Preference
    public final boolean y() {
        return TextUtils.isEmpty(this.U) || super.y();
    }
}
