package com.fotoable.youtube.music.ui.activity;

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
import android.text.TextUtils;
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
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.PlayListModel;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.ui.adapter.MyPlaylistSongsAdapter;
import com.fotoable.youtube.music.ui.dialog.PlayListEditDialog;
import com.fotoable.youtube.music.ui.dialog.PlaylistMenuDialog;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.f;
/* loaded from: classes.dex */
public class MyPlaylistDetailActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3585b = MyPlaylistDetailActivity.class.getSimpleName();
    @BindView(R.id.CollapsingToolbarLayout)
    CollapsingToolbarLayout CollapsingToolbarLayout;
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3586a;
    @BindView(R.id.app_barLayout)
    AppBarLayout appBarLayout;

    /* renamed from: c  reason: collision with root package name */
    private MyPlaylistSongsAdapter f3587c;
    private Long d;
    private List<PlayMusicModel> e;
    @BindView(R.id.empty_bottom_bar)
    View empty_bottom_bar;
    private int f;
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
        return R.layout.activity_my_playlist_detail;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        s();
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
        PlayListModel b2;
        String stringExtra = getIntent().getStringExtra("EXTRA_TYPE_KEY");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
        }
        String str = "";
        String str2 = "";
        this.d = Long.valueOf(getIntent().getLongExtra("EXTRA_ID_KEY", -1L));
        if (this.d.longValue() >= 0 && (b2 = this.f3586a.b(this.d)) != null) {
            str = b2.getName();
            str2 = b2.getCover();
        }
        this.mCountTx.setText(this.f + "  " + getResources().getString(R.string.songs));
        this.mBigTitleTx.setText(str);
        this.tvTitle.setText(str);
        com.bumptech.glide.i.a((FragmentActivity) this).a(str2).a().d((int) R.mipmap.loadingpic).c((int) R.mipmap.loadingpic).a(this.mCoverImg);
        com.fotoable.youtube.music.helper.d.b(this, str2, this.mBgImg);
        a(stringExtra);
    }

    private void a(String str) {
        this.f3587c = new MyPlaylistSongsAdapter(this, getSupportFragmentManager(), this.f3586a);
        this.recycleView.setLayoutManager(new LinearLayoutManager(this));
        this.recycleView.setHasFixedSize(true);
        this.recycleView.setAdapter(this.f3587c);
        this.f3587c.setType(str);
        if (TextUtils.equals(str, "EXTRA_FAVORITE_TYPE")) {
            this.moreImg.setVisibility(8);
            this.tvTitle.setText(R.string.my_favorite);
            this.mBigTitleTx.setText(R.string.my_favorite);
            com.fotoable.youtube.music.helper.d.a(this, (int) R.mipmap.icon_myfavorite_big, this.mCoverImg);
            u();
        }
        if (TextUtils.equals(str, "EXTRA_PLAYLIST_TYPE")) {
            this.moreImg.setVisibility(0);
            this.f3587c.setPlayListId(this.d);
            t();
        }
    }

    private void s() {
        final int i = -com.fotoable.youtube.music.util.w.a(this, 110.0f);
        this.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener(this, i) { // from class: com.fotoable.youtube.music.ui.activity.at

            /* renamed from: a  reason: collision with root package name */
            private final MyPlaylistDetailActivity f3947a;

            /* renamed from: b  reason: collision with root package name */
            private final int f3948b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3947a = this;
                this.f3948b = i;
            }

            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.f3947a.a(this.f3948b, appBarLayout, i2);
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

    private void t() {
        a(this.f3586a.d(this.d).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<List<PlayMusicModel>>() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<PlayMusicModel> list) {
                if (list != null && list.size() > 0) {
                    MyPlaylistDetailActivity.this.f3587c.setAllAddData(list);
                    MyPlaylistDetailActivity.this.mCountTx.setText(list.size() + "  " + MyPlaylistDetailActivity.this.getResources().getString(R.string.songs));
                    MyPlaylistDetailActivity.this.e = list;
                    MyPlaylistDetailActivity.this.f = list.size();
                    return;
                }
                MyPlaylistDetailActivity.this.relNoData.setVisibility(0);
            }
        }));
    }

    private void u() {
        this.f3586a.c().b(new rx.c.e<List<FavBean>, rx.f<List<PlayMusicModel>>>() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity.3
            @Override // rx.c.e
            public rx.f<List<PlayMusicModel>> a(final List<FavBean> list) {
                return rx.f.a((f.a) new f.a<List<PlayMusicModel>>() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity.3.1
                    @Override // rx.c.b
                    /* renamed from: a */
                    public void call(rx.l<? super List<PlayMusicModel>> lVar) {
                        ArrayList arrayList = new ArrayList();
                        for (FavBean favBean : list) {
                            PlayMusicModel playMusicModel = new PlayMusicModel();
                            playMusicModel.setArtists(favBean.getArtists());
                            playMusicModel.setVideoId(favBean.getVideoid());
                            playMusicModel.setFav(true);
                            playMusicModel.setCoverImg(favBean.getImgUrl());
                            playMusicModel.setDescription(favBean.getDesc());
                            playMusicModel.setDuration(favBean.getDuration());
                            playMusicModel.setTitle(favBean.getTitle());
                            arrayList.add(playMusicModel);
                        }
                        if (lVar != null && !lVar.isUnsubscribed()) {
                            lVar.onNext(arrayList);
                            lVar.onCompleted();
                        }
                    }
                });
            }
        }).a((f.c<? super R, ? extends R>) com.fotoable.youtube.music.util.s.a()).a((rx.g) new rx.g<List<PlayMusicModel>>() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity.2
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<PlayMusicModel> list) {
                if (list != null && list.size() > 0) {
                    MyPlaylistDetailActivity.this.f3587c.setAllAddData(list);
                    MyPlaylistDetailActivity.this.mCountTx.setText(list.size() + "  " + MyPlaylistDetailActivity.this.getResources().getString(R.string.songs));
                    MyPlaylistDetailActivity.this.e = list;
                    MyPlaylistDetailActivity.this.f = list.size();
                    return;
                }
                MyPlaylistDetailActivity.this.relNoData.setVisibility(0);
            }
        });
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
                if (this.f3587c != null) {
                    this.f3587c.setIsPlayingID((String) aVar.f2727b);
                    return;
                }
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                if (this.f3587c != null) {
                    this.f3587c.setIsPlayingID("");
                    return;
                }
                return;
            case 1040:
                if (((Long) aVar.f2727b) == this.d) {
                    this.tvTitle.setText(aVar.f2728c);
                    this.mBigTitleTx.setText(aVar.f2728c);
                    return;
                }
                return;
            case 1041:
                if (((Long) aVar.f2727b) == this.d) {
                    this.f--;
                    this.mCountTx.setText(this.f + "  " + getResources().getString(R.string.songs));
                    if (this.f == 0) {
                        this.relNoData.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            default:
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
                v();
                return;
            case R.id.my_playlist_play_all_btn /* 2131820801 */:
                if (this.e != null) {
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2004, this.e));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void v() {
        PlaylistMenuDialog.b bVar = new PlaylistMenuDialog.b(getSupportFragmentManager());
        bVar.a(new PlaylistMenuDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity.4
            @Override // com.fotoable.youtube.music.ui.dialog.PlaylistMenuDialog.a
            public void a() {
                MyPlaylistDetailActivity.this.w();
            }

            @Override // com.fotoable.youtube.music.ui.dialog.PlaylistMenuDialog.a
            public void b() {
                PlayListEditDialog.a(MyPlaylistDetailActivity.this.getSupportFragmentManager(), MyPlaylistDetailActivity.this.d.longValue(), MyPlaylistDetailActivity.this.mBigTitleTx.getText().toString());
            }
        });
        bVar.a().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        SimpleMusicDialog.a(getSupportFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity.5
            @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
            public void a() {
            }

            @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
            public void b() {
            }

            @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
            public void c() {
                MyPlaylistDetailActivity.this.a(MyPlaylistDetailActivity.this.f3586a.a(MyPlaylistDetailActivity.this.d).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistDetailActivity.5.1
                    @Override // rx.g
                    public void onCompleted() {
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(1042, MyPlaylistDetailActivity.this.d));
                        MyPlaylistDetailActivity.this.finish();
                    }

                    @Override // rx.g
                    public void onError(Throwable th) {
                    }

                    @Override // rx.g
                    /* renamed from: a */
                    public void onNext(Boolean bool) {
                    }
                }));
            }
        }, R.string.delete_playlist_tips, R.string.cancel, R.string.ok);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f3587c.cleanData();
    }
}
