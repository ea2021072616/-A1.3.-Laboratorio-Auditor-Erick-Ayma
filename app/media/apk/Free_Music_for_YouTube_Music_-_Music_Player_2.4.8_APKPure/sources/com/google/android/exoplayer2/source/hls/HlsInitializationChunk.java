package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class HlsInitializationChunk extends Chunk {
    private int bytesLoaded;
    public final Extractor extractor;
    public final Format format;
    private volatile boolean loadCanceled;

    public HlsInitializationChunk(DataSource dataSource, DataSpec dataSpec, int i, Object obj, Extractor extractor, Format format) {
        super(dataSource, dataSpec, 0, null, i, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.extractor = extractor;
        this.format = format;
    }

    public void init(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.extractor.init(hlsSampleStreamWrapper);
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
        DataSpec remainderDataSpec = Util.getRemainderDataSpec(this.dataSpec, this.bytesLoaded);
        try {
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, remainderDataSpec.absoluteStreamPosition, this.dataSource.open(remainderDataSpec));
            int i = 0;
            while (i == 0 && !this.loadCanceled) {
                i = this.extractor.read(defaultExtractorInput, null);
            }
            this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
        } finally {
            this.dataSource.close();
        }
    }
}
