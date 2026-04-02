package com.bumptech.glide.load.c;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
/* compiled from: ImageVideoWrapper.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f879a;

    /* renamed from: b  reason: collision with root package name */
    private final ParcelFileDescriptor f880b;

    public g(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.f879a = inputStream;
        this.f880b = parcelFileDescriptor;
    }

    public InputStream a() {
        return this.f879a;
    }

    public ParcelFileDescriptor b() {
        return this.f880b;
    }
}
