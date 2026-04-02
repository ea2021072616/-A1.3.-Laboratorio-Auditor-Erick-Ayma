package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class ko {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2071a = ko.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<? extends kp>, kn> f2072b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<? extends kp>, kp> f2073c = new LinkedHashMap();

    public static void a(Class<? extends kp> cls) {
        if (cls != null) {
            synchronized (f2072b) {
                f2072b.put(cls, new kn(cls));
            }
        }
    }

    public final synchronized void a(Context context) {
        ArrayList<kn> arrayList;
        if (context == null) {
            km.a(5, f2071a, "Null context.");
        } else {
            synchronized (f2072b) {
                arrayList = new ArrayList(f2072b.values());
            }
            for (kn knVar : arrayList) {
                try {
                    if (knVar.f2069a != null && Build.VERSION.SDK_INT >= knVar.f2070b) {
                        kp newInstance = knVar.f2069a.newInstance();
                        newInstance.a(context);
                        this.f2073c.put(knVar.f2069a, newInstance);
                    }
                } catch (Exception e) {
                    km.a(5, f2071a, "Flurry Module for class " + knVar.f2069a + " is not available:", e);
                }
            }
            lm.a().a(context);
            kc.a();
        }
    }

    public final kp b(Class<? extends kp> cls) {
        kp kpVar;
        if (cls == null) {
            return null;
        }
        synchronized (this.f2073c) {
            kpVar = this.f2073c.get(cls);
        }
        if (kpVar == null) {
            throw new IllegalStateException("Module was not registered/initialized. " + cls);
        }
        return kpVar;
    }
}
