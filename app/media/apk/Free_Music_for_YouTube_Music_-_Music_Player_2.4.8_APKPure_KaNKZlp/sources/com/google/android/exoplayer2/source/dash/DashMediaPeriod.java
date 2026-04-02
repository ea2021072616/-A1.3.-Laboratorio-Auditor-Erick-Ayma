package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.CompositeSequenceableLoader;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>> {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    private final DashChunkSource.Factory chunkSourceFactory;
    private final long elapsedRealtimeOffset;
    private final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    final int id;
    private int index;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int minLoadableRetryCount;
    private Period period;
    private ChunkSampleStream<DashChunkSource>[] sampleStreams = newSampleStreamArray(0);
    private CompositeSequenceableLoader sequenceableLoader = new CompositeSequenceableLoader(this.sampleStreams);
    private final TrackGroupArray trackGroups;

    public DashMediaPeriod(int i, DashManifest dashManifest, int i2, DashChunkSource.Factory factory, int i3, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher, long j, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        this.id = i;
        this.manifest = dashManifest;
        this.index = i2;
        this.chunkSourceFactory = factory;
        this.minLoadableRetryCount = i3;
        this.eventDispatcher = eventDispatcher;
        this.elapsedRealtimeOffset = j;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.allocator = allocator;
        this.period = dashManifest.getPeriod(i2);
        this.trackGroups = buildTrackGroups(this.period);
    }

    public void updateManifest(DashManifest dashManifest, int i) {
        this.manifest = dashManifest;
        this.index = i;
        this.period = dashManifest.getPeriod(i);
        if (this.sampleStreams != null) {
            for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
                chunkSampleStream.getChunkSource().updateManifest(dashManifest, i);
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    public void release() {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback) {
        this.callback = callback;
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < trackSelectionArr.length) {
                if (sampleStreamArr[i2] != null) {
                    ChunkSampleStream chunkSampleStream = (ChunkSampleStream) sampleStreamArr[i2];
                    if (trackSelectionArr[i2] == null || !zArr[i2]) {
                        chunkSampleStream.release();
                        sampleStreamArr[i2] = null;
                    } else {
                        arrayList.add(chunkSampleStream);
                    }
                }
                if (sampleStreamArr[i2] == null && trackSelectionArr[i2] != null) {
                    ChunkSampleStream<DashChunkSource> buildSampleStream = buildSampleStream(trackSelectionArr[i2], j);
                    arrayList.add(buildSampleStream);
                    sampleStreamArr[i2] = buildSampleStream;
                    zArr2[i2] = true;
                }
                i = i2 + 1;
            } else {
                this.sampleStreams = newSampleStreamArray(arrayList.size());
                arrayList.toArray(this.sampleStreams);
                this.sequenceableLoader = new CompositeSequenceableLoader(this.sampleStreams);
                return j;
            }
        }
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
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        long j = Long.MAX_VALUE;
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            long bufferedPositionUs = chunkSampleStream.getBufferedPositionUs();
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
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.seekToUs(j);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }

    private static TrackGroupArray buildTrackGroups(Period period) {
        TrackGroup[] trackGroupArr = new TrackGroup[period.adaptationSets.size()];
        for (int i = 0; i < period.adaptationSets.size(); i++) {
            List<Representation> list = period.adaptationSets.get(i).representations;
            Format[] formatArr = new Format[list.size()];
            for (int i2 = 0; i2 < formatArr.length; i2++) {
                formatArr[i2] = list.get(i2).format;
            }
            trackGroupArr[i] = new TrackGroup(formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private ChunkSampleStream<DashChunkSource> buildSampleStream(TrackSelection trackSelection, long j) {
        int indexOf = this.trackGroups.indexOf(trackSelection.getTrackGroup());
        AdaptationSet adaptationSet = this.period.adaptationSets.get(indexOf);
        return new ChunkSampleStream<>(adaptationSet.type, this.chunkSourceFactory.createDashChunkSource(this.manifestLoaderErrorThrower, this.manifest, this.index, indexOf, trackSelection, this.elapsedRealtimeOffset), this, this.allocator, j, this.minLoadableRetryCount, this.eventDispatcher);
    }

    private static ChunkSampleStream<DashChunkSource>[] newSampleStreamArray(int i) {
        return new ChunkSampleStream[i];
    }
}
