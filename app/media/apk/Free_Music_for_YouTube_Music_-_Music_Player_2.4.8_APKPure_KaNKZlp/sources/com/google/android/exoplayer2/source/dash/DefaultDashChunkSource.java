package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;
/* loaded from: classes.dex */
public class DefaultDashChunkSource implements DashChunkSource {
    private final int adaptationSetIndex;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    private IOException fatalError;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private boolean missingLastSegment;
    private int periodIndex;
    private final RepresentationHolder[] representationHolders;
    private final TrackSelection trackSelection;

    /* loaded from: classes.dex */
    public static final class Factory implements DashChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashChunkSource.Factory
        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int i2, TrackSelection trackSelection, long j) {
            return new DefaultDashChunkSource(loaderErrorThrower, dashManifest, i, i2, trackSelection, this.dataSourceFactory.createDataSource(), j);
        }
    }

    public DefaultDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int i2, TrackSelection trackSelection, DataSource dataSource, long j) {
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest;
        this.adaptationSetIndex = i2;
        this.trackSelection = trackSelection;
        this.dataSource = dataSource;
        this.periodIndex = i;
        this.elapsedRealtimeOffsetMs = j;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i);
        List<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[trackSelection.length()];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.representationHolders.length) {
                this.representationHolders[i4] = new RepresentationHolder(periodDurationUs, representations.get(trackSelection.getIndexInTrackGroup(i4)));
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateManifest(DashManifest dashManifest, int i) {
        try {
            this.manifest = dashManifest;
            this.periodIndex = i;
            long periodDurationUs = this.manifest.getPeriodDurationUs(this.periodIndex);
            List<Representation> representations = getRepresentations();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.representationHolders.length) {
                    this.representationHolders[i3].updateRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i3)));
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } catch (BehindLiveWindowException e) {
            this.fatalError = e;
        }
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
        int i;
        int i2;
        int nextChunkIndex;
        if (this.fatalError == null) {
            this.trackSelection.updateSelectedTrack(mediaChunk != null ? mediaChunk.endTimeUs - j : 0L);
            RepresentationHolder representationHolder = this.representationHolders[this.trackSelection.getSelectedIndex()];
            Representation representation = representationHolder.representation;
            DashSegmentIndex dashSegmentIndex = representationHolder.segmentIndex;
            RangedUri rangedUri = null;
            RangedUri rangedUri2 = null;
            Format format = representationHolder.sampleFormat;
            if (format == null) {
                rangedUri = representation.getInitializationUri();
            }
            if (dashSegmentIndex == null) {
                rangedUri2 = representation.getIndexUri();
            }
            if (rangedUri != null || rangedUri2 != null) {
                chunkHolder.chunk = newInitializationChunk(representationHolder, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), rangedUri, rangedUri2);
                return;
            }
            long nowUnixTimeUs = getNowUnixTimeUs();
            int firstSegmentNum = representationHolder.getFirstSegmentNum();
            int lastSegmentNum = representationHolder.getLastSegmentNum();
            if (lastSegmentNum == -1) {
                long j2 = (nowUnixTimeUs - (this.manifest.availabilityStartTime * 1000)) - (this.manifest.getPeriod(this.periodIndex).startMs * 1000);
                if (this.manifest.timeShiftBufferDepth != C.TIME_UNSET) {
                    firstSegmentNum = Math.max(firstSegmentNum, representationHolder.getSegmentNum(j2 - (this.manifest.timeShiftBufferDepth * 1000)));
                }
                int segmentNum = representationHolder.getSegmentNum(j2) - 1;
                i = firstSegmentNum;
                i2 = segmentNum;
            } else {
                i = firstSegmentNum;
                i2 = lastSegmentNum;
            }
            if (mediaChunk == null) {
                nextChunkIndex = Util.constrainValue(representationHolder.getSegmentNum(j), i, i2);
            } else {
                nextChunkIndex = mediaChunk.getNextChunkIndex();
                if (nextChunkIndex < i) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
            }
            if (nextChunkIndex > i2 || (this.missingLastSegment && nextChunkIndex >= i2)) {
                chunkHolder.endOfStream = !this.manifest.dynamic || this.periodIndex < this.manifest.getPeriodCount() + (-1);
            } else {
                chunkHolder.chunk = newMediaChunk(representationHolder, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), format, nextChunkIndex);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(Chunk chunk) {
        SeekMap seekMap;
        if (chunk instanceof InitializationChunk) {
            InitializationChunk initializationChunk = (InitializationChunk) chunk;
            RepresentationHolder representationHolder = this.representationHolders[this.trackSelection.indexOf(initializationChunk.trackFormat)];
            Format sampleFormat = initializationChunk.getSampleFormat();
            if (sampleFormat != null) {
                representationHolder.setSampleFormat(sampleFormat);
            }
            if (representationHolder.segmentIndex == null && (seekMap = initializationChunk.getSeekMap()) != null) {
                representationHolder.segmentIndex = new DashWrappingSegmentIndex((ChunkIndex) seekMap, initializationChunk.dataSpec.uri.toString());
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc) {
        if (!z) {
            return false;
        }
        if (!this.manifest.dynamic && (chunk instanceof MediaChunk) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404) {
            if (((MediaChunk) chunk).chunkIndex >= this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)].getLastSegmentNum()) {
                this.missingLastSegment = true;
                return true;
            }
        }
        return ChunkedTrackBlacklistUtil.maybeBlacklistTrack(this.trackSelection, this.trackSelection.indexOf(chunk.trackFormat), exc);
    }

    private List<Representation> getRepresentations() {
        return this.manifest.getPeriod(this.periodIndex).adaptationSets.get(this.adaptationSetIndex).representations;
    }

    private long getNowUnixTimeUs() {
        return this.elapsedRealtimeOffsetMs != 0 ? (SystemClock.elapsedRealtime() + this.elapsedRealtimeOffsetMs) * 1000 : System.currentTimeMillis() * 1000;
    }

    private Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource, Format format, int i, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        if (rangedUri != null) {
            RangedUri attemptMerge = rangedUri.attemptMerge(rangedUri2);
            if (attemptMerge != null) {
                rangedUri = attemptMerge;
            }
        } else {
            rangedUri = rangedUri2;
        }
        return new InitializationChunk(dataSource, new DataSpec(rangedUri.getUri(), rangedUri.start, rangedUri.length, representationHolder.representation.getCacheKey()), format, i, obj, representationHolder.extractorWrapper);
    }

    private Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource, Format format, int i, Object obj, Format format2, int i2) {
        Representation representation = representationHolder.representation;
        long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(i2);
        long segmentEndTimeUs = representationHolder.getSegmentEndTimeUs(i2);
        RangedUri segmentUrl = representationHolder.getSegmentUrl(i2);
        DataSpec dataSpec = new DataSpec(segmentUrl.getUri(), segmentUrl.start, segmentUrl.length, representation.getCacheKey());
        if (representationHolder.extractorWrapper == null) {
            return new SingleSampleMediaChunk(dataSource, dataSpec, format, i, obj, segmentStartTimeUs, segmentEndTimeUs, i2, format);
        }
        return new ContainerMediaChunk(dataSource, dataSpec, format, i, obj, segmentStartTimeUs, segmentEndTimeUs, i2, -representation.presentationTimeOffsetUs, representationHolder.extractorWrapper, format2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class RepresentationHolder {
        public final ChunkExtractorWrapper extractorWrapper;
        private long periodDurationUs;
        public Representation representation;
        public Format sampleFormat;
        public DashSegmentIndex segmentIndex;
        private int segmentNumShift;

        public RepresentationHolder(long j, Representation representation) {
            Extractor fragmentedMp4Extractor;
            this.periodDurationUs = j;
            this.representation = representation;
            String str = representation.format.containerMimeType;
            if (mimeTypeIsRawText(str)) {
                this.extractorWrapper = null;
            } else {
                boolean z = false;
                if (MimeTypes.APPLICATION_RAWCC.equals(str)) {
                    fragmentedMp4Extractor = new RawCcExtractor();
                    z = true;
                } else if (mimeTypeIsWebm(str)) {
                    fragmentedMp4Extractor = new MatroskaExtractor();
                } else {
                    fragmentedMp4Extractor = new FragmentedMp4Extractor();
                }
                this.extractorWrapper = new ChunkExtractorWrapper(fragmentedMp4Extractor, representation.format, true, z);
            }
            this.segmentIndex = representation.getIndex();
        }

        public void setSampleFormat(Format format) {
            this.sampleFormat = format;
        }

        public void updateRepresentation(long j, Representation representation) throws BehindLiveWindowException {
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation.getIndex();
            this.periodDurationUs = j;
            this.representation = representation;
            if (index != null) {
                this.segmentIndex = index2;
                if (index.isExplicit()) {
                    int lastSegmentNum = index.getLastSegmentNum(this.periodDurationUs);
                    long durationUs = index.getDurationUs(lastSegmentNum, this.periodDurationUs) + index.getTimeUs(lastSegmentNum);
                    int firstSegmentNum = index2.getFirstSegmentNum();
                    long timeUs = index2.getTimeUs(firstSegmentNum);
                    if (durationUs == timeUs) {
                        this.segmentNumShift = ((index.getLastSegmentNum(this.periodDurationUs) + 1) - firstSegmentNum) + this.segmentNumShift;
                    } else if (durationUs < timeUs) {
                        throw new BehindLiveWindowException();
                    } else {
                        this.segmentNumShift = (index.getSegmentNum(timeUs, this.periodDurationUs) - firstSegmentNum) + this.segmentNumShift;
                    }
                }
            }
        }

        public int getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public int getLastSegmentNum() {
            int lastSegmentNum = this.segmentIndex.getLastSegmentNum(this.periodDurationUs);
            if (lastSegmentNum == -1) {
                return -1;
            }
            return this.segmentNumShift + lastSegmentNum;
        }

        public long getSegmentStartTimeUs(int i) {
            return this.segmentIndex.getTimeUs(i - this.segmentNumShift);
        }

        public long getSegmentEndTimeUs(int i) {
            return getSegmentStartTimeUs(i) + this.segmentIndex.getDurationUs(i - this.segmentNumShift, this.periodDurationUs);
        }

        public int getSegmentNum(long j) {
            return this.segmentIndex.getSegmentNum(j, this.periodDurationUs) + this.segmentNumShift;
        }

        public RangedUri getSegmentUrl(int i) {
            return this.segmentIndex.getSegmentUrl(i - this.segmentNumShift);
        }

        private static boolean mimeTypeIsWebm(String str) {
            return str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM) || str.startsWith(MimeTypes.APPLICATION_WEBM);
        }

        private static boolean mimeTypeIsRawText(String str) {
            return MimeTypes.isText(str) || MimeTypes.APPLICATION_TTML.equals(str);
        }
    }
}
