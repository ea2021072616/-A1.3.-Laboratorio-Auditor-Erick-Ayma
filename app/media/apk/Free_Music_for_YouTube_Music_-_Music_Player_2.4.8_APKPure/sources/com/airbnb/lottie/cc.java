package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.Collections;
/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
class cc extends au<PointF> {

    /* renamed from: b  reason: collision with root package name */
    private final PointF f506b;

    /* renamed from: c  reason: collision with root package name */
    private final au<Float> f507c;
    private final au<Float> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(au<Float> auVar, au<Float> auVar2) {
        super(Collections.emptyList());
        this.f506b = new PointF();
        this.f507c = auVar;
        this.d = auVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.n
    public void a(float f) {
        this.f507c.a(f);
        this.d.a(f);
        this.f506b.set(((Float) this.f507c.b()).floatValue(), ((Float) this.d.b()).floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f537a.size()) {
                this.f537a.get(i2).a();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.au, com.airbnb.lottie.n
    /* renamed from: d */
    public PointF b() {
        return a(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.n
    /* renamed from: b */
    public PointF a(at<PointF> atVar, float f) {
        return this.f506b;
    }
}
