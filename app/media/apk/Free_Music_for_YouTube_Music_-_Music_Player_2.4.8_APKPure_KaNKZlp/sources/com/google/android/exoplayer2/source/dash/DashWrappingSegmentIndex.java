package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
/* loaded from: classes.dex */
final class DashWrappingSegmentIndex implements DashSegmentIndex {
    private final ChunkIndex chunkIndex;
    private final String uri;

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex, String str) {
        this.chunkIndex = chunkIndex;
        this.uri = str;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public int getFirstSegmentNum() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public int getLastSegmentNum(long j) {
        return this.chunkIndex.length - 1;
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getTimeUs(int i) {
        return this.chunkIndex.timesUs[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public long getDurationUs(int i, long j) {
        return this.chunkIndex.durationsUs[i];
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public RangedUri getSegmentUrl(int i) {
        return new RangedUri(this.uri, null, this.chunkIndex.offsets[i], this.chunkIndex.sizes[i]);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public int getSegmentNum(long j, long j2) {
        return this.chunkIndex.getChunkIndex(j);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
    public boolean isExplicit() {
        return true;
    }
}
