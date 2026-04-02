package com.facebook.ads.internal.i.a;
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    protected String f1391a;

    /* renamed from: b  reason: collision with root package name */
    protected j f1392b;

    /* renamed from: c  reason: collision with root package name */
    protected String f1393c;
    protected byte[] d;

    public l(String str, p pVar) {
        this.f1391a = "";
        if (str != null) {
            this.f1391a = str;
        }
        if (pVar != null) {
            this.f1391a += "?" + pVar.a();
        }
    }

    public String a() {
        return this.f1391a;
    }

    public j b() {
        return this.f1392b;
    }

    public String c() {
        return this.f1393c;
    }

    public byte[] d() {
        return this.d;
    }
}
