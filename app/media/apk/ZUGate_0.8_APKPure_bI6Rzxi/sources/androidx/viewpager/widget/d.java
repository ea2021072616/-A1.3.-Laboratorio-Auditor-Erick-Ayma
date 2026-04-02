package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class d extends ViewGroup.LayoutParams {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1594a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1595b;

    /* renamed from: c  reason: collision with root package name */
    public float f1596c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1597d;

    /* renamed from: e  reason: collision with root package name */
    public int f1598e;

    /* renamed from: f  reason: collision with root package name */
    public int f1599f;

    public d() {
        super(-1, -1);
        this.f1596c = 0.0f;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1596c = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.LAYOUT_ATTRS);
        this.f1595b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
