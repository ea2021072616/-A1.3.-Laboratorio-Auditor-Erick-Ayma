package p3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
/* loaded from: classes.dex */
public final class n extends s {

    /* renamed from: c  reason: collision with root package name */
    public final p f4341c;

    public n(p pVar) {
        this.f4341c = pVar;
    }

    @Override // p3.s
    public final void a(Matrix matrix, o3.a aVar, int i5, Canvas canvas) {
        p pVar = this.f4341c;
        float f5 = pVar.f4350f;
        float f6 = pVar.f4351g;
        RectF rectF = new RectF(pVar.f4346b, pVar.f4347c, pVar.f4348d, pVar.f4349e);
        aVar.getClass();
        boolean z4 = f6 < 0.0f;
        Path path = aVar.f4114g;
        int[] iArr = o3.a.f4106k;
        if (z4) {
            iArr[0] = 0;
            iArr[1] = aVar.f4113f;
            iArr[2] = aVar.f4112e;
            iArr[3] = aVar.f4111d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f5, f6);
            path.close();
            float f7 = -i5;
            rectF.inset(f7, f7);
            iArr[0] = 0;
            iArr[1] = aVar.f4111d;
            iArr[2] = aVar.f4112e;
            iArr[3] = aVar.f4113f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f8 = 1.0f - (i5 / width);
        float[] fArr = o3.a.f4107l;
        fArr[1] = f8;
        fArr[2] = ((1.0f - f8) / 2.0f) + f8;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), width, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = aVar.f4109b;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z4) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, aVar.f4115h);
        }
        canvas.drawArc(rectF, f5, f6, true, paint);
        canvas.restore();
    }
}
