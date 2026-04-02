package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import k1.a;
import o1.c;
/* loaded from: classes.dex */
public class BarChart extends a implements p1.a {

    /* renamed from: p0  reason: collision with root package name */
    public boolean f1802p0;

    /* renamed from: q0  reason: collision with root package name */
    public boolean f1803q0;

    /* renamed from: r0  reason: collision with root package name */
    public boolean f1804r0;

    /* renamed from: s0  reason: collision with root package name */
    public boolean f1805s0;

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1802p0 = false;
        this.f1803q0 = true;
        this.f1804r0 = false;
        this.f1805s0 = false;
    }

    @Override // k1.c
    public final c b(float f5, float f6) {
        if (this.f3542h == null) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        c a5 = getHighlighter().a(f5, f6);
        return (a5 == null || !this.f1802p0) ? a5 : new c(a5.f4094a, a5.f4095b, a5.f4096c, a5.f4097d, a5.f4098e, a5.f4100g, 0);
    }

    @Override // p1.a
    public m1.a getBarData() {
        return (m1.a) this.f3542h;
    }

    public void setDrawBarShadow(boolean z4) {
        this.f1804r0 = z4;
    }

    public void setDrawValueAboveBar(boolean z4) {
        this.f1803q0 = z4;
    }

    public void setFitBars(boolean z4) {
        this.f1805s0 = z4;
    }

    public void setHighlightFullBarEnabled(boolean z4) {
        this.f1802p0 = z4;
    }
}
