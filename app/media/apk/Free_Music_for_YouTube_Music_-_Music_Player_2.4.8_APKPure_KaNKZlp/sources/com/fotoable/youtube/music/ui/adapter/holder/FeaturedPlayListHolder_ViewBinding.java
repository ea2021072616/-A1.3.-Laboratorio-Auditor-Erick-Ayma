package com.fotoable.youtube.music.ui.adapter.holder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class FeaturedPlayListHolder_ViewBinding implements Unbinder {
    private FeaturedPlayListHolder target;

    @UiThread
    public FeaturedPlayListHolder_ViewBinding(FeaturedPlayListHolder featuredPlayListHolder, View view) {
        this.target = featuredPlayListHolder;
        featuredPlayListHolder.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeaturedPlayListHolder featuredPlayListHolder = this.target;
        if (featuredPlayListHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        featuredPlayListHolder.recyclerView = null;
    }
}
