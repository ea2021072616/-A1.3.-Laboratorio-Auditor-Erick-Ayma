package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final androidx.appcompat.widget.s f2109a;

    /* renamed from: b  reason: collision with root package name */
    public final androidx.appcompat.widget.s f2110b;

    public d(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e4.e.P(R.attr.materialCalendarStyle, context, l.class.getCanonicalName()).data, w2.a.f5397l);
        androidx.appcompat.widget.s.b(context, obtainStyledAttributes.getResourceId(4, 0));
        androidx.appcompat.widget.s.b(context, obtainStyledAttributes.getResourceId(2, 0));
        androidx.appcompat.widget.s.b(context, obtainStyledAttributes.getResourceId(3, 0));
        androidx.appcompat.widget.s.b(context, obtainStyledAttributes.getResourceId(5, 0));
        ColorStateList v5 = p2.a.v(context, obtainStyledAttributes, 7);
        this.f2109a = androidx.appcompat.widget.s.b(context, obtainStyledAttributes.getResourceId(9, 0));
        androidx.appcompat.widget.s.b(context, obtainStyledAttributes.getResourceId(8, 0));
        this.f2110b = androidx.appcompat.widget.s.b(context, obtainStyledAttributes.getResourceId(10, 0));
        new Paint().setColor(v5.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
