package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.bz;
import com.airbnb.lottie.n;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class p implements aa, n.a {
    private final ax f;
    private final float[] h;
    private final n<?, Float> i;
    private final n<?, Integer> j;
    private final List<n<?, Float>> k;
    @Nullable
    private final n<?, Float> l;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f548b = new PathMeasure();

    /* renamed from: c  reason: collision with root package name */
    private final Path f549c = new Path();
    private final Path d = new Path();
    private final RectF e = new RectF();
    private final List<a> g = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    final Paint f547a = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ax axVar, o oVar, Paint.Cap cap, Paint.Join join, d dVar, b bVar, List<b> list, b bVar2) {
        this.f = axVar;
        this.f547a.setStyle(Paint.Style.STROKE);
        this.f547a.setStrokeCap(cap);
        this.f547a.setStrokeJoin(join);
        this.j = dVar.b();
        this.i = bVar.b();
        if (bVar2 == null) {
            this.l = null;
        } else {
            this.l = bVar2.b();
        }
        this.k = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.k.add(list.get(i).b());
        }
        oVar.a(this.j);
        oVar.a(this.i);
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            oVar.a(this.k.get(i2));
        }
        if (this.l != null) {
            oVar.a(this.l);
        }
        this.j.a(this);
        this.i.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.k.get(i3).a(this);
        }
        if (this.l != null) {
            this.l.a(this);
        }
    }

    public void a() {
        this.f.invalidateSelf();
    }

    @Override // com.airbnb.lottie.x
    public void a(List<x> list, List<x> list2) {
        a aVar;
        int size = list.size() - 1;
        cg cgVar = null;
        while (size >= 0) {
            x xVar = list.get(size);
            size--;
            cgVar = ((xVar instanceof cg) && ((cg) xVar).b() == bz.b.Individually) ? (cg) xVar : cgVar;
        }
        if (cgVar != null) {
            cgVar.a(this);
        }
        int size2 = list2.size() - 1;
        a aVar2 = null;
        while (size2 >= 0) {
            x xVar2 = list2.get(size2);
            if ((xVar2 instanceof cg) && ((cg) xVar2).b() == bz.b.Individually) {
                if (aVar2 != null) {
                    this.g.add(aVar2);
                }
                a aVar3 = new a((cg) xVar2);
                ((cg) xVar2).a(this);
                aVar = aVar3;
            } else if (xVar2 instanceof bg) {
                aVar = aVar2 == null ? new a(cgVar) : aVar2;
                aVar.f550a.add((bg) xVar2);
            } else {
                aVar = aVar2;
            }
            size2--;
            aVar2 = aVar;
        }
        if (aVar2 != null) {
            this.g.add(aVar2);
        }
    }

    @Override // com.airbnb.lottie.aa
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f547a.setAlpha((int) (((this.j.b().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.f547a.setStrokeWidth(this.i.b().floatValue() * ch.a(matrix));
        if (this.f547a.getStrokeWidth() > 0.0f) {
            a(matrix);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.g.size()) {
                    a aVar = this.g.get(i3);
                    if (aVar.f551b != null) {
                        a(canvas, aVar, matrix);
                    } else {
                        this.f549c.reset();
                        for (int size = aVar.f550a.size() - 1; size >= 0; size--) {
                            this.f549c.addPath(((bg) aVar.f550a.get(size)).d(), matrix);
                        }
                        canvas.drawPath(this.f549c, this.f547a);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(Canvas canvas, a aVar, Matrix matrix) {
        float f;
        if (aVar.f551b != null) {
            this.f549c.reset();
            for (int size = aVar.f550a.size() - 1; size >= 0; size--) {
                this.f549c.addPath(((bg) aVar.f550a.get(size)).d(), matrix);
            }
            this.f548b.setPath(this.f549c, false);
            float length = this.f548b.getLength();
            while (true) {
                f = length;
                if (!this.f548b.nextContour()) {
                    break;
                }
                length = this.f548b.getLength() + f;
            }
            float floatValue = (aVar.f551b.f().b().floatValue() * f) / 360.0f;
            float floatValue2 = ((aVar.f551b.c().b().floatValue() * f) / 100.0f) + floatValue;
            float floatValue3 = ((aVar.f551b.d().b().floatValue() * f) / 100.0f) + floatValue;
            int size2 = aVar.f550a.size() - 1;
            float f2 = 0.0f;
            while (size2 >= 0) {
                this.d.set(((bg) aVar.f550a.get(size2)).d());
                this.d.transform(matrix);
                this.f548b.setPath(this.d, false);
                float length2 = this.f548b.getLength();
                if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                    ch.a(this.d, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.d, this.f547a);
                } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                    if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                        canvas.drawPath(this.d, this.f547a);
                    } else {
                        ch.a(this.d, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                        canvas.drawPath(this.d, this.f547a);
                    }
                }
                size2--;
                f2 += length2;
            }
        }
    }

    @Override // com.airbnb.lottie.aa
    public void a(RectF rectF, Matrix matrix) {
        this.f549c.reset();
        for (int i = 0; i < this.g.size(); i++) {
            a aVar = this.g.get(i);
            for (int i2 = 0; i2 < aVar.f550a.size(); i2++) {
                this.f549c.addPath(((bg) aVar.f550a.get(i2)).d(), matrix);
            }
        }
        this.f549c.computeBounds(this.e, false);
        float floatValue = this.i.b().floatValue();
        this.e.set(this.e.left - (floatValue / 2.0f), this.e.top - (floatValue / 2.0f), this.e.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.e.bottom);
        rectF.set(this.e);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private void a(Matrix matrix) {
        if (!this.k.isEmpty()) {
            float a2 = ch.a(matrix);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.k.size()) {
                    break;
                }
                this.h[i2] = this.k.get(i2).b().floatValue();
                if (i2 % 2 == 0) {
                    if (this.h[i2] < 1.0f) {
                        this.h[i2] = 1.0f;
                    }
                } else if (this.h[i2] < 0.1f) {
                    this.h[i2] = 0.1f;
                }
                float[] fArr = this.h;
                fArr[i2] = fArr[i2] * a2;
                i = i2 + 1;
            }
            this.f547a.setPathEffect(new DashPathEffect(this.h, this.l == null ? 0.0f : this.l.b().floatValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseStrokeContent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<bg> f550a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final cg f551b;

        private a(@Nullable cg cgVar) {
            this.f550a = new ArrayList();
            this.f551b = cgVar;
        }
    }
}
