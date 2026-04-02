package com.fotoable.youtube.music.ui.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.aw;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.CommentCounter;
import com.fotoable.youtube.music.bean.CommentCounterDataModel;
import com.fotoable.youtube.music.bean.CommentUserInfo;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.bean.PostBean;
import com.fotoable.youtube.music.bean.UserInfoModel;
import com.fotoable.youtube.music.bean.YoutubeComment;
import com.fotoable.youtube.music.bean.YoutubeCommentLocalLikeModel;
import com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity;
import com.fotoable.youtube.music.ui.adapter.CommunityAdapter;
import com.fotoable.youtube.music.ui.adapter.GridSpacingItemDecoration;
import com.fotoable.youtube.music.ui.adapter.PostImageNineSpaceAdapter;
import com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter;
import com.fotoable.youtube.music.ui.dialog.CommentReportDialog;
import com.fotoable.youtube.music.ui.dialog.CommentSelectDialog;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class CommunityPostDetailActivity extends BaseActivity {
    private static final String y = CommunityPostDetailActivity.class.getSimpleName();
    private PostBean A;
    private boolean B;
    private LoadMoreFooterView D;
    private YoutubeCommentAdapter E;
    private TextView F;
    private TextView G;
    private ImageView H;
    private com.fotoable.youtube.music.ui.dialog.n J;
    private String L;
    private String M;
    private String N;
    private UserInfoModel O;

    /* renamed from: a  reason: collision with root package name */
    TextView f3230a;

    /* renamed from: b  reason: collision with root package name */
    RelativeLayout f3231b;

    /* renamed from: c  reason: collision with root package name */
    RoundedImageView f3232c;
    @BindView(R.id.comment_content_et)
    EditText comment_content_et;
    @BindView(R.id.comment_content_et_hint)
    TextView comment_content_et_hint;
    @BindView(R.id.comment_content_et_hint_panel)
    LinearLayout comment_content_et_hint_panel;
    LaToTextView d;
    LaToTextView e;
    LaToTextView f;
    RecyclerView g;
    ImageView h;
    LaToTextView i;
    LaToTextView j;
    LaToTextView k;
    RelativeLayout l;
    View m;
    TextView n;
    TextView o;
    LinearLayout p;
    LottieAnimationView q;
    LinearLayout r;
    @BindView(R.id.recycle_view)
    IRecyclerView recycle_view;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    LinearLayout s;
    @BindView(R.id.send_comment)
    TextView send_comment;
    ImageView t;
    @BindView(R.id.tv_toolbar_title)
    TextView tv_toolbar_title;
    ImageView u;
    TextView v;
    @Inject
    com.fotoable.youtube.music.db.a w;
    @Inject
    com.fotoable.youtube.music.b.c x;
    private ClipboardManager z;
    private int C = 1;
    private OnLoadMoreListener I = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.2
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (!CommunityPostDetailActivity.this.T && CommunityPostDetailActivity.this.P != 0 && CommunityPostDetailActivity.this.E.getItemCount() != 0) {
                if (CommunityPostDetailActivity.this.S) {
                    CommunityPostDetailActivity.this.D.setVisibility(0);
                    CommunityPostDetailActivity.this.D.setStatus(LoadMoreFooterView.Status.LOADING);
                    CommunityPostDetailActivity.this.C();
                    return;
                }
                CommunityPostDetailActivity.this.D.setVisibility(0);
                CommunityPostDetailActivity.this.D.setStatus(LoadMoreFooterView.Status.THE_END);
            }
        }
    };
    private int K = 0;
    private int P = 0;
    private int Q = 20;
    private long R = 0;
    private boolean S = true;
    private boolean T = false;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_youtube_comment;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        com.fotoable.youtube.music.util.b.b("帖子详情-展示次数");
        d();
        this.tv_toolbar_title.setText(R.string.post_detail_title);
        this.A = (PostBean) getIntent().getParcelableExtra("post");
        this.B = getIntent().getBooleanExtra("isShowInput", false);
        if (this.A != null) {
            com.fotoable.youtube.music.util.h.a(y, this.A.toString());
        }
        A();
        x();
        z();
        w();
        C();
        this.z = (ClipboardManager) getSystemService("clipboard");
        if (this.B) {
            this.comment_content_et.postDelayed(new Runnable() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.util.g.a(CommunityPostDetailActivity.this.comment_content_et);
                    CommunityPostDetailActivity.this.comment_content_et.requestFocus();
                }
            }, 500L);
        }
    }

    private void w() {
        if (this.A != null) {
            if (this.A.getUserInfo() != null && this.A.getUserInfo().getData() != null) {
                com.bumptech.glide.i.a((FragmentActivity) this).a(this.A.getUserInfo().getData().getAvatar()).d((int) R.drawable.user_avatar_def).c((int) R.drawable.user_avatar_def).b(com.bumptech.glide.load.b.b.ALL).i().a(this.f3232c);
                this.d.setText(this.A.getUserInfo().getData().getName() + "");
                if (MusicApplication.c().h() == null) {
                    this.x.p();
                }
                if (MusicApplication.c().h() != null) {
                    if (TextUtils.equals(this.A.getUserInfo().getData().getUid(), MusicApplication.c().h().getUid())) {
                        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.12
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                CommunityPostDetailActivity.this.d(CommunityPostDetailActivity.this.A.getBigId());
                            }
                        });
                        this.u.setImageResource(R.drawable.icon_community_delete);
                        this.v.setText(R.string.delete);
                        if (com.fotoable.youtube.music.a.h() || com.fotoable.youtube.music.util.a.a()) {
                            this.H.setVisibility(0);
                        } else {
                            this.H.setVisibility(8);
                        }
                    } else {
                        this.s.setOnClickListener(new AnonymousClass15());
                        this.u.setImageResource(R.drawable.icon_report);
                        this.v.setText(R.string.report);
                        if (this.A.getUserInfo().getData().isVip()) {
                            this.H.setVisibility(0);
                        } else {
                            this.H.setVisibility(8);
                        }
                    }
                } else if (this.A.getUserInfo().getData().isVip()) {
                    this.H.setVisibility(0);
                } else {
                    this.H.setVisibility(8);
                }
            } else if (this.A.getUserInfo().getData().isVip()) {
                this.H.setVisibility(0);
            } else {
                this.H.setVisibility(8);
            }
            this.e.setText(CommunityAdapter.formatCommentTime(this.A.getCreatedAt()) + "");
            if (!TextUtils.isEmpty(this.A.getBody())) {
                this.f.setText(this.A.getBody() + "");
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            if (this.A.getImgUrl() != null && this.A.getImgUrl().size() > 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < this.A.getImgUrl().size(); i++) {
                    arrayList.add(this.A.getImgUrl().get(i).getThumbUrl());
                    arrayList2.add(this.A.getImgUrl().get(i).getImgUrl());
                }
                this.g.setLayoutManager(new GridLayoutManager(this, 3));
                this.g.addItemDecoration(new GridSpacingItemDecoration(3, (int) (getResources().getDisplayMetrics().density * 2.0f), false));
                this.g.setAdapter(new PostImageNineSpaceAdapter(this, arrayList, arrayList2));
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
                this.g.removeAllViews();
            }
            if (!TextUtils.isEmpty(this.A.getVideoId())) {
                if (!TextUtils.isEmpty(this.A.getVideoDuration())) {
                    this.i.setText(this.A.getVideoDuration());
                    this.i.setVisibility(0);
                } else {
                    this.i.setVisibility(8);
                }
                com.bumptech.glide.i.a((FragmentActivity) this).a(this.A.getVideoImgUrl()).b(com.bumptech.glide.load.b.b.ALL).a(this.h);
                this.j.setText(this.A.getVideoTitle() + "");
                if (!TextUtils.isEmpty(this.A.getVideoArtists())) {
                    this.k.setText(this.A.getVideoArtists() + "");
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                this.l.setVisibility(0);
                this.l.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.ui.activity.i

                    /* renamed from: a  reason: collision with root package name */
                    private final CommunityPostDetailActivity f4000a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f4000a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f4000a.i(view);
                    }
                });
            } else {
                this.l.setVisibility(8);
            }
            if (this.A.isLike()) {
                this.t.setImageLevel(1);
                this.n.setTextColor(getResources().getColor(R.color.color_ff2d55));
            } else {
                this.n.setTextColor(getResources().getColor(R.color.color_9b9b9b));
                this.t.setImageLevel(0);
            }
            if (this.A.getCounter() != null && this.A.getCounter().getData() != null) {
                if (this.A.getCounter().getData().getComments_like_count() != 0) {
                    this.n.setText(this.A.getCounter().getData().getComments_like_count() + "");
                } else {
                    this.n.setText(R.string.like);
                }
                if (this.A.getCounter().getData().getCommentsCount() != 0) {
                    this.o.setText(this.A.getCounter().getData().getCommentsCount() + "");
                    return;
                } else {
                    this.o.setText(R.string.comment);
                    return;
                }
            }
            this.n.setText(R.string.like);
            this.o.setText(R.string.comment);
            return;
        }
        com.fotoable.youtube.music.util.h.a(y, "数据错误...");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity$15  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass15 implements View.OnClickListener {
        AnonymousClass15() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommentReportDialog.a(CommunityPostDetailActivity.this.getSupportFragmentManager(), new CommentReportDialog.a(this) { // from class: com.fotoable.youtube.music.ui.activity.o

                /* renamed from: a  reason: collision with root package name */
                private final CommunityPostDetailActivity.AnonymousClass15 f4006a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4006a = this;
                }

                @Override // com.fotoable.youtube.music.ui.dialog.CommentReportDialog.a
                public void a(String str) {
                    this.f4006a.a(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void a(String str) {
            CommunityPostDetailActivity.this.b(CommunityPostDetailActivity.this.A.getBigId(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(View view) {
        PlayMusicModel playMusicModel = new PlayMusicModel();
        playMusicModel.setVideoId(this.A.getVideoId());
        playMusicModel.setDuration(this.A.getVideoDuration());
        playMusicModel.setCoverImg(this.A.getVideoImgUrl());
        playMusicModel.setArtists(this.A.getVideoArtists());
        playMusicModel.setTitle(this.A.getVideoTitle());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(playMusicModel);
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2404);
        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, arrayList, 0));
    }

    private void x() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.j

            /* renamed from: a  reason: collision with root package name */
            private final CommunityPostDetailActivity f4001a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4001a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4001a.v();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void v() {
        this.D.setVisibility(8);
        this.S = true;
        this.P = 0;
        this.R = 0L;
        j();
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.D.setVisibility(8);
        this.S = true;
        this.P = 0;
        this.R = 0L;
        C();
        this.refreshLayout.setRefreshing(true);
    }

    private void z() {
        this.recycle_view.setLayoutManager(new LinearLayoutManager(this));
        this.E = new YoutubeCommentAdapter(this, null);
        this.recycle_view.setIAdapter(this.E);
        this.recycle_view.setOnLoadMoreListener(this.I);
        this.D = (LoadMoreFooterView) this.recycle_view.getLoadMoreFooterView();
        this.D.setVisibility(8);
        View inflate = LayoutInflater.from(this).inflate(R.layout.view_post_detail_header, (ViewGroup) null);
        this.F = (LaToTextView) inflate.findViewById(R.id.type_hot);
        this.G = (LaToTextView) inflate.findViewById(R.id.type_new);
        this.f3232c = (RoundedImageView) inflate.findViewById(R.id.iv_user_avatar);
        this.d = (LaToTextView) inflate.findViewById(R.id.tv_user_name);
        this.e = (LaToTextView) inflate.findViewById(R.id.tv_post_time);
        this.f = (LaToTextView) inflate.findViewById(R.id.tv_post_content);
        this.g = (RecyclerView) inflate.findViewById(R.id.rv_post_image);
        this.h = (ImageView) inflate.findViewById(R.id.iv_post_video_cover);
        this.i = (LaToTextView) inflate.findViewById(R.id.tv_post_video_time);
        this.j = (LaToTextView) inflate.findViewById(R.id.tv_post_video_title);
        this.k = (LaToTextView) inflate.findViewById(R.id.tv_post_video_artists);
        this.l = (RelativeLayout) inflate.findViewById(R.id.ll_post_video);
        this.m = inflate.findViewById(R.id.gap_view);
        this.n = (TextView) inflate.findViewById(R.id.tv_post_like_count);
        this.o = (TextView) inflate.findViewById(R.id.tv_post_comment_count);
        this.p = (LinearLayout) inflate.findViewById(R.id.ll_post_like);
        this.q = (LottieAnimationView) inflate.findViewById(R.id.lav_like_anim);
        this.r = (LinearLayout) inflate.findViewById(R.id.ll_post_comment);
        this.s = (LinearLayout) inflate.findViewById(R.id.ll_post_delete_report);
        this.t = (ImageView) inflate.findViewById(R.id.iv_post_like);
        this.u = (ImageView) inflate.findViewById(R.id.iv_delete_report);
        this.v = (TextView) inflate.findViewById(R.id.tv_delete_report);
        this.H = (ImageView) inflate.findViewById(R.id.iv_vip_mark_icon);
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommunityPostDetailActivity.this.A != null && !CommunityPostDetailActivity.this.A.isLike()) {
                    CommunityPostDetailActivity.this.B();
                }
            }
        });
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.fotoable.youtube.music.util.g.a(CommunityPostDetailActivity.this.comment_content_et);
                CommunityPostDetailActivity.this.comment_content_et.requestFocus();
            }
        });
        this.f3230a = (LaToTextView) inflate.findViewById(R.id.no_data_view);
        this.f3231b = (RelativeLayout) inflate.findViewById(R.id.comment_list_title);
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!CommunityPostDetailActivity.this.refreshLayout.isRefreshing()) {
                    CommunityPostDetailActivity.this.F.setTextColor(CommunityPostDetailActivity.this.getResources().getColor(R.color.color_4a4a4a));
                    CommunityPostDetailActivity.this.G.setTextColor(CommunityPostDetailActivity.this.getResources().getColor(R.color.color_c8c7cc));
                    CommunityPostDetailActivity.this.C = 1;
                    CommunityPostDetailActivity.this.y();
                }
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!CommunityPostDetailActivity.this.refreshLayout.isRefreshing()) {
                    CommunityPostDetailActivity.this.F.setTextColor(CommunityPostDetailActivity.this.getResources().getColor(R.color.color_c8c7cc));
                    CommunityPostDetailActivity.this.G.setTextColor(CommunityPostDetailActivity.this.getResources().getColor(R.color.color_4a4a4a));
                    CommunityPostDetailActivity.this.C = 0;
                    CommunityPostDetailActivity.this.y();
                }
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.recycle_view.addHeaderView(inflate);
        this.E.setOnClickCommentListener(new AnonymousClass21());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity$21  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass21 implements YoutubeCommentAdapter.OnClickCommentListener {
        AnonymousClass21() {
        }

        @Override // com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter.OnClickCommentListener
        public void onClickComment(int i, final String str, final String str2, final String str3, final String str4, final UserInfoModel userInfoModel, final String str5) {
            final boolean equals = TextUtils.equals(MusicApplication.c().h().getUid(), str2);
            CommentSelectDialog.a(CommunityPostDetailActivity.this.getSupportFragmentManager(), equals, new CommentSelectDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.21.1
                @Override // com.fotoable.youtube.music.ui.dialog.CommentSelectDialog.a
                public void a() {
                    CommunityPostDetailActivity.this.K = 1;
                    CommunityPostDetailActivity.this.L = str;
                    CommunityPostDetailActivity.this.M = str2;
                    CommunityPostDetailActivity.this.O = userInfoModel;
                    CommunityPostDetailActivity.this.N = str5;
                    String str6 = str3;
                    if (equals) {
                        str6 = MusicApplication.c().h().getName();
                    }
                    CommunityPostDetailActivity.this.comment_content_et_hint.setText(CommunityPostDetailActivity.this.getString(R.string.reply) + "" + str6 + ":");
                    CommunityPostDetailActivity.this.comment_content_et.requestFocus();
                    com.fotoable.youtube.music.util.g.a(CommunityPostDetailActivity.this.comment_content_et);
                }

                @Override // com.fotoable.youtube.music.ui.dialog.CommentSelectDialog.a
                public void b() {
                    CommunityPostDetailActivity.this.z.setPrimaryClip(ClipData.newPlainText("Label", "" + str4));
                    Toast.makeText(CommunityPostDetailActivity.this, (int) R.string.copy_tip_success, 0).show();
                }

                @Override // com.fotoable.youtube.music.ui.dialog.CommentSelectDialog.a
                public void c() {
                    CommentReportDialog.a(CommunityPostDetailActivity.this.getSupportFragmentManager(), new CommentReportDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.21.1.1
                        @Override // com.fotoable.youtube.music.ui.dialog.CommentReportDialog.a
                        public void a(String str6) {
                            CommunityPostDetailActivity.this.a(str, str6);
                        }
                    });
                }

                @Override // com.fotoable.youtube.music.ui.dialog.CommentSelectDialog.a
                public void d() {
                    CommunityPostDetailActivity.this.b(str);
                }
            });
        }

        @Override // com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter.OnClickCommentListener
        public void onClickLike(String str) {
            CommunityPostDetailActivity.this.a(str);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a() {
    }

    private void A() {
        this.comment_content_et.addTextChangedListener(new TextWatcher() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i3 != 0) {
                    CommunityPostDetailActivity.this.comment_content_et_hint_panel.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    CommunityPostDetailActivity.this.comment_content_et_hint_panel.setVisibility(0);
                }
            }
        });
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void c() {
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2404);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.back_view, R.id.send_comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            case R.id.send_comment /* 2131820954 */:
                String trim = this.comment_content_et.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    Toast.makeText(this, (int) R.string.commit_empty_content_warn, 0).show();
                    return;
                }
                c(trim);
                com.fotoable.youtube.music.util.g.b(this.comment_content_et);
                this.comment_content_et_hint.setText(getString(R.string.write_comment));
                this.comment_content_et.setText("");
                if (this.K == 0) {
                    com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-发布评论次数", "评论类型", "新评论");
                } else {
                    com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-发布评论次数", "评论类型", "回复他人评论");
                }
                this.K = 0;
                this.L = "";
                this.M = "";
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (!this.w.h(this.A.getBigId())) {
            this.w.i(this.A.getBigId());
            this.n.setText((this.A.getCounter().getData().getComments_like_count() + 1) + "");
            this.A.setLike(true);
            this.n.setTextColor(getResources().getColor(R.color.color_ff2d55));
            this.t.setVisibility(8);
            a("post_like.json", this.q);
            a(this.x.e(this.A.getBigId()).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<PostBean>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.4
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    if (CommunityPostDetailActivity.this.w != null && CommunityPostDetailActivity.this.A != null) {
                        CommunityPostDetailActivity.this.w.j(CommunityPostDetailActivity.this.A.getBigId());
                    }
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<PostBean> myHttpResponse) {
                }
            }));
        }
    }

    private void a(String str, final LottieAnimationView lottieAnimationView) {
        aw.a.a(this, str, new com.airbnb.lottie.bf() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.5
            @Override // com.airbnb.lottie.bf
            public void onCompositionLoaded(com.airbnb.lottie.aw awVar) {
                if (lottieAnimationView != null) {
                    lottieAnimationView.setComposition(awVar);
                    lottieAnimationView.c();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        if (!this.w.h(str)) {
            this.w.i(str);
            if (this.E != null) {
            }
            a(this.x.c(str, this.A.getBigId()).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<YoutubeComment>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.6
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    CommunityPostDetailActivity.this.w.j(str);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<YoutubeComment> myHttpResponse) {
                    if (myHttpResponse == null || myHttpResponse.isSuccess()) {
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, String str2) {
        a(this.x.b(str, str2).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<YoutubeComment>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.7
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<YoutubeComment> myHttpResponse) {
                if (myHttpResponse != null && myHttpResponse.isSuccess()) {
                    Toast.makeText(CommunityPostDetailActivity.this, (int) R.string.successfully_reported, 0).show();
                    if (CommunityPostDetailActivity.this.E != null) {
                        CommunityPostDetailActivity.this.E.reportComment(str);
                    }
                }
            }
        }));
        com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-举报评论次数");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        this.J = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), (int) R.string.deleting, k.f4002a);
        a(this.x.d(str).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<YoutubeComment>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.8
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                if (CommunityPostDetailActivity.this.J != null) {
                    CommunityPostDetailActivity.this.J.dismiss();
                    CommunityPostDetailActivity.this.J = null;
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<YoutubeComment> myHttpResponse) {
                if (myHttpResponse != null && myHttpResponse.isSuccess() && CommunityPostDetailActivity.this.E != null) {
                    CommunityPostDetailActivity.this.E.deleteComment(str);
                }
                if (CommunityPostDetailActivity.this.J != null) {
                    CommunityPostDetailActivity.this.J.dismiss();
                    CommunityPostDetailActivity.this.J = null;
                }
            }
        }));
        com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-删除评论次数");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void u() {
    }

    private void c(String str) {
        this.J = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), (int) R.string.sending, l.f4003a);
        final YoutubeComment youtubeComment = new YoutubeComment();
        youtubeComment.setCid("" + System.currentTimeMillis());
        youtubeComment.setBidId(this.A.getBigId());
        youtubeComment.setCreatedAt(System.currentTimeMillis());
        CommentCounter commentCounter = new CommentCounter();
        commentCounter.setData(new CommentCounterDataModel());
        youtubeComment.setCounter(commentCounter);
        CommentUserInfo commentUserInfo = new CommentUserInfo();
        commentUserInfo.setData(MusicApplication.c().h());
        youtubeComment.setUserInfo(commentUserInfo);
        youtubeComment.setIsReplyComment(this.K);
        youtubeComment.setLike(false);
        if (this.K == 0) {
            youtubeComment.setBody(str);
        } else {
            youtubeComment.setBody(str);
            CommentUserInfo commentUserInfo2 = new CommentUserInfo();
            commentUserInfo2.setData(this.O);
            youtubeComment.setReUserInfo(commentUserInfo2);
            youtubeComment.setReBody(this.N);
        }
        if (this.E != null) {
            this.E.addComment(youtubeComment, this.C == 1);
        }
        if (this.f3230a.getVisibility() != 8) {
            this.f3231b.setVisibility(0);
            this.f3230a.setVisibility(8);
        }
        a(this.x.a(this.A.getBigId(), str, 1, this.K, this.L, this.M).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<YoutubeComment>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.9
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                if (CommunityPostDetailActivity.this.J != null) {
                    CommunityPostDetailActivity.this.J.dismiss();
                    CommunityPostDetailActivity.this.J = null;
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<YoutubeComment> myHttpResponse) {
                if (CommunityPostDetailActivity.this.J != null) {
                    CommunityPostDetailActivity.this.J.dismiss();
                    CommunityPostDetailActivity.this.J = null;
                }
                if (myHttpResponse != null && myHttpResponse.isSuccess()) {
                    if (myHttpResponse.getData() != null && CommunityPostDetailActivity.this.E != null) {
                        youtubeComment.setCid(myHttpResponse.getData().getCid());
                        CommunityPostDetailActivity.this.E.notifyDataSetChanged();
                    }
                    if (TextUtils.isEmpty(CommunityPostDetailActivity.this.L)) {
                        Toast.makeText(CommunityPostDetailActivity.this, (int) R.string.comment_added, 0).show();
                    } else {
                        Toast.makeText(CommunityPostDetailActivity.this, (int) R.string.reply_added, 0).show();
                    }
                }
            }
        }));
        com.fotoable.youtube.music.util.b.b("帖子界面-添加评论次数");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (!this.T && this.A != null) {
            this.T = true;
            com.fotoable.youtube.music.util.h.a(y, "id:" + this.A.getBigId() + ",skip:" + this.P + ",limit:" + this.Q + ",mixId:" + this.R + ",sort:" + this.C);
            a(this.x.a(this.A.getBigId(), this.P, this.Q, this.R, this.C).a(new rx.c.b<MyHttpResponse<List<YoutubeComment>>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.11
                @Override // rx.c.b
                /* renamed from: a */
                public void call(MyHttpResponse<List<YoutubeComment>> myHttpResponse) {
                    YoutubeComment youtubeComment;
                    if (myHttpResponse != null && myHttpResponse.isSuccess() && myHttpResponse.getData() != null && myHttpResponse.getData().size() > 0) {
                        HashMap hashMap = new HashMap();
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < myHttpResponse.getData().size(); i++) {
                            YoutubeComment youtubeComment2 = myHttpResponse.getData().get(i);
                            if (youtubeComment2 != null) {
                                hashMap.put(youtubeComment2.getCid(), youtubeComment2);
                                arrayList.add(youtubeComment2.getCid());
                            }
                        }
                        List<YoutubeCommentLocalLikeModel> e = CommunityPostDetailActivity.this.w.e(arrayList);
                        if (e != null) {
                            for (int i2 = 0; i2 < e.size(); i2++) {
                                YoutubeCommentLocalLikeModel youtubeCommentLocalLikeModel = e.get(i2);
                                if (youtubeCommentLocalLikeModel != null && (youtubeComment = (YoutubeComment) hashMap.get(youtubeCommentLocalLikeModel.getCid())) != null) {
                                    youtubeComment.setLike(true);
                                }
                            }
                            e.clear();
                            hashMap.clear();
                        }
                        arrayList.clear();
                    }
                }
            }).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<List<YoutubeComment>>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.10
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    if (!CommunityPostDetailActivity.this.p()) {
                        CommunityPostDetailActivity.this.T = false;
                        CommunityPostDetailActivity.this.refreshLayout.setRefreshing(false);
                        CommunityPostDetailActivity.this.D.setVisibility(8);
                        CommunityPostDetailActivity.this.D.setStatus(LoadMoreFooterView.Status.THE_END);
                    }
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<List<YoutubeComment>> myHttpResponse) {
                    if (!CommunityPostDetailActivity.this.p()) {
                        CommunityPostDetailActivity.this.T = false;
                        CommunityPostDetailActivity.this.refreshLayout.setRefreshing(false);
                        if (myHttpResponse == null) {
                            if (CommunityPostDetailActivity.this.E.getItemCount() != 0) {
                                CommunityPostDetailActivity.this.D.setVisibility(0);
                                CommunityPostDetailActivity.this.D.setStatus(LoadMoreFooterView.Status.THE_END);
                                return;
                            }
                            CommunityPostDetailActivity.this.f3230a.setVisibility(0);
                            CommunityPostDetailActivity.this.f3231b.setVisibility(8);
                            return;
                        }
                        if (myHttpResponse.getData() == null) {
                            CommunityPostDetailActivity.this.S = false;
                            if (CommunityPostDetailActivity.this.E.getItemCount() != 0) {
                                CommunityPostDetailActivity.this.D.setVisibility(0);
                                CommunityPostDetailActivity.this.D.setStatus(LoadMoreFooterView.Status.THE_END);
                            } else {
                                CommunityPostDetailActivity.this.f3230a.setVisibility(0);
                                CommunityPostDetailActivity.this.f3231b.setVisibility(8);
                            }
                        } else {
                            if (myHttpResponse.getData().size() > 0) {
                                CommunityPostDetailActivity.this.S = true;
                            } else {
                                CommunityPostDetailActivity.this.S = false;
                            }
                            if (CommunityPostDetailActivity.this.P == 0 && myHttpResponse.getData().size() > 0 && CommunityPostDetailActivity.this.f3231b.getVisibility() != 0) {
                                CommunityPostDetailActivity.this.f3231b.setVisibility(0);
                                CommunityPostDetailActivity.this.f3230a.setVisibility(8);
                            }
                            if (CommunityPostDetailActivity.this.P == 0 && myHttpResponse.getData().size() == 0 && CommunityPostDetailActivity.this.f3230a.getVisibility() != 0) {
                                CommunityPostDetailActivity.this.f3230a.setVisibility(0);
                                CommunityPostDetailActivity.this.f3231b.setVisibility(8);
                            }
                            if (!CommunityPostDetailActivity.this.S && CommunityPostDetailActivity.this.E.getItemCount() != 0) {
                                CommunityPostDetailActivity.this.D.setVisibility(0);
                                CommunityPostDetailActivity.this.D.setStatus(LoadMoreFooterView.Status.THE_END);
                            }
                            if (CommunityPostDetailActivity.this.P == 0) {
                                CommunityPostDetailActivity.this.E.setYoutubeCommentList(myHttpResponse.getData());
                            } else {
                                CommunityPostDetailActivity.this.E.addYoutubeCommentList(myHttpResponse.getData());
                            }
                            CommunityPostDetailActivity.this.P = myHttpResponse.getData().size() + CommunityPostDetailActivity.this.P;
                        }
                        CommunityPostDetailActivity.this.R = myHttpResponse.getMeta().getMixid();
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        this.J = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), (int) R.string.deleting, m.f4004a);
        a(this.x.f(str).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<PostBean>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.13
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                if (CommunityPostDetailActivity.this.J != null) {
                    CommunityPostDetailActivity.this.J.dismiss();
                    CommunityPostDetailActivity.this.J = null;
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<PostBean> myHttpResponse) {
                if (myHttpResponse != null && myHttpResponse.isSuccess()) {
                    Toast.makeText(CommunityPostDetailActivity.this, (int) R.string.delete_success, 0).show();
                    Intent intent = new Intent();
                    intent.putExtra("bigId", str);
                    CommunityPostDetailActivity.this.setResult(-1, intent);
                    CommunityPostDetailActivity.this.finish();
                }
                if (CommunityPostDetailActivity.this.J != null) {
                    CommunityPostDetailActivity.this.J.dismiss();
                    CommunityPostDetailActivity.this.J = null;
                }
            }
        }));
        com.fotoable.youtube.music.util.b.b("帖子界面-删除帖子次数");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        this.J = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), (int) R.string.report, n.f4005a);
        a(this.x.d(str, str2).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<PostBean>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity.14
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                if (CommunityPostDetailActivity.this.J != null) {
                    CommunityPostDetailActivity.this.J.dismiss();
                    CommunityPostDetailActivity.this.J = null;
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<PostBean> myHttpResponse) {
                if (myHttpResponse != null && myHttpResponse.isSuccess()) {
                    Toast.makeText(CommunityPostDetailActivity.this, (int) R.string.successfully_reported, 0).show();
                }
                if (CommunityPostDetailActivity.this.J != null) {
                    CommunityPostDetailActivity.this.J.dismiss();
                    CommunityPostDetailActivity.this.J = null;
                }
            }
        }));
        com.fotoable.youtube.music.util.b.b("帖子界面-举报评论次数");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void r() {
    }
}
