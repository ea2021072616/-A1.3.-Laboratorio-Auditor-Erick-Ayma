package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.R;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.ui.PlaybackControlView;
import java.util.List;
@TargetApi(16)
/* loaded from: classes.dex */
public final class SimpleExoPlayerView extends FrameLayout {
    private final ComponentListener componentListener;
    private final PlaybackControlView controller;
    private int controllerShowTimeoutMs;
    private final AspectRatioFrameLayout layout;
    private SimpleExoPlayer player;
    private final View shutterView;
    private final SubtitleView subtitleLayout;
    private final View surfaceView;
    private boolean useController;

    public SimpleExoPlayerView(Context context) {
        this(context, null);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        this.useController = true;
        if (attributeSet == null) {
            i2 = 15000;
            i3 = 5000;
            i4 = 0;
            z = false;
            i5 = 5000;
        } else {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SimpleExoPlayerView, 0, 0);
            try {
                this.useController = obtainStyledAttributes.getBoolean(R.styleable.SimpleExoPlayerView_use_controller, this.useController);
                boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SimpleExoPlayerView_use_texture_view, false);
                int i6 = obtainStyledAttributes.getInt(R.styleable.SimpleExoPlayerView_resize_mode, 0);
                int i7 = obtainStyledAttributes.getInt(R.styleable.SimpleExoPlayerView_rewind_increment, 5000);
                int i8 = obtainStyledAttributes.getInt(R.styleable.SimpleExoPlayerView_fastforward_increment, 15000);
                int i9 = obtainStyledAttributes.getInt(R.styleable.SimpleExoPlayerView_show_timeout, 5000);
                obtainStyledAttributes.recycle();
                z = z2;
                i4 = i6;
                i3 = i7;
                i2 = i8;
                i5 = i9;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        LayoutInflater.from(context).inflate(R.layout.exo_simple_player_view, this);
        this.componentListener = new ComponentListener();
        this.layout = (AspectRatioFrameLayout) findViewById(R.id.video_frame);
        this.layout.setResizeMode(i4);
        this.shutterView = findViewById(R.id.shutter);
        this.subtitleLayout = (SubtitleView) findViewById(R.id.subtitles);
        this.subtitleLayout.setUserDefaultStyle();
        this.subtitleLayout.setUserDefaultTextSize();
        this.controller = (PlaybackControlView) findViewById(R.id.control);
        this.controller.hide();
        this.controller.setRewindIncrementMs(i3);
        this.controller.setFastForwardIncrementMs(i2);
        this.controllerShowTimeoutMs = i5;
        View textureView = z ? new TextureView(context) : new SurfaceView(context);
        textureView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.surfaceView = textureView;
        this.layout.addView(this.surfaceView, 0);
    }

    public SimpleExoPlayer getPlayer() {
        return this.player;
    }

    public void setPlayer(SimpleExoPlayer simpleExoPlayer) {
        if (this.player != simpleExoPlayer) {
            if (this.player != null) {
                this.player.setTextOutput(null);
                this.player.setVideoListener(null);
                this.player.removeListener(this.componentListener);
                this.player.setVideoSurface(null);
            }
            this.player = simpleExoPlayer;
            if (this.useController) {
                this.controller.setPlayer(simpleExoPlayer);
            }
            if (simpleExoPlayer != null) {
                if (this.surfaceView instanceof TextureView) {
                    simpleExoPlayer.setVideoTextureView((TextureView) this.surfaceView);
                } else if (this.surfaceView instanceof SurfaceView) {
                    simpleExoPlayer.setVideoSurfaceView((SurfaceView) this.surfaceView);
                }
                simpleExoPlayer.setVideoListener(this.componentListener);
                simpleExoPlayer.addListener(this.componentListener);
                simpleExoPlayer.setTextOutput(this.componentListener);
                maybeShowController(false);
                return;
            }
            this.shutterView.setVisibility(0);
            this.controller.hide();
        }
    }

    public void setResizeMode(int i) {
        this.layout.setResizeMode(i);
    }

    public boolean getUseController() {
        return this.useController;
    }

    public void setUseController(boolean z) {
        if (this.useController != z) {
            this.useController = z;
            if (z) {
                this.controller.setPlayer(this.player);
                return;
            }
            this.controller.hide();
            this.controller.setPlayer(null);
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.controllerShowTimeoutMs;
    }

    public void setControllerShowTimeoutMs(int i) {
        this.controllerShowTimeoutMs = i;
    }

    public void setControllerVisibilityListener(PlaybackControlView.VisibilityListener visibilityListener) {
        this.controller.setVisibilityListener(visibilityListener);
    }

    public void setRewindIncrementMs(int i) {
        this.controller.setRewindIncrementMs(i);
    }

    public void setFastForwardIncrementMs(int i) {
        this.controller.setFastForwardIncrementMs(i);
    }

    public View getVideoSurfaceView() {
        return this.surfaceView;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.useController || this.player == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (this.controller.isVisible()) {
            this.controller.hide();
            return true;
        }
        maybeShowController(true);
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.useController || this.player == null) {
            return false;
        }
        maybeShowController(true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.useController ? this.controller.dispatchKeyEvent(keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeShowController(boolean z) {
        boolean z2 = true;
        if (this.useController && this.player != null) {
            int playbackState = this.player.getPlaybackState();
            boolean z3 = playbackState == 1 || playbackState == 4 || !this.player.getPlayWhenReady();
            if (!this.controller.isVisible() || this.controller.getShowTimeoutMs() > 0) {
                z2 = false;
            }
            this.controller.setShowTimeoutMs(z3 ? 0 : this.controllerShowTimeoutMs);
            if (z || z3 || z2) {
                this.controller.show();
            }
        }
    }

    /* loaded from: classes.dex */
    private final class ComponentListener implements ExoPlayer.EventListener, SimpleExoPlayer.VideoListener, TextRenderer.Output {
        private ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.text.TextRenderer.Output
        public void onCues(List<Cue> list) {
            SimpleExoPlayerView.this.subtitleLayout.onCues(list);
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            SimpleExoPlayerView.this.layout.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onRenderedFirstFrame() {
            SimpleExoPlayerView.this.shutterView.setVisibility(8);
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onVideoTracksDisabled() {
            SimpleExoPlayerView.this.shutterView.setVisibility(0);
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
        public void onLoadingChanged(boolean z) {
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            SimpleExoPlayerView.this.maybeShowController(false);
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
        public void onPositionDiscontinuity() {
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
        public void onTimelineChanged(Timeline timeline, Object obj) {
        }
    }
}
