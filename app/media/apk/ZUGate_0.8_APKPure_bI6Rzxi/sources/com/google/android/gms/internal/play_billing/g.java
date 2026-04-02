package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1868a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f1869b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f1870c;

    public g(Object obj, Object obj2, Object obj3) {
        this.f1868a = obj;
        this.f1869b = obj2;
        this.f1870c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f1868a;
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(this.f1869b);
        String valueOf3 = String.valueOf(obj);
        String valueOf4 = String.valueOf(this.f1870c);
        return new IllegalArgumentException("Multiple entries with same key: " + valueOf + "=" + valueOf2 + " and " + valueOf3 + "=" + valueOf4);
    }
}
