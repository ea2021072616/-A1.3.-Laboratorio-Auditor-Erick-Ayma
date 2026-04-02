package com.acrcloud.rec.b.a;

import com.acrcloud.rec.b.b.h;
import com.acrcloud.rec.b.b.i;
import java.util.Map;
/* compiled from: ACRCloudRecognizerBothImpl.java */
/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private com.acrcloud.rec.b.b f326a;

    /* renamed from: b  reason: collision with root package name */
    private String f327b;

    /* renamed from: c  reason: collision with root package name */
    private d f328c;
    private d d;
    private boolean e = false;
    private boolean f = false;

    public a(com.acrcloud.rec.b.b bVar, String str) {
        this.f326a = null;
        this.f327b = "";
        this.f328c = null;
        this.d = null;
        this.f326a = bVar;
        this.f327b = str;
        this.f328c = new b(this.f326a, this.f327b);
        this.d = new c(this.f326a, this.f327b);
    }

    @Override // com.acrcloud.rec.b.a.d
    public i a(Map<String, String> map) {
        this.e = true;
        this.f = false;
        this.f328c.a(map);
        i a2 = this.d.a(map);
        if (a2.c() == 0) {
            this.f = true;
        }
        return a2;
    }

    @Override // com.acrcloud.rec.b.a.d
    public i a(byte[] bArr, int i, Map<String, Object> map, Map<String, String> map2, int i2) {
        i iVar = null;
        if (this.e) {
            iVar = this.f328c.a(bArr, i, map, map2, i2);
            if (iVar.c() == 0) {
                return iVar;
            }
        }
        if (this.f) {
            return this.d.a(bArr, i, map, map2, i2);
        }
        return iVar;
    }

    @Override // com.acrcloud.rec.b.a.d
    public void a() throws com.acrcloud.rec.b.b.a {
        try {
            this.f328c.a();
        } catch (com.acrcloud.rec.b.b.a e) {
            this.f328c = null;
            h.a("ACRCloudRecognizerBothImpl", "ACRCloud local library init error, " + e.toString());
        }
        this.d.a();
    }

    @Override // com.acrcloud.rec.b.a.d
    public void b() {
        if (this.f328c != null) {
            this.f328c.b();
        }
        if (this.d != null) {
            this.d.b();
        }
    }
}
