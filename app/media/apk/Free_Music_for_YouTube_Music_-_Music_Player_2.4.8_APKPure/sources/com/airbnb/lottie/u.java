package com.airbnb.lottie;

import java.util.List;
/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
class u extends au<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(List<at<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.n
    /* renamed from: b */
    public Integer a(at<Integer> atVar, float f) {
        if (atVar.f406a == null || atVar.f407b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return Integer.valueOf(af.a(f, atVar.f406a.intValue(), atVar.f407b.intValue()));
    }
}
