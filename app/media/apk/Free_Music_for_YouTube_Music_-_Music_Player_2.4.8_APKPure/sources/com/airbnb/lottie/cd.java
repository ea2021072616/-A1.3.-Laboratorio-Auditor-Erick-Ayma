package com.airbnb.lottie;

import android.support.annotation.FloatRange;
import java.util.Collections;
/* compiled from: StaticKeyframeAnimation.java */
/* loaded from: classes.dex */
class cd<T> extends au<T> {

    /* renamed from: b  reason: collision with root package name */
    private final T f508b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(T t) {
        super(Collections.emptyList());
        this.f508b = t;
    }

    @Override // com.airbnb.lottie.n
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
    }

    @Override // com.airbnb.lottie.au, com.airbnb.lottie.n
    public T b() {
        return this.f508b;
    }

    @Override // com.airbnb.lottie.n
    public T a(at<T> atVar, float f) {
        return this.f508b;
    }
}
