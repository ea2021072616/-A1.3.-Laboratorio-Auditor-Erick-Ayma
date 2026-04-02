package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class zzdeh {
    private static HashMap<String, String> zzkvs;
    private static Object zzkvx;
    private static boolean zzkvy;
    private static Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static Uri zzkvo = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static Pattern zzkvp = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static Pattern zzkvq = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzkvr = new AtomicBoolean();
    private static HashMap<String, Boolean> zzkvt = new HashMap<>();
    private static HashMap<String, Integer> zzkvu = new HashMap<>();
    private static HashMap<String, Long> zzkvv = new HashMap<>();
    private static HashMap<String, Float> zzkvw = new HashMap<>();
    private static String[] zzkvz = new String[0];

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        Long l;
        long j2;
        Object zzb = zzb(contentResolver);
        Long l2 = (Long) zza((HashMap<String, long>) zzkvv, str, 0L);
        if (l2 != null) {
            return l2.longValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza == null) {
            l = l2;
            j2 = 0;
        } else {
            try {
                long parseLong = Long.parseLong(zza);
                l = Long.valueOf(parseLong);
                j2 = parseLong;
            } catch (NumberFormatException e) {
                l = l2;
                j2 = 0;
            }
        }
        HashMap<String, Long> hashMap = zzkvv;
        synchronized (zzdeh.class) {
            if (zzb == zzkvx) {
                hashMap.put(str, l);
                zzkvs.remove(str);
            }
        }
        return j2;
    }

    private static <T> T zza(HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzdeh.class) {
            if (hashMap.containsKey(str)) {
                T t2 = hashMap.get(str);
                if (t2 == null) {
                    t2 = t;
                }
                return t2;
            }
            return null;
        }
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzdeh.class) {
            zza(contentResolver);
            Object obj = zzkvx;
            if (zzkvs.containsKey(str)) {
                String str3 = zzkvs.get(str);
                r2 = str3 != null ? str3 : null;
            } else {
                String[] strArr = zzkvz;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                        if (query != null) {
                            try {
                                if (query.moveToFirst()) {
                                    String string = query.getString(1);
                                    if (string != null && string.equals(null)) {
                                        string = null;
                                    }
                                    zza(obj, str, string);
                                    r2 = string != null ? string : null;
                                    if (query != null) {
                                        query.close();
                                    }
                                }
                            } catch (Throwable th) {
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        }
                        zza(obj, str, (String) null);
                        if (query != null) {
                            query.close();
                        }
                    } else if (!str.startsWith(strArr[i])) {
                        i++;
                    } else if (!zzkvy || zzkvs.isEmpty()) {
                        zzc(contentResolver, zzkvz);
                        if (zzkvs.containsKey(str)) {
                            String str4 = zzkvs.get(str);
                            r2 = str4 != null ? str4 : null;
                        }
                    }
                }
            }
        }
        return r2;
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzkvo, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzkvs == null) {
            zzkvr.set(false);
            zzkvs = new HashMap<>();
            zzkvx = new Object();
            zzkvy = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzdei(null));
        } else if (zzkvr.getAndSet(false)) {
            zzkvs.clear();
            zzkvt.clear();
            zzkvu.clear();
            zzkvv.clear();
            zzkvw.clear();
            zzkvx = new Object();
            zzkvy = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzdeh.class) {
            if (obj == zzkvx) {
                zzkvs.put(str, str2);
            }
        }
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzdeh.class) {
            zza(contentResolver);
            obj = zzkvx;
        }
        return obj;
    }

    public static void zzb(ContentResolver contentResolver, String... strArr) {
        String[] strArr2;
        if (strArr.length == 0) {
            return;
        }
        synchronized (zzdeh.class) {
            zza(contentResolver);
            HashSet hashSet = new HashSet((((zzkvz.length + strArr.length) << 2) / 3) + 1);
            hashSet.addAll(Arrays.asList(zzkvz));
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (hashSet.add(str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                strArr2 = new String[0];
            } else {
                zzkvz = (String[]) hashSet.toArray(new String[hashSet.size()]);
                strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            if (!zzkvy || zzkvs.isEmpty()) {
                zzc(contentResolver, zzkvz);
            } else if (strArr2.length != 0) {
                zzc(contentResolver, strArr2);
            }
        }
    }

    private static void zzc(ContentResolver contentResolver, String[] strArr) {
        zzkvs.putAll(zza(contentResolver, strArr));
        zzkvy = true;
    }
}
