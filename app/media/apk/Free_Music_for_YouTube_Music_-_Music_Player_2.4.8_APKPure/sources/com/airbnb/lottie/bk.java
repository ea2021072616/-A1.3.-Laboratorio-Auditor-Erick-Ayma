package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.List;
/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
class bk extends au<PointF> {

    /* renamed from: b  reason: collision with root package name */
    private final PointF f451b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(List<at<PointF>> list) {
        super(list);
        this.f451b = new PointF();
    }

    @Override // com.airbnb.lottie.n
    /* renamed from: b */
    public PointF a(at<PointF> atVar, float f) {
        if (atVar.f406a == null || atVar.f407b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = atVar.f406a;
        PointF pointF2 = atVar.f407b;
        this.f451b.set(pointF.x + ((pointF2.x - pointF.x) * f), ((pointF2.y - pointF.y) * f) + pointF.y);
        return this.f451b;
    }
}
