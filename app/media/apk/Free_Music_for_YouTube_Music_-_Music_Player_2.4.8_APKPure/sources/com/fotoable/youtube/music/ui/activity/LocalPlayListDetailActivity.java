package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.ui.adapter.LocalSongAdapter;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class LocalPlayListDetailActivity extends BaseActivity {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3441a;

    /* renamed from: b  reason: collision with root package name */
    private int f3442b;

    /* renamed from: c  reason: collision with root package name */
    private String f3443c;
    private LocalSongAdapter d;
    @BindView(R.id.recycle_view)
    RecyclerView recycle_view;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refresh_layout;
    @BindView(R.id.rl_nodata)
    RelativeLayout rl_no_data;
    @BindView(R.id.title)
    TextView titleView;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_local_play_list_detail;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        this.f3442b = getIntent().getIntExtra("position", 0);
        this.f3443c = getIntent().getStringExtra("title");
        this.titleView.setText(this.f3443c);
        this.refresh_layout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.aj

            /* renamed from: a  reason: collision with root package name */
            private final LocalPlayListDetailActivity f3929a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3929a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f3929a.r();
            }
        });
        this.recycle_view.setLayoutManager(new LinearLayoutManager(this));
        this.d = new LocalSongAdapter(this, getSupportFragmentManager());
        this.recycle_view.setAdapter(this.d);
        r();
        if (this.f3442b == 0) {
            com.fotoable.youtube.music.util.b.b("本地音乐--收藏页面展示次数");
            com.fotoable.youtube.music.util.b.b("本地歌单-收藏页面展示次数");
        } else if (this.f3442b == 1) {
            com.fotoable.youtube.music.util.b.b("本地歌单-最近播放展示次数");
        } else if (this.f3442b == 2) {
            com.fotoable.youtube.music.util.b.b("本地歌单-最近添加展示次数");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void r() {
        if (this.f3442b == 0) {
            t();
        } else if (this.f3442b == 1) {
            u();
        } else if (this.f3442b == 2) {
            v();
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.back_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            default:
                return;
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(com.fotoable.youtube.music.e.a aVar) {
        super.a(aVar);
        switch (aVar.f2726a) {
            case 3009:
            case 3010:
                r();
                return;
            default:
                return;
        }
    }

    private void t() {
        this.refresh_layout.setRefreshing(true);
        a(this.f3441a.i().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalPlayListDetailActivity.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                LocalPlayListDetailActivity.this.a((List<LocalSongBean>) null);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                LocalPlayListDetailActivity.this.a(list);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LocalSongBean> list) {
        this.refresh_layout.setRefreshing(false);
        if (list == null || list.size() == 0) {
            this.rl_no_data.setVisibility(0);
            this.recycle_view.setVisibility(8);
            this.d.setData(list);
            this.refresh_layout.setRefreshing(false);
            return;
        }
        this.rl_no_data.setVisibility(8);
        this.recycle_view.setVisibility(0);
        if (this.d == null) {
            this.d = new LocalSongAdapter(this, getSupportFragmentManager());
            this.recycle_view.setAdapter(this.d);
        }
        this.d.setData(list);
    }

    private void u() {
        this.refresh_layout.setRefreshing(true);
        a(rx.f.a((f.a) new f.a<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalPlayListDetailActivity.3
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<LocalSongBean>> lVar) {
                List<LocalSongBean> n = LocalPlayListDetailActivity.this.f3441a.n();
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(n);
                    lVar.onCompleted();
                }
            }
        }).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalPlayListDetailActivity.2
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                LocalPlayListDetailActivity.this.a((List<LocalSongBean>) null);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                LocalPlayListDetailActivity.this.a(list);
            }
        }));
    }

    private void v() {
        this.refresh_layout.setRefreshing(true);
        a(rx.f.a((f.a) new f.a<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalPlayListDetailActivity.5
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<LocalSongBean>> lVar) {
                List<LocalSongBean> o = LocalPlayListDetailActivity.this.f3441a.o();
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(o);
                    lVar.onCompleted();
                }
            }
        }).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalPlayListDetailActivity.4
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                LocalPlayListDetailActivity.this.a((List<LocalSongBean>) null);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                LocalPlayListDetailActivity.this.a(list);
            }
        }));
    }
}
