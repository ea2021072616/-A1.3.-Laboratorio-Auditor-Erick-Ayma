package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.R;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes.dex */
public class PlaybackControlView extends FrameLayout {
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REWIND_MS = 5000;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    private static final long MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000;
    private static final int PROGRESS_BAR_MAX = 1000;
    private final ComponentListener componentListener;
    private final Timeline.Window currentWindow;
    private boolean dragging;
    private final View fastForwardButton;
    private int fastForwardMs;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private final Runnable hideAction;
    private long hideAtMs;
    private final View nextButton;
    private final ImageButton playButton;
    private ExoPlayer player;
    private final View previousButton;
    private final SeekBar progressBar;
    private final View rewindButton;
    private int rewindMs;
    private int showTimeoutMs;
    private final TextView time;
    private final TextView timeCurrent;
    private final Runnable updateProgressAction;
    private VisibilityListener visibilityListener;

    /* loaded from: classes.dex */
    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    public PlaybackControlView(Context context) {
        this(context, null);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.updateProgressAction = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.1
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.updateProgress();
            }
        };
        this.hideAction = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.2
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.hide();
            }
        };
        this.rewindMs = 5000;
        this.fastForwardMs = 15000;
        this.showTimeoutMs = 5000;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PlaybackControlView, 0, 0);
            try {
                this.rewindMs = obtainStyledAttributes.getInt(R.styleable.PlaybackControlView_rewind_increment, this.rewindMs);
                this.fastForwardMs = obtainStyledAttributes.getInt(R.styleable.PlaybackControlView_fastforward_increment, this.fastForwardMs);
                this.showTimeoutMs = obtainStyledAttributes.getInt(R.styleable.PlaybackControlView_show_timeout, this.showTimeoutMs);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.currentWindow = new Timeline.Window();
        this.formatBuilder = new StringBuilder();
        this.formatter = new Formatter(this.formatBuilder, Locale.getDefault());
        this.componentListener = new ComponentListener();
        LayoutInflater.from(context).inflate(R.layout.exo_playback_control_view, this);
        this.time = (TextView) findViewById(R.id.time);
        this.timeCurrent = (TextView) findViewById(R.id.time_current);
        this.progressBar = (SeekBar) findViewById(R.id.mediacontroller_progress);
        this.progressBar.setOnSeekBarChangeListener(this.componentListener);
        this.progressBar.setMax(1000);
        this.playButton = (ImageButton) findViewById(R.id.play);
        this.playButton.setOnClickListener(this.componentListener);
        this.previousButton = findViewById(R.id.prev);
        this.previousButton.setOnClickListener(this.componentListener);
        this.nextButton = findViewById(R.id.next);
        this.nextButton.setOnClickListener(this.componentListener);
        this.rewindButton = findViewById(R.id.rew);
        this.rewindButton.setOnClickListener(this.componentListener);
        this.fastForwardButton = findViewById(R.id.ffwd);
        this.fastForwardButton.setOnClickListener(this.componentListener);
    }

    public ExoPlayer getPlayer() {
        return this.player;
    }

    public void setPlayer(ExoPlayer exoPlayer) {
        if (this.player != exoPlayer) {
            if (this.player != null) {
                this.player.removeListener(this.componentListener);
            }
            this.player = exoPlayer;
            if (exoPlayer != null) {
                exoPlayer.addListener(this.componentListener);
            }
            updateAll();
        }
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        this.visibilityListener = visibilityListener;
    }

    public void setRewindIncrementMs(int i) {
        this.rewindMs = i;
        updateNavigation();
    }

    public void setFastForwardIncrementMs(int i) {
        this.fastForwardMs = i;
        updateNavigation();
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public void setShowTimeoutMs(int i) {
        this.showTimeoutMs = i;
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            if (this.visibilityListener != null) {
                this.visibilityListener.onVisibilityChange(getVisibility());
            }
            updateAll();
        }
        hideAfterTimeout();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            if (this.visibilityListener != null) {
                this.visibilityListener.onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.updateProgressAction);
            removeCallbacks(this.hideAction);
            this.hideAtMs = C.TIME_UNSET;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAfterTimeout() {
        removeCallbacks(this.hideAction);
        if (this.showTimeoutMs > 0) {
            this.hideAtMs = SystemClock.uptimeMillis() + this.showTimeoutMs;
            if (isAttachedToWindow()) {
                postDelayed(this.hideAction, this.showTimeoutMs);
                return;
            }
            return;
        }
        this.hideAtMs = C.TIME_UNSET;
    }

    private void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayPauseButton() {
        if (isVisible() && isAttachedToWindow()) {
            boolean z = this.player != null && this.player.getPlayWhenReady();
            this.playButton.setContentDescription(getResources().getString(z ? R.string.exo_controls_pause_description : R.string.exo_controls_play_description));
            this.playButton.setImageResource(z ? R.drawable.exo_controls_pause : R.drawable.exo_controls_play);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigation() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (isVisible() && isAttachedToWindow()) {
            Timeline currentTimeline = this.player != null ? this.player.getCurrentTimeline() : null;
            if (currentTimeline != null) {
                int currentWindowIndex = this.player.getCurrentWindowIndex();
                currentTimeline.getWindow(currentWindowIndex, this.currentWindow);
                z3 = this.currentWindow.isSeekable;
                z2 = currentWindowIndex > 0 || z3 || !this.currentWindow.isDynamic;
                z = currentWindowIndex < currentTimeline.getWindowCount() + (-1) || this.currentWindow.isDynamic;
            } else {
                z = false;
                z2 = false;
                z3 = false;
            }
            setButtonEnabled(z2, this.previousButton);
            setButtonEnabled(z, this.nextButton);
            setButtonEnabled(this.fastForwardMs > 0 && z3, this.fastForwardButton);
            if (this.rewindMs <= 0 || !z3) {
                z4 = false;
            }
            setButtonEnabled(z4, this.rewindButton);
            this.progressBar.setEnabled(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        long j;
        if (isVisible() && isAttachedToWindow()) {
            long duration = this.player == null ? 0L : this.player.getDuration();
            long currentPosition = this.player == null ? 0L : this.player.getCurrentPosition();
            this.time.setText(stringForTime(duration));
            if (!this.dragging) {
                this.timeCurrent.setText(stringForTime(currentPosition));
            }
            if (!this.dragging) {
                this.progressBar.setProgress(progressBarValue(currentPosition));
            }
            this.progressBar.setSecondaryProgress(progressBarValue(this.player != null ? this.player.getBufferedPosition() : 0L));
            removeCallbacks(this.updateProgressAction);
            int playbackState = this.player == null ? 1 : this.player.getPlaybackState();
            if (playbackState != 1 && playbackState != 4) {
                if (this.player.getPlayWhenReady() && playbackState == 3) {
                    j = 1000 - (currentPosition % 1000);
                    if (j < 200) {
                        j += 1000;
                    }
                } else {
                    j = 1000;
                }
                postDelayed(this.updateProgressAction, j);
            }
        }
    }

    private void setButtonEnabled(boolean z, View view) {
        view.setEnabled(z);
        if (Util.SDK_INT >= 11) {
            view.setAlpha(z ? 1.0f : 0.3f);
            view.setVisibility(0);
            return;
        }
        view.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String stringForTime(long j) {
        if (j == C.TIME_UNSET) {
            j = 0;
        }
        long j2 = (500 + j) / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 / 3600;
        this.formatBuilder.setLength(0);
        return j5 > 0 ? this.formatter.format("%d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : this.formatter.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
    }

    private int progressBarValue(long j) {
        long duration = this.player == null ? -9223372036854775807L : this.player.getDuration();
        if (duration == C.TIME_UNSET || duration == 0) {
            return 0;
        }
        return (int) ((1000 * j) / duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long positionValue(int i) {
        long duration = this.player == null ? -9223372036854775807L : this.player.getDuration();
        if (duration == C.TIME_UNSET) {
            return 0L;
        }
        return (duration * i) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void previous() {
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (currentTimeline != null) {
            int currentWindowIndex = this.player.getCurrentWindowIndex();
            currentTimeline.getWindow(currentWindowIndex, this.currentWindow);
            if (currentWindowIndex > 0 && (this.player.getCurrentPosition() <= MAX_POSITION_FOR_SEEK_TO_PREVIOUS || (this.currentWindow.isDynamic && !this.currentWindow.isSeekable))) {
                this.player.seekToDefaultPosition(currentWindowIndex - 1);
            } else {
                this.player.seekTo(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (currentTimeline != null) {
            int currentWindowIndex = this.player.getCurrentWindowIndex();
            if (currentWindowIndex < currentTimeline.getWindowCount() - 1) {
                this.player.seekToDefaultPosition(currentWindowIndex + 1);
            } else if (currentTimeline.getWindow(currentWindowIndex, this.currentWindow, false).isDynamic) {
                this.player.seekToDefaultPosition();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        if (this.rewindMs > 0) {
            this.player.seekTo(Math.max(this.player.getCurrentPosition() - this.rewindMs, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        if (this.fastForwardMs > 0) {
            this.player.seekTo(Math.min(this.player.getCurrentPosition() + this.fastForwardMs, this.player.getDuration()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hideAtMs != C.TIME_UNSET) {
            long uptimeMillis = this.hideAtMs - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.hideAction, uptimeMillis);
            }
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.updateProgressAction);
        removeCallbacks(this.hideAction);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.player == null || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
            case 89:
                rewind();
                break;
            case 22:
            case 90:
                fastForward();
                break;
            case 85:
                this.player.setPlayWhenReady(this.player.getPlayWhenReady() ? false : true);
                break;
            case 87:
                next();
                break;
            case 88:
                previous();
                break;
            case 126:
                this.player.setPlayWhenReady(true);
                break;
            case 127:
                this.player.setPlayWhenReady(false);
                break;
            default:
                return false;
        }
        show();
        return true;
    }

    /* loaded from: classes.dex */
    private final class ComponentListener implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, ExoPlayer.EventListener {
        private ComponentListener() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            PlaybackControlView.this.removeCallbacks(PlaybackControlView.this.hideAction);
            PlaybackControlView.this.dragging = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                PlaybackControlView.this.timeCurrent.setText(PlaybackControlView.this.stringForTime(PlaybackControlView.this.positionValue(i)));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            PlaybackControlView.this.dragging = false;
            PlaybackControlView.this.player.seekTo(PlaybackControlView.this.positionValue(seekBar.getProgress()));
            PlaybackControlView.this.hideAfterTimeout();
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            PlaybackControlView.this.updatePlayPauseButton();
            PlaybackControlView.this.updateProgress();
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
        public void onPositionDiscontinuity() {
            PlaybackControlView.this.updateNavigation();
            PlaybackControlView.this.updateProgress();
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
        public void onTimelineChanged(Timeline timeline, Object obj) {
            PlaybackControlView.this.updateNavigation();
            PlaybackControlView.this.updateProgress();
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
        public void onLoadingChanged(boolean z) {
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Timeline currentTimeline = PlaybackControlView.this.player.getCurrentTimeline();
            if (PlaybackControlView.this.nextButton == view) {
                PlaybackControlView.this.next();
            } else if (PlaybackControlView.this.previousButton == view) {
                PlaybackControlView.this.previous();
            } else if (PlaybackControlView.this.fastForwardButton == view) {
                PlaybackControlView.this.fastForward();
            } else if (PlaybackControlView.this.rewindButton != view || currentTimeline == null) {
                if (PlaybackControlView.this.playButton == view) {
                    PlaybackControlView.this.player.setPlayWhenReady(!PlaybackControlView.this.player.getPlayWhenReady());
                }
            } else {
                PlaybackControlView.this.rewind();
            }
            PlaybackControlView.this.hideAfterTimeout();
        }
    }
}
