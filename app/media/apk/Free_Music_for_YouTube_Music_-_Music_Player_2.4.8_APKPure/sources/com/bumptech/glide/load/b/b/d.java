package com.bumptech.glide.load.b.b;

import com.bumptech.glide.load.b.b.a;
import java.io.File;
/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0026a {

    /* renamed from: a  reason: collision with root package name */
    private final int f805a;

    /* renamed from: b  reason: collision with root package name */
    private final a f806b;

    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: classes.dex */
    public interface a {
        File a();
    }

    public d(a aVar, int i) {
        this.f805a = i;
        this.f806b = aVar;
    }

    @Override // com.bumptech.glide.load.b.b.a.InterfaceC0026a
    public com.bumptech.glide.load.b.b.a a() {
        File a2 = this.f806b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f805a);
        }
        return null;
    }
}
