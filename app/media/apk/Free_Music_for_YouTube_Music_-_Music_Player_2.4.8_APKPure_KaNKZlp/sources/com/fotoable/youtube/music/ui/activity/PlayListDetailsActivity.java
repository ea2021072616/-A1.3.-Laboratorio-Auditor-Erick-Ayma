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
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PlayListDetailBean;
import com.fotoable.youtube.music.bean.SubBean;
import com.fotoable.youtube.music.ui.adapter.GridSpacingItemDecoration;
import com.fotoable.youtube.music.ui.adapter.PlayListDetailAdapter;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.fotoable.youtube.music.ui.view.RoundImageView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class PlayListDetailsActivity extends BaseActivity {
    private static final String f = PlayListDetailsActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public String f3627a;
    @BindView(R.id.app_barLayout)
    AppBarLayout appBarLayout;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.b.e f3628b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3629c;
    @BindView(R.id.che_subscribed)
    CheckBox che_subscribed;
    @BindView(R.id.CollapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Inject
    com.fotoable.youtube.music.b.c d;
    @BindView(R.id.img_del)
    ImageView delImage;
    public List<PlayListDetailBean.ItemsEntity> e;
    @BindView(R.id.empty_bottom_bar)
    View empty_bottom_bar;
    private String g;
    private String h;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.iv_LoadingPic)
    RoundImageView ivLoadingPic;
    @BindView(R.id.iv_play_all)
    Button ivPlayAll;
    private String j;
    private long k;
    private String l;
    @BindView(R.id.main_backdrop)
    ImageView mainBackdrop;
    private PlayListDetailAdapter p;
    private GridLayoutManager q;
    @BindView(R.id.recycle_pop)
    IRecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.rl_details)
    RelativeLayout rlDetails;
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
    private LoadMoreFooterView u;
    private int v;
    private String w;
    private String i = "";
    private int m = 0;
    private int n = 50;
    private int o = 0;
    private boolean r = true;
    private boolean s = false;
    private boolean t = false;
    private OnLoadMoreListener x = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity.2
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (PlayListDetailsActivity.this.r) {
                if (!PlayListDetailsActivity.this.s) {
                    PlayListDetailsActivity.this.u.setStatus(LoadMoreFooterView.Status.LOADING);
                    PlayListDetailsActivity.this.a(PlayListDetailsActivity.this.f3627a, PlayListDetailsActivity.this.l, PlayListDetailsActivity.this.n, PlayListDetailsActivity.this.i);
                    return;
                }
                return;
            }
            PlayListDetailsActivity.this.u.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };

    static /* synthetic */ int f(PlayListDetailsActivity playListDetailsActivity) {
        int i = playListDetailsActivity.m;
        playListDetailsActivity.m = i + 1;
        return i;
    }

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
        a(this.f3627a, this.l, this.n, this.i);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(int i) {
        super.a(i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.empty_bottom_bar.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, i);
        } else {
            layoutParams.height = i;
        }
        this.empty_bottom_bar.setLayoutParams(layoutParams);
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
            this.f3627a = extras.getString("PlaylistId");
            this.g = extras.getString("ImgUrl");
            this.h = extras.getString("Title");
            this.k = extras.getLong("updateTime");
            this.j = extras.getString("Describe");
            this.v = extras.getInt(ShareConstants.FEED_SOURCE_PARAM, 0);
            if (this.v == 2201) {
                this.w = extras.getString("editorChoiceTitle");
            }
        }
        this.tvTitle.setText(this.h + "");
        this.textDetails.setText(this.h + "");
        com.fotoable.youtube.music.helper.d.a(this, this.g, this.ivLoadingPic);
        com.fotoable.youtube.music.helper.d.b(this, this.g, this.mainBackdrop);
        this.e = new ArrayList();
        a(this.f3629c.b(this.f3627a).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<SubBean>>() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                PlayListDetailsActivity.this.t = false;
                PlayListDetailsActivity.this.che_subscribed.setChecked(false);
                PlayListDetailsActivity.this.che_subscribed.setText(PlayListDetailsActivity.this.getResources().getString(R.string.collect_playlist));
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<SubBean> list) {
                if (list == null || list.size() <= 0) {
                    PlayListDetailsActivity.this.t = false;
                    PlayListDetailsActivity.this.che_subscribed.setText(PlayListDetailsActivity.this.getResources().getString(R.string.collect_playlist));
                } else {
                    PlayListDetailsActivity.this.t = true;
                    PlayListDetailsActivity.this.che_subscribed.setText(PlayListDetailsActivity.this.getResources().getString(R.string.collected));
                }
                PlayListDetailsActivity.this.che_subscribed.setChecked(PlayListDetailsActivity.this.t);
            }
        }));
        this.l = com.fotoable.youtube.music.util.v.a(this, "YOU_TUBE_KEY", "AIzaSyBwn6_nAqZvzNb93MeB4PRJ0ZenXCQxJVk");
        this.ivPlayAll.setVisibility(8);
    }

    private void v() {
        this.refreshLayout.setRefreshing(true);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.ax

            /* renamed from: a  reason: collision with root package name */
            private final PlayListDetailsActivity f3957a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3957a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f3957a.s();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void s() {
        this.refreshLayout.setRefreshing(true);
        this.i = "";
        a(this.f3627a, this.l, this.n, this.i);
    }

    private void w() {
        final int i = -com.fotoable.youtube.music.util.w.a(this, 110.0f);
        this.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener(this, i) { // from class: com.fotoable.youtube.music.ui.activity.ay

            /* renamed from: a  reason: collision with root package name */
            private final PlayListDetailsActivity f3958a;

            /* renamed from: b  reason: collision with root package name */
            private final int f3959b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3958a = this;
                this.f3959b = i;
            }

            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f3958a.a(this.f3959b, appBarLayout, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, AppBarLayout appBarLayout, int i2) {
        if (!p()) {
            float f2 = ((i2 * 1.0f) / i) * 1.0f;
            if (this.rlDetails != null) {
                this.rlDetails.setAlpha(1.0f - f2);
            }
            if (this.ivPlayAll != null) {
                this.ivPlayAll.setAlpha(1.0f - f2);
            }
            if (this.tvTitle != null) {
                this.tvTitle.setAlpha(f2);
            }
        }
    }

    private void x() {
        this.recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, 0, true));
        this.q = new GridLayoutManager(this, 1);
        this.recyclerView.setLayoutManager(this.q);
        this.p = new PlayListDetailAdapter(this, getSupportFragmentManager());
        this.p.setSource(this.v);
        this.p.setEditorChoiceTitle(this.w);
        this.p.setTitle(this.h);
        this.p.setIsPlayingID(com.fotoable.youtube.music.newplayer.e.a().e() == null ? "" : com.fotoable.youtube.music.newplayer.e.a().e().getVideoId());
        this.recyclerView.setIAdapter(this.p);
        this.recyclerView.setOnLoadMoreListener(this.x);
        this.u = (LoadMoreFooterView) this.recyclerView.getLoadMoreFooterView();
        this.u.setVisibility(8);
        this.p.setOnItemClickListener(new PlayListDetailAdapter.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity.3
            @Override // com.fotoable.youtube.music.ui.adapter.PlayListDetailAdapter.OnItemClickListener
            public void onPlayNow(PlayListDetailBean.ItemsEntity.SnippetEntity snippetEntity, int i) {
                List<PlayListDetailBean.ItemsEntity> list = PlayListDetailsActivity.this.p.getmItemsEntity();
                com.fotoable.youtube.music.util.h.a(PlayListDetailsActivity.f, i + "  ---------------");
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, com.fotoable.youtube.music.newplayer.a.b.d(list), i));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.PlayListDetailAdapter.OnItemClickListener
            public void onPlayNext(PlayListDetailBean.ItemsEntity.SnippetEntity snippetEntity) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2002, com.fotoable.youtube.music.newplayer.a.b.a(snippetEntity)));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.PlayListDetailAdapter.OnItemClickListener
            public void onAddToPlayQueue(PlayListDetailBean.ItemsEntity.SnippetEntity snippetEntity) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2003, com.fotoable.youtube.music.newplayer.a.b.a(snippetEntity)));
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
                com.fotoable.youtube.music.util.b.b("歌单点击播放全部");
                com.fotoable.youtube.music.util.b.a("歌单点击播放全部");
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2004, com.fotoable.youtube.music.newplayer.a.b.d(this.e)));
                return;
            case R.id.img_del /* 2131820843 */:
                SimpleMusicDialog.a(getSupportFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity.4
                    @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                    public void a() {
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                    public void b() {
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                    public void c() {
                        PlayListDetailsActivity.this.y();
                    }
                }, R.string.delete_playlist_tips, R.string.cancel, R.string.ok);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (!TextUtils.isEmpty(this.f3627a)) {
            a(this.d.a(this.f3627a, 3).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<MyHttpResponse>() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity.5
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    com.fotoable.youtube.music.util.h.a(PlayListDetailsActivity.f, th.getMessage());
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse myHttpResponse) {
                    if (myHttpResponse.isSuccess()) {
                        PlayListDetailsActivity.this.finish();
                        com.fotoable.youtube.music.util.h.a(PlayListDetailsActivity.f, "删除成功");
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
                    com.fotoable.youtube.music.util.b.b("在线音乐-歌单详情-点击订阅", "value", this.f3627a);
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
        subBean.setImgUrl(this.g);
        subBean.setPlaylistid(this.f3627a);
        subBean.setTitle(this.h);
        subBean.setUpdateTime(this.k);
        subBean.setDesc(this.j);
        if (!z) {
            a(this.f3629c.b(subBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity.6
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
            a(this.f3629c.a(subBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity.7
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
        new Handler().postDelayed(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.activity.az

            /* renamed from: a  reason: collision with root package name */
            private final PlayListDetailsActivity f3960a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3960a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3960a.r();
            }
        }, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void r() {
        if (this.refreshLayout != null) {
            this.refreshLayout.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, final int i, final String str3) {
        if (!this.s) {
            this.s = true;
            if (this.tvError != null) {
                this.tvError.setVisibility(8);
            }
            a(this.f3628b.a(str, str2, i, str3).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<PlayListDetailBean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity.8
                @Override // rx.g
                public void onCompleted() {
                    PlayListDetailsActivity.this.s = false;
                    if (PlayListDetailsActivity.this.u != null) {
                        PlayListDetailsActivity.this.u.setVisibility(0);
                    }
                    PlayListDetailsActivity.this.z();
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    com.fotoable.youtube.music.util.b.b("dev_youtube_api_error", "errorName", th.getMessage());
                    com.fotoable.youtube.music.util.b.a(th);
                    PlayListDetailsActivity.this.s = false;
                    PlayListDetailsActivity.this.z();
                    if (PlayListDetailsActivity.this.tvError != null && PlayListDetailsActivity.this.p != null && PlayListDetailsActivity.this.p.getItemCount() <= 0) {
                        PlayListDetailsActivity.this.tvError.setVisibility(0);
                        PlayListDetailsActivity.this.refreshLayout.setRefreshing(false);
                    }
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(PlayListDetailBean playListDetailBean) {
                    if (playListDetailBean.getItems() != null && playListDetailBean.getItems().size() != 0) {
                        if (TextUtils.isEmpty(str3)) {
                            PlayListDetailsActivity.this.p.cleanDatas();
                        }
                        PlayListDetailsActivity.this.p.setAddDatas(playListDetailBean.getItems());
                        PlayListDetailsActivity.this.ivPlayAll.setVisibility(0);
                        PlayListDetailsActivity.this.e.addAll(playListDetailBean.getItems());
                        PlayListDetailsActivity.this.i = playListDetailBean.getNextPageToken();
                        PlayListDetailsActivity.this.o = playListDetailBean.getPageInfo().getTotalResults();
                        PlayListDetailsActivity.f(PlayListDetailsActivity.this);
                        PlayListDetailsActivity.this.tvError.setVisibility(8);
                        PlayListDetailsActivity.this.r = PlayListDetailsActivity.this.o > i * PlayListDetailsActivity.this.m;
                    }
                }
            }));
        }
    }

    private void a(boolean z, FavBean favBean) {
        rx.m b2;
        if (z) {
            b2 = this.f3629c.a(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity.9
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
            b2 = this.f3629c.b(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayListDetailsActivity.10
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
                if (this.p != null) {
                    this.p.setIsPlayingID((String) aVar.f2727b);
                    return;
                }
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                if (this.p != null) {
                    this.p.setIsPlayingID("");
                    return;
                }
                return;
            case 1031:
                if (this.p != null) {
                    this.p.changeFavState(aVar.f2728c, aVar.e);
                    com.fotoable.youtube.music.util.h.a(f, "更新收藏状态");
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
            if (this.p != null) {
                this.p.cleanDatas();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @OnClick({R.id.ll_error})
    public void onClick() {
        this.refreshLayout.setRefreshing(true);
        this.i = "";
        a(this.f3627a, this.l, this.n, this.i);
    }
}
