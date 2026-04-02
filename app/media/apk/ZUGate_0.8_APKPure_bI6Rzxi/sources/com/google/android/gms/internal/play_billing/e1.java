package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class e1 extends LinkedHashMap {

    /* renamed from: c  reason: collision with root package name */
    public static final e1 f1856c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1857b;

    static {
        e1 e1Var = new e1();
        f1856c = e1Var;
        e1Var.f1857b = false;
    }

    public e1() {
        this.f1857b = true;
    }

    public static e1 a() {
        return f1856c;
    }

    public static int e(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof n0) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = s0.f1953a;
        int length = bArr.length;
        for (byte b5 : bArr) {
            length = (length * 31) + b5;
        }
        if (length == 0) {
            return 1;
        }
        return length;
    }

    public final e1 b() {
        return isEmpty() ? new e1() : new e1(this);
    }

    public final void c() {
        this.f1857b = false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        f();
        super.clear();
    }

    public final boolean d() {
        return this.f1857b;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this == map) {
                return true;
            }
            if (size() != map.size()) {
                return false;
            }
            for (Map.Entry entry : entrySet()) {
                if (!map.containsKey(entry.getKey())) {
                    return false;
                }
                Object value = entry.getValue();
                Object obj2 = map.get(entry.getKey());
                if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                    equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                    continue;
                } else {
                    equals = value.equals(obj2);
                    continue;
                }
                if (!equals) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final void f() {
        if (!this.f1857b) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i5 = 0;
        for (Map.Entry entry : entrySet()) {
            i5 += e(entry.getValue()) ^ e(entry.getKey());
        }
        return i5;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        f();
        Charset charset = s0.f1953a;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        f();
        for (Object obj : map.keySet()) {
            Charset charset = s0.f1953a;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        f();
        return super.remove(obj);
    }

    public e1(Map map) {
        super(map);
        this.f1857b = true;
    }
}
