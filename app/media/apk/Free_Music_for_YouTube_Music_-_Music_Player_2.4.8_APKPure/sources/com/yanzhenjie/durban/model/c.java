package com.yanzhenjie.durban.model;

import android.graphics.RectF;
/* compiled from: ImageState.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private RectF f5168a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f5169b;

    /* renamed from: c  reason: collision with root package name */
    private float f5170c;
    private float d;

    public c(RectF rectF, RectF rectF2, float f, float f2) {
        this.f5168a = rectF;
        this.f5169b = rectF2;
        this.f5170c = f;
        this.d = f2;
    }

    public RectF a() {
        return this.f5168a;
    }

    public RectF b() {
        return this.f5169b;
    }

    public float c() {
        return this.f5170c;
    }

    public float d() {
        return this.d;
    }
}
