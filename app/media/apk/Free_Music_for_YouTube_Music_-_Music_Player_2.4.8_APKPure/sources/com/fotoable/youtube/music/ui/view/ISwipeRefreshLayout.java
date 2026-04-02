package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class ISwipeRefreshLayout extends SwipeRefreshLayout {
    public ISwipeRefreshLayout(Context context) {
        super(context);
    }

    public ISwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        return isRefreshing();
    }
}
