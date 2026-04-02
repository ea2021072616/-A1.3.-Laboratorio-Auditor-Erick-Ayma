package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.foto.indexlib.a.a;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* loaded from: classes.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL_LIST = 0;
    public static final int VERTICAL_LIST = 1;
    private Context context;
    private List<? extends a> mDatas;
    private int mOrientation;
    private int mHeaderViewCount = 0;
    private Paint mPaint = new Paint();

    public DividerItemDecoration(Context context, int i) {
        this.context = context;
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(Color.parseColor("#d9cfd1"));
        setOrientation(i);
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.mOrientation = i;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.mOrientation == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int dip2px = dip2px(this.context, 88.0f);
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition() - getHeaderViewCount();
            if (viewLayoutPosition > 0 && this.mDatas != null && !this.mDatas.isEmpty() && viewLayoutPosition <= this.mDatas.size() - 1 && this.mDatas.get(viewLayoutPosition).getSuspensionTag() != null && this.mDatas.get(viewLayoutPosition).getSuspensionTag().equals(this.mDatas.get(viewLayoutPosition - 1).getSuspensionTag())) {
                int bottom = layoutParams.bottomMargin + childAt.getBottom();
                canvas.drawLine(paddingLeft + dip2px, bottom, width, bottom, this.mPaint);
            }
        }
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin + childAt.getRight();
            canvas.drawLine(right, paddingTop, right, height, this.mPaint);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.mOrientation == 1) {
            rect.set(0, 0, 0, 1);
        } else {
            rect.set(0, 0, 1, 0);
        }
    }

    public DividerItemDecoration setmDatas(List<? extends a> list) {
        this.mDatas = list;
        return this;
    }

    public DividerItemDecoration setHeaderViewCount(int i) {
        this.mHeaderViewCount = i;
        return this;
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewCount;
    }

    public static int dip2px(Context context, float f) {
        try {
            return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
            return 0;
        }
    }
}
