package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes.dex */
public final class DefaultHttpDataSourceFactory implements HttpDataSource.Factory {
    private final boolean allowCrossProtocolRedirects;
    private final int connectTimeoutMillis;
    private final TransferListener<? super DataSource> listener;
    private final int readTimeoutMillis;
    private final String userAgent;

    public DefaultHttpDataSourceFactory(String str) {
        this(str, null);
    }

    public DefaultHttpDataSourceFactory(String str, TransferListener<? super DataSource> transferListener) {
        this(str, transferListener, 8000, 8000, false);
    }

    public DefaultHttpDataSourceFactory(String str, TransferListener<? super DataSource> transferListener, int i, int i2, boolean z) {
        this.userAgent = str;
        this.listener = transferListener;
        this.connectTimeoutMillis = i;
        this.readTimeoutMillis = i2;
        this.allowCrossProtocolRedirects = z;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory, com.google.android.exoplayer2.upstream.DataSource.Factory
    public DefaultHttpDataSource createDataSource() {
        return new DefaultHttpDataSource(this.userAgent, null, this.listener, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects);
    }
}
