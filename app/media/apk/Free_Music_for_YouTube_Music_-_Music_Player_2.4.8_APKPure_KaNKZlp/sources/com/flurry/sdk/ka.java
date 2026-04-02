package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ka {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2026a = ka.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, Map<String, String>> f2027b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static ka f2028c;

    public static synchronized ka a() {
        ka kaVar;
        synchronized (ka.class) {
            if (f2028c == null) {
                f2028c = new ka();
            }
            kaVar = f2028c;
        }
        return kaVar;
    }

    public final synchronized void a(String str, String str2, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (map.size() >= 10) {
            km.e(f2026a, "MaxOriginParams exceeded: " + map.size());
        } else {
            map.put("flurryOriginVersion", str2);
            synchronized (f2027b) {
                if (f2027b.size() >= 10 && !f2027b.containsKey(str)) {
                    km.e(f2026a, "MaxOrigins exceeded: " + f2027b.size());
                } else {
                    f2027b.put(str, map);
                }
            }
        }
    }

    public final synchronized HashMap<String, Map<String, String>> b() {
        HashMap<String, Map<String, String>> hashMap;
        synchronized (f2027b) {
            hashMap = new HashMap<>(f2027b);
        }
        return hashMap;
    }
}
