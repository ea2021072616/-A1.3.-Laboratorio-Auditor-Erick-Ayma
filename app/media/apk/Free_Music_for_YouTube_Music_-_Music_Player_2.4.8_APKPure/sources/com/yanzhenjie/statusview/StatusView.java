package com.yanzhenjie.statusview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
/* loaded from: classes2.dex */
public class StatusView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5199a = false;

    /* renamed from: b  reason: collision with root package name */
    private static int f5200b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f5201c = 0;

    private static void a(View view) {
        if (!f5199a) {
            f5199a = true;
            Context context = view.getContext();
            f5201c = context.getResources().getDisplayMetrics().widthPixels;
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                f5200b = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (Throwable th) {
                Rect rect = new Rect();
                b(view).getWindowVisibleDisplayFrame(rect);
                f5200b = rect.top;
            }
        }
    }

    private static View b(View view) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            return b((View) parent);
        }
        return view;
    }

    public StatusView(Context context) {
        this(context, null, 0);
    }

    public StatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View findViewById;
        a(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StatusView);
        int i2 = obtainStyledAttributes.getInt(R.styleable.StatusView_fitsView, -1);
        obtainStyledAttributes.recycle();
        if (i2 != -1 && (findViewById = b(this).findViewById(i2)) != null && Build.VERSION.SDK_INT < 21 && Build.VERSION.SDK_INT > 14) {
            findViewById.setFitsSystemWindows(true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            setMeasuredDimension(f5201c, f5200b);
            return;
        }
        setMeasuredDimension(0, 0);
        setVisibility(8);
    }
}
