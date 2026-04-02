package com.google.android.gms.internal;

import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
/* loaded from: classes.dex */
public final class zzam {
    public static String zza(Map<String, String> map) {
        String str = map.get("Content-Type");
        if (str != null) {
            String[] split = str.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return "ISO-8859-1";
    }

    public static zzc zzb(zzn zznVar) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zznVar.zzy;
        long j3 = 0;
        long j4 = 0;
        String str = map.get("Date");
        long zzf = str != null ? zzf(str) : 0L;
        String str2 = map.get("Cache-Control");
        if (str2 != null) {
            String[] split = str2.split(",");
            z = false;
            long j5 = 0;
            long j6 = 0;
            for (String str3 : split) {
                String trim = str3.trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j6 = Long.parseLong(trim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    try {
                        j5 = Long.parseLong(trim.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
            }
            j3 = j6;
            j4 = j5;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        String str4 = map.get("Expires");
        long zzf2 = str4 != null ? zzf(str4) : 0L;
        String str5 = map.get("Last-Modified");
        long zzf3 = str5 != null ? zzf(str5) : 0L;
        String str6 = map.get("ETag");
        if (z2) {
            j2 = currentTimeMillis + (1000 * j3);
            j = z ? j2 : (1000 * j4) + j2;
        } else if (zzf <= 0 || zzf2 < zzf) {
            j = 0;
            j2 = 0;
        } else {
            j = (zzf2 - zzf) + currentTimeMillis;
            j2 = j;
        }
        zzc zzcVar = new zzc();
        zzcVar.data = zznVar.data;
        zzcVar.zza = str6;
        zzcVar.zze = j2;
        zzcVar.zzd = j;
        zzcVar.zzb = zzf;
        zzcVar.zzc = zzf3;
        zzcVar.zzf = map;
        return zzcVar;
    }

    private static long zzf(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0L;
        }
    }
}
