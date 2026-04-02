package com.google.android.youtube.player.internal;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/* loaded from: classes2.dex */
public final class n extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final ProgressBar f4953a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f4954b;

    public n(Context context) {
        super(context, null, z.c(context));
        m mVar = new m(context);
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4953a = new ProgressBar(context);
        this.f4953a.setVisibility(8);
        addView(this.f4953a, new FrameLayout.LayoutParams(-2, -2, 17));
        int i = (int) ((10.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
        this.f4954b = new TextView(context);
        this.f4954b.setTextAppearance(context, 16973894);
        this.f4954b.setTextColor(-1);
        this.f4954b.setVisibility(8);
        this.f4954b.setPadding(i, i, i, i);
        this.f4954b.setGravity(17);
        this.f4954b.setText(mVar.f4950a);
        addView(this.f4954b, new FrameLayout.LayoutParams(-2, -2, 17));
    }

    public final void a() {
        this.f4953a.setVisibility(8);
        this.f4954b.setVisibility(8);
    }

    public final void b() {
        this.f4953a.setVisibility(0);
        this.f4954b.setVisibility(8);
    }

    public final void c() {
        this.f4953a.setVisibility(8);
        this.f4954b.setVisibility(0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3 = 0;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            i3 = size;
        } else if (mode == 1073741824 || (mode == Integer.MIN_VALUE && mode2 == 0)) {
            size2 = (int) (size / 1.777f);
            i3 = size;
        } else if (mode2 == 1073741824 || (mode2 == Integer.MIN_VALUE && mode == 0)) {
            i3 = (int) (size2 * 1.777f);
        } else if (mode != Integer.MIN_VALUE || mode2 != Integer.MIN_VALUE) {
            size2 = 0;
        } else if (size2 < size / 1.777f) {
            i3 = (int) (size2 * 1.777f);
        } else {
            size2 = (int) (size / 1.777f);
            i3 = size;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(resolveSize(i3, i), 1073741824), View.MeasureSpec.makeMeasureSpec(resolveSize(size2, i2), 1073741824));
    }
}
