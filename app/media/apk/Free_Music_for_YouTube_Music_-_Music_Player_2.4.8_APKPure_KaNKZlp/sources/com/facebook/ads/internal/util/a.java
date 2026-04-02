package com.facebook.ads.internal.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.os.StatFs;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile float[] d;
    private static volatile float[] e;

    /* renamed from: a  reason: collision with root package name */
    private static SensorManager f1471a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Sensor f1472b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Sensor f1473c = null;
    private static Map<String, String> f = new ConcurrentHashMap();
    private static String[] g = {"x", "y", "z"};

    /* renamed from: com.facebook.ads.internal.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0040a implements SensorEventListener {
        private C0040a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor == a.f1472b) {
                float[] unused = a.d = sensorEvent.values;
            } else if (sensorEvent.sensor == a.f1473c) {
                float[] unused2 = a.e = sensorEvent.values;
            }
            a.a(this);
        }
    }

    public static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f);
        a(hashMap);
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (com.facebook.ads.internal.util.a.f1471a == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void a(android.content.Context r5) {
        /*
            java.lang.Class<com.facebook.ads.internal.util.a> r1 = com.facebook.ads.internal.util.a.class
            monitor-enter(r1)
            b(r5)     // Catch: java.lang.Throwable -> L5f
            c(r5)     // Catch: java.lang.Throwable -> L5f
            d(r5)     // Catch: java.lang.Throwable -> L5f
            android.hardware.SensorManager r0 = com.facebook.ads.internal.util.a.f1471a     // Catch: java.lang.Throwable -> L5f
            if (r0 != 0) goto L20
            java.lang.String r0 = "sensor"
            java.lang.Object r0 = r5.getSystemService(r0)     // Catch: java.lang.Throwable -> L5f
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0     // Catch: java.lang.Throwable -> L5f
            com.facebook.ads.internal.util.a.f1471a = r0     // Catch: java.lang.Throwable -> L5f
            android.hardware.SensorManager r0 = com.facebook.ads.internal.util.a.f1471a     // Catch: java.lang.Throwable -> L5f
            if (r0 != 0) goto L20
        L1e:
            monitor-exit(r1)
            return
        L20:
            android.hardware.Sensor r0 = com.facebook.ads.internal.util.a.f1472b     // Catch: java.lang.Throwable -> L5f
            if (r0 != 0) goto L2d
            android.hardware.SensorManager r0 = com.facebook.ads.internal.util.a.f1471a     // Catch: java.lang.Throwable -> L5f
            r2 = 1
            android.hardware.Sensor r0 = r0.getDefaultSensor(r2)     // Catch: java.lang.Throwable -> L5f
            com.facebook.ads.internal.util.a.f1472b = r0     // Catch: java.lang.Throwable -> L5f
        L2d:
            android.hardware.Sensor r0 = com.facebook.ads.internal.util.a.f1473c     // Catch: java.lang.Throwable -> L5f
            if (r0 != 0) goto L3a
            android.hardware.SensorManager r0 = com.facebook.ads.internal.util.a.f1471a     // Catch: java.lang.Throwable -> L5f
            r2 = 4
            android.hardware.Sensor r0 = r0.getDefaultSensor(r2)     // Catch: java.lang.Throwable -> L5f
            com.facebook.ads.internal.util.a.f1473c = r0     // Catch: java.lang.Throwable -> L5f
        L3a:
            android.hardware.Sensor r0 = com.facebook.ads.internal.util.a.f1472b     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L4c
            android.hardware.SensorManager r0 = com.facebook.ads.internal.util.a.f1471a     // Catch: java.lang.Throwable -> L5f
            com.facebook.ads.internal.util.a$a r2 = new com.facebook.ads.internal.util.a$a     // Catch: java.lang.Throwable -> L5f
            r3 = 0
            r2.<init>()     // Catch: java.lang.Throwable -> L5f
            android.hardware.Sensor r3 = com.facebook.ads.internal.util.a.f1472b     // Catch: java.lang.Throwable -> L5f
            r4 = 3
            r0.registerListener(r2, r3, r4)     // Catch: java.lang.Throwable -> L5f
        L4c:
            android.hardware.Sensor r0 = com.facebook.ads.internal.util.a.f1473c     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L1e
            android.hardware.SensorManager r0 = com.facebook.ads.internal.util.a.f1471a     // Catch: java.lang.Throwable -> L5f
            com.facebook.ads.internal.util.a$a r2 = new com.facebook.ads.internal.util.a$a     // Catch: java.lang.Throwable -> L5f
            r3 = 0
            r2.<init>()     // Catch: java.lang.Throwable -> L5f
            android.hardware.Sensor r3 = com.facebook.ads.internal.util.a.f1473c     // Catch: java.lang.Throwable -> L5f
            r4 = 3
            r0.registerListener(r2, r3, r4)     // Catch: java.lang.Throwable -> L5f
            goto L1e
        L5f:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.util.a.a(android.content.Context):void");
    }

    public static synchronized void a(C0040a c0040a) {
        synchronized (a.class) {
            if (f1471a != null) {
                f1471a.unregisterListener(c0040a);
            }
        }
    }

    private static void a(Map<String, String> map) {
        float[] fArr = d;
        float[] fArr2 = e;
        if (fArr != null) {
            int min = Math.min(g.length, fArr.length);
            for (int i = 0; i < min; i++) {
                map.put("accelerometer_" + g[i], String.valueOf(fArr[i]));
            }
        }
        if (fArr2 != null) {
            int min2 = Math.min(g.length, fArr2.length);
            for (int i2 = 0; i2 < min2; i2++) {
                map.put("rotation_" + g[i2], String.valueOf(fArr2[i2]));
            }
        }
    }

    private static void b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        f.put("available_memory", String.valueOf(memoryInfo.availMem));
    }

    private static void c(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        f.put("free_space", String.valueOf(statFs.getAvailableBlocks() * statFs.getBlockSize()));
    }

    private static void d(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return;
        }
        int intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        int intExtra3 = registerReceiver.getIntExtra("status", -1);
        boolean z = intExtra3 == 2 || intExtra3 == 5;
        f.put("battery", String.valueOf(intExtra2 > 0 ? (intExtra / intExtra2) * 100.0f : 0.0f));
        f.put("charging", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }
}
