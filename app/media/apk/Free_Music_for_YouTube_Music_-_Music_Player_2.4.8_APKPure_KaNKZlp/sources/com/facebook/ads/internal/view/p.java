package com.facebook.ads.internal.view;

import android.content.Context;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class p extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f1778a;

    /* renamed from: b  reason: collision with root package name */
    private int f1779b;

    public p(Context context) {
        super(context);
        this.f1778a = 0;
        this.f1779b = 0;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1779b > 0 && getMeasuredWidth() > this.f1779b) {
            setMeasuredDimension(this.f1779b, getMeasuredHeight());
        } else if (getMeasuredWidth() < this.f1778a) {
            setMeasuredDimension(this.f1778a, getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMaxWidth(int i) {
        this.f1779b = i;
    }

    public void setMinWidth(int i) {
        this.f1778a = i;
    }
}
