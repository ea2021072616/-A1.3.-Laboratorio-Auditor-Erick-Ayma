package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Collections;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeLayer.java */
/* loaded from: classes.dex */
public class bw extends o {
    private final y e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(ax axVar, av avVar) {
        super(axVar, avVar);
        this.e = new y(axVar, this, new bu(avVar.d(), avVar.l()));
        this.e.a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.o
    void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.e.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.o, com.airbnb.lottie.aa
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.e.a(rectF, this.f540a);
    }

    @Override // com.airbnb.lottie.o, com.airbnb.lottie.aa
    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.e.a(str, str2, colorFilter);
    }
}
