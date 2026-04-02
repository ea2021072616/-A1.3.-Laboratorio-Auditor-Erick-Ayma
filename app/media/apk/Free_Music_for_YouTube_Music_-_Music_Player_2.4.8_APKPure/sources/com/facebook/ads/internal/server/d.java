package com.facebook.ads.internal.server;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private com.facebook.ads.internal.f.d f1462a;

    /* renamed from: b  reason: collision with root package name */
    private a f1463b;

    /* loaded from: classes.dex */
    public enum a {
        UNKNOWN,
        ERROR,
        ADS
    }

    public d(a aVar, com.facebook.ads.internal.f.d dVar) {
        this.f1463b = aVar;
        this.f1462a = dVar;
    }

    public a a() {
        return this.f1463b;
    }

    public com.facebook.ads.internal.f.d b() {
        return this.f1462a;
    }
}
