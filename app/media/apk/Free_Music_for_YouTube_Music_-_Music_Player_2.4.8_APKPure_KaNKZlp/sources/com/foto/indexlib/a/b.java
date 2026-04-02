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
/* compiled from: NewSuspensionDecoration.java */
/* loaded from: classes.dex */
public class b extends RecyclerView.ItemDecoration {
    private static int g = -1;
    private static int h = Color.parseColor("#FF999999");
    private static int i;

    /* renamed from: a  reason: collision with root package name */
    private List<? extends com.foto.indexlib.a.a> f2211a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f2212b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f2213c;
    private Rect d;
    private LayoutInflater e;
    private int f;
    private int j = 0;
    private Context k;
    private a l;

    /* compiled from: NewSuspensionDecoration.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str);
    }

    public b(Context context, List<? extends com.foto.indexlib.a.a> list) {
        Typeface typeface = null;
        try {
            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Regular.ttf");
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        this.f2211a = list;
        this.f2212b = new Paint();
        this.f2213c = new Paint();
        this.d = new Rect();
        this.f = (int) TypedValue.applyDimension(1, 30.0f, context.getResources().getDisplayMetrics());
        i = (int) TypedValue.applyDimension(2, 14.0f, context.getResources().getDisplayMetrics());
        this.f2212b.setTextSize(i);
        this.f2212b.setAntiAlias(true);
        if (typeface != null) {
            this.f2212b.setTypeface(typeface);
        }
        this.f2213c.setTextSize(i);
        this.f2213c.setAntiAlias(true);
        this.f2213c.setColor(Color.parseColor("#d9cfd1"));
        this.e = LayoutInflater.from(context);
        this.k = context;
    }

    public b a(List<? extends com.foto.indexlib.a.a> list) {
        this.f2211a = list;
        return this;
    }

    public int a() {
        return this.j;
    }

    public b a(int i2) {
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
            if (this.f2211a != null && !this.f2211a.isEmpty() && viewLayoutPosition <= this.f2211a.size() - 1 && viewLayoutPosition >= 0 && this.f2211a.get(viewLayoutPosition).isShowSuspension() && viewLayoutPosition > -1) {
                if (viewLayoutPosition == 0) {
                    a(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                } else if (this.f2211a.get(viewLayoutPosition).getSuspensionTag() != null && !this.f2211a.get(viewLayoutPosition).getSuspensionTag().equals(this.f2211a.get(viewLayoutPosition - 1).getSuspensionTag())) {
                    a(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                }
            }
        }
    }

    private void a(Canvas canvas, int i2, int i3, View view, RecyclerView.LayoutParams layoutParams, int i4) {
        this.f2212b.setColor(g);
        this.f2212b.setColor(h);
        this.f2212b.getTextBounds(this.f2211a.get(i4).getSuspensionTag(), 0, this.f2211a.get(i4).getSuspensionTag().length(), this.d);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        boolean z;
        int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() - a();
        if (this.f2211a != null && !this.f2211a.isEmpty() && findFirstVisibleItemPosition <= this.f2211a.size() - 1 && findFirstVisibleItemPosition >= 0 && this.f2211a.get(findFirstVisibleItemPosition).isShowSuspension()) {
            String suspensionTag = this.f2211a.get(findFirstVisibleItemPosition).getSuspensionTag();
            View view = recyclerView.findViewHolderForLayoutPosition(a() + findFirstVisibleItemPosition).itemView;
            if (findFirstVisibleItemPosition + 1 >= this.f2211a.size() || suspensionTag == null || suspensionTag.equals(this.f2211a.get(findFirstVisibleItemPosition + 1).getSuspensionTag()) || view.getHeight() + view.getTop() >= this.f) {
                z = false;
            } else {
                canvas.save();
                z = true;
                canvas.translate(0.0f, (view.getTop() + view.getHeight()) - this.f);
            }
            this.f2212b.setColor(g);
            this.f2212b.setColor(h);
            this.f2212b.getTextBounds(suspensionTag, 0, suspensionTag.length(), this.d);
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
        if (this.f2211a != null && !this.f2211a.isEmpty() && viewLayoutPosition <= this.f2211a.size() - 1 && viewLayoutPosition > -1) {
            com.foto.indexlib.a.a aVar = this.f2211a.get(viewLayoutPosition);
            if (!aVar.isShowSuspension() || viewLayoutPosition == 0 || aVar.getSuspensionTag() == null || !aVar.getSuspensionTag().equals(this.f2211a.get(viewLayoutPosition - 1).getSuspensionTag())) {
            }
        }
    }

    public void a(a aVar) {
        this.l = aVar;
    }
}
