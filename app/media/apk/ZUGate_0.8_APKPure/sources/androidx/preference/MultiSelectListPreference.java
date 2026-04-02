package androidx.preference;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.util.HashSet;
import java.util.Set;
import y0.h;
/* loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {
    public final CharSequence[] U;
    public final CharSequence[] V;
    public final HashSet W;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MultiSelectListPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130968985(0x7f040199, float:1.754664E38)
            r1 = 16842897(0x1010091, float:2.3693964E-38)
            int r0 = m0.a.f(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r3.W = r1
            int[] r1 = y0.e0.f5610f
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            r5 = 2
            java.lang.CharSequence[] r5 = r4.getTextArray(r5)
            if (r5 != 0) goto L26
            java.lang.CharSequence[] r5 = r4.getTextArray(r2)
        L26:
            r3.U = r5
            r5 = 3
            java.lang.CharSequence[] r5 = r4.getTextArray(r5)
            if (r5 != 0) goto L34
            r5 = 1
            java.lang.CharSequence[] r5 = r4.getTextArray(r5)
        L34:
            r3.V = r5
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.MultiSelectListPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public CharSequence[] A() {
        return this.U;
    }

    public CharSequence[] B() {
        return this.V;
    }

    public void C(Set set) {
        HashSet hashSet = this.W;
        hashSet.clear();
        hashSet.addAll(set);
        if (z()) {
            boolean z4 = z();
            String str = this.f1188m;
            if (!set.equals(z4 ? this.f1178c.c().getStringSet(str, null) : null)) {
                SharedPreferences.Editor b5 = this.f1178c.b();
                b5.putStringSet(str, set);
                if (!this.f1178c.f5588e) {
                    b5.apply();
                }
            }
        }
        i();
    }

    @Override // androidx.preference.Preference
    public Object p(TypedArray typedArray, int i5) {
        CharSequence[] textArray = typedArray.getTextArray(i5);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(h.class)) {
            super.q(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.q(hVar.getSuperState());
        C(hVar.f5621b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        this.K = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f1193s) {
            return absSavedState;
        }
        h hVar = new h(absSavedState);
        hVar.f5621b = this.W;
        return hVar;
    }

    @Override // androidx.preference.Preference
    public void s(Object obj) {
        Set<String> set = (Set) obj;
        if (z()) {
            set = this.f1178c.c().getStringSet(this.f1188m, set);
        }
        C(set);
    }
}
