package com.fotoable.youtube.music.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.foto.indexlib.IndexBar.widget.NewIndexBar;
import com.foto.indexlib.a.c;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.ArtistBean;
import com.fotoable.youtube.music.d.a.a;
import com.fotoable.youtube.music.ui.adapter.ArtistsAdapter;
import com.fotoable.youtube.music.ui.adapter.DividerItemDecoration;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class ArtistsFragment extends com.fotoable.youtube.music.base.i implements a.InterfaceC0057a {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.d.a f4481b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayoutManager f4482c;
    private ArtistsAdapter d;
    private LoadMoreFooterView e;
    private String[] f;
    private com.foto.indexlib.a.c g;
    private DividerItemDecoration h;
    @BindView(R.id.indexBar)
    NewIndexBar indexBar;
    @BindView(R.id.recycle_view)
    IRecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    ISwipeRefreshLayout refreshLayout;
    @BindView(R.id.ll_error)
    LinearLayout tvError;
    @BindView(R.id.tvSideBarHint)
    TextView tvSideBarHint;
    @BindView(R.id.view_bg)
    View viewBg;
    private ArrayList<ArtistBean> i = new ArrayList<>();
    private OnLoadMoreListener j = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.fragment.ArtistsFragment.3
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (ArtistsFragment.this.e != null) {
                ArtistsFragment.this.e.setStatus(LoadMoreFooterView.Status.THE_END);
            }
        }
    };

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_artists;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        j();
        i();
        this.f4481b.b();
        com.fotoable.youtube.music.util.b.b("歌手库-展示");
        com.fotoable.youtube.music.util.b.a("歌手库-展示");
    }

    private void i() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.ArtistsFragment.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                ArtistsFragment.this.f4481b.b();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    private void j() {
        this.f4482c = new LinearLayoutManager(getContext());
        this.recyclerView.setLayoutManager(this.f4482c);
        this.d = new ArtistsAdapter(getContext());
        this.recyclerView.setIAdapter(this.d);
        this.recyclerView.setOnLoadMoreListener(this.j);
        IRecyclerView iRecyclerView = this.recyclerView;
        com.foto.indexlib.a.c cVar = new com.foto.indexlib.a.c(getContext(), this.i);
        this.g = cVar;
        iRecyclerView.addItemDecoration(cVar);
        IRecyclerView iRecyclerView2 = this.recyclerView;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        this.h = dividerItemDecoration;
        iRecyclerView2.addItemDecoration(dividerItemDecoration);
        this.e = (LoadMoreFooterView) this.recyclerView.getLoadMoreFooterView();
        this.e.setVisibility(8);
        this.g.a(2);
        this.indexBar.a(this.tvSideBarHint).a(false).a(2).a(this.f4482c);
        this.g.a(new c.a() { // from class: com.fotoable.youtube.music.ui.fragment.ArtistsFragment.2
            @Override // com.foto.indexlib.a.c.a
            public void a(String str) {
                if (ArtistsFragment.this.indexBar != null) {
                    ArtistsFragment.this.indexBar.setCurrentIndex(str);
                }
            }
        });
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
        this.f4481b.a((a.InterfaceC0057a) this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f4481b != null) {
            this.f4481b.a();
        }
    }

    @Override // com.fotoable.youtube.music.d.a.a.InterfaceC0057a
    public void a(String[] strArr) {
        if (strArr != null && this.indexBar != null) {
            this.f = strArr;
            NewIndexBar newIndexBar = this.indexBar;
            NewIndexBar.f2203a = strArr;
            this.indexBar.a(false);
            this.indexBar.setVisibility(0);
            this.viewBg.setVisibility(0);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.a.InterfaceC0057a
    public void a(ArrayList<ArtistBean> arrayList) {
        if (this.f != null && this.f.length > 0 && this.d != null && this.indexBar != null && this.g != null && this.h != null && this.e != null) {
            Iterator<ArtistBean> it = arrayList.iterator();
            while (it.hasNext()) {
                ArtistBean next = it.next();
                next.setBaseIndexTag(next.getGroup());
            }
            this.d.setAddDatas(arrayList);
            this.indexBar.a(arrayList).invalidate();
            this.g.a(arrayList);
            this.h.setmDatas(arrayList);
            this.e.setVisibility(0);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.a.InterfaceC0057a
    public void a_(boolean z) {
        if (this.refreshLayout != null) {
            this.refreshLayout.setRefreshing(z);
        }
    }

    @OnClick({R.id.ll_error})
    public void onClick() {
        this.f4481b.b();
    }

    @Override // com.fotoable.youtube.music.d.a.a.InterfaceC0057a
    public void b(boolean z) {
        if (this.tvError != null) {
            if (z) {
                this.tvError.setVisibility(0);
            } else {
                this.tvError.setVisibility(8);
            }
        }
    }
}
