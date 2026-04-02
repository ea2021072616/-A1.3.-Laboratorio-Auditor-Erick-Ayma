package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import b.a.a.a.a.b.a;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class DefaultHttpDataSource implements HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final long MAX_BYTES_TO_DRAIN = 2048;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "DefaultHttpDataSource";
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private final Predicate<String> contentTypePredicate;
    private DataSpec dataSpec;
    private InputStream inputStream;
    private final TransferListener<? super DefaultHttpDataSource> listener;
    private boolean opened;
    private final int readTimeoutMillis;
    private final HashMap<String, String> requestProperties;
    private final String userAgent;
    private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> skipBufferReference = new AtomicReference<>();

    public DefaultHttpDataSource(String str, Predicate<String> predicate) {
        this(str, predicate, null);
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener<? super DefaultHttpDataSource> transferListener) {
        this(str, predicate, transferListener, 8000, 8000);
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener<? super DefaultHttpDataSource> transferListener, int i, int i2) {
        this(str, predicate, transferListener, i, i2, false);
    }

    public DefaultHttpDataSource(String str, Predicate<String> predicate, TransferListener<? super DefaultHttpDataSource> transferListener, int i, int i2, boolean z) {
        this.userAgent = Assertions.checkNotEmpty(str);
        this.contentTypePredicate = predicate;
        this.listener = transferListener;
        this.requestProperties = new HashMap<>();
        this.connectTimeoutMillis = i;
        this.readTimeoutMillis = i2;
        this.allowCrossProtocolRedirects = z;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        if (this.connection == null) {
            return null;
        }
        return Uri.parse(this.connection.getURL().toString());
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public Map<String, List<String>> getResponseHeaders() {
        if (this.connection == null) {
            return null;
        }
        return this.connection.getHeaderFields();
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.requestProperties) {
            this.requestProperties.put(str, str2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.requestProperties) {
            this.requestProperties.remove(str);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        synchronized (this.requestProperties) {
            this.requestProperties.clear();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        long j = 0;
        this.dataSpec = dataSpec;
        this.bytesRead = 0L;
        this.bytesSkipped = 0L;
        try {
            this.connection = makeConnection(dataSpec);
            try {
                int responseCode = this.connection.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = this.connection.getHeaderFields();
                    closeConnectionQuietly();
                    HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(responseCode, headerFields, dataSpec);
                    if (responseCode == 416) {
                        invalidResponseCodeException.initCause(new DataSourceException(0));
                    }
                    throw invalidResponseCodeException;
                }
                String contentType = this.connection.getContentType();
                if (this.contentTypePredicate != null && !this.contentTypePredicate.evaluate(contentType)) {
                    closeConnectionQuietly();
                    throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
                }
                if (responseCode == 200 && dataSpec.position != 0) {
                    j = dataSpec.position;
                }
                this.bytesToSkip = j;
                if ((dataSpec.flags & 1) == 0) {
                    if (dataSpec.length != -1) {
                        this.bytesToRead = dataSpec.length;
                    } else {
                        long contentLength = getContentLength(this.connection);
                        this.bytesToRead = contentLength != -1 ? contentLength - this.bytesToSkip : -1L;
                    }
                } else {
                    this.bytesToRead = dataSpec.length;
                }
                try {
                    this.inputStream = this.connection.getInputStream();
                    this.opened = true;
                    if (this.listener != null) {
                        this.listener.onTransferStart(this, dataSpec);
                    }
                    return this.bytesToRead;
                } catch (IOException e) {
                    closeConnectionQuietly();
                    throw new HttpDataSource.HttpDataSourceException(e, dataSpec, 1);
                }
            } catch (IOException e2) {
                closeConnectionQuietly();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.uri.toString(), e2, dataSpec, 1);
            }
        } catch (IOException e3) {
            throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.uri.toString(), e3, dataSpec, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            skipInternal();
            return readInternal(bArr, i, i2);
        } catch (IOException e) {
            throw new HttpDataSource.HttpDataSourceException(e, this.dataSpec, 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource, com.google.android.exoplayer2.upstream.DataSource
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            if (this.inputStream != null) {
                maybeTerminateInputStream(this.connection, bytesRemaining());
                try {
                    this.inputStream.close();
                } catch (IOException e) {
                    throw new HttpDataSource.HttpDataSourceException(e, this.dataSpec, 3);
                }
            }
        } finally {
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                if (this.listener != null) {
                    this.listener.onTransferEnd(this);
                }
            }
        }
    }

    protected final HttpURLConnection getConnection() {
        return this.connection;
    }

    protected final long bytesSkipped() {
        return this.bytesSkipped;
    }

    protected final long bytesRead() {
        return this.bytesRead;
    }

    protected final long bytesRemaining() {
        return this.bytesToRead == -1 ? this.bytesToRead : this.bytesToRead - this.bytesRead;
    }

    private HttpURLConnection makeConnection(DataSpec dataSpec) throws IOException {
        HttpURLConnection makeConnection;
        URL url = new URL(dataSpec.uri.toString());
        byte[] bArr = dataSpec.postBody;
        long j = dataSpec.position;
        long j2 = dataSpec.length;
        boolean z = (dataSpec.flags & 1) != 0;
        if (this.allowCrossProtocolRedirects) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i <= 20) {
                    makeConnection = makeConnection(url, bArr, j, j2, z, false);
                    int responseCode = makeConnection.getResponseCode();
                    if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                        bArr = null;
                        String headerField = makeConnection.getHeaderField("Location");
                        makeConnection.disconnect();
                        url = handleRedirect(url, headerField);
                        i = i2;
                    }
                } else {
                    throw new NoRouteToHostException("Too many redirects: " + i2);
                }
            }
            return makeConnection;
        }
        return makeConnection(url, bArr, j, j2, z, true);
    }

    private HttpURLConnection makeConnection(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeoutMillis);
        httpURLConnection.setReadTimeout(this.readTimeoutMillis);
        synchronized (this.requestProperties) {
            for (Map.Entry<String, String> entry : this.requestProperties.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty(a.HEADER_USER_AGENT, this.userAgent);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL handleRedirect(URL url, String str) throws IOException {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if (!"https".equals(protocol) && !"http".equals(protocol)) {
            throw new ProtocolException("Unsupported protocol redirect: " + protocol);
        }
        return url2;
    }

    private static long getContentLength(HttpURLConnection httpURLConnection) {
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                Log.e(TAG, "Unexpected Content-Length [" + headerField + "]");
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField2)) {
            Matcher matcher = CONTENT_RANGE_HEADER.matcher(headerField2);
            if (matcher.find()) {
                try {
                    long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                    if (j < 0) {
                        return parseLong;
                    }
                    if (j != parseLong) {
                        Log.w(TAG, "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
                        return Math.max(j, parseLong);
                    }
                    return j;
                } catch (NumberFormatException e2) {
                    Log.e(TAG, "Unexpected Content-Range [" + headerField2 + "]");
                    return j;
                }
            }
            return j;
        }
        return j;
    }

    private void skipInternal() throws IOException {
        if (this.bytesSkipped != this.bytesToSkip) {
            byte[] andSet = skipBufferReference.getAndSet(null);
            if (andSet == null) {
                andSet = new byte[4096];
            }
            while (this.bytesSkipped != this.bytesToSkip) {
                int read = this.inputStream.read(andSet, 0, (int) Math.min(this.bytesToSkip - this.bytesSkipped, andSet.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                }
                if (read == -1) {
                    throw new EOFException();
                }
                this.bytesSkipped += read;
                if (this.listener != null) {
                    this.listener.onBytesTransferred(this, read);
                }
            }
            skipBufferReference.set(andSet);
        }
    }

    private int readInternal(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesToRead != -1) {
            long j = this.bytesToRead - this.bytesRead;
            if (j == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j);
        }
        int read = this.inputStream.read(bArr, i, i2);
        if (read == -1) {
            if (this.bytesToRead != -1) {
                throw new EOFException();
            }
            return -1;
        }
        this.bytesRead += read;
        if (this.listener != null) {
            this.listener.onBytesTransferred(this, read);
        }
        return read;
    }

    private static void maybeTerminateInputStream(HttpURLConnection httpURLConnection, long j) {
        if (Util.SDK_INT == 19 || Util.SDK_INT == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception e) {
            }
        }
    }

    private void closeConnectionQuietly() {
        if (this.connection != null) {
            try {
                this.connection.disconnect();
            } catch (Exception e) {
                Log.e(TAG, "Unexpected error while disconnecting", e);
            }
            this.connection = null;
        }
    }
}
