package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f319a;

    /* renamed from: b  reason: collision with root package name */
    public final d.u0 f320b;

    public e0(TextView textView) {
        this.f319a = textView;
        this.f320b = new d.u0(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((p3.e) this.f320b.f2463h).f(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i5) {
        TypedArray obtainStyledAttributes = this.f319a.getContext().obtainStyledAttributes(attributeSet, c.a.f1692i, i5, 0);
        try {
            boolean z4 = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
            obtainStyledAttributes.recycle();
            d(z4);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z4) {
        ((p3.e) this.f320b.f2463h).t(z4);
    }

    public final void d(boolean z4) {
        ((p3.e) this.f320b.f2463h).w(z4);
    }
}
