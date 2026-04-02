package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelections;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes.dex */
public final class DefaultLoadControl implements LoadControl {
    private static final int ABOVE_HIGH_WATERMARK = 0;
    private static final int BELOW_LOW_WATERMARK = 2;
    private static final int BETWEEN_WATERMARKS = 1;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_MAX_BUFFER_MS = 30000;
    public static final int DEFAULT_MIN_BUFFER_MS = 15000;
    private final DefaultAllocator allocator;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferUs;
    private int targetBufferSize;

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536));
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, 15000, DEFAULT_MAX_BUFFER_MS, 2500L, ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i, int i2, long j, long j2) {
        this.allocator = defaultAllocator;
        this.minBufferUs = i * 1000;
        this.maxBufferUs = i2 * 1000;
        this.bufferForPlaybackUs = j * 1000;
        this.bufferForPlaybackAfterRebufferUs = j2 * 1000;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelections<?> trackSelections) {
        this.targetBufferSize = 0;
        for (int i = 0; i < rendererArr.length; i++) {
            if (trackSelections.get(i) != null) {
                this.targetBufferSize += Util.getDefaultBufferSize(rendererArr[i].getTrackType());
            }
        }
        this.allocator.setTargetBufferSize(this.targetBufferSize);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public Allocator getAllocator() {
        return this.allocator;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j, boolean z) {
        long j2 = z ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long j) {
        boolean z = false;
        int bufferTimeState = getBufferTimeState(j);
        boolean z2 = this.allocator.getTotalBytesAllocated() >= this.targetBufferSize;
        if (bufferTimeState == 2 || (bufferTimeState == 1 && this.isBuffering && !z2)) {
            z = true;
        }
        this.isBuffering = z;
        return this.isBuffering;
    }

    private int getBufferTimeState(long j) {
        if (j > this.maxBufferUs) {
            return 0;
        }
        return j < this.minBufferUs ? 2 : 1;
    }

    private void reset(boolean z) {
        this.targetBufferSize = 0;
        this.isBuffering = false;
        if (z) {
            this.allocator.reset();
        }
    }
}
