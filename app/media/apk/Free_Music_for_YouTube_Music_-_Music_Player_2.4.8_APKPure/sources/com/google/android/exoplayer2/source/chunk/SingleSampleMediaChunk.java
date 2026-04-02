package com.google.android.exoplayer2.source.chunk;

import android.support.v7.widget.ActivityChooserView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.DefaultTrackOutput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* loaded from: classes.dex */
public final class SingleSampleMediaChunk extends BaseMediaChunk {
    private volatile int bytesLoaded;
    private volatile boolean loadCanceled;
    private volatile boolean loadCompleted;
    private final Format sampleFormat;

    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, int i2, Format format2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, i2);
        this.sampleFormat = format2;
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
        try {
            long open = this.dataSource.open(Util.getRemainderDataSpec(this.dataSpec, this.bytesLoaded));
            if (open != -1) {
                open += this.bytesLoaded;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, this.bytesLoaded, open);
            DefaultTrackOutput trackOutput = getTrackOutput();
            trackOutput.formatWithOffset(this.sampleFormat, 0L);
            for (int i = 0; i != -1; i = trackOutput.sampleData(defaultExtractorInput, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true)) {
                this.bytesLoaded = i + this.bytesLoaded;
            }
            trackOutput.sampleMetadata(this.startTimeUs, 1, this.bytesLoaded, 0, null);
            this.dataSource.close();
            this.loadCompleted = true;
        } catch (Throwable th) {
            this.dataSource.close();
            throw th;
        }
    }
}
