package com.yanzhenjie.album.widget.photoview.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;
@TargetApi(14)
/* loaded from: classes2.dex */
public class IcsScroller extends GingerScroller {
    public IcsScroller(Context context) {
        super(context);
    }

    @Override // com.yanzhenjie.album.widget.photoview.scrollerproxy.GingerScroller, com.yanzhenjie.album.widget.photoview.scrollerproxy.ScrollerProxy
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }
}
