package f1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: p  reason: collision with root package name */
    public static final Matrix f2781p = new Matrix();

    /* renamed from: a  reason: collision with root package name */
    public final Path f2782a;

    /* renamed from: b  reason: collision with root package name */
    public final Path f2783b;

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f2784c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f2785d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f2786e;

    /* renamed from: f  reason: collision with root package name */
    public PathMeasure f2787f;

    /* renamed from: g  reason: collision with root package name */
    public final h f2788g;

    /* renamed from: h  reason: collision with root package name */
    public float f2789h;

    /* renamed from: i  reason: collision with root package name */
    public float f2790i;

    /* renamed from: j  reason: collision with root package name */
    public float f2791j;

    /* renamed from: k  reason: collision with root package name */
    public float f2792k;

    /* renamed from: l  reason: collision with root package name */
    public int f2793l;

    /* renamed from: m  reason: collision with root package name */
    public String f2794m;

    /* renamed from: n  reason: collision with root package name */
    public Boolean f2795n;
    public final l.b o;

    public k() {
        this.f2784c = new Matrix();
        this.f2789h = 0.0f;
        this.f2790i = 0.0f;
        this.f2791j = 0.0f;
        this.f2792k = 0.0f;
        this.f2793l = 255;
        this.f2794m = null;
        this.f2795n = null;
        this.o = new l.b();
        this.f2788g = new h();
        this.f2782a = new Path();
        this.f2783b = new Path();
    }

    public final void a(h hVar, Matrix matrix, Canvas canvas, int i5, int i6) {
        int i7;
        float f5;
        boolean z4;
        hVar.f2765a.set(matrix);
        Matrix matrix2 = hVar.f2765a;
        matrix2.preConcat(hVar.f2774j);
        canvas.save();
        char c5 = 0;
        int i8 = 0;
        while (true) {
            ArrayList arrayList = hVar.f2766b;
            if (i8 >= arrayList.size()) {
                canvas.restore();
                return;
            }
            i iVar = (i) arrayList.get(i8);
            if (iVar instanceof h) {
                a((h) iVar, matrix2, canvas, i5, i6);
            } else if (iVar instanceof j) {
                j jVar = (j) iVar;
                float f6 = i5 / this.f2791j;
                float f7 = i6 / this.f2792k;
                float min = Math.min(f6, f7);
                Matrix matrix3 = this.f2784c;
                matrix3.set(matrix2);
                matrix3.postScale(f6, f7);
                float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                matrix2.mapVectors(fArr);
                i7 = i8;
                float hypot = (float) Math.hypot(fArr[2], fArr[3]);
                float f8 = (fArr[0] * fArr[3]) - (fArr[1] * fArr[2]);
                float max = Math.max((float) Math.hypot(fArr[c5], fArr[1]), hypot);
                float abs = max > 0.0f ? Math.abs(f8) / max : 0.0f;
                if (abs != 0.0f) {
                    Path path = this.f2782a;
                    jVar.getClass();
                    path.reset();
                    z.f[] fVarArr = jVar.f2777a;
                    if (fVarArr != null) {
                        z.f.b(fVarArr, path);
                    }
                    Path path2 = this.f2783b;
                    path2.reset();
                    if (jVar instanceof f) {
                        path2.setFillType(jVar.f2779c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                        path2.addPath(path, matrix3);
                        canvas.clipPath(path2);
                    } else {
                        g gVar = (g) jVar;
                        float f9 = gVar.f2760j;
                        if (f9 != 0.0f || gVar.f2761k != 1.0f) {
                            float f10 = gVar.f2762l;
                            float f11 = (f9 + f10) % 1.0f;
                            float f12 = (gVar.f2761k + f10) % 1.0f;
                            if (this.f2787f == null) {
                                this.f2787f = new PathMeasure();
                            }
                            this.f2787f.setPath(path, false);
                            float length = this.f2787f.getLength();
                            float f13 = f11 * length;
                            float f14 = f12 * length;
                            path.reset();
                            if (f13 > f14) {
                                this.f2787f.getSegment(f13, length, path, true);
                                f5 = 0.0f;
                                this.f2787f.getSegment(0.0f, f14, path, true);
                            } else {
                                f5 = 0.0f;
                                this.f2787f.getSegment(f13, f14, path, true);
                            }
                            path.rLineTo(f5, f5);
                        }
                        path2.addPath(path, matrix3);
                        y.c cVar = gVar.f2757g;
                        if ((((Shader) cVar.f5544b) != null) || cVar.f5543a != 0) {
                            if (this.f2786e == null) {
                                Paint paint = new Paint(1);
                                this.f2786e = paint;
                                paint.setStyle(Paint.Style.FILL);
                            }
                            Paint paint2 = this.f2786e;
                            Object obj = cVar.f5544b;
                            if (((Shader) obj) != null) {
                                Shader shader = (Shader) obj;
                                shader.setLocalMatrix(matrix3);
                                paint2.setShader(shader);
                                paint2.setAlpha(Math.round(gVar.f2759i * 255.0f));
                            } else {
                                paint2.setShader(null);
                                paint2.setAlpha(255);
                                int i9 = cVar.f5543a;
                                float f15 = gVar.f2759i;
                                PorterDuff.Mode mode = n.f2809p;
                                paint2.setColor((i9 & 16777215) | (((int) (Color.alpha(i9) * f15)) << 24));
                            }
                            paint2.setColorFilter(null);
                            path2.setFillType(gVar.f2779c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            canvas.drawPath(path2, paint2);
                        }
                        y.c cVar2 = gVar.f2755e;
                        if ((((Shader) cVar2.f5544b) != null) || cVar2.f5543a != 0) {
                            if (this.f2785d == null) {
                                z4 = true;
                                Paint paint3 = new Paint(1);
                                this.f2785d = paint3;
                                paint3.setStyle(Paint.Style.STROKE);
                            } else {
                                z4 = true;
                            }
                            Paint paint4 = this.f2785d;
                            Paint.Join join = gVar.f2764n;
                            if (join != null) {
                                paint4.setStrokeJoin(join);
                            }
                            Paint.Cap cap = gVar.f2763m;
                            if (cap != null) {
                                paint4.setStrokeCap(cap);
                            }
                            paint4.setStrokeMiter(gVar.o);
                            Object obj2 = cVar2.f5544b;
                            if (((Shader) obj2) == null) {
                                z4 = false;
                            }
                            if (z4) {
                                Shader shader2 = (Shader) obj2;
                                shader2.setLocalMatrix(matrix3);
                                paint4.setShader(shader2);
                                paint4.setAlpha(Math.round(gVar.f2758h * 255.0f));
                            } else {
                                paint4.setShader(null);
                                paint4.setAlpha(255);
                                int i10 = cVar2.f5543a;
                                float f16 = gVar.f2758h;
                                PorterDuff.Mode mode2 = n.f2809p;
                                paint4.setColor((i10 & 16777215) | (((int) (Color.alpha(i10) * f16)) << 24));
                            }
                            paint4.setColorFilter(null);
                            paint4.setStrokeWidth(gVar.f2756f * abs * min);
                            canvas.drawPath(path2, paint4);
                        }
                    }
                }
                i8 = i7 + 1;
                c5 = 0;
            }
            i7 = i8;
            i8 = i7 + 1;
            c5 = 0;
        }
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f2793l;
    }

    public void setAlpha(float f5) {
        setRootAlpha((int) (f5 * 255.0f));
    }

    public void setRootAlpha(int i5) {
        this.f2793l = i5;
    }

    public k(k kVar) {
        this.f2784c = new Matrix();
        this.f2789h = 0.0f;
        this.f2790i = 0.0f;
        this.f2791j = 0.0f;
        this.f2792k = 0.0f;
        this.f2793l = 255;
        this.f2794m = null;
        this.f2795n = null;
        l.b bVar = new l.b();
        this.o = bVar;
        this.f2788g = new h(kVar.f2788g, bVar);
        this.f2782a = new Path(kVar.f2782a);
        this.f2783b = new Path(kVar.f2783b);
        this.f2789h = kVar.f2789h;
        this.f2790i = kVar.f2790i;
        this.f2791j = kVar.f2791j;
        this.f2792k = kVar.f2792k;
        this.f2793l = kVar.f2793l;
        this.f2794m = kVar.f2794m;
        String str = kVar.f2794m;
        if (str != null) {
            bVar.put(str, this);
        }
        this.f2795n = kVar.f2795n;
    }
}
