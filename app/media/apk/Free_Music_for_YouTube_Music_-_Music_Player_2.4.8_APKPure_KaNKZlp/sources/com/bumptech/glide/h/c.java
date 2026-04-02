package com.bumptech.glide.h;

import com.google.android.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
/* compiled from: StringSignature.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f715a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("Signature cannot be null!");
        }
        this.f715a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f715a.equals(((c) obj).f715a);
    }

    public int hashCode() {
        return this.f715a.hashCode();
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f715a.getBytes(C.UTF8_NAME));
    }

    public String toString() {
        return "StringSignature{signature='" + this.f715a + "'}";
    }
}
