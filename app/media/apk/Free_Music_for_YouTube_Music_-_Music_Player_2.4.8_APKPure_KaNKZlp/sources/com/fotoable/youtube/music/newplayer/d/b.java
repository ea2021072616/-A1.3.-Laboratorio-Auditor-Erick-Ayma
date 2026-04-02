package com.fotoable.youtube.music.newplayer.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import com.bumptech.glide.i;
import com.fotoable.youtube.music.newplayer.g;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import com.fotoable.youtube.music.newplayer.model.SystemMusicData;
import com.fotoable.youtube.music.quicktools.service.QuickToolsService;
import com.fotoable.youtube.music.service.MainService;
import com.fotoable.youtube.music.service.MusicWidgetService;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.x;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.PLMediaPlayer;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import rx.f;
import rx.l;
import rx.m;
/* compiled from: RadioPlayer.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2916a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final b f2917b = new b();

    /* renamed from: c  reason: collision with root package name */
    private Context f2918c;
    private a d;
    private Handler e;
    private boolean f = false;
    private boolean g = true;
    private int h = 2306;
    private RadioModel i;

    public static b a() {
        return f2917b;
    }

    private b() {
    }

    public void a(Context context, Handler handler) {
        this.f2918c = context;
        this.e = handler;
        this.d = new a();
        this.d.a(handler);
    }

    public void b() {
        this.f = true;
        b(false);
    }

    public boolean c() {
        if (this.d != null) {
            return this.d.c();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RadioPlayer.java */
    /* loaded from: classes.dex */
    public class a implements PLMediaPlayer.OnCompletionListener, PLMediaPlayer.OnErrorListener, PLMediaPlayer.OnInfoListener {
        private PLMediaPlayer f;
        private AVOptions g;
        private boolean h;
        private Handler i;
        private long j;
        private String k;
        private long l;
        private m n;

        /* renamed from: a  reason: collision with root package name */
        boolean f2924a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f2925b = false;
        private boolean m = false;

        /* renamed from: c  reason: collision with root package name */
        Runnable f2926c = new Runnable() { // from class: com.fotoable.youtube.music.newplayer.d.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                Log.d(b.f2916a, "mIsTrackPrepared, " + a.this.f2924a);
                if (a.this.f2924a) {
                    if (!b.this.g) {
                        h.a(b.f2916a, "开始播放");
                        a.this.f.start();
                        b.this.h = PlayerInfo.PLAY_STATE_PLAYING;
                        a.this.g();
                        long j = a.this.l;
                        if (((float) j) > 588000.0f) {
                            j = 588000;
                        }
                        b.this.a(false, b.this.f2918c, b.this.i, true, j, 600000L);
                        return;
                    }
                    a.this.f.pause();
                } else if (!a.this.m) {
                    a.this.i.postDelayed(a.this.f2926c, 100L);
                }
            }
        };
        PLMediaPlayer.OnPreparedListener d = new PLMediaPlayer.OnPreparedListener() { // from class: com.fotoable.youtube.music.newplayer.d.b.a.2
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnPreparedListener
            public void onPrepared(PLMediaPlayer pLMediaPlayer, int i) {
                pLMediaPlayer.setOnCompletionListener(a.this);
                a.this.f2924a = true;
                h.a(b.f2916a, "加载耗时：" + (System.currentTimeMillis() - a.this.j));
                if (b.this.g) {
                    pLMediaPlayer.pause();
                }
            }
        };

        public void a(Handler handler) {
            this.i = handler;
        }

        public a() {
            f();
            this.g = new AVOptions();
            this.g.setInteger(AVOptions.KEY_LIVE_STREAMING, 1);
            this.g.setInteger(AVOptions.KEY_MEDIACODEC, 2);
            this.g.setInteger(AVOptions.KEY_PREPARE_TIMEOUT, 40000);
            this.g.setInteger(AVOptions.KEY_DELAY_OPTIMIZATION, 1);
            this.g.setInteger(AVOptions.KEY_CACHE_BUFFER_DURATION, 4000);
            this.g.setInteger(AVOptions.KEY_MAX_CACHE_BUFFER_DURATION, 4000);
            this.g.setInteger(AVOptions.KEY_START_ON_PREPARED, 0);
        }

        private void f() {
            try {
                if (this.f != null) {
                    this.f.reset();
                } else {
                    this.f = new PLMediaPlayer(b.this.f2918c, this.g);
                    this.f.setWakeMode(b.this.f2918c, 1);
                    this.f.setOnErrorListener(this);
                    this.f.setOnInfoListener(this);
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            } catch (UnsatisfiedLinkError e2) {
                ThrowableExtension.printStackTrace(e2);
            }
        }

        public void a(String str) {
            h.a(b.f2916a, "path:" + str);
            if (this.f == null) {
                f();
            }
            this.h = a(this.f, str);
        }

        public boolean a(PLMediaPlayer pLMediaPlayer, String str) {
            if (pLMediaPlayer == null) {
                return false;
            }
            try {
                this.k = str;
                this.l = 0L;
                this.f2924a = false;
                this.m = false;
                pLMediaPlayer.reset();
                pLMediaPlayer.setDataSource(str);
                pLMediaPlayer.setOnPreparedListener(this.d);
                this.f2925b = true;
                pLMediaPlayer.prepareAsync();
                this.j = System.currentTimeMillis();
            } catch (IOException e) {
                ThrowableExtension.printStackTrace(e);
            } catch (IllegalStateException e2) {
                ThrowableExtension.printStackTrace(e2);
            }
            return true;
        }

        public void a() {
            if (this.f == null) {
                f();
            }
            if (!this.f2925b) {
                if (!this.f.isPlaying()) {
                    this.f.start();
                    g();
                    long j = this.l;
                    if (((float) j) > 588000.0f) {
                        j = 588000;
                    }
                    b.this.a(false, b.this.f2918c, b.this.i, true, j, 600000L);
                    return;
                }
                return;
            }
            if (this.m) {
                this.m = false;
                f();
                a(this.f, this.k);
            }
            b.this.h = 2307;
            b.this.a(false, b.this.f2918c, b.this.i, false, 0L, 0L);
            this.i.removeCallbacks(this.f2926c);
            this.i.postDelayed(this.f2926c, 50L);
        }

        public void b() {
            g.a().a(false, this.l);
            this.i.removeCallbacks(this.f2926c);
            this.f.pause();
            long j = this.l;
            if (((float) j) > 588000.0f) {
                j = 588000;
            }
            b.this.a(false, b.this.f2918c, b.this.i, false, j, 600000L);
            b.this.h = 2306;
            d();
            h.a(b.f2916a, "暫停播放");
        }

        public long a(long j) {
            this.f.seekTo((int) j);
            return j;
        }

        @Override // com.pili.pldroid.player.PLMediaPlayer.OnCompletionListener
        public void onCompletion(PLMediaPlayer pLMediaPlayer) {
            b();
        }

        public boolean c() {
            if (this.f == null) {
                return false;
            }
            return this.f.isPlaying();
        }

        public void d() {
            if (this.n != null && !this.n.isUnsubscribed()) {
                this.n.unsubscribe();
                this.n = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            d();
            this.n = f.a(0L, 1000L, TimeUnit.MILLISECONDS).b(new l<Long>() { // from class: com.fotoable.youtube.music.newplayer.d.b.a.3
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Long l) {
                    if (b.this.g) {
                        if (a.this.f != null && a.this.f.isPlaying()) {
                            a.this.b();
                            return;
                        }
                        return;
                    }
                    if (a.this.f != null && a.this.f.isPlaying()) {
                        a.this.l += 1000;
                    }
                    long j = a.this.l;
                    if (((float) j) > 588000.0f) {
                        j = 588000;
                    }
                    g.a().a(a.this.f.isPlaying(), j);
                    b.this.a(false, b.this.f2918c, b.this.i, a.this.f.isPlaying(), j, 600000L);
                    if (!com.fotoable.youtube.music.newplayer.f.a().g()) {
                        a.this.b();
                    }
                }
            });
        }

        public void e() {
            if (this.f == null) {
                b.this.a(false, b.this.f2918c, null, false, 0L, 0L);
                return;
            }
            long j = this.l;
            if (((float) j) > 588000.0f) {
                j = 588000;
            }
            b.this.a(false, b.this.f2918c, b.this.i, this.f.isPlaying(), j, 600000L);
        }

        @Override // com.pili.pldroid.player.PLMediaPlayer.OnErrorListener
        public boolean onError(PLMediaPlayer pLMediaPlayer, int i) {
            h();
            switch (i) {
                case -875574520:
                    h.a(b.f2916a, "onError:--->播放资源不存在");
                    return true;
                case PLMediaPlayer.ERROR_CODE_UNAUTHORIZED /* -825242872 */:
                    h.a(b.f2916a, "onError:--->未授权，播放一个禁播的流");
                    return true;
                case -541478725:
                    h.a(b.f2916a, "onError:--->空的播放列表");
                    return true;
                case PLMediaPlayer.ERROR_CODE_HW_DECODE_FAILURE /* -2003 */:
                    h.a(b.f2916a, "onError:--->硬解码失败");
                    return true;
                case PLMediaPlayer.ERROR_CODE_READ_FRAME_TIMEOUT /* -2002 */:
                    h.a(b.f2916a, "onError:--->读取数据超时");
                    return true;
                case PLMediaPlayer.ERROR_CODE_PREPARE_TIMEOUT /* -2001 */:
                    h.a(b.f2916a, "onError:--->播放器准备超时");
                    return true;
                case -111:
                    h.a(b.f2916a, "onError:--->服务器拒绝连接");
                    return true;
                case -110:
                    h.a(b.f2916a, "onError:--->连接超时");
                    return true;
                case -11:
                    h.a(b.f2916a, "onError:--->与服务器连接断开");
                    return true;
                case -5:
                    h.a(b.f2916a, "onError:--->网络异常");
                    return true;
                case -2:
                    h.a(b.f2916a, "onError:--->无效的 URL");
                    return true;
                case -1:
                    h.a(b.f2916a, "onError:--->未知错误");
                    return true;
                default:
                    return true;
            }
        }

        private void h() {
            this.m = true;
            if (!b.this.g) {
                b.this.h = PlayerInfo.PLAY_STATE_ERROR;
                b();
            }
        }

        @Override // com.pili.pldroid.player.PLMediaPlayer.OnInfoListener
        public boolean onInfo(PLMediaPlayer pLMediaPlayer, int i, int i2) {
            switch (i) {
                case 1:
                    h.a(b.f2916a, "onInfo--->未知消息");
                    return false;
                case 3:
                    h.a(b.f2916a, "onInfo--->第一帧视频已成功渲染");
                    return false;
                case 701:
                    h.a(b.f2916a, "onInfo--->开始缓冲");
                    return false;
                case 702:
                    h.a(b.f2916a, "onInfo--->停止缓冲");
                    return false;
                case 802:
                    h.a(b.f2916a, "onInfo--->硬解失败，自动切换软解");
                    return false;
                case 10001:
                    h.a(b.f2916a, "onInfo--->获取到视频的播放角度");
                    return false;
                case 10002:
                    h.a(b.f2916a, "onInfo--->第一帧音频已成功播放");
                    return false;
                case 10003:
                    h.a(b.f2916a, "onInfo--->获取视频的I帧间隔");
                    return false;
                case 10004:
                    h.a(b.f2916a, "onInfo--->获取当前视频播放时间戳");
                    return false;
                case 10005:
                    h.a(b.f2916a, "onInfo--->获取当前音频播放时间戳");
                    return false;
                default:
                    return false;
            }
        }
    }

    public void a(RadioModel radioModel) {
        this.i = radioModel;
        if (this.d != null && radioModel != null) {
            this.d.a(this.i.getAudioUrl());
            a(false, this.f2918c, radioModel, false, 0L, 0L);
            return;
        }
        a(false, this.f2918c, null, false, 0L, 0L);
    }

    public void a(RadioModel radioModel, boolean z) {
        boolean z2 = this.i == null || radioModel == null || this.i.getId() != radioModel.getId() || this.d == null || !this.d.c();
        this.i = radioModel;
        if (this.d != null && this.i != null) {
            this.g = false;
            this.f = false;
            if (z2) {
                this.d.a(this.i.getAudioUrl());
                final SystemMusicData systemMusicData = new SystemMusicData();
                systemMusicData.setTitle(radioModel.getTitle());
                systemMusicData.setDuration(600000L);
                systemMusicData.setNumTracks(1);
                systemMusicData.setTrackNumber(1);
                i.c(this.f2918c).a(radioModel.getImgUrl()).l().b(com.bumptech.glide.load.b.b.ALL).a((com.bumptech.glide.a<String, Bitmap>) new com.bumptech.glide.g.b.g<Bitmap>() { // from class: com.fotoable.youtube.music.newplayer.d.b.1
                    @Override // com.bumptech.glide.g.b.j
                    /* renamed from: a */
                    public void onResourceReady(Bitmap bitmap, com.bumptech.glide.g.a.c<? super Bitmap> cVar) {
                        systemMusicData.setAlbumArt(bitmap);
                        g.a().a(true, 0L, systemMusicData);
                    }
                });
                this.d.a();
                com.fotoable.youtube.music.util.b.b("播放器-播放Radio次数");
            }
            if (z) {
                f();
            }
        }
    }

    public void a(boolean z) {
        if (this.d != null && this.i != null) {
            this.f = false;
            if (z) {
                f();
            }
            this.g = false;
            this.d.a();
        }
    }

    public void b(boolean z) {
        this.g = true;
        if (this.d != null && this.i != null) {
            this.d.b();
        }
    }

    public void a(int i) {
        if (this.d != null && this.i != null) {
            this.d.a(i);
        }
    }

    public void d() {
        if (this.d != null) {
            this.d.e();
        }
    }

    private void f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final Context context, RadioModel radioModel, boolean z2, long j, long j2) {
        final PlayerInfo playerInfo;
        if (j > j2) {
            j = 0;
        }
        if (com.fotoable.youtube.music.newplayer.b.b.a().c().size() > 0 || radioModel != null) {
            PlayerInfo playerInfo2 = new PlayerInfo();
            playerInfo2.covert(radioModel);
            playerInfo2.setPlaying(z2);
            playerInfo2.setCurrentTime(j);
            playerInfo2.setPlayState(this.d.c() ? 1 : 0);
            playerInfo2.setPlayState(this.h);
            playerInfo2.setTotalTime(j2);
            playerInfo = playerInfo2;
        } else {
            playerInfo = new PlayerInfo();
        }
        if (com.fotoable.youtube.music.a.o()) {
            Intent intent = new Intent(context, QuickToolsService.class);
            intent.setAction("action_syn_music_data");
            intent.putExtra("music", playerInfo);
            intent.putExtra("isPlaying", z2 ? 1 : 0);
            intent.putExtra("duration", "" + playerInfo.getDuration());
            intent.putExtra("currentTime", 1 * j);
            intent.putExtra("totalTime", 1 * j2);
            context.startService(intent);
        }
        if (x.a()) {
            Intent intent2 = new Intent(context, MusicWidgetService.class);
            intent2.setAction("action_syn_music_data");
            intent2.putExtra("music", playerInfo);
            intent2.putExtra("isPlaying", z2 ? 1 : 0);
            intent2.putExtra("duration", "" + playerInfo.getDuration());
            intent2.putExtra("currentTime", 1 * j);
            intent2.putExtra("totalTime", 1 * j2);
            context.startService(intent2);
        }
        MainService.a(context, "syn_player_info", "music", playerInfo);
        if (!this.f) {
            this.e.post(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.c.a().a(context, playerInfo);
                }
            });
        }
    }
}
