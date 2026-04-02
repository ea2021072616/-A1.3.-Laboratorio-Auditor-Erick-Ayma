package com.fotoable.youtube.music.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aspsine.irecyclerview.IRecyclerView;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class SearchPlayListFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SearchPlayListFragment f4739a;

    @UiThread
    public SearchPlayListFragment_ViewBinding(SearchPlayListFragment searchPlayListFragment, View view) {
        this.f4739a = searchPlayListFragment;
        searchPlayListFragment.mRecyclerView = (IRecyclerView) Utils.findRequiredViewAsType(view, R.id.search_recycler_view, "field 'mRecyclerView'", IRecyclerView.class);
        searchPlayListFragment.mNoDataView = Utils.findRequiredView(view, R.id.search_no_data_view, "field 'mNoDataView'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchPlayListFragment searchPlayListFragment = this.f4739a;
        if (searchPlayListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4739a = null;
        searchPlayListFragment.mRecyclerView = null;
        searchPlayListFragment.mNoDataView = null;
    }
}
