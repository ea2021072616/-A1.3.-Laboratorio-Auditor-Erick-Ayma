package com.airbnb.lottie;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageLayer.java */
/* loaded from: classes.dex */
public class ap extends o {
    private final Paint e;
    private final Rect f;
    private final Rect g;
    private final float h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ax axVar, av avVar, float f) {
        super(axVar, avVar);
        this.e = new Paint(3);
        this.f = new Rect();
        this.g = new Rect();
        this.h = f;
    }

    @Override // com.airbnb.lottie.o
    public void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap f = f();
        if (f != null) {
            this.e.setAlpha(i);
            canvas.save();
            canvas.concat(matrix);
            this.f.set(0, 0, f.getWidth(), f.getHeight());
            this.g.set(0, 0, (int) (f.getWidth() * this.h), (int) (f.getHeight() * this.h));
            canvas.drawBitmap(f, this.f, this.g, this.e);
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.o, com.airbnb.lottie.aa
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap f = f();
        if (f != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, f.getWidth()), Math.min(rectF.bottom, f.getHeight()));
            this.f540a.mapRect(rectF);
        }
    }

    @Nullable
    private Bitmap f() {
        return this.f541b.b(this.f542c.e());
    }

    @Override // com.airbnb.lottie.o, com.airbnb.lottie.aa
    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
    }
}
