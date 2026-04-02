package com.flurry.sdk;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class lk {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Class<?>> f2149a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final String f2150b = lk.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, Object> f2151c = new LinkedHashMap();

    public lk() {
        ArrayList<Class<?>> arrayList;
        synchronized (f2149a) {
            arrayList = new ArrayList(f2149a);
        }
        for (Class<?> cls : arrayList) {
            try {
                Object newInstance = cls.newInstance();
                synchronized (this.f2151c) {
                    this.f2151c.put(cls, newInstance);
                }
            } catch (Exception e) {
                km.a(5, this.f2150b, "Module data " + cls + " is not available:", e);
            }
        }
    }

    public static void a(Class<?> cls) {
        synchronized (f2149a) {
            f2149a.add(cls);
        }
    }

    public final Object b(Class<?> cls) {
        Object obj;
        synchronized (this.f2151c) {
            obj = this.f2151c.get(cls);
        }
        return obj;
    }
}
