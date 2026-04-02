package com.fotoable.youtube.music.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.CategoryListBean;
import com.fotoable.youtube.music.ui.adapter.CategoryAdapterComponent;
import com.fotoable.youtube.music.ui.adapter.PlaylistCategoryAdapter;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class CategoryPlaylistFragment extends com.fotoable.youtube.music.base.i {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4490c = CategoryPlaylistFragment.class.getSimpleName();
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f4491b;
    private PlaylistCategoryAdapter d;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_category_playlist;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        j();
        i();
        k();
        this.refreshLayout.setRefreshing(true);
        com.fotoable.youtube.music.util.b.b("在线音乐-Playlist展示次数");
        com.fotoable.youtube.music.util.b.a("在线音乐-Playlist展示次数");
        com.fotoable.youtube.music.util.b.b("在线音乐-分类歌单-展示次数");
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    private void i() {
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.CategoryPlaylistFragment.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                CategoryPlaylistFragment.this.k();
            }
        });
    }

    private void j() {
        this.recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.d = new PlaylistCategoryAdapter(getContext(), new CategoryAdapterComponent());
        this.recycleView.setAdapter(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        a(this.f4491b.o().a(com.fotoable.youtube.music.util.s.a()).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.b()).a((rx.g) new rx.g<CategoryListBean>() { // from class: com.fotoable.youtube.music.ui.fragment.CategoryPlaylistFragment.2
            @Override // rx.g
            public void onCompleted() {
                CategoryPlaylistFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            public void onError(Throwable th) {
                CategoryPlaylistFragment.this.refreshLayout.setRefreshing(false);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(CategoryListBean categoryListBean) {
                CategoryPlaylistFragment.this.d.setBean(categoryListBean);
            }
        }));
    }
}
