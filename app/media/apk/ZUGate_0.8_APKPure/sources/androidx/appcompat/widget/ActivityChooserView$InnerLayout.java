package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f208g = {16842964};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f208g);
        setBackgroundDrawable((!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : p2.a.x(context, resourceId));
        obtainStyledAttributes.recycle();
    }
}
