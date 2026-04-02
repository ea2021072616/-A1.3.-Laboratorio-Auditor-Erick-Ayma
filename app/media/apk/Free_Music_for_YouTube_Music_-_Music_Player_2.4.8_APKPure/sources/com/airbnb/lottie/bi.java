package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
class bi extends au<PointF> {

    /* renamed from: b  reason: collision with root package name */
    private final PointF f448b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f449c;
    private bh d;
    private PathMeasure e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(List<? extends at<PointF>> list) {
        super(list);
        this.f448b = new PointF();
        this.f449c = new float[2];
    }

    @Override // com.airbnb.lottie.n
    /* renamed from: b */
    public PointF a(at<PointF> atVar, float f) {
        bh bhVar = (bh) atVar;
        Path e = bhVar.e();
        if (e == null) {
            return atVar.f406a;
        }
        if (this.d != bhVar) {
            this.e = new PathMeasure(e, false);
            this.d = bhVar;
        }
        this.e.getPosTan(this.e.getLength() * f, this.f449c, null);
        this.f448b.set(this.f449c[0], this.f449c[1]);
        return this.f448b;
    }
}
