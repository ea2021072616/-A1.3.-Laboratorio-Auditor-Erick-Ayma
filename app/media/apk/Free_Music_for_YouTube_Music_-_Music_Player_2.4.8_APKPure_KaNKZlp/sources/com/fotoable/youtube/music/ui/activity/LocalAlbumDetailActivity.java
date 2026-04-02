package com.fotoable.youtube.music.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import com.aspsine.irecyclerview.IRecyclerView;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.ui.adapter.LocalSongAdapter;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* loaded from: classes.dex */
public class LocalAlbumDetailActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3384a = LocalAlbumDetailActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private LoadMoreFooterView f3385b;

    /* renamed from: c  reason: collision with root package name */
    private int f3386c;
    private LocalSongAdapter d;
    private String e;
    private String f;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.iv_playing)
    ImageView ivPlaying;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.recycle_view)
    IRecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    ISwipeRefreshLayout refreshLayout;
    @BindView(R.id.tv_title)
    LaToTextView tvTitle;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_local_music_detail;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        com.fotoable.youtube.music.util.b.b("专辑详情页--进入专辑详情次数");
        if (getIntent() != null) {
            this.f3386c = getIntent().getIntExtra("data_id", 0);
            this.e = getIntent().getStringExtra("name");
            this.f = getIntent().getStringExtra("artists");
        }
        if (!TextUtils.isEmpty(this.e) && this.e.contains("/")) {
            this.e = this.e.substring(0, this.e.indexOf("/"));
        }
        if (!TextUtils.isEmpty(this.e)) {
            this.tvTitle.setText(this.e);
        } else {
            this.tvTitle.setText(getResources().getString(R.string.album));
        }
        this.ivImg.setVisibility(8);
        s();
        r();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    private void s() {
        this.recycleView.setLayoutManager(new LinearLayoutManager(this));
        this.d = new LocalSongAdapter(this, getSupportFragmentManager());
        this.recycleView.setIAdapter(this.d);
        this.f3385b = (LoadMoreFooterView) this.recycleView.getLoadMoreFooterView();
        this.f3385b.setVisibility(8);
        View inflate = LayoutInflater.from(this).inflate(R.layout.include_more_free_songs, (ViewGroup) null);
        this.recycleView.addFooterView(inflate);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.LocalAlbumDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(LocalAlbumDetailActivity.this, GenresDetailActivity.class);
                intent.putExtra("SeachKey", LocalAlbumDetailActivity.this.e);
                intent.putExtra("genres", LocalAlbumDetailActivity.this.e);
                intent.putExtra(ShareConstants.TITLE, LocalAlbumDetailActivity.this.e);
                LocalAlbumDetailActivity.this.startActivity(intent);
            }
        });
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.ae

            /* renamed from: a  reason: collision with root package name */
            private final LocalAlbumDetailActivity f3922a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3922a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f3922a.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void r() {
        u();
        com.fotoable.youtube.music.util.h.a(f3384a, "专辑：" + this.e + ",歌手：" + this.f);
        a(com.fotoable.youtube.music.helper.localmusic.d.a(this.e + "", this.f, 2).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalAlbumDetailActivity.2
            @Override // rx.g
            public void onCompleted() {
                LocalAlbumDetailActivity.this.v();
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                LocalAlbumDetailActivity.this.v();
                LocalAlbumDetailActivity.this.w();
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                LocalAlbumDetailActivity.this.v();
                if (list != null && list.size() > 0) {
                    LocalAlbumDetailActivity.this.d.setData(list);
                } else {
                    com.fotoable.youtube.music.util.b.b("Dev_专辑查询歌曲列表失败", "专辑信息", LocalAlbumDetailActivity.this.e + "|&|" + LocalAlbumDetailActivity.this.f);
                }
            }
        }));
    }

    private void u() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        a(false);
    }

    private void a(final boolean z) {
        if (this.refreshLayout != null) {
            this.refreshLayout.post(new Runnable() { // from class: com.fotoable.youtube.music.ui.activity.LocalAlbumDetailActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!LocalAlbumDetailActivity.this.p()) {
                        LocalAlbumDetailActivity.this.refreshLayout.setRefreshing(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.img_back, R.id.iv_playing, R.id.iv_img})
    @Optional
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                super.finish();
                return;
            default:
                return;
        }
    }
}
