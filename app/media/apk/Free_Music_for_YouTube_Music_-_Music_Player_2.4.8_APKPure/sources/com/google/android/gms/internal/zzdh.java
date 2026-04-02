package com.google.android.gms.internal;

import android.os.Looper;
import android.util.DisplayMetrics;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class zzdh {
    private static final char[] zzajh = "0123456789abcdef".toCharArray();

    public static long zza(double d, int i, DisplayMetrics displayMetrics) {
        return Math.round((i * d) / displayMetrics.density);
    }

    public static String zza(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        ThrowableExtension.printStackTrace(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean zza(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    public static Long zzap() {
        return Long.valueOf(Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles")).getTime().getTime());
    }

    public static boolean zzaq() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String zzn(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID fromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(fromString.getMostSignificantBits());
        wrap.putLong(fromString.getLeastSignificantBits());
        return zzbt.zza(bArr, true);
    }

    public static boolean zzo(String str) {
        return str == null || str.isEmpty();
    }
}
