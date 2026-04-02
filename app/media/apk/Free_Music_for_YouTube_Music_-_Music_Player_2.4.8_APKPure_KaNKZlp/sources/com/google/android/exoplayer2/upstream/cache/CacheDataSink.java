package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class CacheDataSink implements DataSink {
    private final Cache cache;
    private DataSpec dataSpec;
    private long dataSpecBytesWritten;
    private File file;
    private final long maxCacheFileSize;
    private FileOutputStream outputStream;
    private long outputStreamBytesWritten;

    /* loaded from: classes.dex */
    public static class CacheDataSinkException extends IOException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    public CacheDataSink(Cache cache, long j) {
        this.cache = (Cache) Assertions.checkNotNull(cache);
        this.maxCacheFileSize = j;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec) throws CacheDataSinkException {
        this.dataSpec = dataSpec;
        if (dataSpec.length != -1) {
            this.dataSpecBytesWritten = 0L;
            try {
                openNextOutputStream();
            } catch (FileNotFoundException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) throws CacheDataSinkException {
        if (this.dataSpec.length != -1) {
            int i3 = 0;
            while (i3 < i2) {
                try {
                    if (this.outputStreamBytesWritten == this.maxCacheFileSize) {
                        closeCurrentOutputStream();
                        openNextOutputStream();
                    }
                    int min = (int) Math.min(i2 - i3, this.maxCacheFileSize - this.outputStreamBytesWritten);
                    this.outputStream.write(bArr, i + i3, min);
                    i3 += min;
                    this.outputStreamBytesWritten += min;
                    this.dataSpecBytesWritten += min;
                } catch (IOException e) {
                    throw new CacheDataSinkException(e);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() throws CacheDataSinkException {
        if (this.dataSpec != null && this.dataSpec.length != -1) {
            try {
                closeCurrentOutputStream();
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }

    private void openNextOutputStream() throws FileNotFoundException {
        this.file = this.cache.startFile(this.dataSpec.key, this.dataSpec.absoluteStreamPosition + this.dataSpecBytesWritten, Math.min(this.dataSpec.length - this.dataSpecBytesWritten, this.maxCacheFileSize));
        this.outputStream = new FileOutputStream(this.file);
        this.outputStreamBytesWritten = 0L;
    }

    private void closeCurrentOutputStream() throws IOException {
        if (this.outputStream != null) {
            try {
                this.outputStream.flush();
                this.outputStream.getFD().sync();
                Util.closeQuietly(this.outputStream);
                this.cache.commitFile(this.file);
                this.outputStream = null;
                this.file = null;
            } catch (Throwable th) {
                Util.closeQuietly(this.outputStream);
                this.file.delete();
                this.outputStream = null;
                this.file = null;
                throw th;
            }
        }
    }
}
