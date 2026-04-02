package okhttp3;

import c.f;
/* loaded from: classes2.dex */
public abstract class WebSocketListener {
    public void onOpen(WebSocket webSocket, Response response) {
    }

    public void onMessage(WebSocket webSocket, String str) {
    }

    public void onMessage(WebSocket webSocket, f fVar) {
    }

    public void onClosing(WebSocket webSocket, int i, String str) {
    }

    public void onClosed(WebSocket webSocket, int i, String str) {
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
    }
}
