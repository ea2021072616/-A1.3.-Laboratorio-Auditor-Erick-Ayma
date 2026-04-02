package com.fotoable.youtube.music.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
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
import com.fotoable.youtube.music.bean.RanBean;
import com.fotoable.youtube.music.ui.adapter.GridSpacingItemDecoration;
import com.fotoable.youtube.music.ui.adapter.RanAdapter;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class RankFragment extends com.fotoable.youtube.music.base.i {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f4719b;

    /* renamed from: c  reason: collision with root package name */
    private rx.g.b f4720c;
    private RanAdapter d;
    private GridLayoutManager e;
    private LoadMoreFooterView g;
    @BindView(R.id.recycle_view)
    IRecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.ll_error)
    LinearLayout tvError;
    private boolean f = false;
    private OnLoadMoreListener h = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.fragment.RankFragment.4
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            RankFragment.this.g.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_featured;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        h();
    }

    private void k() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.fotoable.youtube.music.ui.fragment.RankFragment.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RankFragment.this.m();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    public void i() {
        n();
        m();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        new Handler().postDelayed(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.fragment.ba

            /* renamed from: a  reason: collision with root package name */
            private final RankFragment f4799a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4799a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4799a.j();
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
    public void m() {
        if (!this.f) {
            this.f = true;
            this.refreshLayout.setRefreshing(true);
            this.tvError.setVisibility(8);
            a(this.f4719b.a().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<ArrayList<RanBean>>>() { // from class: com.fotoable.youtube.music.ui.fragment.RankFragment.2
                @Override // rx.g
                public void onCompleted() {
                    RankFragment.this.f = false;
                    if (RankFragment.this.g != null) {
                        RankFragment.this.g.setVisibility(0);
                    }
                    RankFragment.this.l();
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    RankFragment.this.f = false;
                    RankFragment.this.l();
                    if (RankFragment.this.tvError != null && RankFragment.this.d != null && RankFragment.this.d.getItemCount() <= 0) {
                        RankFragment.this.tvError.setVisibility(0);
                        RankFragment.this.refreshLayout.setRefreshing(false);
                    }
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<ArrayList<RanBean>> myHttpResponse) {
                    if (myHttpResponse.getData() != null && myHttpResponse.getData().size() > 0) {
                        RankFragment.this.d.cleanDatas();
                        RankFragment.this.d.setAddDatas(myHttpResponse.getData());
                        RankFragment.this.tvError.setVisibility(8);
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.i
    public void a(rx.m mVar) {
        if (this.f4720c == null) {
            this.f4720c = new rx.g.b();
        }
        this.f4720c.a(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.i
    public void l_() {
        if (this.f4720c != null) {
            this.f4720c.unsubscribe();
            this.f4720c = null;
        }
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    private void n() {
        this.recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 10, true));
        this.e = new GridLayoutManager(getActivity(), 2);
        this.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.d = new RanAdapter(getContext());
        this.recyclerView.setIAdapter(this.d);
        this.recyclerView.setOnLoadMoreListener(this.h);
        this.g = (LoadMoreFooterView) this.recyclerView.getLoadMoreFooterView();
        this.g.setVisibility(8);
    }

    @Override // com.fotoable.youtube.music.base.i
    public void h() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(rx.a.b.a.a()).a(new rx.c.b(this) { // from class: com.fotoable.youtube.music.ui.fragment.bb

            /* renamed from: a  reason: collision with root package name */
            private final RankFragment f4800a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4800a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f4800a.a(obj);
            }
        }, new rx.c.b<Throwable>() { // from class: com.fotoable.youtube.music.ui.fragment.RankFragment.3
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
                    if (this.recyclerView != null && intValue == 2) {
                        this.recyclerView.smoothScrollToPosition(0);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    return;
                }
            case 1026:
                i();
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            l_();
            if (this.d != null) {
                this.d.onDestroy();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @OnClick({R.id.ll_error})
    public void onClick() {
        m();
    }
}
