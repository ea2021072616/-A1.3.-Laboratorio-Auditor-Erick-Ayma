package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* loaded from: classes.dex */
public final class InitializationChunk extends Chunk implements TrackOutput, ChunkExtractorWrapper.SingleTrackMetadataOutput {
    private volatile int bytesLoaded;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private Format sampleFormat;
    private SeekMap seekMap;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, 2, format, i, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.extractorWrapper = chunkExtractorWrapper;
    }

    @Override // com.google.android.exoplayer2.source.chunk.Chunk
    public long bytesLoaded() {
        return this.bytesLoaded;
    }

    public Format getSampleFormat() {
        return this.sampleFormat;
    }

    public SeekMap getSeekMap() {
        return this.seekMap;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.SingleTrackMetadataOutput
    public void seekMap(SeekMap seekMap) {
        this.seekMap = seekMap;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
        this.sampleFormat = format;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i) {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, byte[] bArr) {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
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
        DataSpec remainderDataSpec = Util.getRemainderDataSpec(this.dataSpec, this.bytesLoaded);
        try {
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, remainderDataSpec.absoluteStreamPosition, this.dataSource.open(remainderDataSpec));
            if (this.bytesLoaded == 0) {
                this.extractorWrapper.init(this, this);
            }
            int i = 0;
            while (i == 0 && !this.loadCanceled) {
                i = this.extractorWrapper.read(defaultExtractorInput);
            }
            this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
        } finally {
            this.dataSource.close();
        }
    }
}
