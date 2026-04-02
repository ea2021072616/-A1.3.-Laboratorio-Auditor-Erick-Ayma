package com.aspsine.irecyclerview;

import android.support.v7.widget.RecyclerView;
/* loaded from: classes.dex */
public abstract class OnLoadMoreScrollListener extends RecyclerView.OnScrollListener {
    public abstract void onLoadMore(RecyclerView recyclerView);

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (recyclerView.getLayoutManager().getChildCount() > 0 && i == 0 && canTriggerLoadMore(recyclerView)) {
            onLoadMore(recyclerView);
        }
    }

    public boolean canTriggerLoadMore(RecyclerView recyclerView) {
        return recyclerView.getLayoutManager().getItemCount() + (-1) == recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() + (-1)));
    }
}
