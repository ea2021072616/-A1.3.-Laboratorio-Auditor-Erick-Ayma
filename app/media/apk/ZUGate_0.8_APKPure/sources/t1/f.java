package t1;

import android.graphics.Matrix;
import android.graphics.RectF;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: c  reason: collision with root package name */
    public final h f5000c;

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f4998a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final Matrix f4999b = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    public final Matrix f5001d = new Matrix();

    /* renamed from: e  reason: collision with root package name */
    public final float[] f5002e = new float[2];

    public f(h hVar) {
        new Matrix();
        new Matrix();
        this.f5000c = hVar;
    }

    public final void a(float f5, float f6, b bVar) {
        float[] fArr = this.f5002e;
        fArr[0] = f5;
        fArr[1] = f6;
        b(fArr);
        bVar.f4985b = fArr[0];
        bVar.f4986c = fArr[1];
    }

    public final void b(float[] fArr) {
        Matrix matrix = this.f5001d;
        matrix.reset();
        this.f4999b.invert(matrix);
        matrix.mapPoints(fArr);
        this.f5000c.f5012a.invert(matrix);
        matrix.mapPoints(fArr);
        this.f4998a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public final void c(float[] fArr) {
        this.f4998a.mapPoints(fArr);
        this.f5000c.f5012a.mapPoints(fArr);
        this.f4999b.mapPoints(fArr);
    }

    public final void d() {
        Matrix matrix = this.f4999b;
        matrix.reset();
        h hVar = this.f5000c;
        RectF rectF = hVar.f5013b;
        float f5 = rectF.left;
        float f6 = hVar.f5015d;
        matrix.postTranslate(f5, f6 - (f6 - rectF.bottom));
    }

    public final void e(float f5, float f6, float f7, float f8) {
        h hVar = this.f5000c;
        float width = hVar.f5013b.width() / f6;
        float height = hVar.f5013b.height() / f7;
        if (Float.isInfinite(width)) {
            width = 0.0f;
        }
        if (Float.isInfinite(height)) {
            height = 0.0f;
        }
        Matrix matrix = this.f4998a;
        matrix.reset();
        matrix.postTranslate(-f5, -f8);
        matrix.postScale(width, -height);
    }
}
