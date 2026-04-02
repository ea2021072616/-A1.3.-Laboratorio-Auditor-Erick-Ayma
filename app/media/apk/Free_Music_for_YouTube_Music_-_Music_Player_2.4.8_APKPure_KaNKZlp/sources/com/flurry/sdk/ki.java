package com.flurry.sdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class ki {

    /* renamed from: a  reason: collision with root package name */
    private static ki f2044a = null;

    /* renamed from: b  reason: collision with root package name */
    private final kd<String, kv<kh<?>>> f2045b = new kd<>();

    /* renamed from: c  reason: collision with root package name */
    private final kd<kv<kh<?>>, String> f2046c = new kd<>();

    private ki() {
    }

    public static synchronized ki a() {
        ki kiVar;
        synchronized (ki.class) {
            if (f2044a == null) {
                f2044a = new ki();
            }
            kiVar = f2044a;
        }
        return kiVar;
    }

    public final synchronized void a(String str, kh<?> khVar) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && khVar != null) {
                kv<kh<?>> kvVar = new kv<>(khVar);
                List<kv<kh<?>>> a2 = this.f2045b.a((kd<String, kv<kh<?>>>) str, false);
                if (!(a2 != null ? a2.contains(kvVar) : false)) {
                    this.f2045b.a((kd<String, kv<kh<?>>>) str, (String) kvVar);
                    this.f2046c.a((kd<kv<kh<?>>, String>) kvVar, (kv<kh<?>>) str);
                }
            }
        }
    }

    public final synchronized void b(String str, kh<?> khVar) {
        if (!TextUtils.isEmpty(str)) {
            kv<kh<?>> kvVar = new kv<>(khVar);
            this.f2045b.b(str, kvVar);
            this.f2046c.b(kvVar, str);
        }
    }

    public final synchronized void a(kh<?> khVar) {
        if (khVar != null) {
            kv<kh<?>> kvVar = new kv<>(khVar);
            for (String str : this.f2046c.a((kd<kv<kh<?>>, String>) kvVar)) {
                this.f2045b.b(str, kvVar);
            }
            this.f2046c.b(kvVar);
        }
    }

    public final synchronized int a(String str) {
        return TextUtils.isEmpty(str) ? 0 : this.f2045b.a((kd<String, kv<kh<?>>>) str).size();
    }

    public final void a(final kg kgVar) {
        if (kgVar != null) {
            for (final kh<?> khVar : b(kgVar.a())) {
                jy.a().b(new ma() { // from class: com.flurry.sdk.ki.1
                    @Override // com.flurry.sdk.ma
                    public final void a() {
                        khVar.a(kgVar);
                    }
                });
            }
        }
    }

    private synchronized List<kh<?>> b(String str) {
        List<kh<?>> list;
        if (TextUtils.isEmpty(str)) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<kv<kh<?>>> it = this.f2045b.a((kd<String, kv<kh<?>>>) str).iterator();
            while (it.hasNext()) {
                kh khVar = (kh) it.next().get();
                if (khVar == null) {
                    it.remove();
                } else {
                    arrayList.add(khVar);
                }
            }
            list = arrayList;
        }
        return list;
    }
}
