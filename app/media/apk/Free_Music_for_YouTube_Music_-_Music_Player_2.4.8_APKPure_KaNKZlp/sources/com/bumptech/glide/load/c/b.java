package com.bumptech.glide.load.c;

import android.net.Uri;
import java.io.File;
/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class b<T> implements l<File, T> {

    /* renamed from: a  reason: collision with root package name */
    private final l<Uri, T> f863a;

    public b(l<Uri, T> lVar) {
        this.f863a = lVar;
    }

    @Override // com.bumptech.glide.load.c.l
    public com.bumptech.glide.load.a.c<T> a(File file, int i, int i2) {
        return this.f863a.a(Uri.fromFile(file), i, i2);
    }
}
