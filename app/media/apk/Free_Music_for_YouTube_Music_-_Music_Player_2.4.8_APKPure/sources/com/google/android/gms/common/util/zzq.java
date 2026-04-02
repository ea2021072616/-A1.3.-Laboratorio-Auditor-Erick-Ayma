package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public final class zzq {
    private static String zzfyz = null;
    private static final int zzfza = Process.myPid();

    public static String zzalk() {
        if (zzfyz == null) {
            zzfyz = zzcg(zzfza);
        }
        return zzfyz;
    }

    private static String zzcg(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        String str = null;
        if (i > 0) {
            try {
                allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    bufferedReader = new BufferedReader(new FileReader(new StringBuilder(25).append("/proc/").append(i).append("/cmdline").toString()));
                } finally {
                }
            } catch (IOException e) {
                bufferedReader = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
            try {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                str = bufferedReader.readLine().trim();
                zzm.closeQuietly(bufferedReader);
            } catch (IOException e2) {
                zzm.closeQuietly(bufferedReader);
                return str;
            } catch (Throwable th3) {
                th = th3;
                zzm.closeQuietly(bufferedReader);
                throw th;
            }
        }
        return str;
    }
}
