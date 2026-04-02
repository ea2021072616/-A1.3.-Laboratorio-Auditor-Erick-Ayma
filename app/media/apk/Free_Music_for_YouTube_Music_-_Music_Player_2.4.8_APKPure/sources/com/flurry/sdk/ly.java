package com.flurry.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class ly {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2186a = ly.class.getSimpleName();

    public static void a() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be called from the main thread!");
        }
    }

    public static void b() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Must be called from a background thread!");
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && Uri.parse(str).getScheme() == null) {
            return "http://" + str;
        }
        return str;
    }

    public static String c(String str) {
        try {
            return URLEncoder.encode(str, C.UTF8_NAME);
        } catch (UnsupportedEncodingException e) {
            km.a(5, f2186a, "Cannot encode '" + str + "'");
            return "";
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static byte[] d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.getBytes(C.UTF8_NAME);
        } catch (UnsupportedEncodingException e) {
            km.a(5, f2186a, "Unsupported UTF-8: " + e.getMessage());
            return null;
        }
    }

    public static byte[] e(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes(), 0, str.length());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            km.a(6, f2186a, "Unsupported SHA1: " + e.getMessage());
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (byte b2 : bArr) {
            sb.append(cArr[(byte) ((b2 & 240) >> 4)]);
            sb.append(cArr[(byte) (b2 & 15)]);
        }
        return sb.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            km.a(5, f2186a, "Unsupported ISO-8859-1:" + e.getMessage());
            return null;
        }
    }

    public static boolean a(long j) {
        if (j != 0 && System.currentTimeMillis() > j) {
            return false;
        }
        return true;
    }

    public static boolean a(Intent intent) {
        return jy.a().f2022a.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static String f(String str) {
        return str.replace("\\b", "").replace("\\n", "").replace("\\r", "").replace("\\t", "").replace("\\", "\\\\").replace("'", "\\'").replace("\"", "\\\"");
    }

    public static Map<String, String> g(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (!split[0].equals(NotificationCompat.CATEGORY_EVENT)) {
                    hashMap.put(h(split[0]), h(split[1]));
                }
            }
        }
        return hashMap;
    }

    public static String h(String str) {
        try {
            return URLDecoder.decode(str, C.UTF8_NAME);
        } catch (UnsupportedEncodingException e) {
            km.a(5, f2186a, "Cannot decode '" + str + "'");
            return "";
        }
    }

    public static long i(String str) {
        if (str == null) {
            return 0L;
        }
        long j = 1125899906842597L;
        int i = 0;
        while (i < str.length()) {
            i++;
            j = str.charAt(i) + (j * 31);
        }
        return j;
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                return j;
            }
        }
    }

    public static double a(double d, int i) {
        if (i != -1) {
            return Math.round(Math.pow(10.0d, i) * d) / Math.pow(10.0d, i);
        }
        return d;
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e) {
            km.a(6, f2186a, "Error occured when checking if app has permission.  Error: " + e.getMessage());
            return false;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 255) {
            return str;
        }
        return str.substring(0, 255);
    }
}
