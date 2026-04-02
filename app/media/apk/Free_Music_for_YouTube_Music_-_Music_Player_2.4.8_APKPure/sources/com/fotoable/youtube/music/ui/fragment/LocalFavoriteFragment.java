package com.fotoable.youtube.music.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.aspsine.irecyclerview.IRecyclerView;
import com.foto.indexlib.IndexBar.widget.NewIndexBar;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.ui.adapter.holder.LocalFavoriteAdapter;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.fragment.LocalFavoriteFragment;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class LocalFavoriteFragment extends com.fotoable.youtube.music.base.i {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4622b;

    /* renamed from: c  reason: collision with root package name */
    private LoadMoreFooterView f4623c;
    private LocalFavoriteAdapter d;
    @BindView(R.id.indexBar)
    NewIndexBar indexBar;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.recycle_view)
    IRecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    ISwipeRefreshLayout refreshLayout;
    @BindView(R.id.rl_nodata)
    RelativeLayout rlNodata;
    @BindView(R.id.tv_again)
    LaToTextView tvAgain;
    @BindView(R.id.tv_error)
    LaToTextView tvError;
    @BindView(R.id.tvSideBarHint)
    TextView tvSideBarHint;
    @BindView(R.id.view_bg)
    View viewBg;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_local;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        l();
        k();
        n();
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    private void l() {
        this.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recycleView.setItemAnimator(new DefaultItemAnimator());
        this.d = new LocalFavoriteAdapter(getContext());
        this.recycleView.setIAdapter(this.d);
        this.f4623c = (LoadMoreFooterView) this.recycleView.getLoadMoreFooterView();
        this.f4623c.setVisibility(8);
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.y

            /* renamed from: a  reason: collision with root package name */
            private final LocalFavoriteFragment f4849a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4849a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4849a.k();
            }
        });
        this.d.SetOnDeleteListener(new LocalFavoriteAdapter.OnDeleteListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.z

            /* renamed from: a  reason: collision with root package name */
            private final LocalFavoriteFragment f4850a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4850a = this;
            }

            @Override // com.fotoable.youtube.music.ui.adapter.holder.LocalFavoriteAdapter.OnDeleteListener
            public void OnClick(View view, Long l) {
                this.f4850a.a(view, l);
            }
        });
    }

    /* renamed from: com.fotoable.youtube.music.ui.fragment.LocalFavoriteFragment$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements SimpleMusicDialog.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Long f4624a;

        AnonymousClass1(Long l) {
            this.f4624a = l;
        }

        @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
        public void a() {
        }

        @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
        public void b() {
        }

        @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
        public void c() {
            if (LocalFavoriteFragment.this.f4622b != null) {
                com.fotoable.youtube.music.util.b.b("本地收藏页面--删除收藏");
                LocalFavoriteFragment.this.f4622b.e(this.f4624a).a(com.fotoable.youtube.music.util.s.a()).b(new rx.c.b(this) { // from class: com.fotoable.youtube.music.ui.fragment.ae

                    /* renamed from: a  reason: collision with root package name */
                    private final LocalFavoriteFragment.AnonymousClass1 f4767a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f4767a = this;
                    }

                    @Override // rx.c.b
                    public void call(Object obj) {
                        this.f4767a.a((Boolean) obj);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void a(Boolean bool) {
            if (bool.booleanValue()) {
                LocalFavoriteFragment.this.k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(View view, Long l) {
        SimpleMusicDialog.a(getFragmentManager(), new AnonymousClass1(l), R.string.delete, R.string.cancel, R.string.delete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void k() {
        o();
        a(this.f4622b.i().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.LocalFavoriteFragment.2
            @Override // rx.g
            public void onCompleted() {
                LocalFavoriteFragment.this.p();
            }

            @Override // rx.g
            public void onError(Throwable th) {
                LocalFavoriteFragment.this.p();
                LocalFavoriteFragment.this.q();
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                LocalFavoriteFragment.this.p();
                if (list == null || list.size() <= 0) {
                    if (LocalFavoriteFragment.this.d != null) {
                        LocalFavoriteFragment.this.d.setData(null);
                    }
                    if (LocalFavoriteFragment.this.rlNodata != null) {
                        LocalFavoriteFragment.this.rlNodata.setVisibility(0);
                        LocalFavoriteFragment.this.tvAgain.setVisibility(8);
                        return;
                    }
                    return;
                }
                LocalFavoriteFragment.this.d.setData(list);
            }
        }));
    }

    private void n() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b(this) { // from class: com.fotoable.youtube.music.ui.fragment.aa

            /* renamed from: a  reason: collision with root package name */
            private final LocalFavoriteFragment f4763a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4763a = this;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                this.f4763a.b((com.fotoable.youtube.music.e.a) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(com.fotoable.youtube.music.e.a aVar) {
        switch (aVar.f2726a) {
            case 3003:
                if (aVar.d == 3) {
                    k();
                    return;
                }
                return;
            case 3004:
                if (aVar.d == 3) {
                    com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "song_sort_order", "title_key");
                    k();
                    return;
                }
                return;
            case 3005:
                if (aVar.d == 3) {
                    com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "song_sort_order", "album");
                    k();
                    return;
                }
                return;
            case 3006:
                if (aVar.d == 3) {
                    com.fotoable.youtube.music.util.v.b(MusicApplication.c().getApplicationContext(), "song_sort_order", "artist");
                    k();
                    return;
                }
                return;
            case 3007:
            case 3008:
            default:
                return;
            case 3009:
                k();
                return;
        }
    }

    private void o() {
        if (this.rlNodata != null) {
            this.rlNodata.setVisibility(8);
        }
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        b(false);
    }

    private void b(boolean z) {
        if (this.refreshLayout != null && !d()) {
            if (z) {
                this.refreshLayout.post(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.fragment.ab

                    /* renamed from: a  reason: collision with root package name */
                    private final LocalFavoriteFragment f4764a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f4764a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f4764a.j();
                    }
                });
            } else {
                new Handler().postDelayed(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.fragment.ac

                    /* renamed from: a  reason: collision with root package name */
                    private final LocalFavoriteFragment f4765a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f4765a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f4765a.i();
                    }
                }, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void j() {
        this.refreshLayout.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i() {
        if (this.refreshLayout != null) {
            this.refreshLayout.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.llError.setVisibility(0);
        this.llError.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.ad

            /* renamed from: a  reason: collision with root package name */
            private final LocalFavoriteFragment f4766a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4766a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f4766a.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(View view) {
        k();
    }

    @Override // com.fotoable.youtube.music.base.i, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.d != null) {
            this.d.destory();
        }
        super.onDestroy();
    }
}
