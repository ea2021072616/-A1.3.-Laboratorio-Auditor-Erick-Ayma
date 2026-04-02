package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import com.github.appintro.R;
import m0.a;
import p3.e;
import y0.e0;
import y0.f;
import y0.o;
/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public final CharSequence[] U;
    public final CharSequence[] V;
    public String W;
    public String X;
    public boolean Y;

    public ListPreference(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.f5609e, i5, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(2);
        this.U = textArray == null ? obtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = obtainStyledAttributes.getTextArray(3);
        this.V = textArray2 == null ? obtainStyledAttributes.getTextArray(1) : textArray2;
        if (obtainStyledAttributes.getBoolean(4, obtainStyledAttributes.getBoolean(4, false))) {
            if (e.f4272j == null) {
                e.f4272j = new e(28);
            }
            this.M = e.f4272j;
            i();
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, e0.f5611g, i5, 0);
        this.X = a.n(obtainStyledAttributes2, 33, 7);
        obtainStyledAttributes2.recycle();
    }

    public final int A(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.V) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public final CharSequence B() {
        CharSequence[] charSequenceArr;
        int A = A(this.W);
        if (A < 0 || (charSequenceArr = this.U) == null) {
            return null;
        }
        return charSequenceArr[A];
    }

    public final void C(String str) {
        boolean z4 = !TextUtils.equals(this.W, str);
        if (z4 || !this.Y) {
            this.W = str;
            this.Y = true;
            v(str);
            if (z4) {
                i();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final CharSequence g() {
        o oVar = this.M;
        if (oVar != null) {
            return ((e) oVar).s(this);
        }
        CharSequence B = B();
        CharSequence g5 = super.g();
        String str = this.X;
        if (str == null) {
            return g5;
        }
        Object[] objArr = new Object[1];
        if (B == null) {
            B = "";
        }
        objArr[0] = B;
        String format = String.format(str, objArr);
        if (TextUtils.equals(format, g5)) {
            return g5;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i5) {
        return typedArray.getString(i5);
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(f.class)) {
            super.q(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.q(fVar.getSuperState());
        C(fVar.f5618b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        this.K = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f1193s) {
            return absSavedState;
        }
        f fVar = new f(absSavedState);
        fVar.f5618b = this.W;
        return fVar;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        C(f((String) obj));
    }

    @Override // androidx.preference.Preference
    public final void x(CharSequence charSequence) {
        super.x(charSequence);
        if (charSequence == null) {
            this.X = null;
        } else {
            this.X = ((String) charSequence).toString();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.f(context, R.attr.dialogPreferenceStyle, 16842897));
    }
}
