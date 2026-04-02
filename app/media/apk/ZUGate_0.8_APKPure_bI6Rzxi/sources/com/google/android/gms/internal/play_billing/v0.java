package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
/* loaded from: classes.dex */
public enum v0 {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(z.class, z.f1994c),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);
    

    /* renamed from: b  reason: collision with root package name */
    public final Object f1979b;

    v0(Class cls, Serializable serializable) {
        this.f1979b = serializable;
    }
}
