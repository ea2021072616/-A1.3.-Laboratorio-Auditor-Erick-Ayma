package okhttp3;

import c.f;
/* loaded from: classes2.dex */
public interface WebSocket {

    /* loaded from: classes2.dex */
    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i, String str);

    long queueSize();

    Request request();

    boolean send(f fVar);

    boolean send(String str);
}
