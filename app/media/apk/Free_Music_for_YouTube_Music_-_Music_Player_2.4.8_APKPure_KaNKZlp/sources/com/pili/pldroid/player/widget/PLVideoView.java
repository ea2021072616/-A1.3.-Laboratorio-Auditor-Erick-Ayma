package com.pili.pldroid.player.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.IMediaController;
import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.PlayerState;
import com.pili.pldroid.player.common.a;
import com.pili.pldroid.player.widget.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class PLVideoView extends com.pili.pldroid.player.widget.a {

    /* renamed from: c  reason: collision with root package name */
    private a f5095c;

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

    public PLVideoView(Context context) {
        super(context);
    }

    public PLVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PLVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public SurfaceView getSurfaceView() {
        return this.f5095c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pili.pldroid.player.widget.a
    public void a(Context context) {
        this.f5095c = new a(context);
        super.a(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pili.pldroid.player.widget.a
    public void a(PLMediaPlayer pLMediaPlayer, Surface surface) {
        super.a(pLMediaPlayer, surface);
        if (isPlaying() && !pLMediaPlayer.a()) {
            pLMediaPlayer.seekTo(pLMediaPlayer.getCurrentPosition());
        }
    }

    @Override // com.pili.pldroid.player.widget.a
    protected a.InterfaceC0100a getRenderView() {
        return this.f5095c;
    }

    /* loaded from: classes2.dex */
    private class a extends SurfaceView implements a.InterfaceC0100a {

        /* renamed from: b  reason: collision with root package name */
        private a.InterfaceC0100a.InterfaceC0101a f5097b;

        /* renamed from: c  reason: collision with root package name */
        private int f5098c;
        private int d;
        private SurfaceHolder.Callback e;

        public a(Context context) {
            super(context);
            this.f5098c = 0;
            this.d = 0;
            this.e = new SurfaceHolder.Callback() { // from class: com.pili.pldroid.player.widget.PLVideoView.a.1
                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    if (a.this.f5097b != null) {
                        a.this.f5097b.a(surfaceHolder.getSurface(), 0, 0);
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                    if (a.this.f5097b != null) {
                        a.this.f5097b.b(surfaceHolder.getSurface(), i2, i3);
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    if (a.this.f5097b != null) {
                        a.this.f5097b.a(surfaceHolder.getSurface());
                        PLVideoView.this.f5100a = null;
                    }
                }
            };
            getHolder().addCallback(this.e);
        }

        @Override // android.view.SurfaceView, android.view.View
        protected void onMeasure(int i, int i2) {
            a.C0096a a2 = com.pili.pldroid.player.common.a.a(PLVideoView.this.getDisplayAspectRatio(), i, i2, this.f5098c, this.d);
            setMeasuredDimension(a2.f5021a, a2.f5022b);
        }

        @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a
        public View getView() {
            return this;
        }

        @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a
        public void a(int i, int i2) {
            this.f5098c = i;
            this.d = i2;
            getHolder().setFixedSize(i, i2);
            requestLayout();
        }

        @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a
        public void setRenderCallback(a.InterfaceC0100a.InterfaceC0101a interfaceC0101a) {
            this.f5097b = interfaceC0101a;
        }
    }
}
