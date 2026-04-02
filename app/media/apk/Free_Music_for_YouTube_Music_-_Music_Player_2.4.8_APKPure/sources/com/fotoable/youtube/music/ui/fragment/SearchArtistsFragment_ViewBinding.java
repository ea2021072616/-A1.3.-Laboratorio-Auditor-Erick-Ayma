package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class SearchArtistsFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SearchArtistsFragment f4732a;

    @UiThread
    public SearchArtistsFragment_ViewBinding(SearchArtistsFragment searchArtistsFragment, View view) {
        this.f4732a = searchArtistsFragment;
        searchArtistsFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.search_recycler_view, "field 'mRecyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchArtistsFragment searchArtistsFragment = this.f4732a;
        if (searchArtistsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4732a = null;
        searchArtistsFragment.mRecyclerView = null;
    }
}
