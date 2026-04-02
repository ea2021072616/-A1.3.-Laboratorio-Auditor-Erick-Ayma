package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class CategoryPlaylistFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CategoryPlaylistFragment f4494a;

    @UiThread
    public CategoryPlaylistFragment_ViewBinding(CategoryPlaylistFragment categoryPlaylistFragment, View view) {
        this.f4494a = categoryPlaylistFragment;
        categoryPlaylistFragment.recycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recycleView'", RecyclerView.class);
        categoryPlaylistFragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refreshLayout, "field 'refreshLayout'", SwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CategoryPlaylistFragment categoryPlaylistFragment = this.f4494a;
        if (categoryPlaylistFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4494a = null;
        categoryPlaylistFragment.recycleView = null;
        categoryPlaylistFragment.refreshLayout = null;
    }
}
