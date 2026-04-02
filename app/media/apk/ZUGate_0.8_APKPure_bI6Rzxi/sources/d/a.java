package d;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class a extends ViewGroup.MarginLayoutParams {

    /* renamed from: a  reason: collision with root package name */
    public int f2278a;

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2278a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f1685b);
        this.f2278a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public a() {
        super(-2, -2);
        this.f2278a = 8388627;
    }

    public a(a aVar) {
        super((ViewGroup.MarginLayoutParams) aVar);
        this.f2278a = 0;
        this.f2278a = aVar.f2278a;
    }

    public a(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f2278a = 0;
    }
}
