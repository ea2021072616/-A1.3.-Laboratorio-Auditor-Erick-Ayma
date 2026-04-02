package com.fotoable.youtube.music.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import butterknife.BindView;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.facebook.ads.AdError;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.SearchItemBean;
import com.fotoable.youtube.music.bean.SearchResultBean;
import com.fotoable.youtube.music.ui.adapter.SearchPlayListAdapter;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class SearchPlayListFragment extends com.fotoable.youtube.music.base.i {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.e f4733b;

    /* renamed from: c  reason: collision with root package name */
    private SearchPlayListAdapter f4734c;
    private boolean d;
    private String f;
    private String g;
    private LoadMoreFooterView h;
    @BindView(R.id.search_no_data_view)
    View mNoDataView;
    @BindView(R.id.search_recycler_view)
    IRecyclerView mRecyclerView;
    private boolean e = true;
    private int i = -1;
    private OnLoadMoreListener j = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.fragment.SearchPlayListFragment.4
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (SearchPlayListFragment.this.e) {
                if (!SearchPlayListFragment.this.d) {
                    SearchPlayListFragment.this.d = true;
                    SearchPlayListFragment.this.h.setStatus(LoadMoreFooterView.Status.LOADING);
                    SearchPlayListFragment.this.a(SearchPlayListFragment.this.f);
                    return;
                }
                return;
            }
            SearchPlayListFragment.this.h.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };

    public static SearchPlayListFragment a(int i) {
        SearchPlayListFragment searchPlayListFragment = new SearchPlayListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ShareConstants.FEED_SOURCE_PARAM, i);
        searchPlayListFragment.setArguments(bundle);
        return searchPlayListFragment;
    }

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        j();
        return R.layout.fragment_search_list;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        if (getArguments() != null) {
            this.i = getArguments().getInt(ShareConstants.FEED_SOURCE_PARAM);
        }
        i();
        this.d = true;
        this.g = "";
        this.e = true;
        this.f4734c.clearData();
        a(this.f);
        com.fotoable.youtube.music.util.h.a("onCreated");
    }

    private void i() {
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f4734c = new SearchPlayListAdapter(getActivity());
        if (this.i == 2) {
            this.f4734c.setSource(AdError.INTERNAL_ERROR_CODE);
        }
        this.mRecyclerView.setIAdapter(this.f4734c);
        this.mRecyclerView.setOnLoadMoreListener(this.j);
        this.h = (LoadMoreFooterView) this.mRecyclerView.getLoadMoreFooterView();
    }

    private void j() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(com.fotoable.youtube.music.util.s.a()).a(new rx.c.b<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.fragment.SearchPlayListFragment.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(com.fotoable.youtube.music.e.a aVar) {
                if (aVar.f2726a == 100) {
                    if (TextUtils.isEmpty(SearchPlayListFragment.this.f)) {
                        SearchPlayListFragment.this.f = (String) aVar.f2727b;
                    } else {
                        SearchPlayListFragment.this.f = (String) aVar.f2727b;
                        if (SearchPlayListFragment.this.k_()) {
                            SearchPlayListFragment.this.d = true;
                            SearchPlayListFragment.this.g = "";
                            SearchPlayListFragment.this.e = true;
                            SearchPlayListFragment.this.f4734c.clearData();
                            SearchPlayListFragment.this.a(SearchPlayListFragment.this.f);
                        }
                        com.fotoable.youtube.music.util.h.a(SearchPlayListFragment.this.f);
                    }
                    if (SearchPlayListFragment.this.i != 1) {
                        if (SearchPlayListFragment.this.i != 2) {
                            if (SearchPlayListFragment.this.i == 3) {
                                String str = aVar.f2728c;
                                if (!TextUtils.isEmpty(str)) {
                                    com.fotoable.youtube.music.util.b.b("分类检索-歌单列表", "分类名", "" + str);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        com.fotoable.youtube.music.util.b.b("Artists-歌手库-歌手歌单列表展示", "歌手名", "" + SearchPlayListFragment.this.f);
                        com.fotoable.youtube.music.util.b.a("Artists-歌手库-歌手歌单列表展示", "歌手名", "" + SearchPlayListFragment.this.f);
                    }
                }
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.ui.fragment.SearchPlayListFragment.2
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (k_()) {
            this.mNoDataView.setVisibility(8);
            a(this.f4733b.b(str, this.g).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<SearchResultBean>() { // from class: com.fotoable.youtube.music.ui.fragment.SearchPlayListFragment.3
                @Override // rx.g
                public void onCompleted() {
                    SearchPlayListFragment.this.d = false;
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    com.fotoable.youtube.music.util.b.b("dev_youtube_api_error", "errorName", th.getMessage());
                    com.fotoable.youtube.music.util.b.a(th);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(SearchResultBean searchResultBean) {
                    if (searchResultBean != null) {
                        List<SearchItemBean> items = searchResultBean.getItems();
                        if (items == null || items.size() <= 0) {
                            SearchPlayListFragment.this.e = false;
                            if (SearchPlayListFragment.this.f4734c.getItemCount() > 0) {
                                SearchPlayListFragment.this.mNoDataView.setVisibility(8);
                            } else {
                                SearchPlayListFragment.this.mNoDataView.setVisibility(0);
                            }
                        } else {
                            if (TextUtils.isEmpty(SearchPlayListFragment.this.g)) {
                                SearchPlayListFragment.this.f4734c.refresh(items);
                            } else {
                                SearchPlayListFragment.this.f4734c.addData(items);
                            }
                            if (SearchPlayListFragment.this.f4734c.getItemCount() >= searchResultBean.getPageInfo().getTotalResults()) {
                                SearchPlayListFragment.this.e = false;
                            } else {
                                SearchPlayListFragment.this.e = true;
                            }
                        }
                        SearchPlayListFragment.this.g = searchResultBean.getNextPageToken();
                    }
                }
            }));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
