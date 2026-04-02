package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class l3 extends d.a {

    /* renamed from: b  reason: collision with root package name */
    public int f410b;

    public l3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f410b = 0;
    }

    public l3() {
        this.f410b = 0;
        this.f2278a = 8388627;
    }

    public l3(l3 l3Var) {
        super((d.a) l3Var);
        this.f410b = 0;
        this.f410b = l3Var.f410b;
    }

    public l3(d.a aVar) {
        super(aVar);
        this.f410b = 0;
    }

    public l3(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f410b = 0;
        ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
    }

    public l3(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f410b = 0;
    }
}
