package com.bumptech.glide.load.b.b;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.i.e<com.bumptech.glide.load.c, String> f817a = new com.bumptech.glide.i.e<>(1000);

    public String a(com.bumptech.glide.load.c cVar) {
        String b2;
        synchronized (this.f817a) {
            b2 = this.f817a.b((com.bumptech.glide.i.e<com.bumptech.glide.load.c, String>) cVar);
        }
        if (b2 == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                cVar.a(messageDigest);
                b2 = com.bumptech.glide.i.h.a(messageDigest.digest());
            } catch (UnsupportedEncodingException e) {
                ThrowableExtension.printStackTrace(e);
            } catch (NoSuchAlgorithmException e2) {
                ThrowableExtension.printStackTrace(e2);
            }
            synchronized (this.f817a) {
                this.f817a.b(cVar, b2);
            }
        }
        return b2;
    }
}
