package com.fotoable.youtube.music.ui.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
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
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.facebook.ads.AdError;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.CommentCounter;
import com.fotoable.youtube.music.bean.CommentCounterDataModel;
import com.fotoable.youtube.music.bean.CommentUserInfo;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.bean.UserInfoModel;
import com.fotoable.youtube.music.bean.YoutubeComment;
import com.fotoable.youtube.music.bean.YoutubeCommentLocalLikeModel;
import com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter;
import com.fotoable.youtube.music.ui.dialog.CommentReportDialog;
import com.fotoable.youtube.music.ui.dialog.CommentSelectDialog;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class YoutubeCommentActivity extends BaseActivity {
    private static final String h = YoutubeCommentActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    ImageView f3876a;

    /* renamed from: b  reason: collision with root package name */
    TextView f3877b;

    /* renamed from: c  reason: collision with root package name */
    TextView f3878c;
    @BindView(R.id.comment_content_et)
    EditText comment_content_et;
    @BindView(R.id.comment_content_et_hint)
    TextView comment_content_et_hint;
    @BindView(R.id.comment_content_et_hint_panel)
    LinearLayout comment_content_et_hint_panel;
    TextView d;
    RelativeLayout e;
    @Inject
    com.fotoable.youtube.music.db.a f;
    @Inject
    com.fotoable.youtube.music.b.c g;
    private String i;
    private PlayMusicModel j;
    private List<PlayMusicModel> k;
    private ClipboardManager l;
    private int m;
    private int n;
    private LoadMoreFooterView p;
    private YoutubeCommentAdapter q;
    private TextView r;
    @BindView(R.id.recycle_view)
    IRecyclerView recycle_view;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    private TextView s;
    @BindView(R.id.send_comment)
    TextView send_comment;
    private com.fotoable.youtube.music.ui.dialog.n u;
    private String w;
    private String x;
    private String y;
    private UserInfoModel z;
    private int o = 1;
    private OnLoadMoreListener t = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.8
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (!YoutubeCommentActivity.this.E && YoutubeCommentActivity.this.A != 0 && YoutubeCommentActivity.this.q.getItemCount() != 0) {
                if (YoutubeCommentActivity.this.D) {
                    YoutubeCommentActivity.this.p.setVisibility(0);
                    YoutubeCommentActivity.this.p.setStatus(LoadMoreFooterView.Status.LOADING);
                    YoutubeCommentActivity.this.y();
                    return;
                }
                YoutubeCommentActivity.this.p.setVisibility(0);
                YoutubeCommentActivity.this.p.setStatus(LoadMoreFooterView.Status.THE_END);
            }
        }
    };
    private int v = 0;
    private int A = 0;
    private int B = 20;
    private long C = 0;
    private boolean D = true;
    private boolean E = false;

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
        d();
        this.i = getIntent().getStringExtra("VideoId");
        this.m = getIntent().getIntExtra(ShareConstants.FEED_SOURCE_PARAM, 1);
        this.n = getIntent().getIntExtra("position", 0);
        this.j = (PlayMusicModel) getIntent().getParcelableExtra("model");
        if (getIntent().hasExtra("modelList")) {
            this.k = getIntent().getParcelableArrayListExtra("modelList");
        }
        this.refreshLayout.setProgressViewEndTarget(false, (int) (140.0f * getResources().getDisplayMetrics().density));
        x();
        u();
        w();
        if (!TextUtils.isEmpty(this.i)) {
            y();
        }
        this.l = (ClipboardManager) getSystemService("clipboard");
        com.fotoable.youtube.music.util.b.b("在线音乐-评论界面展示次数");
    }

    private void u() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.bn

            /* renamed from: a  reason: collision with root package name */
            private final YoutubeCommentActivity f3985a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3985a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f3985a.t();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void t() {
        this.p.setVisibility(8);
        this.D = true;
        this.A = 0;
        this.C = 0L;
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.p.setVisibility(8);
        this.D = true;
        this.A = 0;
        this.C = 0L;
        y();
        this.refreshLayout.setRefreshing(true);
    }

    private void w() {
        this.recycle_view.setLayoutManager(new LinearLayoutManager(this));
        this.q = new YoutubeCommentAdapter(this, null);
        this.recycle_view.setIAdapter(this.q);
        this.recycle_view.setOnLoadMoreListener(this.t);
        this.p = (LoadMoreFooterView) this.recycle_view.getLoadMoreFooterView();
        this.p.setVisibility(8);
        View inflate = LayoutInflater.from(this).inflate(R.layout.view_comment_list_header, (ViewGroup) null);
        this.f3876a = (ImageView) inflate.findViewById(R.id.music_cover);
        this.r = (LaToTextView) inflate.findViewById(R.id.type_hot);
        this.s = (LaToTextView) inflate.findViewById(R.id.type_new);
        this.f3877b = (LaToTextView) inflate.findViewById(R.id.music_title);
        this.f3878c = (LaToTextView) inflate.findViewById(R.id.artists_name);
        this.d = (LaToTextView) inflate.findViewById(R.id.no_data_view);
        this.e = (RelativeLayout) inflate.findViewById(R.id.comment_list_title);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!YoutubeCommentActivity.this.refreshLayout.isRefreshing()) {
                    YoutubeCommentActivity.this.r.setTextColor(YoutubeCommentActivity.this.getResources().getColor(R.color.color_4a4a4a));
                    YoutubeCommentActivity.this.s.setTextColor(YoutubeCommentActivity.this.getResources().getColor(R.color.color_c8c7cc));
                    YoutubeCommentActivity.this.o = 1;
                    YoutubeCommentActivity.this.v();
                }
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!YoutubeCommentActivity.this.refreshLayout.isRefreshing()) {
                    YoutubeCommentActivity.this.r.setTextColor(YoutubeCommentActivity.this.getResources().getColor(R.color.color_c8c7cc));
                    YoutubeCommentActivity.this.s.setTextColor(YoutubeCommentActivity.this.getResources().getColor(R.color.color_4a4a4a));
                    YoutubeCommentActivity.this.o = 0;
                    YoutubeCommentActivity.this.v();
                }
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (YoutubeCommentActivity.this.m != 1) {
                    if (YoutubeCommentActivity.this.m == 2) {
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, YoutubeCommentActivity.this.k, YoutubeCommentActivity.this.n));
                        YoutubeCommentActivity.this.startActivity(new Intent(YoutubeCommentActivity.this, PlayerActivity.class));
                    }
                } else {
                    YoutubeCommentActivity.this.finish();
                }
                com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-点击播放音乐次数");
            }
        });
        if (this.j != null) {
            com.fotoable.youtube.music.util.h.a(h, "playMusicModel:" + this.j.toString());
            com.bumptech.glide.i.a((FragmentActivity) this).a(this.j.getCoverImg()).b(com.bumptech.glide.load.b.b.ALL).c((int) R.mipmap.pic_recently).a(this.f3876a);
            this.f3877b.setText(this.j.getTitle() + "");
            if (!TextUtils.isEmpty(this.j.getArtists())) {
                this.f3878c.setText(this.j.getArtists() + "");
            } else {
                this.f3878c.setVisibility(8);
            }
        } else {
            com.fotoable.youtube.music.util.h.a(h, "playMusicModel is null");
        }
        this.recycle_view.addHeaderView(inflate);
        this.q.setOnClickCommentListener(new AnonymousClass7());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity$7  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass7 implements YoutubeCommentAdapter.OnClickCommentListener {
        AnonymousClass7() {
        }

        @Override // com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter.OnClickCommentListener
        public void onClickComment(int i, final String str, final String str2, final String str3, final String str4, final UserInfoModel userInfoModel, final String str5) {
            final boolean equals = TextUtils.equals(MusicApplication.c().h().getUid(), str2);
            CommentSelectDialog.a(YoutubeCommentActivity.this.getSupportFragmentManager(), equals, new CommentSelectDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.7.1
                @Override // com.fotoable.youtube.music.ui.dialog.CommentSelectDialog.a
                public void a() {
                    YoutubeCommentActivity.this.v = 1;
                    YoutubeCommentActivity.this.w = str;
                    YoutubeCommentActivity.this.x = str2;
                    YoutubeCommentActivity.this.z = userInfoModel;
                    YoutubeCommentActivity.this.y = str5;
                    String str6 = str3;
                    if (equals) {
                        str6 = MusicApplication.c().h().getName();
                    }
                    YoutubeCommentActivity.this.comment_content_et_hint.setText(YoutubeCommentActivity.this.getString(R.string.reply) + "" + str6 + ":");
                    YoutubeCommentActivity.this.comment_content_et.requestFocus();
                    com.fotoable.youtube.music.util.g.a(YoutubeCommentActivity.this.comment_content_et);
                }

                @Override // com.fotoable.youtube.music.ui.dialog.CommentSelectDialog.a
                public void b() {
                    YoutubeCommentActivity.this.l.setPrimaryClip(ClipData.newPlainText("Label", "" + str4));
                    Toast.makeText(YoutubeCommentActivity.this, (int) R.string.copy_tip_success, 0).show();
                }

                @Override // com.fotoable.youtube.music.ui.dialog.CommentSelectDialog.a
                public void c() {
                    CommentReportDialog.a(YoutubeCommentActivity.this.getSupportFragmentManager(), new CommentReportDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.7.1.1
                        @Override // com.fotoable.youtube.music.ui.dialog.CommentReportDialog.a
                        public void a(String str6) {
                            YoutubeCommentActivity.this.a(str, str6);
                        }
                    });
                }

                @Override // com.fotoable.youtube.music.ui.dialog.CommentSelectDialog.a
                public void d() {
                    YoutubeCommentActivity.this.b(str);
                }
            });
        }

        @Override // com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter.OnClickCommentListener
        public void onClickLike(String str) {
            YoutubeCommentActivity.this.a(str);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a() {
    }

    private void x() {
        this.comment_content_et.addTextChangedListener(new TextWatcher() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i3 != 0) {
                    YoutubeCommentActivity.this.comment_content_et_hint_panel.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    YoutubeCommentActivity.this.comment_content_et_hint_panel.setVisibility(0);
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
                if (this.v == 0) {
                    com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-发布评论次数", "评论类型", "新评论");
                } else {
                    com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-发布评论次数", "评论类型", "回复他人评论");
                }
                this.v = 0;
                this.w = "";
                this.x = "";
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        if (!this.f.h(str)) {
            this.f.i(str);
            if (this.q != null) {
                this.q.likeComment(str);
            }
            a(this.g.c(str, this.i).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<YoutubeComment>>() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.10
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    YoutubeCommentActivity.this.f.j(str);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<YoutubeComment> myHttpResponse) {
                    if (myHttpResponse == null || myHttpResponse.isSuccess()) {
                    }
                }
            }));
            com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-点赞评论次数");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, String str2) {
        a(this.g.b(str, str2).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<YoutubeComment>>() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.11
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
                    Toast.makeText(YoutubeCommentActivity.this, (int) R.string.successfully_reported, 0).show();
                    if (YoutubeCommentActivity.this.q != null) {
                        YoutubeCommentActivity.this.q.reportComment(str);
                    }
                }
            }
        }));
        com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-举报评论次数");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        this.u = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), (int) R.string.deleting, bo.f3986a);
        a(this.g.d(str).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<YoutubeComment>>() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.12
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                if (YoutubeCommentActivity.this.u != null) {
                    YoutubeCommentActivity.this.u.dismiss();
                    YoutubeCommentActivity.this.u = null;
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<YoutubeComment> myHttpResponse) {
                if (myHttpResponse != null && myHttpResponse.isSuccess() && YoutubeCommentActivity.this.q != null) {
                    YoutubeCommentActivity.this.q.deleteComment(str);
                }
                if (YoutubeCommentActivity.this.u != null) {
                    YoutubeCommentActivity.this.u.dismiss();
                    YoutubeCommentActivity.this.u = null;
                }
            }
        }));
        com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-删除评论次数");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void s() {
    }

    private void c(String str) {
        this.u = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), (int) R.string.sending, bp.f3987a);
        YoutubeComment youtubeComment = new YoutubeComment();
        youtubeComment.setCid("" + System.currentTimeMillis());
        youtubeComment.setBidId(this.i);
        youtubeComment.setCreatedAt(System.currentTimeMillis());
        CommentCounter commentCounter = new CommentCounter();
        commentCounter.setData(new CommentCounterDataModel());
        youtubeComment.setCounter(commentCounter);
        CommentUserInfo commentUserInfo = new CommentUserInfo();
        commentUserInfo.setData(MusicApplication.c().h());
        youtubeComment.setUserInfo(commentUserInfo);
        youtubeComment.setIsReplyComment(this.v);
        if (this.v == 0) {
            youtubeComment.setBody(str);
        } else {
            youtubeComment.setBody(str);
            CommentUserInfo commentUserInfo2 = new CommentUserInfo();
            commentUserInfo2.setData(this.z);
            youtubeComment.setReUserInfo(commentUserInfo2);
            youtubeComment.setReBody(this.y);
        }
        if (this.q != null) {
            this.q.addComment(youtubeComment, this.o == 1);
        }
        if (this.d.getVisibility() != 8) {
            this.e.setVisibility(0);
            this.d.setVisibility(8);
        }
        a(this.g.a(this.i, str, 2, this.v, this.w, this.x).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<YoutubeComment>>() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.2
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                if (YoutubeCommentActivity.this.u != null) {
                    YoutubeCommentActivity.this.u.dismiss();
                    YoutubeCommentActivity.this.u = null;
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<YoutubeComment> myHttpResponse) {
                if (YoutubeCommentActivity.this.u != null) {
                    YoutubeCommentActivity.this.u.dismiss();
                    YoutubeCommentActivity.this.u = null;
                }
                if (myHttpResponse != null && myHttpResponse.isSuccess()) {
                    if (TextUtils.isEmpty(YoutubeCommentActivity.this.w)) {
                        Toast.makeText(YoutubeCommentActivity.this, (int) R.string.comment_added, 0).show();
                    } else {
                        Toast.makeText(YoutubeCommentActivity.this, (int) R.string.reply_added, 0).show();
                    }
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (!this.E) {
            this.E = true;
            a(this.g.a(this.i, this.A, this.B, this.C, this.o).a(new rx.c.b<MyHttpResponse<List<YoutubeComment>>>() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.4
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
                        List<YoutubeCommentLocalLikeModel> e = YoutubeCommentActivity.this.f.e(arrayList);
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
            }).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<List<YoutubeComment>>>() { // from class: com.fotoable.youtube.music.ui.activity.YoutubeCommentActivity.3
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    if (!YoutubeCommentActivity.this.p()) {
                        YoutubeCommentActivity.this.E = false;
                        YoutubeCommentActivity.this.refreshLayout.setRefreshing(false);
                        YoutubeCommentActivity.this.p.setVisibility(8);
                        YoutubeCommentActivity.this.p.setStatus(LoadMoreFooterView.Status.THE_END);
                    }
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<List<YoutubeComment>> myHttpResponse) {
                    if (!YoutubeCommentActivity.this.p()) {
                        YoutubeCommentActivity.this.E = false;
                        YoutubeCommentActivity.this.refreshLayout.setRefreshing(false);
                        if (myHttpResponse == null) {
                            if (YoutubeCommentActivity.this.q.getItemCount() != 0) {
                                YoutubeCommentActivity.this.p.setVisibility(0);
                                YoutubeCommentActivity.this.p.setStatus(LoadMoreFooterView.Status.THE_END);
                                return;
                            }
                            YoutubeCommentActivity.this.d.setVisibility(0);
                            YoutubeCommentActivity.this.e.setVisibility(8);
                            return;
                        }
                        if (myHttpResponse.getData() == null) {
                            YoutubeCommentActivity.this.D = false;
                            if (YoutubeCommentActivity.this.q.getItemCount() != 0) {
                                YoutubeCommentActivity.this.p.setVisibility(0);
                                YoutubeCommentActivity.this.p.setStatus(LoadMoreFooterView.Status.THE_END);
                            } else {
                                YoutubeCommentActivity.this.d.setVisibility(0);
                                YoutubeCommentActivity.this.e.setVisibility(8);
                            }
                        } else {
                            if (myHttpResponse.getData().size() > 0) {
                                YoutubeCommentActivity.this.D = true;
                            } else {
                                YoutubeCommentActivity.this.D = false;
                            }
                            if (YoutubeCommentActivity.this.A == 0 && myHttpResponse.getData().size() > 0 && YoutubeCommentActivity.this.e.getVisibility() != 0) {
                                YoutubeCommentActivity.this.e.setVisibility(0);
                                YoutubeCommentActivity.this.d.setVisibility(8);
                            }
                            if (YoutubeCommentActivity.this.A == 0 && myHttpResponse.getData().size() == 0 && YoutubeCommentActivity.this.d.getVisibility() != 0) {
                                YoutubeCommentActivity.this.d.setVisibility(0);
                                YoutubeCommentActivity.this.e.setVisibility(8);
                            }
                            if (!YoutubeCommentActivity.this.D && YoutubeCommentActivity.this.q.getItemCount() != 0) {
                                YoutubeCommentActivity.this.p.setVisibility(0);
                                YoutubeCommentActivity.this.p.setStatus(LoadMoreFooterView.Status.THE_END);
                            }
                            if (YoutubeCommentActivity.this.A == 0) {
                                YoutubeCommentActivity.this.q.setYoutubeCommentList(myHttpResponse.getData());
                            } else {
                                YoutubeCommentActivity.this.q.addYoutubeCommentList(myHttpResponse.getData());
                            }
                            YoutubeCommentActivity.this.A = myHttpResponse.getData().size() + YoutubeCommentActivity.this.A;
                        }
                        YoutubeCommentActivity.this.C = myHttpResponse.getMeta().getMixid();
                    }
                }
            }));
        }
    }
}
