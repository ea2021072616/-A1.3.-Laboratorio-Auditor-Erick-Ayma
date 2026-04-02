package com.google.android.exoplayer2.ui;

import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.decoder.DecoderCounters;
/* loaded from: classes.dex */
public final class DebugTextViewHelper implements ExoPlayer.EventListener, Runnable {
    private static final int REFRESH_INTERVAL_MS = 1000;
    private final SimpleExoPlayer player;
    private boolean started;
    private final TextView textView;

    public DebugTextViewHelper(SimpleExoPlayer simpleExoPlayer, TextView textView) {
        this.player = simpleExoPlayer;
        this.textView = textView;
    }

    public void start() {
        if (!this.started) {
            this.started = true;
            this.player.addListener(this);
            updateAndPost();
        }
    }

    public void stop() {
        if (this.started) {
            this.started = false;
            this.player.removeListener(this);
            this.textView.removeCallbacks(this);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
    public void onLoadingChanged(boolean z) {
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        updateAndPost();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
    public void onPositionDiscontinuity() {
        updateAndPost();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
    public void onTimelineChanged(Timeline timeline, Object obj) {
    }

    @Override // com.google.android.exoplayer2.ExoPlayer.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
    }

    @Override // java.lang.Runnable
    public void run() {
        updateAndPost();
    }

    private void updateAndPost() {
        this.textView.setText(getPlayerStateString() + getPlayerWindowIndexString() + getVideoString() + getAudioString());
        this.textView.removeCallbacks(this);
        this.textView.postDelayed(this, 1000L);
    }

    private String getPlayerStateString() {
        String str = "playWhenReady:" + this.player.getPlayWhenReady() + " playbackState:";
        switch (this.player.getPlaybackState()) {
            case 1:
                return str + "idle";
            case 2:
                return str + "buffering";
            case 3:
                return str + "ready";
            case 4:
                return str + "ended";
            default:
                return str + "unknown";
        }
    }

    private String getPlayerWindowIndexString() {
        return " window:" + this.player.getCurrentWindowIndex();
    }

    private String getVideoString() {
        Format videoFormat = this.player.getVideoFormat();
        if (videoFormat == null) {
            return "";
        }
        return "\n" + videoFormat.sampleMimeType + "(id:" + videoFormat.id + " r:" + videoFormat.width + "x" + videoFormat.height + getDecoderCountersBufferCountString(this.player.getVideoDecoderCounters()) + ")";
    }

    private String getAudioString() {
        Format audioFormat = this.player.getAudioFormat();
        if (audioFormat == null) {
            return "";
        }
        return "\n" + audioFormat.sampleMimeType + "(id:" + audioFormat.id + " hz:" + audioFormat.sampleRate + " ch:" + audioFormat.channelCount + getDecoderCountersBufferCountString(this.player.getAudioDecoderCounters()) + ")";
    }

    private static String getDecoderCountersBufferCountString(DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return "";
        }
        decoderCounters.ensureUpdated();
        return " rb:" + decoderCounters.renderedOutputBufferCount + " sb:" + decoderCounters.skippedOutputBufferCount + " db:" + decoderCounters.droppedOutputBufferCount + " mcdb:" + decoderCounters.maxConsecutiveDroppedOutputBufferCount;
    }
}
