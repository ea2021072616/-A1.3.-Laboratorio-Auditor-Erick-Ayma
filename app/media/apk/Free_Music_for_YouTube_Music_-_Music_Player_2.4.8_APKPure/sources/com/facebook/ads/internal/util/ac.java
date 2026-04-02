package com.facebook.ads.internal.util;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    static final int f1493a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b  reason: collision with root package name */
    static final ExecutorService f1494b = Executors.newFixedThreadPool(f1493a);

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f1495c = true;
    private final Bitmap d;
    private Bitmap e;
    private final j f = new u();

    public ac(Bitmap bitmap) {
        this.d = bitmap;
    }

    public Bitmap a() {
        return this.e;
    }

    public Bitmap a(int i) {
        this.e = this.f.a(this.d, i);
        return this.e;
    }
}
