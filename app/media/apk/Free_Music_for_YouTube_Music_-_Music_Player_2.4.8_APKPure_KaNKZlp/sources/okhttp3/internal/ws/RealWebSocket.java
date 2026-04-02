package okhttp3.internal.ws;

import c.d;
import c.e;
import c.f;
import c.l;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.ws.WebSocketReader;
/* loaded from: classes2.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    final WebSocketListener listener;
    private final Request originalRequest;
    int pingCount;
    int pongCount;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private String receivedCloseReason;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;
    private final ArrayDeque<f> pongQueue = new ArrayDeque<>();
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private int receivedCloseCode = -1;

    static {
        $assertionsDisabled = !RealWebSocket.class.desiredAssertionStatus();
        ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random) {
        if (!"GET".equals(request.method())) {
            throw new IllegalArgumentException("Request must be GET: " + request.method());
        }
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = f.a(bArr).b();
        this.writerRunnable = new Runnable() { // from class: okhttp3.internal.ws.RealWebSocket.1
            @Override // java.lang.Runnable
            public void run() {
                do {
                    try {
                    } catch (IOException e) {
                        RealWebSocket.this.failWebSocket(e, null);
                        return;
                    }
                } while (RealWebSocket.this.writeOneFrame());
            }
        };
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.call.cancel();
    }

    public void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().protocols(ONLY_HTTP1).build();
        final int pingIntervalMillis = build.pingIntervalMillis();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        this.call = Internal.instance.newWebSocketCall(build, build2);
        this.call.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket.2
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.checkResponse(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket.this.listener.onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), pingIntervalMillis, newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (ProtocolException e2) {
                    RealWebSocket.this.failWebSocket(e2, response);
                    Util.closeQuietly(response);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, null);
            }
        });
    }

    void checkResponse(Response response) throws ProtocolException {
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
        }
        String header = response.header("Connection");
        if (!"Upgrade".equalsIgnoreCase(header)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        String header2 = response.header("Upgrade");
        if (!"websocket".equalsIgnoreCase(header2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
        }
        String header3 = response.header("Sec-WebSocket-Accept");
        String b2 = f.a(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").d().b();
        if (!b2.equals(header3)) {
            throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + b2 + "' but was '" + header3 + "'");
        }
    }

    public void initReaderAndWriter(String str, long j, Streams streams) throws IOException {
        synchronized (this) {
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.client, streams.sink, this.random);
            this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            if (j != 0) {
                this.executor.scheduleAtFixedRate(new PingRunnable(), j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    boolean processNextFrame() throws IOException {
        try {
            this.reader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    void awaitTermination(int i, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination(i, timeUnit);
    }

    void tearDown() throws InterruptedException {
        if (this.cancelFuture != null) {
            this.cancelFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10L, TimeUnit.SECONDS);
    }

    synchronized int pingCount() {
        return this.pingCount;
    }

    synchronized int pongCount() {
        return this.pongCount;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        this.listener.onMessage(this, str);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(f fVar) throws IOException {
        this.listener.onMessage(this, fVar);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(f fVar) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(fVar);
            runWriter();
            this.pingCount++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(f fVar) {
        this.pongCount++;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        Streams streams;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new IllegalStateException("already closed");
            }
            this.receivedCloseCode = i;
            this.receivedCloseReason = str;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                Streams streams2 = this.streams;
                this.streams = null;
                if (this.cancelFuture != null) {
                    this.cancelFuture.cancel(false);
                }
                this.executor.shutdown();
                streams = streams2;
            } else {
                streams = null;
            }
        }
        try {
            this.listener.onClosing(this, i, str);
            if (streams != null) {
                this.listener.onClosed(this, i, str);
            }
        } finally {
            Util.closeQuietly(streams);
        }
    }

    @Override // okhttp3.WebSocket
    public boolean send(String str) {
        if (str == null) {
            throw new NullPointerException("text == null");
        }
        return send(f.a(str), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("bytes == null");
        }
        return send(fVar, 2);
    }

    private synchronized boolean send(f fVar, int i) {
        boolean z = false;
        synchronized (this) {
            if (!this.failed && !this.enqueuedClose) {
                if (this.queueSize + fVar.h() > MAX_QUEUE_SIZE) {
                    close(1001, null);
                } else {
                    this.queueSize += fVar.h();
                    this.messageAndCloseQueue.add(new Message(i, fVar));
                    runWriter();
                    z = true;
                }
            }
        }
        return z;
    }

    synchronized boolean pong(f fVar) {
        boolean z;
        if (this.failed || (this.enqueuedClose && this.messageAndCloseQueue.isEmpty())) {
            z = false;
        } else {
            this.pongQueue.add(fVar);
            runWriter();
            z = true;
        }
        return z;
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, String str) {
        return close(i, str, 60000L);
    }

    synchronized boolean close(int i, String str, long j) {
        boolean z = true;
        synchronized (this) {
            WebSocketProtocol.validateCloseCode(i);
            f fVar = null;
            if (str != null) {
                fVar = f.a(str);
                if (fVar.h() > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: " + str);
                }
            }
            if (this.failed || this.enqueuedClose) {
                z = false;
            } else {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i, fVar, j));
                runWriter();
            }
        }
        return z;
    }

    private void runWriter() {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.executor != null) {
            this.executor.execute(this.writerRunnable);
        }
    }

    boolean writeOneFrame() throws IOException {
        Streams streams;
        int i;
        Message message;
        String str = null;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            WebSocketWriter webSocketWriter = this.writer;
            f poll = this.pongQueue.poll();
            if (poll == null) {
                Object poll2 = this.messageAndCloseQueue.poll();
                if (poll2 instanceof Close) {
                    int i2 = this.receivedCloseCode;
                    String str2 = this.receivedCloseReason;
                    if (i2 != -1) {
                        Streams streams2 = this.streams;
                        this.streams = null;
                        this.executor.shutdown();
                        str = str2;
                        i = i2;
                        message = poll2;
                        streams = streams2;
                    } else {
                        this.cancelFuture = this.executor.schedule(new CancelRunnable(), ((Close) poll2).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
                        message = poll2;
                        streams = null;
                        str = str2;
                        i = i2;
                    }
                } else if (poll2 == null) {
                    return false;
                } else {
                    i = -1;
                    message = poll2;
                    streams = null;
                }
            } else {
                streams = null;
                i = -1;
                message = null;
            }
            try {
                if (poll != null) {
                    webSocketWriter.writePong(poll);
                } else if (message instanceof Message) {
                    f fVar = message.data;
                    d a2 = l.a(webSocketWriter.newMessageSink(message.formatOpcode, fVar.h()));
                    a2.b(fVar);
                    a2.close();
                    synchronized (this) {
                        this.queueSize -= fVar.h();
                    }
                } else if (message instanceof Close) {
                    Close close = (Close) message;
                    webSocketWriter.writeClose(close.code, close.reason);
                    if (streams != null) {
                        this.listener.onClosed(this, i, str);
                    }
                } else {
                    throw new AssertionError();
                }
                return true;
            } finally {
                Util.closeQuietly(streams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.writePingFrame();
        }
    }

    void writePingFrame() {
        synchronized (this) {
            if (!this.failed) {
                WebSocketWriter webSocketWriter = this.writer;
                try {
                    webSocketWriter.writePing(f.f289b);
                } catch (IOException e) {
                    failWebSocket(e, null);
                }
            }
        }
    }

    public void failWebSocket(Exception exc, Response response) {
        synchronized (this) {
            if (!this.failed) {
                this.failed = true;
                Streams streams = this.streams;
                this.streams = null;
                if (this.cancelFuture != null) {
                    this.cancelFuture.cancel(false);
                }
                if (this.executor != null) {
                    this.executor.shutdown();
                }
                try {
                    this.listener.onFailure(this, exc, response);
                } finally {
                    Util.closeQuietly(streams);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Message {
        final f data;
        final int formatOpcode;

        Message(int i, f fVar) {
            this.formatOpcode = i;
            this.data = fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final f reason;

        Close(int i, f fVar, long j) {
            this.code = i;
            this.reason = fVar;
            this.cancelAfterCloseMillis = j;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final d sink;
        public final e source;

        public Streams(boolean z, e eVar, d dVar) {
            this.client = z;
            this.source = eVar;
            this.sink = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }
}
