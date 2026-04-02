package t1;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f5012a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final RectF f5013b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    public float f5014c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f5015d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public final float f5016e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public final float f5017f = Float.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public float f5018g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f5019h = Float.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public float f5020i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f5021j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f5022k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f5023l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f5024m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    public final Matrix f5025n = new Matrix();
    public final float[] o = new float[9];

    public final boolean a(float f5) {
        return this.f5013b.left <= f5 + 1.0f;
    }

    public final boolean b(float f5) {
        return this.f5013b.right >= (((float) ((int) (f5 * 100.0f))) / 100.0f) - 1.0f;
    }

    public final boolean c(float f5) {
        RectF rectF = this.f5013b;
        if (rectF.top <= f5) {
            if (rectF.bottom >= ((float) ((int) (f5 * 100.0f))) / 100.0f) {
                return true;
            }
        }
        return false;
    }

    public final void d(Matrix matrix, RectF rectF) {
        float f5;
        float f6;
        float[] fArr = this.o;
        matrix.getValues(fArr);
        float f7 = fArr[2];
        float f8 = fArr[0];
        float f9 = fArr[5];
        float f10 = fArr[4];
        this.f5020i = Math.min(Math.max(this.f5018g, f8), this.f5019h);
        this.f5021j = Math.min(Math.max(this.f5016e, f10), this.f5017f);
        if (rectF != null) {
            f5 = rectF.width();
            f6 = rectF.height();
        } else {
            f5 = 0.0f;
            f6 = 0.0f;
        }
        this.f5022k = Math.min(Math.max(f7, ((this.f5020i - 1.0f) * (-f5)) - this.f5023l), this.f5023l);
        float max = Math.max(Math.min(f9, ((this.f5021j - 1.0f) * f6) + this.f5024m), -this.f5024m);
        fArr[2] = this.f5022k;
        fArr[0] = this.f5020i;
        fArr[5] = max;
        fArr[4] = this.f5021j;
        matrix.setValues(fArr);
    }

    public final void e(Matrix matrix, View view, boolean z4) {
        Matrix matrix2 = this.f5012a;
        matrix2.set(matrix);
        d(matrix2, this.f5013b);
        if (z4) {
            view.invalidate();
        }
        matrix.set(matrix2);
    }
}
