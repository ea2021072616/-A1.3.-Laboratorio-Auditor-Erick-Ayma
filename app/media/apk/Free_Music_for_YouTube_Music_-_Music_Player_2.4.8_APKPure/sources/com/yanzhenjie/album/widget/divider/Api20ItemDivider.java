package com.yanzhenjie.album.widget.divider;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes2.dex */
public class Api20ItemDivider extends Divider {
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerWidth;

    public Api20ItemDivider(@ColorInt int i) {
        this(i, 4, 4);
    }

    public Api20ItemDivider(@ColorInt int i, int i2, int i3) {
        this.mDivider = new ColorDrawable(i);
        this.mDividerWidth = i2;
        this.mDividerHeight = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int spanCount = getSpanCount(recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        boolean isFirstRaw = isFirstRaw(childLayoutPosition, spanCount);
        boolean isLastRaw = isLastRaw(childLayoutPosition, spanCount, itemCount);
        boolean isFirstColumn = isFirstColumn(childLayoutPosition, spanCount);
        boolean isLastColumn = isLastColumn(childLayoutPosition, spanCount);
        if (spanCount == 1) {
            if (isFirstRaw) {
                rect.set(0, 0, 0, this.mDividerHeight / 2);
            } else if (isLastRaw) {
                rect.set(0, this.mDividerHeight / 2, 0, 0);
            } else {
                rect.set(0, this.mDividerHeight / 2, 0, this.mDividerHeight / 2);
            }
        } else if (isFirstRaw && isFirstColumn) {
            rect.set(0, 0, this.mDividerWidth / 2, this.mDividerHeight / 2);
        } else if (isFirstRaw && isLastColumn) {
            rect.set(this.mDividerWidth / 2, 0, 0, this.mDividerHeight / 2);
        } else if (isFirstRaw) {
            rect.set(this.mDividerWidth / 2, 0, this.mDividerWidth / 2, this.mDividerHeight / 2);
        } else if (isLastRaw && isFirstColumn) {
            rect.set(0, this.mDividerHeight / 2, this.mDividerWidth / 2, 0);
        } else if (isLastRaw && isLastColumn) {
            rect.set(this.mDividerWidth / 2, this.mDividerHeight / 2, 0, 0);
        } else if (isLastRaw) {
            rect.set(this.mDividerWidth / 2, this.mDividerHeight / 2, this.mDividerWidth / 2, 0);
        } else if (isFirstColumn) {
            rect.set(0, this.mDividerHeight / 2, this.mDividerWidth / 2, this.mDividerHeight / 2);
        } else if (isLastColumn) {
            rect.set(this.mDividerWidth / 2, this.mDividerHeight / 2, 0, this.mDividerHeight / 2);
        } else {
            rect.set(this.mDividerWidth / 2, this.mDividerHeight / 2, this.mDividerWidth / 2, this.mDividerHeight / 2);
        }
    }

    private int getSpanCount(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        return 1;
    }

    private boolean isFirstRaw(int i, int i2) {
        return i < i2;
    }

    private boolean isLastRaw(int i, int i2, int i3) {
        if (i2 == 1) {
            return i + 1 == i3;
        }
        int i4 = i3 % i2;
        int i5 = (i4 > 0 ? 1 : 0) + ((i3 - i4) / i2);
        int i6 = (i + 1) % i2;
        return i6 == 0 ? i5 == (i + 1) / i2 : i5 == (((i + 1) - i6) / i2) + 1;
    }

    private boolean isFirstColumn(int i, int i2) {
        return i2 == 1 || i % i2 == 0;
    }

    private boolean isLastColumn(int i, int i2) {
        return i2 == 1 || (i + 1) % i2 == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawHorizontal(canvas, recyclerView);
        drawVertical(canvas, recyclerView);
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        canvas.save();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int left = childAt.getLeft();
            int bottom = childAt.getBottom();
            this.mDivider.setBounds(left, bottom, childAt.getRight(), this.mDividerHeight + bottom);
            this.mDivider.draw(canvas);
        }
        canvas.restore();
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        canvas.save();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight();
            int bottom = childAt.getBottom();
            this.mDivider.setBounds(right, childAt.getTop(), this.mDividerWidth + right, bottom);
            this.mDivider.draw(canvas);
        }
        canvas.restore();
    }

    @Override // com.yanzhenjie.album.widget.divider.Divider
    public int getHeight() {
        return this.mDividerHeight;
    }

    @Override // com.yanzhenjie.album.widget.divider.Divider
    public int getWidth() {
        return this.mDividerWidth;
    }
}
