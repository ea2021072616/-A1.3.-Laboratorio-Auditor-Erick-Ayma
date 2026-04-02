package com.bumptech.glide.load.b;

import com.google.android.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f846a;

    /* renamed from: b  reason: collision with root package name */
    private final int f847b;

    /* renamed from: c  reason: collision with root package name */
    private final int f848c;
    private final com.bumptech.glide.load.e d;
    private final com.bumptech.glide.load.e e;
    private final com.bumptech.glide.load.g f;
    private final com.bumptech.glide.load.f g;
    private final com.bumptech.glide.load.resource.e.c h;
    private final com.bumptech.glide.load.b i;
    private final com.bumptech.glide.load.c j;
    private String k;
    private int l;
    private com.bumptech.glide.load.c m;

    public f(String str, com.bumptech.glide.load.c cVar, int i, int i2, com.bumptech.glide.load.e eVar, com.bumptech.glide.load.e eVar2, com.bumptech.glide.load.g gVar, com.bumptech.glide.load.f fVar, com.bumptech.glide.load.resource.e.c cVar2, com.bumptech.glide.load.b bVar) {
        this.f846a = str;
        this.j = cVar;
        this.f847b = i;
        this.f848c = i2;
        this.d = eVar;
        this.e = eVar2;
        this.f = gVar;
        this.g = fVar;
        this.h = cVar2;
        this.i = bVar;
    }

    public com.bumptech.glide.load.c a() {
        if (this.m == null) {
            this.m = new j(this.f846a, this.j);
        }
        return this.m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f846a.equals(fVar.f846a) && this.j.equals(fVar.j) && this.f848c == fVar.f848c && this.f847b == fVar.f847b) {
            if ((this.f == null) ^ (fVar.f == null)) {
                return false;
            }
            if (this.f == null || this.f.getId().equals(fVar.f.getId())) {
                if ((this.e == null) ^ (fVar.e == null)) {
                    return false;
                }
                if (this.e == null || this.e.a().equals(fVar.e.a())) {
                    if ((this.d == null) ^ (fVar.d == null)) {
                        return false;
                    }
                    if (this.d == null || this.d.a().equals(fVar.d.a())) {
                        if ((this.g == null) ^ (fVar.g == null)) {
                            return false;
                        }
                        if (this.g == null || this.g.a().equals(fVar.g.a())) {
                            if ((this.h == null) ^ (fVar.h == null)) {
                                return false;
                            }
                            if (this.h == null || this.h.a().equals(fVar.h.a())) {
                                if ((this.i == null) ^ (fVar.i == null)) {
                                    return false;
                                }
                                return this.i == null || this.i.a().equals(fVar.i.a());
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        if (this.l == 0) {
            this.l = this.f846a.hashCode();
            this.l = (this.l * 31) + this.j.hashCode();
            this.l = (this.l * 31) + this.f847b;
            this.l = (this.l * 31) + this.f848c;
            this.l = (this.d != null ? this.d.a().hashCode() : 0) + (this.l * 31);
            this.l = (this.e != null ? this.e.a().hashCode() : 0) + (this.l * 31);
            this.l = (this.f != null ? this.f.getId().hashCode() : 0) + (this.l * 31);
            this.l = (this.g != null ? this.g.a().hashCode() : 0) + (this.l * 31);
            this.l = (this.h != null ? this.h.a().hashCode() : 0) + (this.l * 31);
            this.l = (this.l * 31) + (this.i != null ? this.i.a().hashCode() : 0);
        }
        return this.l;
    }

    public String toString() {
        if (this.k == null) {
            this.k = "EngineKey{" + this.f846a + '+' + this.j + "+[" + this.f847b + 'x' + this.f848c + "]+'" + (this.d != null ? this.d.a() : "") + "'+'" + (this.e != null ? this.e.a() : "") + "'+'" + (this.f != null ? this.f.getId() : "") + "'+'" + (this.g != null ? this.g.a() : "") + "'+'" + (this.h != null ? this.h.a() : "") + "'+'" + (this.i != null ? this.i.a() : "") + "'}";
        }
        return this.k;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] array = ByteBuffer.allocate(8).putInt(this.f847b).putInt(this.f848c).array();
        this.j.a(messageDigest);
        messageDigest.update(this.f846a.getBytes(C.UTF8_NAME));
        messageDigest.update(array);
        messageDigest.update((this.d != null ? this.d.a() : "").getBytes(C.UTF8_NAME));
        messageDigest.update((this.e != null ? this.e.a() : "").getBytes(C.UTF8_NAME));
        messageDigest.update((this.f != null ? this.f.getId() : "").getBytes(C.UTF8_NAME));
        messageDigest.update((this.g != null ? this.g.a() : "").getBytes(C.UTF8_NAME));
        messageDigest.update((this.i != null ? this.i.a() : "").getBytes(C.UTF8_NAME));
    }
}
