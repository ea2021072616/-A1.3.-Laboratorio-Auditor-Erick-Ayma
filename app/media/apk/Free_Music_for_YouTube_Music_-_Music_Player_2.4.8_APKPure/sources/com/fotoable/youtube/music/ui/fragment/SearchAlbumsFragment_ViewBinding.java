package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class SearchAlbumsFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SearchAlbumsFragment f4730a;

    @UiThread
    public SearchAlbumsFragment_ViewBinding(SearchAlbumsFragment searchAlbumsFragment, View view) {
        this.f4730a = searchAlbumsFragment;
        searchAlbumsFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.search_recycler_view, "field 'mRecyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchAlbumsFragment searchAlbumsFragment = this.f4730a;
        if (searchAlbumsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4730a = null;
        searchAlbumsFragment.mRecyclerView = null;
    }
}
