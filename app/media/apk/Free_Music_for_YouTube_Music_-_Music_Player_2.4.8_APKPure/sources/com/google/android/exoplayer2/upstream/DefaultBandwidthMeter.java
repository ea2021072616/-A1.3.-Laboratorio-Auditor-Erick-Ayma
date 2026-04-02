package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.SlidingPercentile;
/* loaded from: classes.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener<Object> {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    public static final int DEFAULT_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private long bitrateEstimate;
    private final Handler eventHandler;
    private final BandwidthMeter.EventListener eventListener;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;

    public DefaultBandwidthMeter() {
        this(null, null);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener) {
        this(handler, eventListener, 2000);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, int i) {
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.slidingPercentile = new SlidingPercentile(i);
        this.bitrateEstimate = -1L;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(Object obj, DataSpec dataSpec) {
        if (this.streamCount == 0) {
            this.sampleStartTimeMs = SystemClock.elapsedRealtime();
        }
        this.streamCount++;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onBytesTransferred(Object obj, int i) {
        this.sampleBytesTransferred += i;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(Object obj) {
        Assertions.checkState(this.streamCount > 0);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = (int) (elapsedRealtime - this.sampleStartTimeMs);
        this.totalElapsedTimeMs += i;
        this.totalBytesTransferred += this.sampleBytesTransferred;
        if (i > 0) {
            this.slidingPercentile.addSample((int) Math.sqrt(this.sampleBytesTransferred), (float) ((this.sampleBytesTransferred * 8000) / i));
            if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float percentile = this.slidingPercentile.getPercentile(0.5f);
                this.bitrateEstimate = Float.isNaN(percentile) ? -1L : percentile;
            }
        }
        notifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
        int i2 = this.streamCount - 1;
        this.streamCount = i2;
        if (i2 > 0) {
            this.sampleStartTimeMs = elapsedRealtime;
        }
        this.sampleBytesTransferred = 0L;
    }

    private void notifyBandwidthSample(final int i, final long j, final long j2) {
        if (this.eventHandler != null && this.eventListener != null) {
            this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultBandwidthMeter.this.eventListener.onBandwidthSample(i, j, j2);
                }
            });
        }
    }
}
