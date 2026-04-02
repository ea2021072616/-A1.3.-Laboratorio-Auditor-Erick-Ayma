package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import java.io.IOException;
import java.util.List;
/* loaded from: classes.dex */
public class DefaultSsChunkSource implements SsChunkSource {
    private int currentManifestChunkOffset;
    private final DataSource dataSource;
    private final int elementIndex;
    private final ChunkExtractorWrapper[] extractorWrappers;
    private IOException fatalError;
    private SsManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final TrackSelection trackSelection;

    /* loaded from: classes.dex */
    public static final class Factory implements SsChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory
        public SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, TrackSelection trackSelection, TrackEncryptionBox[] trackEncryptionBoxArr) {
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i, trackSelection, this.dataSourceFactory.createDataSource(), trackEncryptionBoxArr);
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, TrackSelection trackSelection, DataSource dataSource, TrackEncryptionBox[] trackEncryptionBoxArr) {
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = ssManifest;
        this.elementIndex = i;
        this.trackSelection = trackSelection;
        this.dataSource = dataSource;
        SsManifest.StreamElement streamElement = ssManifest.streamElements[i];
        this.extractorWrappers = new ChunkExtractorWrapper[trackSelection.length()];
        for (int i2 = 0; i2 < this.extractorWrappers.length; i2++) {
            int indexInTrackGroup = trackSelection.getIndexInTrackGroup(i2);
            Format format = streamElement.formats[indexInTrackGroup];
            this.extractorWrappers[i2] = new ChunkExtractorWrapper(new FragmentedMp4Extractor(3, new Track(indexInTrackGroup, streamElement.type, streamElement.timescale, C.TIME_UNSET, ssManifest.durationUs, format, 0, trackEncryptionBoxArr, streamElement.type == 2 ? 4 : 0, null, null), null), format, false, false);
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateManifest(SsManifest ssManifest) {
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.elementIndex];
        int i = streamElement.chunkCount;
        SsManifest.StreamElement streamElement2 = ssManifest.streamElements[this.elementIndex];
        if (i == 0 || streamElement2.chunkCount == 0) {
            this.currentManifestChunkOffset += i;
        } else {
            long startTimeUs = streamElement2.getStartTimeUs(0);
            if (streamElement.getStartTimeUs(i - 1) + streamElement.getChunkDurationUs(i - 1) <= startTimeUs) {
                this.currentManifestChunkOffset += i;
            } else {
                this.currentManifestChunkOffset = streamElement.getChunkIndex(startTimeUs) + this.currentManifestChunkOffset;
            }
        }
        this.manifest = ssManifest;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        if (this.fatalError != null) {
            throw this.fatalError;
        }
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        return (this.fatalError != null || this.trackSelection.length() < 2) ? list.size() : this.trackSelection.evaluateQueueSize(j, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public final void getNextChunk(MediaChunk mediaChunk, long j, ChunkHolder chunkHolder) {
        int nextChunkIndex;
        if (this.fatalError == null) {
            this.trackSelection.updateSelectedTrack(mediaChunk != null ? mediaChunk.endTimeUs - j : 0L);
            SsManifest.StreamElement streamElement = this.manifest.streamElements[this.elementIndex];
            if (streamElement.chunkCount == 0) {
                chunkHolder.endOfStream = !this.manifest.isLive;
                return;
            }
            if (mediaChunk == null) {
                nextChunkIndex = streamElement.getChunkIndex(j);
            } else {
                nextChunkIndex = mediaChunk.getNextChunkIndex() - this.currentManifestChunkOffset;
                if (nextChunkIndex < 0) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
            }
            if (nextChunkIndex >= streamElement.chunkCount) {
                chunkHolder.endOfStream = !this.manifest.isLive;
                return;
            }
            long startTimeUs = streamElement.getStartTimeUs(nextChunkIndex);
            long chunkDurationUs = startTimeUs + streamElement.getChunkDurationUs(nextChunkIndex);
            int i = nextChunkIndex + this.currentManifestChunkOffset;
            int selectedIndex = this.trackSelection.getSelectedIndex();
            chunkHolder.chunk = newMediaChunk(this.trackSelection.getSelectedFormat(), this.dataSource, streamElement.buildRequestUri(this.trackSelection.getIndexInTrackGroup(selectedIndex), nextChunkIndex), null, i, startTimeUs, chunkDurationUs, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), this.extractorWrappers[selectedIndex]);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc) {
        return z && ChunkedTrackBlacklistUtil.maybeBlacklistTrack(this.trackSelection, this.trackSelection.indexOf(chunk.trackFormat), exc);
    }

    private static MediaChunk newMediaChunk(Format format, DataSource dataSource, Uri uri, String str, int i, long j, long j2, int i2, Object obj, ChunkExtractorWrapper chunkExtractorWrapper) {
        return new ContainerMediaChunk(dataSource, new DataSpec(uri, 0L, -1L, str), format, i2, obj, j, j2, i, j, chunkExtractorWrapper, format);
    }
}
