package com.facebook.ads.internal.view.d.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
@TargetApi(14)
/* loaded from: classes.dex */
public class b extends TextureView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, MediaController.MediaPlayerControl, c {
    private static final String p = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private Uri f1718a;

    /* renamed from: b  reason: collision with root package name */
    private e f1719b;

    /* renamed from: c  reason: collision with root package name */
    private Surface f1720c;
    @Nullable
    private MediaPlayer d;
    private MediaController e;
    private d f;
    private d g;
    private View h;
    private int i;
    private long j;
    private int k;
    private int l;
    private float m;
    private boolean n;
    private int o;
    private int q;
    private boolean r;

    public b(Context context) {
        super(context);
        this.f = d.IDLE;
        this.g = d.IDLE;
        this.i = 0;
        this.k = 0;
        this.l = 0;
        this.m = 1.0f;
        this.n = false;
        this.o = 3;
        this.q = 0;
        this.r = false;
    }

    private boolean c() {
        return this.f == d.PREPARED || this.f == d.STARTED || this.f == d.PAUSED || this.f == d.PLAYBACK_COMPLETED;
    }

    private void setVideoState(d dVar) {
        if (dVar != this.f) {
            this.f = dVar;
            if (this.f1719b != null) {
                this.f1719b.a(dVar);
            }
        }
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void a() {
        setVideoState(d.PLAYBACK_COMPLETED);
        b();
        this.i = 0;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void a(boolean z) {
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        this.r = true;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void b() {
        this.g = d.IDLE;
        if (this.d != null) {
            int currentPosition = this.d.getCurrentPosition();
            if (currentPosition > 0) {
                this.i = currentPosition;
            }
            this.d.stop();
            this.d.reset();
            this.d.release();
            this.d = null;
            if (this.e != null) {
                this.e.hide();
                this.e.setEnabled(false);
            }
        }
        setVideoState(d.IDLE);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return (this.f == d.PREPARING || this.f == d.PREPARED) ? false : true;
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
        if (this.d != null) {
            return this.d.getAudioSessionId();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.facebook.ads.internal.view.d.c.c
    public int getCurrentPosition() {
        if (this.d != null) {
            return this.d.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.facebook.ads.internal.view.d.c.c
    public int getDuration() {
        if (this.d == null) {
            return 0;
        }
        if (getState() == d.STARTED || getState() == d.PAUSED || getState() == d.PREPARED || getState() == d.PLAYBACK_COMPLETED) {
            return this.d.getDuration();
        }
        return 0;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public long getInitialBufferTime() {
        return this.j;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public d getState() {
        return this.f;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public d getTargetState() {
        return this.g;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public int getVideoHeight() {
        return this.l;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public int getVideoWidth() {
        return this.k;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public float getVolume() {
        return this.m;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.d != null && this.d.isPlaying();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.d != null) {
            this.d.pause();
        }
        setVideoState(d.PLAYBACK_COMPLETED);
        seekTo(0);
        this.i = 0;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.o <= 0 || getState() != d.STARTED) {
            setVideoState(d.ERROR);
            b();
            return true;
        }
        this.o--;
        b();
        start();
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        switch (i) {
            case 701:
                setVideoState(d.BUFFERING);
                return false;
            case 702:
                setVideoState(d.STARTED);
                return false;
            default:
                return false;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.k, i);
        int defaultSize2 = getDefaultSize(this.l, i2);
        if (this.k > 0 && this.l > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.k * defaultSize2 < this.l * size) {
                    defaultSize = (this.k * defaultSize2) / this.l;
                } else if (this.k * defaultSize2 > this.l * size) {
                    defaultSize2 = (this.l * size) / this.k;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i3 = (this.l * size) / this.k;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.k * defaultSize2) / this.l;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i4 = this.k;
                int i5 = this.l;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = i4;
                } else {
                    defaultSize = (this.k * defaultSize2) / this.l;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.l * size) / this.k;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        setVideoState(d.PREPARED);
        if (this.n && !this.r) {
            this.e = new MediaController(getContext());
            this.e.setAnchorView(this.h == null ? this : this.h);
            this.e.setMediaPlayer(this);
            this.e.setEnabled(true);
        }
        setRequestedVolume(this.m);
        this.k = mediaPlayer.getVideoWidth();
        this.l = mediaPlayer.getVideoHeight();
        if (this.i > 0) {
            if (this.i >= this.d.getDuration()) {
                this.i = 0;
            }
            this.d.seekTo(this.i);
            this.i = 0;
        }
        if (this.g == d.STARTED) {
            start();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        if (this.f1719b == null) {
            return;
        }
        this.f1719b.a(this.q, this.i);
        this.i = 0;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f1720c == null) {
            this.f1720c = new Surface(surfaceTexture);
        }
        if (this.d == null) {
            return;
        }
        this.d.setSurface(this.f1720c);
        if (this.f != d.PAUSED || this.g == d.PAUSED) {
            return;
        }
        start();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.f1720c != null) {
            this.f1720c.release();
            this.f1720c = null;
        }
        if (this.f != d.PAUSED) {
            this.g = this.n ? d.STARTED : this.f;
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

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.k = mediaPlayer.getVideoWidth();
        this.l = mediaPlayer.getVideoHeight();
        if (this.k == 0 || this.l == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.d == null) {
            return;
        }
        if (this.e == null || !this.e.isShowing()) {
            if (z) {
                if (this.f != d.PAUSED || this.g == d.PAUSED) {
                    return;
                }
                start();
            } else if (this.f != d.PAUSED) {
                this.g = this.n ? d.STARTED : this.f;
                pause();
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.facebook.ads.internal.view.d.c.c
    public void pause() {
        if (this.d == null) {
            setVideoState(d.IDLE);
        } else if (canPause()) {
            this.d.pause();
            if (this.f != d.PLAYBACK_COMPLETED) {
                setVideoState(d.PAUSED);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.facebook.ads.internal.view.d.c.c
    public void seekTo(int i) {
        if (this.d == null || !c()) {
            this.i = i;
        } else if (i >= getDuration() || i <= 0) {
        } else {
            this.q = getCurrentPosition();
            this.i = i;
            this.d.seekTo(i);
        }
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setControlsAnchorView(View view) {
        this.h = view;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.ads.internal.view.d.c.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (!b.this.r && b.this.e != null && motionEvent.getAction() == 1) {
                    if (b.this.e.isShowing()) {
                        b.this.e.hide();
                    } else {
                        b.this.e.show();
                    }
                }
                return true;
            }
        });
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setFullScreen(boolean z) {
        this.n = z;
        if (!this.n || this.r) {
            return;
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.ads.internal.view.d.c.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!b.this.r && b.this.e != null && motionEvent.getAction() == 1) {
                    if (b.this.e.isShowing()) {
                        b.this.e.hide();
                    } else {
                        b.this.e.show();
                    }
                }
                return true;
            }
        });
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setRequestedVolume(float f) {
        this.m = f;
        if (this.d == null || this.f == d.PREPARING || this.f == d.IDLE) {
            return;
        }
        this.d.setVolume(f, f);
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setVideoMPD(String str) {
    }

    @Override // com.facebook.ads.internal.view.d.c.c
    public void setVideoStateChangeListener(e eVar) {
        this.f1719b = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // com.facebook.ads.internal.view.d.c.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setup(android.net.Uri r9) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.d.c.b.setup(android.net.Uri):void");
    }

    @Override // android.widget.MediaController.MediaPlayerControl, com.facebook.ads.internal.view.d.c.c
    public void start() {
        this.g = d.STARTED;
        if (this.f == d.STARTED || this.f == d.PREPARED || this.f == d.IDLE || this.f == d.PAUSED || this.f == d.PLAYBACK_COMPLETED) {
            if (this.d == null) {
                setup(this.f1718a);
            } else {
                if (this.i > 0) {
                    this.d.seekTo(this.i);
                }
                this.d.start();
                setVideoState(d.STARTED);
            }
        }
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }
}
