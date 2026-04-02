package com.fotoable.youtube.music.ui.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes.dex */
public class AlbumItemOffsetDecoration extends RecyclerView.ItemDecoration {
    private int borderOffset;
    private int mItemOffset;

    public AlbumItemOffsetDecoration(int i, int i2) {
        this.mItemOffset = i2;
        this.borderOffset = i;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (childAdapterPosition > 1 && childAdapterPosition < adapter.getItemCount() - 2) {
            if (childAdapterPosition % 2 == 0) {
                i3 = this.borderOffset;
                int i7 = this.mItemOffset / 2;
                if (childAdapterPosition == 2) {
                    i5 = this.borderOffset;
                } else {
                    i5 = this.mItemOffset;
                }
                if (childAdapterPosition == adapter.getItemCount() - 3 || (adapter.getItemCount() % 2 == 0 && childAdapterPosition == adapter.getItemCount() - 4)) {
                    i6 = i7;
                    i2 = i5;
                    i = this.borderOffset;
                } else {
                    i6 = i7;
                    i2 = i5;
                    i = 0;
                }
            } else if (childAdapterPosition % 2 == 1) {
                i3 = this.mItemOffset / 2;
                int i8 = this.borderOffset;
                if (childAdapterPosition == 3) {
                    i4 = this.borderOffset;
                } else {
                    i4 = this.mItemOffset;
                }
                if (childAdapterPosition == adapter.getItemCount() - 3) {
                    i6 = i8;
                    i2 = i4;
                    i = this.borderOffset;
                } else {
                    i6 = i8;
                    i2 = i4;
                    i = 0;
                }
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
            }
            rect.set(i3, i2, i6, i);
        }
    }
}
