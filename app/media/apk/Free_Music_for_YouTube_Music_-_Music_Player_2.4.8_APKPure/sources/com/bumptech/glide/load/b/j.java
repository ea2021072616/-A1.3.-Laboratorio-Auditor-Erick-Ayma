package com.bumptech.glide.load.b;

import com.google.android.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
/* compiled from: OriginalKey.java */
/* loaded from: classes.dex */
class j implements com.bumptech.glide.load.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f858a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.c f859b;

    public j(String str, com.bumptech.glide.load.c cVar) {
        this.f858a = str;
        this.f859b = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f858a.equals(jVar.f858a) && this.f859b.equals(jVar.f859b);
    }

    public int hashCode() {
        return (this.f858a.hashCode() * 31) + this.f859b.hashCode();
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f858a.getBytes(C.UTF8_NAME));
        this.f859b.a(messageDigest);
    }
}
