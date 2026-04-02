package com.pili.pldroid.player.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.IMediaController;
import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.PlayerState;
import com.pili.pldroid.player.common.a;
import com.pili.pldroid.player.widget.a;
import java.util.HashMap;
import java.util.Map;
@TargetApi(14)
/* loaded from: classes2.dex */
public class PLVideoTextureView extends com.pili.pldroid.player.widget.a {

    /* renamed from: c  reason: collision with root package name */
    private View f5090c;
    private a d;
    private int e;
    private SurfaceTexture f;

    @Override // com.pili.pldroid.player.widget.a, com.pili.pldroid.player.IMediaController.MediaPlayerControl
    public /* bridge */ /* synthetic */ boolean canPause() {
        return super.canPause();
    }

    @Override // com.pili.pldroid.player.widget.a, com.pili.pldroid.player.IMediaController.MediaPlayerControl
    public /* bridge */ /* synthetic */ boolean canSeekBackward() {
        return super.canSeekBackward();
    }

    @Override // com.pili.pldroid.player.widget.a, com.pili.pldroid.player.IMediaController.MediaPlayerControl
    public /* bridge */ /* synthetic */ boolean canSeekForward() {
        return super.canSeekForward();
    }

    @Override // com.pili.pldroid.player.widget.a, com.pili.pldroid.player.IMediaController.MediaPlayerControl
    public /* bridge */ /* synthetic */ int getBufferPercentage() {
        return super.getBufferPercentage();
    }

