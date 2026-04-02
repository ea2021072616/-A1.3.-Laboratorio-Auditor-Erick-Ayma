package com.fotoable.youtube.music.ui.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import com.fotoable.youtube.music.ui.dialog.LocalMusicMenuDialog;
import com.fotoable.youtube.music.ui.dialog.MusicMenuDialog;
import com.fotoable.youtube.music.ui.dialog.PlayerMusicListDialog;
import com.fotoable.youtube.music.ui.dialog.RadioMenuDialog;
import com.fotoable.youtube.music.ui.view.MarqueeTextView;
import com.fotoable.youtube.music.ui.view.PlayerCoverView;
import com.fotoable.youtube.music.ui.view.SeekBarProgress;
import com.google.android.youtube.player.YouTubeIntents;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class PlayerActivity extends BaseActivity {
    private static final String f = PlayerActivity.class.getSimpleName();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3673a;
    @BindView(R.id.artists_name)
    TextView artists_name;

    /* renamed from: b  reason: collision with root package name */
    List<PlayerCoverView> f3674b;
    @BindView(R.id.blur_bg)
    ImageView blur_bg;

    /* renamed from: c  reason: collision with root package name */
    Map<String, PlayerCoverView> f3675c;
    @BindView(R.id.change_play_loading)
    RelativeLayout change_play_loading;
    @BindView(R.id.change_play_state)
    ImageView change_play_state;
    @BindView(R.id.comment_count)
    TextView comment_count;
    @BindView(R.id.cover_panel)
    RelativeLayout cover_panel;
    a d;
    @BindView(R.id.dialog_comment_tips_img)
    ImageView dialog_comment_tips_img;
    @Inject
    com.fotoable.youtube.music.b.c e;
    @BindView(R.id.full_screen)
    ImageView full_screen;
    private int g;
    @BindView(R.id.go_youtube_panel)
    LinearLayout go_youtube_panel;
    private PlayMusicModel h;
    private LocalMusicModel i;
    private RadioModel j;
    @BindView(R.id.loop_model)
    ImageView loop_model;
    @BindView(R.id.music_name)
    MarqueeTextView music_name;
    private boolean n;
    private long o;
    @BindView(R.id.origin_cover)
    ImageView origin_cover;
    @BindView(R.id.origin_cover_panel)
    RelativeLayout origin_cover_panel;
    @BindView(R.id.play_back)
    ImageView play_back;
    @BindView(R.id.play_loading)
    ImageView play_loading;
    @BindView(R.id.play_next)
    ImageView play_next;
    private PlayerInfo r;
    @BindView(R.id.radio_cover_img)
    ImageView radio_cover_img;
    @BindView(R.id.radio_cover_panel)
    RelativeLayout radio_cover_panel;
    private ObjectAnimator s;
    private ObjectAnimator t;
    private PlayerMusicListDialog u;
    private int v;
    @BindView(R.id.video_comment)
    RelativeLayout video_comment;
    @BindView(R.id.video_favorite_state)
    ImageView video_favorite_state;
    @BindView(R.id.video_favorite_state1)
    ImageView video_favorite_state1;
    @BindView(R.id.video_play_current_time)
    TextView video_play_current_time;
    @BindView(R.id.video_play_list)
    ImageView video_play_list;
    @BindView(R.id.video_play_total_time)
    TextView video_play_total_time;
    @BindView(R.id.video_seek_bar)
    SeekBarProgress video_seek_bar;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    private boolean k = false;
    private boolean l = true;
    private boolean m = true;
    private boolean p = false;
    private boolean q = false;
    private boolean w = false;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_player;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        final int i;
        MusicApplication.c().a(true);
        d();
        this.music_name.setPosition(1);
        this.g = com.fotoable.youtube.music.newplayer.e.a().d();
        if (this.g == 2) {
            if (com.fotoable.youtube.music.a.l()) {
                this.dialog_comment_tips_img.setVisibility(0);
            }
            com.fotoable.youtube.music.newplayer.e.a().d(1002);
            com.fotoable.youtube.music.newplayer.e.a().a(this, 2402);
            this.h = com.fotoable.youtube.music.newplayer.e.a().e();
            if (this.h != null) {
                com.fotoable.youtube.music.util.h.a(f, "当前是Youtube播放器");
                this.music_name.setText(this.h.getTitle() + "");
                if (!TextUtils.isEmpty(this.h.getArtists())) {
                    this.artists_name.setText(this.h.getArtists() + "");
                } else {
                    this.artists_name.setVisibility(8);
                }
                this.cover_panel.setVisibility(0);
                this.radio_cover_panel.setVisibility(8);
                a(this.h.getCoverImg());
                t();
            }
        } else if (this.g == 3) {
            this.i = com.fotoable.youtube.music.newplayer.e.a().f();
            this.go_youtube_panel.setVisibility(8);
            this.full_screen.setVisibility(8);
            this.cover_panel.setVisibility(0);
            this.radio_cover_panel.setVisibility(8);
            if (this.i != null) {
                this.music_name.setText(this.i.getSongName() + "");
                if (!TextUtils.isEmpty(this.i.getArtistName())) {
                    this.artists_name.setText(this.i.getArtistName() + "");
                } else {
                    this.artists_name.setVisibility(8);
                }
                a(this.i.getAlbumData());
                r();
            }
            com.fotoable.youtube.music.util.h.a(f, "当前是本地Music播放器");
        } else if (this.g == 4) {
            this.video_seek_bar.setDrag(false);
            this.loop_model.setAlpha(0.08f);
            this.play_back.setAlpha(0.08f);
            this.play_next.setAlpha(0.08f);
            this.video_play_list.setAlpha(0.08f);
            this.j = com.fotoable.youtube.music.newplayer.e.a().g();
            this.go_youtube_panel.setVisibility(8);
            this.full_screen.setVisibility(8);
            this.cover_panel.setVisibility(4);
            this.radio_cover_panel.setVisibility(0);
            com.fotoable.youtube.music.util.h.a(f, "当前是Radio播放器");
            if (this.j != null) {
                this.music_name.setText(this.j.getTitle() + "");
                this.artists_name.setVisibility(8);
                com.bumptech.glide.i.a((FragmentActivity) this).a(this.j.getImgUrl()).c((int) R.mipmap.icon_radio_default).b(com.bumptech.glide.load.b.b.ALL).c().a(this.radio_cover_img);
                this.origin_cover_panel.setVisibility(0);
                x();
            }
        } else {
            finish();
        }
        this.v = com.fotoable.youtube.music.a.w();
        this.loop_model.setImageLevel(this.v);
        this.video_seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (PlayerActivity.this.n) {
                    long max = (i2 / seekBar.getMax()) * ((float) PlayerActivity.this.o);
                    if (PlayerActivity.this.g == 3) {
                        max /= 1000;
                    }
                    PlayerActivity.this.video_play_current_time.setText(PlayerActivity.this.a(max));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                com.fotoable.youtube.music.util.h.a(PlayerActivity.f, "开始拖动");
                PlayerActivity.this.n = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                PlayerActivity.this.n = false;
                com.fotoable.youtube.music.util.h.a(PlayerActivity.f, "停止拖动");
                if (PlayerActivity.this.video_seek_bar != null) {
                    com.fotoable.youtube.music.newplayer.e.a().e(PlayerActivity.this.video_seek_bar.getProgress());
                }
                PlayerActivity.this.q = true;
            }
        });
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.g == 2) {
            List<PlayMusicModel> b2 = com.fotoable.youtube.music.newplayer.e.a().b();
            i = 0;
            for (int i2 = 0; b2 != null && i2 < b2.size(); i2++) {
                if (this.h != null && b2.get(i2) != null && TextUtils.equals(b2.get(i2).getVideoId(), this.h.getVideoId())) {
                    i = i2;
                }
                if (b2.get(i2) != null) {
                    arrayList.add(b2.get(i2).getCoverImg());
                    arrayList2.add(b2.get(i2).getVideoId());
                }
            }
        } else if (this.g == 3) {
            List<LocalMusicModel> c2 = com.fotoable.youtube.music.newplayer.e.a().c();
            i = 0;
            for (int i3 = 0; c2 != null && i3 < c2.size(); i3++) {
                LocalMusicModel localMusicModel = c2.get(i3);
                if (localMusicModel != null) {
                    if (this.i != null && localMusicModel.getSongId() == this.i.getSongId()) {
                        i = i3;
                    }
                    arrayList.add(localMusicModel.getAlbumData());
                    arrayList2.add(localMusicModel.getSongId() + "");
                }
            }
        } else {
            if (this.g == 4) {
            }
            i = 0;
        }
        this.f3674b = new ArrayList();
        this.f3675c = new HashMap();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            PlayerCoverView playerCoverView = new PlayerCoverView(this);
            playerCoverView.setImgUrl((String) arrayList.get(i4));
            this.f3674b.add(playerCoverView);
            this.f3675c.put(arrayList2.get(i4), playerCoverView);
        }
        if (this.f3674b.size() > 0) {
            this.view_pager.setOffscreenPageLimit(2);
            this.d = new a(this.f3674b);
            this.view_pager.setAdapter(this.d);
            this.view_pager.setCurrentItem((this.f3674b.size() * 0) + i, false);
            this.view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.8
                private int d;

                /* renamed from: a  reason: collision with root package name */
                boolean f3688a = false;
                private boolean e = false;
                private boolean f = false;

                {
                    this.d = i;
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i5, float f2, int i6) {
                    if (!this.f3688a) {
                        this.f3688a = true;
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 < PlayerActivity.this.f3674b.size()) {
                                PlayerActivity.this.f3674b.get(i8).stopRotation();
                                i7 = i8 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageSelected(int i5) {
                    if (this.d > i5) {
                        this.f = false;
                    } else {
                        this.f = true;
                    }
                    this.d = i5;
                    this.e = true;
                }

                @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i5) {
                    switch (i5) {
                        case 0:
                            this.f3688a = false;
                            if (this.e) {
                                if (!PlayerActivity.this.k && !PlayerActivity.this.m) {
                                    com.fotoable.youtube.music.util.h.a(PlayerActivity.f, "状态：" + this.f);
                                    PlayerActivity.this.m = true;
                                    com.fotoable.youtube.music.newplayer.e.a().a(PlayerActivity.this.view_pager.getCurrentItem() % PlayerActivity.this.f3674b.size(), true);
                                }
                                PlayerActivity.this.k = false;
                            }
                            this.e = false;
                            return;
                        default:
                            return;
                    }
                }
            });
            this.view_pager.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.9
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            PlayerActivity.this.l = false;
                            com.fotoable.youtube.music.util.h.a(PlayerActivity.f, "点击VP   ACTION_DOWN");
                            PlayerActivity.this.k = true;
                            PlayerActivity.this.m = true;
                            break;
                        case 1:
                            com.fotoable.youtube.music.util.h.a(PlayerActivity.f, "点击VP  ACTION_UP");
                            PlayerActivity.this.l = true;
                            PlayerActivity.this.k = false;
                            PlayerActivity.this.m = false;
                            break;
                    }
                    return false;
                }
            });
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(this.view_pager, new b(this.view_pager.getContext().getApplicationContext(), new LinearInterpolator()));
            } catch (IllegalAccessException e) {
                ThrowableExtension.printStackTrace(e);
            } catch (IllegalArgumentException e2) {
                ThrowableExtension.printStackTrace(e2);
            } catch (NoSuchFieldException e3) {
                ThrowableExtension.printStackTrace(e3);
            }
        }
        com.fotoable.youtube.music.util.h.a(f, "可滑动的数量：" + arrayList.size());
    }

    /* loaded from: classes.dex */
    public class b extends Scroller {

        /* renamed from: b  reason: collision with root package name */
        private int f3695b;

        public b(Context context, Interpolator interpolator) {
            super(context, interpolator);
            this.f3695b = 390;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.f3695b);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, this.f3695b);
        }
    }

    /* loaded from: classes.dex */
    class a extends PagerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private List<PlayerCoverView> f3693b;

        public a(List<PlayerCoverView> list) {
            this.f3693b = list;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.f3693b.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PlayerCoverView playerCoverView = this.f3693b.get(i % this.f3693b.size());
            playerCoverView.reload();
            viewGroup.removeView(playerCoverView);
            viewGroup.addView(playerCoverView);
            return playerCoverView;
        }
    }

    public void r() {
        if (this.i != null) {
            this.f3673a.f(Long.valueOf(this.i.getSongId())).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.10
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
                    PlayerActivity.this.w = bool.booleanValue();
                    PlayerActivity.this.video_favorite_state.setImageLevel(PlayerActivity.this.w ? 1 : 0);
                }
            });
        }
    }

    private void t() {
        if (this.h != null && !TextUtils.isEmpty(this.h.getVideoId())) {
            a(this.f3673a.d(this.h.getVideoId()).b(Schedulers.io()).a(rx.a.b.a.a()).b(new rx.l<List<FavBean>>() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.11
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.l
                public void onStart() {
                    super.onStart();
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(List<FavBean> list) {
                    if (list == null || list.size() <= 0) {
                        PlayerActivity.this.h.setFav(false);
                        PlayerActivity.this.video_favorite_state.setImageLevel(0);
                        return;
                    }
                    PlayerActivity.this.h.setFav(true);
                    PlayerActivity.this.video_favorite_state.setImageLevel(1);
                }
            }));
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(com.fotoable.youtube.music.e.a aVar) {
        PlayerInfo playerInfo;
        super.a(aVar);
        switch (aVar.f2726a) {
            case 1047:
                t();
                return;
            case 2005:
                if (!this.n && (playerInfo = (PlayerInfo) aVar.f2727b) != null) {
                    a(playerInfo);
                    return;
                }
                return;
            case 2006:
                finish();
                return;
            case 2007:
                this.v = aVar.d;
                this.loop_model.setImageLevel(this.v);
                b(this.v);
                return;
            case 2008:
                com.fotoable.youtube.music.util.h.a(f, "搜索歌词");
                if (TextUtils.isEmpty(this.h.getArtists())) {
                    com.fotoable.youtube.music.util.i.a(this).b(this.h.getTitle(), this.h.getVideoId());
                    return;
                } else {
                    com.fotoable.youtube.music.util.i.a(this).b(this.h.getArtists() + "  " + this.h.getTitle(), this.h.getVideoId());
                    return;
                }
            case 2009:
                com.fotoable.youtube.music.util.h.a(f, "搜索Mp3");
                if (TextUtils.isEmpty(this.h.getArtists())) {
                    com.fotoable.youtube.music.util.i.a(this).a(this.h.getTitle(), this.h.getVideoId());
                    return;
                } else {
                    com.fotoable.youtube.music.util.i.a(this).a(this.h.getArtists() + "  " + this.h.getTitle(), this.h.getVideoId());
                    return;
                }
            case 2011:
                if (TextUtils.equals(this.h.getVideoId(), aVar.f2728c)) {
                    if (aVar.e) {
                        E();
                        return;
                    } else {
                        D();
                        return;
                    }
                }
                return;
            case 2012:
                this.k = true;
                return;
            case 3009:
                r();
                return;
            case 3010:
                if (com.fotoable.youtube.music.newplayer.e.a().f() != null && com.fotoable.youtube.music.newplayer.e.a().c().size() == 1) {
                    finish();
                    return;
                }
                return;
            case 8003:
                com.fotoable.youtube.music.util.h.a(f, "播放界面收到退出全屏的广播");
                if (getRequestedOrientation() != 7) {
                    setRequestedOrientation(7);
                }
                if (e()) {
                    com.fotoable.youtube.music.newplayer.e.a().c(3);
                    return;
                }
                return;
            case 8005:
            default:
                return;
        }
    }

    private void b(int i) {
        if (i == 0) {
            Toast.makeText(this, (int) R.string.model_list_play, 0).show();
        } else if (i == 1) {
            Toast.makeText(this, (int) R.string.model_single_loop, 0).show();
        } else if (i == 2) {
            Toast.makeText(this, (int) R.string.model_random_play, 0).show();
        }
    }

    private void a(PlayerInfo playerInfo) {
        PlayerCoverView playerCoverView;
        PlayerCoverView playerCoverView2;
        if (this.r != null && playerInfo != null && ((this.r.isLocalPlayer() && playerInfo.isLocalPlayer() && this.r.getSongId() == playerInfo.getSongId()) || (this.r.isRadioPlayer() && playerInfo.isRadioPlayer() && this.r.getRadioId() == playerInfo.getRadioId()))) {
            this.r = playerInfo;
            if (playerInfo.isYoutubePlayer()) {
                this.video_play_current_time.setText(a(playerInfo.getCurrentTime()));
                this.video_play_total_time.setText(a(playerInfo.getTotalTime()));
                this.video_seek_bar.setMax((int) playerInfo.getTotalTime());
                if (playerInfo.isBuffering()) {
                    C();
                    PlayerCoverView playerCoverView3 = this.f3675c.get(playerInfo.getVideoId());
                    if (playerCoverView3 != null) {
                        playerCoverView3.stopRotation();
                        return;
                    }
                    return;
                }
                this.p = playerInfo.isPlaying();
                if (playerInfo.isPlaying()) {
                    this.change_play_state.setImageLevel(1);
                    A();
                    if (this.l && (playerCoverView2 = this.f3675c.get(playerInfo.getVideoId())) != null) {
                        playerCoverView2.startRotation();
                    }
                } else {
                    this.change_play_state.setImageLevel(0);
                    z();
                    PlayerCoverView playerCoverView4 = this.f3675c.get(playerInfo.getVideoId());
                    if (playerCoverView4 != null) {
                        playerCoverView4.stopRotation();
                    }
                }
                B();
                return;
            } else if (playerInfo.isLocalPlayer()) {
                this.o = playerInfo.getTotalTime();
                this.video_play_current_time.setText(a(playerInfo.getCurrentTime() / 1000));
                this.video_play_total_time.setText(a(playerInfo.getTotalTime() / 1000));
                this.video_seek_bar.setMax((int) playerInfo.getTotalTime());
                this.p = playerInfo.isPlaying();
                if (playerInfo.isBuffering()) {
                    C();
                    PlayerCoverView playerCoverView5 = this.f3675c.get(playerInfo.getSongId() + "");
                    if (playerCoverView5 != null) {
                        playerCoverView5.stopRotation();
                        return;
                    } else {
                        com.fotoable.youtube.music.util.h.a(f, "PlayerCoverView null1");
                        return;
                    }
                } else if (playerInfo.isPlaying()) {
                    this.change_play_state.setImageLevel(1);
                    A();
                    if (this.l) {
                        PlayerCoverView playerCoverView6 = this.f3675c.get(playerInfo.getSongId() + "");
                        if (playerCoverView6 != null) {
                            playerCoverView6.startRotation();
                            return;
                        } else {
                            com.fotoable.youtube.music.util.h.a(f, "PlayerCoverView null2");
                            return;
                        }
                    }
                    return;
                } else {
                    this.change_play_state.setImageLevel(0);
                    z();
                    PlayerCoverView playerCoverView7 = this.f3675c.get(playerInfo.getSongId() + "");
                    if (playerCoverView7 != null) {
                        playerCoverView7.stopRotation();
                        return;
                    } else {
                        com.fotoable.youtube.music.util.h.a(f, "PlayerCoverView null3    " + playerInfo.getSongId());
                        return;
                    }
                }
            } else if (playerInfo.isRadioPlayer()) {
                this.o = playerInfo.getTotalTime();
                this.video_play_total_time.setText("24:00");
                this.video_play_current_time.setText(a(playerInfo.getCurrentTime() / 1000));
                this.video_seek_bar.setProgress((int) playerInfo.getCurrentTime());
                this.video_seek_bar.setMax((int) playerInfo.getTotalTime());
                if (playerInfo.isBuffering()) {
                    C();
                    return;
                }
                this.p = playerInfo.isPlaying();
                if (playerInfo.isPlaying()) {
                    this.change_play_state.setImageLevel(1);
                } else {
                    this.change_play_state.setImageLevel(0);
                }
                B();
                return;
            } else {
                return;
            }
        }
        this.r = playerInfo;
        this.music_name.setText(playerInfo.getMusicName() + "");
        if (!TextUtils.isEmpty(playerInfo.getArtistsName())) {
            this.artists_name.setText(playerInfo.getArtistsName());
            this.artists_name.setVisibility(0);
        } else {
            this.artists_name.setVisibility(8);
        }
        if (playerInfo.isYoutubePlayer()) {
            this.o = playerInfo.getTotalTime();
            this.video_play_total_time.setText(a(playerInfo.getTotalTime()));
            this.video_seek_bar.setMax((int) playerInfo.getTotalTime());
            if (!TextUtils.equals(this.h.getVideoId(), playerInfo.getVideoId())) {
                this.h = com.fotoable.youtube.music.newplayer.e.a().e();
                this.video_play_current_time.setText(a(playerInfo.getCurrentTime()));
                this.video_seek_bar.setProgress((int) playerInfo.getCurrentTime());
                if (this.u != null) {
                    com.fotoable.youtube.music.util.h.a(f, "playerMusicListDialog not null");
                    this.u.a(this.h.getVideoId());
                } else {
                    com.fotoable.youtube.music.util.h.a(f, "playerMusicListDialog null");
                }
                a(this.h.getCoverImg());
                z();
                t();
                y();
                com.fotoable.youtube.music.util.h.a(f, "刷新滑动.");
            } else if (!this.q) {
                this.video_play_current_time.setText(a(playerInfo.getCurrentTime()));
                this.video_seek_bar.setProgress((int) playerInfo.getCurrentTime());
            } else {
                this.q = false;
            }
            if (playerInfo.isBuffering()) {
                C();
                PlayerCoverView playerCoverView8 = this.f3675c.get(playerInfo.getVideoId());
                if (playerCoverView8 != null) {
                    playerCoverView8.stopRotation();
                    return;
                }
                return;
            }
            this.p = playerInfo.isPlaying();
            if (playerInfo.isPlaying()) {
                this.change_play_state.setImageLevel(1);
                A();
                if (this.l && (playerCoverView = this.f3675c.get(playerInfo.getVideoId())) != null) {
                    playerCoverView.startRotation();
                }
            } else {
                this.change_play_state.setImageLevel(0);
                z();
                PlayerCoverView playerCoverView9 = this.f3675c.get(playerInfo.getVideoId());
                if (playerCoverView9 != null) {
                    playerCoverView9.stopRotation();
                }
            }
            B();
        } else if (playerInfo.isLocalPlayer()) {
            this.o = playerInfo.getTotalTime();
            this.video_play_total_time.setText(a(playerInfo.getTotalTime() / 1000));
            this.video_seek_bar.setMax((int) playerInfo.getTotalTime());
            if (this.i.getSongId() != playerInfo.getSongId()) {
                com.fotoable.youtube.music.util.h.a(f, "上一次ID：" + this.i.getSongId());
                com.fotoable.youtube.music.util.h.a(f, "当前ID：" + playerInfo.getSongId());
                this.i = com.fotoable.youtube.music.newplayer.e.a().f();
                com.fotoable.youtube.music.util.h.a(f, "获取到的ID：" + this.i.getSongId());
                this.video_play_current_time.setText(a(playerInfo.getCurrentTime() / 1000));
                this.video_seek_bar.setProgress((int) playerInfo.getCurrentTime());
                if (this.u != null) {
                    this.u.a(playerInfo.getSongId());
                }
                a(this.i.getAlbumData());
                z();
                r();
                y();
            } else if (!this.q) {
                this.video_play_current_time.setText(a(playerInfo.getCurrentTime() / 1000));
                this.video_seek_bar.setProgress((int) playerInfo.getCurrentTime());
            } else {
                this.q = false;
            }
            this.p = playerInfo.isPlaying();
            if (playerInfo.isBuffering()) {
                C();
                PlayerCoverView playerCoverView10 = this.f3675c.get(playerInfo.getSongId() + "");
                if (playerCoverView10 != null) {
                    playerCoverView10.stopRotation();
                } else {
                    com.fotoable.youtube.music.util.h.a(f, "PlayerCoverView null1");
                }
            } else if (playerInfo.isPlaying()) {
                this.change_play_state.setImageLevel(1);
                A();
                if (this.l) {
                    PlayerCoverView playerCoverView11 = this.f3675c.get(playerInfo.getSongId() + "");
                    if (playerCoverView11 != null) {
                        playerCoverView11.startRotation();
                    } else {
                        com.fotoable.youtube.music.util.h.a(f, "PlayerCoverView null2");
                    }
                }
            } else {
                this.change_play_state.setImageLevel(0);
                z();
                PlayerCoverView playerCoverView12 = this.f3675c.get(playerInfo.getSongId() + "");
                if (playerCoverView12 != null) {
                    playerCoverView12.stopRotation();
                } else {
                    com.fotoable.youtube.music.util.h.a(f, "PlayerCoverView null3    " + playerInfo.getSongId());
                }
            }
            B();
        } else if (playerInfo.isRadioPlayer()) {
            this.o = playerInfo.getTotalTime();
            this.video_play_total_time.setText("24:00");
            if (this.j.getId() != playerInfo.getRadioId()) {
                this.j = com.fotoable.youtube.music.newplayer.e.a().g();
                this.video_play_current_time.setText(a(playerInfo.getCurrentTime() / 1000));
                this.video_seek_bar.setProgress((int) playerInfo.getCurrentTime());
                this.video_seek_bar.setMax((int) playerInfo.getTotalTime());
                this.origin_cover.setRotation(0.0f);
                com.bumptech.glide.i.a((FragmentActivity) this).a(this.j.getImgUrl()).c((int) R.mipmap.icon_radio_default).b(com.bumptech.glide.load.b.b.ALL).c().a(this.radio_cover_img);
                x();
            } else if (!this.q) {
                this.video_play_current_time.setText(a(playerInfo.getCurrentTime() / 1000));
                this.video_seek_bar.setProgress((int) playerInfo.getCurrentTime());
                this.video_seek_bar.setMax((int) playerInfo.getTotalTime());
            } else {
                this.q = false;
            }
            if (playerInfo.isBuffering()) {
                C();
                return;
            }
            this.p = playerInfo.isPlaying();
            if (playerInfo.isPlaying()) {
                this.change_play_state.setImageLevel(1);
            } else {
                this.change_play_state.setImageLevel(0);
            }
            B();
        }
    }

    private void a(String str) {
        com.bumptech.glide.i.a((FragmentActivity) this).a(str).b(com.bumptech.glide.load.b.b.ALL).c((int) R.mipmap.float_player_bg).a(new com.fotoable.youtube.music.helper.b(this, 23, 2)).a((com.bumptech.glide.c<String>) new com.bumptech.glide.g.b.g<com.bumptech.glide.load.resource.a.b>() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.12
            @Override // com.bumptech.glide.g.b.j
            /* renamed from: a */
            public void onResourceReady(com.bumptech.glide.load.resource.a.b bVar, com.bumptech.glide.g.a.c<? super com.bumptech.glide.load.resource.a.b> cVar) {
                try {
                    PlayerActivity.this.a(bVar);
                } catch (StackOverflowError e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }

            @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.g.b.j
            public void onLoadFailed(Exception exc, Drawable drawable) {
                super.onLoadFailed(exc, drawable);
                PlayerActivity.this.u();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.bumptech.glide.i.a((FragmentActivity) this).a(Integer.valueOf((int) R.mipmap.float_player_bg)).b(com.bumptech.glide.load.b.b.ALL).c((int) R.mipmap.float_player_bg).a(new com.fotoable.youtube.music.helper.b(this, 23, 2)).a((com.bumptech.glide.c<Integer>) new com.bumptech.glide.g.b.g<com.bumptech.glide.load.resource.a.b>() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.13
            @Override // com.bumptech.glide.g.b.j
            /* renamed from: a */
            public void onResourceReady(com.bumptech.glide.load.resource.a.b bVar, com.bumptech.glide.g.a.c<? super com.bumptech.glide.load.resource.a.b> cVar) {
                try {
                    PlayerActivity.this.a(bVar);
                } catch (StackOverflowError e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }

            @Override // com.bumptech.glide.g.b.a, com.bumptech.glide.g.b.j
            public void onLoadFailed(Exception exc, Drawable drawable) {
                super.onLoadFailed(exc, drawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Drawable drawable) {
        if (drawable != null) {
            if (this.blur_bg.getDrawable() != null) {
                TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{this.blur_bg.getDrawable(), drawable});
                this.blur_bg.setImageDrawable(transitionDrawable);
                transitionDrawable.setCrossFadeEnabled(true);
                transitionDrawable.startTransition(200);
                return;
            }
            this.blur_bg.setImageDrawable(drawable);
        }
    }

    private void v() {
        if (this.j != null) {
            a(this.f3673a.b(com.fotoable.youtube.music.newplayer.a.c.a(this.j)).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.14
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
                    PlayerActivity.this.w = false;
                    if (PlayerActivity.this.w) {
                        PlayerActivity.this.video_favorite_state.setImageLevel(1);
                    } else {
                        PlayerActivity.this.video_favorite_state.setImageLevel(0);
                    }
                }
            }));
        }
    }

    private void w() {
        if (this.j != null) {
            a(this.f3673a.a(com.fotoable.youtube.music.newplayer.a.c.a(this.j)).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.2
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
                    PlayerActivity.this.w = true;
                    if (PlayerActivity.this.w) {
                        PlayerActivity.this.video_favorite_state.setImageLevel(1);
                    } else {
                        PlayerActivity.this.video_favorite_state.setImageLevel(0);
                    }
                }
            }));
        }
    }

    private void x() {
        if (this.j != null) {
            a(this.f3673a.a(this.j.getId()).b(Schedulers.io()).a(rx.a.b.a.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.3
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.l
                public void onStart() {
                    super.onStart();
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                    PlayerActivity.this.w = bool.booleanValue();
                    if (bool.booleanValue()) {
                        PlayerActivity.this.video_favorite_state.setImageLevel(1);
                    } else {
                        PlayerActivity.this.video_favorite_state.setImageLevel(0);
                    }
                }
            }));
        }
    }

    private void y() {
        int i;
        if (this.g == 2) {
            List<PlayMusicModel> b2 = com.fotoable.youtube.music.newplayer.e.a().b();
            i = 0;
            while (i < b2.size()) {
                if (TextUtils.equals(b2.get(i).getVideoId(), this.h.getVideoId())) {
                    break;
                }
                i++;
            }
            i = 0;
        } else if (this.g == 3) {
            List<LocalMusicModel> c2 = com.fotoable.youtube.music.newplayer.e.a().c();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (int i3 = 0; i3 < c2.size(); i3++) {
                sb.append(c2.get(i3).getSongId() + ", ");
                if (c2.get(i3).getSongId() == this.i.getSongId()) {
                    i2 = i3;
                }
            }
            com.fotoable.youtube.music.util.h.a(f, "当前顺序：" + sb.toString());
            i = i2;
        } else {
            if (this.g == 4) {
            }
            i = 0;
        }
        if (this.f3674b.size() > 0) {
            this.view_pager.setCurrentItem(i, false);
            com.fotoable.youtube.music.util.h.a(f, "封面位置position:" + i);
        }
    }

    private void z() {
        if (this.s != null) {
            this.s.cancel();
            this.s = null;
        }
    }

    private void A() {
        if (this.s == null || !this.s.isRunning()) {
            z();
            this.s = ObjectAnimator.ofFloat(this.origin_cover, "rotation", this.origin_cover.getRotation(), this.origin_cover.getRotation() + 360.0f);
            this.s.setDuration(8000L);
            this.s.setRepeatCount(-1);
            this.s.setInterpolator(new LinearInterpolator());
            this.s.start();
        }
    }

    private void B() {
        if (this.t != null) {
            this.t.cancel();
            this.t = null;
        }
        if (!p()) {
            this.change_play_state.setVisibility(0);
            this.change_play_loading.setVisibility(8);
        }
    }

    private void C() {
        com.fotoable.youtube.music.util.h.a(f, "showPlayLoading.....");
        this.change_play_state.setVisibility(8);
        this.change_play_loading.setVisibility(0);
        if (this.s == null || !this.s.isRunning()) {
            if (this.t != null) {
                this.t.cancel();
                this.t = null;
            }
            this.t = ObjectAnimator.ofFloat(this.play_loading, "rotation", 0.0f, 360.0f);
            this.t.setDuration(1500L);
            this.t.setRepeatCount(-1);
            this.t.setInterpolator(new LinearInterpolator());
            this.t.start();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.fotoable.youtube.music.util.h.a(f, "onConfigurationChanged屏幕旋转Player:" + configuration.orientation);
        if (configuration.orientation == 2) {
            com.fotoable.youtube.music.newplayer.e.a().c(1);
        } else if (configuration.orientation == 1) {
            com.fotoable.youtube.music.newplayer.e.a().c(3);
        }
    }

    @OnClick({R.id.back_view, R.id.full_screen, R.id.youtube_player, R.id.video_favorite_state, R.id.video_more_op, R.id.play_back, R.id.play_next, R.id.video_play_list, R.id.change_play_state, R.id.loop_model, R.id.video_comment})
    public void onClick(View view) {
        int i = 0;
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                com.fotoable.youtube.music.util.b.b("播放界面-返回");
                return;
            case R.id.full_screen /* 2131820857 */:
                if (getRequestedOrientation() != 6) {
                    setRequestedOrientation(6);
                } else {
                    com.fotoable.youtube.music.newplayer.e.a().c(1);
                }
                com.fotoable.youtube.music.util.b.b("播放界面-全屏");
                return;
            case R.id.youtube_player /* 2131820863 */:
                if (this.h != null) {
                    try {
                        com.fotoable.youtube.music.newplayer.e.a().b(false);
                        if (YouTubeIntents.canResolvePlayVideoIntent(this)) {
                            Intent createPlayVideoIntentWithOptions = YouTubeIntents.createPlayVideoIntentWithOptions(this, this.h.getVideoId(), true, false);
                            createPlayVideoIntentWithOptions.setFlags(268435456);
                            startActivity(createPlayVideoIntentWithOptions);
                        } else {
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(Uri.parse("https://www.youtube.com/watch?v=" + this.h.getVideoId()));
                            intent.setFlags(268435456);
                            startActivity(intent);
                        }
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                    com.fotoable.youtube.music.util.h.a(f, "youtube_player 使用Youtube播放");
                    com.fotoable.youtube.music.util.b.b("播放界面-跳转到Youtube播放");
                    return;
                }
                return;
            case R.id.video_favorite_state /* 2131820864 */:
                if (this.g == 2) {
                    if (com.fotoable.youtube.music.newplayer.e.a().e() != null) {
                        if (this.w) {
                            E();
                        } else {
                            D();
                        }
                    } else {
                        return;
                    }
                } else if (this.g == 3) {
                    LocalMusicModel f2 = com.fotoable.youtube.music.newplayer.e.a().f();
                    if (f2 != null) {
                        this.f3673a.a(this.w, com.fotoable.youtube.music.newplayer.a.a.a(f2)).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.5
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
                                PlayerActivity.this.w = !PlayerActivity.this.w;
                                if (PlayerActivity.this.w) {
                                    PlayerActivity.this.video_favorite_state.setImageLevel(1);
                                } else {
                                    PlayerActivity.this.video_favorite_state.setImageLevel(0);
                                }
                            }
                        });
                    } else {
                        return;
                    }
                } else if (this.g == 4) {
                    if (this.w) {
                        v();
                    } else {
                        w();
                    }
                }
                com.fotoable.youtube.music.util.b.b("播放界面-修改收藏状态");
                return;
            case R.id.video_comment /* 2131820865 */:
                if (this.h == null) {
                    this.h = com.fotoable.youtube.music.newplayer.e.a().e();
                }
                if (this.h != null) {
                    Intent intent2 = new Intent(this, YoutubeCommentActivity.class);
                    intent2.putExtra("VideoId", "" + this.h.getVideoId());
                    intent2.putExtra("model", this.h);
                    intent2.putExtra(ShareConstants.FEED_SOURCE_PARAM, 1);
                    startActivity(intent2);
                    com.fotoable.youtube.music.util.b.b("播放界面-点击进入评论界面");
                    com.fotoable.youtube.music.a.f(false);
                    if (this.dialog_comment_tips_img.getVisibility() != 8) {
                        this.dialog_comment_tips_img.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            case R.id.video_more_op /* 2131820869 */:
                if (this.g == 2) {
                    PlayMusicModel e2 = com.fotoable.youtube.music.newplayer.e.a().e();
                    if (e2 != null) {
                        new MusicMenuDialog.b(getSupportFragmentManager()).a(e2).a(true).d(true).b(false).a().e();
                    } else {
                        return;
                    }
                } else if (this.g == 3) {
                    LocalMusicModel f3 = com.fotoable.youtube.music.newplayer.e.a().f();
                    if (f3 != null) {
                        new LocalMusicMenuDialog.a(getSupportFragmentManager()).b(true).d(true).c(true).e(true).a(com.fotoable.youtube.music.newplayer.a.a.a(f3)).a().e();
                    } else {
                        return;
                    }
                } else if (this.g == 4) {
                    RadioModel g = com.fotoable.youtube.music.newplayer.e.a().g();
                    if (g != null) {
                        RadioMenuDialog.a(getSupportFragmentManager(), com.fotoable.youtube.music.newplayer.a.c.a(g), false, true);
                    } else {
                        return;
                    }
                }
                com.fotoable.youtube.music.util.b.b("播放界面-更多");
                return;
            case R.id.loop_model /* 2131820873 */:
                if (this.v == 0) {
                    this.v = 1;
                } else if (this.v == 1) {
                    this.v = 2;
                } else if (this.v == 2) {
                    this.v = 0;
                }
                this.loop_model.setImageLevel(this.v);
                com.fotoable.youtube.music.a.b(this.v);
                com.fotoable.youtube.music.newplayer.e.a().f(this.v);
                com.fotoable.youtube.music.util.b.b("播放界面-切换循环模式");
                b(this.v);
                return;
            case R.id.play_back /* 2131820874 */:
                if (this.g == 2 || this.g == 3) {
                    this.k = true;
                    B();
                    com.fotoable.youtube.music.newplayer.e.a().c(false);
                    if (com.fotoable.youtube.music.a.w() != 2) {
                        this.view_pager.setCurrentItem(this.view_pager.getCurrentItem() - 1, true);
                    }
                    com.fotoable.youtube.music.util.b.b("播放界面-上一首");
                    return;
                }
                return;
            case R.id.change_play_state /* 2131820875 */:
                if (this.p) {
                    com.fotoable.youtube.music.newplayer.e.a().b(false);
                    this.p = false;
                    this.change_play_state.setImageLevel(0);
                    if (this.g == 2 || this.g == 3) {
                        while (true) {
                            int i2 = i;
                            if (this.f3674b != null && i2 < this.f3674b.size()) {
                                this.f3674b.get(i2).stopRotation();
                                i = i2 + 1;
                            }
                        }
                    }
                } else {
                    com.fotoable.youtube.music.newplayer.e.a().a(false);
                    this.change_play_state.setImageLevel(1);
                    this.p = true;
                }
                com.fotoable.youtube.music.util.h.a(f, "操作；" + this.p);
                com.fotoable.youtube.music.util.b.b("播放界面-切换播放状态");
                return;
            case R.id.play_next /* 2131820878 */:
                if (this.g == 2 || this.g == 3) {
                    this.k = true;
                    B();
                    com.fotoable.youtube.music.newplayer.e.a().d(false);
                    if (com.fotoable.youtube.music.a.w() != 2) {
                        this.view_pager.setCurrentItem(this.view_pager.getCurrentItem() + 1, true);
                    }
                    com.fotoable.youtube.music.util.b.b("播放界面-下一首");
                    return;
                }
                return;
            case R.id.video_play_list /* 2131820879 */:
                if (this.g == 2 || this.g == 3) {
                    if (this.u == null || !this.u.isAdded()) {
                        this.u = PlayerMusicListDialog.a(getSupportFragmentManager(), this.g, this.h != null ? this.h.getVideoId() : null, this.i != null ? this.i.getSongId() : -1L, new PlayerMusicListDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.4
                            @Override // com.fotoable.youtube.music.ui.dialog.PlayerMusicListDialog.a
                            public void a(List list, int i3) {
                                try {
                                    int currentItem = PlayerActivity.this.view_pager.getCurrentItem();
                                    if (i3 < currentItem) {
                                        currentItem--;
                                    }
                                    if (i3 >= 0 && i3 < PlayerActivity.this.f3674b.size()) {
                                        PlayerActivity.this.f3674b.remove(i3);
                                        PlayerActivity.this.d.notifyDataSetChanged();
                                    }
                                    if (PlayerActivity.this.d != null && currentItem >= 0 && currentItem < PlayerActivity.this.d.getCount()) {
                                        PlayerActivity.this.view_pager.setCurrentItem(currentItem, false);
                                    }
                                } catch (Exception e3) {
                                    ThrowableExtension.printStackTrace(e3);
                                }
                            }

                            @Override // com.fotoable.youtube.music.ui.dialog.PlayerMusicListDialog.a, com.fotoable.youtube.music.ui.dialog.b.a
                            public void a() {
                                super.a();
                                PlayerActivity.this.u = null;
                            }
                        });
                    } else {
                        return;
                    }
                }
                com.fotoable.youtube.music.util.b.b("播放界面-查看播放列表");
                return;
            default:
                return;
        }
    }

    private void D() {
        if (this.h != null) {
            FavBean favBean = new FavBean();
            favBean.setVideoid(this.h.getVideoId());
            favBean.setTitle(this.h.getTitle());
            favBean.setDesc(this.h.getDescription());
            favBean.setImgUrl(this.h.getCoverImg());
            favBean.setArtists(this.h.getArtists());
            this.f3673a.a(favBean);
            a(this.f3673a.a(favBean).b(Schedulers.io()).a(rx.a.b.a.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.6
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
                    PlayerActivity.this.w = true;
                    PlayerActivity.this.h.setFav(true);
                    PlayerActivity.this.video_favorite_state.setImageLevel(1);
                }
            }));
        }
    }

    private void E() {
        if (this.h != null) {
            this.f3673a.c(this.h.getVideoId()).b(Schedulers.io()).a(rx.a.b.a.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.activity.PlayerActivity.7
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
                    PlayerActivity.this.w = false;
                    PlayerActivity.this.h.setFav(false);
                    PlayerActivity.this.video_favorite_state.setImageLevel(0);
                }
            });
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        super.i().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MusicApplication.c().a(true);
        com.fotoable.youtube.music.newplayer.e.a().h(true);
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2402);
        super.onResume();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void c() {
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2402);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MusicApplication.c().a(false);
        com.fotoable.youtube.music.newplayer.e.a().h(false);
        com.fotoable.youtube.music.newplayer.e.a().c(3);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.fotoable.youtube.music.util.h.a(f, "onDestroy");
        MusicApplication.c().a(false);
        try {
            z();
            B();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(long j) {
        long j2 = (j / 60) / 60;
        long j3 = (j - ((j2 * 60) * 60)) / 60;
        long j4 = (j - ((j2 * 60) * 60)) - (60 * j3);
        StringBuffer stringBuffer = new StringBuffer();
        if (j2 > 0) {
            stringBuffer.append(j2);
            stringBuffer.append(":");
        }
        if (j3 > 0) {
            if (j3 < 10) {
                stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuffer.append(j3);
            stringBuffer.append(":");
        } else {
            stringBuffer.append("00:");
        }
        if (j4 > 0) {
            if (j4 < 10) {
                stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuffer.append(j4);
        } else {
            stringBuffer.append("00");
        }
        return stringBuffer.toString();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.widget_dialog_exit_anim_bottom);
    }
}
