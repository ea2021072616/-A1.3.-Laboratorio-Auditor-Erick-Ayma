package com.airbnb.lottie;

import android.graphics.PointF;
/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
class i implements k<PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final b f525a;

    /* renamed from: b  reason: collision with root package name */
    private final b f526b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, b bVar2) {
        this.f525a = bVar;
        this.f526b = bVar2;
    }

    @Override // com.airbnb.lottie.k
    /* renamed from: a */
    public au<PointF> b() {
        return new cc(this.f525a.b(), this.f526b.b());
    }
}
