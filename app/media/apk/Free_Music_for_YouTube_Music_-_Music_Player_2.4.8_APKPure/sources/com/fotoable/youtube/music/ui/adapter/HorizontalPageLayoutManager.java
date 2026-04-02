package com.fotoable.youtube.music.ui.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class HorizontalPageLayoutManager extends RecyclerView.LayoutManager implements PageDecorationLastJudge {
    int columns;
    int itemHeightUsed;
    int itemWidthUsed;
    int onePageSize;
    int rows;
    int totalHeight = 0;
    int totalWidth = 0;
    int offsetY = 0;
    int offsetX = 0;
    private SparseArray<Rect> allItemFrames = new SparseArray<>();
    int pageSize = 0;
    int itemWidth = 0;
    int itemHeight = 0;

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return null;
    }

    public HorizontalPageLayoutManager(int i, int i2) {
        this.rows = 0;
        this.columns = 0;
        this.onePageSize = 0;
        this.rows = i;
        this.columns = i2;
        this.onePageSize = i * i2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int i2 = this.offsetX + i;
        if (i2 > this.totalWidth) {
            i = this.totalWidth - this.offsetX;
        } else if (i2 < 0) {
            i = 0 - this.offsetX;
        }
        this.offsetX += i;
        offsetChildrenHorizontal(-i);
        recycleAndFillItems(recycler, state);
        return i;
    }

    private int getUsableWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int getUsableHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
        } else if (!state.isPreLayout()) {
            this.itemWidth = getUsableWidth() / this.columns;
            this.itemHeight = getUsableHeight() / this.rows;
            this.itemWidthUsed = (this.columns - 1) * this.itemWidth;
            this.itemHeightUsed = (this.rows - 1) * this.itemHeight;
            this.pageSize = (getItemCount() % this.onePageSize == 0 ? 0 : 1) + (getItemCount() / this.onePageSize);
            this.totalWidth = (this.pageSize - 1) * getWidth();
            detachAndScrapAttachedViews(recycler);
            int itemCount = getItemCount();
            for (int i2 = 0; i2 < this.pageSize; i2 = i + 1) {
                int i3 = 0;
                i = i2;
                while (i3 < this.rows) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.columns) {
                            break;
                        }
                        int i5 = (this.onePageSize * i) + (this.columns * i3) + i4;
                        if (i5 == itemCount) {
                            int i6 = this.columns;
                            i3 = this.rows;
                            i = this.pageSize;
                            break;
                        }
                        View viewForPosition = recycler.getViewForPosition(i5);
                        addView(viewForPosition);
                        measureChildWithMargins(viewForPosition, this.itemWidthUsed, this.itemHeightUsed);
                        int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                        int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                        Rect rect = this.allItemFrames.get(i5);
                        if (rect == null) {
                            rect = new Rect();
                        }
                        int usableWidth = (getUsableWidth() * i) + (this.itemWidth * i4);
                        int i7 = this.itemHeight * i3;
                        rect.set(usableWidth, i7, decoratedMeasuredWidth + usableWidth, decoratedMeasuredHeight + i7);
                        this.allItemFrames.put(i5, rect);
                        i4++;
                    }
                    i = i;
                    i3++;
                }
                removeAndRecycleAllViews(recycler);
            }
            recycleAndFillItems(recycler, state);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        this.offsetX = 0;
        this.offsetY = 0;
    }

    private void recycleAndFillItems(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i = 0;
        if (!state.isPreLayout()) {
            Rect rect = new Rect(getPaddingLeft() + this.offsetX, getPaddingTop(), ((getWidth() - getPaddingLeft()) - getPaddingRight()) + this.offsetX, (getHeight() - getPaddingTop()) - getPaddingBottom());
            Rect rect2 = new Rect();
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                rect2.left = getDecoratedLeft(childAt);
                rect2.top = getDecoratedTop(childAt);
                rect2.right = getDecoratedRight(childAt);
                rect2.bottom = getDecoratedBottom(childAt);
                if (!Rect.intersects(rect, rect2)) {
                    removeAndRecycleView(childAt, recycler);
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < getItemCount()) {
                    if (Rect.intersects(rect, this.allItemFrames.get(i3))) {
                        View viewForPosition = recycler.getViewForPosition(i3);
                        addView(viewForPosition);
                        measureChildWithMargins(viewForPosition, this.itemWidthUsed, this.itemHeightUsed);
                        Rect rect3 = this.allItemFrames.get(i3);
                        layoutDecorated(viewForPosition, rect3.left - this.offsetX, rect3.top, rect3.right - this.offsetX, rect3.bottom);
                    }
                    i = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.fotoable.youtube.music.ui.adapter.PageDecorationLastJudge
    public boolean isLastRow(int i) {
        int i2;
        return i >= 0 && i < getItemCount() && (i2 = (i % this.onePageSize) + 1) > (this.rows + (-1)) * this.columns && i2 <= this.onePageSize;
    }

    @Override // com.fotoable.youtube.music.ui.adapter.PageDecorationLastJudge
    public boolean isLastColumn(int i) {
        return i >= 0 && i < getItemCount() && (i + 1) % this.columns == 0;
    }

    @Override // com.fotoable.youtube.music.ui.adapter.PageDecorationLastJudge
    public boolean isPageLast(int i) {
        return (i + 1) % this.onePageSize == 0;
    }
}
