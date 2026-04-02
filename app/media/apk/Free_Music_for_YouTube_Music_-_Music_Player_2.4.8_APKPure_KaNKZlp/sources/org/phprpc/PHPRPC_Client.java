package org.phprpc;

import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.phprpc.util.Base64;
import org.phprpc.util.Cast;
import org.phprpc.util.PHPSerializer;
import org.phprpc.util.XXTEA;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes2.dex */
public class PHPRPC_Client {
    private String __charset;
    private String __clientID;
    private int __encryptMode;
    private boolean __keepAlive;
    private byte[] __key;
    private boolean __keyExchanged;
    private int __keylen;
    private String __output;
    protected PHPSerializer __phpser;
    private HashMap __proxy;
    private HashMap __server;
    private SocketPool __socketPool;
    private int __timeout;
    private PHPRPC_Error __warning;
    private static int __sID = 0;
    private static String __cookie = null;
    private static final HashMap __cookies = new HashMap();

    public PHPRPC_Client() {
        this.__phpser = null;
        this.__server = null;
        this.__proxy = null;
        this.__timeout = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;
        this.__warning = null;
        this.__key = null;
        this.__keylen = 128;
        this.__encryptMode = 0;
        this.__keyExchanged = false;
        this.__charset = AudienceNetworkActivity.WEBVIEW_ENCODING;
        this.__output = "";
        this.__socketPool = null;
        this.__keepAlive = true;
        this.__clientID = "";
        StringBuilder append = new StringBuilder().append("java").append(String.valueOf(new Random().nextInt())).append(String.valueOf(new Date().getTime()));
        int i = __sID;
        __sID = i + 1;
        this.__clientID = append.append(String.valueOf(i)).toString();
    }

    public PHPRPC_Client(String str) {
        this();
        useService(str);
    }

