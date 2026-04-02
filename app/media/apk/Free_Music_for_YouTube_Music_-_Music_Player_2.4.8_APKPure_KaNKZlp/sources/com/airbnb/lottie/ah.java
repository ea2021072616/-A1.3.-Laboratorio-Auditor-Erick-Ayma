package com.airbnb.lottie;

import java.util.List;
/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
class ah extends au<ag> {

    /* renamed from: b  reason: collision with root package name */
    private final ag f386b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(List<? extends at<ag>> list) {
        super(list);
        ag agVar = list.get(0).f406a;
        int c2 = agVar == null ? 0 : agVar.c();
        this.f386b = new ag(new float[c2], new int[c2]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.n
    /* renamed from: b */
    public ag a(at<ag> atVar, float f) {
        this.f386b.a(atVar.f406a, atVar.f407b, f);
        return this.f386b;
    }
}
