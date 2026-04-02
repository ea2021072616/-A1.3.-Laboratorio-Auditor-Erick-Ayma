package com.fotoable.youtube.music.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PlayBean;
import com.fotoable.youtube.music.ui.adapter.AlbumItemOffsetDecoration;
import com.fotoable.youtube.music.ui.adapter.PlayListAdapter;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class EditorChoicePlayListActivity extends BaseActivity {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3291a;

    /* renamed from: b  reason: collision with root package name */
    private String f3292b;

    /* renamed from: c  reason: collision with root package name */
    private int f3293c;
    private PlayListAdapter d;
    @BindView(R.id.img_back)
    ImageView imgBack;
    private LoadMoreFooterView j;
    private int l;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.recycle_view)
    IRecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    ISwipeRefreshLayout refreshLayout;
    @BindView(R.id.toolbar)
    RelativeLayout toolbar;
    @BindView(R.id.tv_error)
    LaToTextView tvError;
    @BindView(R.id.tv_title)
    LaToTextView tvTitle;
    private int e = 0;
    private int f = 20;
    private long g = 0;
    private boolean h = true;
    private boolean i = false;
    private int k = 1;
    private OnLoadMoreListener m = new OnLoadMoreListener() { // from class: com.fotoable.youtube.music.ui.activity.EditorChoicePlayListActivity.3
        @Override // com.aspsine.irecyclerview.OnLoadMoreListener
        public void onLoadMore() {
            if (EditorChoicePlayListActivity.this.h) {
                if (!EditorChoicePlayListActivity.this.i) {
                    EditorChoicePlayListActivity.this.j.setStatus(LoadMoreFooterView.Status.LOADING);
                    EditorChoicePlayListActivity.this.v();
                    return;
                }
                return;
            }
            EditorChoicePlayListActivity.this.j.setStatus(LoadMoreFooterView.Status.THE_END);
        }
    };

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.editchoice_palylist_activity;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        u();
        t();
        v();
    }

    private void t() {
        com.fotoable.youtube.music.util.b.b("推荐页-编辑推荐-新版歌单页打开次数");
        if (!TextUtils.isEmpty(this.f3292b)) {
            this.tvTitle.setText(this.f3292b);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        this.recycleView.addItemDecoration(new AlbumItemOffsetDecoration(com.fotoable.youtube.music.util.w.a(this, 16.0f), com.fotoable.youtube.music.util.w.a(this, 10.0f)));
        this.recycleView.setLayoutManager(gridLayoutManager);
        this.d = new PlayListAdapter(this);
        this.d.setSource(this.l);
        if (this.l == 2201) {
            this.d.setEditorChoiceTitle(this.f3292b);
        }
        this.d.setType(this.k);
        this.recycleView.setIAdapter(this.d);
        this.recycleView.setOnLoadMoreListener(this.m);
        this.j = (LoadMoreFooterView) this.recycleView.getLoadMoreFooterView();
        this.j.setVisibility(8);
        this.refreshLayout.setRefreshing(true);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.s

            /* renamed from: a  reason: collision with root package name */
            private final EditorChoicePlayListActivity f4014a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4014a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f4014a.s();
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void s() {
        this.e = 0;
        this.g = 0L;
        if (this.d != null) {
            this.d.cleanData();
        }
        v();
        a(true);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    private void u() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f3292b = intent.getStringExtra("extra_title");
            this.f3293c = intent.getIntExtra("extra_id", 0);
            this.k = intent.getIntExtra("extra_type", 1);
            this.l = intent.getIntExtra(ShareConstants.FEED_SOURCE_PARAM, 1002);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.k == 1) {
            w();
        } else {
            x();
        }
    }

    private void w() {
        if (!this.i && this.f3293c >= 0) {
            a(this.f3291a.a(this.f3293c, this.e, this.f, this.g).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<MyHttpResponse<List<PlayBean>>>() { // from class: com.fotoable.youtube.music.ui.activity.EditorChoicePlayListActivity.1
                @Override // rx.g
                public void onCompleted() {
                    EditorChoicePlayListActivity.this.a(false);
                    if (EditorChoicePlayListActivity.this.j != null) {
                        EditorChoicePlayListActivity.this.j.setVisibility(0);
                    }
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    EditorChoicePlayListActivity.this.a(false);
                    EditorChoicePlayListActivity.this.y();
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<List<PlayBean>> myHttpResponse) {
                    if (myHttpResponse.getData() == null || myHttpResponse.getData().size() <= 0) {
                        EditorChoicePlayListActivity.this.h = false;
                        if (EditorChoicePlayListActivity.this.j != null) {
                            EditorChoicePlayListActivity.this.j.setStatus(LoadMoreFooterView.Status.THE_END);
                        }
                    } else {
                        EditorChoicePlayListActivity.this.d.setAddData(myHttpResponse.getData());
                        EditorChoicePlayListActivity.this.e += EditorChoicePlayListActivity.this.f;
                        EditorChoicePlayListActivity.this.h = true;
                    }
                    EditorChoicePlayListActivity.this.g = myHttpResponse.getMeta().getMixid();
                    if (EditorChoicePlayListActivity.this.tvError != null) {
                        EditorChoicePlayListActivity.this.tvError.setVisibility(8);
                    }
                }
            }));
        }
    }

    private void x() {
        if (!this.i && this.f3293c >= 0) {
            a(this.f3291a.b(this.f3293c, this.e, this.f, this.g).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<MyHttpResponse<List<PlayBean>>>() { // from class: com.fotoable.youtube.music.ui.activity.EditorChoicePlayListActivity.2
                @Override // rx.g
                public void onCompleted() {
                    EditorChoicePlayListActivity.this.a(false);
                    if (EditorChoicePlayListActivity.this.j != null) {
                        EditorChoicePlayListActivity.this.j.setVisibility(0);
                    }
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    EditorChoicePlayListActivity.this.a(false);
                    EditorChoicePlayListActivity.this.y();
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(MyHttpResponse<List<PlayBean>> myHttpResponse) {
                    if (myHttpResponse.getData() == null || myHttpResponse.getData().size() <= 0) {
                        EditorChoicePlayListActivity.this.h = false;
                        if (EditorChoicePlayListActivity.this.j != null) {
                            EditorChoicePlayListActivity.this.j.setStatus(LoadMoreFooterView.Status.THE_END);
                        }
                    } else {
                        EditorChoicePlayListActivity.this.d.setAddData(myHttpResponse.getData());
                        EditorChoicePlayListActivity.this.e += EditorChoicePlayListActivity.this.f;
                        EditorChoicePlayListActivity.this.h = true;
                    }
                    EditorChoicePlayListActivity.this.g = myHttpResponse.getMeta().getMixid();
                    if (EditorChoicePlayListActivity.this.tvError != null) {
                        EditorChoicePlayListActivity.this.tvError.setVisibility(8);
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.tvError != null && this.d != null && this.d.getItemCount() <= 0) {
            this.tvError.setVisibility(0);
            this.refreshLayout.setRefreshing(false);
        }
        this.h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.refreshLayout != null) {
            if (z) {
                this.i = true;
                this.refreshLayout.setRefreshing(true);
                return;
            }
            this.i = false;
            new Handler().postDelayed(new Runnable(this) { // from class: com.fotoable.youtube.music.ui.activity.t

                /* renamed from: a  reason: collision with root package name */
                private final EditorChoicePlayListActivity f4015a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4015a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f4015a.r();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.img_back, R.id.ll_error})
    @Optional
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                finish();
                return;
            case R.id.ll_error /* 2131820763 */:
                this.e = 0;
                this.g = 0L;
                v();
                a(true);
                return;
            default:
                return;
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }
}
