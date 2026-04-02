package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzzt;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
@zzzt
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzd extends zzy implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzcfd = new HashMap();
    private final zzar zzcfe;
    private final boolean zzcff;
    private int zzcfg;
    private int zzcfh;
    private MediaPlayer zzcfi;
    private Uri zzcfj;
    private int zzcfk;
    private int zzcfl;
    private int zzcfm;
    private int zzcfn;
    private int zzcfo;
    private zzap zzcfp;
    private boolean zzcfq;
    private int zzcfr;
    private zzx zzcfs;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzcfd.put(Integer.valueOf((int) IMediaPlayer.MEDIA_ERROR_IO), "MEDIA_ERROR_IO");
            zzcfd.put(Integer.valueOf((int) IMediaPlayer.MEDIA_ERROR_MALFORMED), "MEDIA_ERROR_MALFORMED");
            zzcfd.put(Integer.valueOf((int) IMediaPlayer.MEDIA_ERROR_UNSUPPORTED), "MEDIA_ERROR_UNSUPPORTED");
            zzcfd.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzcfd.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzcfd.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzcfd.put(1, "MEDIA_ERROR_UNKNOWN");
        zzcfd.put(1, "MEDIA_INFO_UNKNOWN");
        zzcfd.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzcfd.put(701, "MEDIA_INFO_BUFFERING_START");
        zzcfd.put(702, "MEDIA_INFO_BUFFERING_END");
        zzcfd.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzcfd.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzcfd.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzcfd.put(Integer.valueOf((int) IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzcfd.put(Integer.valueOf((int) IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzd(Context context, boolean z, boolean z2, zzaq zzaqVar, zzar zzarVar) {
        super(context);
        this.zzcfg = 0;
        this.zzcfh = 0;
        setSurfaceTextureListener(this);
        this.zzcfe = zzarVar;
        this.zzcfq = z;
        this.zzcff = z2;
        this.zzcfe.zza(this);
    }

    private final void zza(float f) {
        if (this.zzcfi == null) {
            zzafx.zzcs("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
            return;
        }
        try {
            this.zzcfi.setVolume(f, f);
        } catch (IllegalStateException e) {
        }
    }

    private final void zzmh() {
        SurfaceTexture surfaceTexture;
        zzafx.v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture2 = getSurfaceTexture();
        if (this.zzcfj == null || surfaceTexture2 == null) {
            return;
        }
        zzr(false);
        try {
            zzbv.zzes();
            this.zzcfi = new MediaPlayer();
            this.zzcfi.setOnBufferingUpdateListener(this);
            this.zzcfi.setOnCompletionListener(this);
            this.zzcfi.setOnErrorListener(this);
            this.zzcfi.setOnInfoListener(this);
            this.zzcfi.setOnPreparedListener(this);
            this.zzcfi.setOnVideoSizeChangedListener(this);
            this.zzcfm = 0;
            if (this.zzcfq) {
                this.zzcfp = new zzap(getContext());
                this.zzcfp.zza(surfaceTexture2, getWidth(), getHeight());
                this.zzcfp.start();
                surfaceTexture = this.zzcfp.zznj();
                if (surfaceTexture == null) {
                    this.zzcfp.zzni();
                    this.zzcfp = null;
                }
                this.zzcfi.setDataSource(getContext(), this.zzcfj);
                zzbv.zzet();
                this.zzcfi.setSurface(new Surface(surfaceTexture));
                this.zzcfi.setAudioStreamType(3);
                this.zzcfi.setScreenOnWhilePlaying(true);
                this.zzcfi.prepareAsync();
                zzv(1);
            }
            surfaceTexture = surfaceTexture2;
            this.zzcfi.setDataSource(getContext(), this.zzcfj);
            zzbv.zzet();
            this.zzcfi.setSurface(new Surface(surfaceTexture));
            this.zzcfi.setAudioStreamType(3);
            this.zzcfi.setScreenOnWhilePlaying(true);
            this.zzcfi.prepareAsync();
            zzv(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e) {
            String valueOf = String.valueOf(this.zzcfj);
            zzafx.zzc(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
            onError(this.zzcfi, 1, 0);
        }
    }

    private final void zzmi() {
        if (this.zzcff && zzmj() && this.zzcfi.getCurrentPosition() > 0 && this.zzcfh != 3) {
            zzafx.v("AdMediaPlayerView nudging MediaPlayer");
            zza(0.0f);
            this.zzcfi.start();
            int currentPosition = this.zzcfi.getCurrentPosition();
            long currentTimeMillis = zzbv.zzeg().currentTimeMillis();
            while (zzmj() && this.zzcfi.getCurrentPosition() == currentPosition && zzbv.zzeg().currentTimeMillis() - currentTimeMillis <= 250) {
            }
            this.zzcfi.pause();
            zzmk();
        }
    }

    private final boolean zzmj() {
        return (this.zzcfi == null || this.zzcfg == -1 || this.zzcfg == 0 || this.zzcfg == 1) ? false : true;
    }

    private final void zzr(boolean z) {
        zzafx.v("AdMediaPlayerView release");
        if (this.zzcfp != null) {
            this.zzcfp.zzni();
            this.zzcfp = null;
        }
        if (this.zzcfi != null) {
            this.zzcfi.reset();
            this.zzcfi.release();
            this.zzcfi = null;
            zzv(0);
            if (z) {
                this.zzcfh = 0;
                this.zzcfh = 0;
            }
        }
    }

    private final void zzv(int i) {
        if (i == 3) {
            this.zzcfe.zznm();
            this.zzchj.zznm();
        } else if (this.zzcfg == 3) {
            this.zzcfe.zznn();
            this.zzchj.zznn();
        }
        this.zzcfg = i;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final int getCurrentPosition() {
        if (zzmj()) {
            return this.zzcfi.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final int getDuration() {
        if (zzmj()) {
            return this.zzcfi.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final int getVideoHeight() {
        if (this.zzcfi != null) {
            return this.zzcfi.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final int getVideoWidth() {
        if (this.zzcfi != null) {
            return this.zzcfi.getVideoWidth();
        }
        return 0;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzcfm = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzafx.v("AdMediaPlayerView completion");
        zzv(5);
        this.zzcfh = 5;
        zzahf.zzdbo.post(new zzf(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzcfd.get(Integer.valueOf(i));
        String str2 = zzcfd.get(Integer.valueOf(i2));
        zzafx.zzcs(new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer error: ").append(str).append(":").append(str2).toString());
        zzv(-1);
        this.zzcfh = -1;
        zzahf.zzdbo.post(new zzg(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzcfd.get(Integer.valueOf(i));
        String str2 = zzcfd.get(Integer.valueOf(i2));
        zzafx.v(new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer info: ").append(str).append(":").append(str2).toString());
        return true;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.zzcfk, i);
        int defaultSize2 = getDefaultSize(this.zzcfl, i2);
        if (this.zzcfk > 0 && this.zzcfl > 0 && this.zzcfp == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.zzcfk * defaultSize2 < this.zzcfl * size) {
                    defaultSize = (this.zzcfk * defaultSize2) / this.zzcfl;
                } else if (this.zzcfk * defaultSize2 > this.zzcfl * size) {
                    defaultSize2 = (this.zzcfl * size) / this.zzcfk;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i3 = (this.zzcfl * size) / this.zzcfk;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.zzcfk * defaultSize2) / this.zzcfl;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i4 = this.zzcfk;
                int i5 = this.zzcfl;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = i4;
                } else {
                    defaultSize = (this.zzcfk * defaultSize2) / this.zzcfl;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.zzcfl * size) / this.zzcfk;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (this.zzcfp != null) {
            this.zzcfp.zzf(defaultSize, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            if ((this.zzcfn > 0 && this.zzcfn != defaultSize) || (this.zzcfo > 0 && this.zzcfo != defaultSize2)) {
                zzmi();
            }
            this.zzcfn = defaultSize;
            this.zzcfo = defaultSize2;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzafx.v("AdMediaPlayerView prepared");
        zzv(2);
        this.zzcfe.zzmw();
        zzahf.zzdbo.post(new zze(this));
        this.zzcfk = mediaPlayer.getVideoWidth();
        this.zzcfl = mediaPlayer.getVideoHeight();
        if (this.zzcfr != 0) {
            seekTo(this.zzcfr);
        }
        zzmi();
        int i = this.zzcfk;
        zzafx.zzcr(new StringBuilder(62).append("AdMediaPlayerView stream dimensions: ").append(i).append(" x ").append(this.zzcfl).toString());
        if (this.zzcfh == 3) {
            play();
        }
        zzmk();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzafx.v("AdMediaPlayerView surface created");
        zzmh();
        zzahf.zzdbo.post(new zzh(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzafx.v("AdMediaPlayerView surface destroyed");
        if (this.zzcfi != null && this.zzcfr == 0) {
            this.zzcfr = this.zzcfi.getCurrentPosition();
        }
        if (this.zzcfp != null) {
            this.zzcfp.zzni();
        }
        zzahf.zzdbo.post(new zzj(this));
        zzr(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = true;
        zzafx.v("AdMediaPlayerView surface changed");
        boolean z2 = this.zzcfh == 3;
        if (this.zzcfk != i || this.zzcfl != i2) {
            z = false;
        }
        if (this.zzcfi != null && z2 && z) {
            if (this.zzcfr != 0) {
                seekTo(this.zzcfr);
            }
            play();
        }
        if (this.zzcfp != null) {
            this.zzcfp.zzf(i, i2);
        }
        zzahf.zzdbo.post(new zzi(this, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzcfe.zzb(this);
        this.zzchi.zza(surfaceTexture, this.zzcfs);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        zzafx.v(new StringBuilder(57).append("AdMediaPlayerView size changed: ").append(i).append(" x ").append(i2).toString());
        this.zzcfk = mediaPlayer.getVideoWidth();
        this.zzcfl = mediaPlayer.getVideoHeight();
        if (this.zzcfk == 0 || this.zzcfl == 0) {
            return;
        }
        requestLayout();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void pause() {
        zzafx.v("AdMediaPlayerView pause");
        if (zzmj() && this.zzcfi.isPlaying()) {
            this.zzcfi.pause();
            zzv(4);
            zzahf.zzdbo.post(new zzl(this));
        }
        this.zzcfh = 4;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void play() {
        zzafx.v("AdMediaPlayerView play");
        if (zzmj()) {
            this.zzcfi.start();
            zzv(3);
            this.zzchi.zzmx();
            zzahf.zzdbo.post(new zzk(this));
        }
        this.zzcfh = 3;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void seekTo(int i) {
        zzafx.v(new StringBuilder(34).append("AdMediaPlayerView seek ").append(i).toString());
        if (!zzmj()) {
            this.zzcfr = i;
            return;
        }
        this.zzcfi.seekTo(i);
        this.zzcfr = 0;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzie zze = zzie.zze(parse);
        if (zze != null) {
            parse = Uri.parse(zze.url);
        }
        this.zzcfj = parse;
        this.zzcfr = 0;
        zzmh();
        requestLayout();
        invalidate();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void stop() {
        zzafx.v("AdMediaPlayerView stop");
        if (this.zzcfi != null) {
            this.zzcfi.stop();
            this.zzcfi.release();
            this.zzcfi = null;
            zzv(0);
            this.zzcfh = 0;
        }
        this.zzcfe.onStop();
    }

    @Override // android.view.View
    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        return new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length()).append(name).append("@").append(hexString).toString();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void zza(float f, float f2) {
        if (this.zzcfp != null) {
            this.zzcfp.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void zza(zzx zzxVar) {
        this.zzcfs = zzxVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final String zzmg() {
        String valueOf = String.valueOf(this.zzcfq ? " spherical" : "");
        return valueOf.length() != 0 ? "MediaPlayer".concat(valueOf) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy, com.google.android.gms.ads.internal.overlay.zzau
    public final void zzmk() {
        zza(this.zzchj.zznp());
    }
}
