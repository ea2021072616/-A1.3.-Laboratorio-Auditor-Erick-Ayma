package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.facebook.ads.AdError;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.GlobalRankVideoBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.d.a.h;
import com.fotoable.youtube.music.ui.adapter.GlobalMusicDetailAdapter;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.fotoable.youtube.music.ui.view.RoundImageView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class GlobalMusicDetailsActivity extends BaseActivity implements h.a {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.d.r f3343a;
    @BindView(R.id.app_barLayout)
    AppBarLayout appBarLayout;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3344b;
    @BindView(R.id.CollapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    private LinearLayoutManager d;
    private GlobalMusicDetailAdapter e;
    private LoadMoreFooterView f;
    private String g;
    private String h;
    private long i;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.iv_LoadingPic)
    RoundImageView ivLoadingPic;
    @BindView(R.id.iv_play_all)
    Button ivPlayAll;
    private int j;
    @BindView(R.id.main_backdrop)
    ImageView mainBackdrop;
    @BindView(R.id.recycle_pop)
    IRecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    ISwipeRefreshLayout refreshLayout;
    @BindView(R.id.rl_details)
    RelativeLayout rlDetails;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_error)
    LinearLayout tvError;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_update_time)
    TextView txtUpdateTime;

    /* renamed from: c  reason: collision with root package name */
    private SimpleDateFormat f3345c = new SimpleDateFormat("MM/dd/yyyy");
    private OnLoadMoreListener k = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.activity.GlobalMusicDetailsActivity.2
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (GlobalMusicDetailsActivity.this.f3343a.d()) {
                GlobalMusicDetailsActivity.this.f3343a.a(GlobalMusicDetailsActivity.this.j);
                GlobalMusicDetailsActivity.this.f.setStatus(LoadMoreFooterView.Status.LOADING);
                return;
            }
            GlobalMusicDetailsActivity.this.f.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };
    private GlobalMusicDetailAdapter.OnAdminDeleteLister l = new GlobalMusicDetailAdapter.OnAdminDeleteLister() { // from class: com.fotoable.youtube.music.ui.activity.GlobalMusicDetailsActivity.4
        @Override // com.fotoable.youtube.music.ui.adapter.GlobalMusicDetailAdapter.OnAdminDeleteLister
        public void onDelete(final GlobalRankVideoBean globalRankVideoBean, final int i) {
            SimpleMusicDialog.a(GlobalMusicDetailsActivity.this.getSupportFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.GlobalMusicDetailsActivity.4.1
                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void a() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void b() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void c() {
                    GlobalMusicDetailsActivity.this.a(globalRankVideoBean, i);
                }
            }, R.string.sure_delete, R.string.cancel, R.string.ok);
        }
    };

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_global_muisc_details;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
        this.f3343a.a((h.a) this);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        u();
        v();
        s();
        t();
    }

    private void s() {
        this.d = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(this.d);
        this.e = new GlobalMusicDetailAdapter(this, getSupportFragmentManager());
        this.e.setOnAdminDeleteLister(this.l);
        this.e.setIsPlayingID(com.fotoable.youtube.music.newplayer.e.a().e() == null ? "" : com.fotoable.youtube.music.newplayer.e.a().e().getVideoId());
        this.recyclerView.setIAdapter(this.e);
        this.recyclerView.setOnLoadMoreListener(this.k);
        this.f = (LoadMoreFooterView) this.recyclerView.getLoadMoreFooterView();
        this.f.setVisibility(8);
        this.e.setOnItemClickListener(new GlobalMusicDetailAdapter.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.activity.GlobalMusicDetailsActivity.1
            @Override // com.fotoable.youtube.music.ui.adapter.GlobalMusicDetailAdapter.OnItemClickListener
            public void onPlayNow(GlobalRankVideoBean globalRankVideoBean) {
                ArrayList<GlobalRankVideoBean> globalRankVideoBeens = GlobalMusicDetailsActivity.this.e.getGlobalRankVideoBeens();
                if (globalRankVideoBeens != null) {
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, com.fotoable.youtube.music.newplayer.a.b.e(globalRankVideoBeens), globalRankVideoBeens.indexOf(globalRankVideoBean)));
                    if (globalRankVideoBean != null) {
                        com.fotoable.youtube.music.util.b.b("Charts-Global-PlaySingle-主流榜单点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                        com.fotoable.youtube.music.util.b.a("Charts-Global-PlaySingle-主流榜单点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                    }
                }
            }

            @Override // com.fotoable.youtube.music.ui.adapter.GlobalMusicDetailAdapter.OnItemClickListener
            public void onPlayNext(GlobalRankVideoBean globalRankVideoBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2002, com.fotoable.youtube.music.newplayer.a.b.a(globalRankVideoBean)));
                if (globalRankVideoBean != null) {
                    com.fotoable.youtube.music.util.b.b("Charts-Global-PlaySingle-主流榜单点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                    com.fotoable.youtube.music.util.b.a("Charts-Global-PlaySingle-主流榜单点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                }
            }

            @Override // com.fotoable.youtube.music.ui.adapter.GlobalMusicDetailAdapter.OnItemClickListener
            public void onAddToPlayQueue(GlobalRankVideoBean globalRankVideoBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2003, com.fotoable.youtube.music.newplayer.a.b.a(globalRankVideoBean)));
                if (globalRankVideoBean != null) {
                    com.fotoable.youtube.music.util.b.b("Charts-Global-PlaySingle-主流榜单点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                    com.fotoable.youtube.music.util.b.a("Charts-Global-PlaySingle-主流榜单点击播放单曲", "视频ID", globalRankVideoBean.getVideoid());
                }
            }
        });
    }

    private void t() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.z

            /* renamed from: a  reason: collision with root package name */
            private final GlobalMusicDetailsActivity f4025a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4025a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4025a.r();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setRefreshing(true);
        this.f3343a.a(this.j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void r() {
        this.f.setVisibility(8);
        this.f3343a.b();
        this.f3343a.a(this.j);
    }

    private void u() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.g = extras.getString("ImgURL");
            this.h = extras.getString(ShareConstants.TITLE);
            this.i = extras.getLong("LastUpdateTime");
            this.j = extras.getInt("ChartsId");
            this.tvTitle.setText(this.h == null ? "" : this.h);
            this.txtTitle.setText(this.h == null ? "" : this.h);
            this.txtUpdateTime.setText(getResources().getString(R.string.last_updated) + " " + this.f3345c.format(new Date(this.i)));
            com.fotoable.youtube.music.helper.d.a(this, this.g, this.ivLoadingPic, R.mipmap.loadingpic_187);
            com.fotoable.youtube.music.helper.d.b(this, this.g, this.mainBackdrop);
            this.f3343a.a();
        }
    }

    private void v() {
        final int i = -com.fotoable.youtube.music.util.w.a(this, 110.0f);
        this.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener(this, i) { // from class: com.fotoable.youtube.music.ui.activity.aa

            /* renamed from: a  reason: collision with root package name */
            private final GlobalMusicDetailsActivity f3913a;

            /* renamed from: b  reason: collision with root package name */
            private final int f3914b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3913a = this;
                this.f3914b = i;
            }

            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f3913a.a(this.f3914b, appBarLayout, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, AppBarLayout appBarLayout, int i2) {
        float f = ((i2 * 1.0f) / i) * 1.0f;
        if (!p()) {
            this.rlDetails.setAlpha(1.0f - f);
            this.ivPlayAll.setAlpha(1.0f - f);
            this.tvTitle.setAlpha(f);
        }
    }

    @OnClick({R.id.img_back, R.id.iv_play_all, R.id.ll_error})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                finish();
                return;
            case R.id.ll_error /* 2131820763 */:
                this.f3343a.b();
                this.f3343a.a(this.j);
                return;
            case R.id.iv_play_all /* 2131820766 */:
                w();
                return;
            default:
                return;
        }
    }

    private void w() {
        ArrayList<GlobalRankVideoBean> globalRankVideoBeens = this.e.getGlobalRankVideoBeens();
        if (globalRankVideoBeens != null) {
            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2004, com.fotoable.youtube.music.newplayer.a.b.e(globalRankVideoBeens)));
            com.fotoable.youtube.music.util.b.b("在线音乐-主流榜单点击播放全部");
            com.fotoable.youtube.music.util.b.a("在线音乐-主流榜单点击播放全部");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            this.f3343a.c();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.h.a
    public void a(ArrayList<GlobalRankVideoBean> arrayList) {
        if (this.refreshLayout.isRefreshing()) {
            this.e.cleanDatas();
        }
        this.refreshLayout.setRefreshing(false);
        this.f.setVisibility(0);
        this.ivPlayAll.setVisibility(0);
        if (arrayList != null) {
            this.e.setAddDatas(arrayList);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.h.a
    public void e_() {
        this.refreshLayout.setRefreshing(false);
        if (this.e.getItemCount() == 0) {
            this.tvError.setVisibility(0);
            this.e.cleanDatas();
        }
    }

    @Override // com.fotoable.youtube.music.d.a.h.a
    public void a(String str, boolean z) {
        if (this.e != null) {
            this.e.changeFavState(str, z);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.h.a
    public void f_() {
        this.f.setStatus(LoadMoreFooterView.Status.THE_END);
    }

    @Override // com.fotoable.youtube.music.d.a.h.a
    public void a(String str) {
        if (this.e != null) {
            this.e.setIsPlayingID(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final GlobalRankVideoBean globalRankVideoBean, int i) {
        a(this.f3344b.a(globalRankVideoBean.getVideoid(), i + 1).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<MyHttpResponse>() { // from class: com.fotoable.youtube.music.ui.activity.GlobalMusicDetailsActivity.3
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
                    GlobalMusicDetailsActivity.this.e.delete(globalRankVideoBean);
                    com.fotoable.youtube.music.util.h.a("GlobalMusicDetailsActivity", "删除成功");
                }
            }
        }));
    }
}
