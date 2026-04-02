package com.fotoable.youtube.music.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PlayBean;
import com.fotoable.youtube.music.ui.adapter.AlbumItemOffsetDecoration;
import com.fotoable.youtube.music.ui.adapter.PlayListAdapter;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class PlayListFragment extends com.fotoable.youtube.music.base.i {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f4676b;
    private rx.g.b f;
    private PlayListAdapter g;
    private GridLayoutManager h;
    private LoadMoreFooterView k;
    @BindView(R.id.recycle_view)
    IRecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.ll_error)
    LinearLayout tvError;

    /* renamed from: c  reason: collision with root package name */
    private int f4677c = 0;
    private int d = 20;
    private long e = 0;
    private boolean i = true;
    private boolean j = false;
    private OnLoadMoreListener l = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.fragment.PlayListFragment.3
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (PlayListFragment.this.i) {
                if (!PlayListFragment.this.j) {
                    PlayListFragment.this.k.setStatus(LoadMoreFooterView.Status.LOADING);
                    PlayListFragment.this.a(PlayListFragment.this.f4677c, PlayListFragment.this.d, PlayListFragment.this.e);
                    return;
                }
                return;
            }
            PlayListFragment.this.k.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_playlist;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        h();
        i();
        com.fotoable.youtube.music.util.b.b("在线音乐-Playlist展示次数");
        com.fotoable.youtube.music.util.b.a("在线音乐-Playlist展示次数");
        com.fotoable.youtube.music.util.b.b("在线音乐-歌单页面展示");
    }

    public void i() {
        n();
        l();
        a(this.f4677c, this.d, this.e);
    }

    private void l() {
        this.refreshLayout.setRefreshing(true);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.au

            /* renamed from: a  reason: collision with root package name */
            private final PlayListFragment f4788a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4788a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4788a.k();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void k() {
        this.refreshLayout.setRefreshing(true);
        this.f4677c = 0;
        this.e = 0L;
        a(this.f4677c, this.d, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        new Handler().postDelayed(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.fragment.av

            /* renamed from: a  reason: collision with root package name */
            private final PlayListFragment f4789a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4789a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4789a.j();
            }
        }, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void j() {
        if (this.refreshLayout != null) {
            this.refreshLayout.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final int i2, long j) {
        if (!this.j) {
            this.j = true;
            this.tvError.setVisibility(8);
            a(this.f4676b.a(i, i2, j).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<ArrayList<PlayBean>>>() { // from class: com.fotoable.youtube.music.ui.fragment.PlayListFragment.1
                @Override // rx.g
                public void onCompleted() {
                    PlayListFragment.this.j = false;
                    if (PlayListFragment.this.k != null) {
                        PlayListFragment.this.k.setVisibility(0);
                    }
                    PlayListFragment.this.m();
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    PlayListFragment.this.j = false;
                    PlayListFragment.this.m();
                    if (PlayListFragment.this.tvError != null && PlayListFragment.this.g != null && PlayListFragment.this.g.getItemCount() <= 0) {
                        PlayListFragment.this.tvError.setVisibility(0);
                        PlayListFragment.this.refreshLayout.setRefreshing(false);
                    }
                    PlayListFragment.this.i = true;
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<ArrayList<PlayBean>> myHttpResponse) {
                    if (myHttpResponse.getData() == null || myHttpResponse.getData().size() <= 0) {
                        PlayListFragment.this.i = false;
                    } else {
                        PlayListFragment.this.g.setAddData(myHttpResponse.getData());
                        PlayListFragment.this.f4677c += i2;
                        PlayListFragment.this.i = true;
                    }
                    PlayListFragment.this.e = myHttpResponse.getMeta().getMixid();
                    if (PlayListFragment.this.tvError != null) {
                        PlayListFragment.this.tvError.setVisibility(8);
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.i
    public void a(rx.m mVar) {
        if (this.f == null) {
            this.f = new rx.g.b();
        }
        this.f.a(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.i
    public void l_() {
        if (this.f != null) {
            this.f.unsubscribe();
            this.f = null;
        }
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    private void n() {
        this.h = new GridLayoutManager(getContext(), 2);
        this.recyclerView.setLayoutManager(this.h);
        this.recyclerView.addItemDecoration(new AlbumItemOffsetDecoration(com.fotoable.youtube.music.util.w.a(getContext(), 16.0f), com.fotoable.youtube.music.util.w.a(getContext(), 10.0f)));
        this.g = new PlayListAdapter(getContext());
        this.g.setSource(1001);
        this.recyclerView.setIAdapter(this.g);
        this.recyclerView.setOnLoadMoreListener(this.l);
        this.k = (LoadMoreFooterView) this.recyclerView.getLoadMoreFooterView();
        this.k.setVisibility(8);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void h() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(new rx.c.b(this) { // from class: com.fotoable.youtube.music.ui.fragment.aw

            /* renamed from: a  reason: collision with root package name */
            private final PlayListFragment f4790a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4790a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f4790a.a(obj);
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.ui.fragment.PlayListFragment.2
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
            case PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW /* 1017 */:
                try {
                    int intValue = ((Integer) aVar.f2727b).intValue();
                    if (this.recyclerView != null && intValue == 1) {
                        this.recyclerView.smoothScrollToPosition(0);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    return;
                }
            case InputDeviceCompat.SOURCE_GAMEPAD /* 1025 */:
                i();
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        l_();
    }

    @OnClick({R.id.ll_error})
    public void onClick() {
        this.refreshLayout.setRefreshing(true);
        this.f4677c = 0;
        this.e = 0L;
        a(this.f4677c, this.d, this.e);
    }
}
