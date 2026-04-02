package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.TeeDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class CacheDataSource implements DataSource {
    public static final long DEFAULT_MAX_CACHE_FILE_SIZE = 2097152;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_CACHE_UNBOUNDED_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    private static final String TAG = "CacheDataSource";
    private final boolean blockOnCache;
    private final boolean bypassUnboundedRequests;
    private long bytesRemaining;
    private final Cache cache;
    private final DataSource cacheReadDataSource;
    private final DataSource cacheWriteDataSource;
    private DataSource currentDataSource;
    private boolean currentRequestIgnoresCache;
    private boolean currentRequestUnbounded;
    private final EventListener eventListener;
    private int flags;
    private final boolean ignoreCacheOnError;
    private String key;
    private CacheSpan lockedSpan;
    private long readPosition;
    private boolean seenCacheError;
    private long totalCachedBytesRead;
    private final DataSource upstreamDataSource;
    private Uri uri;

    /* loaded from: classes.dex */
    public interface EventListener {
        void onCachedBytesRead(long j, long j2);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public CacheDataSource(Cache cache, DataSource dataSource, int i) {
        this(cache, dataSource, i, 2097152L);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, int i, long j) {
        this(cache, dataSource, new FileDataSource(), new CacheDataSink(cache, j), i, null);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int i, EventListener eventListener) {
        this.cache = cache;
        this.cacheReadDataSource = dataSource2;
        this.blockOnCache = (i & 1) != 0;
        this.ignoreCacheOnError = (i & 2) != 0;
        this.bypassUnboundedRequests = (i & 4) == 0;
        this.upstreamDataSource = dataSource;
        if (dataSink != null) {
            this.cacheWriteDataSource = new TeeDataSource(dataSource, dataSink);
        } else {
            this.cacheWriteDataSource = null;
        }
        this.eventListener = eventListener;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        boolean z = true;
        try {
            this.uri = dataSpec.uri;
            this.flags = dataSpec.flags;
            this.key = dataSpec.key;
            this.readPosition = dataSpec.position;
            if ((!this.ignoreCacheOnError || !this.seenCacheError) && (!this.bypassUnboundedRequests || dataSpec.length != -1)) {
                z = false;
            }
            this.currentRequestIgnoresCache = z;
            if (dataSpec.length != -1 || this.currentRequestIgnoresCache) {
                this.bytesRemaining = dataSpec.length;
            } else {
                this.bytesRemaining = this.cache.getContentLength(this.key);
                if (this.bytesRemaining != -1) {
                    this.bytesRemaining -= dataSpec.position;
                }
            }
            openNextSource(true);
            return this.bytesRemaining;
        } catch (IOException e) {
            handleBeforeThrow(e);
            throw e;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            int read = this.currentDataSource.read(bArr, i, i2);
            if (read >= 0) {
                if (this.currentDataSource == this.cacheReadDataSource) {
                    this.totalCachedBytesRead += read;
                }
                this.readPosition += read;
                if (this.bytesRemaining != -1) {
                    this.bytesRemaining -= read;
                    return read;
                }
                return read;
            }
            if (this.currentRequestUnbounded) {
                setContentLength(this.readPosition);
                this.bytesRemaining = 0L;
            }
            closeCurrentSource();
            if ((this.bytesRemaining > 0 || this.bytesRemaining == -1) && openNextSource(false)) {
                return read(bArr, i, i2);
            }
            return read;
        } catch (IOException e) {
            handleBeforeThrow(e);
            throw e;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.currentDataSource == this.upstreamDataSource ? this.currentDataSource.getUri() : this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.uri = null;
        notifyBytesRead();
        try {
            closeCurrentSource();
        } catch (IOException e) {
            handleBeforeThrow(e);
            throw e;
        }
    }

    private boolean openNextSource(boolean z) throws IOException {
        CacheSpan startReadWrite;
        long j;
        DataSpec dataSpec;
        long j2;
        if (this.currentRequestIgnoresCache) {
            startReadWrite = null;
        } else if (this.blockOnCache) {
            try {
                startReadWrite = this.cache.startReadWrite(this.key, this.readPosition);
            } catch (InterruptedException e) {
                throw new InterruptedIOException();
            }
        } else {
            startReadWrite = this.cache.startReadWriteNonBlocking(this.key, this.readPosition);
        }
        if (startReadWrite == null) {
            this.currentDataSource = this.upstreamDataSource;
            dataSpec = new DataSpec(this.uri, this.readPosition, this.bytesRemaining, this.key, this.flags);
        } else if (startReadWrite.isCached) {
            Uri fromFile = Uri.fromFile(startReadWrite.file);
            long j3 = this.readPosition - startReadWrite.position;
            long j4 = startReadWrite.length - j3;
            if (this.bytesRemaining != -1) {
                j4 = Math.min(j4, this.bytesRemaining);
            }
            DataSpec dataSpec2 = new DataSpec(fromFile, this.readPosition, j3, j4, this.key, this.flags);
            this.currentDataSource = this.cacheReadDataSource;
            dataSpec = dataSpec2;
        } else {
            this.lockedSpan = startReadWrite;
            if (startReadWrite.isOpenEnded()) {
                j = this.bytesRemaining;
            } else {
                j = startReadWrite.length;
                if (this.bytesRemaining != -1) {
                    j = Math.min(j, this.bytesRemaining);
                }
            }
            DataSpec dataSpec3 = new DataSpec(this.uri, this.readPosition, j, this.key, this.flags);
            this.currentDataSource = this.cacheWriteDataSource != null ? this.cacheWriteDataSource : this.upstreamDataSource;
            dataSpec = dataSpec3;
        }
        this.currentRequestUnbounded = dataSpec.length == -1;
        boolean z2 = false;
        try {
            j2 = this.currentDataSource.open(dataSpec);
            z2 = true;
        } catch (IOException e2) {
            IOException iOException = e2;
            if (!z && this.currentRequestUnbounded) {
                Throwable th = iOException;
                while (true) {
                    if (th != null) {
                        if ((th instanceof DataSourceException) && ((DataSourceException) th).reason == 0) {
                            iOException = null;
                            break;
                        }
                        th = th.getCause();
                    } else {
                        break;
                    }
                }
            }
            if (iOException == null) {
                j2 = 0;
            } else {
                throw iOException;
            }
        }
        if (this.currentRequestUnbounded && j2 != -1) {
            this.bytesRemaining = j2;
            if (this.lockedSpan != null) {
                setContentLength(dataSpec.position + this.bytesRemaining);
            }
        }
        return z2;
    }

    private void setContentLength(long j) {
        if (!this.cache.setContentLength(this.key, j)) {
            Log.e(TAG, "cache.setContentLength(" + j + ") failed. cache.getContentLength() = " + this.cache.getContentLength(this.key));
        }
    }

    /* JADX WARN: Finally extract failed */
    private void closeCurrentSource() throws IOException {
        if (this.currentDataSource != null) {
            try {
                this.currentDataSource.close();
                this.currentDataSource = null;
                this.currentRequestUnbounded = false;
                if (this.lockedSpan != null) {
                    this.cache.releaseHoleSpan(this.lockedSpan);
                    this.lockedSpan = null;
                }
            } catch (Throwable th) {
                if (this.lockedSpan != null) {
                    this.cache.releaseHoleSpan(this.lockedSpan);
                    this.lockedSpan = null;
                }
                throw th;
            }
        }
    }

    private void handleBeforeThrow(IOException iOException) {
        if (this.currentDataSource == this.cacheReadDataSource || (iOException instanceof CacheDataSink.CacheDataSinkException)) {
            this.seenCacheError = true;
        }
    }

    private void notifyBytesRead() {
        if (this.eventListener != null && this.totalCachedBytesRead > 0) {
            this.eventListener.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
            this.totalCachedBytesRead = 0L;
        }
    }
}
