package com.bumptech.glide.load.c.b;

import android.content.Context;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import java.io.InputStream;
/* compiled from: StreamByteArrayLoader.java */
/* loaded from: classes.dex */
public class b implements d<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final String f866a;

    public b() {
        this("");
    }

    @Deprecated
    public b(String str) {
        this.f866a = str;
    }

    @Override // com.bumptech.glide.load.c.l
    public com.bumptech.glide.load.a.c<InputStream> a(byte[] bArr, int i, int i2) {
        return new com.bumptech.glide.load.a.b(bArr, this.f866a);
    }

    /* compiled from: StreamByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<byte[], InputStream> {
        @Override // com.bumptech.glide.load.c.m
        public l<byte[], InputStream> a(Context context, com.bumptech.glide.load.c.c cVar) {
            return new b();
        }

        @Override // com.bumptech.glide.load.c.m
        public void a() {
        }
    }
}
