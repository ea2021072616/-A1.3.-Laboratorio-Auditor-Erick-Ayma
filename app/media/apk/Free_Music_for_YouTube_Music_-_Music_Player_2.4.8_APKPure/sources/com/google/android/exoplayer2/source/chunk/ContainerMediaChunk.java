package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.DefaultTrackOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* loaded from: classes.dex */
public class ContainerMediaChunk extends BaseMediaChunk implements ChunkExtractorWrapper.SingleTrackMetadataOutput {
    private volatile int bytesLoaded;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private volatile boolean loadCompleted;
    private final Format sampleFormat;
    private final long sampleOffsetUs;

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, int i2, long j3, ChunkExtractorWrapper chunkExtractorWrapper, Format format2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, i2);
        this.extractorWrapper = chunkExtractorWrapper;
        this.sampleOffsetUs = j3;
        this.sampleFormat = format2;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.google.android.exoplayer2.source.chunk.Chunk
    public final long bytesLoaded() {
        return this.bytesLoaded;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.SingleTrackMetadataOutput
    public final void seekMap(SeekMap seekMap) {
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final boolean isLoadCanceled() {
        return this.loadCanceled;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws IOException, InterruptedException {
        DataSpec remainderDataSpec = Util.getRemainderDataSpec(this.dataSpec, this.bytesLoaded);
        try {
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, remainderDataSpec.absoluteStreamPosition, this.dataSource.open(remainderDataSpec));
            if (this.bytesLoaded == 0) {
                DefaultTrackOutput trackOutput = getTrackOutput();
                trackOutput.formatWithOffset(this.sampleFormat, this.sampleOffsetUs);
                this.extractorWrapper.init(this, trackOutput);
            }
            int i = 0;
            while (i == 0 && !this.loadCanceled) {
                i = this.extractorWrapper.read(defaultExtractorInput);
            }
            this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
            this.dataSource.close();
            this.loadCompleted = true;
        } catch (Throwable th) {
            this.dataSource.close();
            throw th;
        }
    }
}
