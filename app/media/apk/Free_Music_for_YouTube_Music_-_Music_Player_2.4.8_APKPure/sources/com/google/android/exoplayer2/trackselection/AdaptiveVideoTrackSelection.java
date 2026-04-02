package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;
/* loaded from: classes.dex */
public class AdaptiveVideoTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_INITIAL_BITRATE = 800000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final long maxDurationForQualityDecreaseUs;
    private final int maxInitialBitrate;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private int reason;
    private int selectedIndex;

    /* loaded from: classes.dex */
    public static final class Factory implements TrackSelection.Factory {
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final int maxDurationForQualityDecreaseMs;
        private final int maxInitialBitrate;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;

        public Factory(BandwidthMeter bandwidthMeter) {
            this(bandwidthMeter, AdaptiveVideoTrackSelection.DEFAULT_MAX_INITIAL_BITRATE, 10000, 25000, 25000, 0.75f);
        }

        public Factory(BandwidthMeter bandwidthMeter, int i, int i2, int i3, int i4, float f) {
            this.bandwidthMeter = bandwidthMeter;
            this.maxInitialBitrate = i;
            this.minDurationForQualityIncreaseMs = i2;
            this.maxDurationForQualityDecreaseMs = i3;
            this.minDurationToRetainAfterDiscardMs = i4;
            this.bandwidthFraction = f;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public AdaptiveVideoTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            return new AdaptiveVideoTrackSelection(trackGroup, iArr, this.bandwidthMeter, this.maxInitialBitrate, this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.bandwidthFraction);
        }
    }

    public AdaptiveVideoTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, bandwidthMeter, DEFAULT_MAX_INITIAL_BITRATE, 10000L, 25000L, 25000L, 0.75f);
    }

    public AdaptiveVideoTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter, int i, long j, long j2, long j3, float f) {
        super(trackGroup, iArr);
        this.bandwidthMeter = bandwidthMeter;
        this.maxInitialBitrate = i;
        this.minDurationForQualityIncreaseUs = j * 1000;
        this.maxDurationForQualityDecreaseUs = j2 * 1000;
        this.minDurationToRetainAfterDiscardUs = j3 * 1000;
        this.bandwidthFraction = f;
        this.selectedIndex = determineIdealSelectedIndex(Long.MIN_VALUE);
        this.reason = 1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.selectedIndex;
        Format selectedFormat = getSelectedFormat();
        int determineIdealSelectedIndex = determineIdealSelectedIndex(elapsedRealtime);
        Format format = getFormat(determineIdealSelectedIndex);
        this.selectedIndex = determineIdealSelectedIndex;
        if (selectedFormat != null && !isBlacklisted(this.selectedIndex, elapsedRealtime)) {
            if (format.bitrate > selectedFormat.bitrate && j < this.minDurationForQualityIncreaseUs) {
                this.selectedIndex = i;
            } else if (format.bitrate < selectedFormat.bitrate && j >= this.maxDurationForQualityDecreaseUs) {
                this.selectedIndex = i;
            }
        }
        if (this.selectedIndex != i) {
            this.reason = 3;
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (list.get(size - 1).endTimeUs - j < this.minDurationToRetainAfterDiscardUs) {
            return size;
        }
        Format format = getFormat(determineIdealSelectedIndex(SystemClock.elapsedRealtime()));
        for (int i = 0; i < size; i++) {
            MediaChunk mediaChunk = list.get(i);
            if (mediaChunk.startTimeUs - j >= this.minDurationToRetainAfterDiscardUs && mediaChunk.trackFormat.bitrate < format.bitrate && mediaChunk.trackFormat.height < format.height && mediaChunk.trackFormat.height < 720 && mediaChunk.trackFormat.width < 1280) {
                return i;
            }
        }
        return size;
    }

    private int determineIdealSelectedIndex(long j) {
        long bitrateEstimate;
        long j2 = this.bandwidthMeter.getBitrateEstimate() == -1 ? this.maxInitialBitrate : ((float) bitrateEstimate) * this.bandwidthFraction;
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (j == Long.MIN_VALUE || !isBlacklisted(i2, j)) {
                if (getFormat(i2).bitrate <= j2) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }
}
