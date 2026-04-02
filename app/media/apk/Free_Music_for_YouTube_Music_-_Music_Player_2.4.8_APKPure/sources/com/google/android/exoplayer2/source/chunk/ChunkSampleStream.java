package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.DefaultTrackOutput;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk> {
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
    private final T chunkSource;
    private Format downstreamTrackFormat;
    private final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    private long lastSeekPositionUs;
    private boolean loadingFinished;
    private final int minLoadableRetryCount;
    private long pendingResetPositionUs;
    private final DefaultTrackOutput sampleQueue;
    private final int trackType;
    private final Loader loader = new Loader("Loader:ChunkSampleStream");
    private final ChunkHolder nextChunkHolder = new ChunkHolder();
    private final LinkedList<BaseMediaChunk> mediaChunks = new LinkedList<>();
    private final List<BaseMediaChunk> readOnlyMediaChunks = Collections.unmodifiableList(this.mediaChunks);

    public ChunkSampleStream(int i, T t, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j, int i2, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher) {
        this.trackType = i;
        this.chunkSource = t;
        this.callback = callback;
        this.eventDispatcher = eventDispatcher;
        this.minLoadableRetryCount = i2;
        this.sampleQueue = new DefaultTrackOutput(allocator);
        this.lastSeekPositionUs = j;
        this.pendingResetPositionUs = j;
    }

    public T getChunkSource() {
        return this.chunkSource;
    }

    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j = this.lastSeekPositionUs;
        BaseMediaChunk last = this.mediaChunks.getLast();
        if (!last.isLoadCompleted()) {
            last = this.mediaChunks.size() > 1 ? this.mediaChunks.get(this.mediaChunks.size() - 2) : null;
        }
        return Math.max(last != null ? Math.max(j, last.endTimeUs) : j, this.sampleQueue.getLargestQueuedTimestampUs());
    }

    public void seekToUs(long j) {
        this.lastSeekPositionUs = j;
        if (!isPendingReset() && this.sampleQueue.skipToKeyframeBefore(j)) {
            while (this.mediaChunks.size() > 1 && this.mediaChunks.get(1).getFirstSampleIndex() <= this.sampleQueue.getReadIndex()) {
                this.mediaChunks.removeFirst();
            }
            return;
        }
        this.pendingResetPositionUs = j;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
        } else {
            this.sampleQueue.reset(true);
        }
    }

    public void release() {
        this.sampleQueue.disable();
        this.loader.release();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return this.loadingFinished || !(isPendingReset() || this.sampleQueue.isEmpty());
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        if (!this.loader.isLoading()) {
            this.chunkSource.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer) {
        if (isPendingReset()) {
            return -3;
        }
        while (this.mediaChunks.size() > 1 && this.mediaChunks.get(1).getFirstSampleIndex() <= this.sampleQueue.getReadIndex()) {
            this.mediaChunks.removeFirst();
        }
        BaseMediaChunk first = this.mediaChunks.getFirst();
        Format format = first.trackFormat;
        if (!format.equals(this.downstreamTrackFormat)) {
            this.eventDispatcher.downstreamFormatChanged(this.trackType, format, first.trackSelectionReason, first.trackSelectionData, first.startTimeUs);
        }
        this.downstreamTrackFormat = format;
        return this.sampleQueue.readData(formatHolder, decoderInputBuffer, this.loadingFinished, this.lastSeekPositionUs);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void skipToKeyframeBefore(long j) {
        this.sampleQueue.skipToKeyframeBefore(j);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(Chunk chunk, long j, long j2) {
        this.chunkSource.onChunkLoadCompleted(chunk);
        this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
        if (!z) {
            this.sampleQueue.reset(true);
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(Chunk chunk, long j, long j2, IOException iOException) {
        long bytesLoaded = chunk.bytesLoaded();
        boolean isMediaChunk = isMediaChunk(chunk);
        boolean z = false;
        if (this.chunkSource.onChunkLoadError(chunk, !isMediaChunk || bytesLoaded == 0 || this.mediaChunks.size() > 1, iOException)) {
            z = true;
            if (isMediaChunk) {
                BaseMediaChunk removeLast = this.mediaChunks.removeLast();
                Assertions.checkState(removeLast == chunk);
                this.sampleQueue.discardUpstreamSamples(removeLast.getFirstSampleIndex());
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
        }
        this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, bytesLoaded, iOException, z);
        if (z) {
            this.callback.onContinueLoadingRequested(this);
            return 2;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.loader.isLoading()) {
            return false;
        }
        T t = this.chunkSource;
        BaseMediaChunk last = this.mediaChunks.isEmpty() ? null : this.mediaChunks.getLast();
        if (this.pendingResetPositionUs != C.TIME_UNSET) {
            j = this.pendingResetPositionUs;
        }
        t.getNextChunk(last, j, this.nextChunkHolder);
        boolean z = this.nextChunkHolder.endOfStream;
        Chunk chunk = this.nextChunkHolder.chunk;
        this.nextChunkHolder.clear();
        if (z) {
            this.loadingFinished = true;
            return true;
        } else if (chunk == null) {
            return false;
        } else {
            if (isMediaChunk(chunk)) {
                this.pendingResetPositionUs = C.TIME_UNSET;
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                baseMediaChunk.init(this.sampleQueue);
                this.mediaChunks.add(baseMediaChunk);
            }
            this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.minLoadableRetryCount));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return this.mediaChunks.getLast().endTimeUs;
    }

    private void maybeDiscardUpstream(long j) {
        discardUpstreamMediaChunks(Math.max(1, this.chunkSource.getPreferredQueueSize(j, this.readOnlyMediaChunks)));
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != C.TIME_UNSET;
    }

    private boolean discardUpstreamMediaChunks(int i) {
        if (this.mediaChunks.size() <= i) {
            return false;
        }
        long j = 0;
        long j2 = this.mediaChunks.getLast().endTimeUs;
        BaseMediaChunk baseMediaChunk = null;
        while (this.mediaChunks.size() > i) {
            baseMediaChunk = this.mediaChunks.removeLast();
            j = baseMediaChunk.startTimeUs;
            this.loadingFinished = false;
        }
        this.sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex());
        this.eventDispatcher.upstreamDiscarded(this.trackType, j, j2);
        return true;
    }
}
