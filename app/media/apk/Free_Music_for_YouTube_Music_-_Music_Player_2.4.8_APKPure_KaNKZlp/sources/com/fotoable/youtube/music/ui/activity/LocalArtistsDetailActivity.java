package com.fotoable.youtube.music.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
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
import com.fotoable.youtube.music.ui.adapter.holder.LocalArtistsSongAdapter;
import com.fotoable.youtube.music.ui.view.ISwipeRefreshLayout;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.ui.view.LoadMoreFooterView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
/* loaded from: classes.dex */
public class LocalArtistsDetailActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private LoadMoreFooterView f3400a;

    /* renamed from: b  reason: collision with root package name */
    private Long f3401b;

    /* renamed from: c  reason: collision with root package name */
    private String f3402c;
    private LocalArtistsSongAdapter d;
    private String e;
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
        com.fotoable.youtube.music.util.b.b("歌手详情页--进入歌手详情次数");
        this.f3401b = Long.valueOf(getIntent().getLongExtra(ShareConstants.WEB_DIALOG_PARAM_DATA, 0L));
        this.f3402c = getIntent().getStringExtra("name");
        this.e = getIntent().getStringExtra("url");
        if (this.f3402c != null) {
            this.tvTitle.setText(this.f3402c);
        } else {
            this.tvTitle.setText(getResources().getString(R.string.artists));
        }
        this.ivImg.setImageResource(R.mipmap.icon_artist);
        t();
        s();
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

    private void t() {
        this.f3400a = (LoadMoreFooterView) this.recycleView.getLoadMoreFooterView();
        this.f3400a.setVisibility(8);
        this.recycleView.setLayoutManager(new LinearLayoutManager(this));
        this.recycleView.setHasFixedSize(true);
        this.d = new LocalArtistsSongAdapter(this, getSupportFragmentManager());
        this.d.setName(this.f3402c);
        this.recycleView.setAdapter(this.d);
        this.refreshLayout.setColorSchemeResources(17170459, 17170452, 17170456, 17170454);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(this) { // from class: com.fotoable.youtube.music.ui.activity.af

            /* renamed from: a  reason: collision with root package name */
            private final LocalArtistsDetailActivity f3923a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3923a = this;
            }

            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                this.f3923a.s();
            }
        });
        this.d.setOnFootClickListener(new LocalArtistsSongAdapter.onFootClickListener(this) { // from class: com.fotoable.youtube.music.ui.activity.ag

            /* renamed from: a  reason: collision with root package name */
            private final LocalArtistsDetailActivity f3924a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3924a = this;
            }

            @Override // com.fotoable.youtube.music.ui.adapter.holder.LocalArtistsSongAdapter.onFootClickListener
            public void onClickFoot() {
                this.f3924a.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void r() {
        if (!TextUtils.isEmpty(this.f3402c)) {
            com.fotoable.youtube.music.util.b.b("歌手详情页--搜索歌手");
            Intent intent = new Intent(this, ArtistsDetailActivity.class);
            if (this.e != null) {
                intent.putExtra("ImgURL", this.e);
            }
            intent.putExtra(ShareConstants.TITLE, this.f3402c);
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void s() {
        if (!TextUtils.isEmpty(this.f3402c)) {
            v();
            a(com.fotoable.youtube.music.helper.localmusic.d.a(this.f3402c, 3).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalArtistsDetailActivity.1
                @Override // rx.g
                public void onCompleted() {
                    LocalArtistsDetailActivity.this.w();
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    LocalArtistsDetailActivity.this.w();
                    LocalArtistsDetailActivity.this.x();
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<LocalSongBean> list) {
                    LocalArtistsDetailActivity.this.w();
                    if (list != null && list.size() > 0) {
                        LocalArtistsDetailActivity.this.d.setData(list);
                        LocalArtistsDetailActivity.this.d.bindFootHolder(LocalArtistsDetailActivity.this.f3402c);
                    }
                }
            }));
        }
    }

    private void v() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        a(false);
    }

    private void a(final boolean z) {
        if (this.refreshLayout != null) {
            this.refreshLayout.post(new Runnable() { // from class: com.fotoable.youtube.music.ui.activity.LocalArtistsDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LocalArtistsDetailActivity.this.refreshLayout != null && !LocalArtistsDetailActivity.this.p()) {
                        LocalArtistsDetailActivity.this.refreshLayout.setRefreshing(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
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
