package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TimestampAdjuster;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class HlsMediaChunk extends MediaChunk {
    private static final AtomicInteger UID_SOURCE = new AtomicInteger();
    private long adjustedEndTimeUs;
    private int bytesLoaded;
    public final int discontinuitySequenceNumber;
    public final Extractor extractor;
    private final boolean extractorNeedsInit;
    private HlsSampleStreamWrapper extractorOutput;
    private final boolean isEncrypted;
    private final boolean isMasterTimestampSource;
    private volatile boolean loadCanceled;
    private volatile boolean loadCompleted;
    private final boolean shouldSpliceIn;
    private final TimestampAdjuster timestampAdjuster;
    public final int uid;

    public HlsMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, int i2, int i3, boolean z, TimestampAdjuster timestampAdjuster, Extractor extractor, boolean z2, boolean z3, byte[] bArr, byte[] bArr2) {
        super(buildDataSource(dataSource, bArr, bArr2), dataSpec, format, i, obj, j, j2, i2);
        this.discontinuitySequenceNumber = i3;
        this.isMasterTimestampSource = z;
        this.timestampAdjuster = timestampAdjuster;
        this.extractor = extractor;
        this.extractorNeedsInit = z2;
        this.shouldSpliceIn = z3;
        this.adjustedEndTimeUs = j;
        this.isEncrypted = this.dataSource instanceof Aes128DataSource;
        this.uid = UID_SOURCE.getAndIncrement();
    }

    public void init(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.extractorOutput = hlsSampleStreamWrapper;
        hlsSampleStreamWrapper.init(this.uid, this.shouldSpliceIn);
        if (this.extractorNeedsInit) {
            this.extractor.init(hlsSampleStreamWrapper);
        }
    }

    public long getAdjustedStartTimeUs() {
        return this.adjustedEndTimeUs - getDurationUs();
    }

    public long getAdjustedEndTimeUs() {
        return this.adjustedEndTimeUs;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.google.android.exoplayer2.source.chunk.Chunk
    public long bytesLoaded() {
        return this.bytesLoaded;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public boolean isLoadCanceled() {
        return this.loadCanceled;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException, InterruptedException {
        boolean z;
        DataSpec remainderDataSpec;
        int i = 0;
        if (this.isEncrypted) {
            DataSpec dataSpec = this.dataSpec;
            z = this.bytesLoaded != 0;
            remainderDataSpec = dataSpec;
        } else {
            z = false;
            remainderDataSpec = Util.getRemainderDataSpec(this.dataSpec, this.bytesLoaded);
        }
        try {
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, remainderDataSpec.absoluteStreamPosition, this.dataSource.open(remainderDataSpec));
            if (z) {
                defaultExtractorInput.skipFully(this.bytesLoaded);
            }
            if (!this.isMasterTimestampSource && this.timestampAdjuster != null) {
                this.timestampAdjuster.waitUntilInitialized();
            }
            while (i == 0 && !this.loadCanceled) {
                i = this.extractor.read(defaultExtractorInput, null);
            }
            long largestQueuedTimestampUs = this.extractorOutput.getLargestQueuedTimestampUs();
            if (largestQueuedTimestampUs != Long.MIN_VALUE) {
                this.adjustedEndTimeUs = largestQueuedTimestampUs;
            }
            this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
            this.dataSource.close();
            this.loadCompleted = true;
        } catch (Throwable th) {
            this.dataSource.close();
            throw th;
        }
    }

    private static DataSource buildDataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr2 == null) ? dataSource : new Aes128DataSource(dataSource, bArr, bArr2);
    }
}
