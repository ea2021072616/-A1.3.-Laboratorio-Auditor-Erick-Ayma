package com.fotoable.youtube.music.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import com.fotoable.youtube.music.quicktools.service.QuickToolsService;
import com.fotoable.youtube.music.ui.activity.PlayerActivity;
import com.fotoable.youtube.music.ui.dialog.FloatPermissionDialog;
import com.fotoable.youtube.music.ui.dialog.PlayerMusicListDialog;
import com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog;
import com.fotoable.youtube.music.ui.view.CircleProgressView;
import com.fotoable.youtube.music.ui.view.MarqueeTextView;
import com.fotoable.youtube.music.util.o;
import com.fotoable.youtube.music.util.r;
import com.fotoable.youtube.music.util.s;
import com.fotoable.youtube.music.util.w;
import com.google.android.youtube.player.YouTubeIntents;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import rx.l;
import rx.m;
/* loaded from: classes.dex */
public abstract class BaseActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2302a = BaseActivity.class.getSimpleName();
    private CircleProgressView A;
    private ImageView B;
    private ImageView C;
    private boolean F;
    private PlayerInfo G;
    private PlayerMusicListDialog H;
    private rx.g.b K;
    private int L;

    /* renamed from: b  reason: collision with root package name */
    private Unbinder f2303b;
    private PlayMusicModel e;
    private List<PlayMusicModel> f;
    private LocalMusicModel g;
    private List<LocalMusicModel> h;
    private RadioModel i;
    private List<RadioModel> j;
    private MarqueeTextView m;
    private TextView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private CircleProgressView r;
    private RelativeLayout s;
    private RelativeLayout t;
    private ImageView u;
    private RelativeLayout v;
    private ImageView w;
    private MarqueeTextView x;
    private LinearLayout y;
    private RelativeLayout z;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2304c = false;
    private int d = -1;
    private int k = -1;
    private boolean l = false;
    private boolean D = false;
    private boolean E = true;
    private Handler I = new Handler();
    private boolean J = false;

    public abstract void a(@Nullable Bundle bundle);

    public abstract boolean f();

    public abstract int g();

    public abstract void h();

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        this.f2304c = false;
        a();
        com.fotoable.youtube.music.c.a.b y = y();
        if (y != null) {
            y.a(this);
        }
        h();
        setContentView(g());
        this.E = f();
        this.f2303b = ButterKnife.bind(this);
        a(bundle);
        a(getIntent());
        if (this.E) {
            r();
        }
    }

    public void a() {
        try {
            requestWindowFeature(1);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.getDecorView().setSystemUiVisibility(1280);
            if (Build.VERSION.SDK_INT >= 21) {
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                return;
            }
            window.addFlags(67108864);
        }
    }

    private void r() {
        this.m = (MarqueeTextView) findViewById(R.id.music_name);
        this.n = (TextView) findViewById(R.id.music_artists);
        this.o = (ImageView) findViewById(R.id.play_state);
        this.p = (ImageView) findViewById(R.id.music_cover);
        this.q = (ImageView) findViewById(R.id.music_cover2);
        this.r = (CircleProgressView) findViewById(R.id.play_progress);
        this.s = (RelativeLayout) findViewById(R.id.play_panel);
        this.t = (RelativeLayout) findViewById(R.id.bottom_player_panel);
        this.u = (ImageView) findViewById(R.id.play_list);
        this.u.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.base.a

            /* renamed from: a  reason: collision with root package name */
            private final BaseActivity f2312a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2312a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f2312a.h(view);
            }
        });
        this.o.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.base.b

            /* renamed from: a  reason: collision with root package name */
            private final BaseActivity f2313a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2313a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f2313a.g(view);
            }
        });
        this.t.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.base.c

            /* renamed from: a  reason: collision with root package name */
            private final BaseActivity f2314a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2314a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f2314a.f(view);
            }
        });
        this.v = (RelativeLayout) findViewById(R.id.bottom_player_youtube_panel);
        this.w = (ImageView) findViewById(R.id.music_cover_youtube);
        this.x = (MarqueeTextView) findViewById(R.id.music_name_youtube);
        this.y = (LinearLayout) findViewById(R.id.to_youtube_panel);
        this.z = (RelativeLayout) findViewById(R.id.play_panel_youtube);
        this.A = (CircleProgressView) findViewById(R.id.play_progress_youtube);
        this.B = (ImageView) findViewById(R.id.play_state_youtube);
        this.C = (ImageView) findViewById(R.id.play_list_youtube);
        this.C.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.base.d

            /* renamed from: a  reason: collision with root package name */
            private final BaseActivity f2315a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2315a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f2315a.e(view);
            }
        });
        this.B.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.base.e

            /* renamed from: a  reason: collision with root package name */
            private final BaseActivity f2316a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2316a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f2316a.d(view);
            }
        });
        this.v.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.base.f

            /* renamed from: a  reason: collision with root package name */
            private final BaseActivity f2317a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2317a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f2317a.c(view);
            }
        });
        this.x.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.base.g

            /* renamed from: a  reason: collision with root package name */
            private final BaseActivity f2318a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2318a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f2318a.b(view);
            }
        });
        this.y.setOnClickListener(new View.OnClickListener(this) { // from class: com.fotoable.youtube.music.base.h

            /* renamed from: a  reason: collision with root package name */
            private final BaseActivity f2319a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2319a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f2319a.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(View view) {
        s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(View view) {
        s();
    }

    private void s() {
        if (this.G != null) {
            try {
                if (YouTubeIntents.canResolvePlayVideoIntent(this)) {
                    Intent createPlayVideoIntentWithOptions = YouTubeIntents.createPlayVideoIntentWithOptions(this, this.G.getVideoId(), true, false);
                    createPlayVideoIntentWithOptions.setFlags(268435456);
                    startActivity(createPlayVideoIntentWithOptions);
                } else {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=" + this.G.getVideoId()));
                    intent.setFlags(268435456);
                    startActivity(intent);
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public void b() {
        if (!com.fotoable.youtube.music.a.k()) {
        }
        com.fotoable.youtube.music.util.h.a(f2302a, "changePlayerPosition");
        if (!MusicApplication.c().d()) {
            com.fotoable.youtube.music.newplayer.e.a().e(true);
            c();
            return;
        }
        com.fotoable.youtube.music.newplayer.e.a().e(false);
    }

    public void c() {
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2401);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    private void a(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("open_page");
            if (!TextUtils.isEmpty(stringExtra)) {
                com.fotoable.youtube.music.util.h.a(f2302a, "toPage:" + stringExtra);
                if (TextUtils.equals(stringExtra, "player")) {
                    int d = com.fotoable.youtube.music.newplayer.e.a().d();
                    if (d == 2 || d == 3 || d == 4) {
                        this.D = true;
                        MusicApplication.c().a(true);
                        startActivity(new Intent(this, PlayerActivity.class));
                        overridePendingTransition(R.anim.widget_dialog_enter_anim, 0);
                        com.fotoable.youtube.music.util.h.a(f2302a, "跳转到播放界面");
                    }
                }
            }
        }
    }

    public void d() {
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class).a(s.a()).b(new l<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.base.BaseActivity.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                if (th != null) {
                    ThrowableExtension.printStackTrace(th);
                    com.fotoable.youtube.music.util.h.a(BaseActivity.f2302a, "" + th.toString());
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(com.fotoable.youtube.music.e.a aVar) {
                BaseActivity.this.b(aVar);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.l = true;
        b();
        if (this.E) {
            a(com.fotoable.youtube.music.newplayer.d.a().b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.l = false;
    }

    public boolean e() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.fotoable.youtube.music.e.a aVar) {
        if (aVar != null) {
            if (this.l) {
                switch (aVar.f2726a) {
                    case AdError.INTERNAL_ERROR_CODE /* 2001 */:
                        if (aVar.f2727b != null && ((aVar.f2727b instanceof List) || (aVar.f2727b instanceof ArrayList))) {
                            List list = (List) aVar.f2727b;
                            if (list.size() > 0) {
                                if (list.get(0) instanceof PlayMusicModel) {
                                    this.f = (List) aVar.f2727b;
                                    this.k = aVar.d;
                                    this.d = 1;
                                    u();
                                    break;
                                } else {
                                    d(aVar);
                                    break;
                                }
                            }
                        } else {
                            d(aVar);
                            break;
                        }
                        break;
                    case 2002:
                        if (aVar.f2727b != null && (aVar.f2727b instanceof PlayMusicModel)) {
                            this.e = (PlayMusicModel) aVar.f2727b;
                            this.d = 2;
                            u();
                            break;
                        } else {
                            d(aVar);
                            break;
                        }
                        break;
                    case 2003:
                        if (aVar.f2727b != null && (aVar.f2727b instanceof PlayMusicModel)) {
                            this.e = (PlayMusicModel) aVar.f2727b;
                            this.d = 3;
                            u();
                            break;
                        } else {
                            d(aVar);
                            break;
                        }
                        break;
                    case 2004:
                        if ((aVar.f2727b != null && (aVar.f2727b instanceof List)) || (aVar.f2727b instanceof ArrayList)) {
                            List list2 = (List) aVar.f2727b;
                            if (list2.size() > 0) {
                                if (list2.get(0) instanceof PlayMusicModel) {
                                    this.f = (List) aVar.f2727b;
                                    this.d = 4;
                                    u();
                                    break;
                                } else {
                                    d(aVar);
                                    break;
                                }
                            }
                        } else {
                            d(aVar);
                            break;
                        }
                        break;
                    case 2101:
                        if (aVar.f2727b != null && ((aVar.f2727b instanceof List) || (aVar.f2727b instanceof ArrayList))) {
                            List list3 = (List) aVar.f2727b;
                            if (list3.size() > 0) {
                                if (list3.get(0) instanceof LocalMusicModel) {
                                    this.h = (List) aVar.f2727b;
                                    this.k = aVar.d;
                                    this.d = 17;
                                    v();
                                    break;
                                } else {
                                    d(aVar);
                                    break;
                                }
                            }
                        } else {
                            d(aVar);
                            break;
                        }
                        break;
                    case 2102:
                        if (aVar.f2727b != null && (aVar.f2727b instanceof PlayMusicModel)) {
                            this.e = (PlayMusicModel) aVar.f2727b;
                            this.d = 18;
                            v();
                            break;
                        } else {
                            d(aVar);
                            break;
                        }
                        break;
                    case 2103:
                        if (aVar.f2727b != null && (aVar.f2727b instanceof PlayMusicModel)) {
                            this.e = (PlayMusicModel) aVar.f2727b;
                            this.d = 19;
                            v();
                            break;
                        } else {
                            d(aVar);
                            break;
                        }
                        break;
                    case 2104:
                        if ((aVar.f2727b != null && (aVar.f2727b instanceof List)) || (aVar.f2727b instanceof ArrayList)) {
                            List list4 = (List) aVar.f2727b;
                            if (list4.size() > 0) {
                                if (list4.get(0) instanceof LocalMusicModel) {
                                    this.h = (List) aVar.f2727b;
                                    this.d = 20;
                                    v();
                                    break;
                                } else {
                                    d(aVar);
                                    break;
                                }
                            }
                        } else {
                            d(aVar);
                            break;
                        }
                        break;
                    case 2201:
                        if (aVar.f2727b != null && (aVar.f2727b instanceof RadioModel)) {
                            this.i = (RadioModel) aVar.f2727b;
                            this.d = 33;
                            t();
                            break;
                        } else {
                            d(aVar);
                            break;
                        }
                    case 2204:
                        if (aVar.f2727b != null && ((aVar.f2727b instanceof List) || (aVar.f2727b instanceof ArrayList))) {
                            List list5 = (List) aVar.f2727b;
                            if (list5.size() > 0) {
                                if (list5.get(0) instanceof RadioModel) {
                                    this.j = (List) aVar.f2727b;
                                    this.k = aVar.d;
                                    this.d = 36;
                                    t();
                                    break;
                                } else {
                                    d(aVar);
                                    break;
                                }
                            }
                        } else {
                            d(aVar);
                            break;
                        }
                        break;
                }
            }
            if (this.E) {
                c(aVar);
            }
            a(aVar);
        }
    }

    private void c(com.fotoable.youtube.music.e.a aVar) {
        if (aVar != null) {
            switch (aVar.f2726a) {
                case 2005:
                    a((PlayerInfo) aVar.f2727b);
                    return;
                case 2006:
                    a((PlayerInfo) null);
                    return;
                case 2007:
                case 2008:
                case 2009:
                default:
                    return;
                case 2010:
                    if (aVar.d == 771) {
                        a((PlayerInfo) aVar.f2727b);
                        return;
                    } else {
                        this.m.setText(R.string.welcome_to_freemusic_tube_enjoy_your_music);
                        return;
                    }
            }
        }
    }

    public void a(int i) {
    }

    private void a(PlayerInfo playerInfo) {
        int d = com.fotoable.youtube.music.newplayer.e.a().d();
        if (d != 2 && d != 3 && d != 4) {
            this.G = null;
            playerInfo = null;
        }
        if (this.G != null && playerInfo != null && ((this.G.isYoutubePlayer() && playerInfo.isYoutubePlayer() && TextUtils.equals(this.G.getVideoId(), playerInfo.getVideoId())) || ((this.G.isLocalPlayer() && playerInfo.isLocalPlayer() && this.G.getSongId() == playerInfo.getSongId()) || (this.G.isRadioPlayer() && playerInfo.isRadioPlayer() && this.G.getRadioId() == playerInfo.getRadioId())))) {
            this.G = playerInfo;
            if (playerInfo.isPlaying()) {
                if (this.G.isYoutubePlayer()) {
                    this.B.setImageLevel(1);
                } else {
                    this.o.setImageLevel(1);
                }
            } else if (this.G.isYoutubePlayer()) {
                this.B.setImageLevel(0);
            } else {
                this.o.setImageLevel(0);
            }
            if (this.G.isYoutubePlayer()) {
                this.A.setTotalProgress((float) playerInfo.getTotalTime());
                this.A.setCurrentProgress((float) playerInfo.getCurrentTime());
                if (this.v.getVisibility() != 0) {
                    this.v.setVisibility(0);
                    a(100);
                }
                if (this.t.getVisibility() != 8) {
                    this.t.setVisibility(8);
                    return;
                }
                return;
            }
            this.r.setTotalProgress((float) playerInfo.getTotalTime());
            this.r.setCurrentProgress((float) playerInfo.getCurrentTime());
            if (this.t.getVisibility() != 0) {
                this.t.setVisibility(0);
                a(56);
            }
            if (this.v.getVisibility() != 8) {
                this.v.setVisibility(8);
                return;
            }
            return;
        }
        this.G = playerInfo;
        if (playerInfo != null) {
            if (this.G.isYoutubePlayer()) {
                if (!TextUtils.isEmpty(playerInfo.getMusicName())) {
                    this.x.setText(playerInfo.getMusicName() + "");
                } else {
                    this.x.setText(getString(R.string.welcome_to_freemusic_tube_enjoy_your_music));
                }
            } else {
                if (!TextUtils.isEmpty(playerInfo.getArtistsName())) {
                    this.n.setText(playerInfo.getArtistsName());
                    if (this.n.getVisibility() != 0) {
                        this.n.setVisibility(0);
                    }
                } else if (this.n.getVisibility() != 8) {
                    this.n.setVisibility(8);
                }
                if (!TextUtils.isEmpty(playerInfo.getMusicName())) {
                    this.m.setText(playerInfo.getMusicName() + "");
                } else {
                    this.m.setText(getString(R.string.welcome_to_freemusic_tube_enjoy_your_music));
                }
            }
            if (playerInfo.isYoutubePlayer()) {
                if (playerInfo.isPlaying()) {
                    this.B.setImageLevel(1);
                    this.w.setVisibility(4);
                } else {
                    this.B.setImageLevel(0);
                    this.w.setVisibility(0);
                }
                this.F = playerInfo.isPlaying();
                if (this.H != null) {
                    this.H.a(playerInfo.getVideoId());
                }
                this.q.setVisibility(8);
                com.bumptech.glide.i.a((FragmentActivity) this).a(playerInfo.getCoverImg()).c((int) R.mipmap.pic_recently).a(this.w);
                this.A.setTotalProgress((float) playerInfo.getTotalTime());
                this.A.setCurrentProgress((float) playerInfo.getCurrentTime());
                if (this.C.getVisibility() != 0) {
                    this.C.setVisibility(0);
                }
                if (this.v.getVisibility() != 0) {
                    this.v.setVisibility(0);
                    a(100);
                }
                if (this.t.getVisibility() != 8) {
                    this.t.setVisibility(8);
                    return;
                }
                return;
            } else if (playerInfo.isLocalPlayer()) {
                if (playerInfo.isPlaying()) {
                    this.o.setImageLevel(1);
                } else {
                    this.o.setImageLevel(0);
                }
                this.F = playerInfo.isPlaying();
                if (this.H != null) {
                    this.H.a(playerInfo.getSongId());
                }
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                com.bumptech.glide.i.a((FragmentActivity) this).a(playerInfo.getCoverImg()).c((int) R.mipmap.icon_bigplaylistdefault).a(this.q);
                this.r.setTotalProgress((float) playerInfo.getTotalTime());
                this.r.setCurrentProgress((float) playerInfo.getCurrentTime());
                if (this.u.getVisibility() != 0) {
                    this.u.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.s.getLayoutParams();
                    layoutParams.rightMargin = (int) (16.0f * getResources().getDisplayMetrics().density);
                    this.s.setLayoutParams(layoutParams);
                }
                if (this.t.getVisibility() != 0) {
                    this.t.setVisibility(0);
                    a(56);
                }
                if (this.v.getVisibility() != 8) {
                    this.v.setVisibility(8);
                    return;
                }
                return;
            } else if (playerInfo.isRadioPlayer()) {
                com.fotoable.youtube.music.util.h.a(f2302a, "更新Radio信息...");
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                com.bumptech.glide.i.a((FragmentActivity) this).a(playerInfo.getCoverImg()).c((int) R.mipmap.icon_bigplaylistdefault).i().a(this.p);
                if (playerInfo.isPlaying()) {
                    this.o.setImageLevel(1);
                } else {
                    this.o.setImageLevel(0);
                }
                if (playerInfo.isError()) {
                    Toast.makeText(this, (int) R.string.error_player_msg, 0).show();
                }
                this.r.setTotalProgress((float) playerInfo.getTotalTime());
                this.r.setCurrentProgress((float) playerInfo.getCurrentTime());
                if (this.u.getVisibility() != 8) {
                    this.u.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.s.getLayoutParams();
                    layoutParams2.rightMargin = (int) (28.0f * getResources().getDisplayMetrics().density);
                    this.s.setLayoutParams(layoutParams2);
                }
                if (this.t.getVisibility() != 0) {
                    this.t.setVisibility(0);
                    a(56);
                }
                if (this.v.getVisibility() != 8) {
                    this.v.setVisibility(8);
                    return;
                }
                return;
            } else {
                com.fotoable.youtube.music.util.h.a(f2302a, "未实现此类播放器，" + playerInfo.getPlayerType());
                return;
            }
        }
        if (this.n.getVisibility() != 8) {
            this.n.setVisibility(8);
        }
        com.fotoable.youtube.music.util.h.a(f2302a, "接收到一个空状态消息.....");
        this.m.setText(getString(R.string.welcome_to_freemusic_tube_enjoy_your_music));
        this.o.setImageLevel(0);
        this.F = false;
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        this.q.setImageResource(R.mipmap.icon_bigplaylistdefault);
        this.r.setTotalProgress(0.0f);
        this.r.setCurrentProgress(0.0f);
        if (this.t.getVisibility() != 0) {
            this.t.setVisibility(0);
            a(56);
        }
        if (this.v.getVisibility() != 8) {
            this.v.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void h(View view) {
        switch (view.getId()) {
            case R.id.bottom_player_youtube_panel /* 2131821526 */:
            case R.id.bottom_player_panel /* 2131821534 */:
                int d = com.fotoable.youtube.music.newplayer.e.a().d();
                if (d == 2 || d == 3 || d == 4) {
                    startActivity(new Intent(this, PlayerActivity.class));
                    overridePendingTransition(R.anim.widget_dialog_enter_anim, 0);
                    com.fotoable.youtube.music.util.b.b("播放条-点击进入播放界面");
                    return;
                }
                return;
            case R.id.play_state_youtube /* 2131821532 */:
            case R.id.play_state /* 2131821540 */:
                int d2 = com.fotoable.youtube.music.newplayer.e.a().d();
                if (d2 == 2 || d2 == 3 || d2 == 4) {
                    if (this.G != null && this.G.isPlaying()) {
                        com.fotoable.youtube.music.newplayer.e.a().b(false);
                        this.o.setImageLevel(0);
                        this.G.setPlaying(false);
                    } else {
                        com.fotoable.youtube.music.newplayer.e.a().a(false);
                        this.o.setImageLevel(1);
                        if (this.G != null) {
                            this.G.setPlaying(true);
                        }
                    }
                    com.fotoable.youtube.music.util.b.b("播放条-切换播放状态");
                    return;
                }
                return;
            case R.id.play_list_youtube /* 2131821533 */:
            case R.id.play_list /* 2131821538 */:
                if (this.G != null) {
                    int d3 = com.fotoable.youtube.music.newplayer.e.a().d();
                    com.fotoable.youtube.music.util.h.a(f2302a, "currentPlayerType：" + d3);
                    if (d3 == 2 || d3 == 3) {
                        com.fotoable.youtube.music.util.h.a(f2302a, "打开歌单");
                        com.fotoable.youtube.music.newplayer.e.a().a(0);
                        this.H = PlayerMusicListDialog.a(getSupportFragmentManager(), d3, this.G.getVideoId(), this.G.getSongId(), new PlayerMusicListDialog.a() { // from class: com.fotoable.youtube.music.base.BaseActivity.2
                            @Override // com.fotoable.youtube.music.ui.dialog.PlayerMusicListDialog.a
                            public void a(List list, int i) {
                            }

                            @Override // com.fotoable.youtube.music.ui.dialog.PlayerMusicListDialog.a, com.fotoable.youtube.music.ui.dialog.b.a
                            public void a() {
                                BaseActivity.this.H = null;
                                com.fotoable.youtube.music.util.h.a(BaseActivity.f2302a, "关闭歌单");
                                BaseActivity.this.I.postDelayed(new Runnable() { // from class: com.fotoable.youtube.music.base.BaseActivity.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.fotoable.youtube.music.newplayer.e.a().a(1);
                                    }
                                }, 300L);
                            }
                        });
                        com.fotoable.youtube.music.util.b.b("播放条-查看播放列表");
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void t() {
        if (!w.f(this)) {
            Toast.makeText(this, (int) R.string.wearing_network_connect_error, 0).show();
        } else if (com.fotoable.youtube.music.a.t()) {
            SimpleMusicDialog.a(getSupportFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.base.BaseActivity.3
                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void a() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void b() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void c() {
                    BaseActivity.this.v();
                }
            }, R.string.network_dialog_tip_msg, R.string.cancel, R.string.continues);
        } else {
            v();
        }
    }

    private void u() {
        if (!w.f(this)) {
            Toast.makeText(this, (int) R.string.wearing_network_connect_error, 0).show();
        } else {
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.d == 1) {
            if (this.f != null) {
                ArrayList arrayList = new ArrayList(this.f.size());
                arrayList.addAll(this.f);
                com.fotoable.youtube.music.newplayer.e.a().a(arrayList, this.k);
            }
        } else if (this.d == 2) {
            if (this.e != null) {
                com.fotoable.youtube.music.newplayer.e.a().a(this.e);
            }
        } else if (this.d == 3) {
            if (this.e != null) {
                com.fotoable.youtube.music.newplayer.e.a().b(this.e);
            }
        } else if (this.d == 4) {
            if (this.f != null) {
                com.fotoable.youtube.music.newplayer.e.a().a(this.f);
            }
        } else if (this.d == 17) {
            if (this.h != null) {
                ArrayList arrayList2 = new ArrayList(this.h.size());
                arrayList2.addAll(this.h);
                com.fotoable.youtube.music.newplayer.e.a().b(arrayList2, this.k);
            }
        } else if (this.d == 18) {
            if (this.g != null) {
                com.fotoable.youtube.music.newplayer.e.a().a(this.g);
            }
        } else if (this.d == 19) {
            if (this.g != null) {
                com.fotoable.youtube.music.newplayer.e.a().b(this.g);
            }
        } else if (this.d == 20) {
            if (this.h != null) {
                com.fotoable.youtube.music.newplayer.e.a().b(this.h);
            }
        } else if (this.d == 33 && this.i != null) {
            com.fotoable.youtube.music.newplayer.e.a().a(this.i);
            o.a().a(com.fotoable.youtube.music.newplayer.a.c.a(this.i));
        }
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    private void w() {
        if (this.J) {
            x();
        } else if (m()) {
            com.fotoable.youtube.music.util.h.a(f2302a, "EVENT_PLAY_YOUTUBE_NOW checkPermission");
            if (w.f(this)) {
                o();
            } else {
                Toast.makeText(this, (int) R.string.wearing_network_connect_error, 0).show();
            }
        } else {
            n();
        }
    }

    private void x() {
        if (w.f(this)) {
            o();
        } else {
            Toast.makeText(this, (int) R.string.wearing_network_connect_error, 0).show();
        }
    }

    private void d(com.fotoable.youtube.music.e.a aVar) {
        throw new InvalidParameterException("event:" + aVar.f2726a + ",obj 必须是PlayMusicModel类型");
    }

    public void a(com.fotoable.youtube.music.e.a aVar) {
    }

    private com.fotoable.youtube.music.c.a.b y() {
        if (MusicApplication.c() != null) {
            return MusicApplication.c().e();
        }
        com.fotoable.youtube.music.util.h.a(f2302a, "ApplicationComponent is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.fotoable.youtube.music.c.a.a i() {
        return com.fotoable.youtube.music.c.a.c.a().a(y()).a(z()).a();
    }

    private com.fotoable.youtube.music.c.b.a z() {
        return new com.fotoable.youtube.music.c.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        if (this.K == null) {
            this.K = new rx.g.b();
        }
        this.K.a(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        if (this.K != null && !this.K.isUnsubscribed()) {
            this.K.unsubscribe();
            this.K = null;
        }
    }

    public void hideSoft(View view) {
        com.fotoable.youtube.music.util.g.b(view);
    }

    public void k() {
        if (r.a()) {
            if (r.a((Context) this)) {
                a(true);
                return;
            }
            this.L = 2;
            r.a((Activity) this);
        } else if (m()) {
            if (Build.VERSION.SDK_INT >= 24) {
                a(true);
            } else {
                a(true);
            }
        } else {
            this.L = 2;
            A();
        }
    }

    public void l() {
        if (r.a()) {
            if (r.a((Context) this)) {
                com.fotoable.youtube.music.a.i(true);
                QuickToolsService.a(this, "action_show_quick");
                return;
            }
            this.L = 3;
            r.a((Activity) this);
        } else if (m()) {
            com.fotoable.youtube.music.a.i(true);
            QuickToolsService.a(this, "action_show_quick");
        } else {
            this.L = 3;
            A();
        }
    }

    public boolean m() {
        if (r.a()) {
            return r.a((Context) this);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return Settings.canDrawOverlays(this);
        }
        return true;
    }

    public void n() {
        com.fotoable.youtube.music.util.h.a(f2302a, "EVENT_PLAY_YOUTUBE_NOW showPermissionDialog");
        FloatPermissionDialog.a(getSupportFragmentManager(), new FloatPermissionDialog.a() { // from class: com.fotoable.youtube.music.base.BaseActivity.4
            @Override // com.fotoable.youtube.music.ui.dialog.FloatPermissionDialog.a
            public void a() {
                com.fotoable.youtube.music.util.b.b("Dev_Float点击取消跳转授权");
            }

            @Override // com.fotoable.youtube.music.ui.dialog.FloatPermissionDialog.a
            public void b() {
                com.fotoable.youtube.music.util.b.b("Dev_Float点击同意跳转授权");
                BaseActivity.this.k();
            }

            @Override // com.fotoable.youtube.music.ui.dialog.FloatPermissionDialog.a
            public void c() {
                com.fotoable.youtube.music.util.b.b("Dev_Float点击取消跳转授权");
            }
        });
    }

    private void a(boolean z) {
        if (z) {
            o();
        }
    }

    public void o() {
        if (w.g(this)) {
            v();
        } else if (com.fotoable.youtube.music.a.t()) {
            SimpleMusicDialog.a(getSupportFragmentManager(), new SimpleMusicDialog.a() { // from class: com.fotoable.youtube.music.base.BaseActivity.5
                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void a() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void b() {
                }

                @Override // com.fotoable.youtube.music.ui.dialog.SimpleMusicDialog.a
                public void c() {
                    BaseActivity.this.v();
                }
            }, R.string.network_dialog_tip_msg, R.string.cancel, R.string.continues);
        } else {
            v();
        }
    }

    private void A() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                intent.setData(Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 1);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
                Toast.makeText(this, (int) R.string.request_permission_error_msg, 0).show();
                com.fotoable.youtube.music.util.b.b("Dev_无法跳转到授权界面", "异常信息", e != null ? e.getMessage() : "无异常信息");
                com.fotoable.youtube.music.util.b.b("Dev_无法跳转到授权界面", "产商&机型&系统版本", Build.MANUFACTURER + "&" + Build.MODEL + "&" + Build.VERSION.RELEASE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (r.a()) {
                    if (this.L == 2) {
                        if (r.a((Context) this)) {
                            a(true);
                            com.fotoable.youtube.music.util.b.b("Dev_Float授权成功", "操作", "播放");
                            return;
                        }
                        com.fotoable.youtube.music.util.b.b("Dev_Float授权失败", "操作", "播放");
                        a(false);
                        Toast.makeText(this, (int) R.string.request_permission_error_msg, 0).show();
                        return;
                    } else if (this.L == 3) {
                        if (r.a((Context) this)) {
                            com.fotoable.youtube.music.a.i(true);
                            QuickToolsService.a(this, "action_show_quick");
                            com.fotoable.youtube.music.util.b.b("Dev_Float授权成功", "操作", "底部工具栏");
                            return;
                        }
                        Toast.makeText(this, (int) R.string.request_permission_error_msg, 0).show();
                        com.fotoable.youtube.music.util.b.b("Dev_Float授权失败", "操作", "底部工具栏");
                        return;
                    } else {
                        return;
                    }
                } else if (Build.VERSION.SDK_INT >= 24) {
                    if (this.L == 2) {
                        if (Settings.canDrawOverlays(this)) {
                            a(true);
                            com.fotoable.youtube.music.util.b.b("Dev_Float授权成功", "操作", "播放");
                            return;
                        }
                        com.fotoable.youtube.music.util.b.b("Dev_Float授权失败", "操作", "播放");
                        a(false);
                        Toast.makeText(this, (int) R.string.request_permission_error_msg, 0).show();
                        return;
                    } else if (this.L == 3) {
                        if (Settings.canDrawOverlays(this)) {
                            com.fotoable.youtube.music.a.i(true);
                            QuickToolsService.a(this, "action_show_quick");
                            com.fotoable.youtube.music.util.b.b("Dev_Float授权成功", "操作", "底部工具栏");
                            return;
                        }
                        Toast.makeText(this, (int) R.string.request_permission_error_msg, 0).show();
                        com.fotoable.youtube.music.util.b.b("Dev_Float授权失败", "操作", "底部工具栏");
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.fotoable.youtube.music.util.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.fotoable.youtube.music.util.b.b(this);
    }

    public boolean p() {
        return Build.VERSION.SDK_INT >= 17 ? super.isDestroyed() : this.f2304c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f2304c = true;
        try {
            j();
            if (this.f2303b != null) {
                this.f2303b.unbind();
                this.f2303b = null;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}
