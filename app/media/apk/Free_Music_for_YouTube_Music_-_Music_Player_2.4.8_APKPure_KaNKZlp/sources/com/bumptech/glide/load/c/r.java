package com.bumptech.glide.load.c;

import java.net.URL;
/* compiled from: UrlLoader.java */
/* loaded from: classes.dex */
public class r<T> implements l<URL, T> {

    /* renamed from: a  reason: collision with root package name */
    private final l<d, T> f899a;

    public r(l<d, T> lVar) {
        this.f899a = lVar;
    }

    @Override // com.bumptech.glide.load.c.l
    public com.bumptech.glide.load.a.c<T> a(URL url, int i, int i2) {
        return this.f899a.a(new d(url), i, i2);
    }
}
