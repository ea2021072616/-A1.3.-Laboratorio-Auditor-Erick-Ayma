package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.appintro.R;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class f extends ConstraintLayout {

    /* renamed from: w  reason: collision with root package name */
    public final e f2267w;

    /* renamed from: x  reason: collision with root package name */
    public int f2268x;

    /* renamed from: y  reason: collision with root package name */
    public p3.g f2269y;

    /* JADX WARN: Type inference failed for: r7v2, types: [com.google.android.material.timepicker.e] */
    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        p3.g gVar = new p3.g();
        this.f2269y = gVar;
        p3.h hVar = new p3.h(0.5f);
        p3.j jVar = gVar.f4294g.f4274a;
        jVar.getClass();
        w1.h hVar2 = new w1.h(jVar);
        hVar2.f5338e = hVar;
        hVar2.f5339f = hVar;
        hVar2.f5340g = hVar;
        hVar2.f5341h = hVar;
        gVar.setShapeAppearanceModel(new p3.j(hVar2));
        this.f2269y.j(ColorStateList.valueOf(-1));
        p3.g gVar2 = this.f2269y;
        WeakHashMap weakHashMap = z0.f3233a;
        setBackground(gVar2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w2.a.f5404t, R.attr.materialClockStyle, 0);
        this.f2268x = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f2267w = new Runnable() { // from class: com.google.android.material.timepicker.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.m();
            }
        };
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i5, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = z0.f3233a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            e eVar = this.f2267w;
            handler.removeCallbacks(eVar);
            handler.post(eVar);
        }
    }

    public abstract void m();

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        m();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            e eVar = this.f2267w;
            handler.removeCallbacks(eVar);
            handler.post(eVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i5) {
        this.f2269y.j(ColorStateList.valueOf(i5));
    }
}
