package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import c.a;
/* loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: g  reason: collision with root package name */
    public final int f127g;

    /* renamed from: h  reason: collision with root package name */
    public final int f128h;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f1702t);
        this.f128h = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f127g = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
