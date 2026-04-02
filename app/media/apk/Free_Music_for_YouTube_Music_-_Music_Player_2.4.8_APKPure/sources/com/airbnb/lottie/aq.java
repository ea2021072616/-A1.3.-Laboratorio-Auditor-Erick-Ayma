package com.airbnb.lottie;

import java.util.List;
/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
class aq extends au<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(List<at<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.n
    /* renamed from: b */
    public Integer a(at<Integer> atVar, float f) {
        if (atVar.f406a == null || atVar.f407b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return Integer.valueOf(bd.a(atVar.f406a.intValue(), atVar.f407b.intValue(), f));
    }
}
