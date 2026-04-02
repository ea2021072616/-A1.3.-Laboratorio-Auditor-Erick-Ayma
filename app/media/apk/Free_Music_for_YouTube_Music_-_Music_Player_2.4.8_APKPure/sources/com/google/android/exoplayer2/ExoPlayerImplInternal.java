package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelections;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.PriorityHandlerThread;
import com.google.android.exoplayer2.util.StandaloneMediaClock;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ExoPlayerImplInternal<T> implements Handler.Callback, MediaPeriod.Callback, MediaSource.Listener, TrackSelector.InvalidationListener {
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    private static final int MSG_CUSTOM = 10;
    private static final int MSG_DO_SOME_WORK = 2;
    public static final int MSG_ERROR = 6;
    public static final int MSG_LOADING_CHANGED = 2;
    private static final int MSG_PERIOD_PREPARED = 7;
    public static final int MSG_POSITION_DISCONTINUITY = 4;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_REFRESH_SOURCE_INFO = 6;
    private static final int MSG_RELEASE = 5;
    public static final int MSG_SEEK_ACK = 3;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 8;
    public static final int MSG_SOURCE_INFO_REFRESHED = 5;
    public static final int MSG_STATE_CHANGED = 1;
    private static final int MSG_STOP = 4;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 9;
    private static final int PREPARING_SOURCE_INTERVAL_MS = 10;
    private static final int RENDERING_INTERVAL_MS = 10;
    private static final String TAG = "ExoPlayerImplInternal";
    private int bufferAheadPeriodCount;
    private int customMessagesProcessed;
    private int customMessagesSent;
    private long elapsedRealtimeUs;
    private Renderer[] enabledRenderers;
    private final Handler eventHandler;
    private final Handler handler;
    private final HandlerThread internalPlaybackThread;
    private boolean isLoading;
    private boolean isTimelineEnded;
    private boolean isTimelineReady;
    private final LoadControl loadControl;
    private MediaPeriodHolder<T> loadingPeriodHolder;
    private MediaSource mediaSource;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private PlaybackInfo playbackInfo;
    private MediaPeriodHolder<T> playingPeriodHolder;
    private MediaPeriodHolder<T> readingPeriodHolder;
    private boolean rebuffering;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private MediaClock rendererMediaClock;
    private Renderer rendererMediaClockSource;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private final StandaloneMediaClock standaloneMediaClock;
    private int state = 1;
    private Timeline timeline;
    private final TrackSelector<T> trackSelector;
    private final Timeline.Window window;

    /* loaded from: classes.dex */
    public static final class PlaybackInfo {
        public volatile long bufferedPositionUs;
        public final int periodIndex;
        public volatile long positionUs;
        public final long startPositionUs;

        public PlaybackInfo(int i, long j) {
            this.periodIndex = i;
            this.startPositionUs = j;
            this.positionUs = j;
            this.bufferedPositionUs = j;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector<T> trackSelector, LoadControl loadControl, boolean z, Handler handler, PlaybackInfo playbackInfo) {
        this.renderers = rendererArr;
        this.trackSelector = trackSelector;
        this.loadControl = loadControl;
        this.playWhenReady = z;
        this.eventHandler = handler;
        this.playbackInfo = playbackInfo;
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i = 0; i < rendererArr.length; i++) {
            rendererArr[i].setIndex(i);
            this.rendererCapabilities[i] = rendererArr[i].getCapabilities();
        }
        this.standaloneMediaClock = new StandaloneMediaClock();
        this.enabledRenderers = new Renderer[0];
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector.init(this);
        this.internalPlaybackThread = new PriorityHandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.internalPlaybackThread.start();
        this.handler = new Handler(this.internalPlaybackThread.getLooper(), this);
    }

    public void prepare(MediaSource mediaSource, boolean z) {
        this.handler.obtainMessage(0, z ? 1 : 0, 0, mediaSource).sendToTarget();
    }

    public void setPlayWhenReady(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void seekTo(int i, long j) {
        this.handler.obtainMessage(3, i, 0, Long.valueOf(j)).sendToTarget();
    }

    public void stop() {
        this.handler.sendEmptyMessage(4);
    }

    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        if (this.released) {
            Log.w(TAG, "Ignoring messages sent after release.");
            return;
        }
        this.customMessagesSent++;
        this.handler.obtainMessage(10, exoPlayerMessageArr).sendToTarget();
    }

    public synchronized void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        if (this.released) {
            Log.w(TAG, "Ignoring messages sent after release.");
        } else {
            int i = this.customMessagesSent;
            this.customMessagesSent = i + 1;
            this.handler.obtainMessage(10, exoPlayerMessageArr).sendToTarget();
            while (this.customMessagesProcessed <= i) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public synchronized void release() {
        if (!this.released) {
            this.handler.sendEmptyMessage(5);
            while (!this.released) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.internalPlaybackThread.quit();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Listener
    public void onSourceInfoRefreshed(Timeline timeline, Object obj) {
        this.handler.obtainMessage(6, Pair.create(timeline, obj)).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(7, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(9);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z;
        try {
            switch (message.what) {
                case 0:
                    prepareInternal((MediaSource) message.obj, message.arg1 != 0);
                    z = true;
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0);
                    z = true;
                    break;
                case 2:
                    doSomeWork();
                    z = true;
                    break;
                case 3:
                    seekToInternal(message.arg1, ((Long) message.obj).longValue());
                    z = true;
                    break;
                case 4:
                    stopInternal();
                    z = true;
                    break;
                case 5:
                    releaseInternal();
                    z = true;
                    break;
                case 6:
                    handleSourceInfoRefreshed((Pair) message.obj);
                    z = true;
                    break;
                case 7:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    z = true;
                    break;
                case 8:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    z = true;
                    break;
                case 9:
                    reselectTracksInternal();
                    z = true;
                    break;
                case 10:
                    sendMessagesInternal((ExoPlayer.ExoPlayerMessage[]) message.obj);
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            return z;
        } catch (ExoPlaybackException e) {
            Log.e(TAG, "Renderer error.", e);
            this.eventHandler.obtainMessage(6, e).sendToTarget();
            stopInternal();
            return true;
        } catch (IOException e2) {
            Log.e(TAG, "Source error.", e2);
            this.eventHandler.obtainMessage(6, ExoPlaybackException.createForSource(e2)).sendToTarget();
            stopInternal();
            return true;
        } catch (RuntimeException e3) {
            Log.e(TAG, "Internal runtime error.", e3);
            this.eventHandler.obtainMessage(6, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            stopInternal();
            return true;
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.eventHandler.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private void setIsLoading(boolean z) {
        if (this.isLoading != z) {
            this.isLoading = z;
            this.eventHandler.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void prepareInternal(MediaSource mediaSource, boolean z) throws ExoPlaybackException {
        resetInternal();
        this.loadControl.onPrepared();
        if (z) {
            this.playbackInfo = new PlaybackInfo(0, C.TIME_UNSET);
        }
        this.mediaSource = mediaSource;
        mediaSource.prepareSource(this);
        setState(2);
        this.handler.sendEmptyMessage(2);
    }

    private void setPlayWhenReadyInternal(boolean z) throws ExoPlaybackException {
        this.rebuffering = false;
        this.playWhenReady = z;
        if (!z) {
            stopRenderers();
            updatePlaybackPositions();
        } else if (this.state == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (this.state == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void startRenderers() throws ExoPlaybackException {
        this.rebuffering = false;
        this.standaloneMediaClock.start();
        for (Renderer renderer : this.enabledRenderers) {
            renderer.start();
        }
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.standaloneMediaClock.stop();
        for (Renderer renderer : this.enabledRenderers) {
            ensureStopped(renderer);
        }
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        if (this.playingPeriodHolder != null) {
            long readDiscontinuity = this.playingPeriodHolder.mediaPeriod.readDiscontinuity();
            if (readDiscontinuity != C.TIME_UNSET) {
                resetRendererPosition(readDiscontinuity);
            } else {
                if (this.rendererMediaClockSource != null && !this.rendererMediaClockSource.isEnded()) {
                    this.rendererPositionUs = this.rendererMediaClock.getPositionUs();
                    this.standaloneMediaClock.setPositionUs(this.rendererPositionUs);
                } else {
                    this.rendererPositionUs = this.standaloneMediaClock.getPositionUs();
                }
                readDiscontinuity = this.rendererPositionUs - this.playingPeriodHolder.rendererPositionOffsetUs;
            }
            this.playbackInfo.positionUs = readDiscontinuity;
            this.elapsedRealtimeUs = SystemClock.elapsedRealtime() * 1000;
            long bufferedPositionUs = this.enabledRenderers.length == 0 ? Long.MIN_VALUE : this.playingPeriodHolder.mediaPeriod.getBufferedPositionUs();
            PlaybackInfo playbackInfo = this.playbackInfo;
            if (bufferedPositionUs == Long.MIN_VALUE) {
                bufferedPositionUs = this.timeline.getPeriod(this.playingPeriodHolder.index, this.period).getDurationUs();
            }
            playbackInfo.bufferedPositionUs = bufferedPositionUs;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b5, code lost:
        setState(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bb, code lost:
        if (r15.playWhenReady == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bd, code lost:
        startRenderers();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d2, code lost:
        r15.rebuffering = r15.playWhenReady;
        setState(2);
        stopRenderers();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void doSomeWork() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.doSomeWork():void");
    }

    private void scheduleNextWork(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private void seekToInternal(int i, long j) throws ExoPlaybackException {
        if (j == C.TIME_UNSET) {
            try {
                if (this.timeline != null && i < this.timeline.getPeriodCount()) {
                    Pair<Integer, Long> defaultPosition = getDefaultPosition(i);
                    i = ((Integer) defaultPosition.first).intValue();
                    j = ((Long) defaultPosition.second).longValue();
                }
            } finally {
                this.playbackInfo = new PlaybackInfo(i, j);
                this.eventHandler.obtainMessage(3, this.playbackInfo).sendToTarget();
            }
        }
        if (i != this.playbackInfo.periodIndex || ((j != C.TIME_UNSET || this.playbackInfo.positionUs != C.TIME_UNSET) && j / 1000 != this.playbackInfo.positionUs / 1000)) {
            this.playbackInfo = new PlaybackInfo(i, seekToPeriodPosition(i, j));
            this.eventHandler.obtainMessage(3, this.playbackInfo).sendToTarget();
        }
    }

    private long seekToPeriodPosition(int i, long j) throws ExoPlaybackException {
        MediaPeriodHolder<T> mediaPeriodHolder;
        if (this.mediaSource == null) {
            if (j != C.TIME_UNSET) {
                resetRendererPosition(j);
            }
        } else {
            stopRenderers();
            this.rebuffering = false;
            setState(2);
            if (j == C.TIME_UNSET || (this.readingPeriodHolder != this.playingPeriodHolder && (i == this.playingPeriodHolder.index || i == this.readingPeriodHolder.index))) {
                i = -1;
            }
            if (this.playingPeriodHolder == null) {
                if (this.loadingPeriodHolder != null) {
                    this.loadingPeriodHolder.release();
                    mediaPeriodHolder = null;
                } else {
                    mediaPeriodHolder = null;
                }
            } else {
                mediaPeriodHolder = null;
                for (MediaPeriodHolder<T> mediaPeriodHolder2 = this.playingPeriodHolder; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.next) {
                    if (mediaPeriodHolder2.index == i && mediaPeriodHolder2.prepared) {
                        mediaPeriodHolder = mediaPeriodHolder2;
                    } else {
                        mediaPeriodHolder2.release();
                    }
                }
            }
            if (mediaPeriodHolder != this.playingPeriodHolder) {
                for (Renderer renderer : this.enabledRenderers) {
                    renderer.disable();
                }
                this.enabledRenderers = new Renderer[0];
                this.rendererMediaClock = null;
                this.rendererMediaClockSource = null;
            }
            this.bufferAheadPeriodCount = 0;
            if (mediaPeriodHolder != null) {
                mediaPeriodHolder.next = null;
                setPlayingPeriodHolder(mediaPeriodHolder);
                updateTimelineState();
                this.readingPeriodHolder = this.playingPeriodHolder;
                this.loadingPeriodHolder = this.playingPeriodHolder;
                if (this.playingPeriodHolder.hasEnabledTracks) {
                    j = this.playingPeriodHolder.mediaPeriod.seekToUs(j);
                }
                resetRendererPosition(j);
                maybeContinueLoading();
            } else {
                this.playingPeriodHolder = null;
                this.readingPeriodHolder = null;
                this.loadingPeriodHolder = null;
                if (j != C.TIME_UNSET) {
                    resetRendererPosition(j);
                }
            }
            updatePlaybackPositions();
            this.handler.sendEmptyMessage(2);
        }
        return j;
    }

    private void resetRendererPosition(long j) throws ExoPlaybackException {
        this.rendererPositionUs = (this.playingPeriodHolder == null ? 0L : this.playingPeriodHolder.rendererPositionOffsetUs) + j;
        this.standaloneMediaClock.setPositionUs(this.rendererPositionUs);
        for (Renderer renderer : this.enabledRenderers) {
            renderer.resetPosition(this.rendererPositionUs);
        }
    }

    private void stopInternal() {
        resetInternal();
        this.loadControl.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        resetInternal();
        this.loadControl.onReleased();
        setState(1);
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void resetInternal() {
        Renderer[] rendererArr;
        this.handler.removeMessages(2);
        this.rebuffering = false;
        this.standaloneMediaClock.stop();
        this.rendererMediaClock = null;
        this.rendererMediaClockSource = null;
        for (Renderer renderer : this.enabledRenderers) {
            try {
                ensureStopped(renderer);
                renderer.disable();
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e(TAG, "Stop failed.", e);
            }
        }
        this.enabledRenderers = new Renderer[0];
        releasePeriodHoldersFrom(this.playingPeriodHolder != null ? this.playingPeriodHolder : this.loadingPeriodHolder);
        if (this.mediaSource != null) {
            this.mediaSource.releaseSource();
            this.mediaSource = null;
        }
        this.isTimelineReady = false;
        this.isTimelineEnded = false;
        this.playingPeriodHolder = null;
        this.readingPeriodHolder = null;
        this.loadingPeriodHolder = null;
        this.timeline = null;
        this.bufferAheadPeriodCount = 0;
        setIsLoading(false);
    }

    private void sendMessagesInternal(ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr) throws ExoPlaybackException {
        try {
            for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
                exoPlayerMessage.target.handleMessage(exoPlayerMessage.messageType, exoPlayerMessage.message);
            }
            if (this.mediaSource != null) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.customMessagesProcessed++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.customMessagesProcessed++;
                notifyAll();
                throw th;
            }
        }
    }

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        if (this.playingPeriodHolder != null) {
            boolean z = true;
            for (MediaPeriodHolder<T> mediaPeriodHolder = this.playingPeriodHolder; mediaPeriodHolder != null && mediaPeriodHolder.prepared; mediaPeriodHolder = mediaPeriodHolder.next) {
                if (!mediaPeriodHolder.selectTracks()) {
                    if (mediaPeriodHolder == this.readingPeriodHolder) {
                        z = false;
                    }
                } else {
                    if (z) {
                        boolean z2 = this.readingPeriodHolder != this.playingPeriodHolder;
                        releasePeriodHoldersFrom(this.playingPeriodHolder.next);
                        this.playingPeriodHolder.next = null;
                        this.readingPeriodHolder = this.playingPeriodHolder;
                        this.loadingPeriodHolder = this.playingPeriodHolder;
                        this.bufferAheadPeriodCount = 0;
                        boolean[] zArr = new boolean[this.renderers.length];
                        long updatePeriodTrackSelection = this.playingPeriodHolder.updatePeriodTrackSelection(this.playbackInfo.positionUs, this.loadControl, z2, zArr);
                        if (updatePeriodTrackSelection != this.playbackInfo.positionUs) {
                            this.playbackInfo.positionUs = updatePeriodTrackSelection;
                            resetRendererPosition(updatePeriodTrackSelection);
                        }
                        boolean[] zArr2 = new boolean[this.renderers.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.renderers.length; i2++) {
                            Renderer renderer = this.renderers[i2];
                            zArr2[i2] = renderer.getState() != 0;
                            SampleStream sampleStream = this.playingPeriodHolder.sampleStreams[i2];
                            if (sampleStream != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (sampleStream != renderer.getStream()) {
                                    if (renderer == this.rendererMediaClockSource) {
                                        if (sampleStream == null) {
                                            this.standaloneMediaClock.setPositionUs(this.rendererMediaClock.getPositionUs());
                                        }
                                        this.rendererMediaClock = null;
                                        this.rendererMediaClockSource = null;
                                    }
                                    ensureStopped(renderer);
                                    renderer.disable();
                                } else if (zArr[i2]) {
                                    renderer.resetPosition(this.playbackInfo.positionUs);
                                }
                            }
                        }
                        this.trackSelector.onSelectionActivated(((MediaPeriodHolder) this.playingPeriodHolder).trackSelections);
                        enableRenderers(zArr2, i);
                    } else {
                        this.loadingPeriodHolder = mediaPeriodHolder;
                        MediaPeriodHolder<T> mediaPeriodHolder2 = this.loadingPeriodHolder.next;
                        while (mediaPeriodHolder2 != null) {
                            mediaPeriodHolder2.release();
                            mediaPeriodHolder2 = mediaPeriodHolder2.next;
                            this.bufferAheadPeriodCount--;
                        }
                        this.loadingPeriodHolder.next = null;
                        this.loadingPeriodHolder.updatePeriodTrackSelection(Math.max(0L, this.rendererPositionUs - this.loadingPeriodHolder.rendererPositionOffsetUs), this.loadControl, false);
                    }
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
            }
        }
    }

    private boolean haveSufficientBuffer(boolean z) {
        if (this.loadingPeriodHolder == null) {
            return false;
        }
        long j = this.rendererPositionUs - this.loadingPeriodHolder.rendererPositionOffsetUs;
        long bufferedPositionUs = !this.loadingPeriodHolder.prepared ? 0L : this.loadingPeriodHolder.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs == Long.MIN_VALUE) {
            if (this.loadingPeriodHolder.isLast) {
                return true;
            }
            bufferedPositionUs = this.timeline.getPeriod(this.loadingPeriodHolder.index, this.period).getDurationUs();
        }
        return this.loadControl.shouldStartPlayback(bufferedPositionUs - j, z);
    }

    private void maybeThrowPeriodPrepareError() throws IOException {
        if (this.loadingPeriodHolder == null || this.loadingPeriodHolder.prepared) {
            return;
        }
        if (this.readingPeriodHolder == null || this.readingPeriodHolder.next == this.loadingPeriodHolder) {
            for (Renderer renderer : this.enabledRenderers) {
                if (!renderer.hasReadStreamToEnd()) {
                    return;
                }
            }
            this.loadingPeriodHolder.mediaPeriod.maybeThrowPrepareError();
        }
    }

    private void handleSourceInfoRefreshed(Pair<Timeline, Object> pair) throws ExoPlaybackException, IOException {
        int i;
        this.eventHandler.obtainMessage(5, pair).sendToTarget();
        Timeline timeline = this.timeline;
        this.timeline = (Timeline) pair.first;
        if (this.playingPeriodHolder != null) {
            int indexOfPeriod = this.timeline.getIndexOfPeriod(this.playingPeriodHolder.uid);
            if (indexOfPeriod == -1) {
                attemptRestart(this.timeline, timeline, this.playingPeriodHolder.index);
                return;
            }
            this.timeline.getPeriod(indexOfPeriod, this.period, true);
            this.playingPeriodHolder.setIndex(this.timeline, this.timeline.getWindow(this.period.windowIndex, this.window), indexOfPeriod);
            MediaPeriodHolder<T> mediaPeriodHolder = this.playingPeriodHolder;
            this.bufferAheadPeriodCount = 0;
            int i2 = indexOfPeriod;
            boolean z = false;
            MediaPeriodHolder<T> mediaPeriodHolder2 = mediaPeriodHolder;
            while (true) {
                if (mediaPeriodHolder2.next == null) {
                    break;
                }
                MediaPeriodHolder<T> mediaPeriodHolder3 = mediaPeriodHolder2.next;
                i2++;
                this.timeline.getPeriod(i2, this.period, true);
                if (!mediaPeriodHolder3.uid.equals(this.period.uid)) {
                    if (!z) {
                        int i3 = this.playingPeriodHolder.index;
                        releasePeriodHoldersFrom(this.playingPeriodHolder);
                        this.playingPeriodHolder = null;
                        this.readingPeriodHolder = null;
                        this.loadingPeriodHolder = null;
                        long seekToPeriodPosition = seekToPeriodPosition(i3, this.playbackInfo.positionUs);
                        if (seekToPeriodPosition != this.playbackInfo.positionUs) {
                            this.playbackInfo = new PlaybackInfo(i3, seekToPeriodPosition);
                            this.eventHandler.obtainMessage(4, this.playbackInfo).sendToTarget();
                            return;
                        }
                        return;
                    }
                    this.loadingPeriodHolder = mediaPeriodHolder2;
                    this.loadingPeriodHolder.next = null;
                    releasePeriodHoldersFrom(mediaPeriodHolder3);
                } else {
                    this.bufferAheadPeriodCount++;
                    mediaPeriodHolder3.setIndex(this.timeline, this.timeline.getWindow(this.timeline.getPeriod(i2, this.period).windowIndex, this.window), i2);
                    if (mediaPeriodHolder3 == this.readingPeriodHolder) {
                        z = true;
                    }
                    mediaPeriodHolder2 = mediaPeriodHolder3;
                }
            }
        } else if (this.loadingPeriodHolder != null) {
            int indexOfPeriod2 = this.timeline.getIndexOfPeriod(this.loadingPeriodHolder.uid);
            if (indexOfPeriod2 == -1) {
                attemptRestart(this.timeline, timeline, this.loadingPeriodHolder.index);
                return;
            }
            this.loadingPeriodHolder.setIndex(this.timeline, this.timeline.getWindow(this.timeline.getPeriod(indexOfPeriod2, this.period).windowIndex, this.window), indexOfPeriod2);
        }
        if (timeline != null) {
            if (this.playingPeriodHolder != null) {
                i = this.playingPeriodHolder.index;
            } else {
                i = this.loadingPeriodHolder != null ? this.loadingPeriodHolder.index : -1;
            }
            if (i != -1 && i != this.playbackInfo.periodIndex) {
                this.playbackInfo = new PlaybackInfo(i, this.playbackInfo.positionUs);
                updatePlaybackPositions();
                this.eventHandler.obtainMessage(4, this.playbackInfo).sendToTarget();
            }
        }
    }

    private void attemptRestart(Timeline timeline, Timeline timeline2, int i) throws ExoPlaybackException {
        int i2 = -1;
        while (i2 == -1 && i < timeline2.getPeriodCount() - 1) {
            i++;
            i2 = timeline.getIndexOfPeriod(timeline2.getPeriod(i, this.period, true).uid);
        }
        if (i2 == -1) {
            stopInternal();
            return;
        }
        releasePeriodHoldersFrom(this.playingPeriodHolder != null ? this.playingPeriodHolder : this.loadingPeriodHolder);
        this.bufferAheadPeriodCount = 0;
        this.playingPeriodHolder = null;
        this.readingPeriodHolder = null;
        this.loadingPeriodHolder = null;
        Pair<Integer, Long> defaultPosition = getDefaultPosition(i2);
        this.playbackInfo = new PlaybackInfo(((Integer) defaultPosition.first).intValue(), ((Long) defaultPosition.second).longValue());
        this.eventHandler.obtainMessage(4, this.playbackInfo).sendToTarget();
    }

    private Pair<Integer, Long> getDefaultPosition(int i) {
        this.timeline.getPeriod(i, this.period);
        this.timeline.getWindow(this.period.windowIndex, this.window);
        int i2 = this.window.firstPeriodIndex;
        long positionInFirstPeriodUs = this.window.getPositionInFirstPeriodUs() + this.window.getDefaultPositionUs();
        this.timeline.getPeriod(i2, this.period);
        while (i2 < this.window.lastPeriodIndex && positionInFirstPeriodUs > this.period.getDurationMs()) {
            positionInFirstPeriodUs -= this.period.getDurationUs();
            this.timeline.getPeriod(i2, this.period);
            i2++;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(positionInFirstPeriodUs));
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        long j;
        if (this.timeline == null) {
            this.mediaSource.maybeThrowSourceInfoRefreshError();
            return;
        }
        if (this.loadingPeriodHolder == null || (this.loadingPeriodHolder.isFullyBuffered() && !this.loadingPeriodHolder.isLast && this.bufferAheadPeriodCount < 100)) {
            int i = this.loadingPeriodHolder == null ? this.playbackInfo.periodIndex : this.loadingPeriodHolder.index + 1;
            if (i >= this.timeline.getPeriodCount()) {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            } else {
                int i2 = this.timeline.getPeriod(i, this.period).windowIndex;
                boolean z = i == this.timeline.getWindow(i2, this.window).firstPeriodIndex;
                if (this.loadingPeriodHolder == null) {
                    j = this.playbackInfo.positionUs;
                } else {
                    j = z ? -9223372036854775807L : 0L;
                }
                if (j == C.TIME_UNSET) {
                    Pair<Integer, Long> defaultPosition = getDefaultPosition(i);
                    int intValue = ((Integer) defaultPosition.first).intValue();
                    j = ((Long) defaultPosition.second).longValue();
                    i = intValue;
                }
                Object obj = this.timeline.getPeriod(i, this.period, true).uid;
                MediaPeriod createPeriod = this.mediaSource.createPeriod(i, this.loadControl.getAllocator(), j);
                createPeriod.prepare(this);
                MediaPeriodHolder<T> mediaPeriodHolder = new MediaPeriodHolder<>(this.renderers, this.rendererCapabilities, this.trackSelector, this.mediaSource, createPeriod, obj, j);
                this.timeline.getWindow(i2, this.window);
                mediaPeriodHolder.setIndex(this.timeline, this.window, i);
                if (this.loadingPeriodHolder != null) {
                    this.loadingPeriodHolder.setNext(mediaPeriodHolder);
                    mediaPeriodHolder.rendererPositionOffsetUs = this.loadingPeriodHolder.rendererPositionOffsetUs + this.timeline.getPeriod(this.loadingPeriodHolder.index, this.period).getDurationUs();
                }
                this.bufferAheadPeriodCount++;
                this.loadingPeriodHolder = mediaPeriodHolder;
                setIsLoading(true);
            }
        }
        if (this.loadingPeriodHolder == null || this.loadingPeriodHolder.isFullyBuffered()) {
            setIsLoading(false);
        } else if (this.loadingPeriodHolder != null && this.loadingPeriodHolder.needsContinueLoading) {
            maybeContinueLoading();
        }
        if (this.playingPeriodHolder != null) {
            while (this.playingPeriodHolder != this.readingPeriodHolder && this.playingPeriodHolder.next != null && this.rendererPositionUs >= this.playingPeriodHolder.next.rendererPositionOffsetUs) {
                this.playingPeriodHolder.release();
                setPlayingPeriodHolder(this.playingPeriodHolder.next);
                this.bufferAheadPeriodCount--;
                this.playbackInfo = new PlaybackInfo(this.playingPeriodHolder.index, this.playingPeriodHolder.startPositionUs);
                updatePlaybackPositions();
                this.eventHandler.obtainMessage(4, this.playbackInfo).sendToTarget();
            }
            updateTimelineState();
            if (this.readingPeriodHolder.isLast) {
                for (Renderer renderer : this.enabledRenderers) {
                    renderer.setCurrentStreamIsFinal();
                }
                return;
            }
            for (Renderer renderer2 : this.enabledRenderers) {
                if (!renderer2.hasReadStreamToEnd()) {
                    return;
                }
            }
            if (this.readingPeriodHolder.next == null || !this.readingPeriodHolder.next.prepared) {
                return;
            }
            TrackSelections trackSelections = ((MediaPeriodHolder) this.readingPeriodHolder).trackSelections;
            this.readingPeriodHolder = this.readingPeriodHolder.next;
            TrackSelections trackSelections2 = ((MediaPeriodHolder) this.readingPeriodHolder).trackSelections;
            for (int i3 = 0; i3 < this.renderers.length; i3++) {
                Renderer renderer3 = this.renderers[i3];
                TrackSelection trackSelection = trackSelections.get(i3);
                TrackSelection trackSelection2 = trackSelections2.get(i3);
                if (trackSelection != null) {
                    if (trackSelection2 != null) {
                        Format[] formatArr = new Format[trackSelection2.length()];
                        for (int i4 = 0; i4 < formatArr.length; i4++) {
                            formatArr[i4] = trackSelection2.getFormat(i4);
                        }
                        renderer3.replaceStream(formatArr, this.readingPeriodHolder.sampleStreams[i3], this.readingPeriodHolder.rendererPositionOffsetUs);
                    } else {
                        renderer3.setCurrentStreamIsFinal();
                    }
                }
            }
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.loadingPeriodHolder != null && this.loadingPeriodHolder.mediaPeriod == mediaPeriod) {
            this.loadingPeriodHolder.handlePrepared(this.loadingPeriodHolder.startPositionUs, this.loadControl);
            if (this.playingPeriodHolder == null) {
                this.readingPeriodHolder = this.loadingPeriodHolder;
                setPlayingPeriodHolder(this.readingPeriodHolder);
                if (this.playbackInfo.startPositionUs == C.TIME_UNSET) {
                    this.playbackInfo = new PlaybackInfo(this.playingPeriodHolder.index, this.playingPeriodHolder.startPositionUs);
                    resetRendererPosition(this.playbackInfo.startPositionUs);
                    updatePlaybackPositions();
                    this.eventHandler.obtainMessage(4, this.playbackInfo).sendToTarget();
                }
                updateTimelineState();
            }
            maybeContinueLoading();
        }
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.loadingPeriodHolder != null && this.loadingPeriodHolder.mediaPeriod == mediaPeriod) {
            maybeContinueLoading();
        }
    }

    private void maybeContinueLoading() {
        long nextLoadPositionUs = this.loadingPeriodHolder.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.rendererPositionUs - this.loadingPeriodHolder.rendererPositionOffsetUs;
            boolean shouldContinueLoading = this.loadControl.shouldContinueLoading(nextLoadPositionUs - j);
            setIsLoading(shouldContinueLoading);
            if (shouldContinueLoading) {
                this.loadingPeriodHolder.needsContinueLoading = false;
                this.loadingPeriodHolder.mediaPeriod.continueLoading(j);
                return;
            }
            this.loadingPeriodHolder.needsContinueLoading = true;
            return;
        }
        setIsLoading(false);
    }

    private void releasePeriodHoldersFrom(MediaPeriodHolder<T> mediaPeriodHolder) {
        while (mediaPeriodHolder != null) {
            mediaPeriodHolder.release();
            mediaPeriodHolder = mediaPeriodHolder.next;
        }
    }

    private void setPlayingPeriodHolder(MediaPeriodHolder<T> mediaPeriodHolder) throws ExoPlaybackException {
        boolean[] zArr = new boolean[this.renderers.length];
        int i = 0;
        for (int i2 = 0; i2 < this.renderers.length; i2++) {
            Renderer renderer = this.renderers[i2];
            zArr[i2] = renderer.getState() != 0;
            if (((MediaPeriodHolder) mediaPeriodHolder).trackSelections.get(i2) != null) {
                i++;
            } else if (zArr[i2]) {
                if (renderer == this.rendererMediaClockSource) {
                    this.standaloneMediaClock.setPositionUs(this.rendererMediaClock.getPositionUs());
                    this.rendererMediaClock = null;
                    this.rendererMediaClockSource = null;
                }
                ensureStopped(renderer);
                renderer.disable();
            }
        }
        this.trackSelector.onSelectionActivated(((MediaPeriodHolder) mediaPeriodHolder).trackSelections);
        this.playingPeriodHolder = mediaPeriodHolder;
        enableRenderers(zArr, i);
    }

    private void updateTimelineState() {
        long durationUs = this.timeline.getPeriod(this.playingPeriodHolder.index, this.period).getDurationUs();
        this.isTimelineReady = durationUs == C.TIME_UNSET || this.playbackInfo.positionUs < durationUs || (this.playingPeriodHolder.next != null && this.playingPeriodHolder.next.prepared);
        this.isTimelineEnded = this.playingPeriodHolder.isLast;
    }

    private void enableRenderers(boolean[] zArr, int i) throws ExoPlaybackException {
        this.enabledRenderers = new Renderer[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.renderers.length; i3++) {
            Renderer renderer = this.renderers[i3];
            TrackSelection trackSelection = ((MediaPeriodHolder) this.playingPeriodHolder).trackSelections.get(i3);
            if (trackSelection != null) {
                int i4 = i2 + 1;
                this.enabledRenderers[i2] = renderer;
                if (renderer.getState() == 0) {
                    boolean z = this.playWhenReady && this.state == 3;
                    boolean z2 = !zArr[i3] && z;
                    Format[] formatArr = new Format[trackSelection.length()];
                    for (int i5 = 0; i5 < formatArr.length; i5++) {
                        formatArr[i5] = trackSelection.getFormat(i5);
                    }
                    renderer.enable(formatArr, this.playingPeriodHolder.sampleStreams[i3], this.rendererPositionUs, z2, this.playingPeriodHolder.rendererPositionOffsetUs);
                    MediaClock mediaClock = renderer.getMediaClock();
                    if (mediaClock != null) {
                        if (this.rendererMediaClock != null) {
                            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.rendererMediaClock = mediaClock;
                        this.rendererMediaClockSource = renderer;
                    }
                    if (z) {
                        renderer.start();
                    }
                }
                i2 = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class MediaPeriodHolder<T> {
        public boolean hasEnabledTracks;
        public int index;
        public boolean isLast;
        public final boolean[] mayRetainStreamFlags;
        public final MediaPeriod mediaPeriod;
        private final MediaSource mediaSource;
        public boolean needsContinueLoading;
        public MediaPeriodHolder<T> next;
        private TrackSelections<T> periodTrackSelections;
        public boolean prepared;
        private final RendererCapabilities[] rendererCapabilities;
        public long rendererPositionOffsetUs;
        private final Renderer[] renderers;
        public final SampleStream[] sampleStreams;
        public long startPositionUs;
        private TrackSelections<T> trackSelections;
        private final TrackSelector<T> trackSelector;
        public final Object uid;

        public MediaPeriodHolder(Renderer[] rendererArr, RendererCapabilities[] rendererCapabilitiesArr, TrackSelector<T> trackSelector, MediaSource mediaSource, MediaPeriod mediaPeriod, Object obj, long j) {
            this.renderers = rendererArr;
            this.rendererCapabilities = rendererCapabilitiesArr;
            this.trackSelector = trackSelector;
            this.mediaSource = mediaSource;
            this.mediaPeriod = mediaPeriod;
            this.uid = Assertions.checkNotNull(obj);
            this.sampleStreams = new SampleStream[rendererArr.length];
            this.mayRetainStreamFlags = new boolean[rendererArr.length];
            this.startPositionUs = j;
        }

        public void setNext(MediaPeriodHolder<T> mediaPeriodHolder) {
            this.next = mediaPeriodHolder;
        }

        public void setIndex(Timeline timeline, Timeline.Window window, int i) {
            this.index = i;
            this.isLast = this.index == timeline.getPeriodCount() + (-1) && !window.isDynamic;
        }

        public boolean isFullyBuffered() {
            return this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE);
        }

        public void handlePrepared(long j, LoadControl loadControl) throws ExoPlaybackException {
            this.prepared = true;
            selectTracks();
            this.startPositionUs = updatePeriodTrackSelection(j, loadControl, false);
        }

        public boolean selectTracks() throws ExoPlaybackException {
            TrackSelections<T> selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.mediaPeriod.getTrackGroups());
            if (selectTracks.equals(this.periodTrackSelections)) {
                return false;
            }
            this.trackSelections = selectTracks;
            return true;
        }

        public long updatePeriodTrackSelection(long j, LoadControl loadControl, boolean z) throws ExoPlaybackException {
            return updatePeriodTrackSelection(j, loadControl, z, new boolean[this.renderers.length]);
        }

        public long updatePeriodTrackSelection(long j, LoadControl loadControl, boolean z, boolean[] zArr) throws ExoPlaybackException {
            boolean z2;
            for (int i = 0; i < this.trackSelections.length; i++) {
                boolean[] zArr2 = this.mayRetainStreamFlags;
                if (!z) {
                    if (Util.areEqual(this.periodTrackSelections == null ? null : this.periodTrackSelections.get(i), this.trackSelections.get(i))) {
                        z2 = true;
                        zArr2[i] = z2;
                    }
                }
                z2 = false;
                zArr2[i] = z2;
            }
            long selectTracks = this.mediaPeriod.selectTracks(this.trackSelections.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j);
            this.periodTrackSelections = this.trackSelections;
            this.hasEnabledTracks = false;
            for (int i2 = 0; i2 < this.sampleStreams.length; i2++) {
                if (this.sampleStreams[i2] != null) {
                    Assertions.checkState(this.trackSelections.get(i2) != null);
                    this.hasEnabledTracks = true;
                } else {
                    Assertions.checkState(this.trackSelections.get(i2) == null);
                }
            }
            loadControl.onTracksSelected(this.renderers, this.mediaPeriod.getTrackGroups(), this.trackSelections);
            return selectTracks;
        }

        public void release() {
            try {
                this.mediaSource.releasePeriod(this.mediaPeriod);
            } catch (RuntimeException e) {
                Log.e(ExoPlayerImplInternal.TAG, "Period release failed.", e);
            }
        }
    }
}
