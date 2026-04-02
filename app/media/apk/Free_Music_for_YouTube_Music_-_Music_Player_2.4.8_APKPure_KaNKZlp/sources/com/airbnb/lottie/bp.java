package com.airbnb.lottie;

import java.util.List;
/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes.dex */
class bp extends au<bq> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(List<at<bq>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.n
    /* renamed from: b */
    public bq a(at<bq> atVar, float f) {
        if (atVar.f406a == null || atVar.f407b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        bq bqVar = atVar.f406a;
        bq bqVar2 = atVar.f407b;
        return new bq(bd.a(bqVar.a(), bqVar2.a(), f), bd.a(bqVar.b(), bqVar2.b(), f));
    }
}
