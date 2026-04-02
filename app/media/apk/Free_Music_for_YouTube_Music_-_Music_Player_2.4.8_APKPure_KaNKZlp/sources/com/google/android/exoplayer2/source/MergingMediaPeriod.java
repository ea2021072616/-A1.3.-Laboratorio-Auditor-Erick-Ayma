package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
/* loaded from: classes.dex */
final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private MediaPeriod[] enabledPeriods;
    private int pendingChildPrepareCount;
    public final MediaPeriod[] periods;
    private SequenceableLoader sequenceableLoader;
    private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices = new IdentityHashMap<>();
    private TrackGroupArray trackGroups;

    public MergingMediaPeriod(MediaPeriod... mediaPeriodArr) {
        this.periods = mediaPeriodArr;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback) {
        this.callback = callback;
        this.pendingChildPrepareCount = this.periods.length;
        for (MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.prepare(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int[] iArr = new int[trackSelectionArr.length];
        int[] iArr2 = new int[trackSelectionArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= trackSelectionArr.length) {
                break;
            }
            iArr[i2] = sampleStreamArr[i2] == null ? -1 : this.streamPeriodIndices.get(sampleStreamArr[i2]).intValue();
            iArr2[i2] = -1;
            if (trackSelectionArr[i2] != null) {
                TrackGroup trackGroup = trackSelectionArr[i2].getTrackGroup();
                int i3 = 0;
                while (true) {
                    if (i3 < this.periods.length) {
                        if (this.periods[i3].getTrackGroups().indexOf(trackGroup) == -1) {
                            i3++;
                        } else {
                            iArr2[i2] = i3;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i = i2 + 1;
        }
        this.streamPeriodIndices.clear();
        SampleStream[] sampleStreamArr2 = new SampleStream[trackSelectionArr.length];
        SampleStream[] sampleStreamArr3 = new SampleStream[trackSelectionArr.length];
        TrackSelection[] trackSelectionArr2 = new TrackSelection[trackSelectionArr.length];
        ArrayList arrayList = new ArrayList(this.periods.length);
        int i4 = 0;
        long j2 = j;
        while (i4 < this.periods.length) {
            for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
                sampleStreamArr3[i5] = iArr[i5] == i4 ? sampleStreamArr[i5] : null;
                trackSelectionArr2[i5] = iArr2[i5] == i4 ? trackSelectionArr[i5] : null;
            }
            long selectTracks = this.periods[i4].selectTracks(trackSelectionArr2, zArr, sampleStreamArr3, zArr2, j2);
            if (i4 == 0) {
                j2 = selectTracks;
            } else if (selectTracks != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < trackSelectionArr.length; i6++) {
                if (iArr2[i6] == i4) {
                    Assertions.checkState(sampleStreamArr3[i6] != null);
                    sampleStreamArr2[i6] = sampleStreamArr3[i6];
                    z = true;
                    this.streamPeriodIndices.put(sampleStreamArr3[i6], Integer.valueOf(i4));
                } else if (iArr[i6] == i4) {
                    Assertions.checkState(sampleStreamArr3[i6] == null);
                }
            }
            if (z) {
                arrayList.add(this.periods[i4]);
            }
            i4++;
        }
        System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, sampleStreamArr2.length);
        this.enabledPeriods = new MediaPeriod[arrayList.size()];
        arrayList.toArray(this.enabledPeriods);
        this.sequenceableLoader = new CompositeSequenceableLoader(this.enabledPeriods);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.sequenceableLoader.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.sequenceableLoader.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        long readDiscontinuity = this.periods[0].readDiscontinuity();
        for (int i = 1; i < this.periods.length; i++) {
            if (this.periods[i].readDiscontinuity() != C.TIME_UNSET) {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (readDiscontinuity != C.TIME_UNSET) {
            for (int i2 = 0; i2 < this.enabledPeriods.length; i2++) {
                if (this.enabledPeriods[i2] != this.periods[0] && this.enabledPeriods[i2].seekToUs(readDiscontinuity) != readDiscontinuity) {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return readDiscontinuity;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        long j = Long.MAX_VALUE;
        for (MediaPeriod mediaPeriod : this.enabledPeriods) {
            long bufferedPositionUs = mediaPeriod.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                j = Math.min(j, bufferedPositionUs);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        long seekToUs = this.enabledPeriods[0].seekToUs(j);
        for (int i = 1; i < this.enabledPeriods.length; i++) {
            if (this.enabledPeriods[i].seekToUs(seekToUs) != seekToUs) {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return seekToUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        int i = this.pendingChildPrepareCount - 1;
        this.pendingChildPrepareCount = i;
        if (i <= 0) {
            int i2 = 0;
            for (MediaPeriod mediaPeriod2 : this.periods) {
                i2 += mediaPeriod2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            MediaPeriod[] mediaPeriodArr = this.periods;
            int length = mediaPeriodArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                TrackGroupArray trackGroups = mediaPeriodArr[i3].getTrackGroups();
                int i5 = trackGroups.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    trackGroupArr[i6] = trackGroups.get(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.trackGroups != null) {
            this.callback.onContinueLoadingRequested(this);
        }
    }
}
