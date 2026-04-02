package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
/* loaded from: classes.dex */
public class HScrollLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private final c f1743a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.ads.internal.view.hscroll.a f1744b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1745c;
    private int[] d;
    private int e;
    private float f;
    private a g;
    private int h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager.canScrollHorizontally()) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return calculateDtToFit(layoutManager.getDecoratedLeft(view) - layoutParams.leftMargin, layoutManager.getDecoratedRight(view) + layoutParams.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i) + HScrollLinearLayoutManager.this.e;
            }
            return 0;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return HScrollLinearLayoutManager.this.f / displayMetrics.densityDpi;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public PointF computeScrollVectorForPosition(int i) {
            return HScrollLinearLayoutManager.this.computeScrollVectorForPosition(i);
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        protected int getHorizontalSnapPreference() {
            return -1;
        }
    }

    public HScrollLinearLayoutManager(Context context, c cVar, com.facebook.ads.internal.view.hscroll.a aVar) {
        super(context);
        this.e = 0;
        this.f = 50.0f;
        this.f1745c = context;
        this.f1743a = cVar;
        this.f1744b = aVar;
        this.h = -1;
        this.g = new a(this.f1745c);
    }

    public void a(double d) {
        if (d <= 0.0d) {
            d = 1.0d;
        }
        this.f = (float) (50.0d / d);
        this.g = new a(this.f1745c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.e = i;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int[] iArr;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if ((mode == 1073741824 && getOrientation() == 1) || (mode2 == 1073741824 && getOrientation() == 0)) {
            super.onMeasure(recycler, state, i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.f1744b.b(this.h)) {
            iArr = this.f1744b.a(this.h);
        } else {
            iArr = new int[]{0, 0};
            if (state.getItemCount() >= 1) {
                for (int i3 = 0; i3 < 1; i3++) {
                    this.d = this.f1743a.a(recycler, i3, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (getOrientation() == 0) {
                        iArr[0] = iArr[0] + this.d[0];
                        if (i3 == 0) {
                            iArr[1] = this.d[1] + getPaddingTop() + getPaddingBottom();
                        }
                    } else {
                        iArr[1] = iArr[1] + this.d[1];
                        if (i3 == 0) {
                            iArr[0] = this.d[0] + getPaddingLeft() + getPaddingRight();
                        }
                    }
                }
                if (this.h != -1) {
                    this.f1744b.a(this.h, iArr);
                }
            }
        }
        if (mode == 1073741824) {
            iArr[0] = size;
        }
        if (mode2 == 1073741824) {
            iArr[1] = size2;
        }
        setMeasuredDimension(iArr[0], iArr[1]);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        super.scrollToPositionWithOffset(i, this.e);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        this.g.setTargetPosition(i);
        startSmoothScroll(this.g);
    }
}
