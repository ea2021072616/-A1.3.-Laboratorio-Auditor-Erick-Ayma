package com.bumptech.glide.i;
/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f731a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f732b;

    public g() {
    }

    public g(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }

    public void a(Class<?> cls, Class<?> cls2) {
        this.f731a = cls;
        this.f732b = cls2;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f731a + ", second=" + this.f732b + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f731a.equals(gVar.f731a) && this.f732b.equals(gVar.f732b);
    }

    public int hashCode() {
        return (this.f731a.hashCode() * 31) + this.f732b.hashCode();
    }
}
