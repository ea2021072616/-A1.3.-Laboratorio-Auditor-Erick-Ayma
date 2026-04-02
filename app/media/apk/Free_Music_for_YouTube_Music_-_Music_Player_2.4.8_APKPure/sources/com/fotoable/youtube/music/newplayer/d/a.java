package com.fotoable.youtube.music.newplayer.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.i;
import com.fotoable.youtube.music.newplayer.f;
import com.fotoable.youtube.music.newplayer.g;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.newplayer.model.SystemMusicData;
import com.fotoable.youtube.music.quicktools.service.QuickToolsService;
import com.fotoable.youtube.music.service.MainService;
import com.fotoable.youtube.music.service.MusicWidgetService;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.x;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import rx.l;
import rx.m;
/* compiled from: LocalMusicPlayer.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2900a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final a f2901b = new a();

    /* renamed from: c  reason: collision with root package name */
    private Context f2902c;
    private C0060a d;
    private Handler e;
    private boolean f = false;
    private LocalMusicModel g;

    public static a a() {
        return f2901b;
    }

    private a() {
    }

    public void a(Context context, Handler handler) {
        this.f2902c = context;
        this.e = handler;
        this.d = new C0060a();
        this.d.a(handler);
    }

    public void b() {
        this.f = true;
        b(false);
    }

    public boolean c() {
        if (this.d != null) {
            return this.d.d();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LocalMusicPlayer.java */
    /* renamed from: com.fotoable.youtube.music.newplayer.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0060a implements MediaPlayer.OnCompletionListener {
        private MediaPlayer g;
        private boolean h;
        private Handler i;
        private m k;

        /* renamed from: a  reason: collision with root package name */
        boolean f2908a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f2909b = false;

        /* renamed from: c  reason: collision with root package name */
        Runnable f2910c = new Runnable() { // from class: com.fotoable.youtube.music.newplayer.d.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                Log.d(a.f2900a, "mIsTrackPrepared, " + C0060a.this.f2908a);
                if (C0060a.this.f2908a) {
                    C0060a.this.f.start();
                    C0060a.this.g();
                    a.this.a(false, a.this.f2902c, a.this.g, true, C0060a.this.f.getCurrentPosition(), C0060a.this.f.getDuration());
                    return;
                }
                C0060a.this.i.postDelayed(C0060a.this.f2910c, 700L);
            }
        };
        MediaPlayer.OnPreparedListener d = new MediaPlayer.OnPreparedListener() { // from class: com.fotoable.youtube.music.newplayer.d.a.a.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setOnCompletionListener(C0060a.this);
                C0060a.this.f2908a = true;
            }
        };
        private boolean j = false;
        private MediaPlayer f = new MediaPlayer();

        public void a(Handler handler) {
            this.i = handler;
        }

        public C0060a() {
            this.f.setWakeMode(a.this.f2902c, 1);
            this.f.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.fotoable.youtube.music.newplayer.d.a.a.1
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    C0060a.this.a(mediaPlayer);
                    return true;
                }
            });
        }

        public void a(String str) {
            h.a(a.f2900a, "path:" + str);
            this.h = a(this.f, str);
            if (this.h) {
                b((String) null);
            }
        }

        public void b(String str) {
            try {
                this.f.setNextMediaPlayer(null);
            } catch (IllegalArgumentException e) {
                h.a(a.f2900a, "Next media player is current one, continuing");
            } catch (IllegalStateException e2) {
                h.a(a.f2900a, "Media player not initialized!");
                return;
            }
            if (this.g != null) {
                this.g.release();
                this.g = null;
            }
            if (!TextUtils.isEmpty(str)) {
                this.g = new MediaPlayer();
                this.g.setWakeMode(a.this.f2902c, 1);
                this.g.setAudioSessionId(c());
                if (a(this.f, str)) {
                    this.f.setNextMediaPlayer(this.g);
                } else if (this.g != null) {
                    this.g.release();
                    this.g = null;
                }
            }
        }

        public boolean a(MediaPlayer mediaPlayer, String str) {
            if (mediaPlayer == null) {
                return false;
            }
            try {
                mediaPlayer.reset();
                mediaPlayer.setAudioStreamType(3);
                if (str.startsWith("content://")) {
                    mediaPlayer.setOnPreparedListener(null);
                    mediaPlayer.setDataSource(a.this.f2902c, Uri.parse(str));
                    mediaPlayer.prepare();
                    this.f2908a = true;
                    mediaPlayer.setOnCompletionListener(this);
                } else {
                    mediaPlayer.setDataSource(str);
                    mediaPlayer.setOnPreparedListener(this.d);
                    mediaPlayer.prepareAsync();
                    this.f2909b = true;
                }
                return true;
            } catch (IOException e) {
                ThrowableExtension.printStackTrace(e);
                return true;
            } catch (IllegalStateException e2) {
                ThrowableExtension.printStackTrace(e2);
                return true;
            } catch (Exception e3) {
                ThrowableExtension.printStackTrace(e3);
                return true;
            }
        }

        public void a() {
            this.j = false;
            if (!this.f2909b) {
                if (!this.f.isPlaying()) {
                    this.f.start();
                    g();
                    a.this.a(false, a.this.f2902c, a.this.g, true, this.f.getCurrentPosition(), this.f.getDuration());
                    return;
                }
                return;
            }
            this.i.postDelayed(this.f2910c, 50L);
            g.a().a(true, 0L);
        }

        public void b() {
            g.a().a(false, this.f.getCurrentPosition());
            this.i.removeCallbacks(this.f2910c);
            if (this.f.isPlaying()) {
                this.f.pause();
            }
            a.this.a(false, a.this.f2902c, a.this.g, false, this.f.getCurrentPosition(), this.f.getDuration());
            e();
            h.a(a.f2900a, "暫停播放");
        }

        public long a(long j) {
            this.f.seekTo((int) j);
            return j;
        }

        public int c() {
            return this.f.getAudioSessionId();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (f.a().b() && com.fotoable.youtube.music.a.j()) {
                a.this.b(false);
                f.a().a(false);
                return;
            }
            a(mediaPlayer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MediaPlayer mediaPlayer) {
            if (com.fotoable.youtube.music.a.v()) {
                if (a.this.g != null && com.fotoable.youtube.music.newplayer.b.b.a().e() != null) {
                    if (a.this.g.getSongId() == com.fotoable.youtube.music.newplayer.b.b.a().e().getSongId() && this.j) {
                        a.this.g = com.fotoable.youtube.music.newplayer.b.b.a().b(false);
                    }
                } else {
                    a.this.g = com.fotoable.youtube.music.newplayer.b.b.a().b(false);
                }
                if (a.this.g != null) {
                    a(mediaPlayer, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "/" + a.this.g.getSongId());
                    a.this.g = a.this.g;
                    a.this.a(a.this.g, false);
                }
            }
        }

        public boolean d() {
            return this.f.isPlaying();
        }

        public void e() {
            if (this.k != null && !this.k.isUnsubscribed()) {
                this.k.unsubscribe();
                this.k = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            e();
            this.k = rx.f.a(0L, 1000L, TimeUnit.MILLISECONDS).b(new l<Long>() { // from class: com.fotoable.youtube.music.newplayer.d.a.a.4
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
                    g.a().a(C0060a.this.f.isPlaying(), C0060a.this.f.getCurrentPosition());
                    if (C0060a.this.f.getCurrentPosition() > 5000) {
                        C0060a.this.j = true;
                    }
                    a.this.a(false, a.this.f2902c, a.this.g, C0060a.this.f.isPlaying(), C0060a.this.f.getCurrentPosition(), C0060a.this.f.getDuration());
                    if (!f.a().f()) {
                        C0060a.this.b();
                    }
                }
            });
        }

        public void f() {
            a.this.a(false, a.this.f2902c, a.this.g, this.f.isPlaying(), this.f.getCurrentPosition(), this.f.getDuration());
        }
    }

    public void a(LocalMusicModel localMusicModel) {
        this.g = localMusicModel;
        if (this.d != null && localMusicModel != null) {
            this.d.a(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "/" + this.g.getSongId());
            a(false, this.f2902c, localMusicModel, false, 0L, 0L);
            return;
        }
        a(false, this.f2902c, null, false, 0L, 0L);
    }

    public void a(LocalMusicModel localMusicModel, boolean z) {
        this.g = localMusicModel;
        if (this.d != null && localMusicModel != null) {
            this.f = false;
            this.d.a(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "/" + this.g.getSongId());
            final SystemMusicData systemMusicData = new SystemMusicData();
            systemMusicData.setTitle(localMusicModel.getSongName());
            systemMusicData.setArtist(localMusicModel.getArtistName());
            systemMusicData.setAlbum(localMusicModel.getAlbumName());
            systemMusicData.setDuration(localMusicModel.getDuration());
            systemMusicData.setNumTracks(com.fotoable.youtube.music.newplayer.b.b.a().c().size());
            systemMusicData.setTrackNumber(com.fotoable.youtube.music.newplayer.b.b.a().g());
            i.c(this.f2902c).a(localMusicModel.getAlbumData()).l().b(com.bumptech.glide.load.b.b.ALL).a((com.bumptech.glide.a<String, Bitmap>) new com.bumptech.glide.g.b.g<Bitmap>() { // from class: com.fotoable.youtube.music.newplayer.d.a.1
                @Override // com.bumptech.glide.g.b.j
                /* renamed from: a */
                public void onResourceReady(Bitmap bitmap, com.bumptech.glide.g.a.c<? super Bitmap> cVar) {
                    systemMusicData.setAlbumArt(bitmap);
                    g.a().a(true, 0L, systemMusicData);
                }
            });
            this.d.a();
            if (z) {
            }
        }
    }

    public void a(boolean z) {
        if (this.d != null && this.g != null) {
            this.f = false;
            if (z) {
                f();
            }
            this.d.a();
        }
    }

    public void b(boolean z) {
        this.f = false;
        if (this.d != null && this.g != null) {
            this.d.b();
        }
    }

    public void a(int i) {
        if (this.d != null && this.g != null) {
            this.d.a(i);
        }
    }

    private void f() {
    }

    public void d() {
        if (this.d != null) {
            this.d.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final Context context, LocalMusicModel localMusicModel, boolean z2, long j, long j2) {
        if (j > j2) {
            j = 0;
        }
        final PlayerInfo playerInfo = null;
        if (com.fotoable.youtube.music.newplayer.b.b.a().c().size() > 0 || localMusicModel != null) {
            PlayerInfo playerInfo2 = new PlayerInfo();
            playerInfo2.covert(localMusicModel);
            playerInfo2.setPlaying(z2);
            playerInfo2.setCurrentTime(j);
            playerInfo2.setPlayState(this.d.d() ? 1 : 0);
            playerInfo2.setTotalTime(j2);
            playerInfo = playerInfo2;
        }
        Intent intent = new Intent(context, QuickToolsService.class);
        intent.setAction("action_syn_music_data");
        intent.putExtra("music", playerInfo);
        context.startService(intent);
        if (x.a()) {
            Intent intent2 = new Intent(context, MusicWidgetService.class);
            intent2.setAction("action_syn_music_data");
            intent2.putExtra("music", playerInfo);
            context.startService(intent2);
        }
        if (playerInfo != null && com.fotoable.youtube.music.newplayer.b.b.a().e() != null) {
            if (playerInfo.getSongId() == com.fotoable.youtube.music.newplayer.b.b.a().e().getSongId()) {
                MainService.a(context, "syn_player_info", "music", playerInfo);
            } else {
                h.a(f2900a, "本地丢弃通知，不发送..." + playerInfo.getSongId() + "    " + com.fotoable.youtube.music.newplayer.b.b.a().e().getSongId());
            }
        } else {
            h.a(f2900a, "空，发送，");
            MainService.a(context, "syn_player_info", "music", playerInfo);
        }
        if (!this.f) {
            this.e.post(new Runnable() { // from class: com.fotoable.youtube.music.newplayer.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.fotoable.youtube.music.newplayer.c.a().a(context, playerInfo);
                }
            });
        }
    }
}
