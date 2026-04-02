package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NullLayer.java */
/* loaded from: classes.dex */
public class be extends o {
    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ax axVar, av avVar) {
        super(axVar, avVar);
    }

    @Override // com.airbnb.lottie.o
    void b(Canvas canvas, Matrix matrix, int i) {
    }

    @Override // com.airbnb.lottie.o, com.airbnb.lottie.aa
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
