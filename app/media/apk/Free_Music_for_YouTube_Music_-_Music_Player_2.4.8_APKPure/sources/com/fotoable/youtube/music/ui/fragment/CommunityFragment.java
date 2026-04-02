package com.fotoable.youtube.music.ui.fragment;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PostBean;
import com.fotoable.youtube.music.d.a.d;
import com.fotoable.youtube.music.ui.activity.CommunityPostActivity;
import com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity;
import com.fotoable.youtube.music.ui.adapter.CommunityAdapter;
import com.fotoable.youtube.music.ui.dialog.CommentReportDialog;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.dialog.g;
import com.fotoable.youtube.music.ui.fragment.CommunityFragment;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class CommunityFragment extends com.fotoable.youtube.music.base.i implements d.a {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.d.l f4506b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f4507c;
    @Inject
    com.fotoable.youtube.music.b.c d;
    private LoadMoreFooterView e;
    private CommunityAdapter f;
    private LinearLayout g;
    private OnLoadMoreListener h = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment.4
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            com.fotoable.youtube.music.util.h.a("CommunityFragment", "内容高度：" + CommunityFragment.this.mRvPostList.computeVerticalScrollExtent() + "   " + CommunityFragment.this.mRvPostList.computeVerticalScrollRange());
            com.fotoable.youtube.music.util.h.a("CommunityFragment", "内容高度2：" + CommunityFragment.this.mRvPostList.getHeight());
            if (CommunityFragment.this.mRvPostList.computeVerticalScrollExtent() >= CommunityFragment.this.mRvPostList.getHeight()) {
                if (!CommunityFragment.this.f4506b.e()) {
                    CommunityFragment.this.e.setStatus(LoadMoreFooterView.Status.THE_END);
                } else {
                    CommunityFragment.this.f4506b.c();
                    CommunityFragment.this.e.setStatus(LoadMoreFooterView.Status.LOADING);
                }
                com.fotoable.youtube.music.util.h.a("CommunityFragment", "上拉刷新...");
            }
        }
    };
    private com.fotoable.youtube.music.ui.dialog.n i;
    @BindView(R.id.iv_post_add)
    ImageView iv_post_add;
    @BindView(R.id.rv_post_list)
    IRecyclerView mRvPostList;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.rl_error_page)
    RelativeLayout rl_error_page;

    @Override // com.fotoable.youtube.music.base.i
    public int a() {
        return R.layout.fragment_community;
    }

    @Override // com.fotoable.youtube.music.base.i
    public void a(View view, @Nullable Bundle bundle) {
        com.fotoable.youtube.music.util.b.b("社区界面-展示");
        l();
        o();
    }

    @Override // com.fotoable.youtube.music.base.i
    public void g() {
        e().a(this);
        this.f4506b.a((d.a) this);
    }

    private void l() {
        this.mRvPostList.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mRvPostList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    CommunityFragment.this.m();
                } else if (i2 < 0) {
                    CommunityFragment.this.n();
                }
            }
        });
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_community_header, (ViewGroup) null);
        this.g = (LinearLayout) inflate.findViewById(R.id.ll_post_type);
        final LaToTextView laToTextView = (LaToTextView) inflate.findViewById(R.id.tv_post_type);
        this.mRvPostList.addHeaderView(inflate);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.fotoable.youtube.music.util.b.b("社区界面-切换帖子类型");
                com.fotoable.youtube.music.ui.dialog.g.a(CommunityFragment.this.getContext(), CommunityFragment.this.g, new g.a() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment.2.1
                    @Override // com.fotoable.youtube.music.ui.dialog.g.a
                    public void a(String str, int i) {
                        if (CommunityFragment.this.rl_error_page.getVisibility() != 8) {
                            CommunityFragment.this.rl_error_page.setVisibility(8);
                        }
                        laToTextView.setText(i);
                        if (CommunityFragment.this.f4506b != null) {
                            CommunityFragment.this.e.setVisibility(8);
                            CommunityFragment.this.f4506b.d();
                            CommunityFragment.this.refreshLayout.setRefreshing(true);
                            CommunityFragment.this.f4506b.a(str);
                            CommunityFragment.this.f4506b.c();
                        }
                    }
                });
                CommunityFragment.this.n();
            }
        });
        this.f = new CommunityAdapter(getContext());
        this.mRvPostList.setIAdapter(this.f);
        this.mRvPostList.setOnLoadMoreListener(this.h);
        this.e = (LoadMoreFooterView) this.mRvPostList.getLoadMoreFooterView();
        this.e.setVisibility(8);
        this.f.setOnItemClickListener(new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fotoable.youtube.music.ui.fragment.CommunityFragment$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements CommunityAdapter.OnItemClickListener {
        AnonymousClass3() {
        }

        @Override // com.fotoable.youtube.music.ui.adapter.CommunityAdapter.OnItemClickListener
        public void onLike(String str) {
            CommunityFragment.this.a(str);
        }

        @Override // com.fotoable.youtube.music.ui.adapter.CommunityAdapter.OnItemClickListener
        public void onComment(PostBean postBean) {
            Intent intent = new Intent(CommunityFragment.this.getContext(), CommunityPostDetailActivity.class);
            intent.putExtra("post", postBean);
            intent.putExtra("isShowInput", true);
            CommunityFragment.this.getActivity().startActivityForResult(intent, AdError.MEDIATION_ERROR_CODE);
        }

        @Override // com.fotoable.youtube.music.ui.adapter.CommunityAdapter.OnItemClickListener
        public void onDelete(String str) {
            CommunityFragment.this.c(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void a(String str, String str2) {
            CommunityFragment.this.a(str, str2);
        }

        @Override // com.fotoable.youtube.music.ui.adapter.CommunityAdapter.OnItemClickListener
        public void onReport(final String str) {
            CommentReportDialog.a(CommunityFragment.this.getFragmentManager(), new CommentReportDialog.a(this, str) { // from class: com.fotoable.youtube.music.ui.fragment.g

                /* renamed from: a  reason: collision with root package name */
                private final CommunityFragment.AnonymousClass3 f4822a;

                /* renamed from: b  reason: collision with root package name */
                private final String f4823b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4822a = this;
                    this.f4823b = str;
                }

                @Override // com.fotoable.youtube.music.ui.dialog.CommentReportDialog.a
                public void a(String str2) {
                    this.f4822a.a(this.f4823b, str2);
                }
            });
        }

        @Override // com.fotoable.youtube.music.ui.adapter.CommunityAdapter.OnItemClickListener
        public void onLongClick(final String str) {
            if (com.fotoable.youtube.music.util.a.a()) {
                SimpleMusicDialog.a(CommunityFragment.this.getFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment.3.1
                    @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                    public void a() {
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                    public void b() {
                    }

                    @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                    public void c() {
                        CommunityFragment.this.b(str);
                    }
                }, R.string.sure_delete, R.string.cancel, R.string.ok);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.iv_post_add.getTranslationY() <= 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iv_post_add, "translationY", 0.0f, 80.0f * getContext().getResources().getDisplayMetrics().density);
            ofFloat.setDuration(250L);
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.iv_post_add.getTranslationY() >= getContext().getResources().getDisplayMetrics().density * 80.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iv_post_add, "translationY", getContext().getResources().getDisplayMetrics().density * 80.0f, 0.0f);
            ofFloat.setDuration(250L);
            ofFloat.start();
        }
    }

    private void o() {
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.fragment.d

            /* renamed from: a  reason: collision with root package name */
            private final CommunityFragment f4819a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4819a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4819a.k();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setRefreshing(true);
        this.f4506b.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void k() {
        this.e.setVisibility(8);
        if (this.rl_error_page.getVisibility() != 8) {
            this.rl_error_page.setVisibility(8);
        }
        this.f4506b.d();
        this.f4506b.c();
        com.fotoable.youtube.music.util.h.a("CommunityFragment", "下拉刷新...");
    }

    @OnClick({R.id.iv_post_add, R.id.rl_error_page})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_error_page /* 2131821158 */:
                if (this.rl_error_page.getVisibility() != 8) {
                    this.rl_error_page.setVisibility(8);
                }
                if (this.f4506b != null) {
                    this.e.setVisibility(8);
                    this.f4506b.d();
                    this.refreshLayout.setRefreshing(true);
                    this.f4506b.c();
                    return;
                }
                return;
            case R.id.iv_post_add /* 2131821159 */:
                Intent intent = new Intent(getContext(), CommunityPostActivity.class);
                intent.putExtra("postType", this.f4506b.b());
                getActivity().startActivityForResult(intent, 3002);
                com.fotoable.youtube.music.util.b.b("社区界面-点击发布入口");
                return;
            default:
                return;
        }
    }

    @Override // com.fotoable.youtube.music.d.a.d.a
    public void a(boolean z, List<PostBean> list) {
        b(false);
        if (this.f != null) {
            this.f.showPostList(z, list);
        }
        if (!z && list == null && this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
            this.e.setStatus(LoadMoreFooterView.Status.THE_END);
        } else if (list == null && this.e.getVisibility() != 8) {
            this.e.setVisibility(8);
        }
        if (z && list == null) {
            if (this.rl_error_page.getVisibility() != 0) {
                this.rl_error_page.setVisibility(0);
            }
        } else if (list == null && this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
            this.e.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    }

    public void b(boolean z) {
        if (z) {
            this.refreshLayout.setRefreshing(true);
        } else {
            this.refreshLayout.setRefreshing(false);
        }
    }

    @Override // com.fotoable.youtube.music.d.a.d.a
    public void c_(boolean z) {
        b(false);
        if (z) {
            if (this.f != null && this.f.getItemCount() <= 0 && this.rl_error_page.getVisibility() != 0) {
                this.rl_error_page.setVisibility(0);
            }
        } else if (this.f4506b.e()) {
            this.e.setStatus(LoadMoreFooterView.Status.ERROR);
        } else {
            this.e.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.fotoable.youtube.music.util.h.a("CommunityFragment", "onActivityResult:requestCode:" + i + ",resultCode:" + i2);
        if (i == 3001 && i2 == -1) {
            if (intent != null && intent.hasExtra("bigId")) {
                String stringExtra = intent.getStringExtra("bigId");
                if (this.f != null) {
                    this.f.deletePost(stringExtra);
                }
                if (this.f != null && this.f.getItemCount() == 0) {
                    if (this.rl_error_page != null && this.rl_error_page.getVisibility() != 0) {
                        this.rl_error_page.setVisibility(0);
                    }
                    if (this.e != null && this.e.getVisibility() != 8) {
                        this.e.setVisibility(8);
                    }
                }
            }
        } else if (i == 3002 && i2 == -1 && intent != null && intent.hasExtra("model")) {
            PostBean postBean = (PostBean) intent.getParcelableExtra("model");
            if (this.f != null && postBean != null) {
                com.fotoable.youtube.music.util.h.a("CommunityFragment", postBean.toString());
                this.f.addPost(postBean);
            }
            if (this.rl_error_page != null && this.rl_error_page.getVisibility() != 8) {
                this.rl_error_page.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        if (!this.f4507c.h(str)) {
            this.f4507c.i(str);
            if (this.f != null) {
            }
            a(this.d.e(str).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<PostBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment.5
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    CommunityFragment.this.f4507c.j(str);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<PostBean> myHttpResponse) {
                }
            }));
            com.fotoable.youtube.music.util.b.b("社区界面-点赞评论次数");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        this.i = com.fotoable.youtube.music.ui.dialog.n.a(getFragmentManager(), (int) R.string.deleting, e.f4820a);
        a(this.d.h(str).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<PostBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment.6
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                Toast.makeText(CommunityFragment.this.getContext(), (int) R.string.wearing_network_connect_error, 0).show();
                if (CommunityFragment.this.i != null) {
                    CommunityFragment.this.i.dismiss();
                    CommunityFragment.this.i = null;
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<PostBean> myHttpResponse) {
                if (myHttpResponse != null && myHttpResponse.isSuccess()) {
                    Toast.makeText(CommunityFragment.this.getContext(), (int) R.string.delete_success, 0).show();
                    if (CommunityFragment.this.f != null) {
                        CommunityFragment.this.f.deletePost(str);
                    }
                    if (CommunityFragment.this.f.getItemCount() == 0) {
                        if (CommunityFragment.this.rl_error_page.getVisibility() != 0) {
                            CommunityFragment.this.rl_error_page.setVisibility(0);
                        }
                        if (CommunityFragment.this.e.getVisibility() != 8) {
                            CommunityFragment.this.e.setVisibility(8);
                        }
                    }
                }
                if (CommunityFragment.this.i != null) {
                    CommunityFragment.this.i.dismiss();
                    CommunityFragment.this.i = null;
                }
            }
        }));
        com.fotoable.youtube.music.util.b.b("社区界面-管理员删除帖子次数");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str) {
        this.i = com.fotoable.youtube.music.ui.dialog.n.a(getFragmentManager(), (int) R.string.deleting, f.f4821a);
        a(this.d.f(str).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<PostBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment.7
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                Toast.makeText(CommunityFragment.this.getContext(), (int) R.string.wearing_network_connect_error, 0).show();
                if (CommunityFragment.this.i != null) {
                    CommunityFragment.this.i.dismiss();
                    CommunityFragment.this.i = null;
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<PostBean> myHttpResponse) {
                if (myHttpResponse != null && myHttpResponse.isSuccess()) {
                    Toast.makeText(CommunityFragment.this.getContext(), (int) R.string.delete_success, 0).show();
                    if (CommunityFragment.this.f != null) {
                        CommunityFragment.this.f.deletePost(str);
                    }
                    if (CommunityFragment.this.f.getItemCount() == 0) {
                        if (CommunityFragment.this.rl_error_page.getVisibility() != 0) {
                            CommunityFragment.this.rl_error_page.setVisibility(0);
                        }
                        if (CommunityFragment.this.e.getVisibility() != 8) {
                            CommunityFragment.this.e.setVisibility(8);
                        }
                    }
                }
                if (CommunityFragment.this.i != null) {
                    CommunityFragment.this.i.dismiss();
                    CommunityFragment.this.i = null;
                }
            }
        }));
        com.fotoable.youtube.music.util.b.b("社区界面-删除帖子次数");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        a(this.d.d(str, str2).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<PostBean>>() { // from class: com.fotoable.youtube.music.ui.fragment.CommunityFragment.8
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(MyHttpResponse<PostBean> myHttpResponse) {
                if (myHttpResponse != null && myHttpResponse.isSuccess()) {
                    Toast.makeText(CommunityFragment.this.getContext(), (int) R.string.successfully_reported, 0).show();
                }
            }
        }));
        com.fotoable.youtube.music.util.b.b("社区界面-举报评论次数");
    }

    @Override // com.fotoable.youtube.music.base.i, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f4506b != null) {
            this.f4506b.a();
        }
    }
}
