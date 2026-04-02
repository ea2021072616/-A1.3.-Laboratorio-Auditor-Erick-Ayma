package com.bumptech.glide.load.c;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: ImageVideoWrapperEncoder.java */
/* loaded from: classes.dex */
public class h implements com.bumptech.glide.load.b<g> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.b<InputStream> f881a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b<ParcelFileDescriptor> f882b;

    /* renamed from: c  reason: collision with root package name */
    private String f883c;

    public h(com.bumptech.glide.load.b<InputStream> bVar, com.bumptech.glide.load.b<ParcelFileDescriptor> bVar2) {
        this.f881a = bVar;
        this.f882b = bVar2;
    }

    @Override // com.bumptech.glide.load.b
    public boolean a(g gVar, OutputStream outputStream) {
        return gVar.a() != null ? this.f881a.a(gVar.a(), outputStream) : this.f882b.a(gVar.b(), outputStream);
    }

    @Override // com.bumptech.glide.load.b
    public String a() {
        if (this.f883c == null) {
            this.f883c = this.f881a.a() + this.f882b.a();
        }
        return this.f883c;
    }
}
