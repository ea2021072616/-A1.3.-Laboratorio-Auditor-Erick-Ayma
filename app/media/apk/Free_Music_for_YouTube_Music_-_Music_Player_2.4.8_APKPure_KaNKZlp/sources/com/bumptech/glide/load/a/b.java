package com.bumptech.glide.load.a;

import com.bumptech.glide.k;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* compiled from: ByteArrayFetcher.java */
/* loaded from: classes.dex */
public class b implements c<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f762a;

    /* renamed from: b  reason: collision with root package name */
    private final String f763b;

    public b(byte[] bArr, String str) {
        this.f762a = bArr;
        this.f763b = str;
    }

    @Override // com.bumptech.glide.load.a.c
    /* renamed from: b */
    public InputStream a(k kVar) {
        return new ByteArrayInputStream(this.f762a);
    }

    @Override // com.bumptech.glide.load.a.c
    public void a() {
    }

    @Override // com.bumptech.glide.load.a.c
    public String b() {
        return this.f763b;
    }

    @Override // com.bumptech.glide.load.a.c
    public void c() {
    }
}
