package org.phprpc;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.flurry.android.Constants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.phprpc.util.Base64;
import org.phprpc.util.Cast;
import org.phprpc.util.DHParams;
import org.phprpc.util.PHPSerializer;
import org.phprpc.util.XXTEA;
/* loaded from: classes2.dex */
public final class PHPRPC_Server {
    private static HashMap globalFunctions = new HashMap();
    private StringBuffer buffer;
    private boolean byref;
    private String callback;
    private String cid;
    private boolean encode;
    private boolean encrypt;
    private int encryptMode;
    private int errno;
    private String errstr;
    private byte[] key;
    private int keylen;
    private String output;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private BigInteger y;
    private PHPSerializer phpser = new PHPSerializer();
    private HashMap functions = new HashMap();
    private String charset = C.UTF8_NAME;
    private boolean debug = false;
    private boolean enableGZIP = false;

    private static boolean add(String[] strArr, Object obj, Class cls, String[] strArr2, HashMap hashMap) {
        if (strArr2 == null) {
            strArr2 = strArr;
        }
        if (strArr.length != strArr2.length) {
            return false;
        }
        Method[] methods = cls.getMethods();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            ArrayList arrayList = new ArrayList();
            int length2 = methods.length;
            for (int i2 = 0; i2 < length2; i2++) {
                int modifiers = methods[i2].getModifiers();
                if (strArr[i].toLowerCase().equals(methods[i2].getName().toLowerCase()) && Modifier.isPublic(modifiers)) {
                    if ((obj == null) == Modifier.isStatic(modifiers)) {
                        arrayList.add(methods[i2]);
                    }
                }
            }
            if (arrayList.size() > 0) {
                hashMap.put(strArr2[i].toLowerCase(), new RemoteFunction(obj, (Method[]) arrayList.toArray(new Method[arrayList.size()])));
            }
        }
        return true;
    }

    private static boolean add(Method[] methodArr, Object obj, String[] strArr, HashMap hashMap) {
        if (strArr == null) {
            strArr = new String[methodArr.length];
            for (int i = 0; i < methodArr.length; i++) {
                strArr[i] = methodArr[i].getName();
            }
        }
        if (methodArr.length != strArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < methodArr.length; i2++) {
            int modifiers = methodArr[i2].getModifiers();
            if (Modifier.isPublic(modifiers)) {
                if ((obj == null) == Modifier.isStatic(modifiers)) {
                    hashMap.put(strArr[i2].toLowerCase(), new RemoteFunction(obj, new Method[]{methodArr[i2]}));
                }
            }
        }
        return true;
    }

    public static String[] getAllFunctions(Class cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        HashMap hashMap = new HashMap();
        int length = declaredMethods.length;
        for (int i = 0; i < length; i++) {
            if (Modifier.isPublic(declaredMethods[i].getModifiers())) {
                String lowerCase = declaredMethods[i].getName().toLowerCase();
                hashMap.put(lowerCase, lowerCase);
            }
        }
        Object[] array = hashMap.keySet().toArray();
        String[] strArr = new String[array.length];
        System.arraycopy(array, 0, strArr, 0, array.length);
        return strArr;
    }

    private String toHexString(int i) {
        return (i < 16 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "") + Integer.toHexString(i);
    }

    private String addJsSlashes(String str) {
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (charArray[i] <= 31 || charArray[i] == '\"' || charArray[i] == '\'' || charArray[i] == '\\' || charArray[i] == 127) {
                stringBuffer.append("\\x");
                stringBuffer.append(toHexString(charArray[i] & 255));
            } else {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer.toString();
    }

    private String addJsSlashes(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (bArr[i] <= 31 || bArr[i] == 34 || bArr[i] == 39 || bArr[i] == 92 || bArr[i] >= Byte.MAX_VALUE) {
                stringBuffer.append("\\x");
                stringBuffer.append(toHexString(bArr[i] & Constants.UNKNOWN));
            } else {
                stringBuffer.append((char) bArr[i]);
            }
        }
        return stringBuffer.toString();
    }

    private String encodeString(String str) throws UnsupportedEncodingException {
        return this.encode ? Base64.encode(str.getBytes(this.charset)) : addJsSlashes(str);
    }

    private String encodeString(byte[] bArr) {
        return this.encode ? Base64.encode(bArr) : addJsSlashes(bArr);
    }

    private byte[] encryptString(byte[] bArr, int i) {
        if (this.encryptMode >= i) {
            return XXTEA.encrypt(bArr, this.key);
        }
        return bArr;
    }

    private byte[] decryptString(byte[] bArr, int i) {
        if (this.encryptMode >= i) {
            return XXTEA.decrypt(bArr, this.key);
        }
        return bArr;
    }

    private void sendURL() throws UnsupportedEncodingException {
        if (!this.request.isRequestedSessionIdValid() || this.session.isNew()) {
            StringBuffer requestURL = this.request.getRequestURL();
            Enumeration parameterNames = this.request.getParameterNames();
            if (parameterNames.hasMoreElements()) {
                requestURL.append('?');
                do {
                    String str = (String) parameterNames.nextElement();
                    if (!str.toLowerCase().startsWith("phprpc_")) {
                        for (String str2 : this.request.getParameterValues(str)) {
                            requestURL.append(str).append('=').append(URLEncoder.encode(str2, this.charset)).append('&');
                        }
                    }
                } while (parameterNames.hasMoreElements());
                requestURL.setLength(requestURL.length() - 1);
            }
            this.buffer.append("phprpc_url=\"");
            this.buffer.append(encodeString(this.response.encodeURL(requestURL.toString())));
            this.buffer.append("\";\r\n");
        }
    }

    private void gzip(byte[] bArr) throws IOException {
        String header = this.request.getHeader("Accept-Encoding");
        if (header != null && header.indexOf("gzip") != -1) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            if (bArr.length > byteArrayOutputStream.size()) {
                this.response.setHeader("Content-Encoding", "gzip");
                this.response.setContentLength(byteArrayOutputStream.size());
                byteArrayOutputStream.writeTo(this.response.getOutputStream());
                return;
            }
        }
        this.response.setContentLength(bArr.length);
        this.response.getOutputStream().write(bArr);
    }

    private void sendCallback() throws IOException {
        this.buffer.append(this.callback);
        String stringBuffer = this.buffer.toString();
        if (this.enableGZIP) {
            gzip(stringBuffer.getBytes(this.charset));
        } else {
            this.response.getWriter().write(stringBuffer);
        }
        this.response.flushBuffer();
    }

    private void sendFunctions() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.buffer.append("phprpc_functions=\"");
        this.functions.putAll(globalFunctions);
        this.buffer.append(encodeString(this.phpser.serialize(this.functions.keySet().toArray())));
        this.buffer.append("\";\r\n");
        sendCallback();
    }

    private void sendOutput() throws IOException {
        if (this.encryptMode >= 3) {
            this.buffer.append("phprpc_output=\"");
            this.buffer.append(encodeString(XXTEA.encrypt(this.output.getBytes(this.charset), this.key)));
            this.buffer.append("\";\r\n");
            return;
        }
        this.buffer.append("phprpc_output=\"");
        this.buffer.append(encodeString(this.output));
        this.buffer.append("\";\r\n");
    }

    private void sendError() throws IOException {
        this.buffer.append("phprpc_errno=\"");
        this.buffer.append(this.errno);
        this.buffer.append("\";\r\n");
        this.buffer.append("phprpc_errstr=\"");
        this.buffer.append(encodeString(this.errstr));
        this.buffer.append("\";\r\n");
        sendOutput();
        sendCallback();
    }

    private void sendHeader() {
        this.response.setContentType("text/plain; charset=" + this.charset);
        this.response.setHeader("P3P", "CP=\"CAO DSP COR CUR ADM DEV TAI PSA PSD IVAi IVDi CONi TELo OTPi OUR DELi SAMi OTRi UNRi PUBi IND PHY ONL UNI PUR FIN COM NAV INT DEM CNT STA POL HEA PRE GOV\"");
        this.response.setHeader("X-Powered-By", "PHPRPC Server/3.0");
        this.response.setDateHeader("Expires", new Date().getTime());
        this.response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
    }

    private byte[] call(Method method, Object obj, ArrayList arrayList) throws Throwable {
        Class<?>[] parameterTypes = method.getParameterTypes();
        String name = method.getName();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream, false, this.charset);
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(byteArrayOutputStream, this.charset), false);
        int size = arrayList.size();
        if (parameterTypes.length != size) {
            if (this.session == null) {
                this.session = this.request.getSession(true);
            }
            if (parameterTypes.length == size + 1) {
                String name2 = parameterTypes[parameterTypes.length - 1].getName();
                if (name2.equals("javax.servlet.http.HttpServletRequest")) {
                    arrayList.add(this.request);
                } else if (name2.equals("javax.servlet.http.HttpSession")) {
                    arrayList.add(this.session);
                } else if (name2.equals("javax.servlet.ServletContext")) {
                    arrayList.add(this.session.getServletContext());
                } else if (name2.equals("java.io.PrintStream")) {
                    arrayList.add(printStream);
                } else if (name2.equals("java.io.PrintWriter")) {
                    arrayList.add(printWriter);
                } else {
                    throw new IllegalArgumentException("number of arguments mismatch for " + name + "().");
                }
            } else if (parameterTypes.length == size + 2) {
                String name3 = parameterTypes[parameterTypes.length - 2].getName();
                String name4 = parameterTypes[parameterTypes.length - 1].getName();
                if (name3.equals("javax.servlet.http.HttpServletRequest") && name4.equals("java.io.PrintStream")) {
                    arrayList.add(this.request);
                    arrayList.add(printStream);
                } else if (name3.equals("javax.servlet.http.HttpServletRequest") && name4.equals("java.io.PrintWriter")) {
                    arrayList.add(this.request);
                    arrayList.add(printWriter);
                } else if (name3.equals("java.io.PrintStream") && name4.equals("javax.servlet.http.HttpServletRequest")) {
                    arrayList.add(printStream);
                    arrayList.add(this.request);
                } else if (name3.equals("java.io.PrintWriter") && name4.equals("javax.servlet.http.HttpServletRequest")) {
                    arrayList.add(printWriter);
                    arrayList.add(this.request);
                } else if (name3.equals("javax.servlet.http.HttpSession") && name4.equals("java.io.PrintStream")) {
                    arrayList.add(this.session);
                    arrayList.add(printStream);
                } else if (name3.equals("javax.servlet.http.HttpSession") && name4.equals("java.io.PrintWriter")) {
                    arrayList.add(this.session);
                    arrayList.add(printWriter);
                } else if (name3.equals("java.io.PrintStream") && name4.equals("javax.servlet.http.HttpSession")) {
                    arrayList.add(printStream);
                    arrayList.add(this.session);
                } else if (name3.equals("java.io.PrintWriter") && name4.equals("javax.servlet.http.HttpSession")) {
                    arrayList.add(printWriter);
                    arrayList.add(this.session);
                } else if (name3.equals("javax.servlet.ServletContext") && name4.equals("java.io.PrintStream")) {
                    arrayList.add(this.session.getServletContext());
                    arrayList.add(printStream);
                } else if (name3.equals("javax.servlet.ServletContext") && name4.equals("java.io.PrintWriter")) {
                    arrayList.add(this.session.getServletContext());
                    arrayList.add(printWriter);
                } else if (name3.equals("java.io.PrintStream") && name4.equals("javax.servlet.ServletContext")) {
                    arrayList.add(printStream);
                    arrayList.add(this.session.getServletContext());
                } else if (name3.equals("java.io.PrintWriter") && name4.equals("javax.servlet.ServletContext")) {
                    arrayList.add(printWriter);
                    arrayList.add(this.session.getServletContext());
                } else {
                    throw new IllegalArgumentException("number of arguments mismatch for " + name + "().");
                }
            } else {
                throw new IllegalArgumentException("number of arguments mismatch for " + name + "().");
            }
        }
        Object[] array = arrayList.toArray();
        while (size < arrayList.size()) {
            arrayList.remove(size);
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] != null) {
                array[i] = Cast.cast(array[i], parameterTypes[i], this.charset);
            }
        }
        try {
            byte[] serialize = this.phpser.serialize(method.invoke(obj, array));
            printStream.close();
            printWriter.close();
            this.output = new String(byteArrayOutputStream.toByteArray(), this.charset);
            return serialize;
        } catch (ExceptionInInitializerError e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                throw cause;
            }
            throw new ExceptionInInitializerError(e.getMessage() + " for " + name + "().");
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(e2.getMessage() + " for " + name + "().");
        } catch (IllegalArgumentException e3) {
            throw new IllegalArgumentException(e3.getMessage() + " for " + name + "().");
        } catch (NullPointerException e4) {
            throw new NullPointerException(e4.getMessage() + " for " + name + "().");
        } catch (InvocationTargetException e5) {
            Throwable cause2 = e5.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw new InvocationTargetException(null, e5.getMessage() + " for " + name + "().");
        }
    }

    private boolean getBooleanRequest(String str) {
        if (this.request.getParameter(str) == null || !this.request.getParameter(str).toLowerCase().equals("false")) {
            return true;
        }
        return false;
    }

    private void initEncode() {
        this.encode = getBooleanRequest("phprpc_encode");
    }

    private void initRef() {
        this.byref = getBooleanRequest("phprpc_ref");
    }

    private void initErrorHandler() {
        this.errno = 0;
        this.errstr = "";
        this.output = "";
    }

    private void initCallback() throws UnsupportedEncodingException {
        if (this.request.getParameter("phprpc_callback") != null) {
            this.callback = new String(Base64.decode(this.request.getParameter("phprpc_callback")), this.charset);
        } else {
            this.callback = "";
        }
    }

    private void initClientID() {
        this.cid = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (this.request.getParameter("phprpc_id") != null) {
            this.cid = this.request.getParameter("phprpc_id");
        }
        this.cid = "phprpc_" + this.cid;
    }

    private void initKeylen() {
        if (this.request.getParameter("phprpc_keylen") != null) {
            this.keylen = Integer.parseInt(this.request.getParameter("phprpc_keylen"));
            return;
        }
        HashMap hashMap = (HashMap) this.session.getAttribute(this.cid);
        if (hashMap != null && hashMap.get("keylen") != null) {
            this.keylen = ((Integer) hashMap.get("keylen")).intValue();
        } else {
            this.keylen = 128;
        }
    }

    private void initEncrypt() {
        this.encrypt = false;
        this.encryptMode = 0;
        this.y = null;
        if (this.request.getParameter("phprpc_encrypt") != null) {
            String lowerCase = this.request.getParameter("phprpc_encrypt").toLowerCase();
            if (lowerCase.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                this.encrypt = true;
            } else if (lowerCase.equals("false")) {
                this.encrypt = false;
            } else if (lowerCase.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.encryptMode = 0;
            } else if (lowerCase.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                this.encryptMode = 1;
            } else if (lowerCase.equals("2")) {
                this.encryptMode = 2;
            } else if (lowerCase.equals("3")) {
                this.encryptMode = 3;
            } else {
                this.y = new BigInteger(lowerCase);
            }
        }
    }

    private void initKey() throws Exception {
        if (this.encryptMode > 0) {
            if (this.session == null) {
                this.session = this.request.getSession(true);
            }
            HashMap hashMap = (HashMap) this.session.getAttribute(this.cid);
            if (hashMap != null && hashMap.get("key") != null) {
                this.key = (byte[]) hashMap.get("key");
            } else {
                this.encryptMode = 0;
                throw new Exception("Can't find the key for decryption.");
            }
        }
    }

    private ArrayList getArguments() throws UnsupportedEncodingException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.request.getParameter("phprpc_args") != null) {
            return (ArrayList) this.phpser.unserialize(decryptString(Base64.decode(this.request.getParameter("phprpc_args")), 1), ArrayList.class);
        }
        return new ArrayList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0056, code lost:
        r13.buffer.append("phprpc_args=\"");
        r13.buffer.append(encodeString(encryptString(r13.phpser.serialize(r5), 1)));
        r13.buffer.append("\";\r\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0078, code lost:
        sendError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x007b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003f, code lost:
        r13.buffer.append("phprpc_result=\"");
        r13.buffer.append(r0);
        r13.buffer.append("\";\r\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0054, code lost:
        if (r13.byref == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void callFunction() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.phprpc.PHPRPC_Server.callFunction():void");
    }

    private void keyExchange() throws IOException, IllegalAccessException, NoSuchAlgorithmException, IllegalArgumentException, InvocationTargetException {
        byte[] digest;
        if (this.session == null) {
            this.session = this.request.getSession(true);
        }
        initKeylen();
        if (this.encrypt) {
            DHParams dHParams = new DHParams(this.keylen);
            this.keylen = dHParams.getL();
            BigInteger p = dHParams.getP();
            BigInteger g = dHParams.getG();
            BigInteger x = dHParams.getX();
            BigInteger modPow = g.modPow(x, p);
            HashMap hashMap = new HashMap();
            hashMap.put("x", x);
            hashMap.put(TtmlNode.TAG_P, p);
            hashMap.put("keylen", new Integer(this.keylen));
            this.session.setAttribute(this.cid, hashMap);
            HashMap dHParams2 = dHParams.getDHParams();
            dHParams2.put("y", modPow.toString());
            this.buffer.append("phprpc_encrypt=\"");
            this.buffer.append(encodeString(this.phpser.serialize(dHParams2)));
            this.buffer.append("\";\r\n");
            if (this.keylen != 128) {
                this.buffer.append("phprpc_keylen=\"");
                this.buffer.append(this.keylen);
                this.buffer.append("\";\r\n");
            }
            sendURL();
        } else {
            HashMap hashMap2 = (HashMap) this.session.getAttribute(this.cid);
            BigInteger modPow2 = this.y.modPow((BigInteger) hashMap2.get("x"), (BigInteger) hashMap2.get(TtmlNode.TAG_P));
            if (this.keylen == 128) {
                digest = modPow2.toByteArray();
            } else {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(modPow2.toString().getBytes());
                digest = messageDigest.digest();
            }
            this.key = new byte[16];
            int min = Math.min(digest.length, 16);
            for (int i = 1; i <= min; i++) {
                this.key[16 - i] = digest[digest.length - i];
            }
            hashMap2.put("key", this.key);
            hashMap2.remove("x");
            hashMap2.remove(TtmlNode.TAG_P);
            this.session.setAttribute(this.cid, hashMap2);
        }
        sendCallback();
    }

    public static boolean addGlobal(Object obj) {
        Class<?> cls = obj.getClass();
        return addGlobal(getAllFunctions(cls), obj, cls, (String[]) null);
    }

    public static boolean addGlobal(Class cls) {
        return addGlobal(getAllFunctions(cls), (Object) null, cls, (String[]) null);
    }

    public static boolean addGlobal(Object obj, Class cls) {
        return addGlobal(getAllFunctions(cls), obj, cls, (String[]) null);
    }

    public static boolean addGlobal(String str, Object obj) {
        return addGlobal(new String[]{str}, obj, obj.getClass(), (String[]) null);
    }

    public static boolean addGlobal(String str, Object obj, String str2) {
        return addGlobal(new String[]{str}, obj, obj.getClass(), new String[]{str2});
    }

    public static boolean addGlobal(Method method, Object obj) {
        return addGlobal(new Method[]{method}, obj, (String[]) null);
    }

    public static boolean addGlobal(Method method, Object obj, String str) {
        return addGlobal(new Method[]{method}, obj, new String[]{str});
    }

    public static boolean addGlobal(Method[] methodArr, Object obj, String[] strArr) {
        return add(methodArr, obj, strArr, globalFunctions);
    }

    public static boolean addGlobal(String[] strArr, Object obj) {
        return addGlobal(strArr, obj, obj.getClass(), (String[]) null);
    }

    public static boolean addGlobal(String[] strArr, Object obj, String[] strArr2) {
        return addGlobal(strArr, obj, obj.getClass(), strArr2);
    }

    public static boolean addGlobal(String str, Class cls) {
        return addGlobal(new String[]{str}, (Object) null, cls, (String[]) null);
    }

    public static boolean addGlobal(String str, Class cls, String str2) {
        return addGlobal(new String[]{str}, (Object) null, cls, new String[]{str2});
    }

    public static boolean addGlobal(String[] strArr, Class cls) {
        return addGlobal(strArr, (Object) null, cls, (String[]) null);
    }

    public static boolean addGlobal(String[] strArr, Class cls, String[] strArr2) {
        return addGlobal(strArr, (Object) null, cls, strArr2);
    }

    public static boolean addGlobal(String str, Object obj, Class cls, String str2) {
        return addGlobal(new String[]{str}, obj, cls, new String[]{str2});
    }

    public static boolean addGlobal(String[] strArr, Object obj, Class cls, String[] strArr2) {
        return add(strArr, obj, cls, strArr2, globalFunctions);
    }

    public boolean add(Object obj) {
        Class<?> cls = obj.getClass();
        return add(getAllFunctions(cls), obj, cls, (String[]) null);
    }

    public boolean add(Class cls) {
        return add(getAllFunctions(cls), (Object) null, cls, (String[]) null);
    }

    public boolean add(Object obj, Class cls) {
        return add(getAllFunctions(cls), obj, cls, (String[]) null);
    }

    public boolean add(String str, Object obj) {
        return add(new String[]{str}, obj, obj.getClass(), (String[]) null);
    }

    public boolean add(String str, Object obj, String str2) {
        return add(new String[]{str}, obj, obj.getClass(), new String[]{str2});
    }

    public boolean add(String[] strArr, Object obj) {
        return add(strArr, obj, obj.getClass(), (String[]) null);
    }

    public boolean add(String[] strArr, Object obj, String[] strArr2) {
        return add(strArr, obj, obj.getClass(), strArr2);
    }

    public boolean add(String str, Class cls) {
        return add(new String[]{str}, (Object) null, cls, (String[]) null);
    }

    public boolean add(String str, Class cls, String str2) {
        return add(new String[]{str}, (Object) null, cls, new String[]{str2});
    }

    public boolean add(String[] strArr, Class cls) {
        return add(strArr, (Object) null, cls, (String[]) null);
    }

    public boolean add(String[] strArr, Class cls, String[] strArr2) {
        return add(strArr, (Object) null, cls, strArr2);
    }

    public boolean add(String str, Object obj, Class cls, String str2) {
        return add(new String[]{str}, obj, cls, new String[]{str2});
    }

    public boolean add(String[] strArr, Object obj, Class cls, String[] strArr2) {
        return add(strArr, obj, cls, strArr2, this.functions);
    }

    public void setCharset(String str) {
        this.charset = str;
        this.phpser.setCharset(str);
    }

    public void setDebugMode(boolean z) {
        this.debug = z;
    }

    public void setEnableGZIP(boolean z) {
        this.enableGZIP = z;
    }

    public void start(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        this.request = httpServletRequest;
        this.response = httpServletResponse;
        httpServletResponse.resetBuffer();
        this.session = null;
        this.buffer = new StringBuffer();
        try {
            initErrorHandler();
            sendHeader();
            initClientID();
            initEncode();
            initCallback();
            initRef();
            initEncrypt();
            if (httpServletRequest.getParameter("phprpc_func") != null) {
                callFunction();
            } else if (this.encrypt || this.y != null) {
                keyExchange();
            } else {
                sendFunctions();
            }
        } catch (Throwable th) {
            this.errno = 1;
            if (this.debug) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                StringBuffer append = new StringBuffer(th.toString()).append("\r\n");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    append.append(stackTraceElement.toString()).append("\r\n");
                }
                this.errstr = append.toString();
            } else {
                this.errstr = th.toString();
            }
            sendError();
        }
    }

    public String getErrstr() {
        return this.errstr;
    }
}
