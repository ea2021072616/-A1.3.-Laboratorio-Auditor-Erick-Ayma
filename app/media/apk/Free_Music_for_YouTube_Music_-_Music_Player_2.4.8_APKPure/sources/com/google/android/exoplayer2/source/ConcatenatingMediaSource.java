package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class ConcatenatingMediaSource implements MediaSource {
    private final boolean[] duplicateFlags;
    private MediaSource.Listener listener;
    private final Object[] manifests;
    private final MediaSource[] mediaSources;
    private final Map<MediaPeriod, Integer> sourceIndexByMediaPeriod = new HashMap();
    private ConcatenatedTimeline timeline;
    private final Timeline[] timelines;

    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this.mediaSources = mediaSourceArr;
        this.timelines = new Timeline[mediaSourceArr.length];
        this.manifests = new Object[mediaSourceArr.length];
        this.duplicateFlags = buildDuplicateFlags(mediaSourceArr);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(MediaSource.Listener listener) {
        this.listener = listener;
        for (final int i = 0; i < this.mediaSources.length; i++) {
            if (!this.duplicateFlags[i]) {
                this.mediaSources[i].prepareSource(new MediaSource.Listener() { // from class: com.google.android.exoplayer2.source.ConcatenatingMediaSource.1
                    @Override // com.google.android.exoplayer2.source.MediaSource.Listener
                    public void onSourceInfoRefreshed(Timeline timeline, Object obj) {
                        ConcatenatingMediaSource.this.handleSourceInfoRefreshed(i, timeline, obj);
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        for (int i = 0; i < this.mediaSources.length; i++) {
            if (!this.duplicateFlags[i]) {
                this.mediaSources[i].maybeThrowSourceInfoRefreshError();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(int i, Allocator allocator, long j) {
        int sourceIndexForPeriod = this.timeline.getSourceIndexForPeriod(i);
        MediaPeriod createPeriod = this.mediaSources[sourceIndexForPeriod].createPeriod(i - this.timeline.getFirstPeriodIndexInSource(sourceIndexForPeriod), allocator, j);
        this.sourceIndexByMediaPeriod.put(createPeriod, Integer.valueOf(sourceIndexForPeriod));
        return createPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        int intValue = this.sourceIndexByMediaPeriod.get(mediaPeriod).intValue();
        this.sourceIndexByMediaPeriod.remove(mediaPeriod);
        this.mediaSources[intValue].releasePeriod(mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        for (int i = 0; i < this.mediaSources.length; i++) {
            if (!this.duplicateFlags[i]) {
                this.mediaSources[i].releaseSource();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSourceInfoRefreshed(int i, Timeline timeline, Object obj) {
        this.timelines[i] = timeline;
        this.manifests[i] = obj;
        for (int i2 = i + 1; i2 < this.mediaSources.length; i2++) {
            if (this.mediaSources[i2] == this.mediaSources[i]) {
                this.timelines[i2] = timeline;
                this.manifests[i2] = obj;
            }
        }
        for (Timeline timeline2 : this.timelines) {
            if (timeline2 == null) {
                return;
            }
        }
        this.timeline = new ConcatenatedTimeline((Timeline[]) this.timelines.clone());
        this.listener.onSourceInfoRefreshed(this.timeline, this.manifests.clone());
    }

    private static boolean[] buildDuplicateFlags(MediaSource[] mediaSourceArr) {
        boolean[] zArr = new boolean[mediaSourceArr.length];
        IdentityHashMap identityHashMap = new IdentityHashMap(mediaSourceArr.length);
        for (int i = 0; i < mediaSourceArr.length; i++) {
            MediaSource mediaSource = mediaSourceArr[i];
            if (!identityHashMap.containsKey(mediaSource)) {
                identityHashMap.put(mediaSource, null);
            } else {
                zArr[i] = true;
            }
        }
        return zArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ConcatenatedTimeline extends Timeline {
        private final int[] sourcePeriodOffsets;
        private final int[] sourceWindowOffsets;
        private final Timeline[] timelines;

        public ConcatenatedTimeline(Timeline[] timelineArr) {
            int[] iArr = new int[timelineArr.length];
            int[] iArr2 = new int[timelineArr.length];
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < timelineArr.length; i3++) {
                Timeline timeline = timelineArr[i3];
                i2 += timeline.getPeriodCount();
                iArr[i3] = i2;
                i += timeline.getWindowCount();
                iArr2[i3] = i;
            }
            this.timelines = timelineArr;
            this.sourcePeriodOffsets = iArr;
            this.sourceWindowOffsets = iArr2;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.sourceWindowOffsets[this.sourceWindowOffsets.length - 1];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z) {
            int sourceIndexForWindow = getSourceIndexForWindow(i);
            int firstWindowIndexInSource = getFirstWindowIndexInSource(sourceIndexForWindow);
            int firstPeriodIndexInSource = getFirstPeriodIndexInSource(sourceIndexForWindow);
            this.timelines[sourceIndexForWindow].getWindow(i - firstWindowIndexInSource, window, z);
            window.firstPeriodIndex += firstPeriodIndexInSource;
            window.lastPeriodIndex += firstPeriodIndexInSource;
            return window;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.sourcePeriodOffsets[this.sourcePeriodOffsets.length - 1];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            int sourceIndexForPeriod = getSourceIndexForPeriod(i);
            int firstWindowIndexInSource = getFirstWindowIndexInSource(sourceIndexForPeriod);
            this.timelines[sourceIndexForPeriod].getPeriod(i - getFirstPeriodIndexInSource(sourceIndexForPeriod), period, z);
            period.windowIndex = firstWindowIndexInSource + period.windowIndex;
            if (z) {
                period.uid = Pair.create(Integer.valueOf(sourceIndexForPeriod), period.uid);
            }
            return period;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                if (pair.first instanceof Integer) {
                    int intValue = ((Integer) pair.first).intValue();
                    Object obj2 = pair.second;
                    if (intValue < 0 || intValue >= this.timelines.length) {
                        return -1;
                    }
                    int indexOfPeriod = this.timelines[intValue].getIndexOfPeriod(obj2);
                    return indexOfPeriod == -1 ? -1 : getFirstPeriodIndexInSource(intValue) + indexOfPeriod;
                }
                return -1;
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getSourceIndexForPeriod(int i) {
            return Util.binarySearchFloor(this.sourcePeriodOffsets, i, true, false) + 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getFirstPeriodIndexInSource(int i) {
            if (i == 0) {
                return 0;
            }
            return this.sourcePeriodOffsets[i - 1];
        }

        private int getSourceIndexForWindow(int i) {
            return Util.binarySearchFloor(this.sourceWindowOffsets, i, true, false) + 1;
        }

        private int getFirstWindowIndexInSource(int i) {
            if (i == 0) {
                return 0;
            }
            return this.sourceWindowOffsets[i - 1];
        }
    }
}
