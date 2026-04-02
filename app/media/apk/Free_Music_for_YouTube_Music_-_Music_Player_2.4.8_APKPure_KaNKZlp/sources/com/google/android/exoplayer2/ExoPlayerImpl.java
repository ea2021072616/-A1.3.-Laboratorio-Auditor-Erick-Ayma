package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
final class ExoPlayerImpl implements ExoPlayer {
    private static final String TAG = "ExoPlayerImpl";
    private final Handler eventHandler;
    private final ExoPlayerImplInternal<?> internalPlayer;
    private boolean isLoading;
    private final CopyOnWriteArraySet<ExoPlayer.EventListener> listeners;
    private Object manifest;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private boolean pendingInitialSeek;
    private int pendingSeekAcks;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private ExoPlayerImplInternal.PlaybackInfo playbackInfo;
    private int playbackState;
    private Timeline timeline;
    private final Timeline.Window window;

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector<?> trackSelector, LoadControl loadControl) {
        Log.i(TAG, "Init 2.0.3");
        Assertions.checkNotNull(rendererArr);
        Assertions.checkState(rendererArr.length > 0);
        this.playWhenReady = false;
        this.playbackState = 1;
        this.listeners = new CopyOnWriteArraySet<>();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.eventHandler = new Handler() { // from class: com.google.android.exoplayer2.ExoPlayerImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ExoPlayerImpl.this.handleEvent(message);
            }
        };
        this.playbackInfo = new ExoPlayerImplInternal.PlaybackInfo(0, 0L);
        this.internalPlayer = new ExoPlayerImplInternal<>(rendererArr, trackSelector, loadControl, this.playWhenReady, this.eventHandler, this.playbackInfo);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addListener(ExoPlayer.EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void removeListener(ExoPlayer.EventListener eventListener) {
        this.listeners.remove(eventListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getPlaybackState() {
        return this.playbackState;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        if (z2 && (this.timeline != null || this.manifest != null)) {
            this.timeline = null;
            this.manifest = null;
            Iterator<ExoPlayer.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onTimelineChanged(null, null);
            }
        }
        this.internalPlayer.prepare(mediaSource, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPlayWhenReady(boolean z) {
        if (this.playWhenReady != z) {
            this.playWhenReady = z;
            this.internalPlayer.setPlayWhenReady(z);
            Iterator<ExoPlayer.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlayerStateChanged(z, this.playbackState);
            }
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean isLoading() {
        return this.isLoading;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void seekToDefaultPosition(int i) {
        if (this.timeline == null) {
            this.maskingWindowIndex = i;
            this.maskingWindowPositionMs = C.TIME_UNSET;
            this.pendingInitialSeek = true;
            return;
        }
        Assertions.checkIndex(i, 0, this.timeline.getWindowCount());
        this.pendingSeekAcks++;
        this.maskingWindowIndex = i;
        this.maskingWindowPositionMs = 0L;
        this.internalPlayer.seekTo(this.timeline.getWindow(i, this.window).firstPeriodIndex, C.TIME_UNSET);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void seekTo(long j) {
        seekTo(getCurrentWindowIndex(), j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void seekTo(int i, long j) {
        if (j == C.TIME_UNSET) {
            seekToDefaultPosition(i);
        } else if (this.timeline == null) {
            this.maskingWindowIndex = i;
            this.maskingWindowPositionMs = j;
            this.pendingInitialSeek = true;
        } else {
            Assertions.checkIndex(i, 0, this.timeline.getWindowCount());
            this.pendingSeekAcks++;
            this.maskingWindowIndex = i;
            this.maskingWindowPositionMs = j;
            this.timeline.getWindow(i, this.window);
            int i2 = this.window.firstPeriodIndex;
            long positionInFirstPeriodMs = this.window.getPositionInFirstPeriodMs() + j;
            long durationMs = this.timeline.getPeriod(i2, this.period).getDurationMs();
            while (durationMs != C.TIME_UNSET && positionInFirstPeriodMs >= durationMs && i2 < this.window.lastPeriodIndex) {
                positionInFirstPeriodMs -= durationMs;
                i2++;
                durationMs = this.timeline.getPeriod(i2, this.period).getDurationMs();
            }
            this.internalPlayer.seekTo(i2, C.msToUs(positionInFirstPeriodMs));
            Iterator<ExoPlayer.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPositionDiscontinuity();
            }
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void stop() {
        this.internalPlayer.stop();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void release() {
        this.internalPlayer.release();
        this.eventHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.internalPlayer.sendMessages(exoPlayerMessageArr);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.internalPlayer.blockingSendMessages(exoPlayerMessageArr);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getCurrentPeriodIndex() {
        return this.playbackInfo.periodIndex;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getCurrentWindowIndex() {
        return (this.timeline == null || this.pendingSeekAcks > 0) ? this.maskingWindowIndex : this.timeline.getPeriod(this.playbackInfo.periodIndex, this.period).windowIndex;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public long getDuration() {
        return this.timeline == null ? C.TIME_UNSET : this.timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public long getCurrentPosition() {
        if (this.timeline == null || this.pendingSeekAcks > 0) {
            return this.maskingWindowPositionMs;
        }
        this.timeline.getPeriod(this.playbackInfo.periodIndex, this.period);
        return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.positionUs);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public long getBufferedPosition() {
        if (this.timeline == null || this.pendingSeekAcks > 0) {
            return this.maskingWindowPositionMs;
        }
        this.timeline.getPeriod(this.playbackInfo.periodIndex, this.period);
        return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.bufferedPositionUs);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getBufferedPercentage() {
        int i;
        if (this.timeline == null) {
            return 0;
        }
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == C.TIME_UNSET || duration == C.TIME_UNSET) {
            i = 0;
        } else {
            i = (int) (duration != 0 ? (100 * bufferedPosition) / duration : 100L);
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Timeline getCurrentTimeline() {
        return this.timeline;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Object getCurrentManifest() {
        return this.manifest;
    }

    void handleEvent(Message message) {
        switch (message.what) {
            case 1:
                this.playbackState = message.arg1;
                Iterator<ExoPlayer.EventListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onPlayerStateChanged(this.playWhenReady, this.playbackState);
                }
                return;
            case 2:
                this.isLoading = message.arg1 != 0;
                Iterator<ExoPlayer.EventListener> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onLoadingChanged(this.isLoading);
                }
                return;
            case 3:
                int i = this.pendingSeekAcks - 1;
                this.pendingSeekAcks = i;
                if (i == 0) {
                    this.playbackInfo = (ExoPlayerImplInternal.PlaybackInfo) message.obj;
                    Iterator<ExoPlayer.EventListener> it3 = this.listeners.iterator();
                    while (it3.hasNext()) {
                        it3.next().onPositionDiscontinuity();
                    }
                    return;
                }
                return;
            case 4:
                if (this.pendingSeekAcks == 0) {
                    this.playbackInfo = (ExoPlayerImplInternal.PlaybackInfo) message.obj;
                    Iterator<ExoPlayer.EventListener> it4 = this.listeners.iterator();
                    while (it4.hasNext()) {
                        it4.next().onPositionDiscontinuity();
                    }
                    return;
                }
                return;
            case 5:
                Pair pair = (Pair) message.obj;
                this.timeline = (Timeline) pair.first;
                this.manifest = pair.second;
                if (this.pendingInitialSeek) {
                    this.pendingInitialSeek = false;
                    seekTo(this.maskingWindowIndex, this.maskingWindowPositionMs);
                }
                Iterator<ExoPlayer.EventListener> it5 = this.listeners.iterator();
                while (it5.hasNext()) {
                    it5.next().onTimelineChanged(this.timeline, this.manifest);
                }
                return;
            case 6:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator<ExoPlayer.EventListener> it6 = this.listeners.iterator();
                while (it6.hasNext()) {
                    it6.next().onPlayerError(exoPlaybackException);
                }
                return;
            default:
                return;
        }
    }
}
