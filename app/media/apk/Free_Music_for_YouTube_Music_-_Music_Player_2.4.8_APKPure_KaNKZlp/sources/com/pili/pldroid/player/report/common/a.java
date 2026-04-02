package com.pili.pldroid.player.report.common;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Choreographer;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: Util.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f5048a = "AUTO";

    /* renamed from: b  reason: collision with root package name */
    private static String[] f5049b = {"/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone1/temp", "/sys/devices/platform/s5p-tmu/curr_temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/system/cpu/cpufreq/cput_attributes/cur_temp", "/sys/devices/platform/s5p-tmu/temperature"};

    public static String a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("qos", 0);
        String string = sharedPreferences.getString("deviceId", "");
        if ("".equals(string)) {
            String c2 = c();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("deviceId", c2);
            edit.commit();
            return c2;
        }
        return string;
    }

    public static String a() {
        String hostAddress;
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.connect(InetAddress.getByName("114.114.114.114"), 53);
            InetAddress localAddress = datagramSocket.getLocalAddress();
            datagramSocket.close();
            if (localAddress == null || (hostAddress = localAddress.getHostAddress()) == null || "::".equals(hostAddress)) {
                return "";
            }
            return hostAddress;
        } catch (IOException e) {
            return "";
        }
    }

    private static InetAddress[] j() {
        String hostAddress;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
            ArrayList arrayList = new ArrayList(5);
            while (true) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf("]: [");
                if (indexOf != -1 && indexOf + 4 + 7 <= readLine.length() - 1) {
                    String substring = readLine.substring(1, indexOf);
                    String substring2 = readLine.substring(indexOf + 4, readLine.length() - 1);
                    if (substring.endsWith(".dns") || substring.endsWith(".dns1") || substring.endsWith(".dns2") || substring.endsWith(".dns3") || substring.endsWith(".dns4")) {
                        InetAddress byName = InetAddress.getByName(substring2);
                        if (byName != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0) {
                            arrayList.add(byName);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
            }
        } catch (IOException e) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", (Throwable) e);
        }
        return null;
    }

    private static InetAddress[] k() {
        InetAddress byName;
        String hostAddress;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            ArrayList arrayList = new ArrayList(5);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = (String) method.invoke(null, strArr[i]);
                if (str != null && str.length() != 0 && (byName = InetAddress.getByName(str)) != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0 && !arrayList.contains(byName)) {
                    arrayList.add(byName);
                }
            }
            if (arrayList.size() > 0) {
                return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
            }
        } catch (Exception e) {
            Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", (Throwable) e);
        }
        return null;
    }

    public static String b() {
        InetAddress[] k = k();
        if (k == null && (k = j()) == null) {
            return "";
        }
        String[] strArr = new String[k.length];
        String str = "";
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = k[i].toString();
            if (strArr[i].indexOf(47) == 0) {
                strArr[i] = strArr[i].substring(1);
                str = strArr[i];
            }
        }
        return str;
    }

    public static String c() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt > 31 && charAt < 127) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String d() {
        String str = Build.VERSION.RELEASE;
        return str == null ? "" : a(str.trim());
    }

    public static String e() {
        String trim = Build.MODEL.trim();
        String a2 = a(Build.MANUFACTURER.trim(), trim);
        if (TextUtils.isEmpty(a2)) {
            a2 = a(Build.BRAND.trim(), trim);
        }
        StringBuilder sb = new StringBuilder();
        if (a2 == null) {
            a2 = "";
        }
        return a(sb.append(a2).append(trim).toString()).replace(" ", b.a.a.a.a.d.b.ROLL_OVER_FILE_NAME_SEPARATOR);
    }

    private static String a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v35, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v36, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v50, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v58, types: [float] */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public static C0099a f() {
        C0099a c0099a;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        long parseLong;
        BufferedReader bufferedReader3;
        long parseLong2;
        long parseLong3;
        BufferedReader bufferedReader4;
        BufferedReader e = 0;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/stat"));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
        } catch (Exception e3) {
        }
        try {
            String[] split = bufferedReader.readLine().split("[ ]+", 9);
            long parseLong4 = Long.parseLong(split[1]) + Long.parseLong(split[2]) + Long.parseLong(split[3]);
            long parseLong5 = Long.parseLong(split[4]) + parseLong4 + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                }
            }
            e = 0;
            try {
                try {
                    bufferedReader2 = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/stat"));
                } catch (IOException e5) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                String[] split2 = bufferedReader2.readLine().split("[ ]+", 18);
                parseLong = Long.parseLong(split2[13]) + Long.parseLong(split2[14]) + Long.parseLong(split2[15]) + Long.parseLong(split2[16]);
                bufferedReader2.close();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e6) {
                    }
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e7) {
                }
                e = 0;
                try {
                    try {
                        bufferedReader3 = new BufferedReader(new FileReader("/proc/stat"));
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e8) {
                }
            } catch (IOException e9) {
                e = bufferedReader2;
                c0099a = new C0099a(0.0f, 0.0f);
                if (e != 0) {
                    try {
                        e.close();
                    } catch (IOException e10) {
                        e = e10;
                    }
                }
                return c0099a;
            } catch (Throwable th4) {
                e = bufferedReader2;
                th = th4;
                if (e != null) {
                    try {
                        e.close();
                    } catch (IOException e11) {
                    }
                }
                throw th;
            }
            try {
                String[] split3 = bufferedReader3.readLine().split("[ ]+", 9);
                parseLong2 = Long.parseLong(split3[1]) + Long.parseLong(split3[2]) + Long.parseLong(split3[3]);
                parseLong3 = Long.parseLong(split3[4]) + parseLong2 + Long.parseLong(split3[5]) + Long.parseLong(split3[6]) + Long.parseLong(split3[7]);
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e12) {
                    }
                }
                e = 0;
                e = 0;
                try {
                    try {
                        bufferedReader4 = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/stat"));
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (IOException e13) {
                }
            } catch (IOException e14) {
                e = bufferedReader3;
                c0099a = new C0099a(0.0f, 0.0f);
                if (e != 0) {
                    try {
                        e.close();
                    } catch (IOException e15) {
                        e = e15;
                    }
                }
                return c0099a;
            } catch (Throwable th6) {
                e = bufferedReader3;
                th = th6;
                if (e != null) {
                    try {
                        e.close();
                    } catch (IOException e16) {
                    }
                }
                throw th;
            }
            try {
                String[] split4 = bufferedReader4.readLine().split("[ ]+", 18);
                long parseLong6 = Long.parseLong(split4[13]) + Long.parseLong(split4[14]) + Long.parseLong(split4[15]) + Long.parseLong(split4[16]);
                bufferedReader4.close();
                if (bufferedReader4 != null) {
                    try {
                        bufferedReader4.close();
                    } catch (IOException e17) {
                    }
                }
                long j = parseLong3 - parseLong5;
                float f = ((float) ((parseLong2 - parseLong4) * 100)) / ((float) j);
                e = ((float) ((parseLong6 - parseLong) * 100)) / ((float) j);
                if (f < 0.0f || f > 100.0f) {
                    e = 0;
                    c0099a = new C0099a(0.0f, 0.0f);
                } else {
                    c0099a = new C0099a(f, e);
                }
            } catch (IOException e18) {
                e = bufferedReader4;
                c0099a = new C0099a(0.0f, 0.0f);
                if (e != 0) {
                    try {
                        e.close();
                    } catch (IOException e19) {
                        e = e19;
                    }
                }
                return c0099a;
            } catch (Throwable th7) {
                e = bufferedReader4;
                th = th7;
                if (e != 0) {
                    try {
                        e.close();
                    } catch (IOException e20) {
                    }
                }
                throw th;
            }
        } catch (IOException e21) {
            e = bufferedReader;
            c0099a = new C0099a(0.0f, 0.0f);
            if (e != 0) {
                try {
                    e.close();
                } catch (IOException e22) {
                    e = e22;
                }
            }
            return c0099a;
        } catch (Exception e23) {
            e = bufferedReader;
            c0099a = new C0099a(0.0f, 0.0f);
            if (e != 0) {
                try {
                    e.close();
                } catch (IOException e24) {
                    e = e24;
                }
            }
            return c0099a;
        } catch (Throwable th8) {
            e = bufferedReader;
            th = th8;
            if (e != null) {
                try {
                    e.close();
                } catch (IOException e25) {
                }
            }
            throw th;
        }
        return c0099a;
    }

    @TargetApi(16)
    public static b b(Context context) {
        if (Build.VERSION.SDK_INT < 16) {
            return new b(0L, 0L, 0L, 0L);
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return new b(0L, 0L, 0L, 0L);
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        Debug.MemoryInfo memoryInfo2 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo2);
        int i = memoryInfo2.dalvikPrivateDirty;
        return new b(memoryInfo.totalMem, memoryInfo.totalMem - memoryInfo.availMem, memoryInfo.threshold, (memoryInfo2.nativePrivateDirty + i) * 1024);
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "None";
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                return "None";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            return activeNetworkInfo.getSubtypeName();
        } catch (Exception e) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    public static String e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    /* compiled from: Util.java */
    /* renamed from: com.pili.pldroid.player.report.common.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0099a {

        /* renamed from: a  reason: collision with root package name */
        public final float f5050a;

        /* renamed from: b  reason: collision with root package name */
        public final float f5051b;

        public C0099a(float f, float f2) {
            this.f5050a = f;
            this.f5051b = f2;
        }
    }

    /* compiled from: Util.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f5052a;

        /* renamed from: b  reason: collision with root package name */
        public final long f5053b;

        /* renamed from: c  reason: collision with root package name */
        public final long f5054c;
        public final long d;

        public b(long j, long j2, long j3, long j4) {
            this.f5052a = j;
            this.f5053b = j2;
            this.d = j3;
            this.f5054c = j4;
        }
    }

    public static boolean f(Context context) {
        return context != null && context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static boolean g(Context context) {
        return context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0;
    }

    public static String[] h(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        if (!g(context) || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return null;
        }
        return new String[]{connectionInfo.getSSID(), Integer.toString(connectionInfo.getRssi())};
    }

    public static String[] i(Context context) {
        String[] strArr;
        if (context == null || !f(context) || Build.VERSION.SDK_INT <= 17) {
            strArr = null;
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (telephonyManager == null) {
                return null;
            }
            String[] strArr2 = {"", ""};
            strArr2[0] = telephonyManager.getNetworkOperatorName();
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo != null) {
                for (int i = 0; i < allCellInfo.size(); i++) {
                    if (allCellInfo.get(i).isRegistered()) {
                        CellInfo cellInfo = allCellInfo.get(i);
                        if (cellInfo instanceof CellInfoCdma) {
                            strArr2[1] = String.valueOf(((CellInfoCdma) cellInfo).getCellSignalStrength().getLevel());
                        } else if (cellInfo instanceof CellInfoWcdma) {
                            strArr2[1] = String.valueOf(((CellInfoWcdma) cellInfo).getCellSignalStrength().getLevel());
                        } else if (cellInfo instanceof CellInfoGsm) {
                            strArr2[1] = String.valueOf(((CellInfoGsm) cellInfo).getCellSignalStrength().getLevel());
                        } else if (cellInfo instanceof CellInfoLte) {
                            strArr2[1] = String.valueOf(((CellInfoLte) cellInfo).getCellSignalStrength().getLevel());
                        }
                    }
                }
            }
            strArr = strArr2;
        }
        return strArr;
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$");
    }

    public static void g() {
        if (Build.VERSION.SDK_INT >= 16) {
            com.pili.pldroid.player.report.core.a.f5055a.a();
            try {
                Choreographer.getInstance().postFrameCallback(com.pili.pldroid.player.report.core.a.f5055a);
            } catch (RuntimeException e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public static void h() {
        if (Build.VERSION.SDK_INT >= 16) {
            com.pili.pldroid.player.report.core.a.f5055a.b();
        }
    }

    public static int i() {
        if (Build.VERSION.SDK_INT >= 16) {
            return com.pili.pldroid.player.report.core.a.f5055a.c();
        }
        return 60;
    }
}