    public final Object useService(Class cls) {
        PHPRPC_InvocationHandler pHPRPC_InvocationHandler = new PHPRPC_InvocationHandler(this);
        return cls.isInterface() ? Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, pHPRPC_InvocationHandler) : Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), pHPRPC_InvocationHandler);
    }

    public final Object useService(Class[] clsArr) {
        return Proxy.newProxyInstance(clsArr[0].getClassLoader(), clsArr, new PHPRPC_InvocationHandler(this));
    }

    public final boolean useService(String str) {
        return useService(str, null, null);
    }

    public final Object useService(String str, Class cls) {
        if (useService(str, null, null)) {
            return useService(cls);
        }
        return null;
    }

    public final Object useService(String str, Class[] clsArr) {
        if (useService(str, null, null)) {
            return useService(clsArr);
        }
        return null;
    }

    public final boolean useService(String str, String str2, String str3) {
        String str4;
        try {
            URL url = new URL(str);
            if (url.getProtocol().equals("http") || url.getProtocol().equals("https")) {
                this.__server = new HashMap();
                this.__server.put("scheme", url.getProtocol());
                this.__server.put("host", url.getHost());
                this.__server.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT, new Integer(url.getPort() == -1 ? url.getDefaultPort() : url.getPort()));
                String file = url.getFile();
                if (file.indexOf(63) > -1) {
                    str4 = file + "&phprpc_id=" + this.__clientID;
                } else {
                    str4 = file + "?phprpc_id=" + this.__clientID;
                }
                this.__server.put("path", str4);
                this.__server.put("userinfo", str2 == null ? url.getUserInfo() : str2 + ':' + str3);
                this.__socketPool = null;
                this.__keepAlive = true;
                this.__key = null;
                this.__keylen = 128;
                this.__encryptMode = 0;
                this.__keyExchanged = false;
                this.__phpser = new PHPSerializer();
                setCharset(AudienceNetworkActivity.WEBVIEW_ENCODING);
                return true;
            }
            return false;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public final Object useService(String str, String str2, String str3, Class cls) {
        if (useService(str, str2, str3)) {
            return useService(cls);
        }
        return null;
    }

    public final Object useService(String str, String str2, String str3, Class[] clsArr) {
        if (useService(str, str2, str3)) {
            return useService(clsArr);
        }
        return null;
    }

    public final void setProxy(String str) throws MalformedURLException {
        if (str == null) {
            this.__proxy = null;
            return;
        }
        URL url = new URL(str);
        setProxy(url.getHost(), url.getPort() == -1 ? url.getDefaultPort() : url.getPort(), url.getUserInfo());
    }

    public final void setProxy(String str, int i) {
        setProxy(str, i, null);
    }

    public final void setProxy(String str, int i, String str2, String str3) {
        setProxy(str, i, str2 == null ? null : str2 + ':' + str3);
    }

    private final void setProxy(String str, int i, String str2) {
        this.__proxy = new HashMap();
        this.__proxy.put("host", str);
        this.__proxy.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT, new Integer(i));
        this.__proxy.put("userinfo", str2);
    }

    public final boolean setKeyLength(int i) {
        if (this.__key != null) {
            return false;
        }
        this.__keylen = i;
        return true;
    }

    public final int getKeyLength() {
        return this.__keylen;
    }

    public final boolean setEncryptMode(int i) {
        if (i >= 0 && i <= 3) {
            this.__encryptMode = i;
            return true;
        }
        this.__encryptMode = 0;
        return false;
    }

    public final int getEncryptMode() {
        return this.__encryptMode;
    }

    public final synchronized void setCharset(String str) {
        this.__charset = str;
        this.__phpser.setCharset(this.__charset);
    }

    public final String getCharset() {
        return this.__charset;
    }

    public final void setTimeout(int i) {
        this.__timeout = i;
    }

    public final int getTimeout() {
        return this.__timeout;
    }

    public final String getOutput() {
        return this.__output;
    }

    public final PHPRPC_Error getWarning() {
        return this.__warning;
    }

    public final Object invoke(String str, Object[] objArr) {
        return invoke(str, objArr, false);
    }

    public final Object invoke(String str, Object[] objArr, boolean z) {
        HashMap invoke = invoke(str, objArr, z, this.__encryptMode);
        this.__output = (String) invoke.get("output");
        this.__warning = (PHPRPC_Error) invoke.get("warning");
        return invoke.get("result");
    }

    public final void invoke(String str, Object[] objArr, PHPRPC_Callback pHPRPC_Callback) {
        invoke(str, objArr, pHPRPC_Callback, false);
    }

    public final void invoke(String str, Object[] objArr, PHPRPC_Callback pHPRPC_Callback, boolean z) {
        invoke(str, objArr, pHPRPC_Callback, z, this.__encryptMode);
    }

    public final void invoke(final String str, final Object[] objArr, final PHPRPC_Callback pHPRPC_Callback, final boolean z, final int i) {
        new Thread(new Runnable() { // from class: org.phprpc.PHPRPC_Client.1
            @Override // java.lang.Runnable
            public void run() {
                Method[] declaredMethods;
                HashMap invoke = this.invoke(str, objArr, z, i);
                if (invoke.get("result") instanceof PHPRPC_Error) {
                    pHPRPC_Callback.errorHandler((PHPRPC_Error) invoke.get("result"));
                    return;
                }
                try {
                    for (Method method : pHPRPC_Callback.getClass().getDeclaredMethods()) {
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        int length = parameterTypes.length;
                        if (length > 0) {
                            Object cast = Cast.cast(invoke.get("result"), parameterTypes[0]);
                            switch (length) {
                                case 1:
                                    if (!method.getName().equals("errorHandler") || parameterTypes[0] != Throwable.class) {
                                        method.invoke(pHPRPC_Callback, cast);
                                        break;
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 2:
                                    method.invoke(pHPRPC_Callback, cast, objArr);
                                    continue;
                                case 3:
                                    method.invoke(pHPRPC_Callback, cast, objArr, invoke.get("output"));
                                    continue;
                                case 4:
                                    method.invoke(pHPRPC_Callback, cast, objArr, invoke.get("output"), invoke.get("warning"));
                                    continue;
                            }
                        }
                    }
                } catch (Exception e) {
                    pHPRPC_Callback.errorHandler(e);
                }
            }
        }).start();
    }

    public final HashMap invoke(String str, Object[] objArr, boolean z, int i) {
        HashMap hashMap = new HashMap();
        try {
            int __keyExchange = __keyExchange(i);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("phprpc_func=").append(str);
            if (objArr != null && objArr.length > 0) {
                stringBuffer.append("&phprpc_args=");
                stringBuffer.append(Base64.encode(__encrypt(this.__phpser.serialize(objArr), 1, __keyExchange)).replaceAll("\\+", "%2B"));
            }
            stringBuffer.append("&phprpc_encrypt=").append(__keyExchange);
            if (!z) {
                stringBuffer.append("&phprpc_ref=false");
            }
            HashMap __post = __post(stringBuffer.toString());
            int parseInt = Integer.parseInt((String) __post.get("phprpc_errno"));
            if (parseInt > 0) {
                hashMap.put("warning", new PHPRPC_Error(parseInt, new String(Base64.decode((String) __post.get("phprpc_errstr")), this.__charset)));
            } else {
                hashMap.put("warning", null);
            }
            if (__post.containsKey("phprpc_output")) {
                byte[] decode = Base64.decode((String) __post.get("phprpc_output"));
                hashMap.put("output", new String(Double.parseDouble((String) this.__server.get(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) >= 3.0d ? __decrypt(decode, 3, __keyExchange) : decode, this.__charset));
            } else {
                hashMap.put("output", "");
            }
            if (__post.containsKey("phprpc_result")) {
                if (__post.containsKey("phprpc_args")) {
                    Object[] objArr2 = (Object[]) this.__phpser.unserialize(__decrypt(Base64.decode((String) __post.get("phprpc_args")), 1, __keyExchange), Object[].class);
                    for (int i2 = 0; i2 < Math.min(objArr.length, objArr2.length); i2++) {
                        objArr[i2] = objArr2[i2];
                    }
                }
                hashMap.put("result", this.__phpser.unserialize(__decrypt(Base64.decode((String) __post.get("phprpc_result")), 2, __keyExchange)));
            } else {
                hashMap.put("result", this.__warning);
            }
        } catch (PHPRPC_Error e) {
            hashMap.put("result", e);
        } catch (Throwable th) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            StringBuffer append = new StringBuffer(th.toString()).append("\r\n");
            for (StackTraceElement stackTraceElement : stackTrace) {
                append.append(stackTraceElement.toString()).append("\r\n");
            }
            hashMap.put("result", new PHPRPC_Error(1, append.toString()));
        }
        return hashMap;
    }

    private final void __initSocketPool() throws IOException {
        SocketFactory socketFactory;
        String str;
        int i;
        if (((String) this.__server.get("scheme")).equals("https")) {
            socketFactory = SSLSocketFactory.getDefault();
        } else {
            socketFactory = SocketFactory.getDefault();
        }
        if (this.__proxy != null) {
            int intValue = ((Integer) this.__proxy.get(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT)).intValue();
            str = (String) this.__proxy.get("host");
            i = intValue;
        } else {
            int intValue2 = ((Integer) this.__server.get(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT)).intValue();
            str = (String) this.__server.get("host");
            i = intValue2;
        }
        this.__socketPool = new SocketPool(socketFactory, str, i, this.__timeout);
    }

    private final void __sendRequest(String str, Socket socket) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.__proxy == null) {
            stringBuffer.append(this.__server.get("path"));
            stringBuffer2.append("Connection: ");
            stringBuffer2.append(this.__keepAlive ? "Keep-Alive" : "close");
            stringBuffer2.append("\r\n");
            stringBuffer2.append("Pragma: no-cache\r\n");
            stringBuffer2.append("Cache-Control: no-cache\r\n");
        } else {
            stringBuffer.append(this.__server.get("scheme"));
            stringBuffer.append("://");
            stringBuffer.append(this.__server.get("host"));
            stringBuffer.append(":");
            stringBuffer.append(this.__server.get(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT));
            stringBuffer.append(this.__server.get("path"));
            stringBuffer2.append("Proxy-Connection: ");
            stringBuffer2.append(this.__keepAlive ? "Keep-Alive" : "close");
            stringBuffer2.append("\r\n");
            if (this.__proxy.get("userinfo") != null) {
                stringBuffer2.append("Proxy-Authorization: Basic ");
                stringBuffer2.append(Base64.encode(((String) this.__proxy.get("userinfo")).getBytes(this.__charset)));
                stringBuffer2.append("\r\n");
            }
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        if (this.__server.get("userinfo") != null) {
            stringBuffer3.append("Authorization: Basic ");
            stringBuffer3.append(Base64.encode(((String) this.__server.get("userinfo")).getBytes(this.__charset)));
            stringBuffer3.append("\r\n");
        }
        StringBuffer stringBuffer4 = new StringBuffer();
        if (__cookie != null) {
            stringBuffer4.append("Cookie: ");
            stringBuffer4.append(__cookie);
            stringBuffer4.append("\r\n");
        }
        byte[] bytes = str.getBytes();
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("POST ").append(stringBuffer).append(" HTTP/1.1\r\n");
        stringBuffer5.append("Host: ").append(this.__server.get("host")).append(':').append(this.__server.get(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT)).append("\r\n");
        stringBuffer5.append("User-Agent: PHPRPC Client 3.0 for Java\r\n");
        stringBuffer5.append(stringBuffer3).append(stringBuffer2).append(stringBuffer4);
        stringBuffer5.append("Accept: */*\r\n");
        stringBuffer5.append("Accept-Encoding: gzip,deflate\r\n");
        stringBuffer5.append("Content-Type: application/x-www-form-urlencoded; charset=").append(this.__charset).append("\r\n");
        stringBuffer5.append("Content-Length: ").append(bytes.length).append("\r\n");
        stringBuffer5.append("\r\n");
        __sendRequest(stringBuffer5.toString().getBytes(), bytes, socket);
    }

    private final void __sendRequest(byte[] bArr, byte[] bArr2, Socket socket) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.write(bArr2);
        bufferedOutputStream.flush();
    }

    private final void __parseHeader(HashMap hashMap) throws PHPRPC_Error {
        String str;
        String str2;
        ArrayList arrayList = (ArrayList) hashMap.get("x-powered-by");
        if (arrayList == null) {
            throw new PHPRPC_Error(1, "Illegal PHPRPC server.");
        }
        this.__server.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String str3 = null;
        int i = 0;
        while (i < arrayList.size()) {
            String str4 = (String) arrayList.get(i);
            i++;
            str3 = str4.startsWith("PHPRPC Server/") ? str4.substring(14) : str3;
        }
        if (str3 == null) {
            throw new PHPRPC_Error(1, "Illegal PHPRPC server.");
        }
        this.__server.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, str3);
        if (hashMap.containsKey("content-type")) {
            ArrayList arrayList2 = (ArrayList) hashMap.get("content-type");
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                String str5 = (String) arrayList2.get(i2);
                if (str5.startsWith("text/plain; charset=")) {
                    setCharset(str5.substring(20));
                }
            }
        }
        if (hashMap.containsKey("set-cookie")) {
            synchronized (__cookies) {
                ArrayList arrayList3 = (ArrayList) hashMap.get("set-cookie");
                for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                    for (String str6 : ((String) arrayList3.get(i3)).split("[;,]\\s?")) {
                        String[] split = str6.split("=", 2);
                        if (split.length == 2) {
                            str = split[0];
                            str2 = split[1];
                        } else {
                            str = split[0];
                            str2 = "";
                        }
                        if (!str.equals("domain") && !str.equals("expires") && !str.equals("path") && !str.equals("secure")) {
                            __cookies.put(str, str2);
                        }
                    }
                }
                __cookie = "";
                for (String str7 : __cookies.keySet()) {
                    __cookie += str7 + "=" + ((String) __cookies.get(str7)) + "; ";
                }
            }
        }
        if (hashMap.containsKey("content-encoding")) {
            hashMap.put("content-encoding", ((ArrayList) hashMap.get("content-encoding")).get(0));
        }
        if (hashMap.containsKey("transfer-encoding")) {
            hashMap.put("transfer-encoding", ((ArrayList) hashMap.get("transfer-encoding")).get(0));
        }
        if (hashMap.containsKey("content-length")) {
            hashMap.put("content-length", ((ArrayList) hashMap.get("content-length")).get(0));
        }
        if (hashMap.containsKey("connection")) {
            hashMap.put("connection", ((ArrayList) hashMap.get("connection")).get(0));
        }
    }

    private final String __readLine(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = inputStream.read();
            if (read > -1) {
                if (read == 13) {
                    if (inputStream.read() != 10) {
                        throw new IOException();
                    }
                    return stringBuffer.toString();
                }
                stringBuffer.append((char) read);
            } else {
                return stringBuffer.toString();
            }
        }
    }

    private final boolean __readCRLF(InputStream inputStream) throws IOException {
        return inputStream.read() == 13 && inputStream.read() == 10;
    }

    private final HashMap __readResponseHeader(String str, Socket socket) throws IOException, PHPRPC_Error {
        return __readResponseHeader(str, socket, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
        throw new org.phprpc.PHPRPC_Error(java.lang.Integer.parseInt(r2), r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.HashMap __readResponseHeader(java.lang.String r9, java.net.Socket r10, int r11) throws java.io.IOException, org.phprpc.PHPRPC_Error {
        /*
            r8 = this;
            r7 = 0
            r8.__sendRequest(r9, r10)
            java.io.InputStream r3 = r10.getInputStream()
            r1 = 0
            java.lang.String r0 = ""
        Lb:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r2 = r1
            r1 = r0
        L12:
            java.lang.String r0 = r8.__readLine(r3)
            java.lang.String r5 = ""
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L6b
            java.lang.String r5 = "HTTP/"
            boolean r5 = r0.startsWith(r5)
            if (r5 == 0) goto L37
            r1 = 9
            r2 = 12
            java.lang.String r1 = r0.substring(r1, r2)
            r2 = 13
            java.lang.String r0 = r0.substring(r2)
            r2 = r1
            r1 = r0
            goto L12
        L37:
            java.lang.String r5 = ":"
            int r5 = r0.indexOf(r5)
            r6 = -1
            if (r5 <= r6) goto L12
            java.lang.String r6 = r0.substring(r7, r5)
            java.lang.String r6 = r6.toLowerCase()
            int r5 = r5 + 1
            java.lang.String r0 = r0.substring(r5)
            java.lang.String r5 = r0.trim()
            boolean r0 = r4.containsKey(r6)
            if (r0 == 0) goto L65
            java.lang.Object r0 = r4.get(r6)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L5e:
            r0.add(r5)
            r4.put(r6, r0)
            goto L12
        L65:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            goto L5e
        L6b:
            if (r2 != 0) goto L7d
            org.phprpc.PHPRPC_Error r0 = new org.phprpc.PHPRPC_Error     // Catch: org.phprpc.PHPRPC_Error -> L76
            r1 = 1
            java.lang.String r2 = "Illegal HTTP server."
            r0.<init>(r1, r2)     // Catch: org.phprpc.PHPRPC_Error -> L76
            throw r0     // Catch: org.phprpc.PHPRPC_Error -> L76
        L76:
            r0 = move-exception
            org.phprpc.SocketPool r1 = r8.__socketPool
            r1.freeConnect(r10, r7)
            throw r0
        L7d:
            java.lang.String r0 = "100"
            boolean r0 = r2.equals(r0)     // Catch: org.phprpc.PHPRPC_Error -> L76
            if (r0 != 0) goto Lb6
            java.lang.String r0 = "200"
            boolean r0 = r2.equals(r0)     // Catch: org.phprpc.PHPRPC_Error -> L76
            if (r0 != 0) goto Lb6
            org.phprpc.PHPRPC_Error r0 = new org.phprpc.PHPRPC_Error     // Catch: org.phprpc.PHPRPC_Error -> L76 java.lang.NumberFormatException -> L97
            int r3 = java.lang.Integer.parseInt(r2)     // Catch: org.phprpc.PHPRPC_Error -> L76 java.lang.NumberFormatException -> L97
            r0.<init>(r3, r1)     // Catch: org.phprpc.PHPRPC_Error -> L76 java.lang.NumberFormatException -> L97
            throw r0     // Catch: org.phprpc.PHPRPC_Error -> L76 java.lang.NumberFormatException -> L97
        L97:
            r0 = move-exception
            org.phprpc.PHPRPC_Error r0 = new org.phprpc.PHPRPC_Error     // Catch: org.phprpc.PHPRPC_Error -> L76
            r3 = 1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: org.phprpc.PHPRPC_Error -> L76
            r4.<init>()     // Catch: org.phprpc.PHPRPC_Error -> L76
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch: org.phprpc.PHPRPC_Error -> L76
            java.lang.String r4 = ":"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: org.phprpc.PHPRPC_Error -> L76
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: org.phprpc.PHPRPC_Error -> L76
            java.lang.String r1 = r1.toString()     // Catch: org.phprpc.PHPRPC_Error -> L76
            r0.<init>(r3, r1)     // Catch: org.phprpc.PHPRPC_Error -> L76
            throw r0     // Catch: org.phprpc.PHPRPC_Error -> L76
        Lb6:
            java.lang.String r0 = "200"
            boolean r0 = r2.equals(r0)     // Catch: org.phprpc.PHPRPC_Error -> L76
            if (r0 == 0) goto Lc1
            r8.__parseHeader(r4)     // Catch: org.phprpc.PHPRPC_Error -> L76
        Lc1:
            java.lang.String r0 = "100"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto Lca
            return r4
        Lca:
            r0 = r1
            r1 = r2
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: org.phprpc.PHPRPC_Client.__readResponseHeader(java.lang.String, java.net.Socket, int):java.util.HashMap");
    }

    private final byte[] __ungzip(HashMap hashMap, byte[] bArr) throws IOException, PHPRPC_Error {
        String str = (String) hashMap.get("content-encoding");
        if (str != null && str.toLowerCase().equals("gzip")) {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            while (true) {
                int read = gZIPInputStream.read(bArr2, 0, length);
                if (read > -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } else {
            return bArr;
        }
    }

    private final HashMap __parseBody(byte[] bArr) throws IOException, PHPRPC_Error {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        HashMap hashMap = new HashMap();
        while (true) {
            String __readLine = __readLine(byteArrayInputStream);
            if (!__readLine.equals("")) {
                int indexOf = __readLine.indexOf("=");
                if (indexOf > -1) {
                    hashMap.put(__readLine.substring(0, indexOf), __readLine.substring(indexOf + 2, __readLine.length() - 2));
                }
            } else {
                return hashMap;
            }
        }
    }

    private final HashMap __readResponseBody(HashMap hashMap, Socket socket) throws IOException, PHPRPC_Error {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = socket.getInputStream();
        String str = (String) hashMap.get("transfer-encoding");
        if (str != null && str.toLowerCase().equals("chunked")) {
            String __readLine = __readLine(inputStream);
            if (__readLine.equals("")) {
                return new HashMap();
            }
            int parseInt = Integer.parseInt(__readLine, 16);
            while (parseInt > 0) {
                byte[] bArr = new byte[parseInt];
                while (parseInt > 0) {
                    int read = inputStream.read(bArr, 0, parseInt);
                    if (read <= -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    parseInt -= read;
                }
                if (!__readCRLF(inputStream)) {
                    this.__socketPool.freeConnect(socket, false);
                    throw new PHPRPC_Error(1, "Response is incorrect.");
                }
                parseInt = Integer.parseInt(__readLine(inputStream), 16);
            }
            __readLine(inputStream);
        } else if (hashMap.get("content-length") != null) {
            int parseInt2 = Integer.parseInt((String) hashMap.get("content-length"));
            byte[] bArr2 = new byte[parseInt2];
            while (parseInt2 > 0) {
                int read2 = inputStream.read(bArr2, 0, parseInt2);
                if (read2 <= -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read2);
                parseInt2 -= read2;
            }
        } else {
            byte[] bArr3 = new byte[2048];
            while (true) {
                int read3 = inputStream.read(bArr3, 0, 2048);
                if (read3 <= -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read3);
            }
            this.__keepAlive = false;
        }
        return __parseBody(__ungzip(hashMap, byteArrayOutputStream.toByteArray()));
    }

    private final HashMap __post(String str) throws IOException, PHPRPC_Error {
        if (this.__socketPool == null) {
            __initSocketPool();
        }
        Socket connect = this.__socketPool.getConnect();
        try {
            HashMap __readResponseHeader = __readResponseHeader(str, connect);
            HashMap __readResponseBody = __readResponseBody(__readResponseHeader, connect);
            String str2 = (String) __readResponseHeader.get("connection");
            if (this.__keepAlive && str2 != null && str2.equals("close")) {
                this.__keepAlive = false;
            }
            this.__socketPool.freeConnect(connect, this.__keepAlive);
            return __readResponseBody;
        } catch (IOException e) {
            this.__socketPool.freeConnect(connect, false);
            throw e;
        }
    }

    private final synchronized int __keyExchange(int i) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchAlgorithmException, PHPRPC_Error {
        byte[] digest;
        if (this.__key == null && i != 0) {
            if (this.__key == null && this.__keyExchanged) {
                i = 0;
            } else {
                HashMap __post = __post("phprpc_encrypt=true&phprpc_keylen=" + this.__keylen);
                if (__post.containsKey("phprpc_keylen")) {
                    this.__keylen = Integer.parseInt((String) __post.get("phprpc_keylen"));
                } else {
                    this.__keylen = 128;
                }
                if (__post.containsKey("phprpc_encrypt")) {
                    HashMap hashMap = (HashMap) this.__phpser.unserialize(Base64.decode((String) __post.get("phprpc_encrypt")), HashMap.class);
                    BigInteger bit = new BigInteger(this.__keylen - 1, new Random()).setBit(this.__keylen - 2);
                    BigInteger bigInteger = new BigInteger(Cast.toString(hashMap.get("y")));
                    BigInteger bigInteger2 = new BigInteger(Cast.toString(hashMap.get(TtmlNode.TAG_P)));
                    BigInteger bigInteger3 = new BigInteger(Cast.toString(hashMap.get("g")));
                    BigInteger modPow = bigInteger.modPow(bit, bigInteger2);
                    if (this.__keylen == 128) {
                        digest = modPow.toByteArray();
                    } else {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(modPow.toString().getBytes());
                        digest = messageDigest.digest();
                    }
                    byte[] bArr = new byte[16];
                    int min = Math.min(digest.length, 16);
                    for (int i2 = 1; i2 <= min; i2++) {
                        bArr[16 - i2] = digest[digest.length - i2];
                    }
                    __post("phprpc_encrypt=" + bigInteger3.modPow(bit, bigInteger2).toString());
                    this.__key = bArr;
                } else {
                    this.__key = null;
                    this.__keyExchanged = true;
                    i = 0;
                }
            }
        }
        return i;
    }

    private final byte[] __encrypt(byte[] bArr, int i, int i2) {
        if (this.__key != null && i2 >= i) {
            return XXTEA.encrypt(bArr, this.__key);
        }
        return bArr;
    }

    private final byte[] __decrypt(byte[] bArr, int i, int i2) {
        if (this.__key != null && i2 >= i) {
            return XXTEA.decrypt(bArr, this.__key);
        }
        return bArr;
    }
}
