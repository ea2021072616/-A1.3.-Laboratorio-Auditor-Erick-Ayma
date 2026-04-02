package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.n;
import java.util.ArrayList;
import java.util.List;
/* compiled from: GradientFillContent.java */
/* loaded from: classes.dex */
class aj implements aa, n.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f390a;

    /* renamed from: b  reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f391b = new LongSparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f392c = new LongSparseArray<>();
    private final Matrix d = new Matrix();
    private final Path e = new Path();
    private final Paint f = new Paint(1);
    private final RectF g = new RectF();
    private final List<bg> h = new ArrayList();
    private final am i;
    private final au<ag> j;
    private final au<Integer> k;
    private final au<PointF> l;
    private final au<PointF> m;
    private final ax n;
    private final int o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ax axVar, o oVar, ai aiVar) {
        this.f390a = aiVar.a();
        this.n = axVar;
        this.i = aiVar.b();
        this.e.setFillType(aiVar.c());
        this.o = (int) (axVar.k().b() / 32);
        this.j = aiVar.d().b();
        this.j.a(this);
        oVar.a(this.j);
        this.k = aiVar.e().b();
        this.k.a(this);
        oVar.a(this.k);
        this.l = aiVar.f().b();
        this.l.a(this);
        oVar.a(this.l);
        this.m = aiVar.g().b();
        this.m.a(this);
        oVar.a(this.m);
    }

    @Override // com.airbnb.lottie.n.a
    public void a() {
        this.n.invalidateSelf();
    }

    @Override // com.airbnb.lottie.x
    public void a(List<x> list, List<x> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                x xVar = list2.get(i2);
                if (xVar instanceof bg) {
                    this.h.add((bg) xVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.aa
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader c2;
        this.e.reset();
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.e.addPath(this.h.get(i2).d(), matrix);
        }
        this.e.computeBounds(this.g, false);
        if (this.i == am.Linear) {
            c2 = b();
        } else {
            c2 = c();
        }
        this.d.set(matrix);
        c2.setLocalMatrix(this.d);
        this.f.setShader(c2);
        this.f.setAlpha((int) (((((Integer) this.k.b()).intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.e, this.f);
    }

    @Override // com.airbnb.lottie.aa
    public void a(RectF rectF, Matrix matrix) {
        this.e.reset();
        for (int i = 0; i < this.h.size(); i++) {
            this.e.addPath(this.h.get(i).d(), matrix);
        }
        this.e.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.aa
    public void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.x
    public String e() {
        return this.f390a;
    }

    private LinearGradient b() {
        int d = d();
        LinearGradient linearGradient = this.f391b.get(d);
        if (linearGradient == null) {
            PointF pointF = (PointF) this.l.b();
            PointF pointF2 = (PointF) this.m.b();
            ag agVar = (ag) this.j.b();
            LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, agVar.b(), agVar.a(), Shader.TileMode.CLAMP);
            this.f391b.put(d, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient c() {
        int d = d();
        RadialGradient radialGradient = this.f392c.get(d);
        if (radialGradient == null) {
            PointF pointF = (PointF) this.l.b();
            PointF pointF2 = (PointF) this.m.b();
            ag agVar = (ag) this.j.b();
            int[] b2 = agVar.b();
            float[] a2 = agVar.a();
            float f = pointF.x;
            float f2 = pointF.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(pointF2.x - f, pointF2.y - f2), b2, a2, Shader.TileMode.CLAMP);
            this.f392c.put(d, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int d() {
        int round = Math.round(this.l.c() * this.o);
        return round * 527 * 31 * Math.round(this.m.c() * this.o) * 31 * Math.round(this.j.c() * this.o);
    }
}
