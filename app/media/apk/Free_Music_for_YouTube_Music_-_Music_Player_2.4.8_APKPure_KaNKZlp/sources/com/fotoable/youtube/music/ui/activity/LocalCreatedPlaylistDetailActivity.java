package com.fotoable.youtube.music.ui.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.LocalPlayListBean;
import com.fotoable.youtube.music.bean.LocalPlayListModel;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.ui.adapter.LocalSongAdapter;
import com.fotoable.youtube.music.ui.dialog.LocalPlayListEditDialog;
import com.fotoable.youtube.music.ui.dialog.PlaylistMenuDialog;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class LocalCreatedPlaylistDetailActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3415b = LocalCreatedPlaylistDetailActivity.class.getSimpleName();
    @BindView(R.id.CollapsingToolbarLayout)
    CollapsingToolbarLayout CollapsingToolbarLayout;
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3416a;
    @BindView(R.id.app_barLayout)
    AppBarLayout appBarLayout;

    /* renamed from: c  reason: collision with root package name */
    private int f3417c;
    private LocalPlayListBean d;
    private LocalPlayListModel e;
    @BindView(R.id.empty_bottom_bar)
    View empty_bottom_bar;
    private LocalSongAdapter f;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.my_playlist_bg_img)
    ImageView mBgImg;
    @BindView(R.id.my_playlist_detail_big_title_tx)
    LaToTextView mBigTitleTx;
    @BindView(R.id.my_playlist_detail_count_tx)
    LaToTextView mCountTx;
    @BindView(R.id.my_playlist_detail_cover_img)
    RoundedImageView mCoverImg;
    @BindView(R.id.my_playlist_desc_layout)
    RelativeLayout mDescLayout;
    @BindView(R.id.my_playlist_play_all_btn)
    Button mPlayAllBtn;
    @BindView(R.id.more_img)
    ImageView moreImg;
    @BindView(R.id.my_playlist_detail_cover_hint)
    RoundedImageView my_playlist_detail_cover_hint;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.rel_no_data)
    NestedScrollView relNoData;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_local_created_playlist_detail;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        u();
        r();
        d();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
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

    private void r() {
        final int i;
        final int i2 = -1;
        this.f3417c = getIntent().getIntExtra("position", 0);
        if (this.f3417c < 4) {
            this.d = (LocalPlayListBean) getIntent().getParcelableExtra("model");
            if (this.d != null) {
                this.mCountTx.setText(this.d.getCount() + "  " + getResources().getString(R.string.songs));
                this.mBigTitleTx.setText(this.d.getTitle());
                this.tvTitle.setText(this.d.getTitle());
                if (this.f3417c == 0) {
                    i2 = R.mipmap.max_local_favorites;
                    i = R.mipmap.icon_myfavorite_big;
                } else if (this.f3417c == 1) {
                    i2 = R.mipmap.max_local_last_played;
                    i = R.mipmap.pic_recently_played;
                } else if (this.f3417c == 2) {
                    i2 = R.mipmap.max_local_added;
                    i = R.mipmap.pic_recently_added;
                } else if (this.f3417c == 3) {
                    i2 = R.mipmap.max_local_most_played;
                    i = R.mipmap.pic_most_played;
                } else {
                    i = -1;
                }
                if (this.d.getCount() > 0) {
                    com.bumptech.glide.i.a((FragmentActivity) this).a(this.d.getCoverUrl()).l().a().d((int) R.mipmap.loadingpic).c((int) R.mipmap.loadingpic).a((com.bumptech.glide.a<String, Bitmap>) new com.bumptech.glide.g.b.g<Bitmap>() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.1
                        @Override // com.bumptech.glide.g.b.j
                        /* renamed from: a */
                        public void onResourceReady(Bitmap bitmap, com.bumptech.glide.g.a.c<? super Bitmap> cVar) {
                            LocalCreatedPlaylistDetailActivity.this.mCoverImg.setImageBitmap(bitmap);
                            com.bumptech.glide.i.a((FragmentActivity) LocalCreatedPlaylistDetailActivity.this).a(Integer.valueOf(i2)).a().a(LocalCreatedPlaylistDetailActivity.this.my_playlist_detail_cover_hint);
                        }

                        @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.g.b.j
                        public void onLoadFailed(Exception exc, Drawable drawable) {
                            super.onLoadFailed(exc, drawable);
                            LocalCreatedPlaylistDetailActivity.this.mCoverImg.setImageResource(i);
                            LocalCreatedPlaylistDetailActivity.this.my_playlist_detail_cover_hint.setVisibility(8);
                        }
                    });
                    com.fotoable.youtube.music.helper.d.b(this, this.d.getCoverUrl(), this.mBgImg);
                } else {
                    com.bumptech.glide.i.a((FragmentActivity) this).a(Integer.valueOf(i)).a().d(i).c(i).a(this.mCoverImg);
                }
                if (this.f3417c == 0) {
                    com.fotoable.youtube.music.util.b.b("本地音乐--收藏页面展示次数");
                    com.fotoable.youtube.music.util.b.b("本地歌单-收藏页面展示次数");
                } else if (this.f3417c == 1) {
                    com.fotoable.youtube.music.util.b.b("本地歌单-最近播放展示次数");
                } else if (this.f3417c == 2) {
                    com.fotoable.youtube.music.util.b.b("本地歌单-最近添加展示次数");
                } else if (this.f3417c == 3) {
                    com.fotoable.youtube.music.util.b.b("本地歌单-最多播放展示次数");
                }
            }
        } else {
            com.fotoable.youtube.music.util.b.b("本地歌单-歌单详情展示次数");
            this.e = (LocalPlayListModel) getIntent().getParcelableExtra("model");
            if (this.e != null) {
                this.mCountTx.setText(this.e.getMusicCount() + "  " + getResources().getString(R.string.songs));
                this.mBigTitleTx.setText(this.e.getName());
                this.tvTitle.setText(this.e.getName());
                com.bumptech.glide.i.a((FragmentActivity) this).a(this.e.getCover()).a().d((int) R.mipmap.loadingpic).c((int) R.mipmap.loadingpic).a(this.mCoverImg);
                com.fotoable.youtube.music.helper.d.b(this, this.e.getCover(), this.mBgImg);
            }
        }
        s();
    }

    private void s() {
        this.recycleView.setLayoutManager(new LinearLayoutManager(this));
        this.recycleView.setHasFixedSize(true);
        t();
    }

    private void t() {
        if (this.f3417c < 4) {
            this.moreImg.setVisibility(8);
            if (this.f3417c == 0) {
                w();
                return;
            } else if (this.f3417c == 1) {
                y();
                return;
            } else if (this.f3417c == 2) {
                z();
                return;
            } else if (this.f3417c == 3) {
                x();
                return;
            } else {
                return;
            }
        }
        this.moreImg.setVisibility(0);
        v();
    }

    private void u() {
        final int i = -com.fotoable.youtube.music.util.w.a(this, 110.0f);
        this.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener(this, i) { // from class: com.fotoable.youtube.music.ui.activity.ah

            /* renamed from: a  reason: collision with root package name */
            private final LocalCreatedPlaylistDetailActivity f3925a;

            /* renamed from: b  reason: collision with root package name */
            private final int f3926b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3925a = this;
                this.f3926b = i;
            }

            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f3925a.a(this.f3926b, appBarLayout, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, AppBarLayout appBarLayout, int i2) {
        if (!p()) {
            float f = ((i2 * 1.0f) / i) * 1.0f;
            if (this.mDescLayout != null) {
                this.mDescLayout.setAlpha(1.0f - f);
            }
            if (this.mPlayAllBtn != null) {
                this.mPlayAllBtn.setAlpha(1.0f - f);
            }
            if (this.tvTitle != null) {
                this.tvTitle.setAlpha(f);
            }
        }
    }

    private void v() {
        if (this.e != null) {
            com.fotoable.youtube.music.util.h.a(f3415b, "" + this.e.toString());
            a(this.f3416a.g(this.e.getId()).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.4
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                    LocalCreatedPlaylistDetailActivity.this.a((List<LocalSongBean>) null);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<LocalSongBean> list) {
                    LocalCreatedPlaylistDetailActivity.this.a(list);
                }
            }));
        }
    }

    private void w() {
        a(this.f3416a.i().a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.5
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                LocalCreatedPlaylistDetailActivity.this.a((List<LocalSongBean>) null);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                LocalCreatedPlaylistDetailActivity.this.a(list);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LocalSongBean> list) {
        if (list == null || list.size() == 0) {
            this.relNoData.setVisibility(0);
            this.recycleView.setVisibility(8);
            this.mCountTx.setText("0  " + getResources().getString(R.string.songs));
            if (this.f != null) {
                this.f.setData(list);
                return;
            }
            return;
        }
        this.relNoData.setVisibility(8);
        this.recycleView.setVisibility(0);
        this.mCountTx.setText(list.size() + "  " + getResources().getString(R.string.songs));
        if (this.f == null) {
            this.f = new LocalSongAdapter(this, getSupportFragmentManager());
            this.recycleView.setAdapter(this.f);
        }
        this.f.setData(list);
    }

    private void x() {
        a(rx.f.a((f.a) new f.a<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.7
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<LocalSongBean>> lVar) {
                List<LocalSongBean> s = LocalCreatedPlaylistDetailActivity.this.f3416a.s();
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(s);
                    lVar.onCompleted();
                }
            }
        }).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.6
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                LocalCreatedPlaylistDetailActivity.this.a((List<LocalSongBean>) null);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                LocalCreatedPlaylistDetailActivity.this.a(list);
            }
        }));
    }

    private void y() {
        a(rx.f.a((f.a) new f.a<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.9
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<LocalSongBean>> lVar) {
                List<LocalSongBean> n = LocalCreatedPlaylistDetailActivity.this.f3416a.n();
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(n);
                    lVar.onCompleted();
                }
            }
        }).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.8
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                LocalCreatedPlaylistDetailActivity.this.a((List<LocalSongBean>) null);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                LocalCreatedPlaylistDetailActivity.this.a(list);
            }
        }));
    }

    private void z() {
        a(rx.f.a((f.a) new f.a<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.11
            @Override // rx.c.b
            /* renamed from: a */
            public void call(rx.l<? super List<LocalSongBean>> lVar) {
                List<LocalSongBean> o = LocalCreatedPlaylistDetailActivity.this.f3416a.o();
                if (lVar != null && !lVar.isUnsubscribed()) {
                    lVar.onNext(o);
                    lVar.onCompleted();
                }
            }
        }).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<List<LocalSongBean>>() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.10
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                LocalCreatedPlaylistDetailActivity.this.a((List<LocalSongBean>) null);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalSongBean> list) {
                LocalCreatedPlaylistDetailActivity.this.a(list);
            }
        }));
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(com.fotoable.youtube.music.e.a aVar) {
        super.a(aVar);
        switch (aVar.f2726a) {
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                if (this.f != null) {
                }
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
            default:
                return;
            case 2017:
                Long l = (Long) aVar.f2727b;
                if (this.e != null && l == this.e.getId()) {
                    this.tvTitle.setText(aVar.f2728c);
                    this.mBigTitleTx.setText(aVar.f2728c);
                    return;
                }
                return;
            case 3010:
                t();
                return;
        }
    }

    @OnClick({R.id.img_back, R.id.my_playlist_play_all_btn, R.id.more_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                finish();
                return;
            case R.id.more_img /* 2131820798 */:
                A();
                return;
            case R.id.my_playlist_play_all_btn /* 2131820801 */:
                if (this.f != null) {
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2104, com.fotoable.youtube.music.newplayer.a.a.a(this.f.getData())));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void A() {
        PlaylistMenuDialog.b bVar = new PlaylistMenuDialog.b(getSupportFragmentManager());
        bVar.a(new PlaylistMenuDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.2
            @Override // com.fotoable.youtube.music.ui.dialog.PlaylistMenuDialog.a
            public void a() {
                LocalCreatedPlaylistDetailActivity.this.B();
            }

            @Override // com.fotoable.youtube.music.ui.dialog.PlaylistMenuDialog.a
            public void b() {
                LocalPlayListEditDialog.a(LocalCreatedPlaylistDetailActivity.this.getSupportFragmentManager(), LocalCreatedPlaylistDetailActivity.this.e.getId().longValue(), LocalCreatedPlaylistDetailActivity.this.mBigTitleTx.getText().toString());
            }
        });
        bVar.a().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.e != null) {
            SimpleMusicDialog.a(getSupportFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.3
                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void a() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void b() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void c() {
                    LocalCreatedPlaylistDetailActivity.this.a(LocalCreatedPlaylistDetailActivity.this.f3416a.h(LocalCreatedPlaylistDetailActivity.this.e.getId()).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.LocalCreatedPlaylistDetailActivity.3.1
                        @Override // rx.g
                        public void onCompleted() {
                            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2015));
                            LocalCreatedPlaylistDetailActivity.this.finish();
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
            }, R.string.delete_playlist_tips, R.string.cancel, R.string.ok);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f != null) {
                this.f.destroy();
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}
