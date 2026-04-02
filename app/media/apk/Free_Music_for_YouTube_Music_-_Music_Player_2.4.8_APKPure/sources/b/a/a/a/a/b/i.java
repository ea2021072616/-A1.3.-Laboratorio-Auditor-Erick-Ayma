package b.a.a.a.a.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.flurry.android.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
/* compiled from: CommonUtils.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f98b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f99c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long d = -1;

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<File> f97a = new Comparator<File>() { // from class: b.a.a.a.a.b.i.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    };

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
        r0 = r1[1];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.io.File r7, java.lang.String r8) {
        /*
            r0 = 0
            r5 = 1
            boolean r1 = r7.exists()
            if (r1 == 0) goto L39
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
            r1.<init>(r7)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1, r3)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5e
        L14:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r1 == 0) goto L34
            java.lang.String r3 = "\\s*:\\s*"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r4 = 2
            java.lang.String[] r1 = r3.split(r1, r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            int r3 = r1.length     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r3 <= r5) goto L14
            r3 = 0
            r3 = r1[r3]     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            boolean r3 = r3.equals(r8)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            if (r3 == 0) goto L14
            r3 = 1
            r0 = r1[r3]     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
        L34:
            java.lang.String r1 = "Failed to close system file reader."
            a(r2, r1)
        L39:
            return r0
        L3a:
            r1 = move-exception
            r2 = r0
        L3c:
            b.a.a.a.l r3 = b.a.a.a.c.h()     // Catch: java.lang.Throwable -> L67
            java.lang.String r4 = "Fabric"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r5.<init>()     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = "Error parsing "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L67
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch: java.lang.Throwable -> L67
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L67
            r3.e(r4, r5, r1)     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = "Failed to close system file reader."
            a(r2, r1)
            goto L39
        L5e:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L61:
            java.lang.String r1 = "Failed to close system file reader."
            a(r2, r1)
            throw r0
        L67:
            r0 = move-exception
            goto L61
        L69:
            r1 = move-exception
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.a.a.b.i.a(java.io.File, java.lang.String):java.lang.String");
    }

    public static int a() {
        return a.a().ordinal();
    }

    /* compiled from: CommonUtils.java */
    /* loaded from: classes.dex */
    enum a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, a> k = new HashMap(4);

        static {
            k.put("armeabi-v7a", ARMV7);
            k.put("armeabi", ARMV6);
            k.put("arm64-v8a", ARM64);
            k.put("x86", X86_32);
        }

        static a a() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                b.a.a.a.c.h().a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            a aVar = k.get(str.toLowerCase(Locale.US));
            if (aVar == null) {
                return UNKNOWN;
            }
            return aVar;
        }
    }

    public static synchronized long b() {
        long j;
        synchronized (i.class) {
            if (d == -1) {
                long j2 = 0;
                String a2 = a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a2)) {
                    String upperCase = a2.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            j2 = a(upperCase, "KB", 1024);
                        } else if (upperCase.endsWith("MB")) {
                            j2 = a(upperCase, "MB", 1048576);
                        } else if (upperCase.endsWith("GB")) {
                            j2 = a(upperCase, "GB", 1073741824);
                        } else {
                            b.a.a.a.c.h().a("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase);
                        }
                    } catch (NumberFormatException e) {
                        b.a.a.a.c.h().e("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase, e);
                    }
                }
                d = j2;
            }
            j = d;
        }
        return j;
    }

    static long a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * i;
    }

    public static ActivityManager.RunningAppProcessInfo a(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String a(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static String a(String str) {
        return a(str, "SHA-1");
    }

    public static String b(InputStream inputStream) {
        return a(inputStream, "SHA-1");
    }

    private static String a(InputStream inputStream, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return a(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            b.a.a.a.c.h().e("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    private static String a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            b.a.a.a.c.h().e("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    private static String a(String str, String str2) {
        return a(str.getBytes(), str2);
    }

    public static String a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            sb.append(str2);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            return a(sb2);
        }
        return null;
    }

    public static long b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long b(String str) {
        StatFs statFs;
        long blockSize = new StatFs(str).getBlockSize();
        return (statFs.getBlockCount() * blockSize) - (statFs.getAvailableBlocks() * blockSize);
    }

    public static Float c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        return Float.valueOf(registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1));
    }

    public static boolean d(Context context) {
        if (f(context)) {
            return false;
        }
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static void a(Context context, String str) {
        if (e(context)) {
            b.a.a.a.c.h().a("Fabric", str);
        }
    }

    public static void a(Context context, String str, Throwable th) {
        if (e(context)) {
            b.a.a.a.c.h().e("Fabric", str);
        }
    }

    public static void a(Context context, int i, String str, String str2) {
        if (e(context)) {
            b.a.a.a.c.h().a(i, "Fabric", str2);
        }
    }

    public static boolean e(Context context) {
        if (f98b == null) {
            f98b = Boolean.valueOf(a(context, "com.crashlytics.Trace", false));
        }
        return f98b.booleanValue();
    }

    public static boolean a(Context context, String str, boolean z) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int a2 = a(context, str, "bool");
            if (a2 > 0) {
                return resources.getBoolean(a2);
            }
            int a3 = a(context, str, "string");
            if (a3 > 0) {
                return Boolean.parseBoolean(context.getString(a3));
            }
            return z;
        }
        return z;
    }

    public static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, j(context));
    }

    public static boolean f(Context context) {
        return ServerProtocol.DIALOG_PARAM_SDK_VERSION.equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Settings.Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean g(Context context) {
        boolean f = f(context);
        String str = Build.TAGS;
        if ((f || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !f && new File("/system/xbin/su").exists();
        }
        return true;
    }

    public static boolean c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int h(Context context) {
        int i = 0;
        if (f(context)) {
            i = 1;
        }
        if (g(context)) {
            i |= 2;
        }
        if (c()) {
            return i | 4;
        }
        return i;
    }

    public static int a(Context context, boolean z) {
        Float c2 = c(context);
        if (!z || c2 == null) {
            return 1;
        }
        if (c2.floatValue() >= 99.0d) {
            return 3;
        }
        if (c2.floatValue() < 99.0d) {
            return 2;
        }
        return 0;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & Constants.UNKNOWN;
            cArr[i * 2] = f99c[i2 >>> 4];
            cArr[(i * 2) + 1] = f99c[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String b(Context context, String str) {
        int a2 = a(context, str, "string");
        return a2 > 0 ? context.getString(a2) : "";
    }

    public static void a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                b.a.a.a.c.h().e("Fabric", str, e);
            }
        }
    }

    public static void a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e) {
                b.a.a.a.c.h().e("Fabric", str, e);
            }
        }
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0;
    }

    public static String a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value must be zero or greater");
        }
        return String.format(Locale.US, "%1$10s", Integer.valueOf(i)).replace(' ', '0');
    }

    public static String j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        return i > 0 ? context.getResources().getResourcePackageName(i) : context.getPackageName();
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String b(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    public static String k(Context context) {
        InputStream inputStream;
        Throwable th;
        try {
            inputStream = context.getResources().openRawResource(l(context));
            try {
                try {
                    String b2 = b(inputStream);
                    r0 = c(b2) ? null : b2;
                    a((Closeable) inputStream, "Failed to close icon input stream.");
                } catch (Exception e) {
                    e = e;
                    b.a.a.a.c.h().e("Fabric", "Could not calculate hash for app icon.", e);
                    a((Closeable) inputStream, "Failed to close icon input stream.");
                    return r0;
                }
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) inputStream, "Failed to close icon input stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            a((Closeable) inputStream, "Failed to close icon input stream.");
            throw th;
        }
        return r0;
    }

    public static int l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m(Context context) {
        int a2 = a(context, "io.fabric.android.build_id", "string");
        if (a2 == 0) {
            a2 = a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a2 == 0) {
            return null;
        }
        String string = context.getResources().getString(a2);
        b.a.a.a.c.h().a("Fabric", "Build ID is: " + string);
        return string;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean n(Context context) {
        if (c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        return true;
    }
}
