package com.airbnb.lottie;

import android.graphics.PointF;
/* compiled from: CubicCurveData.java */
/* loaded from: classes.dex */
class z {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f560a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f561b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f562c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z() {
        this.f560a = new PointF();
        this.f561b = new PointF();
        this.f562c = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f560a = pointF;
        this.f561b = pointF2;
        this.f562c = pointF3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, float f2) {
        this.f560a.set(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointF a() {
        return this.f560a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f, float f2) {
        this.f561b.set(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointF b() {
        return this.f561b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f, float f2) {
        this.f562c.set(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointF c() {
        return this.f562c;
    }
}
