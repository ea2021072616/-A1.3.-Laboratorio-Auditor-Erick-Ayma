package com.facebook.ads.internal.view.d.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
import com.facebook.ads.AdSettings;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
@TargetApi(14)
/* loaded from: classes.dex */
public class a extends TextureView implements TextureView.SurfaceTextureListener, c, ExoPlayer.EventListener, SimpleExoPlayer.VideoListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1712a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Uri f1713b;

    /* renamed from: c  reason: collision with root package name */
    private String f1714c;
    private e d;
    private Handler e;
    private Surface f;
    @Nullable
    private SimpleExoPlayer g;
    private MediaController h;
    private d i;
    private d j;
    private View k;
    private boolean l;
    private boolean m;
    private long n;
    private long o;
    private long p;
    private int q;
    private int r;
    private float s;
    private int t;

    public a(Context context) {
        super(context);
        this.i = d.IDLE;
        this.j = d.IDLE;
        this.l = false;
        this.m = false;
        this.s = 1.0f;
        this.t = -1;
        this.e = new Handler();
    }

    private void c() {
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        this.g = ExoPlayerFactory.newSimpleInstance(getContext(), new DefaultTrackSelector(this.e, new AdaptiveVideoTrackSelection.Factory(defaultBandwidthMeter)), new DefaultLoadControl());
        this.g.setVideoListener(this);
        this.g.addListener(this);
        this.g.setPlayWhenReady(false);
        if (this.m) {
            this.h = new MediaController(getContext());
            this.h.setAnchorView(this.k == null ? this : this.k);
            this.h.setMediaPlayer(new MediaController.MediaPlayerControl() { // from class: com.facebook.ads.internal.view.d.c.a.1
                @Override // android.widget.MediaController.MediaPlayerControl
                public boolean canPause() {
                    return true;
                }

                @Override // android.widget.MediaController.MediaPlayerControl
                public boolean canSeekBackward() {
                    return true;
                }

                @Override // android.widget.MediaController.MediaPlayerControl
                public boolean canSeekForward() {
                    return true;
                }

                @Override // android.widget.MediaController.MediaPlayerControl
                public int getAudioSessionId() {
                    return a.this.g.getAudioSessionId();
                }

                @Override // android.widget.MediaController.MediaPlayerControl
                public int getBufferPercentage() {
                    return a.this.g.getBufferedPercentage();
                }

                @Override // android.widget.MediaController.MediaPlayerControl
                public int getCurrentPosition() {
                    return a.this.getCurrentPosition();
                }

                @Override // android.widget.MediaController.MediaPlayerControl
                public int getDuration() {
                    return a.this.getDuration();
                }

                @Override // android.widget.MediaController.MediaPlayerControl
                public boolean isPlaying() {
                    return a.this.g.getPlayWhenReady();
                }

                @Override // android.widget.MediaController.MediaPlayerControl
                public void pause() {
                    a.this.pause();
                }

                @Override // android.widget.MediaController.MediaPlayerControl
                public void seekTo(int i) {
                    a.this.seekTo(i);
                }

                @Override // android.widget.MediaController.MediaPlayerControl
                public void start() {
                    a.this.start();
                }
            });
            this.h.setEnabled(true);
        }
        if (this.f1714c == null || this.f1714c.length() <= 0 || AdSettings.isTestMode(getContext())) {
            this.g.prepare(new ExtractorMediaSource(this.f1713b, new DefaultDataSourceFactory(getContext(), Util.getUserAgent(getContext(), "ads"), defaultBandwidthMeter), new DefaultExtractorsFactory(), null, null));
        }
        setVideoState(d.PREPARING);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    private void d() {
        if (this.f != null) {
            this.f.release();
            this.f = null;
        }
        if (this.g != null) {
            this.g.release();
            this.g = null;
        }
        this.h = null;
        this.l = false;
        setVideoState(d.IDLE);
    }

    private void setVideoState(d dVar) {
        if (dVar != this.i) {
            this.i = dVar;
            if (this.i == d.STARTED) {
                this.l = true;
            }
            if (this.d != null) {
                this.d.a(dVar);
            }
        }
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void a() {
        setVideoState(d.PLAYBACK_COMPLETED);
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void a(boolean z) {
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void b() {
        this.j = d.IDLE;
        if (this.g != null) {
            this.g.stop();
            this.g.release();
            this.g = null;
        }
        setVideoState(d.IDLE);
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public int getCurrentPosition() {
        if (this.g != null) {
            return (int) this.g.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public int getDuration() {
        if (this.g == null) {
            return 0;
        }
        return (int) this.g.getDuration();
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public long getInitialBufferTime() {
        return this.o;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public d getState() {
        return this.i;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public d getTargetState() {
        return this.j;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public int getVideoHeight() {
        return this.r;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public int getVideoWidth() {
        return this.q;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public float getVolume() {
        return this.s;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
    public void onLoadingChanged(boolean z) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.q, i);
        int defaultSize2 = getDefaultSize(this.r, i2);
        if (this.q > 0 && this.r > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.q * defaultSize2 < this.r * size) {
                    defaultSize = (this.q * defaultSize2) / this.r;
                } else if (this.q * defaultSize2 > this.r * size) {
                    defaultSize2 = (this.r * size) / this.q;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i3 = (this.r * size) / this.q;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.q * defaultSize2) / this.r;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i4 = this.q;
                int i5 = this.r;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = i4;
                } else {
                    defaultSize = (this.q * defaultSize2) / this.r;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.r * size) / this.q;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        setVideoState(d.ERROR);
        ThrowableExtension.printStackTrace(exoPlaybackException);
        com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(exoPlaybackException, "[ExoPlayer] Error during playback of ExoPlayer"));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        switch (i) {
            case 1:
                setVideoState(d.IDLE);
                return;
            case 2:
                if (this.t >= 0) {
                    int i2 = this.t;
                    this.t = -1;
                    this.d.a(i2, getCurrentPosition());
                    return;
                }
                return;
            case 3:
                if (this.n != 0) {
                    this.o = System.currentTimeMillis() - this.n;
                }
                setRequestedVolume(this.s);
                if (this.p > 0 && this.p < this.g.getDuration()) {
                    this.g.seekTo(this.p);
                    this.p = 0L;
                }
                if (this.g.getCurrentPosition() != 0 && !z && this.l) {
                    setVideoState(d.PAUSED);
                    return;
                } else if (z || this.i == d.PLAYBACK_COMPLETED) {
                    return;
                } else {
                    setVideoState(d.PREPARED);
                    if (this.j == d.STARTED) {
                        start();
                        this.j = d.IDLE;
                        return;
                    }
                    return;
                }
            case 4:
                if (z) {
                    setVideoState(d.PLAYBACK_COMPLETED);
                }
                if (this.g != null) {
                    this.g.setPlayWhenReady(false);
                    if (!z) {
                        this.g.seekToDefaultPosition();
                    }
                }
                this.l = false;
                return;
            default:
                return;
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
    public void onPositionDiscontinuity() {
    }

    @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
    public void onRenderedFirstFrame() {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f = new Surface(surfaceTexture);
        if (this.f == null) {
            this.f = new Surface(surfaceTexture);
        }
        if (this.g == null) {
            return;
        }
        this.g.setVideoSurface(this.f);
        if (this.i != d.PAUSED || this.j == d.PAUSED) {
            return;
        }
        start();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.f != null) {
            this.f.release();
            this.f = null;
            if (this.g != null) {
                this.g.setVideoSurface(null);
            }
        }
        if (this.i != d.PAUSED) {
            this.j = this.m ? d.STARTED : this.i;
            pause();
            return true;
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
    public void onTimelineChanged(Timeline timeline, Object obj) {
    }

    @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        this.q = i;
        this.r = i2;
        if (this.q == 0 || this.r == 0) {
            return;
        }
        requestLayout();
    }

    @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
    public void onVideoTracksDisabled() {
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.g == null) {
            return;
        }
        if (z) {
            if (this.i != d.PAUSED || this.j == d.PAUSED) {
                return;
            }
            start();
        } else if (this.i != d.PAUSED) {
            this.j = this.m ? d.STARTED : this.i;
            pause();
        }
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void pause() {
        if (this.g != null) {
            this.g.setPlayWhenReady(false);
        } else {
            setVideoState(d.IDLE);
        }
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void seekTo(int i) {
        if (this.g == null) {
            this.p = i;
            return;
        }
        this.t = getCurrentPosition();
        this.g.seekTo(i);
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setControlsAnchorView(View view) {
        this.k = view;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.ads.internal.view.d.c.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (a.this.h != null && motionEvent.getAction() == 1) {
                    if (a.this.h.isShowing()) {
                        a.this.h.hide();
                    } else {
                        a.this.h.show();
                    }
                }
                return true;
            }
        });
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setFullScreen(boolean z) {
        this.m = z;
        if (z) {
            setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.ads.internal.view.d.c.a.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (a.this.h != null && motionEvent.getAction() == 1) {
                        if (a.this.h.isShowing()) {
                            a.this.h.hide();
                        } else {
                            a.this.h.show();
                        }
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setRequestedVolume(float f) {
        this.s = f;
        if (this.g == null || this.i == d.PREPARING || this.i == d.IDLE) {
            return;
        }
        this.g.setVolume(f);
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setVideoMPD(String str) {
        this.f1714c = str;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setVideoStateChangeListener(e eVar) {
        this.d = eVar;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setup(Uri uri) {
        if (this.g != null && this.i != d.PLAYBACK_COMPLETED) {
            d();
        }
        this.f1713b = uri;
        setSurfaceTextureListener(this);
        c();
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void start() {
        this.j = d.STARTED;
        if (this.g == null) {
            setup(this.f1713b);
        } else if (this.i == d.PREPARED || this.i == d.PAUSED || this.i == d.PLAYBACK_COMPLETED) {
            this.g.setPlayWhenReady(true);
            setVideoState(d.STARTED);
        }
    }
}
