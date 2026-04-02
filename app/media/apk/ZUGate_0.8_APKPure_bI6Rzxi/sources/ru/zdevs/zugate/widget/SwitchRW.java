package ru.zdevs.zugate.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.github.appintro.R;
import e4.e;
/* loaded from: classes.dex */
public class SwitchRW extends CompoundButton {

    /* renamed from: g  reason: collision with root package name */
    public final int f4633g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4634h;

    public SwitchRW(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842827);
        int i5;
        setBackgroundResource(R.drawable.switch_bg);
        try {
            i5 = Math.round(6 * context.getResources().getDisplayMetrics().density);
        } catch (Exception unused) {
            i5 = 12;
        }
        setPadding(i5, 0, i5, 0);
        a();
        this.f4633g = e.m(context, R.attr.colorError);
        this.f4634h = e.m(context, R.attr.colorPrimary);
    }

    public final void a() {
        if (isChecked()) {
            setText("RW");
            setTextColor(this.f4633g);
            setGravity(21);
            return;
        }
        setText("R0");
        setTextColor(this.f4634h);
        setGravity(19);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        super.setChecked(z4);
        a();
    }
}
