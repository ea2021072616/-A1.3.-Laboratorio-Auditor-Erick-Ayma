package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
/* loaded from: classes.dex */
public final class ChunkExtractorWrapper implements ExtractorOutput, TrackOutput {
    private final Extractor extractor;
    private boolean extractorInitialized;
    private final Format manifestFormat;
    private SingleTrackMetadataOutput metadataOutput;
    private final boolean preferManifestDrmInitData;
    private final boolean resendFormatOnInit;
    private boolean seenTrack;
    private int seenTrackId;
    private Format sentFormat;
    private TrackOutput trackOutput;

    /* loaded from: classes.dex */
    public interface SingleTrackMetadataOutput {
        void seekMap(SeekMap seekMap);
    }

    public ChunkExtractorWrapper(Extractor extractor, Format format, boolean z, boolean z2) {
        this.extractor = extractor;
        this.manifestFormat = format;
        this.preferManifestDrmInitData = z;
        this.resendFormatOnInit = z2;
    }

    public void init(SingleTrackMetadataOutput singleTrackMetadataOutput, TrackOutput trackOutput) {
        this.metadataOutput = singleTrackMetadataOutput;
        this.trackOutput = trackOutput;
        if (!this.extractorInitialized) {
            this.extractor.init(this);
            this.extractorInitialized = true;
            return;
        }
        this.extractor.seek(0L);
        if (this.resendFormatOnInit && this.sentFormat != null) {
            trackOutput.format(this.sentFormat);
        }
    }

    public int read(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int read = this.extractor.read(extractorInput, null);
        Assertions.checkState(read != 1);
        return read;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i) {
        Assertions.checkState(!this.seenTrack || this.seenTrackId == i);
        this.seenTrack = true;
        this.seenTrackId = i;
        return this;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        Assertions.checkState(this.seenTrack);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.metadataOutput.seekMap(seekMap);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
        this.sentFormat = format.copyWithManifestFormatInfo(this.manifestFormat, this.preferManifestDrmInitData);
        this.trackOutput.format(this.sentFormat);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
        return this.trackOutput.sampleData(extractorInput, i, z);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i) {
        this.trackOutput.sampleData(parsableByteArray, i);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, byte[] bArr) {
        this.trackOutput.sampleMetadata(j, i, i2, i3, bArr);
    }
}
