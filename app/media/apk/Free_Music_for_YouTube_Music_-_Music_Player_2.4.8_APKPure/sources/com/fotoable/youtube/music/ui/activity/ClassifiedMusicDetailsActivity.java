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
import com.fotoable.youtube.music.bean.ClassifiedRankVideoBean;
import com.fotoable.youtube.music.d.a.c;
import com.fotoable.youtube.music.ui.adapter.ClassifiedMusicDetailAdapter;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.fotoable.youtube.music.ui.view.RoundImageView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class ClassifiedMusicDetailsActivity extends BaseActivity implements c.a {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.d.d f3196a;
    @BindView(R.id.app_barLayout)
    AppBarLayout appBarLayout;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayoutManager f3198c;
    @BindView(R.id.CollapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    private ClassifiedMusicDetailAdapter d;
    private LoadMoreFooterView e;
    private String f;
    private String g;
    private long h;
    private int i;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.iv_LoadingPic)
    RoundImageView ivLoadingPic;
    @BindView(R.id.iv_play_all)
    Button ivPlayAll;
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

    /* renamed from: b  reason: collision with root package name */
    private SimpleDateFormat f3197b = new SimpleDateFormat("MM/dd/yyyy");
    private OnLoadMoreListener j = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.activity.ClassifiedMusicDetailsActivity.2
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (ClassifiedMusicDetailsActivity.this.f3196a.d()) {
                ClassifiedMusicDetailsActivity.this.e.setStatus(LoadMoreFooterView.Status.LOADING);
                ClassifiedMusicDetailsActivity.this.f3196a.a(ClassifiedMusicDetailsActivity.this.i);
                return;
            }
            ClassifiedMusicDetailsActivity.this.e.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_classified_muisc_details;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
        this.f3196a.a((c.a) this);
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
        this.f3198c = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(this.f3198c);
        this.d = new ClassifiedMusicDetailAdapter(this, getSupportFragmentManager());
        this.d.setIsPlayingID(com.fotoable.youtube.music.newplayer.e.a().e() == null ? "" : com.fotoable.youtube.music.newplayer.e.a().e().getVideoId());
        this.recyclerView.setIAdapter(this.d);
        this.recyclerView.setOnLoadMoreListener(this.j);
        this.e = (LoadMoreFooterView) this.recyclerView.getLoadMoreFooterView();
        this.e.setVisibility(8);
        this.d.setOnItemClickListener(new ClassifiedMusicDetailAdapter.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.activity.ClassifiedMusicDetailsActivity.1
            @Override // com.fotoable.youtube.music.ui.adapter.ClassifiedMusicDetailAdapter.OnItemClickListener
            public void onPlayNow(ClassifiedRankVideoBean classifiedRankVideoBean) {
                ArrayList<ClassifiedRankVideoBean> arrayList = ClassifiedMusicDetailsActivity.this.d.getclassifiedRankVideoBeen();
                if (arrayList != null) {
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, com.fotoable.youtube.music.newplayer.a.b.f(arrayList), arrayList.indexOf(classifiedRankVideoBean)));
                    if (classifiedRankVideoBean != null) {
                        com.fotoable.youtube.music.util.b.b("分类榜单点击播放单曲", "视频ID", classifiedRankVideoBean.getVideoid());
                        com.fotoable.youtube.music.util.b.a("分类榜单点击播放单曲", "视频ID", classifiedRankVideoBean.getVideoid());
                    }
                }
            }

            @Override // com.fotoable.youtube.music.ui.adapter.ClassifiedMusicDetailAdapter.OnItemClickListener
            public void onPlayNext(ClassifiedRankVideoBean classifiedRankVideoBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2002, com.fotoable.youtube.music.newplayer.a.b.a(classifiedRankVideoBean)));
                if (classifiedRankVideoBean != null) {
                    com.fotoable.youtube.music.util.b.b("分类榜单点击播放单曲", "视频ID", classifiedRankVideoBean.getVideoid());
                    com.fotoable.youtube.music.util.b.a("分类榜单点击播放单曲", "视频ID", classifiedRankVideoBean.getVideoid());
                }
            }

            @Override // com.fotoable.youtube.music.ui.adapter.ClassifiedMusicDetailAdapter.OnItemClickListener
            public void onAddToPlayQueue(ClassifiedRankVideoBean classifiedRankVideoBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2003, com.fotoable.youtube.music.newplayer.a.b.a(classifiedRankVideoBean)));
                if (classifiedRankVideoBean != null) {
                    com.fotoable.youtube.music.util.b.b("分类榜单点击播放单曲", "视频ID", classifiedRankVideoBean.getVideoid());
                    com.fotoable.youtube.music.util.b.a("分类榜单点击播放单曲", "视频ID", classifiedRankVideoBean.getVideoid());
                }
            }
        });
    }

    private void t() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.b

            /* renamed from: a  reason: collision with root package name */
            private final ClassifiedMusicDetailsActivity f3961a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3961a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f3961a.r();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setRefreshing(true);
        this.f3196a.a(this.i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void r() {
        this.f3196a.b();
        this.f3196a.a(this.i);
    }

    private void u() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f = extras.getString("ImgURL");
            this.g = extras.getString(ShareConstants.TITLE);
            this.h = extras.getLong("LastUpdateTime");
            this.i = extras.getInt("ChartsId");
            this.tvTitle.setText(this.g == null ? "" : this.g);
            this.txtTitle.setText(this.g == null ? "" : this.g);
            this.txtUpdateTime.setText(getResources().getString(R.string.last_updated) + " " + this.f3197b.format(new Date(this.h)));
            com.fotoable.youtube.music.helper.d.a(this, this.f, this.ivLoadingPic, R.mipmap.loadingpic_187);
            com.fotoable.youtube.music.helper.d.b(this, this.f, this.mainBackdrop);
            this.f3196a.a();
        }
    }

    private void v() {
        final int i = -com.fotoable.youtube.music.util.w.a(this, 110.0f);
        this.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener(this, i) { // from class: com.fotoable.youtube.music.ui.activity.c

            /* renamed from: a  reason: collision with root package name */
            private final ClassifiedMusicDetailsActivity f3991a;

            /* renamed from: b  reason: collision with root package name */
            private final int f3992b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3991a = this;
                this.f3992b = i;
            }

            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f3991a.a(this.f3992b, appBarLayout, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, AppBarLayout appBarLayout, int i2) {
        float f = ((i2 * 1.0f) / i) * 1.0f;
        this.rlDetails.setAlpha(1.0f - f);
        this.ivPlayAll.setAlpha(1.0f - f);
        this.tvTitle.setAlpha(f);
    }

    @OnClick({R.id.img_back, R.id.iv_play_all, R.id.ll_error})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                finish();
                return;
            case R.id.ll_error /* 2131820763 */:
                this.f3196a.b();
                this.d.cleanDatas();
                this.f3196a.a(this.i);
                return;
            case R.id.iv_play_all /* 2131820766 */:
                w();
                return;
            default:
                return;
        }
    }

    private void w() {
        ArrayList<ClassifiedRankVideoBean> arrayList = this.d.getclassifiedRankVideoBeen();
        if (arrayList != null) {
            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2004, com.fotoable.youtube.music.newplayer.a.b.f(arrayList)));
            com.fotoable.youtube.music.util.b.b("在线音乐-分类榜单点击播放全部");
            com.fotoable.youtube.music.util.b.a("在线音乐-分类榜单点击播放全部");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            this.f3196a.c();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.c.a
    public void a(ArrayList<ClassifiedRankVideoBean> arrayList) {
        if (this.refreshLayout.isRefreshing()) {
            this.d.cleanDatas();
        }
        this.refreshLayout.setRefreshing(false);
        this.e.setVisibility(0);
        this.ivPlayAll.setVisibility(0);
        if (arrayList != null) {
            this.d.setAddDatas(arrayList);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.c.a
    public void c_() {
        this.refreshLayout.setRefreshing(false);
        if (this.d.getItemCount() == 0) {
            this.tvError.setVisibility(0);
            this.d.cleanDatas();
        }
    }

    @Override // com.fotoable.youtube.music.d.a.c.a
    public void a(String str, boolean z) {
        if (this.d != null) {
            this.d.changeFavState(str, z);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.c.a
    public void d_() {
        this.e.setStatus(LoadMoreFooterView.Status.THE_END);
    }

    @Override // com.fotoable.youtube.music.d.a.c.a
    public void a(String str) {
        if (this.d != null) {
            this.d.setIsPlayingID(str);
        }
    }
}
