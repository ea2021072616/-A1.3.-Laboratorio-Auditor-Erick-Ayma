package com.bumptech.glide.load.resource;

import java.io.OutputStream;
/* compiled from: NullEncoder.java */
/* loaded from: classes.dex */
public class a<T> implements com.bumptech.glide.load.b<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final a<?> f902a = new a<>();

    public static <T> com.bumptech.glide.load.b<T> b() {
        return f902a;
    }

    @Override // com.bumptech.glide.load.b
    public boolean a(T t, OutputStream outputStream) {
        return false;
    }

    @Override // com.bumptech.glide.load.b
    public String a() {
        return "";
    }
}
