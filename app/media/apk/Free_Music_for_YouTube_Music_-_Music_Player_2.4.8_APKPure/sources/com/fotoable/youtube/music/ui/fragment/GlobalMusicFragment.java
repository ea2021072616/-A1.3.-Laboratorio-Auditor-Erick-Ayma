package com.fotoable.youtube.music.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.GlobalRankBean;
import com.fotoable.youtube.music.d.a.g;
import com.fotoable.youtube.music.ui.adapter.GlobalMusicAdapter;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import java.util.ArrayList;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class GlobalMusicFragment extends com.fotoable.youtube.music.base.i implements g.a {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.d.w f4577b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayoutManager f4578c;
    private GlobalMusicAdapter d;
    private LoadMoreFooterView e;
    private OnLoadMoreListener f = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.fragment.GlobalMusicFragment.2
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (GlobalMusicFragment.this.e != null) {
                GlobalMusicFragment.this.e.setStatus(LoadMoreFooterView.Status.THE_END);
            }
        }
    };
    @BindView(R.id.recycle_view)
    IRecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    ISwipeRefreshLayout refreshLayout;
    @BindView(R.id.ll_error)
    LinearLayout tvError;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_global_music;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        j();
        this.f4577b.a();
        i();
        com.fotoable.youtube.music.util.b.b("在线音乐-榜单页面展示");
        com.fotoable.youtube.music.util.b.a("在线音乐-榜单页面展示");
    }

    private void i() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.GlobalMusicFragment.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                GlobalMusicFragment.this.f4577b.a();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    private void j() {
        this.f4578c = new LinearLayoutManager(getContext());
        this.recyclerView.setLayoutManager(this.f4578c);
        this.d = new GlobalMusicAdapter(getContext());
        this.recyclerView.setIAdapter(this.d);
        this.recyclerView.setOnLoadMoreListener(this.f);
        this.e = (LoadMoreFooterView) this.recyclerView.getLoadMoreFooterView();
        this.e.setVisibility(8);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
        this.f4577b.a((g.a) this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f4577b != null) {
            this.f4577b.b();
        }
    }

    @Override // com.fotoable.youtube.music.d.a.g.a
    public void a(ArrayList<GlobalRankBean> arrayList) {
        if (arrayList != null && arrayList.size() > 0 && this.d != null) {
            this.e.setStatus(LoadMoreFooterView.Status.THE_END);
            this.e.setVisibility(0);
            this.tvError.setVisibility(8);
            this.d.setAddDatas(arrayList);
            return;
        }
        this.tvError.setVisibility(0);
    }

    @Override // com.fotoable.youtube.music.d.a.g.a
    public void e_(boolean z) {
        if (this.refreshLayout != null) {
            this.refreshLayout.setRefreshing(z);
        }
    }

    @OnClick({R.id.ll_error})
    public void onClick() {
        this.f4577b.a();
    }
}
