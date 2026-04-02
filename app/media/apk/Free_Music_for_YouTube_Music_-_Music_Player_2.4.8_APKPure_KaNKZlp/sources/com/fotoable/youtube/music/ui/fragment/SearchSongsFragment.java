package com.fotoable.youtube.music.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import butterknife.BindView;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.facebook.ads.AdError;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.bean.SearchItemBean;
import com.fotoable.youtube.music.bean.SearchResultBean;
import com.fotoable.youtube.music.ui.adapter.SearchSongsAdapter;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class SearchSongsFragment extends com.fotoable.youtube.music.base.i {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.e f4740b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4741c;
    private SearchSongsAdapter d;
    private boolean e;
    private String g;
    private String h;
    private LoadMoreFooterView i;
    @BindView(R.id.search_no_data_view)
    View mNoDataView;
    @BindView(R.id.search_recycler_view)
    IRecyclerView mRecyclerView;
    private boolean f = true;
    private int j = -1;
    private boolean k = false;
    private Handler l = new Handler() { // from class: com.fotoable.youtube.music.ui.fragment.SearchSongsFragment.1
    };
    private OnLoadMoreListener m = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.fragment.SearchSongsFragment.7
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (SearchSongsFragment.this.f) {
                if (!SearchSongsFragment.this.e) {
                    SearchSongsFragment.this.e = true;
                    SearchSongsFragment.this.i.setStatus(LoadMoreFooterView.Status.LOADING);
                    SearchSongsFragment.this.a(SearchSongsFragment.this.g);
                    return;
                }
                return;
            }
            SearchSongsFragment.this.i.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };

    public static SearchSongsFragment a(int i, boolean z) {
        SearchSongsFragment searchSongsFragment = new SearchSongsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ShareConstants.FEED_SOURCE_PARAM, i);
        bundle.putBoolean("isSelectedMusic", z);
        searchSongsFragment.setArguments(bundle);
        return searchSongsFragment;
    }

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
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            this.j = arguments.getInt(ShareConstants.FEED_SOURCE_PARAM);
            this.k = arguments.getBoolean("isSelectedMusic");
        }
        j();
        i();
        h();
    }

    @Override // com.fotoable.youtube.music.base.i
    public void h() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(new rx.c.b(this) { // from class: com.fotoable.youtube.music.ui.fragment.bg

            /* renamed from: a  reason: collision with root package name */
            private final SearchSongsFragment f4809a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4809a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f4809a.a(obj);
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.ui.fragment.SearchSongsFragment.2
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj) {
        com.fotoable.youtube.music.e.a aVar = (com.fotoable.youtube.music.e.a) obj;
        switch (aVar.f2726a) {
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                if (this.d != null) {
                    this.d.setPlayingId((String) aVar.f2727b);
                    return;
                }
                return;
            case PointerIconCompat.TYPE_ALL_SCROLL /* 1013 */:
            default:
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                if (this.d != null) {
                    this.d.setPlayingId("");
                    return;
                }
                return;
        }
    }

    private void i() {
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.d = new SearchSongsAdapter(getActivity(), this.f4741c, getFragmentManager());
        this.d.setSelectedMusic(this.k);
        this.mRecyclerView.setIAdapter(this.d);
        this.mRecyclerView.setOnLoadMoreListener(this.m);
        this.i = (LoadMoreFooterView) this.mRecyclerView.getLoadMoreFooterView();
        this.mRecyclerView.getHeaderContainer();
        this.d.setOnItemClickListener(new SearchSongsAdapter.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.SearchSongsFragment.3
            @Override // com.fotoable.youtube.music.ui.adapter.SearchSongsAdapter.OnItemClickListener
            public void onPlayNow(SearchItemBean searchItemBean) {
                PlayMusicModel a2 = com.fotoable.youtube.music.newplayer.a.b.a(searchItemBean);
                if (!SearchSongsFragment.this.k) {
                    if (SearchSongsFragment.this.j == 2 && a2 != null) {
                        com.fotoable.youtube.music.util.b.b("Artists歌手页-单曲列表播放单曲", "VideoId", a2.getVideoId());
                        com.fotoable.youtube.music.util.b.a("Artists歌手页-单曲列表播放单曲", "视频ID", a2.getVideoId());
                    }
                    if (SearchSongsFragment.this.j == 3 && a2 != null) {
                        com.fotoable.youtube.music.util.b.b("分类检索-播放单曲", "VideoId", a2.getVideoId());
                    }
                    List<SearchItemBean> allData = SearchSongsFragment.this.d.getAllData();
                    int indexOf = allData.indexOf(searchItemBean);
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, com.fotoable.youtube.music.newplayer.a.b.a(allData), indexOf));
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("model", a2);
                SearchSongsFragment.this.getActivity().setResult(-1, intent);
                SearchSongsFragment.this.getActivity().finish();
            }

            @Override // com.fotoable.youtube.music.ui.adapter.SearchSongsAdapter.OnItemClickListener
            public void onPlayNext(SearchItemBean searchItemBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2002, com.fotoable.youtube.music.newplayer.a.b.a(searchItemBean)));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.SearchSongsAdapter.OnItemClickListener
            public void onAddToPlayQueue(SearchItemBean searchItemBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2003, com.fotoable.youtube.music.newplayer.a.b.a(searchItemBean)));
            }
        });
    }

    private void j() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(com.fotoable.youtube.music.util.s.a()).a(new rx.c.b<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.fragment.SearchSongsFragment.4
            @Override // rx.c.b
            /* renamed from: a */
            public void call(com.fotoable.youtube.music.e.a aVar) {
                if (aVar.f2726a == 100) {
                    SearchSongsFragment.this.g = (String) aVar.f2727b;
                    SearchSongsFragment.this.e = true;
                    SearchSongsFragment.this.h = "";
                    SearchSongsFragment.this.f = true;
                    SearchSongsFragment.this.d.clearData();
                    SearchSongsFragment.this.mNoDataView.setVisibility(8);
                    SearchSongsFragment.this.a(SearchSongsFragment.this.g);
                    if (SearchSongsFragment.this.j != 1) {
                        if (SearchSongsFragment.this.j != 2) {
                            if (SearchSongsFragment.this.j == 3) {
                                String str = aVar.f2728c;
                                if (!TextUtils.isEmpty(str)) {
                                    com.fotoable.youtube.music.util.b.b("分类检索-单曲列表", "分类名", "" + str);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        com.fotoable.youtube.music.util.b.b("Artists-歌手库-歌手单曲列表展示", "歌手名", "" + SearchSongsFragment.this.g);
                        com.fotoable.youtube.music.util.b.a("Artists-歌手库-歌手单曲列表展示", "歌手名", "" + SearchSongsFragment.this.g);
                    }
                }
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.ui.fragment.SearchSongsFragment.5
            @Override // rx.c.b
            /* renamed from: a */
            public void call(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.fotoable.youtube.music.util.h.a("SearchSongsFragment", "开始搜索");
        a(this.f4740b.a(str, this.h).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<SearchResultBean>() { // from class: com.fotoable.youtube.music.ui.fragment.SearchSongsFragment.6
            @Override // rx.g
            public void onCompleted() {
                SearchSongsFragment.this.e = false;
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
                        SearchSongsFragment.this.f = false;
                        if (SearchSongsFragment.this.d.getItemCount() > 0) {
                            SearchSongsFragment.this.mNoDataView.setVisibility(8);
                        } else {
                            SearchSongsFragment.this.mNoDataView.setVisibility(0);
                        }
                    } else {
                        if (TextUtils.isEmpty(SearchSongsFragment.this.h)) {
                            SearchSongsFragment.this.d.refresh(items);
                        } else {
                            SearchSongsFragment.this.d.addData(items);
                        }
                        if (SearchSongsFragment.this.d.getItemCount() >= searchResultBean.getPageInfo().getTotalResults()) {
                            SearchSongsFragment.this.f = false;
                        } else {
                            SearchSongsFragment.this.f = true;
                        }
                    }
                    SearchSongsFragment.this.h = searchResultBean.getNextPageToken();
                }
            }
        }));
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        l_();
    }
}
