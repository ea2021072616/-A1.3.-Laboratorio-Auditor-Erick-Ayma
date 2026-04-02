package com.fotoable.youtube.music.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.adapter.SearchSongsAdapter;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class SearchArtistsFragment extends com.fotoable.youtube.music.base.i {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4731b;
    @BindView(R.id.search_recycler_view)
    RecyclerView mRecyclerView;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_search_list;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        i();
    }

    private void i() {
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mRecyclerView.setAdapter(new SearchSongsAdapter(getActivity(), this.f4731b, getFragmentManager()));
    }
}
