package com.fotoable.youtube.music.ui.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.fotoable.youtube.music.util.h;
/* loaded from: classes.dex */
public class GridSpacingItemDecoration2 extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int spacing;
    private int spanCount;

    public GridSpacingItemDecoration2(int i, int i2, boolean z) {
        this.spanCount = i;
        this.spacing = i2;
        this.includeEdge = z;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (childAdapterPosition > 1 && childAdapterPosition < adapter.getItemCount() - 2) {
            int i = childAdapterPosition % this.spanCount;
            if (this.includeEdge) {
                rect.left = this.spacing - ((this.spacing * i) / this.spanCount);
                rect.right = ((i + 1) * this.spacing) / this.spanCount;
                if (childAdapterPosition < this.spanCount) {
                    rect.top = this.spacing;
                }
                rect.bottom = this.spacing;
                h.a("Grid", "top:" + rect.top + ", position:" + childAdapterPosition);
                return;
            }
            rect.left = (this.spacing * i) / this.spanCount;
            rect.right = this.spacing - (((i + 1) * this.spacing) / this.spanCount);
            if (childAdapterPosition >= this.spanCount) {
                rect.top = this.spacing;
            }
        }
    }
}
