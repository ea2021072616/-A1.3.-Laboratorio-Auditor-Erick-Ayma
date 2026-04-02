package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class DataChunk extends Chunk {
    private static final int READ_GRANULARITY = 16384;
    private byte[] data;
    private int limit;
    private volatile boolean loadCanceled;

    protected abstract void consume(byte[] bArr, int i) throws IOException;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i, Format format, int i2, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i, format, i2, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.data = bArr;
    }

    public byte[] getDataHolder() {
        return this.data;
    }

    @Override // com.google.android.exoplayer2.source.chunk.Chunk
    public long bytesLoaded() {
        return this.limit;
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
        int i = 0;
        try {
            this.dataSource.open(this.dataSpec);
            this.limit = 0;
            while (i != -1 && !this.loadCanceled) {
                maybeExpandData();
                i = this.dataSource.read(this.data, this.limit, 16384);
                if (i != -1) {
                    this.limit += i;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, this.limit);
            }
        } finally {
            this.dataSource.close();
        }
    }

    private void maybeExpandData() {
        if (this.data == null) {
            this.data = new byte[16384];
        } else if (this.data.length < this.limit + 16384) {
            this.data = Arrays.copyOf(this.data, this.data.length + 16384);
        }
    }
}
