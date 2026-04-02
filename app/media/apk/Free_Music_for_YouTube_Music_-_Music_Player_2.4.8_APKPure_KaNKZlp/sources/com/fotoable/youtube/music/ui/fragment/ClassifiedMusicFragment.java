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
import com.fotoable.youtube.music.bean.ClassifiedRankBean;
import com.fotoable.youtube.music.d.a.b;
import com.fotoable.youtube.music.ui.adapter.ClassifiedMusicAdapter;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import java.util.ArrayList;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class ClassifiedMusicFragment extends com.fotoable.youtube.music.base.i implements b.a {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.d.i f4498b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayoutManager f4499c;
    private ClassifiedMusicAdapter d;
    private LoadMoreFooterView e;
    private OnLoadMoreListener f = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.fragment.ClassifiedMusicFragment.2
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (ClassifiedMusicFragment.this.e != null) {
                ClassifiedMusicFragment.this.e.setStatus(LoadMoreFooterView.Status.THE_END);
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
        return R.layout.fragment_classified_music;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        j();
        this.f4498b.b();
        i();
    }

    private void i() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.ClassifiedMusicFragment.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                ClassifiedMusicFragment.this.f4498b.b();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    private void j() {
        this.f4499c = new LinearLayoutManager(getContext());
        this.recyclerView.setLayoutManager(this.f4499c);
        this.d = new ClassifiedMusicAdapter(getContext());
        this.recyclerView.setIAdapter(this.d);
        this.recyclerView.setOnLoadMoreListener(this.f);
        this.e = (LoadMoreFooterView) this.recyclerView.getLoadMoreFooterView();
        this.e.setVisibility(8);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
        this.f4498b.a((b.a) this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f4498b != null) {
            this.f4498b.a();
        }
    }

    @Override // com.fotoable.youtube.music.d.a.b.a
    public void a(ArrayList<ClassifiedRankBean> arrayList) {
        if (arrayList != null && arrayList.size() > 0 && this.d != null) {
            this.e.setStatus(LoadMoreFooterView.Status.THE_END);
            this.e.setVisibility(0);
            this.tvError.setVisibility(8);
            this.d.setAddDatas(arrayList);
            return;
        }
        this.tvError.setVisibility(0);
    }

    @Override // com.fotoable.youtube.music.d.a.b.a
    public void b_(boolean z) {
        if (this.refreshLayout != null) {
            this.refreshLayout.setRefreshing(z);
        }
    }

    @OnClick({R.id.ll_error})
    public void onClick() {
        this.f4498b.b();
    }
}
