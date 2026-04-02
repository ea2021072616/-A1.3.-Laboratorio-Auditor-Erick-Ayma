package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes.dex */
public final class zzj {
    private static long zzfys;
    private static IntentFilter zzfyr = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static float zzfyt = Float.NaN;

    @TargetApi(20)
    public static int zzcn(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzfyr);
        boolean z = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((zzp.zzali() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << 1) | (z ? 1 : 0);
    }

    public static synchronized float zzco(Context context) {
        float f;
        synchronized (zzj.class) {
            if (SystemClock.elapsedRealtime() - zzfys >= 60000 || Float.isNaN(zzfyt)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzfyr);
                if (registerReceiver != null) {
                    zzfyt = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
                }
                zzfys = SystemClock.elapsedRealtime();
                f = zzfyt;
            } else {
                f = zzfyt;
            }
        }
        return f;
    }
}
