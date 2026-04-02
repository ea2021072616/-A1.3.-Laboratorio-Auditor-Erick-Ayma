package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.github.appintro.R;
import h0.z0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s.n;
/* loaded from: classes.dex */
class ClockFaceView extends f implements d {
    public final Rect A;
    public final RectF B;
    public final Rect C;
    public final SparseArray D;
    public final c E;
    public final int[] F;
    public final float[] G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public String[] L;
    public float M;
    public final ColorStateList N;

    /* renamed from: z  reason: collision with root package name */
    public final ClockHandView f2248z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = new Rect();
        this.B = new RectF();
        this.C = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.D = sparseArray;
        this.G = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w2.a.f5389d, R.attr.materialClockStyle, 2131952772);
        Resources resources = getResources();
        ColorStateList v5 = p2.a.v(context, obtainStyledAttributes, 1);
        this.N = v5;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f2248z = clockHandView;
        this.H = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = v5.getColorForState(new int[]{16842913}, v5.getDefaultColor());
        this.F = new int[]{colorForState, colorForState, v5.getDefaultColor()};
        clockHandView.f2251i.add(this);
        int defaultColor = p2.a.u(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList v6 = p2.a.v(context, obtainStyledAttributes, 0);
        setBackgroundColor(v6 != null ? v6.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.E = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.L = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z4 = false;
        for (int i5 = 0; i5 < Math.max(this.L.length, size); i5++) {
            TextView textView = (TextView) sparseArray.get(i5);
            if (i5 >= this.L.length) {
                removeView(textView);
                sparseArray.remove(i5);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i5, textView);
                    addView(textView);
                }
                textView.setText(this.L[i5]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i5));
                int i6 = (i5 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i6));
                z4 = i6 > 1 ? true : z4;
                z0.n(textView, this.E);
                textView.setTextColor(this.N);
            }
        }
        ClockHandView clockHandView2 = this.f2248z;
        if (clockHandView2.f2250h && !z4) {
            clockHandView2.f2260s = 1;
        }
        clockHandView2.f2250h = z4;
        clockHandView2.invalidate();
        this.I = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.J = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.K = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.f
    public final void m() {
        n nVar = new n();
        nVar.b(this);
        HashMap hashMap = new HashMap();
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i6 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i6 == null) {
                    i6 = 1;
                }
                if (!hashMap.containsKey(i6)) {
                    hashMap.put(i6, new ArrayList());
                }
                ((List) hashMap.get(i6)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            List<View> list = (List) entry.getValue();
            int round = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.f2268x * 0.66f) : this.f2268x;
            float f5 = 0.0f;
            for (View view : list) {
                int id = view.getId();
                HashMap hashMap2 = nVar.f4792c;
                if (!hashMap2.containsKey(Integer.valueOf(id))) {
                    hashMap2.put(Integer.valueOf(id), new s.i());
                }
                s.j jVar = ((s.i) hashMap2.get(Integer.valueOf(id))).f4715d;
                jVar.f4758z = R.id.circle_center;
                jVar.A = round;
                jVar.B = f5;
                f5 += 360.0f / list.size();
            }
        }
        nVar.a(this);
        setConstraintSet(null);
        requestLayout();
        int i7 = 0;
        while (true) {
            SparseArray sparseArray = this.D;
            if (i7 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i7)).setVisibility(0);
            i7++;
        }
    }

    public final void n() {
        SparseArray sparseArray;
        RectF rectF;
        Rect rect;
        Rect rect2;
        RectF rectF2 = this.f2248z.f2255m;
        float f5 = Float.MAX_VALUE;
        TextView textView = null;
        int i5 = 0;
        while (true) {
            sparseArray = this.D;
            int size = sparseArray.size();
            rectF = this.B;
            rect = this.A;
            if (i5 >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i5);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float height = rectF.height() * rectF.width();
                if (height < f5) {
                    textView = textView2;
                    f5 = height;
                }
            }
            i5++;
        }
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            TextView textView3 = (TextView) sparseArray.get(i6);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.C);
                rectF.inset(rect2.left, rect2.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.F, this.G, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.L.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (this.K / Math.max(Math.max(this.I / displayMetrics.heightPixels, this.J / displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
