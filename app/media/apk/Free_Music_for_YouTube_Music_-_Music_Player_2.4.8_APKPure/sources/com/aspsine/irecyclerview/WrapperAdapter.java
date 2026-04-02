package com.aspsine.irecyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class WrapperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected static final int FOOTER = 2147483646;
    protected static final int HEADER = -2147483647;
    protected static final int LOAD_MORE_FOOTER = Integer.MAX_VALUE;
    protected static final int REFRESH_HEADER = Integer.MIN_VALUE;
    private final RecyclerView.Adapter mAdapter;
    private final LinearLayout mFooterContainer;
    private final LinearLayout mHeaderContainer;
    private final FrameLayout mLoadMoreFooterContainer;
    private RecyclerView.AdapterDataObserver mObserver = new RecyclerView.AdapterDataObserver() { // from class: com.aspsine.irecyclerview.WrapperAdapter.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            WrapperAdapter.this.notifyDataSetChanged();
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            WrapperAdapter.this.notifyItemRangeChanged(i + 2, i2);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            WrapperAdapter.this.notifyItemRangeChanged(i + 2, i2, obj);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            WrapperAdapter.this.notifyItemRangeInserted(i + 2, i2);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            WrapperAdapter.this.notifyItemRangeRemoved(i + 2, i2);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            WrapperAdapter.this.notifyDataSetChanged();
        }
    };
    private final RefreshHeaderLayout mRefreshHeaderContainer;

    public WrapperAdapter(RecyclerView.Adapter adapter, RefreshHeaderLayout refreshHeaderLayout, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout) {
        this.mAdapter = adapter;
        this.mRefreshHeaderContainer = refreshHeaderLayout;
        this.mHeaderContainer = linearLayout;
        this.mFooterContainer = linearLayout2;
        this.mLoadMoreFooterContainer = frameLayout;
        this.mAdapter.registerAdapterDataObserver(this.mObserver);
    }

    public RecyclerView.Adapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.aspsine.irecyclerview.WrapperAdapter.2
                @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    if (WrapperAdapter.this.isFullSpanType(((WrapperAdapter) recyclerView.getAdapter()).getItemViewType(i))) {
                        return gridLayoutManager.getSpanCount();
                    }
                    if (spanSizeLookup != null) {
                        return spanSizeLookup.getSpanSize(i - 2);
                    }
                    return 1;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (isFullSpanType(getItemViewType(viewHolder.getAdapterPosition()))) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFullSpanType(int i) {
        return i == Integer.MIN_VALUE || i == HEADER || i == FOOTER || i == Integer.MAX_VALUE;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mAdapter.getItemCount() + 4;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return Integer.MIN_VALUE;
        }
        if (i == 1) {
            return HEADER;
        }
        if (1 < i && i < this.mAdapter.getItemCount() + 2) {
            return this.mAdapter.getItemViewType(i - 2);
        }
        if (i == this.mAdapter.getItemCount() + 2) {
            return FOOTER;
        }
        if (i == this.mAdapter.getItemCount() + 3) {
            return Integer.MAX_VALUE;
        }
        throw new IllegalArgumentException("Wrong type! Position = " + i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == Integer.MIN_VALUE) {
            return new RefreshHeaderContainerViewHolder(this.mRefreshHeaderContainer);
        }
        if (i == HEADER) {
            return new HeaderContainerViewHolder(this.mHeaderContainer);
        }
        if (i == FOOTER) {
            return new FooterContainerViewHolder(this.mFooterContainer);
        }
        if (i == Integer.MAX_VALUE) {
            return new LoadMoreFooterContainerViewHolder(this.mLoadMoreFooterContainer);
        }
        return this.mAdapter.onCreateViewHolder(viewGroup, i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (1 < i && i < this.mAdapter.getItemCount() + 2) {
            this.mAdapter.onBindViewHolder(viewHolder, i - 2);
        }
    }

    /* loaded from: classes.dex */
    static class RefreshHeaderContainerViewHolder extends RecyclerView.ViewHolder {
        public RefreshHeaderContainerViewHolder(View view) {
            super(view);
        }
    }

    /* loaded from: classes.dex */
    static class HeaderContainerViewHolder extends RecyclerView.ViewHolder {
        public HeaderContainerViewHolder(View view) {
            super(view);
        }
    }

    /* loaded from: classes.dex */
    static class FooterContainerViewHolder extends RecyclerView.ViewHolder {
        public FooterContainerViewHolder(View view) {
            super(view);
        }
    }

    /* loaded from: classes.dex */
    static class LoadMoreFooterContainerViewHolder extends RecyclerView.ViewHolder {
        public LoadMoreFooterContainerViewHolder(View view) {
            super(view);
        }
    }
}
