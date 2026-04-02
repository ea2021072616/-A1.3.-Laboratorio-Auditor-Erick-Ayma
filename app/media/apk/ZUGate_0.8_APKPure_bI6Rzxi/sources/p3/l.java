package p3;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.google.android.gms.internal.play_billing.i0;
import java.util.ArrayList;
import java.util.BitSet;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final t[] f4327a = new t[4];

    /* renamed from: b  reason: collision with root package name */
    public final Matrix[] f4328b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    public final Matrix[] f4329c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    public final PointF f4330d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    public final Path f4331e = new Path();

    /* renamed from: f  reason: collision with root package name */
    public final Path f4332f = new Path();

    /* renamed from: g  reason: collision with root package name */
    public final t f4333g = new t();

    /* renamed from: h  reason: collision with root package name */
    public final float[] f4334h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    public final float[] f4335i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    public final Path f4336j = new Path();

    /* renamed from: k  reason: collision with root package name */
    public final Path f4337k = new Path();

    /* renamed from: l  reason: collision with root package name */
    public final boolean f4338l = true;

    public l() {
        for (int i5 = 0; i5 < 4; i5++) {
            this.f4327a[i5] = new t();
            this.f4328b[i5] = new Matrix();
            this.f4329c[i5] = new Matrix();
        }
    }

    public final void a(j jVar, float f5, RectF rectF, n2.b bVar, Path path) {
        int i5;
        Matrix[] matrixArr;
        float[] fArr;
        Matrix[] matrixArr2;
        t[] tVarArr;
        Path path2;
        n2.b bVar2;
        char c5;
        l lVar = this;
        n2.b bVar3 = bVar;
        Path path3 = path;
        path.rewind();
        Path path4 = lVar.f4331e;
        path4.rewind();
        Path path5 = lVar.f4332f;
        path5.rewind();
        path5.addRect(rectF, Path.Direction.CW);
        int i6 = 0;
        while (true) {
            i5 = 4;
            matrixArr = lVar.f4329c;
            fArr = lVar.f4334h;
            matrixArr2 = lVar.f4328b;
            tVarArr = lVar.f4327a;
            if (i6 >= 4) {
                break;
            }
            c cVar = i6 != 1 ? i6 != 2 ? i6 != 3 ? jVar.f4319f : jVar.f4318e : jVar.f4321h : jVar.f4320g;
            i0 i0Var = i6 != 1 ? i6 != 2 ? i6 != 3 ? jVar.f4315b : jVar.f4314a : jVar.f4317d : jVar.f4316c;
            t tVar = tVarArr[i6];
            i0Var.getClass();
            i0Var.x(f5, cVar.a(rectF), tVar);
            int i7 = i6 + 1;
            float f6 = (i7 % 4) * 90;
            matrixArr2[i6].reset();
            PointF pointF = lVar.f4330d;
            if (i6 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i6 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i6 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i6].setTranslate(pointF.x, pointF.y);
            matrixArr2[i6].preRotate(f6);
            t tVar2 = tVarArr[i6];
            fArr[0] = tVar2.f4359c;
            fArr[1] = tVar2.f4360d;
            matrixArr2[i6].mapPoints(fArr);
            matrixArr[i6].reset();
            matrixArr[i6].setTranslate(fArr[0], fArr[1]);
            matrixArr[i6].preRotate(f6);
            i6 = i7;
        }
        char c6 = 1;
        char c7 = 0;
        int i8 = 0;
        while (i8 < i5) {
            t tVar3 = tVarArr[i8];
            fArr[c7] = tVar3.f4357a;
            fArr[c6] = tVar3.f4358b;
            matrixArr2[i8].mapPoints(fArr);
            if (i8 == 0) {
                path3.moveTo(fArr[c7], fArr[c6]);
            } else {
                path3.lineTo(fArr[c7], fArr[c6]);
            }
            tVarArr[i8].b(matrixArr2[i8], path3);
            if (bVar3 != null) {
                t tVar4 = tVarArr[i8];
                Matrix matrix = matrixArr2[i8];
                BitSet bitSet = ((g) bVar3.f4085g).f4297j;
                tVar4.getClass();
                bitSet.set(i8, false);
                s[] sVarArr = ((g) bVar3.f4085g).f4295h;
                tVar4.a(tVar4.f4362f);
                sVarArr[i8] = new m(new ArrayList(tVar4.f4364h), new Matrix(matrix));
            }
            int i9 = i8 + 1;
            int i10 = i9 % 4;
            t tVar5 = tVarArr[i8];
            fArr[0] = tVar5.f4359c;
            fArr[1] = tVar5.f4360d;
            matrixArr2[i8].mapPoints(fArr);
            t tVar6 = tVarArr[i10];
            float f7 = tVar6.f4357a;
            float[] fArr2 = lVar.f4335i;
            fArr2[0] = f7;
            fArr2[1] = tVar6.f4358b;
            matrixArr2[i10].mapPoints(fArr2);
            float max = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            t tVar7 = tVarArr[i8];
            fArr[0] = tVar7.f4359c;
            fArr[1] = tVar7.f4360d;
            matrixArr2[i8].mapPoints(fArr);
            if (i8 == 1 || i8 == 3) {
                Math.abs(rectF.centerX() - fArr[0]);
            } else {
                Math.abs(rectF.centerY() - fArr[1]);
            }
            t tVar8 = lVar.f4333g;
            tVar8.d(0.0f, 270.0f, 0.0f);
            (i8 != 1 ? i8 != 2 ? i8 != 3 ? jVar.f4323j : jVar.f4322i : jVar.f4325l : jVar.f4324k).getClass();
            tVar8.c(max, 0.0f);
            Path path6 = lVar.f4336j;
            path6.reset();
            tVar8.b(matrixArr[i8], path6);
            if (lVar.f4338l && (lVar.b(path6, i8) || lVar.b(path6, i10))) {
                path6.op(path6, path5, Path.Op.DIFFERENCE);
                fArr[0] = tVar8.f4357a;
                fArr[1] = tVar8.f4358b;
                matrixArr[i8].mapPoints(fArr);
                path4.moveTo(fArr[0], fArr[1]);
                tVar8.b(matrixArr[i8], path4);
                bVar2 = bVar;
                path2 = path;
            } else {
                path2 = path;
                tVar8.b(matrixArr[i8], path2);
                bVar2 = bVar;
            }
            if (bVar2 != null) {
                Matrix matrix2 = matrixArr[i8];
                c5 = 0;
                ((g) bVar2.f4085g).f4297j.set(i8 + 4, false);
                s[] sVarArr2 = ((g) bVar2.f4085g).f4296i;
                tVar8.a(tVar8.f4362f);
                sVarArr2[i8] = new m(new ArrayList(tVar8.f4364h), new Matrix(matrix2));
            } else {
                c5 = 0;
            }
            c7 = c5;
            path3 = path2;
            i8 = i9;
            c6 = 1;
            i5 = 4;
            lVar = this;
            bVar3 = bVar2;
        }
        Path path7 = path3;
        path.close();
        path4.close();
        if (path4.isEmpty()) {
            return;
        }
        path7.op(path4, Path.Op.UNION);
    }

    public final boolean b(Path path, int i5) {
        Path path2 = this.f4337k;
        path2.reset();
        this.f4327a[i5].b(this.f4328b[i5], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
