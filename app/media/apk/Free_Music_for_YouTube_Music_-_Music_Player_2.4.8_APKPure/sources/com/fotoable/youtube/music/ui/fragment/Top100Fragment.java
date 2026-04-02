package com.fotoable.youtube.music.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.GlobalRankVideoBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.d.a.q;
import com.fotoable.youtube.music.ui.activity.ArtistsActivity;
import com.fotoable.youtube.music.ui.activity.ChartsActivity;
import com.fotoable.youtube.music.ui.activity.GenresActivity;
import com.fotoable.youtube.music.ui.adapter.Top100Adapter;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class Top100Fragment extends com.fotoable.youtube.music.base.i implements View.OnClickListener, q.a {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f4750b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.d.as f4751c;
    private LinearLayoutManager d;
    private Top100Adapter e;
    private LoadMoreFooterView f;
    private OnLoadMoreListener g = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.fragment.Top100Fragment.2
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (!Top100Fragment.this.f4751c.e()) {
                Top100Fragment.this.f.setStatus(LoadMoreFooterView.Status.THE_END);
                return;
            }
            Top100Fragment.this.f4751c.b();
            Top100Fragment.this.f.setStatus(LoadMoreFooterView.Status.LOADING);
        }
    };
    private Top100Adapter.OnAdminDeleteLister h = new Top100Adapter.OnAdminDeleteLister() { // from class: com.fotoable.youtube.music.ui.fragment.Top100Fragment.3
        @Override // com.fotoable.youtube.music.ui.adapter.Top100Adapter.OnAdminDeleteLister
        public void onDelete(final GlobalRankVideoBean globalRankVideoBean, final int i) {
            SimpleMusicDialog.a(Top100Fragment.this.getFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.ui.fragment.Top100Fragment.3.1
                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void a() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void b() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void c() {
                    Top100Fragment.this.a(globalRankVideoBean, i);
                }
            }, R.string.sure_delete, R.string.cancel, R.string.ok);
        }
    };
    @BindView(R.id.recycle_view)
    IRecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_top_100;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        j();
        k();
        com.fotoable.youtube.music.util.b.b("在线音乐-Top100页展示");
        com.fotoable.youtube.music.util.b.a("在线音乐-Top100页展示");
    }

    private void j() {
        this.d = new LinearLayoutManager(getContext());
        this.recyclerView.setLayoutManager(this.d);
        this.e = new Top100Adapter(getContext(), getFragmentManager());
        this.e.setOnAdminDeleteLister(this.h);
        this.e.setIsPlayingID(com.fotoable.youtube.music.newplayer.e.a().e() == null ? "" : com.fotoable.youtube.music.newplayer.e.a().e().getVideoId());
        this.recyclerView.setIAdapter(this.e);
        this.recyclerView.setOnLoadMoreListener(this.g);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_top100_header, (ViewGroup) null);
        inflate.findViewById(R.id.featured_charts_view).setOnClickListener(this);
        inflate.findViewById(R.id.featured_artists_view).setOnClickListener(this);
        inflate.findViewById(R.id.featured_genres_view).setOnClickListener(this);
        this.recyclerView.addHeaderView(inflate);
        this.f = (LoadMoreFooterView) this.recyclerView.getLoadMoreFooterView();
        this.f.setVisibility(8);
        this.e.setOnItemClickListener(new Top100Adapter.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.Top100Fragment.1
            @Override // com.fotoable.youtube.music.ui.adapter.Top100Adapter.OnItemClickListener
            public void onPlayNow(GlobalRankVideoBean globalRankVideoBean) {
                ArrayList<GlobalRankVideoBean> globalRankVideoBeens = Top100Fragment.this.e.getGlobalRankVideoBeens();
                if (globalRankVideoBeens != null) {
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, com.fotoable.youtube.music.newplayer.a.b.e(globalRankVideoBeens), globalRankVideoBeens.indexOf(globalRankVideoBean)));
                    if (globalRankVideoBean != null) {
                        com.fotoable.youtube.music.util.b.b("在线音乐-Top100-点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                        com.fotoable.youtube.music.util.b.a("在线音乐-Top100-点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                    }
                }
            }

            @Override // com.fotoable.youtube.music.ui.adapter.Top100Adapter.OnItemClickListener
            public void onPlayNext(GlobalRankVideoBean globalRankVideoBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2002, com.fotoable.youtube.music.newplayer.a.b.a(globalRankVideoBean)));
                if (globalRankVideoBean != null) {
                    com.fotoable.youtube.music.util.b.b("在线音乐-Top100-点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                    com.fotoable.youtube.music.util.b.a("在线音乐-Top100-点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                }
            }

            @Override // com.fotoable.youtube.music.ui.adapter.Top100Adapter.OnItemClickListener
            public void onAddToPlayQueue(GlobalRankVideoBean globalRankVideoBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2003, com.fotoable.youtube.music.newplayer.a.b.a(globalRankVideoBean)));
                if (globalRankVideoBean != null) {
                    com.fotoable.youtube.music.util.b.b("在线音乐-Top100-点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                    com.fotoable.youtube.music.util.b.a("在线音乐-Top100-点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.featured_charts_view /* 2131821189 */:
                getContext().startActivity(new Intent(getContext(), ChartsActivity.class));
                com.fotoable.youtube.music.util.b.b("Top100-快捷入口-排行榜点击");
                return;
            case R.id.featured_artists_view /* 2131821190 */:
                getContext().startActivity(new Intent(getContext(), ArtistsActivity.class));
                com.fotoable.youtube.music.util.b.b("Top100-快捷入口-歌手检索点击");
                return;
            case R.id.featured_genres_view /* 2131821191 */:
                getContext().startActivity(new Intent(getContext(), GenresActivity.class));
                com.fotoable.youtube.music.util.b.b("Top100-快捷入口-分类检索点击");
                return;
            default:
                return;
        }
    }

    private void k() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.bi

            /* renamed from: a  reason: collision with root package name */
            private final Top100Fragment f4813a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4813a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4813a.i();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setRefreshing(true);
        this.f4751c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i() {
        this.f.setVisibility(8);
        this.f4751c.c();
        this.f4751c.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final GlobalRankVideoBean globalRankVideoBean, int i) {
        a(this.f4750b.a(globalRankVideoBean.getVideoid(), i + 1).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<MyHttpResponse>() { // from class: com.fotoable.youtube.music.ui.fragment.Top100Fragment.4
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse myHttpResponse) {
                if (myHttpResponse.isSuccess()) {
                    Top100Fragment.this.e.delete(globalRankVideoBean);
                    com.fotoable.youtube.music.util.h.a("GlobalMusicDetailsActivity", "删除成功");
                }
            }
        }));
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
        this.f4751c.a((q.a) this);
    }

    @Override // com.fotoable.youtube.music.d.a.q.a
    public void a(ArrayList<GlobalRankVideoBean> arrayList) {
        if (this.refreshLayout.isRefreshing()) {
            this.e.cleanDatas();
        }
        this.refreshLayout.setRefreshing(false);
        this.f.setVisibility(0);
        if (arrayList != null) {
            this.e.setAddDatas(arrayList);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.q.a
    public void a(String str) {
        if (this.e != null) {
            this.e.setIsPlayingID(str);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.q.a
    public void b() {
        this.f.setStatus(LoadMoreFooterView.Status.THE_END);
    }

    @Override // com.fotoable.youtube.music.d.a.q.a
    public void c() {
        this.refreshLayout.setRefreshing(false);
        if (this.e.getItemCount2() == 0) {
            this.e.cleanDatas();
        }
    }

    @Override // com.fotoable.youtube.music.d.a.q.a
    public void a(String str, boolean z) {
        if (this.e != null) {
            this.e.changeFavState(str, z);
        }
    }

    @Override // com.fotoable.youtube.music.base.i, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            this.f4751c.d();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
