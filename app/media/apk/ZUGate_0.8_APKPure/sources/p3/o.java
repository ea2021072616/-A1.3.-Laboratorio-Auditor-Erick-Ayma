package p3;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
/* loaded from: classes.dex */
public final class o extends s {

    /* renamed from: c  reason: collision with root package name */
    public final q f4342c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4343d;

    /* renamed from: e  reason: collision with root package name */
    public final float f4344e;

    public o(q qVar, float f5, float f6) {
        this.f4342c = qVar;
        this.f4343d = f5;
        this.f4344e = f6;
    }

    @Override // p3.s
    public final void a(Matrix matrix, o3.a aVar, int i5, Canvas canvas) {
        q qVar = this.f4342c;
        float f5 = qVar.f4353c;
        float f6 = this.f4344e;
        float f7 = qVar.f4352b;
        float f8 = this.f4343d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f5 - f6, f7 - f8), 0.0f);
        Matrix matrix2 = this.f4356a;
        matrix2.set(matrix);
        matrix2.preTranslate(f8, f6);
        matrix2.preRotate(b());
        aVar.getClass();
        rectF.bottom += i5;
        rectF.offset(0.0f, -i5);
        int[] iArr = o3.a.f4104i;
        iArr[0] = aVar.f4113f;
        iArr[1] = aVar.f4112e;
        iArr[2] = aVar.f4111d;
        Paint paint = aVar.f4110c;
        float f9 = rectF.left;
        paint.setShader(new LinearGradient(f9, rectF.top, f9, rectF.bottom, iArr, o3.a.f4105j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        q qVar = this.f4342c;
        return (float) Math.toDegrees(Math.atan((qVar.f4353c - this.f4344e) / (qVar.f4352b - this.f4343d)));
    }
}
