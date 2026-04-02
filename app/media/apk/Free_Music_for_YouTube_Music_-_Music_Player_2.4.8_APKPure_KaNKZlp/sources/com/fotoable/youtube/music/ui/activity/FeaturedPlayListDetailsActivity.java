package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.facebook.ads.AdError;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.FeaturedDetailBean;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.SubBean;
import com.fotoable.youtube.music.ui.adapter.FeaturedPlayListDetailAdapter;
import com.fotoable.youtube.music.ui.adapter.GridSpacingItemDecoration;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.fotoable.youtube.music.ui.view.RoundImageView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class FeaturedPlayListDetailsActivity extends BaseActivity {
    private static final String d = FeaturedPlayListDetailsActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public String f3304a;
    @BindView(R.id.app_barLayout)
    AppBarLayout appBarLayout;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3305b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3306c;
    @BindView(R.id.che_subscribed)
    CheckBox che_subscribed;
    @BindView(R.id.CollapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.img_del)
    ImageView delImage;
    private String e;
    private String f;
    private String h;
    private long i;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.iv_LoadingPic)
    RoundImageView ivLoadingPic;
    @BindView(R.id.iv_play_all)
    Button ivPlayAll;
    private FeaturedPlayListDetailAdapter j;
    private GridLayoutManager k;
    @BindView(R.id.main_backdrop)
    ImageView mainBackdrop;
    private LoadMoreFooterView o;
    private List<FeaturedDetailBean> p;
    @BindView(R.id.recycle_pop)
    IRecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.rl_details)
    RelativeLayout rlDetails;
    private int t;
    @BindView(R.id.text_details)
    TextView textDetails;
    @BindView(R.id.text_listen)
    TextView textListen;
    @BindView(R.id.text_people)
    TextView textPeople;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_error)
    LinearLayout tvError;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private int u;
    private String v;
    private String g = "";
    private boolean l = true;
    private boolean m = false;
    private boolean n = false;
    private int q = 0;
    private int r = 20;
    private long s = 0;
    private OnLoadMoreListener w = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.3
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (FeaturedPlayListDetailsActivity.this.l) {
                if (!FeaturedPlayListDetailsActivity.this.m) {
                    FeaturedPlayListDetailsActivity.this.o.setStatus(LoadMoreFooterView.Status.LOADING);
                    FeaturedPlayListDetailsActivity.this.z();
                    return;
                }
                return;
            }
            FeaturedPlayListDetailsActivity.this.o.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_play_list_details;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        u();
        x();
        w();
        v();
        d();
        z();
    }

    private void u() {
        ButterKnife.bind(this);
        if (com.fotoable.youtube.music.util.a.a()) {
            this.delImage.setVisibility(0);
        } else {
            this.delImage.setVisibility(8);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f3304a = extras.getString("PlaylistId");
            this.e = extras.getString("ImgUrl");
            this.f = extras.getString("Title");
            this.i = extras.getLong("updateTime");
            this.h = extras.getString("Describe");
            this.t = extras.getInt("type", 1);
            this.u = extras.getInt(ShareConstants.FEED_SOURCE_PARAM, 0);
            if (this.u == 2201) {
                this.v = extras.getString("editorChoiceTitle");
            }
        }
        this.tvTitle.setText(this.f + "");
        this.textDetails.setText(this.f + "");
        com.fotoable.youtube.music.helper.d.a(this, this.e, this.ivLoadingPic);
        com.fotoable.youtube.music.helper.d.b(this, this.e, this.mainBackdrop);
        this.p = new ArrayList();
        a(this.f3305b.b(this.f3304a).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<SubBean>>() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                FeaturedPlayListDetailsActivity.this.n = false;
                FeaturedPlayListDetailsActivity.this.che_subscribed.setChecked(false);
                FeaturedPlayListDetailsActivity.this.che_subscribed.setText(FeaturedPlayListDetailsActivity.this.getResources().getString(R.string.collect_playlist));
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<SubBean> list) {
                if (list == null || list.size() <= 0) {
                    FeaturedPlayListDetailsActivity.this.n = false;
                    FeaturedPlayListDetailsActivity.this.che_subscribed.setText(FeaturedPlayListDetailsActivity.this.getResources().getString(R.string.collect_playlist));
                } else {
                    FeaturedPlayListDetailsActivity.this.n = true;
                    FeaturedPlayListDetailsActivity.this.che_subscribed.setText(FeaturedPlayListDetailsActivity.this.getResources().getString(R.string.collected));
                }
                FeaturedPlayListDetailsActivity.this.che_subscribed.setChecked(FeaturedPlayListDetailsActivity.this.n);
            }
        }));
        this.ivPlayAll.setVisibility(8);
    }

    private void v() {
        this.refreshLayout.setRefreshing(true);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.v

            /* renamed from: a  reason: collision with root package name */
            private final FeaturedPlayListDetailsActivity f4018a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4018a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4018a.s();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void s() {
        this.q = 0;
        this.s = 0L;
        z();
        b(true);
    }

    private void w() {
        final int i = -com.fotoable.youtube.music.util.w.a(this, 110.0f);
        this.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener(this, i) { // from class: com.fotoable.youtube.music.ui.activity.w

            /* renamed from: a  reason: collision with root package name */
            private final FeaturedPlayListDetailsActivity f4019a;

            /* renamed from: b  reason: collision with root package name */
            private final int f4020b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4019a = this;
                this.f4020b = i;
            }

            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f4019a.a(this.f4020b, appBarLayout, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, AppBarLayout appBarLayout, int i2) {
        if (!p()) {
            float f = ((i2 * 1.0f) / i) * 1.0f;
            if (this.rlDetails != null) {
                this.rlDetails.setAlpha(1.0f - f);
            }
            if (this.ivPlayAll != null) {
                this.ivPlayAll.setAlpha(1.0f - f);
            }
            if (this.tvTitle != null) {
                this.tvTitle.setAlpha(f);
            }
        }
    }

    private void x() {
        this.recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, 0, true));
        this.k = new GridLayoutManager(this, 1);
        this.recyclerView.setLayoutManager(this.k);
        this.j = new FeaturedPlayListDetailAdapter(this, getSupportFragmentManager());
        this.j.setIsPlayingID(com.fotoable.youtube.music.newplayer.e.a().e() == null ? "" : com.fotoable.youtube.music.newplayer.e.a().e().getVideoId());
        this.j.setSource(this.u);
        this.j.setEditorChoiceTitle(this.v);
        this.j.setTitle(this.f);
        this.recyclerView.setIAdapter(this.j);
        this.recyclerView.setOnLoadMoreListener(this.w);
        this.o = (LoadMoreFooterView) this.recyclerView.getLoadMoreFooterView();
        this.o.setVisibility(8);
        this.j.setOnItemClickListener(new FeaturedPlayListDetailAdapter.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.4
            @Override // com.fotoable.youtube.music.ui.adapter.FeaturedPlayListDetailAdapter.OnItemClickListener
            public void onPlayNow(FeaturedDetailBean featuredDetailBean) {
                List<FeaturedDetailBean> list = FeaturedPlayListDetailsActivity.this.j.getmItemsEntity();
                int indexOf = list.indexOf(featuredDetailBean);
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, com.fotoable.youtube.music.newplayer.a.b.g(list), indexOf));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.FeaturedPlayListDetailAdapter.OnItemClickListener
            public void onPlayNext(FeaturedDetailBean featuredDetailBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2002, com.fotoable.youtube.music.newplayer.a.b.a(featuredDetailBean)));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.FeaturedPlayListDetailAdapter.OnItemClickListener
            public void onAddToPlayQueue(FeaturedDetailBean featuredDetailBean) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2003, com.fotoable.youtube.music.newplayer.a.b.a(featuredDetailBean)));
            }
        });
    }

    @OnClick({R.id.img_back, R.id.iv_play_all, R.id.img_del})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                finish();
                return;
            case R.id.iv_play_all /* 2131820766 */:
                com.fotoable.youtube.music.util.b.b("推荐歌单详情页--点击播放全部");
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2004, com.fotoable.youtube.music.newplayer.a.b.g(this.p)));
                return;
            case R.id.img_del /* 2131820843 */:
                SimpleMusicDialog.a(getSupportFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.5
                    @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                    public void a() {
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                    public void b() {
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                    public void c() {
                        FeaturedPlayListDetailsActivity.this.y();
                    }
                }, R.string.delete_playlist_tips, R.string.cancel, R.string.ok);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (!TextUtils.isEmpty(this.f3304a)) {
            a(this.f3306c.a(this.f3304a, 3).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<MyHttpResponse>() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.6
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    com.fotoable.youtube.music.util.h.a(FeaturedPlayListDetailsActivity.d, th.getMessage());
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse myHttpResponse) {
                    if (myHttpResponse.isSuccess()) {
                        FeaturedPlayListDetailsActivity.this.finish();
                        com.fotoable.youtube.music.util.h.a(FeaturedPlayListDetailsActivity.d, "删除成功");
                    }
                }
            }));
        }
    }

    @OnCheckedChanged({R.id.che_subscribed})
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.che_subscribed /* 2131820842 */:
                if (z) {
                    com.fotoable.youtube.music.util.b.b("Sub-Click", "value", this.f3304a);
                    compoundButton.setText(getResources().getString(R.string.collected));
                } else {
                    compoundButton.setText(getResources().getString(R.string.collect_playlist));
                }
                a(z);
                return;
            default:
                return;
        }
    }

    private void a(boolean z) {
        SubBean subBean = new SubBean();
        subBean.setImgUrl(this.e);
        subBean.setPlaylistid(this.f3304a);
        subBean.setTitle(this.f);
        subBean.setType(this.t + "");
        com.fotoable.youtube.music.util.h.a("=========" + this.t);
        subBean.setUpdateTime(this.i);
        subBean.setDesc(this.h);
        if (!z) {
            a(this.f3305b.b(subBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.7
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                }
            }));
        } else {
            a(this.f3305b.a(subBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.8
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                }
            }));
        }
        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1044));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (!this.m) {
            this.m = true;
            if (this.tvError != null) {
                this.tvError.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f3304a)) {
                a(this.f3306c.a(this.t, this.f3304a, this.q, this.r, this.s).b(new rx.c.e<MyHttpResponse<List<FeaturedDetailBean>>, rx.f<MyHttpResponse<List<FeaturedDetailBean>>>>() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.10
                    @Override // rx.c.e
                    public rx.f<MyHttpResponse<List<FeaturedDetailBean>>> a(MyHttpResponse<List<FeaturedDetailBean>> myHttpResponse) {
                        return (myHttpResponse.getData() == null || myHttpResponse.getData().size() <= 0) ? rx.f.a(myHttpResponse) : FeaturedPlayListDetailsActivity.this.f3305b.a(myHttpResponse);
                    }
                }).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<List<FeaturedDetailBean>>>() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.9
                    @Override // rx.g
                    public void onCompleted() {
                        FeaturedPlayListDetailsActivity.this.b(false);
                        if (FeaturedPlayListDetailsActivity.this.o != null) {
                            FeaturedPlayListDetailsActivity.this.o.setVisibility(0);
                        }
                    }

                    @Override // rx.g
                    public void onError(Throwable th) {
                        FeaturedPlayListDetailsActivity.this.b(false);
                        if (FeaturedPlayListDetailsActivity.this.tvError != null && FeaturedPlayListDetailsActivity.this.j != null && FeaturedPlayListDetailsActivity.this.j.getItemCount() <= 0) {
                            FeaturedPlayListDetailsActivity.this.tvError.setVisibility(0);
                            FeaturedPlayListDetailsActivity.this.refreshLayout.setRefreshing(false);
                        }
                    }

                    @Override // rx.g
                    /* renamed from: a */
                    public void onNext(MyHttpResponse<List<FeaturedDetailBean>> myHttpResponse) {
                        if (myHttpResponse.getData() == null || myHttpResponse.getData().size() <= 0) {
                            FeaturedPlayListDetailsActivity.this.l = false;
                            if (FeaturedPlayListDetailsActivity.this.o != null) {
                                FeaturedPlayListDetailsActivity.this.o.setStatus(LoadMoreFooterView.Status.THE_END);
                            }
                        } else {
                            FeaturedPlayListDetailsActivity.this.p.addAll(myHttpResponse.getData());
                            FeaturedPlayListDetailsActivity.this.j.setAddDatas(myHttpResponse.getData());
                            FeaturedPlayListDetailsActivity.this.q += FeaturedPlayListDetailsActivity.this.r;
                            FeaturedPlayListDetailsActivity.this.l = true;
                            FeaturedPlayListDetailsActivity.this.ivPlayAll.setVisibility(0);
                        }
                        FeaturedPlayListDetailsActivity.this.s = myHttpResponse.getMeta().getMixid();
                        if (FeaturedPlayListDetailsActivity.this.tvError != null) {
                            FeaturedPlayListDetailsActivity.this.tvError.setVisibility(8);
                        }
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.refreshLayout != null) {
            if (z) {
                this.m = true;
                this.refreshLayout.setRefreshing(true);
                return;
            }
            this.m = false;
            new Handler().postDelayed(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.activity.x

                /* renamed from: a  reason: collision with root package name */
                private final FeaturedPlayListDetailsActivity f4021a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4021a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f4021a.r();
                }
            }, 1500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void r() {
        if (this.refreshLayout != null) {
            this.refreshLayout.setRefreshing(false);
        }
    }

    private void a(boolean z, FavBean favBean) {
        rx.m b2;
        if (z) {
            b2 = this.f3305b.a(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.11
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                }
            });
        } else {
            b2 = this.f3305b.b(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.FeaturedPlayListDetailsActivity.2
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                }
            });
        }
        a(b2);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(com.fotoable.youtube.music.e.a aVar) {
        super.a(aVar);
        switch (aVar.f2726a) {
            case PointerIconCompat.TYPE_HELP /* 1003 */:
                a(true, (FavBean) aVar.f2727b);
                return;
            case PointerIconCompat.TYPE_WAIT /* 1004 */:
                a(false, (FavBean) aVar.f2727b);
                return;
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                if (this.j != null) {
                    this.j.setIsPlayingID((String) aVar.f2727b);
                    return;
                }
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                if (this.j != null) {
                    this.j.setIsPlayingID("");
                    return;
                }
                return;
            case 1031:
                if (this.j != null) {
                    this.j.changeFavState(aVar.f2728c, aVar.e);
                    com.fotoable.youtube.music.util.h.a(d, "更新收藏状态");
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.j != null) {
                this.j.cleanDatas();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @OnClick({R.id.ll_error})
    public void onClick() {
        this.q = 0;
        this.s = 0L;
        z();
        b(true);
    }
}
