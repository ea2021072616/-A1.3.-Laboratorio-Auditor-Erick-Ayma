package com.yanzhenjie.statusview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
/* loaded from: classes2.dex */
public class NavigationView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5196a = false;

    /* renamed from: b  reason: collision with root package name */
    private static int f5197b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f5198c = 0;

    private static void a(View view) {
        if (!f5196a) {
            f5196a = true;
            Context context = view.getContext();
            f5198c = context.getResources().getDisplayMetrics().widthPixels;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                defaultDisplay.getClass().getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                f5197b = displayMetrics.heightPixels - a(defaultDisplay);
            } catch (Exception e) {
            }
        }
    }

    private static int a(Display display) {
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            display.getSize(point);
            return point.y;
        }
        return display.getHeight();
    }

    private static View b(View view) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            return b((View) parent);
        }
        return view;
    }

    public NavigationView(Context context) {
        this(context, null, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
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
            setMeasuredDimension(f5198c, f5197b);
            return;
        }
        setMeasuredDimension(0, 0);
        setVisibility(8);
    }
}
