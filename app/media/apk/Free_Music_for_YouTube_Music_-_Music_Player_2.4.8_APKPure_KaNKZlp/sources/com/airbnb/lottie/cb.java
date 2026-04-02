package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SolidLayer.java */
/* loaded from: classes.dex */
public class cb extends o {
    private final RectF e;
    private final Paint f;
    private final av g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ax axVar, av avVar) {
        super(axVar, avVar);
        this.e = new RectF();
        this.f = new Paint();
        this.g = avVar;
        this.f.setAlpha(0);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(avVar.n());
    }

    @Override // com.airbnb.lottie.o
    public void b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.g.n());
        if (alpha != 0) {
            int intValue = (int) (((this.d.a().b().intValue() * (alpha / 255.0f)) / 100.0f) * 255.0f);
            this.f.setAlpha(intValue);
            if (intValue > 0) {
                a(matrix);
                canvas.drawRect(this.e, this.f);
            }
        }
    }

    @Override // com.airbnb.lottie.o, com.airbnb.lottie.aa
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        a(this.f540a);
        rectF.set(this.e);
    }

    private void a(Matrix matrix) {
        this.e.set(0.0f, 0.0f, this.g.p(), this.g.o());
        matrix.mapRect(this.e);
    }

    @Override // com.airbnb.lottie.o, com.airbnb.lottie.aa
    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.f.setColorFilter(colorFilter);
    }
}
