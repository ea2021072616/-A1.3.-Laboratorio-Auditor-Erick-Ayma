package com.fotoable.youtube.music.locker.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import com.bumptech.glide.i;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.c.a.h;
import com.fotoable.youtube.music.c.b.af;
import com.fotoable.youtube.music.locker.view.shimmer.ShimmerFrameLayout;
import com.fotoable.youtube.music.newplayer.e;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import com.fotoable.youtube.music.ui.view.MarqueeTextView;
import com.fotoable.youtube.music.util.s;
import com.fotoable.youtube.music.util.v;
import com.google.android.gms.common.ConnectionResult;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import javax.inject.Inject;
import rx.g;
import rx.l;
import rx.m;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class MusicLockerView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2781b = MusicLockerView.class.getSimpleName();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f2782a;
    @BindView(R.id.battery_view)
    BatteryView01 batteryView;
    @BindView(R.id.battery_lock_panel)
    LinearLayout battery_lock_panel;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f2783c;
    private int d;
    private BroadcastReceiver e;
    private boolean f;
    private PlayerInfo g;
    private GestureDetector h;
    private boolean i;
    private rx.g.b j;
    private int k;
    @BindView(R.id.locker_bottom_bar_panel_bg)
    ImageView locker_bottom_bar_panel_bg;
    @BindView(R.id.locker_days)
    TextView locker_days;
    @BindView(R.id.locker_month)
    TextView locker_month;
    @BindView(R.id.locker_time)
    TextView locker_time;
    @BindView(R.id.music_artists)
    TextView music_artists;
    @BindView(R.id.music_cover_panel)
    RelativeLayout music_cover_panel;
    @BindView(R.id.music_info_panel)
    LinearLayout music_info_panel;
    @BindView(R.id.music_title)
    TextView music_title;
    @BindView(R.id.player_cover)
    ImageView player_cover;
    @BindView(R.id.player_fav)
    ImageView player_fav;
    @BindView(R.id.player_next)
    ImageView player_next;
    @BindView(R.id.player_previous)
    ImageView player_previous;
    @BindView(R.id.player_state)
    ImageView player_state;
    @BindView(R.id.radio_cover_img)
    ImageView radio_cover_img;
    @BindView(R.id.radio_cover_panel)
    RelativeLayout radio_cover_panel;
    @BindView(R.id.root_view)
    RelativeLayout root_view;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout shimmer_view_container;
    @BindView(R.id.slide_img)
    ImageView slide_img;
    @BindView(R.id.slide_to_unlock_tv)
    MarqueeTextView slide_to_unlock_tv;
    @BindView(R.id.wallpaper_blur)
    ImageView wallpaper_blur;

    public MusicLockerView(Context context) {
        super(context);
        this.f2783c = new Runnable(this) { // from class: com.fotoable.youtube.music.locker.view.a

            /* renamed from: a  reason: collision with root package name */
            private final MusicLockerView f2818a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2818a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f2818a.a();
            }
        };
        this.e = new BroadcastReceiver() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                char c2;
                String action = intent.getAction();
                if (action != null) {
                    switch (action.hashCode()) {
                        case -1886648615:
                            if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1538406691:
                            if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1454123155:
                            if (action.equals("android.intent.action.SCREEN_ON")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            if (!MusicLockerView.this.g()) {
                                if (!MusicLockerView.this.g()) {
                                    v.b((Context) MusicApplication.c(), com.fotoable.youtube.music.b.n, intent.getIntExtra(com.fotoable.youtube.music.b.n, 0));
                                    v.b((Context) MusicApplication.c(), com.fotoable.youtube.music.b.o, intent.getIntExtra(com.fotoable.youtube.music.b.o, 0));
                                    v.b(MusicApplication.c(), com.fotoable.youtube.music.b.p, MusicLockerView.this.d());
                                    MusicLockerView.this.f();
                                }
                                switch (intent.getIntExtra("status", -1)) {
                                    case 2:
                                        if (MusicLockerView.this.d == 0) {
                                            MusicLockerView.this.d = 1;
                                            if (MusicLockerView.this.batteryView != null) {
                                                MusicLockerView.this.batteryView.b();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 3:
                                        MusicLockerView.this.d = 0;
                                        if (MusicLockerView.this.batteryView != null) {
                                            MusicLockerView.this.batteryView.a();
                                            return;
                                        }
                                        return;
                                    case 4:
                                        MusicLockerView.this.d = 0;
                                        if (MusicLockerView.this.batteryView != null) {
                                            MusicLockerView.this.batteryView.a();
                                            return;
                                        }
                                        return;
                                    case 5:
                                        MusicLockerView.this.d = 0;
                                        if (MusicLockerView.this.batteryView != null) {
                                            MusicLockerView.this.batteryView.a();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                            return;
                        case 1:
                        default:
                            return;
                    }
                }
            }
        };
        this.i = false;
        a(context);
    }

    public MusicLockerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2783c = new Runnable(this) { // from class: com.fotoable.youtube.music.locker.view.b

            /* renamed from: a  reason: collision with root package name */
            private final MusicLockerView f2819a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2819a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f2819a.a();
            }
        };
        this.e = new BroadcastReceiver() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                char c2;
                String action = intent.getAction();
                if (action != null) {
                    switch (action.hashCode()) {
                        case -1886648615:
                            if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1538406691:
                            if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1454123155:
                            if (action.equals("android.intent.action.SCREEN_ON")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            if (!MusicLockerView.this.g()) {
                                if (!MusicLockerView.this.g()) {
                                    v.b((Context) MusicApplication.c(), com.fotoable.youtube.music.b.n, intent.getIntExtra(com.fotoable.youtube.music.b.n, 0));
                                    v.b((Context) MusicApplication.c(), com.fotoable.youtube.music.b.o, intent.getIntExtra(com.fotoable.youtube.music.b.o, 0));
                                    v.b(MusicApplication.c(), com.fotoable.youtube.music.b.p, MusicLockerView.this.d());
                                    MusicLockerView.this.f();
                                }
                                switch (intent.getIntExtra("status", -1)) {
                                    case 2:
                                        if (MusicLockerView.this.d == 0) {
                                            MusicLockerView.this.d = 1;
                                            if (MusicLockerView.this.batteryView != null) {
                                                MusicLockerView.this.batteryView.b();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 3:
                                        MusicLockerView.this.d = 0;
                                        if (MusicLockerView.this.batteryView != null) {
                                            MusicLockerView.this.batteryView.a();
                                            return;
                                        }
                                        return;
                                    case 4:
                                        MusicLockerView.this.d = 0;
                                        if (MusicLockerView.this.batteryView != null) {
                                            MusicLockerView.this.batteryView.a();
                                            return;
                                        }
                                        return;
                                    case 5:
                                        MusicLockerView.this.d = 0;
                                        if (MusicLockerView.this.batteryView != null) {
                                            MusicLockerView.this.batteryView.a();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                            return;
                        case 1:
                        default:
                            return;
                    }
                }
            }
        };
        this.i = false;
    }

    public MusicLockerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2783c = new Runnable(this) { // from class: com.fotoable.youtube.music.locker.view.c

            /* renamed from: a  reason: collision with root package name */
            private final MusicLockerView f2820a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2820a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f2820a.a();
            }
        };
        this.e = new BroadcastReceiver() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                char c2;
                String action = intent.getAction();
                if (action != null) {
                    switch (action.hashCode()) {
                        case -1886648615:
                            if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1538406691:
                            if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1454123155:
                            if (action.equals("android.intent.action.SCREEN_ON")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            if (!MusicLockerView.this.g()) {
                                if (!MusicLockerView.this.g()) {
                                    v.b((Context) MusicApplication.c(), com.fotoable.youtube.music.b.n, intent.getIntExtra(com.fotoable.youtube.music.b.n, 0));
                                    v.b((Context) MusicApplication.c(), com.fotoable.youtube.music.b.o, intent.getIntExtra(com.fotoable.youtube.music.b.o, 0));
                                    v.b(MusicApplication.c(), com.fotoable.youtube.music.b.p, MusicLockerView.this.d());
                                    MusicLockerView.this.f();
                                }
                                switch (intent.getIntExtra("status", -1)) {
                                    case 2:
                                        if (MusicLockerView.this.d == 0) {
                                            MusicLockerView.this.d = 1;
                                            if (MusicLockerView.this.batteryView != null) {
                                                MusicLockerView.this.batteryView.b();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 3:
                                        MusicLockerView.this.d = 0;
                                        if (MusicLockerView.this.batteryView != null) {
                                            MusicLockerView.this.batteryView.a();
                                            return;
                                        }
                                        return;
                                    case 4:
                                        MusicLockerView.this.d = 0;
                                        if (MusicLockerView.this.batteryView != null) {
                                            MusicLockerView.this.batteryView.a();
                                            return;
                                        }
                                        return;
                                    case 5:
                                        MusicLockerView.this.d = 0;
                                        if (MusicLockerView.this.batteryView != null) {
                                            MusicLockerView.this.batteryView.a();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                            return;
                        case 1:
                        default:
                            return;
                    }
                }
            }
        };
        this.i = false;
    }

    private void a(Context context) {
        b(context);
        inflate(context, R.layout.view_music_locker, this);
        ButterKnife.bind(this);
        i();
        this.slide_to_unlock_tv.setAutoScroll(true);
        this.slide_to_unlock_tv.setText(getResources().getString(R.string.slide_to_unlock));
        b();
    }

    private void b() {
        this.shimmer_view_container.setDuration(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        this.shimmer_view_container.setRepeatMode(-1);
        this.shimmer_view_container.setAngle(ShimmerFrameLayout.b.CW_270);
        this.shimmer_view_container.setMaskShape(ShimmerFrameLayout.c.LINEAR);
    }

    private void c() {
        e();
        if (this.battery_lock_panel.getVisibility() != 0) {
            this.battery_lock_panel.setVisibility(0);
            this.music_info_panel.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        int a2 = v.a((Context) MusicApplication.c(), com.fotoable.youtube.music.b.n, 0);
        return a2 == 2 || a2 == 5;
    }

    private void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        getContext().registerReceiver(this.e, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.batteryView != null) {
            this.batteryView.a(d(), v.a((Context) MusicApplication.c(), com.fotoable.youtube.music.b.o, 0), v.a((Context) MusicApplication.c(), com.fotoable.youtube.music.b.q, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void a() {
        if (this.locker_time != null) {
            this.locker_time.removeCallbacks(this.f2783c);
            this.locker_time.setText(com.fotoable.youtube.music.locker.a.a.a(System.currentTimeMillis()));
            this.locker_month.setText(com.fotoable.youtube.music.locker.a.a.b(System.currentTimeMillis()));
            this.locker_days.setText(com.fotoable.youtube.music.locker.a.a.c(System.currentTimeMillis()));
            this.locker_time.postDelayed(this.f2783c, 1000L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        this.f = false;
        if (this.shimmer_view_container != null) {
            this.shimmer_view_container.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f = true;
        try {
            removeCallbacks(this.f2783c);
            if (this.shimmer_view_container != null) {
                this.shimmer_view_container.c();
            }
            if (this.e != null) {
                getContext().unregisterReceiver(this.e);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.locker_logo})
    @Optional
    public void onLockerLogoClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.player_previous})
    @Optional
    public void onPlayerPreviousClick(View view) {
        e.a().c(false);
        com.fotoable.youtube.music.util.b.b("音乐锁屏-点击上一首");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.player_state})
    @Optional
    public void onPlayerStateClick(View view) {
        if (this.g != null && this.g.isPlaying()) {
            e.a().b(false);
        } else {
            e.a().a(false);
        }
        com.fotoable.youtube.music.util.b.b("音乐锁屏-切换播放状态");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.player_next})
    @Optional
    public void onPlayerNextClick(View view) {
        e.a().d(false);
        com.fotoable.youtube.music.util.b.b("音乐锁屏-点击下一首");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.menu_more})
    @Optional
    public void onClick(View view) {
        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2019));
        if (this.k == 1) {
            com.fotoable.youtube.music.util.b.b("充电锁屏-点击更多");
        } else if (this.k == 2) {
            com.fotoable.youtube.music.util.b.b("音乐锁屏-点击更多");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.player_fav})
    @Optional
    public void onPlayerFavClick(View view) {
        if (this.g != null) {
            if (this.g.isLocalPlayer()) {
                j();
            } else if (this.g.isRadioPlayer()) {
                if (this.i) {
                    k();
                } else {
                    l();
                }
            }
            com.fotoable.youtube.music.util.b.b("音乐锁屏-切换收藏状态");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    private void i() {
        if (this.h == null) {
            this.h = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView.2
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (motionEvent != null && motionEvent2 != null && MusicLockerView.this.h != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) MusicLockerView.this.root_view.getLayoutParams();
                        layoutParams.bottomMargin += (int) f2;
                        layoutParams.topMargin = -layoutParams.bottomMargin;
                        if (layoutParams.bottomMargin < 0) {
                            layoutParams.bottomMargin = 0;
                        }
                        if (layoutParams.topMargin > 0) {
                            layoutParams.topMargin = 0;
                        }
                        MusicLockerView.this.root_view.setLayoutParams(layoutParams);
                    }
                    return false;
                }
            });
        }
    }

    public void a(LocalMusicModel localMusicModel) {
        if (this.music_info_panel.getVisibility() != 0) {
            this.music_info_panel.setVisibility(0);
            this.battery_lock_panel.setVisibility(8);
        }
        this.music_title.setText(localMusicModel.getSongName() + "");
        if (!TextUtils.isEmpty(localMusicModel.getArtistName())) {
            this.music_artists.setText(localMusicModel.getArtistName() + "");
            this.music_artists.setVisibility(0);
        } else {
            this.music_artists.setVisibility(4);
        }
        a(localMusicModel.getAlbumData());
        if (this.music_cover_panel.getVisibility() != 0) {
            this.radio_cover_panel.setVisibility(8);
            this.music_cover_panel.setVisibility(0);
        }
        this.player_previous.setVisibility(0);
        this.player_next.setVisibility(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.player_fav.getLayoutParams();
        marginLayoutParams.leftMargin = (int) (getResources().getDisplayMetrics().density * 22.0f);
        this.player_fav.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.player_state.getLayoutParams();
        marginLayoutParams2.leftMargin = (int) (getResources().getDisplayMetrics().density * 22.0f);
        this.player_state.setLayoutParams(marginLayoutParams2);
    }

    public void a(RadioModel radioModel) {
        this.music_title.setText(radioModel.getTitle() + "");
        this.music_artists.setVisibility(4);
        i.c(getContext()).a(radioModel.getImgUrl()).d((int) R.mipmap.icon_radio_default).c((int) R.mipmap.icon_radio_default).i().b(com.bumptech.glide.load.b.b.ALL).a(this.radio_cover_img);
        if (this.radio_cover_panel.getVisibility() != 0) {
            this.radio_cover_panel.setVisibility(0);
            this.music_cover_panel.setVisibility(8);
        }
        this.player_previous.setVisibility(8);
        this.player_next.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.player_state.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        this.player_state.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.player_fav.getLayoutParams();
        marginLayoutParams2.leftMargin = (int) (67.0f * getResources().getDisplayMetrics().density);
        this.player_fav.setLayoutParams(marginLayoutParams2);
    }

    public void a(PlayerInfo playerInfo) {
        if (playerInfo != null && playerInfo.isPlaying()) {
            this.player_state.setImageLevel(1);
        } else {
            this.player_state.setImageLevel(0);
        }
        if (this.g != null && playerInfo != null && ((this.g.isLocalPlayer() && playerInfo.isLocalPlayer() && this.g.getSongId() == playerInfo.getSongId()) || (this.g.isRadioPlayer() && playerInfo.isRadioPlayer() && this.g.getRadioId() == playerInfo.getRadioId()))) {
            this.g = playerInfo;
            return;
        }
        this.g = playerInfo;
        this.music_title.setText(playerInfo.getMusicName() + "");
        if (!TextUtils.isEmpty(playerInfo.getArtistsName())) {
            this.music_artists.setText(playerInfo.getArtistsName() + "");
            this.music_artists.setVisibility(0);
        } else {
            this.music_artists.setVisibility(4);
        }
        if (playerInfo.isLocalPlayer()) {
            a(playerInfo.getCoverImg());
            this.player_previous.setVisibility(0);
            this.player_next.setVisibility(0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.player_fav.getLayoutParams();
            marginLayoutParams.leftMargin = (int) (getResources().getDisplayMetrics().density * 22.0f);
            this.player_fav.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.player_state.getLayoutParams();
            marginLayoutParams2.leftMargin = (int) (getResources().getDisplayMetrics().density * 22.0f);
            this.player_state.setLayoutParams(marginLayoutParams2);
            if (this.music_cover_panel.getVisibility() != 0) {
                this.radio_cover_panel.setVisibility(8);
                this.music_cover_panel.setVisibility(0);
            }
        } else if (playerInfo.isRadioPlayer()) {
            i.c(getContext()).a(playerInfo.getCoverImg()).i().b(com.bumptech.glide.load.b.b.ALL).a(this.radio_cover_img);
            this.player_previous.setVisibility(8);
            this.player_next.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.player_state.getLayoutParams();
            marginLayoutParams3.leftMargin = 0;
            this.player_state.setLayoutParams(marginLayoutParams3);
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.player_fav.getLayoutParams();
            marginLayoutParams4.leftMargin = (int) (67.0f * getResources().getDisplayMetrics().density);
            this.player_fav.setLayoutParams(marginLayoutParams4);
            if (this.radio_cover_panel.getVisibility() != 0) {
                this.radio_cover_panel.setVisibility(0);
                this.music_cover_panel.setVisibility(8);
            }
        }
        if (playerInfo.isLocalPlayer()) {
            a(playerInfo.getSongId());
        } else if (playerInfo.isRadioPlayer()) {
            a(playerInfo.getRadioId());
        }
    }

    private void b(Context context) {
        h.a().a(MusicApplication.c().e()).a(new af(context)).a().a(this);
    }

    public void a(long j) {
        if (j != 0) {
            a(this.f2782a.f(Long.valueOf(j)).a(s.a()).b(new l<Boolean>() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView.3
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
                    if (bool.booleanValue()) {
                        MusicLockerView.this.player_fav.setImageLevel(1);
                        MusicLockerView.this.i = true;
                        return;
                    }
                    MusicLockerView.this.player_fav.setImageLevel(0);
                    MusicLockerView.this.i = false;
                }
            }));
        }
    }

    private void j() {
        LocalMusicModel f = e.a().f();
        if (f != null) {
            a(this.f2782a.a(this.i, com.fotoable.youtube.music.newplayer.a.a.a(f)).a(s.a()).b(new l<Boolean>() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView.4
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
                    MusicLockerView.this.i = !MusicLockerView.this.i;
                    if (MusicLockerView.this.i) {
                        MusicLockerView.this.player_fav.setImageLevel(1);
                    } else {
                        MusicLockerView.this.player_fav.setImageLevel(0);
                    }
                }
            }));
        }
    }

    private void k() {
        RadioModel g = e.a().g();
        if (g != null) {
            a(this.f2782a.b(com.fotoable.youtube.music.newplayer.a.c.a(g)).a(s.a()).a(new g<Boolean>() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView.5
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
                    MusicLockerView.this.i = false;
                    if (MusicLockerView.this.i) {
                        MusicLockerView.this.player_fav.setImageLevel(1);
                    } else {
                        MusicLockerView.this.player_fav.setImageLevel(0);
                    }
                }
            }));
        }
    }

    private void l() {
        RadioModel g = e.a().g();
        if (g != null) {
            a(this.f2782a.a(com.fotoable.youtube.music.newplayer.a.c.a(g)).a(s.a()).a(new g<Boolean>() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView.6
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
                    MusicLockerView.this.i = true;
                    if (MusicLockerView.this.i) {
                        MusicLockerView.this.player_fav.setImageLevel(1);
                    } else {
                        MusicLockerView.this.player_fav.setImageLevel(0);
                    }
                }
            }));
        }
    }

    private void a(int i) {
        if (i >= 0) {
            a(this.f2782a.a(i).b(Schedulers.io()).a(rx.a.b.a.a()).b(new l<Boolean>() { // from class: com.fotoable.youtube.music.locker.view.MusicLockerView.7
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
                    if (bool.booleanValue()) {
                        MusicLockerView.this.player_fav.setImageLevel(1);
                        MusicLockerView.this.i = true;
                        return;
                    }
                    MusicLockerView.this.player_fav.setImageLevel(0);
                    MusicLockerView.this.i = false;
                }
            }));
        }
    }

    private void setDrawable2(Drawable drawable) {
        if (drawable != null) {
            if (this.player_cover.getDrawable() != null) {
                TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{this.player_cover.getDrawable(), drawable});
                this.player_cover.setImageDrawable(transitionDrawable);
                transitionDrawable.setCrossFadeEnabled(true);
                transitionDrawable.startTransition(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                return;
            }
            this.player_cover.setImageDrawable(drawable);
        }
    }

    private void a(String str) {
        i.c(getContext()).a(str).b(com.bumptech.glide.load.b.b.ALL).c((int) R.drawable.locker_music_def_cover).i().a(this.player_cover);
    }

    private void setDrawable(Drawable drawable) {
        if (drawable != null) {
            if (this.wallpaper_blur.getDrawable() != null) {
                TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{this.wallpaper_blur.getDrawable(), drawable});
                this.wallpaper_blur.setImageDrawable(transitionDrawable);
                transitionDrawable.setCrossFadeEnabled(true);
                transitionDrawable.startTransition(200);
                return;
            }
            this.wallpaper_blur.setImageDrawable(drawable);
        }
    }

    protected void a(m mVar) {
        if (this.j == null) {
            this.j = new rx.g.b();
        }
        this.j.a(mVar);
    }

    public void setType(int i) {
        this.k = i;
        if (this.k == 1) {
            c();
        } else if (this.k == 2 && this.music_info_panel.getVisibility() != 0) {
            this.battery_lock_panel.setVisibility(8);
            this.music_info_panel.setVisibility(0);
        }
    }
}
