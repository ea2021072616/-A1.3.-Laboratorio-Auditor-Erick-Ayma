package com.fotoable.youtube.music.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.GenresBean;
import com.fotoable.youtube.music.d.a.f;
import com.fotoable.youtube.music.ui.adapter.DividerGridItemDecoration;
import com.fotoable.youtube.music.ui.adapter.GenresAdapter;
import java.util.ArrayList;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class GenresFragment extends com.fotoable.youtube.music.base.i implements f.a {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.d.p f4569b;

    /* renamed from: c  reason: collision with root package name */
    private GridLayoutManager f4570c;
    private GenresAdapter d;
    private ArrayList<GenresBean> e;
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.ll_error)
    LinearLayout tvError;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_genres;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        j();
        i();
        this.f4569b.a();
        com.fotoable.youtube.music.util.b.b("在线音乐-分类检索界面展示次数");
    }

    private void i() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.GenresFragment.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                GenresFragment.this.f4569b.a();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    private void j() {
        this.f4570c = new GridLayoutManager(getContext(), 2);
        this.f4570c.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.fotoable.youtube.music.ui.fragment.GenresFragment.2
            @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                return (GenresFragment.this.e == null || i >= GenresFragment.this.e.size() || ((GenresBean) GenresFragment.this.e.get(i)).getType() != 1) ? 1 : 2;
            }
        });
        this.recyclerView.setLayoutManager(this.f4570c);
        this.d = new GenresAdapter(getContext());
        this.recyclerView.setAdapter(this.d);
        this.recyclerView.addItemDecoration(new DividerGridItemDecoration(getContext()));
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
        this.f4569b.a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f4569b != null) {
            this.f4569b.b();
        }
    }

    @Override // com.fotoable.youtube.music.d.a.f.a
    public void d_(boolean z) {
        if (this.refreshLayout != null) {
            this.refreshLayout.setRefreshing(z);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.f.a
    public void a(ArrayList<GenresBean> arrayList) {
        if (this.d != null && arrayList != null) {
            this.e = arrayList;
            this.d.setAddData(arrayList);
        }
    }

    @OnClick({R.id.ll_error})
    public void onClick() {
        this.f4569b.a();
    }

    @Override // com.fotoable.youtube.music.d.a.f.a
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
