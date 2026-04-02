package com.facebook.ads.internal.i.a;
/* loaded from: classes.dex */
public enum j {
    GET(true, false),
    POST(true, true);
    

    /* renamed from: c  reason: collision with root package name */
    private boolean f1390c;
    private boolean d;

    j(boolean z, boolean z2) {
        this.f1390c = z;
        this.d = z2;
    }

    public boolean a() {
        return this.f1390c;
    }

    public boolean b() {
        return this.d;
    }

    public String c() {
        return toString();
    }
}
