package com.airbnb.lottie;

import android.graphics.Path;
import java.util.List;
/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes.dex */
class bv extends n<bs, Path> {

    /* renamed from: b  reason: collision with root package name */
    private final bs f483b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f484c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(List<at<bs>> list) {
        super(list);
        this.f483b = new bs();
        this.f484c = new Path();
    }

    @Override // com.airbnb.lottie.n
    /* renamed from: b */
    public Path a(at<bs> atVar, float f) {
        this.f483b.a(atVar.f406a, atVar.f407b, f);
        bd.a(this.f483b, this.f484c);
        return this.f484c;
    }
}