    @Override // com.pili.pldroid.player.widget.a, com.pili.pldroid.player.IMediaController.MediaPlayerControl
    public /* bridge */ /* synthetic */ long getCurrentPosition() {
        return super.getCurrentPosition();
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ int getDisplayAspectRatio() {
        return super.getDisplayAspectRatio();
    }

    @Override // com.pili.pldroid.player.widget.a, com.pili.pldroid.player.IMediaController.MediaPlayerControl
    public /* bridge */ /* synthetic */ long getDuration() {
        return super.getDuration();
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ HashMap getMetadata() {
        return super.getMetadata();
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ PlayerState getPlayerState() {
        return super.getPlayerState();
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ String getResolutionInline() {
        return super.getResolutionInline();
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ long getVideoBitrate() {
        return super.getVideoBitrate();
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ int getVideoFps() {
        return super.getVideoFps();
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ boolean isLooping() {
        return super.isLooping();
    }

    @Override // com.pili.pldroid.player.widget.a, com.pili.pldroid.player.IMediaController.MediaPlayerControl
    public /* bridge */ /* synthetic */ boolean isPlaying() {
        return super.isPlaying();
    }

    @Override // com.pili.pldroid.player.widget.a, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.pili.pldroid.player.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.pili.pldroid.player.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // com.pili.pldroid.player.widget.a, com.pili.pldroid.player.IMediaController.MediaPlayerControl
    public /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    @Override // com.pili.pldroid.player.widget.a, com.pili.pldroid.player.IMediaController.MediaPlayerControl
    public /* bridge */ /* synthetic */ void seekTo(long j) {
        super.seekTo(j);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setAVOptions(AVOptions aVOptions) {
        super.setAVOptions(aVOptions);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setBufferingIndicator(View view) {
        super.setBufferingIndicator(view);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setCoverView(View view) {
        super.setCoverView(view);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setDebugLoggingEnabled(boolean z) {
        super.setDebugLoggingEnabled(z);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setDisplayAspectRatio(int i) {
        super.setDisplayAspectRatio(i);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setLooping(boolean z) {
        super.setLooping(z);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setMediaController(IMediaController iMediaController) {
        super.setMediaController(iMediaController);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setOnBufferingUpdateListener(PLMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        super.setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setOnCompletionListener(PLMediaPlayer.OnCompletionListener onCompletionListener) {
        super.setOnCompletionListener(onCompletionListener);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setOnErrorListener(PLMediaPlayer.OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setOnInfoListener(PLMediaPlayer.OnInfoListener onInfoListener) {
        super.setOnInfoListener(onInfoListener);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setOnMediaDataListener(PLMediaPlayer.a aVar) {
        super.setOnMediaDataListener(aVar);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setOnPreparedListener(PLMediaPlayer.OnPreparedListener onPreparedListener) {
        super.setOnPreparedListener(onPreparedListener);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setOnSeekCompleteListener(PLMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        super.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setOnVideoSizeChangedListener(PLMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        super.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setScreenOnWhilePlaying(boolean z) {
        super.setScreenOnWhilePlaying(z);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setVideoPath(String str) {
        super.setVideoPath(str);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setVideoPath(String str, Map map) {
        super.setVideoPath(str, map);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setVideoURI(Uri uri) {
        super.setVideoURI(uri);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setVideoURI(Uri uri, Map map) {
        super.setVideoURI(uri, map);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setVolume(float f, float f2) {
        super.setVolume(f, f2);
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void setWakeMode(Context context, int i) {
        super.setWakeMode(context, i);
    }

    @Override // com.pili.pldroid.player.widget.a, com.pili.pldroid.player.IMediaController.MediaPlayerControl
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.pili.pldroid.player.widget.a
    public /* bridge */ /* synthetic */ void stopPlayback() {
        super.stopPlayback();
    }

    public PLVideoTextureView(Context context) {
        super(context);
        this.e = 0;
    }

    public PLVideoTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
    }

    public PLVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
    }

    @TargetApi(21)
    public PLVideoTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.e = 0;
    }

    public TextureView getTextureView() {
        return this.d;
    }

    public void setMirror(boolean z) {
        setScaleX(z ? -1.0f : 1.0f);
    }

    public boolean setDisplayOrientation(int i) {
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            return false;
        }
        int i2 = i % 360;
        if (this.e != i2) {
            this.e = i2;
            requestLayout();
        }
        return true;
    }

    public int getDisplayOrientation() {
        return this.e;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        this.f5090c = getChildAt(0);
        this.f5090c.setPivotX(0.0f);
        this.f5090c.setPivotY(0.0f);
        super.onFinishInflate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f5090c == null) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        switch (this.e) {
            case 0:
            case 180:
                this.f5090c.layout(0, 0, i5, i6);
                return;
            case 90:
            case 270:
                this.f5090c.layout(0, 0, i6, i5);
                return;
            default:
                return;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3 = 0;
        if (this.f5090c == null) {
            super.onMeasure(i, i2);
            return;
        }
        switch (this.e) {
            case 0:
            case 180:
                measureChild(this.f5090c, i, i2);
                measuredHeight = this.f5090c.getMeasuredWidth();
                i3 = this.f5090c.getMeasuredHeight();
                break;
            case 90:
            case 270:
                measureChild(this.f5090c, i2, i);
                measuredHeight = this.f5090c.getMeasuredHeight();
                i3 = this.f5090c.getMeasuredWidth();
                break;
            default:
                measuredHeight = 0;
                break;
        }
        setMeasuredDimension(measuredHeight, i3);
        switch (this.e) {
            case 0:
                this.f5090c.setTranslationX(0.0f);
                this.f5090c.setTranslationY(0.0f);
                break;
            case 90:
                this.f5090c.setTranslationX(0.0f);
                this.f5090c.setTranslationY(i3);
                break;
            case 180:
                this.f5090c.setTranslationX(measuredHeight);
                this.f5090c.setTranslationY(i3);
                break;
            case 270:
                this.f5090c.setTranslationX(measuredHeight);
                this.f5090c.setTranslationY(0.0f);
                break;
        }
        this.f5090c.setRotation(-this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pili.pldroid.player.widget.a
    public void a(Context context) {
        this.d = new a(context);
        super.a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseSurfactexture();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pili.pldroid.player.widget.a
    @TargetApi(16)
    public void a(PLMediaPlayer pLMediaPlayer, Surface surface) {
        if (pLMediaPlayer != null && !this.f5101b && this.f != null && Build.VERSION.SDK_INT >= 16) {
            this.d.setSurfaceTexture(this.f);
            return;
        }
        super.a(pLMediaPlayer, surface);
        this.f5101b = false;
    }

    public void releaseSurfactexture() {
        if (this.f != null) {
            this.f.release();
            this.f = null;
            this.f5100a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pili.pldroid.player.widget.a
    public void a() {
        if (this.f == null && Build.VERSION.SDK_INT < 16) {
            super.a();
        }
    }

    @Override // com.pili.pldroid.player.widget.a
    protected a.InterfaceC0100a getRenderView() {
        return this.d;
    }

    /* loaded from: classes2.dex */
    protected class a extends TextureView implements a.InterfaceC0100a {

        /* renamed from: b  reason: collision with root package name */
        private a.InterfaceC0100a.InterfaceC0101a f5092b;

        /* renamed from: c  reason: collision with root package name */
        private int f5093c;
        private int d;
        private TextureView.SurfaceTextureListener e;

        public a(Context context) {
            super(context);
            this.f5093c = 0;
            this.d = 0;
            this.e = new TextureView.SurfaceTextureListener() { // from class: com.pili.pldroid.player.widget.PLVideoTextureView.a.1
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    if (a.this.f5092b != null) {
                        a.this.f5092b.a(new Surface(surfaceTexture), i, i2);
                    }
                    if (PLVideoTextureView.this.f == null) {
                        PLVideoTextureView.this.f = surfaceTexture;
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                    if (a.this.f5092b != null) {
                        a.this.f5092b.b(new Surface(surfaceTexture), i, i2);
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    if (a.this.f5092b != null) {
                        a.this.f5092b.a(new Surface(surfaceTexture));
                        return false;
                    }
                    return false;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }
            };
            setSurfaceTextureListener(this.e);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            a.C0096a a2 = com.pili.pldroid.player.common.a.a(PLVideoTextureView.this.getDisplayAspectRatio(), i, i2, this.f5093c, this.d);
            setMeasuredDimension(a2.f5021a, a2.f5022b);
        }

        @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a
        public View getView() {
            return this;
        }

        @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a
        public void a(int i, int i2) {
            this.f5093c = i;
            this.d = i2;
            requestLayout();
        }

        @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a
        public void setRenderCallback(a.InterfaceC0100a.InterfaceC0101a interfaceC0101a) {
            this.f5092b = interfaceC0101a;
        }
    }
}
