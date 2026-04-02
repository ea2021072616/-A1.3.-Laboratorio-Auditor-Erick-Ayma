package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.f;
import java.io.OutputStream;
/* compiled from: NullResourceEncoder.java */
/* loaded from: classes.dex */
public class b<T> implements f<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final b<?> f904a = new b<>();

    @Override // com.bumptech.glide.load.b
    public /* bridge */ /* synthetic */ boolean a(Object obj, OutputStream outputStream) {
        return a((k) ((k) obj), outputStream);
    }

    public static <T> b<T> b() {
        return (b<T>) f904a;
    }

    public boolean a(k<T> kVar, OutputStream outputStream) {
        return false;
    }

    @Override // com.bumptech.glide.load.b
    public String a() {
        return "";
    }
}
