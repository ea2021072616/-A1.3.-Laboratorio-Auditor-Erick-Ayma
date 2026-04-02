package com.fotoable.youtube.music.ui.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes.dex */
public class GridSpacingHorizontalDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int spacing;
    private int spanCount;

    public GridSpacingHorizontalDecoration(int i, int i2, boolean z) {
        this.spanCount = i;
        this.spacing = i2;
        this.includeEdge = z;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = childAdapterPosition % this.spanCount;
        if (this.includeEdge) {
            rect.left = this.spacing - ((this.spacing * i) / this.spanCount);
            rect.right = ((i + 1) * this.spacing) / this.spanCount;
            if (childAdapterPosition < this.spanCount) {
                rect.top = this.spacing;
            }
            rect.bottom = this.spacing;
        } else if (childAdapterPosition >= this.spanCount) {
            rect.left = this.spacing;
        }
    }
}
