package com.foto.indexlib.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* compiled from: SuspensionDecoration.java */
/* loaded from: classes.dex */
public class c extends RecyclerView.ItemDecoration {
    private static int g = -1;
    private static int h = Color.parseColor("#FF999999");
    private static int i;

    /* renamed from: a  reason: collision with root package name */
    private List<? extends com.foto.indexlib.a.a> f2214a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f2215b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f2216c;
    private Rect d;
    private LayoutInflater e;
    private int f;
    private int j = 0;
    private Context k;
    private a l;

    /* compiled from: SuspensionDecoration.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str);
    }

    public c(Context context, List<? extends com.foto.indexlib.a.a> list) {
        Typeface typeface = null;
        try {
            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        this.f2214a = list;
        this.f2215b = new Paint();
        this.f2216c = new Paint();
        this.d = new Rect();
        this.f = (int) TypedValue.applyDimension(1, 30.0f, context.getResources().getDisplayMetrics());
        i = (int) TypedValue.applyDimension(2, 14.0f, context.getResources().getDisplayMetrics());
        this.f2215b.setTextSize(i);
        this.f2215b.setAntiAlias(true);
        if (typeface != null) {
            this.f2215b.setTypeface(typeface);
        }
        this.f2216c.setTextSize(i);
        this.f2216c.setAntiAlias(true);
        this.f2216c.setColor(Color.parseColor("#d9cfd1"));
        this.e = LayoutInflater.from(context);
        this.k = context;
    }

    public c a(List<? extends com.foto.indexlib.a.a> list) {
        this.f2214a = list;
        return this;
    }

    public int a() {
        return this.j;
    }

    public c a(int i2) {
        this.j = i2;
        return this;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition() - a();
            if (this.f2214a != null && !this.f2214a.isEmpty() && viewLayoutPosition <= this.f2214a.size() - 1 && viewLayoutPosition >= 0 && this.f2214a.get(viewLayoutPosition).isShowSuspension() && viewLayoutPosition > -1) {
                if (viewLayoutPosition == 0) {
                    a(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                } else if (this.f2214a.get(viewLayoutPosition).getSuspensionTag() != null && !this.f2214a.get(viewLayoutPosition).getSuspensionTag().equals(this.f2214a.get(viewLayoutPosition - 1).getSuspensionTag())) {
                    a(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                }
            }
        }
    }

    private void a(Canvas canvas, int i2, int i3, View view, RecyclerView.LayoutParams layoutParams, int i4) {
        this.f2215b.setColor(g);
        canvas.drawRect(i2, (view.getTop() - layoutParams.topMargin) - this.f, i3, view.getTop() - layoutParams.topMargin, this.f2215b);
        this.f2215b.setColor(h);
        this.f2215b.getTextBounds(this.f2214a.get(i4).getSuspensionTag(), 0, this.f2214a.get(i4).getSuspensionTag().length(), this.d);
        canvas.drawText(this.f2214a.get(i4).getSuspensionTag(), view.getPaddingLeft() + a(this.k, 16.0f), (view.getTop() - layoutParams.topMargin) - ((this.f / 2) - (this.d.height() / 2)), this.f2215b);
        canvas.drawLine(i2, (view.getTop() - layoutParams.topMargin) - this.f, i3, (view.getTop() - layoutParams.topMargin) - this.f, this.f2216c);
        canvas.drawLine(i2, (view.getTop() - layoutParams.topMargin) - 1, i3, (view.getTop() - layoutParams.topMargin) - 1, this.f2216c);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        boolean z;
        int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() - a();
        if (this.f2214a != null && !this.f2214a.isEmpty() && findFirstVisibleItemPosition <= this.f2214a.size() - 1 && findFirstVisibleItemPosition >= 0 && this.f2214a.get(findFirstVisibleItemPosition).isShowSuspension()) {
            String suspensionTag = this.f2214a.get(findFirstVisibleItemPosition).getSuspensionTag();
            View view = recyclerView.findViewHolderForLayoutPosition(a() + findFirstVisibleItemPosition).itemView;
            if (findFirstVisibleItemPosition + 1 >= this.f2214a.size() || suspensionTag == null || suspensionTag.equals(this.f2214a.get(findFirstVisibleItemPosition + 1).getSuspensionTag()) || view.getHeight() + view.getTop() >= this.f) {
                z = false;
            } else {
                canvas.save();
                canvas.translate(0.0f, (view.getHeight() + view.getTop()) - this.f);
                z = true;
            }
            this.f2215b.setColor(g);
            canvas.drawRect(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getRight() - recyclerView.getPaddingRight(), recyclerView.getPaddingTop() + this.f, this.f2215b);
            this.f2215b.setColor(h);
            this.f2215b.getTextBounds(suspensionTag, 0, suspensionTag.length(), this.d);
            canvas.drawText(suspensionTag, view.getPaddingLeft() + a(this.k, 16.0f), (recyclerView.getPaddingTop() + this.f) - ((this.f / 2) - (this.d.height() / 2)), this.f2215b);
            canvas.drawLine(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop() + this.f, recyclerView.getRight() - recyclerView.getPaddingRight(), recyclerView.getPaddingTop() + this.f, this.f2216c);
            if (this.l != null) {
                this.l.a(suspensionTag);
            }
            if (z) {
                canvas.restore();
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition() - a();
        if (this.f2214a != null && !this.f2214a.isEmpty() && viewLayoutPosition <= this.f2214a.size() - 1 && viewLayoutPosition > -1) {
            com.foto.indexlib.a.a aVar = this.f2214a.get(viewLayoutPosition);
            if (aVar.isShowSuspension()) {
                if (viewLayoutPosition == 0) {
                    rect.set(0, this.f, 0, 0);
                } else if (aVar.getSuspensionTag() != null && !aVar.getSuspensionTag().equals(this.f2214a.get(viewLayoutPosition - 1).getSuspensionTag())) {
                    rect.set(0, this.f, 0, 0);
                }
            }
        }
    }

    public void a(a aVar) {
        this.l = aVar;
    }

    public static int a(Context context, float f) {
        try {
            return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
            return 0;
        }
    }
}
