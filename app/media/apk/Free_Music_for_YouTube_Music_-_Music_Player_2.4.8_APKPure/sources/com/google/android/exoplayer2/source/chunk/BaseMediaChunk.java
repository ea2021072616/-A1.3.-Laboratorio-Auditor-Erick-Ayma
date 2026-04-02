package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultTrackOutput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
/* loaded from: classes.dex */
public abstract class BaseMediaChunk extends MediaChunk {
    private int firstSampleIndex;
    private DefaultTrackOutput trackOutput;

    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, int i2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, i2);
    }

    public void init(DefaultTrackOutput defaultTrackOutput) {
        this.trackOutput = defaultTrackOutput;
        this.firstSampleIndex = defaultTrackOutput.getWriteIndex();
    }

    public final int getFirstSampleIndex() {
        return this.firstSampleIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DefaultTrackOutput getTrackOutput() {
        return this.trackOutput;
    }
}
