package com.fotoable.youtube.music.newplayer.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.WindowManager;
import com.bumptech.glide.i;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.newplayer.b.f;
import com.fotoable.youtube.music.newplayer.g;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.model.SystemMusicData;
import com.fotoable.youtube.music.newplayer.popup.FloatBottomCloseView;
import com.fotoable.youtube.music.newplayer.popup.FloatPlayerView;
import com.fotoable.youtube.music.newplayer.popup.PowerSavingModelView;
import com.fotoable.youtube.music.newplayer.popup.YoutubeWarnTipView;
import com.fotoable.youtube.music.quicktools.service.QuickToolsService;
import com.fotoable.youtube.music.service.MainService;
import com.fotoable.youtube.music.service.MusicWidgetService;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.r;
import com.fotoable.youtube.music.util.u;
import com.fotoable.youtube.music.util.x;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: YoutubePlayer.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2930a = c.class.getSimpleName();
    private static final c d = new c();

    /* renamed from: b  reason: collision with root package name */
    private FloatPlayerView f2931b;

    /* renamed from: c  reason: collision with root package name */
    private PlayMusicModel f2932c;
    private WindowManager.LayoutParams e;
    private Context f;
    private long g;
    private long h;
    private WindowManager k;
    private PowerSavingModelView p;
    private WindowManager.LayoutParams q;
    private FloatBottomCloseView r;
    private WindowManager.LayoutParams s;
    private YoutubeWarnTipView t;
    private WindowManager.LayoutParams u;
    private PowerManager.WakeLock v;
    private boolean i = false;
    private int j = 2306;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;

    public static c a() {
        return d;
    }

    private c() {
    }

    public void a(Context context) {
        this.f = context;
    }

    public void a(PlayMusicModel playMusicModel) {
        this.f2932c = playMusicModel;
        if (this.f2931b != null) {
            this.f2931b.a(playMusicModel);
        }
        a(this.f, playMusicModel, false, 0L, 0L);
    }

    public void a(PlayMusicModel playMusicModel, boolean z) {
        h.a(f2930a, "播放1");
        this.i = false;
        this.m = false;
        this.f2932c = playMusicModel;
        if (this.f2931b != null) {
            this.j = 2307;
            a(this.f, playMusicModel, false, 0L, 0L);
            this.f2931b.b(playMusicModel);
            a(this.f, playMusicModel, false, 0L, 0L);
            if (this.p != null) {
                this.p.setModel(playMusicModel);
                return;
            }
            return;
        }
        a(this.f, playMusicModel, false, 0L, 0L);
    }

    public void a(boolean z) {
        h.a(f2930a, "播放2");
        if (this.i) {
            this.i = false;
            if (this.f2931b != null) {
                this.j = 2307;
                this.f2931b.b(f.a().e());
            }
        } else {
            this.i = false;
            if (this.f2931b != null) {
                this.f2931b.a();
            }
        }
        this.m = false;
    }

    public void b(boolean z) {
        h.a(f2930a, "暂停1");
        if (this.f2931b != null) {
            this.f2931b.b();
        }
    }

    public void a(int i) {
        this.i = false;
        if (this.f2931b != null) {
            this.j = 2307;
            this.f2931b.a(i);
        }
    }

    public void b() {
        if (this.f2931b != null) {
            this.f2931b.h();
        } else {
            a(false, this.f, this.f2932c, false, 0L, 0L);
        }
    }

    public void c() {
        if (this.f2931b != null) {
            if (this.f2931b.getVisibility() != 0) {
                this.f2931b.setVisibility(0);
            }
            if (this.e.x < 0) {
                h.a(f2930a, "显示播放器111");
                if (com.fotoable.youtube.music.newplayer.f.a().C() == 2401) {
                    this.f2931b.i();
                } else if (com.fotoable.youtube.music.newplayer.f.a().C() == 2402) {
                    this.e.x = (int) ((this.f2931b.f3011a - this.f2931b.f3013c) - (this.f2931b.e * 15.0f));
                    this.f2931b.b(1);
                } else if (com.fotoable.youtube.music.newplayer.f.a().C() == 2403) {
                    this.e.x = (int) ((this.f2931b.f3011a - this.f2931b.f3013c) - (this.f2931b.e * 15.0f));
                } else {
                    h.a(f2930a, "没有对应的位置3:" + com.fotoable.youtube.music.newplayer.f.a().C());
                }
                p(this.f).updateViewLayout(this.f2931b, this.e);
            }
        }
    }

    public void d() {
        if (this.f2931b != null) {
            if (this.f2931b.getVisibility() != 0) {
                this.f2931b.setVisibility(0);
            }
            if (this.e.x < 0) {
                WindowManager p = p(this.f);
                if (com.fotoable.youtube.music.newplayer.f.a().C() == 2401) {
                    this.f2931b.i();
                } else if (com.fotoable.youtube.music.newplayer.f.a().C() == 2402) {
                    this.e.x = (int) ((this.f2931b.f3011a - this.f2931b.f3013c) - (this.f2931b.e * 15.0f));
                } else if (com.fotoable.youtube.music.newplayer.f.a().C() == 2403) {
                    this.e.x = (int) ((this.f2931b.f3011a - this.f2931b.f3013c) - (this.f2931b.e * 15.0f));
                } else {
                    h.a(f2930a, "没有对应的位置1" + com.fotoable.youtube.music.newplayer.f.a().C());
                }
                try {
                    p.updateViewLayout(this.f2931b, this.e);
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
        }
    }

    public void b(Context context) {
        if (c(context)) {
            this.f = context;
            if (this.f2931b == null) {
                this.i = true;
                h.a(f2930a, "开始预加载播放网页......");
                a(context, false);
                e();
            }
        }
    }

    public boolean c(Context context) {
        if (r.a()) {
            return r.a(context);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return Settings.canDrawOverlays(context);
        }
        return true;
    }

    public void a(final Context context, boolean z) {
        this.f = context;
        if (this.f2931b != null) {
            if (this.f2931b.getVisibility() != 0) {
                this.f2931b.setVisibility(0);
            }
            if (this.e.x < 0) {
                if (com.fotoable.youtube.music.newplayer.f.a().C() == 2401) {
                    this.f2931b.i();
                } else if (com.fotoable.youtube.music.newplayer.f.a().C() == 2402) {
                    this.e.x = (int) ((this.f2931b.f3011a - this.f2931b.f3013c) - (this.f2931b.e * 15.0f));
                    this.f2931b.b(1);
                } else if (com.fotoable.youtube.music.newplayer.f.a().C() == 2403) {
                    this.e.x = (int) ((this.f2931b.f3011a - this.f2931b.f3013c) - (this.f2931b.e * 15.0f));
                } else {
                    h.a(f2930a, "没有对应的位置2:" + com.fotoable.youtube.music.newplayer.f.a().C());
                }
                try {
                    p(context).updateViewLayout(this.f2931b, this.e);
                    return;
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                    return;
                }
            }
            return;
        }
        try {
            this.m = false;
            this.f2932c = f.a().e();
            WindowManager p = p(context);
            this.f2931b = new FloatPlayerView(context);
            this.f2931b.a(this.f2932c);
            this.j = 2307;
            this.f2931b.setOnYoutubePlayerListener(new com.fotoable.youtube.music.newplayer.c.a() { // from class: com.fotoable.youtube.music.newplayer.d.c.1

                /* renamed from: c  reason: collision with root package name */
                private String f2935c;

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void a(Context context2, long j, long j2) {
                    c.this.g = j;
                    c.this.h = j2;
                    c.this.a(context2, c.this.f2932c, c.this.f2931b.e(), j, j2);
                    if (!com.fotoable.youtube.music.newplayer.f.a().e()) {
                        c.this.b(false);
                    }
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void a(Context context2, long j) {
                    c.this.h = j;
                    c.this.a(context2, c.this.f2932c, c.this.f2931b.e(), c.this.g, j);
                    if (c.this.f2932c != null && !TextUtils.equals(this.f2935c, c.this.f2932c.getVideoId())) {
                        this.f2935c = c.this.f2932c.getVideoId();
                        com.fotoable.youtube.music.util.b.b("播放器-播放Youtube次数");
                    }
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void a() {
                    if (c.this.f2932c != null && c.this.f2931b != null && !c.this.i) {
                        c.this.f2931b.b(c.this.f2932c);
                        h.a(c.f2930a, "网页加载完成，准备开始播放：" + c.this.i);
                    }
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void b() {
                    c.this.j = 2307;
                    c.this.a(context, c.this.f2932c, c.this.f2931b.e(), c.this.g, c.this.h);
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void a(Context context2) {
                    c.this.j = PlayerInfo.PLAY_STATE_PLAYING;
                    c.this.a(context2, c.this.f2932c, c.this.f2931b.e(), c.this.g, c.this.h);
                    g.a().a(true, c.this.g);
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void b(Context context2) {
                    c.this.j = 2306;
                    h.a(c.f2930a, "onPaused:" + c.this.g + "    " + c.this.h);
                    if (com.fotoable.youtube.music.newplayer.f.a().e()) {
                        c.this.a(context2, c.this.f2932c, c.this.f2931b != null ? c.this.f2931b.e() : false, c.this.g, c.this.h);
                        g.a().a(false, c.this.g);
                    }
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void c() {
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void d() {
                    if (com.fotoable.youtube.music.newplayer.f.a().b() && com.fotoable.youtube.music.a.j()) {
                        c.this.b(false);
                        c.this.d(context);
                        c.this.j(context);
                        com.fotoable.youtube.music.newplayer.f.a().a(false);
                    } else if (com.fotoable.youtube.music.a.v()) {
                        PlayMusicModel b2 = f.a().b(false);
                        if (b2 == null) {
                            c.this.g = 0L;
                            c.this.a(context, c.this.f2932c, c.this.f2931b.e(), c.this.g, c.this.h);
                            return;
                        }
                        c.this.a(b2, false);
                    }
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void e() {
                    c.this.g = 0L;
                    c.this.h = 0L;
                    c.this.j = 2307;
                    c.this.a(context, c.this.f2932c, c.this.f2931b.e(), c.this.g, c.this.h);
                    final SystemMusicData systemMusicData = new SystemMusicData();
                    systemMusicData.setTitle(c.this.f2932c.getTitle());
                    systemMusicData.setArtist(c.this.f2932c.getArtists());
                    systemMusicData.setDuration(c.this.h);
                    systemMusicData.setNumTracks(f.a().b().size());
                    systemMusicData.setTrackNumber(f.a().d());
                    i.c(context).a(c.this.f2932c.getCoverImg()).l().b(com.bumptech.glide.load.b.b.ALL).a((com.bumptech.glide.a<String, Bitmap>) new com.bumptech.glide.g.b.g<Bitmap>() { // from class: com.fotoable.youtube.music.newplayer.d.c.1.1
                        @Override // com.bumptech.glide.g.b.j
                        /* renamed from: a */
                        public void onResourceReady(Bitmap bitmap, com.bumptech.glide.g.a.c<? super Bitmap> cVar) {
                            if (com.fotoable.youtube.music.newplayer.f.a().e() && c.this.f2931b != null) {
                                systemMusicData.setAlbumArt(bitmap);
                                g.a().a(c.this.f2931b.e(), c.this.g, systemMusicData);
                            }
                        }
                    });
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void c(Context context2) {
                    c.this.h(context2);
                    com.fotoable.youtube.music.util.b.b("Youtube视频窗口-省电模式");
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void d(Context context2) {
                    MainService.a(context2, "open_player_page", ShareConstants.FEED_SOURCE_PARAM, "float_player");
                }

                @Override // com.fotoable.youtube.music.newplayer.c.a
                public void e(Context context2) {
                    c.this.e(context2);
                }
            });
            this.e = new WindowManager.LayoutParams();
            this.f2931b.setParams(this.e);
            if (Build.VERSION.SDK_INT >= 24) {
                this.e.type = 2003;
            } else {
                this.e.type = 2005;
            }
            this.e.format = 1;
            this.e.flags = 1832;
            this.e.gravity = 51;
            if (Build.VERSION.SDK_INT >= 19) {
                this.e.flags |= 16777216;
            }
            this.e.x = (int) ((this.f2931b.f3011a - this.f2931b.f3013c) - (context.getResources().getDisplayMetrics().density * 15.0f));
            this.e.y = (int) (65.0f * context.getResources().getDisplayMetrics().density);
            this.e.width = this.f2931b.f3013c;
            this.e.height = this.f2931b.d;
            k(context);
            h();
            r(context);
            p.addView(this.f2931b, this.e);
            try {
                if (!this.i) {
                    if (com.fotoable.youtube.music.newplayer.f.a().C() == 2401) {
                        this.f2931b.i();
                    } else if (com.fotoable.youtube.music.newplayer.f.a().C() == 2402) {
                        this.e.x = (int) ((this.f2931b.f3011a - this.f2931b.f3013c) - (this.f2931b.e * 15.0f));
                        this.f2931b.b(1);
                    } else if (com.fotoable.youtube.music.newplayer.f.a().C() == 2403) {
                        this.e.x = (int) ((this.f2931b.f3011a - this.f2931b.f3013c) - (this.f2931b.e * 15.0f));
                    } else if (com.fotoable.youtube.music.newplayer.f.a().C() == 2404) {
                        this.e.x = (-context.getResources().getDisplayMetrics().heightPixels) * 2;
                    }
                    p.updateViewLayout(this.f2931b, this.e);
                }
            } catch (Exception e2) {
                ThrowableExtension.printStackTrace(e2);
            }
            if (!this.i) {
                MainService.a(context, "action_pop_up_open", new String[0]);
                com.fotoable.youtube.music.util.b.b("Dev_播放窗口展示次数");
            }
        } catch (Exception e3) {
            ThrowableExtension.printStackTrace(e3);
            com.fotoable.youtube.music.util.b.a(e3);
        }
    }

    public void a(Context context, PlayMusicModel playMusicModel, boolean z, long j, long j2) {
        if (!this.m || playMusicModel == null) {
            a(false, context, playMusicModel, z, j, j2);
        }
    }

    public void a(boolean z, Context context, PlayMusicModel playMusicModel, boolean z2, long j, long j2) {
        if (j > j2) {
            j = 0;
        }
        PlayerInfo playerInfo = null;
        try {
            if (f.a().b().size() > 0) {
                playerInfo = new PlayerInfo();
                playerInfo.covert(playMusicModel);
                playerInfo.setCurrentTime(j);
                playerInfo.setTotalTime(j2);
                playerInfo.setPlaying(z2);
                playerInfo.setPlayState(this.j);
            } else {
                h.a(f2930a, "YoutubeData数据为空队列");
            }
            Intent intent = new Intent(context, QuickToolsService.class);
            intent.setAction("action_syn_music_data");
            intent.putExtra("music", playerInfo);
            context.startService(intent);
            if (x.a() && context != null) {
                Intent intent2 = new Intent(context, MusicWidgetService.class);
                intent2.setAction("action_syn_music_data");
                intent2.putExtra("music", playerInfo);
                context.startService(intent2);
            }
            if (f.a().e() != null && playerInfo != null) {
                if (TextUtils.equals(playerInfo.getVideoId(), f.a().e().getVideoId())) {
                    MainService.a(context, "syn_player_info", "music", playerInfo);
                } else {
                    h.a(f2930a, "丢弃通知，不发送..." + playerInfo.getVideoId() + "    " + f.a().e().getVideoId());
                }
            } else {
                MainService.a(context, "syn_player_info", "music", playerInfo);
            }
            if (!z) {
                com.fotoable.youtube.music.newplayer.c.a().a(context, playerInfo);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void d(Context context) {
        h.a(f2930a, "隐藏播放器");
        if (this.f2931b != null) {
            b(false);
            this.f2931b.setVisibility(8);
        }
    }

    public void e() {
        h.a(f2930a, "隐藏播放器到屏幕外3");
        if (this.f2931b != null) {
            WindowManager p = p(this.f);
            this.e.x = (-this.f.getResources().getDisplayMetrics().heightPixels) * 2;
            try {
                p.updateViewLayout(this.f2931b, this.e);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
            h.a(f2930a, "播放器位置：x:" + this.e.x);
            return;
        }
        h.a(f2930a, "隐藏播放器到屏幕外  floatPlayerView is null.");
    }

    public void f() {
        h.a(f2930a, "隐藏播放器到屏幕外2");
        if (this.f2931b != null) {
            WindowManager p = p(this.f);
            this.e.x = -800;
            try {
                p.updateViewLayout(this.f2931b, this.e);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public void e(Context context) {
        h.a(f2930a, "移除播放器");
        try {
            if (this.f2931b != null) {
                this.f2931b.c();
                p(context).removeView(this.f2931b);
            }
            q(context);
            l(context);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        MainService.a(context, "action_pop_up_close", new String[0]);
        this.f2931b = null;
    }

    private WindowManager p(Context context) {
        if (this.k == null) {
            this.k = (WindowManager) context.getSystemService("window");
        }
        return this.k;
    }

    public void f(Context context) {
        this.m = true;
        this.n = false;
        if (this.f2931b != null) {
            if (this.f2931b.getVisibility() == 0) {
                this.n = true;
            }
            this.l = this.f2931b.e();
            this.f2931b.b();
            a(true, context, this.f2932c, false, this.g, this.h);
        }
        if (this.l) {
            com.fotoable.youtube.music.newplayer.c.a().a(context, f.a().e());
            s(context);
        }
        i(context);
    }

    public void g() {
        if (!this.i) {
            this.m = false;
            if (this.f2931b != null) {
                if (this.n) {
                    this.n = false;
                    this.f2931b.setVisibility(0);
                }
                if (this.f2931b.g()) {
                    this.f2931b.setVisibility(0);
                    g(this.f);
                }
            }
            if (this.f2931b != null && this.l) {
                this.l = false;
                if (this.f2931b.g()) {
                    if (this.f2931b.getVisibility() != 0) {
                        this.f2931b.setVisibility(0);
                    }
                    g(this.f);
                } else {
                    c();
                }
                this.f2931b.a();
            }
        }
    }

    public static String a(long j) {
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

    public void b(int i) {
        if (this.i) {
            h.a(f2930a, "现在处于预加载状态，不能移动位置");
        } else if (this.f2931b != null) {
            if (i == 2404) {
                e();
            } else if (i == 2401) {
                this.f2931b.i();
            } else if (i == 2402) {
                this.f2931b.b(1);
            } else if (i == 2403) {
                this.f2931b.f();
            } else if (i == 2405) {
                if (this.f2931b != null && this.f2931b.e()) {
                    this.f2931b.b(1);
                } else if (this.f2931b != null && this.f2931b.getVisibility() != 8) {
                    this.f2931b.setVisibility(8);
                }
            } else {
                h.a(f2930a, "position不能识别，请注意参数");
            }
        } else {
            h.a(f2930a, "播放视图为空，不能移动位置");
        }
    }

    public void g(Context context) {
        if (this.p != null && this.p.getVisibility() != 0) {
            this.p.setModel(this.f2932c);
            this.p.setVisibility(0);
        }
    }

    public void h(Context context) {
        if (this.p != null && this.p.getVisibility() != 0) {
            this.p.setModel(this.f2932c);
            this.p.setVisibility(0);
            this.p.a();
        }
    }

    public void i(Context context) {
        if (this.p != null && this.p.getVisibility() != 8) {
            this.p.setVisibility(8);
        }
    }

    public void j(Context context) {
        b(2403);
        com.fotoable.youtube.music.newplayer.f.a().h(2403);
        if (this.p != null && this.p.getVisibility() != 8) {
            this.p.setVisibility(8);
        }
    }

    private void q(Context context) {
        if (this.p != null) {
            p(context).removeViewImmediate(this.p);
            this.p = null;
        }
    }

    private void r(Context context) {
        if (this.p == null) {
            this.p = new PowerSavingModelView(context);
            this.p.setVisibility(8);
            if (this.q == null) {
                this.q = new WindowManager.LayoutParams();
                this.p.setParams(this.q);
                if (Build.VERSION.SDK_INT >= 24) {
                    this.q.type = 2003;
                } else {
                    this.q.type = 2005;
                }
                this.q.format = 1;
                this.q.flags = 1952;
                this.q.gravity = 51;
                if (Build.VERSION.SDK_INT >= 19) {
                    this.q.flags |= 16777216;
                }
                this.q.screenOrientation = 1;
                this.q.width = -1;
                this.q.height = context.getResources().getDisplayMetrics().heightPixels + t(context);
                this.q.x = 0;
                this.q.y = 0;
            } else {
                this.p.setParams(this.q);
            }
            p(context).addView(this.p, this.q);
        }
    }

    public void k(Context context) {
        if (this.r != null) {
            this.r.setVisibility(0);
            return;
        }
        WindowManager p = p(context);
        int width = p.getDefaultDisplay().getWidth();
        this.r = new FloatBottomCloseView(context);
        if (this.s == null) {
            this.s = new WindowManager.LayoutParams();
            if (Build.VERSION.SDK_INT >= 24) {
                this.s.type = 2003;
            } else {
                this.s.type = 2005;
            }
            this.s.format = 1;
            this.s.flags = 40;
            this.s.gravity = 81;
            this.s.width = width;
            this.s.height = (int) (60.0f * context.getResources().getDisplayMetrics().density);
        }
        this.r.setParams(this.s);
        try {
            p.addView(this.r, this.s);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void h() {
        if (this.r != null) {
            this.r.setVisibility(8);
        }
    }

    public void l(Context context) {
        try {
            if (this.r != null) {
                p(context).removeView(this.r);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        this.r = null;
    }

    public void c(boolean z) {
        if (this.r != null) {
            this.r.a(z);
        }
    }

    private void s(Context context) {
        try {
            if (!com.fotoable.youtube.music.a.r()) {
                if (this.t != null) {
                    this.t.setVisibility(0);
                } else {
                    WindowManager p = p(context);
                    int height = p.getDefaultDisplay().getHeight();
                    this.t = new YoutubeWarnTipView(context);
                    if (this.u == null) {
                        this.u = new WindowManager.LayoutParams();
                        this.t.setParams(this.u);
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.u.type = 2003;
                        } else {
                            this.u.type = 2005;
                        }
                        this.u.format = 1;
                        this.u.flags = 1832;
                        this.u.gravity = 51;
                        if (Build.VERSION.SDK_INT >= 19) {
                            this.u.flags |= 16777216;
                        }
                        this.u.screenOrientation = 1;
                        this.u.width = -1;
                        this.u.height = height + t(context);
                        this.u.x = 0;
                        this.u.y = 0;
                    } else {
                        this.t.setParams(this.u);
                    }
                    p.addView(this.t, this.u);
                    u.a(this.t);
                    try {
                        ((PowerManager) context.getSystemService("power")).newWakeLock(268435462, f2930a).acquire();
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }
                com.fotoable.youtube.music.util.b.b("Dev_Youtube警告提示展示次数");
            }
        } catch (Exception e2) {
            ThrowableExtension.printStackTrace(e2);
        }
    }

    private int t(Context context) {
        if (u.c(context)) {
            return u.a(context);
        }
        return 0;
    }

    public void m(Context context) {
        try {
            if (this.t != null) {
                p(context).removeView(this.t);
            }
            if (this.v != null) {
                this.v.release();
                this.v = null;
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        this.t = null;
    }

    public void c(int i) {
        if (this.f2931b != null && !this.f2931b.g()) {
            if (this.f2931b == null && i == 1) {
                a(this.f, false);
            }
            try {
                if (this.f2931b != null) {
                    this.f2931b.c(i);
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public void n(Context context) {
        this.m = true;
        if (this.f2931b != null) {
            this.f2931b.b();
        }
        a(true, context, this.f2932c, false, this.g, this.h);
    }

    public void o(Context context) {
        if (this.f2931b != null && !this.i && !this.f2931b.g()) {
            com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(8003));
            com.fotoable.youtube.music.newplayer.f.a().d(4);
        }
    }

    public void d(int i) {
        if (!this.i) {
            if (i == 1) {
                d();
                h.a(f2930a, "changePlayerVisible  1");
                return;
            }
            f();
            h.a(f2930a, "changePlayerVisible  " + i);
        }
    }

    public void a(Context context, boolean z, boolean z2) {
        if (this.f2931b == null) {
            a(context, z);
        }
        if (z2) {
            c();
        } else {
            f();
        }
    }

    public boolean i() {
        if (this.f2931b != null) {
            return this.f2931b.e();
        }
        return false;
    }
}
