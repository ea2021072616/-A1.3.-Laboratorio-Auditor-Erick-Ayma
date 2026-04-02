package ru.zdevs.zugate.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.github.appintro.R;
import e4.e;
/* loaded from: classes.dex */
public class StateView extends TextView {

    /* renamed from: g  reason: collision with root package name */
    public final int f4631g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4632h;

    public StateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842827);
        int i5;
        setBackgroundResource(R.drawable.state_bg);
        try {
            i5 = Math.round(2 * context.getResources().getDisplayMetrics().density);
        } catch (Exception unused) {
            i5 = 4;
        }
        setPadding(i5, 0, i5, 0);
        if (isActivated()) {
            setText("RW");
            setTextColor(this.f4631g);
        } else {
            setText("R0");
            setTextColor(this.f4632h);
        }
        this.f4631g = e.m(context, R.attr.colorError);
        this.f4632h = e.m(context, R.attr.colorPrimary);
    }

    public void setRW(boolean z4) {
        setActivated(z4);
        if (isActivated()) {
            setText("RW");
            setTextColor(this.f4631g);
            return;
        }
        setText("R0");
        setTextColor(this.f4632h);
    }
}
