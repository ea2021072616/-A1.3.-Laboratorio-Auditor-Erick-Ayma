package org.phprpc;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import javax.net.SocketFactory;
/* compiled from: PHPRPC_Client.java */
/* loaded from: classes2.dex */
final class SocketPool {
    private String host;
    private int port;
    private SocketFactory socketFactory;
    private LinkedList sockets = new LinkedList();
    private int timeout;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocketPool(SocketFactory socketFactory, String str, int i, int i2) {
        this.socketFactory = socketFactory;
        this.host = str;
        this.port = i;
        this.timeout = i2;
    }

    private final Socket newSocket() throws IOException {
        Socket createSocket = this.socketFactory.createSocket(this.host, this.port);
        createSocket.setSoTimeout(this.timeout);
        createSocket.setTcpNoDelay(true);
        createSocket.setKeepAlive(true);
        return createSocket;
    }

    public final synchronized Socket getConnect() throws IOException {
        Socket socket;
        socket = this.sockets.isEmpty() ? null : (Socket) this.sockets.removeFirst();
        if (socket == null || socket.isClosed() || socket.isInputShutdown() || socket.isOutputShutdown() || !socket.isConnected()) {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
            socket = newSocket();
        }
        return socket;
    }

    public final synchronized void freeConnect(Socket socket, boolean z) {
        if (z) {
            this.sockets.addLast(socket);
        } else if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

    public final synchronized void clearConnect() {
        while (!this.sockets.isEmpty()) {
            Socket socket = (Socket) this.sockets.removeLast();
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
        this.sockets.clear();
    }

    public final void finalize() throws Throwable {
        super.finalize();
        clearConnect();
    }
}
