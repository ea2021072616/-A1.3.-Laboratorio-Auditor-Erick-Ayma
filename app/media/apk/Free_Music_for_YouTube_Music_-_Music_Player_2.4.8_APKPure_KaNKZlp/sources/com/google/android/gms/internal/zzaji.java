package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;
@zzzt
/* loaded from: classes.dex */
public class zzaji {
    public static void e(String str) {
        if (zzad(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void zza(String str, Throwable th) {
        if (zzad(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean zzad(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }

    public static void zzb(String str, Throwable th) {
        if (zzad(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (zzad(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzcb(String str) {
        if (zzad(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void zzcr(String str) {
        if (zzad(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void zzcs(String str) {
        if (zzad(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
