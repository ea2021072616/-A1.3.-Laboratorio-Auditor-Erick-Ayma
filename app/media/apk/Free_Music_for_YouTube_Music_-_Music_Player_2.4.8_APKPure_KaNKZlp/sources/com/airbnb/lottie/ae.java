package com.airbnb.lottie;

import java.util.List;
/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
class ae extends au<Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(List<at<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.n
    /* renamed from: b */
    public Float a(at<Float> atVar, float f) {
        if (atVar.f406a == null || atVar.f407b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return Float.valueOf(bd.a(atVar.f406a.floatValue(), atVar.f407b.floatValue(), f));
    }
}
