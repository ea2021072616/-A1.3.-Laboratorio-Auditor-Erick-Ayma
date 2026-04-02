package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class SearchSongsFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SearchSongsFragment f4749a;

    @UiThread
    public SearchSongsFragment_ViewBinding(SearchSongsFragment searchSongsFragment, View view) {
        this.f4749a = searchSongsFragment;
        searchSongsFragment.mRecyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.search_recycler_view, "field 'mRecyclerView'", IRecyclerView.class);
        searchSongsFragment.mNoDataView = Utils.findRequiredView(view, R.id.search_no_data_view, "field 'mNoDataView'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchSongsFragment searchSongsFragment = this.f4749a;
        if (searchSongsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4749a = null;
        searchSongsFragment.mRecyclerView = null;
        searchSongsFragment.mNoDataView = null;
    }
}
